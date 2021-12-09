package uk.ac.reigate.api.student;

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

import uk.ac.reigate.domain.academic.EntryQualification
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentEntryQualification
import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.dto.StudentEntryQualificationDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.EntryQualificationService
import uk.ac.reigate.services.exams.ExamBoardService
import uk.ac.reigate.services.student.StudentEntryQualificationService
import uk.ac.reigate.services.student.StudentService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the studentEntryQualifications API")
public class StudentEntryQualificationsApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentEntryQualificationsApi.class);
    
    @Autowired
    private final StudentEntryQualificationService studentEntryQualificationService;
    
    @Autowired
    private final StudentService studentService;
    
    @Autowired
    private final EntryQualificationService entryQualificationService;
    
    @Autowired
    private final ExamBoardService examBoardService;
    
    /**
     * Default NoArgs constructor
     */
    StudentEntryQualificationsApi() {}
    
    /**
     * Autowired constructor
     */
    StudentEntryQualificationsApi(StudentEntryQualificationService studentEntryQualificationService, EntryQualificationService entryQualificationService) {
        this.studentEntryQualificationService = studentEntryQualificationService;
    }
    
    /**
     * The StudentEntryQualificationsGet method is used to retrieve a full list of all the StudentEntryQualificationDto objects
     *
     * @return A ResponseEntity with the corresponding list of StudentEntryQualificationDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StudentEntryQualification entities", notes = "A GET request to the StudentEntryQualifications endpoint returns an array of all the StudentEntryQualifications in the system.", response = StudentEntryQualificationDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of StudentEntryQualifications")
    ])
    @RequestMapping(value = "/studentEntryQualifications", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentEntryQualificationDto>> getAll() throws NotFoundException {
        LOGGER.info("** StudentEntryQualificationsApi - StudentEntryQualificationsGet");
        List<StudentEntryQualification> studentEntryQualifications = studentEntryQualificationService.findAll();
        return new ResponseEntity<List<StudentEntryQualificationDto>>(StudentEntryQualificationDto.mapFromList(studentEntryQualifications), HttpStatus.OK);
    }
    
    /**
     * The StudentEntryQualificationsGet method retrieves the individual studentEntryQualification by Id
     * 
     * @return A ResponseEntity with the corresponding list of StudentEntryQualificationDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @RequestMapping(value = "/studentEntryQualifications/{studentEntryQualificationId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentEntryQualificationDto> getById(
            @ApiParam(value = "The unique ID of the StudentEntryQualification to retrieve", required = true)
            @PathVariable("studentEntryQualificationId") Integer studentEntryQualificationId
    ) throws NotFoundException {
        LOGGER.info("** StudentEntryQualificationsApi - StudentEntryQualificationsIdGet");
        StudentEntryQualification studentEntryQualification = studentEntryQualificationService.findById(studentEntryQualificationId);
        if (studentEntryQualification == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<StudentEntryQualificationDto>(StudentEntryQualificationDto.mapFromEntity(studentEntryQualification), HttpStatus.OK);
    }
    
    /**
     * The studentEntryQualificationsPost method is used to create a new instance of a StudentEntryQualification from the supplied StudentEntryQualificationDto
     *
     * @param studentEntryQualification the StudentEntryQualificationDto to use to create the new StudentEntryQualification object
     * @return A ResponseEntity with the newly created StudentEntryQualification object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @RequestMapping(value = "/studentEntryQualifications", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StudentEntryQualificationDto> create(
            @ApiParam(value = "The StudentEntryQualification object to be created, without the contactId fields", required = true)
            @RequestBody @Valid StudentEntryQualificationDto studentEntryQualificationDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentEntryQualificationsApi - StudentEntryQualificationsPOST");
        if (studentEntryQualificationDto.studentEntryQualificationId != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        StudentEntryQualification studentEntryQualificationSaved = studentEntryQualificationService.createFromDto(studentEntryQualificationDto)
        return new ResponseEntity<StudentEntryQualificationDto>(StudentEntryQualificationDto.mapFromEntity(studentEntryQualificationSaved), HttpStatus.CREATED);
    }
    
    /**
     * The studentEntryQualificationsIdPut is used to update
     *
     * @param studentEntryQualificationId the contact ID for the studentEntryQualification object to update
     * @param studentEntryQualification the new data for the studentEntryQualification object
     * @return the newly updated studentEntryQualificationDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @RequestMapping(value = "/studentEntryQualifications/{studentEntryQualificationId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StudentEntryQualificationDto> update(
            @ApiParam(value = "The unique ID of the StudentEntryQualification to retrieve", required = true)
            @PathVariable("studentEntryQualificationId") Integer studentEntryQualificationId,
            @ApiParam(value = "The StudentEntryQualification object to be created, without the studentEntryQualificationId fields", required = true)
            @RequestBody StudentEntryQualificationDto studentEntryQualification
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentEntryQualificationsApi - StudentEntryQualificationsIdPut");
        if (studentEntryQualificationId != studentEntryQualification.studentEntryQualificationId) {
            throw new InvalidDataException()
        }
        StudentEntryQualification studentEntryQualificationSaved = studentEntryQualificationService.updateFromDto(studentEntryQualification)
        return new ResponseEntity<StudentEntryQualificationDto>(StudentEntryQualificationDto.mapFromEntity(studentEntryQualificationSaved), HttpStatus.OK);
    }
    
    /**
     *  The delete is used to delete the StudentEntryQualificationById
     */
    
    @RequestMapping(value = "/studentEntryQualifications/{studentEntryQualificationId}", produces = ["application/json"], method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (
            @ApiParam(value = "The unique ID of the entryQualification studentID to retrieve", required = true)
            @PathVariable("studentEntryQualificationId") Integer studentEntryQualificationId
    ) throws NotFoundException {
        LOGGER.info("** StudentEntryQualificationsApi - studentEntryQualificationsDELETE");
        studentEntryQualificationService.delete(studentEntryQualificationId);
        LOGGER.info("***StudentEntryQualificationsApi:- Deleted !!! ")
        return new ResponseEntity<>(HttpStatus.NO_CONTENT)
    }
    
    /**
     * The StudentEntryQualificationsGet method is used to retrieve a full list of students by the StudentEntryQualificationDto objects
     *
     * @return A ResponseEntity with the corresponding list of StudentEntryQualificationDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StudentEntryQualification entities", notes = "A GET request to the StudentEntryQualifications endpoint returns an array of all the StudentEntryQualifications in the system.", response = StudentEntryQualificationDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of StudentEntryQualifications")
    ])
    @RequestMapping(value = "/students/{studentId}/entryQualifications", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentEntryQualificationDto>> getAllByStudentId(
            @ApiParam(value = "The unique ID of the Student retrieves the List of entryQualifications for the selected student", required = true)
            @PathVariable("studentId") Integer studentId
    ) throws NotFoundException {
        LOGGER.info("** StudentEntryQualificationsApi - StudentEntryQualificationsGet");
        List<StudentEntryQualification> studentEntryQualification = studentEntryQualificationService.getByStudent(studentId);
        if (studentEntryQualification == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<List<StudentEntryQualificationDto>>(StudentEntryQualificationDto.mapFromList(studentEntryQualification), HttpStatus.OK);
    }
    
    /**
     * The studentEntryQualificationsIdGet method is used to retrieve an instance of a studentEntryQualificationDto object as identified by the studentEntryQualificationId provided
     *
     * @param studentEntryQualificationId the studentEntryQualification ID for the studentEntryQualification object retrieve
     * @return A ResponseEntity with the corresponding studentEntryQualificationDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @RequestMapping(value = "/students/{studentId}/entryQualifications/{studentEntryQualificationId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentEntryQualificationDto> getByStudentId(
            @ApiParam(value = "The unique ID of the Student to retrieve", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value = "The unique ID of the StudentEntryQualification to retrieve", required = true)
            @PathVariable("studentEntryQualificationId") Integer studentEntryQualificationId
            
    ) throws NotFoundException {
        LOGGER.info("** StudentEntryQualificationsApi - StudentEntryQualificationsIdGet");
        
        StudentEntryQualification studentEntryQualification = studentEntryQualificationService.getByStudentEntryQualifications(studentId, studentEntryQualificationId);
        if (studentEntryQualification == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<StudentEntryQualificationDto>(StudentEntryQualificationDto.mapFromEntity(studentEntryQualification), HttpStatus.OK);
    }
    
    /**
     * The updateStudentEntryQualificationChecked method is used to mark the student entry qualification check tab to be mark all checked
     * 
     *  @return A ResponseEntity with the corresponding list of StudentEntryQualificationDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StudentEntryQualification entities", notes = "A PUT request to the StudentEntryQualifications endpoint returns an array of all the StudentEntryQualifications in the system.", response = StudentEntryQualificationDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of StudentEntryQualifications")
    ])
    @RequestMapping(value = "/students/{studentId}/studentEntryQualificationsChecked", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<List<StudentEntryQualificationDto>> updateStudentEntryQualificationChecked(
            @ApiParam(value = "The unique ID of the Student retrieves the List of entryQualifications for the selected student", required = true)
            @PathVariable("studentId") Integer studentId
    ) throws NotFoundException {
        LOGGER.info("** StudentEntryQualificationsApi - StudentEntryQualificationsGet");
        List<StudentEntryQualification> studentEntryQualification = studentEntryQualificationService.getByStudent(studentId);
        if (studentEntryQualification != null) {
            studentEntryQualification.each {  it ->
                it.checked = true
                studentEntryQualificationService.save(it)
            }
        }
        return new ResponseEntity<List<StudentEntryQualificationDto>>(StudentEntryQualificationDto.mapFromList(studentEntryQualification), HttpStatus.OK);
    }
}
