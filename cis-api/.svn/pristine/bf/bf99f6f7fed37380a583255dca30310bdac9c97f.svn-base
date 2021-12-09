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

import uk.ac.reigate.domain.lookup.StudentRemarkPermission
import uk.ac.reigate.dto.StudentRemarkPermissionDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.student.StudentRemarkPermissionService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/studentRemarkPermissions", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/studentRemarkPermissions", description = "the studentRemarkPermissions API")
public class StudentRemarkPermissionsApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentRemarkPermissionsApi.class);
    
    @Autowired
    private final StudentRemarkPermissionService studentRemarkPermissionService;
    
    /**
     * Default NoArgs constructor
     */
    StudentRemarkPermissionsApi() {}
    
    /**
     * Autowired constructor
     */
    StudentRemarkPermissionsApi(StudentRemarkPermissionService studentRemarkPermissionService) {
        this.studentRemarkPermissionService = studentRemarkPermissionService;
    }
    
    /**
     * The studentRemarkPermissionsGet method is used to retrieve a full list of all the StudentRemarkPermissionDto objects
     *
     * @return A ResponseEntity with the corresponding list of StudentRemarkPermissionDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StudentRemarkPermission entities", notes = "A GET request to the StudentRemarkPermissions endpoint returns an array of all the studentRemarkPermissions in the system.", response = StudentRemarkPermissionDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of studentRemarkPermissions")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentRemarkPermissionDto>> getAll() throws NotFoundException {
        LOGGER.info("** StudentRemarkPermissionsApi - studentRemarkPermissionsGet");
        List<StudentRemarkPermission> studentRemarkPermissions = studentRemarkPermissionService.findAll();
        return new ResponseEntity<List<StudentRemarkPermissionDto>>(StudentRemarkPermissionDto.mapFromList(studentRemarkPermissions), HttpStatus.OK);
    }
    
    /**
     * The studentRemarkPermissionsPost method is used to create a new instance of a StudentRemarkPermission from the supplied StudentRemarkPermissionDto
     *
     * @param studentRemarkPermission the StudentRemarkPermissionDto to use to create the new StudentRemarkPermission object
     * @return A ResponseEntity with the newly created StudentRemarkPermission object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new StudentRemarkPermission entity", notes = "A POST request to the StudentRemarkPermissions endpoint with a StudentRemarkPermission object in the request body will create a new StudentRemarkPermission entity in the database.", response = StudentRemarkPermissionDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created StudentRemarkPermission entity including the studentRemarkPermissionId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StudentRemarkPermissionDto> create(
            @ApiParam(value = "The StudentRemarkPermission object to be created, without the studentRemarkPermissionId fields", required = true)
            @RequestBody @Valid StudentRemarkPermissionDto studentRemarkPermissionDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentRemarkPermissionsApi - studentRemarkPermissionsPOST");
        if (studentRemarkPermissionDto.id == null) {
            throw new NotFoundException();
        }
        StudentRemarkPermission studentRemarkPermission = studentRemarkPermissionService.createFromDto(studentRemarkPermissionDto)
        return new ResponseEntity<StudentRemarkPermissionDto>(StudentRemarkPermissionDto.mapFromEntity(studentRemarkPermission), HttpStatus.CREATED);
    }
    
    /**
     * The studentRemarkPermissionsStudentRemarkPermissionIdGet method is used to retrieve an instance of a StudentRemarkPermissionDto object as identified by the studentRemarkPermissionId provided
     *
     * @param studentRemarkPermissionId the studentRemarkPermission ID for the StudentRemarkPermission object retrieve
     * @return A ResponseEntity with the corresponding StudentRemarkPermissionDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentRemarkPermission identified by the studentRemarkPermissionId", notes = "A getGET request to the StudentRemarkPermission instance endpoint will retrieve an instance of a StudentRemarkPermission entity as identified by the studentRemarkPermissionId provided in the URI.", response = StudentRemarkPermissionDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentRemarkPermission as identified by the studentRemarkPermissionId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{studentRemarkPermissionId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentRemarkPermissionDto> getById(
            @ApiParam(value = "The unique ID of the StudentRemarkPermission to retrieve", required = true)
            @PathVariable("studentRemarkPermissionId") Integer studentRemarkPermissionId
    ) throws NotFoundException {
        LOGGER.info("** StudentRemarkPermissionsApi - studentRemarkPermissionsStudentRemarkPermissionIdGet");
        StudentRemarkPermission studentRemarkPermission = studentRemarkPermissionService.findById(studentRemarkPermissionId);
        if (studentRemarkPermission == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<StudentRemarkPermissionDto>(StudentRemarkPermissionDto.mapFromEntity(studentRemarkPermission), HttpStatus.OK);
    }
    
    /**
     * The studentRemarkPermissionsStudentRemarkPermissionIdPut is used to update
     *
     * @param studentRemarkPermissionId the studentRemarkPermission ID for the StudentRemarkPermission object to update
     * @param studentRemarkPermission the new data for the StudentRemarkPermission object
     * @return the newly updated StudentRemarkPermissionDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a StudentRemarkPermission entity", notes = "A PUT request to the StudentRemarkPermission instance endpoint with a StudentRemarkPermission object in the request body will update an existing StudentRemarkPermission entity in the database.", response = StudentRemarkPermissionDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated StudentRemarkPermission object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{studentRemarkPermissionId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StudentRemarkPermissionDto> update(
            @ApiParam(value = "The unique ID of the StudentRemarkPermission to retrieve", required = true)
            @PathVariable("studentRemarkPermissionId") Integer studentRemarkPermissionId,
            @ApiParam(value = "The StudentRemarkPermission object to be created, without the studentRemarkPermissionId fields", required = true)
            @RequestBody StudentRemarkPermissionDto studentRemarkPermissionDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentRemarkPermissionsApi - studentRemarkPermissionsPUT");
        if (studentRemarkPermissionId != studentRemarkPermissionDto.id) {
            throw new InvalidDataException()
        }
        StudentRemarkPermission studentRemarkPermission = studentRemarkPermissionService.updateFromDto(studentRemarkPermissionDto)
        return new ResponseEntity<StudentRemarkPermissionDto>(StudentRemarkPermissionDto.mapFromEntity(studentRemarkPermission), HttpStatus.OK);
    }
}
