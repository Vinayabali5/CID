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

import uk.ac.reigate.domain.lookup.YearGroup
import uk.ac.reigate.dto.lookup.YearGroupDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.YearGroupService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = ["/yearGroups", "/year-groups"], produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/yearGroups", description = "the yearGroups API")
public class YearGroupsApi implements ICoreDataApi<YearGroupDto, Integer>  {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(YearGroupsApi.class);
    
    @Autowired
    private final YearGroupService yearGroupService;
    
    /**
     * Default NoArgs constructor
     */
    YearGroupsApi() {}
    
    /**
     * Autowired constructor
     */
    YearGroupsApi(YearGroupService yearGroupService) {
        this.yearGroupService = yearGroupService;
    }
    
    /**
     * The yearGroupsGet method is used to retrieve a full list of all the YearGroupDto objects
     *
     * @return A ResponseEntity with the corresponding list of YearGroupDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of YearGroup entities", notes = "A GET request to the YearGroups endpoint returns an array of all the yearGroups in the system.", response = YearGroupDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of yearGroups")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<YearGroupDto>> getAll() throws NotFoundException {
        LOGGER.info("** YearGroupsApi - getAll");
        List<YearGroup> yearGroups = yearGroupService.findAll();
        return new ResponseEntity<List<YearGroupDto>>(YearGroupDto.mapFromList(yearGroups), HttpStatus.OK);
    }
    
    /**
     * The yearGroupsYearGroupIdGet method is used to retrieve an instance of a YearGroupDto object as identified by the yearGroupId provided
     *
     * @param yearGroupId the yearGroup ID for the YearGroup object retrieve
     * @return A ResponseEntity with the corresponding YearGroupDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a YearGroup identified by the yearGroupId", notes = "A getGET request to the YearGroup instance endpoint will retrieve an instance of a YearGroup entity as identified by the yearGroupId provided in the URI.", response = YearGroupDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the YearGroup as identified by the yearGroupId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{yearGroupId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<YearGroupDto> getById(
            @ApiParam(value = "The unique ID of the YearGroup to retrieve", required = true)
            @PathVariable("yearGroupId") Integer yearGroupId
    ) throws NotFoundException {
        LOGGER.info("** YearGroupsApi - getById");
        YearGroup yearGroup = yearGroupService.findById(yearGroupId);
        if (yearGroup == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<YearGroupDto>(YearGroupDto.mapFromEntity(yearGroup), HttpStatus.OK);
    }
    
    /**
     * The yearGroupsPost method is used to create a new instance of a YearGroup from the supplied YearGroupDto
     *
     * @param yearGroup the YearGroupDto to use to create the new YearGroup object
     * @return A ResponseEntity with the newly created YearGroup object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new YearGroup entity", notes = "A POST request to the YearGroups endpoint with a YearGroup object in the request body will create a new YearGroup entity in the database.", response = YearGroupDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created YearGroup entity including the yearGroupId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<YearGroupDto> create(
            @ApiParam(value = "The YearGroup object to be created, without the yearGroupId fields", required = true)
            @RequestBody @Valid YearGroupDto yearGroup
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** YearGroupsApi - create");
        if (yearGroup.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        YearGroup yearGroupSaved = yearGroupService.createFromDto(yearGroup)
        return new ResponseEntity<YearGroupDto>(YearGroupDto.mapFromEntity(yearGroupSaved), HttpStatus.CREATED);
    }
    
    /**
     * The yearGroupsYearGroupIdPut is used to update
     *
     * @param yearGroupId the yearGroup ID for the YearGroup object to update
     * @param yearGroup the new data for the YearGroup object
     * @return the newly updated YearGroupDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a YearGroup entity", notes = "A PUT request to the YearGroup instance endpoint with a YearGroup object in the request body will update an existing YearGroup entity in the database.", response = YearGroupDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated YearGroup object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{yearGroupId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<YearGroupDto> update(
            @ApiParam(value = "The unique ID of the YearGroup to retrieve", required = true)
            @PathVariable("yearGroupId") Integer yearGroupId,
            @ApiParam(value = "The YearGroup object to be created, without the yearGroupId fields", required = true)
            @RequestBody YearGroupDto yearGroup
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** YearGroupsApi - update");
        if (yearGroupId != yearGroup.id) {
            throw new InvalidDataException()
        }
        YearGroup yearGroupSaved = yearGroupService.updateFromDto(yearGroup)
        return new ResponseEntity<YearGroupDto>(YearGroupDto.mapFromEntity(yearGroupSaved), HttpStatus.OK);
    }
}
