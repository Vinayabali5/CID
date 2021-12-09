package uk.ac.reigate.api;

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
import uk.ac.reigate.domain.academic.StudentCareersRecord
import uk.ac.reigate.dto.careers.StudentCareersRecordDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.StudentCareersRecordService
import uk.ac.reigate.services.student.StudentService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the studentCareersRecords API")
public class StudentCareersRecordsApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentCareersRecordsApi.class);
    
    @Autowired
    private final StudentCareersRecordService studentCareersRecordService;
    
    @Autowired
    StudentService studentService
    
    /**
     * Default NoArgs constructor
     */
    StudentCareersRecordsApi() {}
    
    /**
     * Autowired constructor
     */
    StudentCareersRecordsApi(StudentCareersRecordService studentCareersRecordService) {
        this.studentCareersRecordService = studentCareersRecordService;
    }
    
    /**
     * The studentCareersRecordsStudentCareersRecordIdGet method is used to retrieve an instance of a StudentCareersRecordDto object as identified by the studentCareersRecordId provided
     *
     * @param studentCareersRecordId the studentCareersRecord ID for the StudentCareersRecord object retrieve
     * @return A ResponseEntity with the corresponding StudentCareersRecordDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentCareersRecord identified by the studentCareersRecordId", notes = "A getGET request to the StudentCareersRecord instance endpoint will retrieve an instance of a StudentCareersRecord entity as identified by the studentCareersRecordId provided in the URI.", response = StudentCareersRecordDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentCareersRecord as identified by the studentCareersRecordId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/student-careers-records/{studentCareersRecordId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentCareersRecordDto> getById(
            @ApiParam(value = "The unique ID of the StudentCareersRecord to retrieve", required = true)
            @PathVariable("studentCareersRecordId") Integer studentCareersRecordId) throws NotFoundException {
        LOGGER.info("** StudentCareersRecordsApi - studentCareersRecordsStudentCareersRecordIdGet");
        StudentCareersRecord studentCareersRecord = studentCareersRecordService.findById(studentCareersRecordId)
        return new ResponseEntity<StudentCareersRecordDto>(StudentCareersRecordDto.mapFromEntity(studentCareersRecord), HttpStatus.OK);
    }
    
    /**
     * The studentCareersRecordsStudentCareersRecordIdGet method is used to retrieve an instance of a StudentCareersRecordDto object as identified by the studentCareersRecordId provided
     *
     * @param studentCareersRecordId the studentCareersRecord ID for the StudentCareersRecord object retrieve
     * @return A ResponseEntity with the corresponding StudentCareersRecordDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentCareersRecord identified by the studentCareersRecordId", notes = "A getGET request to the StudentCareersRecord instance endpoint will retrieve an instance of a StudentCareersRecord entity as identified by the studentCareersRecordId provided in the URI.", response = StudentCareersRecordDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentCareersRecord as identified by the studentCareersRecordId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/students/{studentId}/student-careers-records", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentCareersRecordDto>> getByStudentId(
            @ApiParam(value = "The unique ID of the StudentCareersRecord to retrieve", required = true)
            @PathVariable("studentId") Integer studentId) throws NotFoundException {
        LOGGER.info("** StudentCareersRecordsApi - studentCareersRecordsStudentCareersRecordIdGet");
        Student student = studentService.findById(studentId)
        List<StudentCareersRecord> studentCareersRecords = studentCareersRecordService.findByStudentId(studentId)
        return new ResponseEntity<List<StudentCareersRecordDto>>(StudentCareersRecordDto.mapFromList(studentCareersRecords), HttpStatus.OK);
    }
    
    /**
     * The studentCareersRecordsStudentCareersRecordIdGet method is used to create StudentCareersRecordDto object as identified by the studentCareersRecordId provided
     *
     * @param studentCareersRecordId the studentCareersRecord ID for the StudentCareersRecord object
     * @return A ResponseEntity with the corresponding StudentCareersRecordDto object
     */
    @RequestMapping(value = "/student-careers-records", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StudentCareersRecordDto> create(
            @ApiParam(value = "The StudentCareersRecord object to be created, without the studentCareersRecordId fields", required = true)
            @RequestBody StudentCareersRecordDto studentCareersRecordDto
    ) throws NotFoundException {
        LOGGER.info("** StudentCareersRecordsApi - studentCareersRecordsStudentCareersRecordIdGet");
        Student student
        if (studentCareersRecordDto.studentId == null) {
            throw new NotFoundException();
        }
        StudentCareersRecord studentCareersRecord = studentCareersRecordService.createFromDto(studentCareersRecordDto)
        return new ResponseEntity<StudentCareersRecordDto>(StudentCareersRecordDto.mapFromEntity(studentCareersRecord), HttpStatus.OK);
    }
    
    /**
     * The studentCareersRecordsStudentCareersRecordIdGet method is used to update StudentCareersRecordDto object as identified by the studentCareersRecordId provided
     *
     * @param studentCareersRecordId the studentCareersRecord ID for the StudentCareersRecord object
     * @return A ResponseEntity with the corresponding StudentCareersRecordDto object
     */
    @RequestMapping(value = "/student-careers-records/{studentCareersRecordId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StudentCareersRecordDto> update(
            @ApiParam(value = "The unique ID of the CareersRecord to retrieve", required = true)
            @PathVariable("studentCareersRecordId") Integer studentCareersRecordId,
            @ApiParam(value = "The StudentCareersRecord object to be created, without the studentCareersRecordId fields", required = true)
            @RequestBody StudentCareersRecordDto studentCareersRecordDto
    ) throws NotFoundException {
        LOGGER.info("** StudentCareersRecordsApi - studentCareersRecordsStudentCareersRecordIdGet");
        if (studentCareersRecordId != studentCareersRecordDto.id) {
            throw new InvalidDataException();
        }
        StudentCareersRecord studentCareersRecord = studentCareersRecordService.updateFromDto(studentCareersRecordDto)
        return new ResponseEntity<StudentCareersRecordDto>(StudentCareersRecordDto.mapFromEntity(studentCareersRecord), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/student-careers-records/{studentCareersRecordId}", produces = ["application/json"], method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(
            @ApiParam(value = "The unique ID of the CareersRecord to retrieve", required = true)
            @PathVariable("studentCareersRecordId") Integer studentCareersRecordId
    ) throws NotFoundException {
        LOGGER.info("** StudentCareersRecordsApi - studentCareersRecordsStudentCareersRecordIdGet");
        studentCareersRecordService.deleteById(studentCareersRecordId)
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
