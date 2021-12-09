package uk.ac.reigate.api.student;

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.dto.PastoralMonitorDto
import uk.ac.reigate.dto.StudentYearDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.model.email.EmailMessage
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.DestinationService
import uk.ac.reigate.services.EnglishConditionOfFundingService
import uk.ac.reigate.services.LLDDHealthProblemService
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.TutorGroupService;
import uk.ac.reigate.services.email.StaffEmailingService
import uk.ac.reigate.services.ilr.MathsConditionOfFundingService
import uk.ac.reigate.services.lookup.BursaryTypeService
import uk.ac.reigate.services.lookup.StudentTypeService
import uk.ac.reigate.services.student.StudentService
import uk.ac.reigate.services.student.StudentYearService


@Controller
@RequestMapping(value = "/students", produces = [ MediaType.APPLICATION_JSON_VALUE ])
@Api(value = "/students", description = "the studentYears API")
public class StudentYearsApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentYearsApi.class);
    
    @Autowired
    AcademicYearService academicYearService
    
    @Autowired
    StudentService studentService
    
    @Autowired
    DestinationService destinationService
    
    @Autowired
    StudentYearService studentYearService;
    
    @Autowired
    LLDDHealthProblemService lLDDHealthProblemService;
    
    @Autowired
    StudentTypeService studentTypeService
    
    @Autowired
    TutorGroupService tutorGroupService
    
    @Autowired
    MathsConditionOfFundingService mathsConditionOfFundingService
    
    @Autowired
    EnglishConditionOfFundingService englishConditionOfFundingService
    
    @Autowired
    BursaryTypeService bursaryTypeService
    
    @Autowired
    StaffService staffService
    
    @Autowired
    private final StaffEmailingService staffEmailingService;
    
    /**
     * Default NoArgs constructor
     */
    StudentYearsApi() {}
    
    /**
     * The studentYearsStudentYearIdGet method is used to retrieve an instance of a StudentYearDto object as identified by the studentYearId provided
     *
     * @param studentYearId the studentYear ID for the StudentYear object retrieve
     * @return A ResponseEntity with the corresponding StudentYearDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentYear identified by the studentYearId", notes = "A getGET request to the StudentYear instance endpoint will retrieve an instance of a StudentYear entity as identified by the studentYearId provided in the URI.", response = StudentYearDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentYear as identified by the studentYearId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{studentId}/years/{yearId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentYearDto> studentYearsStudentYearIdGet(
            @ApiParam(value = "The unique ID of the StudentYear to retrieve", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value = "The year ID of the StudentYear to retrieve", required = false)
            @PathVariable("yearId") Integer yearId
    ) throws NotFoundException {
        LOGGER.info("** StudentYearsApi - studentYearsStudentYearIdGet");
        if (yearId == null) {
            yearId = academicYearService.getCurrentAcademicYear().id;
        }
        StudentYear studentYear = studentYearService.findByStudentAndYear(studentId, yearId);
        if (studentYear != null) {
            return new ResponseEntity<StudentYearDto>(new StudentYearDto(studentYear), HttpStatus.OK);
        } else {
            throw new NotFoundException("There are no student year data for the requested student/year.");
        }
    }
    
    /**
     * The studentYearsStudentYearIdPut is used to update
     *
     * @param studentId, yearId the student ID and year Id for the StudentYear object to update
     * @param studentYear the new data for the StudentYear object
     * @return the newly updated StudentYearDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a StudentYear entity", notes = "A PUT request to the StudentYear instance endpoint with a StudentYear object in the request body will update an existing StudentYear entity in the database.", response = StudentYearDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated StudentYear object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{studentId}/years/{yearId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StudentYearDto> studentYearsStudentYearIdPut(
            @ApiParam(value = "The unique ID of the StudentYear to retrieve", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value = "The year ID of the StudentYear to retrieve", required = true)
            @PathVariable("yearId") Integer yearId,
            @ApiParam(value = "The StudentYear object to be created, without the studentYearId fields", required = true)
            @RequestBody StudentYearDto studentYearDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentYearsApi - studentYearsPUT");
        StudentYear studentYear  =  studentYearService.findByStudentAndYear(studentYearDto.studentId, studentYearDto.yearId)
        if (studentYear != null ){
            studentYear.ilr = studentYearDto.ilr
            studentYear.startDate = studentYearDto.startDate
            studentYear.endDate = studentYearDto.endDate
            studentYear.withdrawnDate = studentYearDto.withdrawnDate
            studentYear.plh = studentYearDto.plh
            studentYear.peeph = studentYearDto.peeph
            studentYear.gcseEnglishGrade = studentYearDto.gcseEnglishGrade
            studentYear.gcseMathsGrade = studentYearDto.gcseMathsGrade
            studentYear.tutorGroup = studentYearDto.tutorGroupId != null ? tutorGroupService.findById(studentYearDto.tutorGroupId) : null
            studentYear.bursaryType = studentYearDto.bursaryTypeId != null ? bursaryTypeService.findById(studentYearDto.bursaryTypeId) : null
            studentYear.studentType = studentYearDto.typeId != null ? studentTypeService.findById(studentYearDto.typeId) : null
            studentYear.lda = studentYearDto.lda;
            studentYear.ehc = studentYearDto.ehc;
            studentYear.hns = studentYearDto.hns;
            studentYear.sen = studentYearDto.sen;
            studentYear.onMentoring = studentYearDto.onMentoring;
            studentYear.socialWorker = studentYearDto.socialWorker
            studentYear.mathsConditionOfFunding = studentYearDto.mathsConditionOfFundingId != null ? mathsConditionOfFundingService.findById(studentYearDto.mathsConditionOfFundingId) : null
            studentYear.englishConditionOfFunding = studentYearDto.englishConditionOfFundingId != null ? englishConditionOfFundingService.findById(studentYearDto.englishConditionOfFundingId) : null;
            studentYear.learningSupportCost = studentYearDto.learningSupportCost;
            studentYear.candidateNo = studentYearDto.candidateNo;
            studentYear.onContract = studentYearDto.onContract;
            studentYear.breakInLearning = studentYearDto.breakInLearning;
            studentYear.initialPostcode = studentYearDto.initialPostcode;
            studentYear.externalCandidate = studentYearDto.externalCandidate;
            studentYear.destination = studentYearDto.destinationId != null ? destinationService.findById(studentYearDto.destinationId) : null
            studentYear.destinationCollegeEmployer = studentYearDto.destinationCollegeEmployer;
            studentYear.destinationCourseCareer = studentYearDto.destinationCourseCareer;
            studentYear.pastoralMonitor = studentYearDto.pastoralMonitorId != null ? staffService.findById(studentYearDto.pastoralMonitorId) : null
            StudentYear studentSaved = studentYearService.save(studentYear)
            return new ResponseEntity<?>(HttpStatus.OK);
        } else {
            throw new InvalidDataException();
        }
    }
    
    /**
     * The studentYearIdPut is used to update
     *
     * @param studentId the student ID for the StudentYear object to update
     * @param studentYear the new data for the StudentYear object
     * @return the newly updated PastoralMonitorDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a StudentYear entity", notes = "A PUT request to the StudentYear instance endpoint with a StudentYear object in the request body will update an existing StudentYear entity in the database.", response = PastoralMonitorDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated StudentWarning object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{studentId}/pastoral-monitor", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<PastoralMonitorDto> pastoralMonitorUpdate(
            @ApiParam(value = "The unique ID of the PastoralMonitor to retrieve", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value = "The PastoralMonitorDto object to be updated", required = true)
            @RequestBody PastoralMonitorDto pastoralMonitor
    ) throws NotFoundException, InvalidDataException {
        
        LOGGER.info("** StudentYearsApi - studentYearsPUT");
        if (studentId == pastoralMonitor.studentId) {
            StudentYear studentYear = studentYearService.updatePastoralMonitor(pastoralMonitor);
            PastoralMonitorDto output = new PastoralMonitorDto(studentYear);
            EmailMessage email = staffEmailingService.sendPastoralMonitoringUpdate(output)
            return new ResponseEntity<PastoralMonitorDto>(output, HttpStatus.OK);
        } else {
            throw new InvalidDataException();
        }
    }
    
    @RequestMapping(value = "/{studentId}/pastoral-monitor", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<PastoralMonitorDto> pastoralMonitorIdGet(
            @ApiParam(value = "The unique ID of the PastoralMonitorDto to retrieve", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value = "The year ID of the PastoralMonitorDto to retrieve", required = false)
            @RequestParam(value = "yearId", required = false) Integer yearId
    ) throws NotFoundException {
        LOGGER.info("** StudentWarningsApi - studentWarningsStudentWarningIdGet");
        if (yearId == null) {
            yearId = academicYearService.getCurrentAcademicYear().id;
        }
        StudentYear studentYear = studentYearService.findByStudentAndYear(studentId, yearId);
        if (studentYear != null) {
            return new ResponseEntity<PastoralMonitorDto>(new PastoralMonitorDto(studentYear), HttpStatus.OK);
        } else {
            throw new NotFoundException("There are no student year data for the requested student/year.");
        }
    }
}
