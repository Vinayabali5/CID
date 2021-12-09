package uk.ac.reigate.api.risk_assessment;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

import javax.validation.Valid

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper
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
import uk.ac.reigate.api.ICoreDataBaseApi
import uk.ac.reigate.domain.risk_assessment.StudentRiskLevel
import uk.ac.reigate.dto.lookup.BursaryTypeDto
import uk.ac.reigate.dto.risk_assessment.StudentRiskLevelDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.risk_assessment.StudentRiskLevelService
import uk.ac.reigate.services.student.StudentService


@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the studentRiskLevels API")
public class StudentRiskLevelsApi{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentRiskLevelsApi.class);
    
    @Autowired
    private final StudentRiskLevelService studentRiskLevelService;
    
    @Autowired
    private final StudentService studentService;
    
    @Autowired
    private final StaffService staffService;
    
    /**
     * Default NoArgs constructor
     */
    StudentRiskLevelsApi() {}
    
    /**
     * Autowired constructor
     */
    StudentRiskLevelsApi(StudentRiskLevelService studentRiskLevelService) {
        this.studentRiskLevelService = studentRiskLevelService;
    }
    
    /**
     * This method is used to retrieve a full list of all the BursaryTypeDto objects
     *
     * @return A ResponseEntity with the corresponding list of BursaryTypeDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StudentRiskLevel entities", notes = "A GET request to the StudentRiskLevels endpoint returns an array of all the bursaryTypes in the system.", response = StudentRiskLevelDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of studentRiskLevels")
    ])
    @RequestMapping(value = "/student-risk-levels", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentRiskLevelDto>> getAll() throws NotFoundException {
        LOGGER.info("** StudentRiskLevelsApi - studentRiskLevelsGet");
        List<StudentRiskLevel> studentRiskLevels = studentRiskLevelService.findAll();
        return new ResponseEntity<List<StudentRiskLevelDto>>(StudentRiskLevelDto.mapFromList(studentRiskLevels), HttpStatus.OK);
    }
    
    /**
     * This method is used to retrieve an instance of a StudentRiskLevelDto object as identified by the studentRiskLevelId provided
     *
     * @param studentRiskLevelId the studentRiskLevel ID for the StudentRiskLevel object retrieve
     * @return A ResponseEntity with the corresponding StudentRiskLevelDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentRiskLevel identified by the StudentRiskLevelId", notes = "A getGET request to the StudentRiskLevel instance endpoint will retrieve an instance of a StudentRiskLevel entity as identified by the studentRiskLevelId provided in the URI.", response = StudentRiskLevelDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentRiskLevel as identified by the studentRiskLevelId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/student-risk-level/{studentRiskLevelId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentRiskLevelDto> getById(
            @ApiParam(value = "The unique ID of the StudentRiskLevel to retrieve", required = true)
            @PathVariable("studentRiskLevelId") Integer studentRiskLevelId
    ) throws NotFoundException {
        LOGGER.info("** StudentRiskLevelsApi - studentRiskLevelIdGet");
        StudentRiskLevel studentRiskLevel = studentRiskLevelService.findById(studentRiskLevelId);
        if (studentRiskLevel == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<StudentRiskLevelDto>(StudentRiskLevelDto.mapFromEntity(studentRiskLevel), HttpStatus.OK);
    }
    
    /**
     * The studentRiskLevelsStudentRiskLevelIdGet method is used to retrieve an instance of a StudentRiskLevelDto object as identified by the studentId and studentRiskLevelId provided
     *
     * @param studentId, studentRiskLevelId the student ID and StudentRiskLevel Id for the StudentRiskLevel object retrieve
     * @return A ResponseEntity with the corresponding StudentRiskLevelDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentRiskLevel identified by the studentRiskLevelId", notes = "A getGET request to the StudentRiskLevel instance endpoint will retrieve an instance of a StudentRiskLevel entity as identified by the studentRiskLevelId provided in the URI.", response = StudentRiskLevelDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentRiskLevel as identified by the studentRiskLevelId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/students/{studentId}/risk-levels", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentRiskLevelDto>> getByStudentId(
            @ApiParam(value = "The unique ID of the StudentRiskLevel to retrieve", required = true)
            @PathVariable("studentId") Integer studentId
    ) throws NotFoundException {
        LOGGER.info("** StudentRiskLevelsApi - studentRiskLevelsStudentRiskLevelIdGet");
        List<StudentRiskLevel> studentRiskLevel = studentRiskLevelService.getByStudentId(studentId);
        if (studentRiskLevel == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<List<StudentRiskLevelDto>>(StudentRiskLevelDto.mapFromList(studentRiskLevel), HttpStatus.OK);
    }
    
    /**
     * The studentRiskLevelsPost method is used to create a new instance of a StudentRiskLevel from the supplied StudentRiskLevelDto
     *
     * @param studentRiskLevel the StudentRiskLevelDto to use to create the new StudentRiskLevel object
     * @return A ResponseEntity with the newly created StudentRiskLevel object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new StudentRiskLevel entity", notes = "A POST request to the StudentRiskLevels endpoint with a StudentRiskLevel object in the request body will create a new StudentRiskLevel entity in the database.", response = StudentRiskLevelDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created StudentRiskLevel entity including the studentRiskLevelId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "/student-risk-level", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StudentRiskLevelDto> create(
            @ApiParam(value = "The StudentRiskLevel object to be created, without the studentRiskLevelId fields", required = true)
            @RequestBody @Valid StudentRiskLevelDto studentRiskLevelDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentRiskLevelsApi - studentRiskLevelsPOST");
        if (studentRiskLevelDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        StudentRiskLevel studentRiskLevel = studentRiskLevelService.createFromDto(studentRiskLevelDto)
        return new ResponseEntity<StudentRiskLevelDto>(StudentRiskLevelDto.mapFromEntity(studentRiskLevel), HttpStatus.CREATED);
    }
    
    /**
     * The studentRiskLevelsStudentRiskLevelIdPut is used to update
     *
     * @param studentRiskLevelId the studentRiskLevel ID for the StudentRiskLevel object to update
     * @param studentRiskLevel the new data for the StudentRiskLevel object
     * @return the newly updated StudentRiskLevelDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a StudentRiskLevel entity", notes = "A PUT request to the StudentRiskLevel instance endpoint with a StudentRiskLevel object in the request body will update an existing StudentRiskLevel entity in the database.", response = StudentRiskLevelDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated StudentRiskLevel object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/student-risk-level/{studentRiskLevelId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StudentRiskLevelDto> update(
            @ApiParam(value = "The unique ID of the StudentRiskLevel to retrieve", required = true)
            @PathVariable("studentRiskLevelId") Integer studentRiskLevelId,
            @ApiParam(value = "The StudentRiskLevel object to be created, without the studentRiskLevelId fields", required = true)
            @RequestBody StudentRiskLevelDto studentRiskLevelDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentRiskLevelsApi - studentRiskLevelsPUT");
        if (studentRiskLevelId != studentRiskLevelDto.id) {
            throw new InvalidDataException()
        }
        StudentRiskLevel studentRiskLevel = studentRiskLevelService.updateFromDto(studentRiskLevelDto)
        return new ResponseEntity<StudentRiskLevelDto>(StudentRiskLevelDto.mapFromEntity(studentRiskLevel), HttpStatus.OK);
    }
    
    /**
     *  The delete is used to delete the StudentRiskLevel by StudentRiskLevelById
     */
    
    @RequestMapping(value = "/student-risk-levels/{studentRiskLevelId}", produces = ["application/json"], method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (
            @ApiParam(value = "The unique ID of the riskLevel studentID to retrieve", required = true)
            @PathVariable("studentRiskLevelId") Integer studentRiskLevelId
    ) throws NotFoundException {
        LOGGER.info("** StudentEntryQualificationsApi - studentEntryQualificationsDELETE");
        studentRiskLevelService.delete(studentRiskLevelId);
        LOGGER.info("***StudentRiskLevelsApi:- Deleted !!! ")
        return new ResponseEntity<>(HttpStatus.NO_CONTENT)
    }
}
