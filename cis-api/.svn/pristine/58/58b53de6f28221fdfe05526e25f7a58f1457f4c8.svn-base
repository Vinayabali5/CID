package uk.ac.reigate.api.staff;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

import javax.validation.Valid

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
import uk.ac.reigate.api.ICoreDataBaseApi
import uk.ac.reigate.domain.staff.StaffInsetCourse
import uk.ac.reigate.dto.staff.StaffAbsenceDto
import uk.ac.reigate.dto.staff.StaffInsetCourseDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.staff.StaffInsetCourseService


@Controller
@RequestMapping(value = "/staff-inset-courses", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/staff-inset-courses", description = "the staffInsetCourses API")
public class StaffInsetCoursesApi  {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StaffInsetCoursesApi.class);
    
    @Autowired
    private final StaffInsetCourseService staffInsetCourseService;
    
    /**
     * Default NoArgs constructor
     */
    StaffInsetCoursesApi() {}
    
    /**
     * Autowired constructor
     */
    StaffInsetCoursesApi(StaffInsetCourseService staffInsetCourseService) {
        this.staffInsetCourseService = staffInsetCourseService;
    }
    
    /**
     * The staffInsetCoursesGet method is used to retrieve a full list of all the StaffInsetCourseDto objects
     *
     * @return A ResponseEntity with the corresponding list of StaffInsetCourseDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StaffInsetCourse entities", notes = "A GET request to the StaffInsetCourses endpoint returns an array of all the staffInsetCourses in the system.", response = StaffInsetCourseDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of staffInsetCourses")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StaffInsetCourseDto>> getAll() throws NotFoundException {
        LOGGER.info("** StaffInsetCoursesApi - staffInsetCoursesGet");
        List<StaffInsetCourse> staffInsetCourses = staffInsetCourseService.findAll();
        return new ResponseEntity<List<StaffInsetCourseDto>>(StaffInsetCourseDto.mapFromList(staffInsetCourses), HttpStatus.OK);
    }
    
    @RequestMapping(value = "staff/{staffId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StaffInsetCourseDto>> getByStaffId(
            @ApiParam(value = "The unique ID of the Staff to retrieve", required = true)
            @PathVariable("staffId") Integer staffId
    ) throws NotFoundException {
        LOGGER.info("** StaffAbsencesApi - staffAbsencesStaffAbsenceIdGet");
        List<StaffInsetCourse> staffInsetCourses = staffInsetCourseService.findByStaffId(staffId);
        if (staffInsetCourses == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<List<StaffInsetCourseDto>>(StaffInsetCourseDto.mapFromList(staffInsetCourses), HttpStatus.OK);
    }
    /**
     * The staffInsetCoursesPost method is used to create a new instance of a StaffInsetCourse from the supplied StaffInsetCourseDto
     *
     * @param staffInsetCourse the StaffInsetCourseDto to use to create the new StaffInsetCourse object
     * @return A ResponseEntity with the newly created StaffInsetCourse object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new StaffInsetCourse entity", notes = "A POST request to the StaffInsetCourses endpoint with a StaffInsetCourse object in the request body will create a new StaffInsetCourse entity in the database.", response = StaffInsetCourseDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created StaffInsetCourse entity including the staffInsetCourseId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StaffInsetCourseDto> create(
            @ApiParam(value = "The StaffInsetCourse object to be created, without the staffInsetCourseId fields", required = true)
            @RequestBody @Valid StaffInsetCourseDto staffInsetCourseDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StaffInsetCoursesApi - staffInsetCoursesPOST");
        if (staffInsetCourseDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        StaffInsetCourse staffInsetCourse = staffInsetCourseService.createFromDto(staffInsetCourseDto)
        return new ResponseEntity<StaffInsetCourseDto>(StaffInsetCourseDto.mapFromEntity(staffInsetCourse), HttpStatus.CREATED);
    }
    
    /**
     * The staffInsetCoursesStaffInsetCourseIdGet method is used to retrieve an instance of a StaffInsetCourseDto object as identified by the staffInsetCourseId provided
     *
     * @param staffInsetCourseId the staffInsetCourse ID for the StaffInsetCourse object retrieve
     * @return A ResponseEntity with the corresponding StaffInsetCourseDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StaffInsetCourse identified by the staffInsetCourseId", notes = "A getGET request to the StaffInsetCourse instance endpoint will retrieve an instance of a StaffInsetCourse entity as identified by the staffInsetCourseId provided in the URI.", response = StaffInsetCourseDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StaffInsetCourse as identified by the staffInsetCourseId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{staffInsetCourseId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StaffInsetCourseDto> getById(
            @ApiParam(value = "The unique ID of the StaffInsetCourse to retrieve", required = true)
            @PathVariable("staffInsetCourseId") Integer staffInsetCourseId
    ) throws NotFoundException {
        LOGGER.info("** StaffInsetCoursesApi - staffInsetCoursesStaffInsetCourseIdGet");
        StaffInsetCourse staffInsetCourse = staffInsetCourseService.findById(staffInsetCourseId);
        if (staffInsetCourse == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<StaffInsetCourseDto>(StaffInsetCourseDto.mapFromEntity(staffInsetCourse), HttpStatus.OK);
    }
    
    /**
     * The staffInsetCoursesStaffInsetCourseIdPut is used to update
     *
     * @param staffInsetCourseId the staffInsetCourse ID for the StaffInsetCourse object to update
     * @param staffInsetCourse the new data for the StaffInsetCourse object
     * @return the newly updated StaffInsetCourseDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a StaffInsetCourse entity", notes = "A PUT request to the StaffInsetCourse instance endpoint with a StaffInsetCourse object in the request body will update an existing StaffInsetCourse entity in the database.", response = StaffInsetCourseDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated StaffInsetCourse object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{staffInsetCourseId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StaffInsetCourseDto> update(
            @ApiParam(value = "The unique ID of the StaffInsetCourse to retrieve", required = true)
            @PathVariable("staffInsetCourseId") Integer staffInsetCourseId,
            @ApiParam(value = "The StaffInsetCourse object to be created, without the staffInsetCourseId fields", required = true)
            @RequestBody StaffInsetCourseDto staffInsetCourseDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StaffInsetCoursesApi - staffInsetCoursesPUT");
        if (staffInsetCourseId != staffInsetCourseDto.id) {
            throw new InvalidDataException()
        }
        StaffInsetCourse staffInsetCourse = staffInsetCourseService.updateFromDto(staffInsetCourseDto)
        return new ResponseEntity<StaffInsetCourseDto>(StaffInsetCourseDto.mapFromEntity(staffInsetCourse), HttpStatus.OK);
    }
}
