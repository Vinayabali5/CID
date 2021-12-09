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
import uk.ac.reigate.domain.staff.MaritalStatus
import uk.ac.reigate.dto.staff.MaritalStatusDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.staff.MaritalStatusService


@Controller
@RequestMapping(value = "/marital-statuses", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/marital-statuses", description = "the maritalStatuses API")
public class MaritalStatusesApi implements ICoreDataBaseApi<MaritalStatusDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MaritalStatusesApi.class);
    
    @Autowired
    private final MaritalStatusService maritalStatusService;
    
    /**
     * Default NoArgs constructor
     */
    MaritalStatusesApi() {}
    
    /**
     * Autowired constructor
     */
    MaritalStatusesApi(MaritalStatusService maritalStatusService) {
        this.maritalStatusService = maritalStatusService;
    }
    
    /**
     * The maritalStatusesGet method is used to retrieve a full list of all the MaritalStatusDto objects
     *
     * @return A ResponseEntity with the corresponding list of MaritalStatusDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of MaritalStatus entities", notes = "A GET request to the MaritalStatuses endpoint returns an array of all the maritalStatuses in the system.", response = MaritalStatusDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of maritalStatuses")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<MaritalStatusDto>> getAll() throws NotFoundException {
        LOGGER.info("** MaritalStatusesApi - maritalStatusesGet");
        List<MaritalStatus> maritalStatuses = maritalStatusService.findAll();
        return new ResponseEntity<List<MaritalStatusDto>>(MaritalStatusDto.mapFromList(maritalStatuses), HttpStatus.OK);
    }
    
    /**
     * The maritalStatusesPost method is used to create a new instance of a MaritalStatus from the supplied MaritalStatusDto
     *
     * @param maritalStatus the MaritalStatusDto to use to create the new MaritalStatus object
     * @return A ResponseEntity with the newly created MaritalStatus object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new MaritalStatus entity", notes = "A POST request to the MaritalStatuses endpoint with a MaritalStatus object in the request body will create a new MaritalStatus entity in the database.", response = MaritalStatusDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created MaritalStatus entity including the maritalStatusId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<MaritalStatusDto> create(
            @ApiParam(value = "The MaritalStatus object to be created, without the maritalStatusId fields", required = true)
            @RequestBody @Valid MaritalStatusDto maritalStatusDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** MaritalStatusesApi - maritalStatusesPOST");
        if (maritalStatusDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        MaritalStatus maritalStatus = maritalStatusService.createFromDto(maritalStatusDto)
        return new ResponseEntity<MaritalStatusDto>(MaritalStatusDto.mapFromEntity(maritalStatus), HttpStatus.CREATED);
    }
    
    /**
     * The maritalStatusesMaritalStatusIdGet method is used to retrieve an instance of a MaritalStatusDto object as identified by the maritalStatusId provided
     *
     * @param maritalStatusId the maritalStatus ID for the MaritalStatus object retrieve
     * @return A ResponseEntity with the corresponding MaritalStatusDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a MaritalStatus identified by the maritalStatusId", notes = "A getGET request to the MaritalStatus instance endpoint will retrieve an instance of a MaritalStatus entity as identified by the maritalStatusId provided in the URI.", response = MaritalStatusDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the MaritalStatus as identified by the maritalStatusId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{maritalStatusId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<MaritalStatusDto> getById(
            @ApiParam(value = "The unique ID of the MaritalStatus to retrieve", required = true)
            @PathVariable("maritalStatusId") Integer maritalStatusId
    ) throws NotFoundException {
        LOGGER.info("** MaritalStatusesApi - maritalStatussMaritalStatusIdGet");
        MaritalStatus maritalStatus = maritalStatusService.findById(maritalStatusId);
        if (maritalStatus == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<MaritalStatusDto>(MaritalStatusDto.mapFromEntity(maritalStatus), HttpStatus.OK);
    }
    
    /**
     * The maritalStatusesMaritalStatusIdPut is used to update
     *
     * @param maritalStatusId the maritalStatus ID for the MaritalStatus object to update
     * @param maritalStatus the new data for the MaritalStatus object
     * @return the newly updated MaritalStatusDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a MaritalStatus entity", notes = "A PUT request to the MaritalStatus instance endpoint with a MaritalStatus object in the request body will update an existing MaritalStatus entity in the database.", response = MaritalStatusDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated MaritalStatus object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{maritalStatusId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<MaritalStatusDto> update(
            @ApiParam(value = "The unique ID of the MaritalStatus to retrieve", required = true)
            @PathVariable("maritalStatusId") Integer maritalStatusId,
            @ApiParam(value = "The MaritalStatus object to be created, without the maritalStatusId fields", required = true)
            @RequestBody MaritalStatusDto maritalStatusDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** MaritalStatusesApi - maritalStatusesPUT");
        if (maritalStatusId != maritalStatusDto.id) {
            throw new InvalidDataException()
        }
        MaritalStatus maritalStatus = maritalStatusService.updateFromDto(maritalStatusDto)
        return new ResponseEntity<MaritalStatusDto>(MaritalStatusDto.mapFromEntity(maritalStatus), HttpStatus.OK);
    }
}
