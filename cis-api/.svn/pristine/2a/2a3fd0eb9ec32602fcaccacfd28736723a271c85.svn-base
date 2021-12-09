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
import uk.ac.reigate.domain.staff.Disability
import uk.ac.reigate.dto.staff.DisabilityDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.staff.DisabilityService


@Controller
@RequestMapping(value = "/disabilities", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/disabilities", description = "the disabilities API")
public class DisabilitiesApi implements ICoreDataBaseApi<DisabilityDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DisabilitiesApi.class);
    
    @Autowired
    private final DisabilityService disabilityService;
    
    /**
     * Default NoArgs constructor
     */
    DisabilitiesApi() {}
    
    /**
     * Autowired constructor
     */
    DisabilitiesApi(DisabilityService disabilityService) {
        this.disabilityService = disabilityService;
    }
    
    /**
     * The disabilitiesGet method is used to retrieve a full list of all the DisabilityDto objects
     *
     * @return A ResponseEntity with the corresponding list of DisabilityDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of Disability entities", notes = "A GET request to the Nationalities endpoint returns an array of all the disabilities in the system.", response = DisabilityDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of disabilities")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<DisabilityDto>> getAll() throws NotFoundException {
        LOGGER.info("** NationalitiesApi - disabilitiesGet");
        List<Disability> disabilities = disabilityService.findAll();
        return new ResponseEntity<List<DisabilityDto>>(DisabilityDto.mapFromList(disabilities), HttpStatus.OK);
    }
    
    /**
     * The disabilitiesPost method is used to create a new instance of a Disability from the supplied DisabilityDto
     *
     * @param disability the DisabilityDto to use to create the new Disability object
     * @return A ResponseEntity with the newly created Disability object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new Disability entity", notes = "A POST request to the Nationalities endpoint with a Disability object in the request body will create a new Disability entity in the database.", response = DisabilityDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created Disability entity including the disabilityId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<DisabilityDto> create(
            @ApiParam(value = "The Disability object to be created, without the disabilityId fields", required = true)
            @RequestBody @Valid DisabilityDto disabilityDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** NationalitiesApi - disabilitiesPOST");
        if (disabilityDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        Disability disability = disabilityService.createFromDto(disabilityDto)
        return new ResponseEntity<DisabilityDto>(DisabilityDto.mapFromEntity(disability), HttpStatus.CREATED);
    }
    
    /**
     * The disabilitiesDisabilityIdGet method is used to retrieve an instance of a DisabilityDto object as identified by the disabilityId provided
     *
     * @param disabilityId the disability ID for the Disability object retrieve
     * @return A ResponseEntity with the corresponding DisabilityDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a Disability identified by the disabilityId", notes = "A getGET request to the Disability instance endpoint will retrieve an instance of a Disability entity as identified by the disabilityId provided in the URI.", response = DisabilityDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Disability as identified by the disabilityId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{disabilityId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<DisabilityDto> getById(
            @ApiParam(value = "The unique ID of the Disability to retrieve", required = true)
            @PathVariable("disabilityId") Integer disabilityId
    ) throws NotFoundException {
        LOGGER.info("** NationalitiesApi - disabilitysDisabilityIdGet");
        Disability disability = disabilityService.findById(disabilityId);
        if (disability == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<DisabilityDto>(DisabilityDto.mapFromEntity(disability), HttpStatus.OK);
    }
    
    /**
     * The disabilitiesDisabilityIdPut is used to update
     *
     * @param disabilityId the disability ID for the Disability object to update
     * @param disability the new data for the Disability object
     * @return the newly updated DisabilityDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a Disability entity", notes = "A PUT request to the Disability instance endpoint with a Disability object in the request body will update an existing Disability entity in the database.", response = DisabilityDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated Disability object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{disabilityId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<DisabilityDto> update(
            @ApiParam(value = "The unique ID of the Disability to retrieve", required = true)
            @PathVariable("disabilityId") Integer disabilityId,
            @ApiParam(value = "The Disability object to be created, without the disabilityId fields", required = true)
            @RequestBody DisabilityDto disabilityDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** NationalitiesApi - disabilitiesPUT");
        if (disabilityId != disabilityDto.id) {
            throw new InvalidDataException()
        }
        Disability disability = disabilityService.updateFromDto(disabilityDto)
        return new ResponseEntity<DisabilityDto>(DisabilityDto.mapFromEntity(disability), HttpStatus.OK);
    }
}
