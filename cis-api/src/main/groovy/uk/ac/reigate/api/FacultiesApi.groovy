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
import uk.ac.reigate.dto.FacultyDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.DepartmentService
import uk.ac.reigate.services.FacultyService
import uk.ac.reigate.services.StaffService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/faculties", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/faculties", description = "the faculties API")
public class FacultiesApi implements ICoreDataApi<FacultyDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(FacultiesApi.class);
    
    @Autowired
    private final FacultyService facultyService;
    
    @Autowired
    private final StaffService staffService;
    
    @Autowired
    private final DepartmentService departmentService;
    /**
     * Default NoArgs constructor
     */
    FacultiesApi() {}
    
    /**
     * Autowired constructor
     */
    FacultiesApi(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    
    /**
     * The facultiesGet method is used to retrieve a full list of all the FacultyDto objects
     *
     * @return A ResponseEntity with the corresponding list of FacultyDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of Faculty entities", notes = "A GET request to the Faculties endpoint returns an array of all the facultys in the system.", response = FacultyDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of faculties")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<FacultyDto>> getAll() throws NotFoundException {
        LOGGER.info("** FacultiesApi - facultiesGet");
        List<Faculty> faculties = facultyService.findAll();
        return new ResponseEntity<List<FacultyDto>>(FacultyDto.mapFromList(faculties), HttpStatus.OK);
    }
    
    /**
     * The facultiesPost method is used to create a new instance of a Faculty from the supplied FacultyDto
     *
     * @param faculty the FacultyDto to use to create the new Faculty object
     * @return A ResponseEntity with the newly created Faculty object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new Faculty entity", notes = "A POST request to the Faculties endpoint with a Faculty object in the request body will create a new Faculty entity in the database.", response = FacultyDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created Faculty entity including the facultyId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<FacultyDto> create(
            @ApiParam(value = "The Faculty object to be created, without the facultyId fields", required = true)
            @RequestBody @Valid FacultyDto faculty
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** FacultiesApi - facultiesPOST");
        if (faculty.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        Faculty facultySaved = facultyService.createFromDto(faculty)
        return new ResponseEntity<FacultyDto>(FacultyDto.mapFromEntity(facultySaved), HttpStatus.CREATED);
    }
    
    /**
     * The facultiesFacultyIdGet method is used to retrieve an instance of a FacultyDto object as identified by the facultyId provided
     *
     * @param facultyId the faculty ID for the Faculty object retrieve
     * @return A ResponseEntity with the corresponding FacultyDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a Faculty identified by the facultyId", notes = "A getGET request to the Faculty instance endpoint will retrieve an instance of a Faculty entity as identified by the facultyId provided in the URI.", response = FacultyDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Faculty as identified by the facultyId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{facultyId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<FacultyDto> getById(
            @ApiParam(value = "The unique ID of the Faculty to retrieve", required = true)
            @PathVariable("facultyId") Integer facultyId
    ) throws NotFoundException {
        LOGGER.info("** FacultiesApi - facultiesFacultyIdGet");
        Faculty faculty = facultyService.findById(facultyId);
        if (faculty == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<FacultyDto>(FacultyDto.mapFromEntity(faculty), HttpStatus.OK);
    }
    
    /**
     * The facultiesFacultyIdPut is used to update
     *
     * @param facultyId the faculty ID for the Faculty object to update
     * @param faculty the new data for the Faculty object
     * @return the newly updated FacultyDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a Faculty entity", notes = "A PUT request to the Faculty instance endpoint with a Faculty object in the request body will update an existing Faculty entity in the database.", response = FacultyDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated Faculty object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{facultyId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<FacultyDto> update(
            @ApiParam(value = "The unique ID of the Faculty to retrieve", required = true)
            @PathVariable("facultyId") Integer facultyId,
            @ApiParam(value = "The Faculty object to be created, without the facultyId fields", required = true)
            @RequestBody FacultyDto faculty
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** FacultiesApi - facultyPUT");
        if (facultyId != faculty.id) {
            throw new InvalidDataException()
        }
        Faculty facultySaved = facultyService.updateFromDto(faculty)
        return new ResponseEntity<FacultyDto>(FacultyDto.mapFromEntity(facultySaved), HttpStatus.OK);
    }
    
    /**
     * This method is used to retrieve the departments for a given faculty. 
     * 
     * @param facultyId the facultyId to use for the retrieval
     * @return a List of DepartmentDto objects 
     * @throws NotFoundException
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a Faculty identified by the facultyId", notes = "A getGET request to the Faculty instance endpoint will retrieve an instance of a Faculty entity as identified by the facultyId provided in the URI.", response = FacultyDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Faculty as identified by the facultyId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{facultyId}/departments", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<DepartmentDto> getDepratments(
            @ApiParam(value = "The unique ID of the Faculty to retrieve", required = true)
            @PathVariable("facultyId") Integer facultyId
    ) throws NotFoundException {
        LOGGER.info("** FacultiesApi - facultiesFacultyIdGet");
        List<Department> departments = departmentService.findByfacultyId(facultyId);
        if (departments == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<List<DepartmentDto>>(DepartmentDto.mapFromList(departments), HttpStatus.OK);
    }
}
