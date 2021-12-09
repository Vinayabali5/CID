package uk.ac.reigate.api;

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
import uk.ac.reigate.domain.lookup.SchoolPriority
import uk.ac.reigate.dto.SchoolPriorityDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.SchoolPriorityService


@Controller
@RequestMapping(value = "/schoolPriorities", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/schoolPriorities", description = "the schoolPriorities API")
public class SchoolPrioritiesApi implements ICoreDataBaseApi<SchoolPriorityDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolPrioritiesApi.class);
    
    @Autowired
    private final SchoolPriorityService schoolPriorityService;
    
    /**
     * Default No Args constructor
     */
    SchoolPrioritiesApi() {}
    
    /**
     * Default Autowired constructor
     */
    SchoolPrioritiesApi(SchoolPriorityService schoolPriorityService) {
        this.schoolPriorityService = schoolPriorityService;
    }
    
    /**
     * The schoolPrioritiesGet method is used to retrieve a full list of all the SchoolPriorityDto objects
     *
     * @return A ResponseEntity with the corresponding list of SchoolPriorityDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of SchoolPriority entities", notes = "A GET request to the SchoolPriorities endpoint returns an array of all the schoolPriorities in the system.", response = SchoolPriorityDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of schoolPriorities")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<SchoolPriorityDto>> getAll() throws NotFoundException {
        LOGGER.info("** SchoolPrioritiesApi - schoolPrioritiesGet");
        List<SchoolPriority> schoolPriorities = schoolPriorityService.findAll();
        return new ResponseEntity<List<SchoolPriorityDto>>(SchoolPriorityDto.mapFromList(schoolPriorities), HttpStatus.OK);
    }
    
    /**
     * The schoolPrioritiesPost method is used to create a new instance of a SchoolPriority from the supplied SchoolPriorityDto
     *
     * @param schoolPriority the SchoolPriorityDto to use to create the new SchoolPriority object
     * @return A ResponseEntity with the newly created SchoolPriority object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new SchoolPriority entity", notes = "A POST request to the SchoolPriorities endpoint with a SchoolPriority object in the request body will create a new SchoolPriority entity in the database.", response = SchoolPriorityDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created SchoolPriority entity including the schoolPriorityId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<SchoolPriorityDto> create(
            @ApiParam(value = "The SchoolPriority object to be created, without the schoolPriorityId fields", required = true)
            @RequestBody @Valid SchoolPriorityDto schoolPriorityDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** SchoolPrioritiesApi - schoolPrioritiesPOST");
        if (schoolPriorityDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        SchoolPriority schoolPriority = schoolPriorityService.createFromDto(schoolPriorityDto)
        return new ResponseEntity<SchoolPriorityDto>(SchoolPriorityDto.mapFromEntity(schoolPriority), HttpStatus.CREATED);
    }
    
    /**
     * The schoolPrioritiesSchoolPriorityIdGet method is used to retrieve an instance of a SchoolPriorityDto object as identified by the schoolPriorityId provided
     *
     * @param schoolPriorityId the schoolPriority ID for the SchoolPriority object retrieve
     * @return A ResponseEntity with the corresponding SchoolPriorityDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a SchoolPriority identified by the schoolPriorityId", notes = "A getGET request to the SchoolPriority instance endpoint will retrieve an instance of a SchoolPriority entity as identified by the schoolPriorityId provided in the URI.", response = SchoolPriorityDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the SchoolPriority as identified by the schoolPriorityId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{schoolPriorityId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<SchoolPriorityDto> getById(
            @ApiParam(value = "The unique ID of the SchoolPriority to retrieve", required = true)
            @PathVariable("schoolPriorityId") Integer schoolPriorityId
    ) throws NotFoundException {
        LOGGER.info("** SchoolPrioritiesApi - schoolPrioritiesSchoolPriorityIdGet");
        SchoolPriority schoolPriority = schoolPriorityService.findById(schoolPriorityId);
        if (schoolPriority == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<SchoolPriorityDto>(SchoolPriorityDto.mapFromEntity(schoolPriority), HttpStatus.OK);
    }
    
    /**
     * The schoolPrioritiesSchoolPriorityIdPut is used to update
     *
     * @param schoolPriorityId the schoolPriority ID for the SchoolPriority object to update
     * @param schoolPriority the new data for the SchoolPriority object
     * @return the newly updated SchoolPriorityDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a SchoolPriority entity", notes = "A PUT request to the SchoolPriority instance endpoint with a SchoolPriority object in the request body will update an existing SchoolPriority entity in the database.", response = SchoolPriorityDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated SchoolPriority object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{schoolPriorityId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<SchoolPriorityDto> update(
            @ApiParam(value = "The unique ID of the SchoolPriority to retrieve", required = true)
            @PathVariable("schoolPriorityId") Integer schoolPriorityId,
            @ApiParam(value = "The SchoolPriority object to be created, without the schoolPriorityId fields", required = true)
            @RequestBody SchoolPriorityDto schoolPriorityDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** SchoolPrioritiesApi - schoolPrioritiesPUT");
        if (schoolPriorityId != schoolPriorityDto.id) {
            throw new InvalidDataException()
        }
        SchoolPriority schoolPrioritySaved = schoolPriorityService.updateFromDto(schoolPriorityDto)
        return new ResponseEntity<SchoolPriorityDto>(SchoolPriorityDto.mapFromEntity(schoolPrioritySaved), HttpStatus.OK);
    }
}
