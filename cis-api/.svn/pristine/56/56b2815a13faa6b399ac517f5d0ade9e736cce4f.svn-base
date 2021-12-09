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
import uk.ac.reigate.domain.staff.InsetCourse
import uk.ac.reigate.dto.staff.InsetCourseDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.staff.InsetCourseService


@Controller
@RequestMapping(value = "/inset-courses", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/inset-courses", description = "the insetCourses API")
public class InsetCoursesApi implements ICoreDataBaseApi<InsetCourseDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(InsetCoursesApi.class);
    
    @Autowired
    private final InsetCourseService insetCourseService;
    
    /**
     * Default NoArgs constructor
     */
    InsetCoursesApi() {}
    
    /**
     * Autowired constructor
     */
    InsetCoursesApi(InsetCourseService insetCourseService) {
        this.insetCourseService = insetCourseService;
    }
    
    /**
     * The insetCoursesGet method is used to retrieve a full list of all the InsetCourseDto objects
     *
     * @return A ResponseEntity with the corresponding list of InsetCourseDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of InsetCourse entities", notes = "A GET request to the InsetCourses endpoint returns an array of all the insetCourses in the system.", response = InsetCourseDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of insetCourses")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<InsetCourseDto>> getAll() throws NotFoundException {
        LOGGER.info("** InsetCoursesApi - insetCoursesGet");
        List<InsetCourse> insetCourses = insetCourseService.findAll();
        return new ResponseEntity<List<InsetCourseDto>>(InsetCourseDto.mapFromList(insetCourses), HttpStatus.OK);
    }
    
    /**
     * The insetCoursesPost method is used to create a new instance of a InsetCourse from the supplied InsetCourseDto
     *
     * @param insetCourse the InsetCourseDto to use to create the new InsetCourse object
     * @return A ResponseEntity with the newly created InsetCourse object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new InsetCourse entity", notes = "A POST request to the InsetCourses endpoint with a InsetCourse object in the request body will create a new InsetCourse entity in the database.", response = InsetCourseDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created InsetCourse entity including the insetCourseId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<InsetCourseDto> create(
            @ApiParam(value = "The InsetCourse object to be created, without the insetCourseId fields", required = true)
            @RequestBody @Valid InsetCourseDto insetCourseDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** InsetCoursesApi - insetCoursesPOST");
        if (insetCourseDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        InsetCourse insetCourse = insetCourseService.createFromDto(insetCourseDto)
        return new ResponseEntity<InsetCourseDto>(InsetCourseDto.mapFromEntity(insetCourse), HttpStatus.CREATED);
    }
    
    /**
     * The insetCoursesInsetCourseIdGet method is used to retrieve an instance of a InsetCourseDto object as identified by the insetCourseId provided
     *
     * @param insetCourseId the insetCourse ID for the InsetCourse object retrieve
     * @return A ResponseEntity with the corresponding InsetCourseDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a InsetCourse identified by the insetCourseId", notes = "A getGET request to the InsetCourse instance endpoint will retrieve an instance of a InsetCourse entity as identified by the insetCourseId provided in the URI.", response = InsetCourseDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the InsetCourse as identified by the insetCourseId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{insetCourseId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<InsetCourseDto> getById(
            @ApiParam(value = "The unique ID of the InsetCourse to retrieve", required = true)
            @PathVariable("insetCourseId") Integer insetCourseId
    ) throws NotFoundException {
        LOGGER.info("** InsetCoursesApi - insetCoursesInsetCourseIdGet");
        InsetCourse insetCourse = insetCourseService.findById(insetCourseId);
        if (insetCourse == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<InsetCourseDto>(InsetCourseDto.mapFromEntity(insetCourse), HttpStatus.OK);
    }
    
    /**
     * The insetCoursesInsetCourseIdPut is used to update
     *
     * @param insetCourseId the insetCourse ID for the InsetCourse object to update
     * @param insetCourse the new data for the InsetCourse object
     * @return the newly updated InsetCourseDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a InsetCourse entity", notes = "A PUT request to the InsetCourse instance endpoint with a InsetCourse object in the request body will update an existing InsetCourse entity in the database.", response = InsetCourseDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated InsetCourse object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{insetCourseId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<InsetCourseDto> update(
            @ApiParam(value = "The unique ID of the InsetCourse to retrieve", required = true)
            @PathVariable("insetCourseId") Integer insetCourseId,
            @ApiParam(value = "The InsetCourse object to be created, without the insetCourseId fields", required = true)
            @RequestBody InsetCourseDto insetCourseDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** InsetCoursesApi - insetCoursesPUT");
        if (insetCourseId != insetCourseDto.id) {
            throw new InvalidDataException()
        }
        InsetCourse insetCourse = insetCourseService.updateFromDto(insetCourseDto)
        return new ResponseEntity<InsetCourseDto>(InsetCourseDto.mapFromEntity(insetCourse), HttpStatus.OK);
    }
}
