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
import uk.ac.reigate.domain.academic.StudentDukeOfEdinburgh
import uk.ac.reigate.dto.StudentDukeOfEdinburghDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.student.StudentService
import uk.ac.reigate.services.student.StudentDukeOfEdinburghService


@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the studentDukeOfEdinburghs API")
public class StudentDukeOfEdinburghsApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDukeOfEdinburghsApi.class);
    
    @Autowired
    private final StudentDukeOfEdinburghService studentDukeOfEdinburghService;
    
    @Autowired
    StudentService studentService
    
    /**
     * Default NoArgs constructor
     */
    StudentDukeOfEdinburghsApi() {}
    
    /**
     * Autowired constructor
     */
    StudentDukeOfEdinburghsApi(StudentDukeOfEdinburghService studentDukeOfEdinburghService) {
        this.studentDukeOfEdinburghService = studentDukeOfEdinburghService;
    }
    
    /**
     * The studentDukeOfEdinburghsStudentDukeOfEdinburghIdGet method is used to retrieve an instance of a StudentDukeOfEdinburghDto object as identified by the studentDukeOfEdinburghId provided
     *
     * @param studentDukeOfEdinburghId the studentDukeOfEdinburgh ID for the StudentDukeOfEdinburgh object retrieve
     * @return A ResponseEntity with the corresponding StudentDukeOfEdinburghDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentDukeOfEdinburgh identified by the studentDukeOfEdinburghId", notes = "A getGET request to the StudentDukeOfEdinburgh instance endpoint will retrieve an instance of a StudentDukeOfEdinburgh entity as identified by the studentDukeOfEdinburghId provided in the URI.", response = StudentDukeOfEdinburghDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentDukeOfEdinburgh as identified by the studentDukeOfEdinburghId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/student-duke-of-edinburghs/{studentDukeOfEdinburghId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentDukeOfEdinburghDto> getById(
            @ApiParam(value = "The unique ID of the StudentDukeOfEdinburgh to retrieve", required = true)
            @PathVariable("studentDukeOfEdinburghId") Integer studentDukeOfEdinburghId) throws NotFoundException {
        LOGGER.info("** StudentDukeOfEdinburghsApi - studentDukeOfEdinburghsStudentDukeOfEdinburghIdGet");
        StudentDukeOfEdinburgh studentDukeOfEdinburgh = studentDukeOfEdinburghService.findById(studentDukeOfEdinburghId)
        return new ResponseEntity<StudentDukeOfEdinburghDto>(StudentDukeOfEdinburghDto.mapFromEntity(studentDukeOfEdinburgh), HttpStatus.OK);
    }
    
    /**
     * The studentDukeOfEdinburghsStudentDukeOfEdinburghIdGet method is used to retrieve an instance of a StudentDukeOfEdinburghDto object as identified by the studentDukeOfEdinburghId provided
     *
     * @param studentDukeOfEdinburghId the studentDukeOfEdinburgh ID for the StudentDukeOfEdinburgh object retrieve
     * @return A ResponseEntity with the corresponding StudentDukeOfEdinburghDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentDukeOfEdinburgh identified by the studentDukeOfEdinburghId", notes = "A getGET request to the StudentDukeOfEdinburgh instance endpoint will retrieve an instance of a StudentDukeOfEdinburgh entity as identified by the studentDukeOfEdinburghId provided in the URI.", response = StudentDukeOfEdinburghDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentDukeOfEdinburgh as identified by the studentDukeOfEdinburghId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/students/{studentId}/student-duke-of-edinburghs", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentDukeOfEdinburghDto>> getByStudentId(
            @ApiParam(value = "The unique ID of the StudentDukeOfEdinburgh to retrieve", required = true)
            @PathVariable("studentId") Integer studentId) throws NotFoundException {
        LOGGER.info("** StudentDukeOfEdinburghsApi - studentDukeOfEdinburghsStudentDukeOfEdinburghIdGet");
        Student student = studentService.findById(studentId)
        List<StudentDukeOfEdinburgh> studentDukeOfEdinburghs = studentDukeOfEdinburghService.findByStudentId(studentId)
        return new ResponseEntity<List<StudentDukeOfEdinburghDto>>(StudentDukeOfEdinburghDto.mapFromList(studentDukeOfEdinburghs), HttpStatus.OK);
    }
    
    /**
     * The studentDukeOfEdinburghsStudentDukeOfEdinburghIdGet method is used to create StudentDukeOfEdinburghDto object as identified by the studentDukeOfEdinburghId provided
     *
     * @param studentDukeOfEdinburghId the studentDukeOfEdinburgh ID for the StudentDukeOfEdinburgh object
     * @return A ResponseEntity with the corresponding StudentDukeOfEdinburghDto object
     */
    @RequestMapping(value = "/student-duke-of-edinburghs", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StudentDukeOfEdinburghDto> create(
            @ApiParam(value = "The StudentDukeOfEdinburgh object to be created, without the studentDukeOfEdinburghId fields", required = true)
            @RequestBody StudentDukeOfEdinburghDto studentDukeOfEdinburghDto
    ) throws NotFoundException {
        LOGGER.info("** StudentDukeOfEdinburghsApi - studentDukeOfEdinburghsStudentDukeOfEdinburghIdGet");
        Student student
        if (studentDukeOfEdinburghDto.studentId == null) {
            throw new NotFoundException();
        }
        StudentDukeOfEdinburgh studentDukeOfEdinburgh = studentDukeOfEdinburghService.createFromDto(studentDukeOfEdinburghDto)
        return new ResponseEntity<StudentDukeOfEdinburghDto>(StudentDukeOfEdinburghDto.mapFromEntity(studentDukeOfEdinburgh), HttpStatus.OK);
    }
    
    /**
     * The studentDukeOfEdinburghsStudentDukeOfEdinburghIdGet method is used to update StudentDukeOfEdinburghDto object as identified by the studentDukeOfEdinburghId provided
     *
     * @param studentDukeOfEdinburghId the studentDukeOfEdinburgh ID for the StudentDukeOfEdinburgh object
     * @return A ResponseEntity with the corresponding StudentDukeOfEdinburghDto object
     */
    @RequestMapping(value = "/student-duke-of-edinburghs/{studentDukeOfEdinburghId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StudentDukeOfEdinburghDto> update(
            @ApiParam(value = "The unique ID of the CareersRecord to retrieve", required = true)
            @PathVariable("studentDukeOfEdinburghId") Integer studentDukeOfEdinburghId,
            @ApiParam(value = "The StudentDukeOfEdinburgh object to be created, without the studentDukeOfEdinburghId fields", required = true)
            @RequestBody StudentDukeOfEdinburghDto studentDukeOfEdinburghDto
    ) throws NotFoundException {
        LOGGER.info("** StudentDukeOfEdinburghsApi - studentDukeOfEdinburghsStudentDukeOfEdinburghIdGet");
        if (studentDukeOfEdinburghId != studentDukeOfEdinburghDto.id) {
            throw new InvalidDataException();
        }
        StudentDukeOfEdinburgh studentDukeOfEdinburgh = studentDukeOfEdinburghService.updateFromDto(studentDukeOfEdinburghDto)
        return new ResponseEntity<StudentDukeOfEdinburghDto>(StudentDukeOfEdinburghDto.mapFromEntity(studentDukeOfEdinburgh), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/student-duke-of-edinburghs/{studentDukeOfEdinburghId}", produces = ["application/json"], method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(
            @ApiParam(value = "The unique ID of the CareersRecord to retrieve", required = true)
            @PathVariable("studentDukeOfEdinburghId") Integer studentDukeOfEdinburghId
    ) throws NotFoundException {
        LOGGER.info("** StudentDukeOfEdinburghsApi - studentDukeOfEdinburghsStudentDukeOfEdinburghIdGet");
        studentDukeOfEdinburghService.deleteById(studentDukeOfEdinburghId)
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
