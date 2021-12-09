package uk.ac.reigate.api.risk_assessment;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

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
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.risk_assessment.StudentSafetyPlan
import uk.ac.reigate.dto.risk_assessment.StudentSafetyPlanDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.risk_assessment.StudentSafetyPlanService
import uk.ac.reigate.services.student.StudentService


@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the studentSafetyPlans API")
public class StudentSafetyPlanApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentSafetyPlanApi.class);
    
    @Autowired
    private final StudentSafetyPlanService studentSafetyPlanService;
    
    @Autowired
    StudentService studentService
    
    /**
     * Default NoArgs constructor
     */
    StudentSafetyPlanApi() {}
    
    /**
     * Autowired constructor
     */
    StudentSafetyPlanApi(StudentSafetyPlanService studentSafetyPlanService) {
        this.studentSafetyPlanService = studentSafetyPlanService;
    }
    
    
    /**
     * The studentSafetyPlansStudentSafetyPlanIdGet method is used to retrieve an instance of a StudentSafetyPlanDto object as identified by the studentSafetyPlanId provided
     *
     * @param studentSafetyPlanId the studentSafetyPlan ID for the StudentSafetyPlan object retrieve
     * @return A ResponseEntity with the corresponding StudentSafetyPlanDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentSafetyPlan identified by the studentSafetyPlanId", notes = "A getGET request to the StudentSafetyPlan instance endpoint will retrieve an instance of a StudentSafetyPlan entity as identified by the studentSafetyPlanId provided in the URI.", response = StudentSafetyPlanDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentSafetyPlan as identified by the studentSafetyPlanId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/students/{studentId}/safety-plan", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentSafetyPlanDto> studentSafetyPlansStudentSafetyPlanIdGet(
            @ApiParam(value = "The unique ID of the StudentSafetyPlan to retrieve", required = true)
            @PathVariable("studentId") Integer studentId) throws NotFoundException {
        LOGGER.info("** StudentSafetyPlansApi - studentSafetyPlansStudentSafetyPlanIdGet");
        Student student = studentService.findById(studentId)
        StudentSafetyPlan studentSafetyPlan = studentSafetyPlanService.findStudentSafetyPlan(studentId)
        return new ResponseEntity<?>(new StudentSafetyPlanDto(studentSafetyPlan), HttpStatus.OK);
    }
    
    /**
     * The studentSafetyPlansStudentSafetyPlanIdGet method is used to create StudentSafetyPlanDto object as identified by the studentSafetyPlanId provided
     *
     * @param studentSafetyPlanId the studentSafetyPlan ID for the StudentSafetyPlan object
     * @return A ResponseEntity with the corresponding StudentSafetyPlanDto object
     */
    @RequestMapping(value = "/student-safety-plan", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StudentSafetyPlanDto> create(
            @ApiParam(value = "The StudentSafetyPlan object to be created, without the studentSafetyPlanId fields", required = true)
            @RequestBody StudentSafetyPlanDto studentSafetyPlanDto
    ) throws NotFoundException {
        LOGGER.info("** StudentSafetyPlansApi - studentSafetyPlansStudentSafetyPlanIdGet");
        Student student
        if (studentSafetyPlanDto.studentId == null) {
            throw new NotFoundException();
        }
        StudentSafetyPlan studentSafetyPlan = studentSafetyPlanService.createFromDto(studentSafetyPlanDto)
        return new ResponseEntity<?>(StudentSafetyPlanDto.mapFromEntity(studentSafetyPlan), HttpStatus.OK);
    }
    
    /**
     * The studentSafetyPlansStudentSafetyPlanIdGet method is used to update StudentSafetyPlanDto object as identified by the studentSafetyPlanId provided
     *
     * @param studentSafetyPlanId the studentSafetyPlan ID for the StudentSafetyPlan object
     * @return A ResponseEntity with the corresponding StudentSafetyPlanDto object
     */
    @RequestMapping(value = "/student-safety-plan/{studentId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StudentSafetyPlanDto> update(
            @ApiParam(value = "The unique ID of the StudentSafetyPlan to retrieve", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value = "The StudentSafetyPlan object to be created, without the studentSafetyPlanId fields", required = true)
            @RequestBody StudentSafetyPlanDto studentSafetyPlanDto
    ) throws NotFoundException {
        LOGGER.info("** StudentSafetyPlansApi - studentSafetyPlansStudentSafetyPlanIdGet");
        if (studentSafetyPlanDto == null || studentSafetyPlanDto.studentId == null) {
            throw new InvalidDataException();
        }
        StudentSafetyPlan studentSafetyPlan = studentSafetyPlanService.updateFromDto(studentSafetyPlanDto)
        return new ResponseEntity<?>(StudentSafetyPlanDto.mapFromEntity(studentSafetyPlan), HttpStatus.OK);
    }
}
