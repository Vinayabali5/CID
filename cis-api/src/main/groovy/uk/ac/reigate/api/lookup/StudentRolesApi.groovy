package uk.ac.reigate.api.lookup;

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

import uk.ac.reigate.api.ICoreDataBaseApi
import uk.ac.reigate.domain.lookup.StudentRole
import uk.ac.reigate.dto.lookup.StudentRoleDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.lookup.StudentRoleService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/student-roles", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/student-roles", description = "the studentRoles API")
public class StudentRolesApi implements ICoreDataBaseApi<StudentRoleDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentRolesApi.class);
    
    @Autowired
    private final StudentRoleService studentRoleService;
    
    /**
     * Default NoArgs constructor
     */
    StudentRolesApi() {}
    
    /**
     * Autowired constructor
     */
    StudentRolesApi(StudentRoleService studentRoleService) {
        this.studentRoleService = studentRoleService;
    }
    
    /**
     * This method is used to retrieve a full list of all the StudentRoleDto objects
     *
     * @return A ResponseEntity with the corresponding list of StudentRoleDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StudentRole entities", notes = "A GET request to the StudentRoles endpoint returns an array of all the studentRoles in the system.", response = StudentRoleDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of studentRoles")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentRoleDto>> getAll() throws NotFoundException {
        LOGGER.info("** StudentRolesApi - studentRolesGet");
        List<StudentRole> studentRoles = studentRoleService.findAll();
        return new ResponseEntity<List<StudentRoleDto>>(StudentRoleDto.mapFromList(studentRoles), HttpStatus.OK);
    }
    
    /**
     * This method is used to retrieve an instance of a StudentRoleDto object as identified by the studentRoleId provided
     *
     * @param studentRoleId the studentRole ID for the StudentRole object retrieve
     * @return A ResponseEntity with the corresponding StudentRoleDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentRole identified by the studentRoleId", notes = "A getGET request to the StudentRole instance endpoint will retrieve an instance of a StudentRole entity as identified by the studentRoleId provided in the URI.", response = StudentRoleDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentRole as identified by the studentRoleId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{studentRoleId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentRoleDto> getById(
            @ApiParam(value = "The unique ID of the StudentRole to retrieve", required = true)
            @PathVariable("studentRoleId") Integer studentRoleId
    ) throws NotFoundException {
        LOGGER.info("** StudentRolesApi - studentRolesStudentRoleIdGet");
        StudentRole studentRole = studentRoleService.findById(studentRoleId);
        if (studentRole == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<StudentRoleDto>(StudentRoleDto.mapFromEntity(studentRole), HttpStatus.OK);
    }
    
    /**
     * This method is used to create a new instance of a StudentRole from the supplied StudentRoleDto
     *
     * @param studentRole the StudentRoleDto to use to create the new StudentRole object
     * @return A ResponseEntity with the newly created StudentRole object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new StudentRole entity", notes = "A POST request to the StudentRoles endpoint with a StudentRole object in the request body will create a new StudentRole entity in the database.", response = StudentRoleDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created StudentRole entity including the studentRoleId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StudentRoleDto> create(
            @ApiParam(value = "The StudentRole object to be created, without the studentRoleId fields", required = true)
            @RequestBody @Valid StudentRoleDto studentRoleDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentRolesApi - studentRolesPOST");
        if (studentRoleDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        StudentRole studentRole = studentRoleService.createFromDto(studentRoleDto)
        return new ResponseEntity<StudentRoleDto>(StudentRoleDto.mapFromEntity(studentRole), HttpStatus.CREATED);
    }
    
    /**
     * The studentRolesStudentRoleIdPut is used to update
     *
     * @param studentRoleId the studentRole ID for the StudentRole object to update
     * @param studentRole the new data for the StudentRole object
     * @return the newly updated StudentRoleDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a StudentRole entity", notes = "A PUT request to the StudentRole instance endpoint with a StudentRole object in the request body will update an existing StudentRole entity in the database.", response = StudentRoleDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated StudentRole object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{studentRoleId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StudentRoleDto> update(
            @ApiParam(value = "The unique ID of the StudentRole to retrieve", required = true)
            @PathVariable("studentRoleId") Integer studentRoleId,
            @ApiParam(value = "The StudentRole object to be created, without the studentRoleId fields", required = true)
            @RequestBody StudentRoleDto studentRoleDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentRolesApi - studentRolesPUT");
        if (studentRoleId != studentRoleDto.id) {
            throw new InvalidDataException()
        }
        StudentRole studentRole = studentRoleService.updateFromDto(studentRoleDto)
        return new ResponseEntity<StudentRoleDto>(StudentRoleDto.mapFromEntity(studentRole), HttpStatus.OK);
    }
}
