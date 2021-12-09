package uk.ac.reigate.api.student;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

import javax.validation.Valid

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

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import uk.ac.reigate.domain.academic.StudentPredictedGrade
import uk.ac.reigate.dto.StudentPredictedGradeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.EntryQualificationService
import uk.ac.reigate.services.exams.ExamBoardService
import uk.ac.reigate.services.lookup.PossibleGradeService
import uk.ac.reigate.services.student.StudentPredictedGradeService
import uk.ac.reigate.services.student.StudentService

@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the studentPredictedGrades API")
public class StudentPredictedGradesApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentPredictedGradesApi.class);
    
    @Autowired
    private final StudentPredictedGradeService studentPredictedGradeService;
    
    /**
     * Default NoArgs constructor
     */
    StudentPredictedGradesApi() {}
    
    /**
     * Autowired constructor
     */
    StudentPredictedGradesApi(StudentPredictedGradeService studentPredictedGradeService) {
        this.studentPredictedGradeService = studentPredictedGradeService;
    }
    
    /**
     * The StudentPredictedGradesGet method is used to retrieve a full list of all the StudentPredictedGradeDto objects
     *
     * @return A ResponseEntity with the corresponding list of StudentPredictedGradeDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StudentPredictedGrade entities", notes = "A GET request to the StudentPredictedGrades endpoint returns an array of all the StudentPredictedGrades in the system.", response = StudentPredictedGradeDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of StudentPredictedGrades")
    ])
    @RequestMapping(value = "/student-predicted-grades", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentPredictedGradeDto>> getAll() throws NotFoundException {
        LOGGER.info("** StudentPredictedGradesApi - StudentPredictedGradesGet");
        List<StudentPredictedGrade> studentPredictedGrades = studentPredictedGradeService.findAll();
        return new ResponseEntity<List<StudentPredictedGradeDto>>(StudentPredictedGradeDto.mapFromList(studentPredictedGrades), HttpStatus.OK);
    }
    
    /**
     * The StudentPredictedGradesGet method retrieves the individual studentPredictedGrade by Id
     * 
     * @return A ResponseEntity with the corresponding list of StudentPredictedGradeDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @RequestMapping(value = "/student-predicted-grades/{studentPredictedGradeId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentPredictedGradeDto> getById(
            @ApiParam(value = "The unique ID of the StudentPredictedGrade to retrieve", required = true)
            @PathVariable("studentPredictedGradeId") Integer studentPredictedGradeId
    ) throws NotFoundException {
        LOGGER.info("** StudentPredictedGradesApi - StudentPredictedGradesIdGet");
        StudentPredictedGrade studentPredictedGrade = studentPredictedGradeService.findById(studentPredictedGradeId);
        if (studentPredictedGrade == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<StudentPredictedGradeDto>(StudentPredictedGradeDto.mapFromEntity(studentPredictedGrade), HttpStatus.OK);
    }
    
    /**
     * The studentPredictedGradesPost method is used to create a new instance of a StudentPredictedGrade from the supplied StudentPredictedGradeDto
     *
     * @param studentPredictedGrade the StudentPredictedGradeDto to use to create the new StudentPredictedGrade object
     * @return A ResponseEntity with the newly created StudentPredictedGrade object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @RequestMapping(value = "/student-predicted-grades", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StudentPredictedGradeDto> create(
            @ApiParam(value = "The StudentPredictedGrade object to be created, without the contactId fields", required = true)
            @RequestBody @Valid StudentPredictedGradeDto studentPredictedGradeDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentPredictedGradesApi - StudentPredictedGradesPOST");
        if (studentPredictedGradeDto.studentPredictedGradeId != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        StudentPredictedGrade studentPredictedGradeSaved = studentPredictedGradeService.createFromDto(studentPredictedGradeDto)
        return new ResponseEntity<StudentPredictedGradeDto>(StudentPredictedGradeDto.mapFromEntity(studentPredictedGradeSaved), HttpStatus.CREATED);
    }
    
    /**
     * The studentPredictedGradesIdPut is used to update
     *
     * @param studentPredictedGradeId the contact ID for the studentPredictedGrade object to update
     * @param studentPredictedGrade the new data for the studentPredictedGrade object
     * @return the newly updated studentPredictedGradeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @RequestMapping(value = "/student-predicted-grades/{studentPredictedGradeId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StudentPredictedGradeDto> update(
            @ApiParam(value = "The unique ID of the StudentPredictedGrade to retrieve", required = true)
            @PathVariable("studentPredictedGradeId") Integer studentPredictedGradeId,
            @ApiParam(value = "The StudentPredictedGrade object to be created, without the studentPredictedGradeId fields", required = true)
            @RequestBody StudentPredictedGradeDto studentPredictedGrade
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentPredictedGradesApi - StudentPredictedGradesIdPut");
        if (studentPredictedGradeId != studentPredictedGrade.studentPredictedGradeId) {
            throw new InvalidDataException()
        }
        StudentPredictedGrade studentPredictedGradeSaved = studentPredictedGradeService.updateFromDto(studentPredictedGrade)
        return new ResponseEntity<StudentPredictedGradeDto>(StudentPredictedGradeDto.mapFromEntity(studentPredictedGradeSaved), HttpStatus.OK);
    }
    
    /**
     *  The delete is used to delete the StudentPredictedGradeById
     */
    
    @RequestMapping(value = "/student-predicted-grades/{studentPredictedGradeId}", produces = ["application/json"], method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (
            @ApiParam(value = "The unique ID of the entryQualification studentID to retrieve", required = true)
            @PathVariable("studentPredictedGradeId") Integer studentPredictedGradeId
    ) throws NotFoundException {
        LOGGER.info("** StudentPredictedGradesApi - studentPredictedGradesDELETE");
        studentPredictedGradeService.delete(studentPredictedGradeId);
        LOGGER.info("***StudentPredictedGradesApi:- Deleted !!! ")
        return new ResponseEntity<>(HttpStatus.NO_CONTENT)
    }
    
    /**
     * The StudentPredictedGradesGet method is used to retrieve a full list of students by the StudentPredictedGradeDto objects
     *
     * @return A ResponseEntity with the corresponding list of StudentPredictedGradeDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StudentPredictedGrade entities", notes = "A GET request to the StudentPredictedGrades endpoint returns an array of all the StudentPredictedGrades in the system.", response = StudentPredictedGradeDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of StudentPredictedGrades")
    ])
    @RequestMapping(value = "/students/{studentId}/predictedGrades", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentPredictedGradeDto>> getAllByStudentId(
            @ApiParam(value = "The unique ID of the Student retrieves the List of predictedGrades for the selected student", required = true)
            @PathVariable("studentId") Integer studentId
    ) throws NotFoundException {
        LOGGER.info("** StudentPredictedGradesApi - StudentPredictedGradesGet");
        List<StudentPredictedGrade> studentPredictedGrade = studentPredictedGradeService.getByStudent(studentId);
        if (studentPredictedGrade == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<List<StudentPredictedGradeDto>>(StudentPredictedGradeDto.mapFromList(studentPredictedGrade), HttpStatus.OK);
    }
}
