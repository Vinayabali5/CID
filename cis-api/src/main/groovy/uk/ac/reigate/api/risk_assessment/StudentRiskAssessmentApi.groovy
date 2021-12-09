package uk.ac.reigate.api.risk_assessment;

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

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.risk_assessment.StudentRiskAssessment
import uk.ac.reigate.dto.risk_assessment.StudentRiskAssessmentDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.risk_assessment.StudentRiskAssessmentService
import uk.ac.reigate.services.student.StudentService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the studentRiskAssessments API")
public class StudentRiskAssessmentApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentRiskAssessmentApi.class);
    
    @Autowired
    private final StudentRiskAssessmentService studentRiskAssessmentService;
    
    @Autowired
    StudentService studentService
    
    /**
     * Default NoArgs constructor
     */
    StudentRiskAssessmentApi() {}
    
    /**
     * Autowired constructor
     */
    StudentRiskAssessmentApi(StudentRiskAssessmentService studentRiskAssessmentService) {
        this.studentRiskAssessmentService = studentRiskAssessmentService;
    }
    
    /**
     * The studentRiskAssessmentsStudentRiskAssessmentIdGet method is used to retrieve an instance of a StudentRiskAssessmentDto object as identified by the studentRiskAssessmentId provided
     *
     * @param studentRiskAssessmentId the studentRiskAssessment ID for the StudentRiskAssessment object retrieve
     * @return A ResponseEntity with the corresponding StudentRiskAssessmentDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentRiskAssessment identified by the studentRiskAssessmentId", notes = "A getGET request to the StudentRiskAssessment instance endpoint will retrieve an instance of a StudentRiskAssessment entity as identified by the studentRiskAssessmentId provided in the URI.", response = StudentRiskAssessmentDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentRiskAssessment as identified by the studentRiskAssessmentId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/students/{studentId}/risk-assessment", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentRiskAssessmentDto> studentRiskAssessmentsStudentRiskAssessmentIdGet(
            @ApiParam(value = "The unique ID of the StudentRiskAssessment to retrieve", required = true)
            @PathVariable("studentId") Integer studentId) throws NotFoundException {
        LOGGER.info("** StudentRiskAssessmentsApi - studentRiskAssessmentsStudentRiskAssessmentIdGet");
        Student student = studentService.findById(studentId)
        StudentRiskAssessment studentRiskAssessment = studentRiskAssessmentService.findStudentRiskAssessment(studentId)
        return new ResponseEntity<?>(new StudentRiskAssessmentDto(studentRiskAssessment), HttpStatus.OK);
    }
    
    /**
     * The studentRiskAssessmentsStudentRiskAssessmentIdGet method is used to create StudentRiskAssessmentDto object as identified by the studentRiskAssessmentId provided
     *
     * @param studentRiskAssessmentId the studentRiskAssessment ID for the StudentRiskAssessment object
     * @return A ResponseEntity with the corresponding StudentRiskAssessmentDto object
     */
    @RequestMapping(value = "/student-risk-assessment", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StudentRiskAssessmentDto> create(
            @ApiParam(value = "The StudentRiskAssessment object to be created, without the studentRiskAssessmentId fields", required = true)
            @RequestBody StudentRiskAssessmentDto studentRiskAssessmentDto
    ) throws NotFoundException {
        LOGGER.info("** StudentRiskAssessmentsApi - studentRiskAssessmentsStudentRiskAssessmentIdGet");
        StudentRiskAssessment studentRiskAssessment = studentRiskAssessmentService.createFromDto(studentRiskAssessmentDto)
        return new ResponseEntity<?>(StudentRiskAssessmentDto.mapFromEntity(studentRiskAssessment), HttpStatus.OK);
    }
    
    /**
     * The studentRiskAssessmentsStudentRiskAssessmentIdGet method is used to update StudentRiskAssessmentDto object as identified by the studentRiskAssessmentId provided
     *
     * @param studentRiskAssessmentId the studentRiskAssessment ID for the StudentRiskAssessment object
     * @return A ResponseEntity with the corresponding StudentRiskAssessmentDto object
     */
    @RequestMapping(value = "/student-risk-assessment/{studentRiskAssessmentId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StudentRiskAssessmentDto> update(
            @ApiParam(value = "The unique ID of the StudentRiskAssessment to retrieve", required = true)
            @PathVariable("studentRiskAssessmentId") Integer studentRiskAssessmentId,
            @ApiParam(value = "The StudentRiskAssessment object to be created, without the studentRiskAssessmentId fields", required = true)
            @RequestBody StudentRiskAssessmentDto studentRiskAssessmentDto
    ) throws NotFoundException {
        LOGGER.info("** StudentRiskAssessmentsApi - studentRiskAssessmentsStudentRiskAssessmentIdGet");
        if (studentRiskAssessmentId != studentRiskAssessmentDto.id) {
            throw new InvalidDataException();
        }
        StudentRiskAssessment studentRiskAssessment = studentRiskAssessmentService.updateFromDto(studentRiskAssessmentDto)
        return new ResponseEntity<?>(StudentRiskAssessmentDto.mapFromEntity(studentRiskAssessment), HttpStatus.OK);
    }
}