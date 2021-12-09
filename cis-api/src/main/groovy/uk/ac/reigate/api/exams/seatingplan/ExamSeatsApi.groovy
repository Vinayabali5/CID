package uk.ac.reigate.api.exams.seatingplan

import javax.persistence.EntityManager
import javax.validation.Valid

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.exams.StudentOptionEntry
import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.domain.exams.seatingplan.ExamSeat
import uk.ac.reigate.domain.exams.seatingplan.ExamSeatingPlan
import uk.ac.reigate.domain.learning_support.StudentCourseConcession
import uk.ac.reigate.dto.exams.StudentOptionEntryDto
import uk.ac.reigate.dto.exams.seatingplan.ExamSeatsDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.exams.StudentOptionEntryService
import uk.ac.reigate.services.exams.basedata.ExamComponentService
import uk.ac.reigate.services.exams.seatingplan.ExamSeatService
import uk.ac.reigate.services.exams.seatingplan.ExamSeatingPlanService
import uk.ac.reigate.services.learningsupport.StudentCourseConcessionService
import uk.ac.reigate.services.student.StudentConcessionTypeService
import uk.ac.reigate.services.student.StudentService
import uk.ac.reigate.services.student.StudentYearService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the seatingPlan API")
public class ExamSeatsApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ExamSeatsApi.class);
    
    @Autowired
    EntityManager entityManager
    
    @Autowired
    private final ExamSeatService examSeatService;
    
    @Autowired
    private final AcademicYearService academicYearService
    
    @Autowired
    private final StudentService studentService;
    
    @Autowired
    private final StudentYearService studentYearService
    
    @Autowired
    private StudentConcessionTypeService studentConcessionTypeService
    
    @Autowired
    private StudentCourseConcessionService studentCourseConcessionService
    
    @Autowired
    private StudentOptionEntryService studentOptionEntryService
    
    @Autowired
    private final ExamComponentService examComponentService;
    
    @Autowired
    private final ExamSeatingPlanService examSeatingPlanService;
    
    /**
     * Default No Args constructor
     */
    ExamSeatsApi() {}
    
    /**
     * The seatingPlansGet method is used to retrieve a full list of all the SeatingPlanDto objects
     *
     * @return A ResponseEntity with the corresponding list of StudentOptionEntryDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of ExamSeat entities",
    notes = "A GET request to the ExamSeat endpoint returns an array of all the seatingPlans in the system.",
    response = ExamSeatsDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of seatingPlans")
    ])
    @RequestMapping(value = "/seating-plans/", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<ExamSeatsDto>> seatingPlansGet() throws NotFoundException {
        LOGGER.info("** ExamSeatsApi - seatingPlansGet");
        List<ExamSeat> seatingPlans = examSeatService.findAll();
        return new ResponseEntity<List<ExamSeatsDto>>(ExamSeatsDto.mapFromList(seatingPlans), HttpStatus.OK);
    }
    
    
    /**
     * The seatingPlanGetByExamComponentId method is used to retrieve a list of seatingPlans for a specified examComponentId
     * 
     * @param examComponentId
     * @return
     * @throws NotFoundException
     */
    @ApiOperation(value = "Collection of ExamSeat entities",
    notes = "A GET request to the ExamSeat endpoint returns an array of all the seatingPlans in the system.",
    response = ExamSeatsDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of seatingPlans")
    ])
    @RequestMapping(value = "/seating-plans/byComponentId/{examComponentId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<ExamSeatsDto>> seatingPlansGetByExamComponentId(
            @ApiParam(value="The unique ID of the examComponentId", required = true)
            @PathVariable("examComponentId") Integer examComponentId
    ) throws NotFoundException {
        LOGGER.info("** ExamSeatsApi - seatingPlanGetByExamComponentId");
        AcademicYear currentAcademicYear
        ExamComponent examComponent = examComponentService.findById(examComponentId);
        AcademicYear year = examComponent.examSeries.academicYear
        List<ExamSeatsDto> seatingPlanDtoToReturn = new ArrayList<ExamSeatsDto>();
        List<StudentOptionEntry> students = studentOptionEntryService.getByComponentIdAndLive(examComponentId)
        for (StudentOptionEntry soe : students) {
            ExamSeat examSeat = examSeatService.findExamSeat(soe.student, examComponent)
            StudentYear studentYear = studentYearService.findByStudentAndYear(soe.student, year);
            List<StudentCourseConcession> concessions = studentCourseConcessionService.getByStudent(soe.student)
            if (examSeat != null) {
                seatingPlanDtoToReturn.add(new ExamSeatsDto(soe.student, examComponent, examSeat.examSeatingPlan, examSeat.row, examSeat.col, studentYear, concessions));
            } else {
                seatingPlanDtoToReturn.add(new ExamSeatsDto(soe.student, examComponent, null, null, null, studentYear, concessions));
            }
        }
        return new ResponseEntity<List<ExamSeatsDto>>(seatingPlanDtoToReturn, HttpStatus.OK);
    }
    
    /**
     * The seatingPlanPost method is used to save a new seatingPlan object to the database
     * OR to update a seatingPlan object if it already exists - we have no idea whether the seatingPlan object exists on the front end
     * 
     * @param seatingPlanDto
     * @return
     * @throws NotFoundException
     */
    @RequestMapping(value = "/seating-plans/{seatingPlanId}", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<ExamSeatsDto> create(
            @ApiParam(value = "The unique ID of the studentId to retrieve", required = true)
            @PathVariable("seatingPlanId") Integer seatingPlanId,
            @ApiParam(value = "The ExamSeat object to be created", required = true)
            @RequestBody @Valid  ExamSeatsDto examSeatsDto
    ) throws NotFoundException, InvalidDataException {
        
        LOGGER.info("** SeatingPlanApi - seatingPlanPost");
        Student student = studentService.findById(examSeatsDto.studentId)
        ExamComponent examComponent = examComponentService.findById(examSeatsDto.examComponentId)
        ExamSeat studentsCurrentSeat = examSeatService.findExamSeat(student, examComponent)
        if (studentsCurrentSeat != null) {
            LOGGER.debug("-- Deleting original exam seat")
            examSeatService.delete(studentsCurrentSeat)
        }
        ExamSeat examSeat = examSeatService.findSeatingPlan(seatingPlanId, examSeatsDto.row, examSeatsDto.col)
        
        if(examSeat){
            LOGGER.debug("-- Updating exam seat information with new data")
            examSeat.examSeatingPlan = examSeatsDto.examSeatingPlanId != null ? examSeatingPlanService.findById(examSeatsDto.examSeatingPlanId) : examSeat.examSeatingPlan
            examSeat.row = examSeatsDto.row
            examSeat.col = examSeatsDto.col
            ExamSeat examSeatSaved = examSeatService.save(examSeat)
            return new ResponseEntity<ExamSeatsDto>(new ExamSeatsDto(examSeat), HttpStatus.OK);
        } else {
            LOGGER.debug("-- Creating new exam seat")
            ExamSeatingPlan examSeatingPlan
            if(examSeatsDto.examSeatingPlanId != null){
                examSeatingPlan = examSeatingPlanService.findById(examSeatsDto.examSeatingPlanId)
            }
            
            if(student != null && examComponent != null && examSeatingPlan != null && examSeatsDto.row != null && examSeatsDto.col != null) {
                ExamSeat seatingPlanToSave = new ExamSeat(student, examComponent, examSeatingPlan, examSeatsDto.row, examSeatsDto.col)
                ExamSeat seatingPlanSaved = examSeatService.save(seatingPlanToSave);
                return new ResponseEntity<ExamSeatsDto>(new ExamSeatsDto(seatingPlanSaved), HttpStatus.CREATED);
            } else {
                throw new InvalidDataException()
            }
        }
    }
    
    
    /**
     * The seatingPlanPut method updates an existing record with in the database
     * 
     * @param studentId
     * @param seatingPlanDto
     * @return
     * @throws NotFoundException
     */
    @RequestMapping(value = "/seating-plans/{seatingPlanId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StudentOptionEntryDto> seatingPlanPut(
            @ApiParam(value = "The unique ID of the studentId to retrieve", required = true)
            @PathVariable("seatingPlanId") Integer seatingPlanId,
            @ApiParam(value = "The ExamSeat object to be updated", required = true)
            @RequestBody ExamSeatsDto examSeatsDto
    ) throws NotFoundException {
        
        LOGGER.info("** ExamSeatsApi - seatingPlanPut");
        
        ExamSeat seatingPlan = examSeatService.findExamSeat(examSeatsDto.studentId, examSeatsDto.examComponentId)
        if(seatingPlan != null){
            seatingPlan.examSeatingPlan = examSeatsDto.examSeatingPlanId != null ? examSeatingPlanService.findById(examSeatsDto.examSeatingPlanId) : seatingPlan.examSeatingPlan
            seatingPlan.row = examSeatsDto.row
            seatingPlan.col = examSeatsDto.col
            ExamSeat seatingPlanSaved = examSeatService.save(seatingPlan)
            return new ResponseEntity<ExamSeatsDto>(new ExamSeatsDto(seatingPlan), HttpStatus.OK);
        }
    }
    
    /**
     * The seatingPlanDelete method removes an existing record from the database
     *
     * @param studentId
     * @param examComponentId
     * @return
     * @throws NotFoundException
     */
    @RequestMapping(value = "/seating-plans/byStudentAndExam/{studentId}/{examComponentId}", produces = ["application/json"], method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteByStudentIdAndExamComponentId (
            @ApiParam(value = "The unique ID of the studentId to retrieve", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value = "The unique ID of the studentId to retrieve", required = true)
            @PathVariable("examComponentId") Integer examComponentId
    ) throws NotFoundException {
        LOGGER.info("** ExamSeatsApi - deleteByStudentIdAndExamComponentId");
        examSeatService.deleteByStudentAndExamComponent(studentId, examComponentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT)
    }
    
    
    /**
     * The seatingPlanDelete method removes an existing record from the database
     * 
     * @param studentId
     * @param examComponentId
     * @return
     * @throws NotFoundException
     */
    @RequestMapping(value = "/seating-plans/byRowAndCol/{seatingPlanId}/{row}/{col}", produces = ["application/json"], method = RequestMethod.DELETE)
    public ResponseEntity<?> seatingPlanDeleteByRowAndCol (
            @ApiParam(value = "The unique ID of the studentId to retrieve", required = true)
            @PathVariable("seatinPlanId") Integer seatingPlanId,
            @ApiParam(value = "The unique ID of the studentId to retrieve", required = true)
            @PathVariable("row") Integer row,
            @ApiParam(value = "The unique ID of the studentId to retrieve", required = true)
            @PathVariable("col") Integer col
    ) throws NotFoundException {
        LOGGER.info("** SeatingPlansApi - seatingPlanDelete");
        examSeatService.deleteByRowAndCol(seatingPlanId, row, col);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT)
    }
    
    /**
     * The seatingPlanDelete method removes an existing record from the database
     *
     * @param studentId
     * @param examComponentId
     * @return
     * @throws NotFoundException
     */
    @RequestMapping(value = "/seating-plans/{seatingPlanId}/{row}/{col}", produces = ["application/json"], method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteByRowAndCol (
            @ApiParam(value = "The unique ID of the studentId to retrieve", required = true)
            @PathVariable("seatinPlanId") Integer seatingPlanId,
            @ApiParam(value = "The unique ID of the studentId to retrieve", required = true)
            @PathVariable("row") Integer row,
            @ApiParam(value = "The unique ID of the studentId to retrieve", required = true)
            @PathVariable("col") Integer col
    ) throws NotFoundException {
        LOGGER.info("** SeatingPlansApi - seatingPlanDelete");
        examSeatService.deleteByRowAndCol(seatingPlanId, row, col);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT)
    }
}
