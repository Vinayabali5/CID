package uk.ac.reigate.api.student;

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
import uk.ac.reigate.domain.academic.StudentVolunteeringLog
import uk.ac.reigate.dto.StudentVolunteeringLogDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.student.StudentService
import uk.ac.reigate.services.student.StudentVolunteeringLogService


@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the studentVolunteeringLogs API")
public class StudentVolunteeringLogsApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentVolunteeringLogsApi.class);
    
    @Autowired
    private final StudentVolunteeringLogService studentVolunteeringLogService;
    
    @Autowired
    StudentService studentService
    
    /**
     * Default NoArgs constructor
     */
    StudentVolunteeringLogsApi() {}
    
    /**
     * Autowired constructor
     */
    StudentVolunteeringLogsApi(StudentVolunteeringLogService studentVolunteeringLogService) {
        this.studentVolunteeringLogService = studentVolunteeringLogService;
    }
    
    /**
     * The studentVolunteeringLogsStudentVolunteeringLogIdGet method is used to retrieve an instance of a StudentVolunteeringLogDto object as identified by the studentVolunteeringLogId provided
     *
     * @param studentVolunteeringLogId the studentVolunteeringLog ID for the StudentVolunteeringLog object retrieve
     * @return A ResponseEntity with the corresponding StudentVolunteeringLogDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentVolunteeringLog identified by the studentVolunteeringLogId", notes = "A getGET request to the StudentVolunteeringLog instance endpoint will retrieve an instance of a StudentVolunteeringLog entity as identified by the studentVolunteeringLogId provided in the URI.", response = StudentVolunteeringLogDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentVolunteeringLog as identified by the studentVolunteeringLogId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/student-volunteering-logs/{studentVolunteeringLogId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentVolunteeringLogDto> getById(
            @ApiParam(value = "The unique ID of the StudentVolunteeringLog to retrieve", required = true)
            @PathVariable("studentVolunteeringLogId") Integer studentVolunteeringLogId) throws NotFoundException {
        LOGGER.info("** StudentVolunteeringLogsApi - studentVolunteeringLogsStudentVolunteeringLogIdGet");
        StudentVolunteeringLog studentVolunteeringLog = studentVolunteeringLogService.findById(studentVolunteeringLogId)
        return new ResponseEntity<StudentVolunteeringLogDto>(StudentVolunteeringLogDto.mapFromEntity(studentVolunteeringLog), HttpStatus.OK);
    }
    
    /**
     * The studentVolunteeringLogsStudentVolunteeringLogIdGet method is used to retrieve an instance of a StudentVolunteeringLogDto object as identified by the studentVolunteeringLogId provided
     *
     * @param studentVolunteeringLogId the studentVolunteeringLog ID for the StudentVolunteeringLog object retrieve
     * @return A ResponseEntity with the corresponding StudentVolunteeringLogDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentVolunteeringLog identified by the studentVolunteeringLogId", notes = "A getGET request to the StudentVolunteeringLog instance endpoint will retrieve an instance of a StudentVolunteeringLog entity as identified by the studentVolunteeringLogId provided in the URI.", response = StudentVolunteeringLogDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentVolunteeringLog as identified by the studentVolunteeringLogId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/students/{studentId}/student-volunteering-logs", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentVolunteeringLogDto>> getByStudentId(
            @ApiParam(value = "The unique ID of the StudentVolunteeringLog to retrieve", required = true)
            @PathVariable("studentId") Integer studentId) throws NotFoundException {
        LOGGER.info("** StudentVolunteeringLogsApi - studentVolunteeringLogsStudentVolunteeringLogIdGet");
        Student student = studentService.findById(studentId)
        List<StudentVolunteeringLog> studentVolunteeringLogs = studentVolunteeringLogService.findByStudentId(studentId)
        return new ResponseEntity<List<StudentVolunteeringLogDto>>(StudentVolunteeringLogDto.mapFromList(studentVolunteeringLogs), HttpStatus.OK);
    }
    
    /**
     * The studentVolunteeringLogsStudentVolunteeringLogIdGet method is used to create StudentVolunteeringLogDto object as identified by the studentVolunteeringLogId provided
     *
     * @param studentVolunteeringLogId the studentVolunteeringLog ID for the StudentVolunteeringLog object
     * @return A ResponseEntity with the corresponding StudentVolunteeringLogDto object
     */
    @RequestMapping(value = "/student-volunteering-logs", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StudentVolunteeringLogDto> create(
            @ApiParam(value = "The StudentVolunteeringLog object to be created, without the studentVolunteeringLogId fields", required = true)
            @RequestBody StudentVolunteeringLogDto studentVolunteeringLogDto
    ) throws NotFoundException {
        LOGGER.info("** StudentVolunteeringLogsApi - studentVolunteeringLogsStudentVolunteeringLogIdGet");
        Student student
        if (studentVolunteeringLogDto.studentId == null) {
            throw new NotFoundException();
        }
        StudentVolunteeringLog studentVolunteeringLog = studentVolunteeringLogService.createFromDto(studentVolunteeringLogDto)
        return new ResponseEntity<StudentVolunteeringLogDto>(StudentVolunteeringLogDto.mapFromEntity(studentVolunteeringLog), HttpStatus.OK);
    }
    
    /**
     * The studentVolunteeringLogsStudentVolunteeringLogIdGet method is used to update StudentVolunteeringLogDto object as identified by the studentVolunteeringLogId provided
     *
     * @param studentVolunteeringLogId the studentVolunteeringLog ID for the StudentVolunteeringLog object
     * @return A ResponseEntity with the corresponding StudentVolunteeringLogDto object
     */
    @RequestMapping(value = "/student-volunteering-logs/{studentVolunteeringLogId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StudentVolunteeringLogDto> update(
            @ApiParam(value = "The unique ID of the CareersRecord to retrieve", required = true)
            @PathVariable("studentVolunteeringLogId") Integer studentVolunteeringLogId,
            @ApiParam(value = "The StudentVolunteeringLog object to be created, without the studentVolunteeringLogId fields", required = true)
            @RequestBody StudentVolunteeringLogDto studentVolunteeringLogDto
    ) throws NotFoundException {
        LOGGER.info("** StudentVolunteeringLogsApi - studentVolunteeringLogsStudentVolunteeringLogIdGet");
        if (studentVolunteeringLogId != studentVolunteeringLogDto.id) {
            throw new InvalidDataException();
        }
        StudentVolunteeringLog studentVolunteeringLog = studentVolunteeringLogService.updateFromDto(studentVolunteeringLogDto)
        return new ResponseEntity<StudentVolunteeringLogDto>(StudentVolunteeringLogDto.mapFromEntity(studentVolunteeringLog), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/student-volunteering-logs/{studentVolunteeringLogId}", produces = ["application/json"], method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(
            @ApiParam(value = "The unique ID of the CareersRecord to retrieve", required = true)
            @PathVariable("studentVolunteeringLogId") Integer studentVolunteeringLogId
    ) throws NotFoundException {
        LOGGER.info("** StudentVolunteeringLogsApi - studentVolunteeringLogsStudentVolunteeringLogIdGet");
        studentVolunteeringLogService.deleteById(studentVolunteeringLogId)
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
