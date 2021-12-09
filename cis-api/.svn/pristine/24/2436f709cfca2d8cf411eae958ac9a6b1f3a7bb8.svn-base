package uk.ac.reigate.api;

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
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Department
import uk.ac.reigate.domain.academic.Faculty
import uk.ac.reigate.dto.DepartmentDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.DepartmentService
import uk.ac.reigate.services.FacultyService
import uk.ac.reigate.services.StaffService

@Controller
@RequestMapping(value = "/departments", produces = [ MediaType.APPLICATION_JSON_VALUE ])
@Api(value = "/departments", description = "the departments API")
public class DepartmentsApi implements ICoreDataApi<DepartmentDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentsApi.class);
    
    @Autowired
    private final DepartmentService departmentService;
    
    /**
     * Default NoArgs constructor
     */
    DepartmentsApi() {}
    
    /**
     * Autowired constructor
     */
    DepartmentsApi(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    
    /**
     * The departmentsGet method is used to retrieve a full list of all the DepartmentDto objects
     *
     * @return A ResponseEntity with the corresponding list of DepartmentDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of Department entities", notes = "A GET request to the Departments endpoint returns an array of all the departments in the system.", response = DepartmentDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of departments")
    ])
    @RequestMapping(value = "", produces = [
        MediaType.APPLICATION_JSON_VALUE
    ], method = RequestMethod.GET)
    public ResponseEntity<List<DepartmentDto>> getAll() throws NotFoundException {
        LOGGER.info("** DepartmentsApi - getAll");
        List<Department> departments = departmentService.findAll();
        return new ResponseEntity<List<DepartmentDto>>(DepartmentDto.mapFromList(departments), HttpStatus.OK);
    }
    
    /**
     * This method is used to retrieve an instance of a DepartmentDto object as identified by the departmentId provided
     *
     * @param departmentId the department ID for the Department object retrieve
     * @return A ResponseEntity with the corresponding DepartmentDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a Department identified by the departmentId", notes = "A getGET request to the Department instance endpoint will retrieve an instance of a Department entity as identified by the departmentId provided in the URI.", response = DepartmentDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Department as identified by the departmentId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{departmentId}", produces = [
        MediaType.APPLICATION_JSON_VALUE
    ], method = RequestMethod.GET)
    public ResponseEntity<DepartmentDto> getById(
            @ApiParam(value = "The unique ID of the Department to retrieve", required = true)
            @PathVariable("departmentId") Integer departmentId
    ) throws NotFoundException {
        LOGGER.info("** DepartmentsApi - getById");
        Department department = departmentService.findById(departmentId);
        if (department == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<DepartmentDto>(DepartmentDto.mapFromEntity(department), HttpStatus.OK);
    }
    
    /**
     * This method is used to create a new instance of a Department from the supplied DepartmentDto
     *
     * @param department the DepartmentDto to use to create the new Department object
     * @return A ResponseEntity with the newly created Department object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new Department entity", notes = "A POST request to the Departments endpoint with a Department object in the request body will create a new Department entity in the database.", response = DepartmentDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created Department entity including the departmentId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = [
        MediaType.APPLICATION_JSON_VALUE
    ], method = RequestMethod.POST)
    public ResponseEntity<DepartmentDto> create(
            @ApiParam(value = "The Department object to be created, without the departmentId fields", required = true)
            @RequestBody @Valid DepartmentDto department
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** DepartmentsApi - create");
        if (department.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        Department departmentSaved = departmentService.createFromDto(department)
        return new ResponseEntity<DepartmentDto>(DepartmentDto.mapFromEntity(departmentSaved), HttpStatus.CREATED);
    }
    
    /**
     * This method is used to update a Department object from the supplied DepartmentDto object.
     *
     * @param departmentId the department ID for the Department object to update
     * @param department the new data for the Department object
     * @return the newly updated DepartmentDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a Department entity", notes = "A PUT request to the Department instance endpoint with a Department object in the request body will update an existing Department entity in the database.", response = DepartmentDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated Department object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{departmentId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<DepartmentDto> update(
            @ApiParam(value = "The unique ID of the Department to retrieve", required = true)
            @PathVariable("departmentId") Integer departmentId,
            @ApiParam(value = "The Department object to be created, without the departmentId fields", required = true)
            @RequestBody DepartmentDto department
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** DepartmentsApi - update");
        if (departmentId != department.id) {
            throw new InvalidDataException()
        }
        Department departmentSaved = departmentService.updateFromDto(department)
        return new ResponseEntity<DepartmentDto>(DepartmentDto.mapFromEntity(departmentSaved), HttpStatus.OK);
    }
}
