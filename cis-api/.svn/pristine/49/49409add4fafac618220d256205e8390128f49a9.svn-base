package uk.ac.reigate.api.ilr;

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

import uk.ac.reigate.api.ICoreDataApi
import uk.ac.reigate.domain.lookup.Ethnicity
import uk.ac.reigate.dto.ilr.EthnicityDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.ilr.EthnicityService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/ethnicities", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/ethnicities", description = "the ethnicities API")
public class EthnicitiesApi implements ICoreDataApi<EthnicityDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EthnicitiesApi.class);
    
    @Autowired
    private final EthnicityService ethnicityService;
    
    /**
     * Default NoArgs constructor
     */
    EthnicitiesApi() {}
    
    /**
     * Autowired constructor
     */
    EthnicitiesApi(EthnicityService ethnicityService) {
        this.ethnicityService = ethnicityService;
    }
    
    /**
     * The ethnicitiesGet method is used to retrieve a full list of all the EthnicityDto objects
     *
     * @return A ResponseEntity with the corresponding list of EthnicityDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of Ethnicity entities", notes = "A GET request to the Ethnicities endpoint returns an array of all the ethnicities in the system.", response = EthnicityDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of ethnicities")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<EthnicityDto>> getAll() throws NotFoundException {
        LOGGER.info("** EthnicitiesApi - getAll");
        List<Ethnicity> ethnicities = ethnicityService.findAll();
        return new ResponseEntity<List<EthnicityDto>>(EthnicityDto.mapFromList(ethnicities), HttpStatus.OK);
    }
    
    /**
     * The ethnicitiesEthnicityIdGet method is used to retrieve an instance of a EthnicityDto object as identified by the ethnicityId provided
     *
     * @param ethnicityId the ethnicity ID for the Ethnicity object retrieve
     * @return A ResponseEntity with the corresponding EthnicityDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a Ethnicity identified by the ethnicityId", notes = "A getGET request to the Ethnicity instance endpoint will retrieve an instance of a Ethnicity entity as identified by the ethnicityId provided in the URI.", response = EthnicityDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Ethnicity as identified by the ethnicityId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{ethnicityId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<EthnicityDto> getById(
            @ApiParam(value = "The unique ID of the Ethnicity to retrieve", required = true)
            @PathVariable("ethnicityId") Integer ethnicityId
    ) throws NotFoundException {
        LOGGER.info("** EthnicitiesApi - getById");
        Ethnicity ethnicity = ethnicityService.findById(ethnicityId);
        if (ethnicity == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<EthnicityDto>(EthnicityDto.mapFromEntity(ethnicity), HttpStatus.OK);
    }
    
    /**
     * The ethnicitiesPost method is used to create a new instance of a Ethnicity from the supplied EthnicityDto
     *
     * @param ethnicity the EthnicityDto to use to create the new Ethnicity object
     * @return A ResponseEntity with the newly created Ethnicity object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new Ethnicity entity", notes = "A POST request to the Ethnicities endpoint with a Ethnicity object in the request body will create a new Ethnicity entity in the database.", response = EthnicityDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created Ethnicity entity including the ethnicityId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<EthnicityDto> create(
            @ApiParam(value = "The Ethnicity object to be created, without the ethnicityId fields", required = true)
            @RequestBody @Valid EthnicityDto ethnicityDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** EthnicitiesApi - create");
        if (ethnicityDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        Ethnicity ethnicity = ethnicityService.createFromDto(ethnicityDto)
        return new ResponseEntity<EthnicityDto>(EthnicityDto.mapFromEntity(ethnicity), HttpStatus.CREATED);
    }
    
    /**
     * The ethnicitiesEthnicityIdPut is used to update
     *
     * @param ethnicityId the ethnicity ID for the Ethnicity object to update
     * @param ethnicity the new data for the Ethnicity object
     * @return the newly updated EthnicityDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a Ethnicity entity", notes = "A PUT request to the Ethnicity instance endpoint with a Ethnicity object in the request body will update an existing Ethnicity entity in the database.", response = EthnicityDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated Ethnicity object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{ethnicityId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<EthnicityDto> update(
            @ApiParam(value = "The unique ID of the Ethnicity to retrieve", required = true)
            @PathVariable("ethnicityId") Integer ethnicityId,
            @ApiParam(value = "The Ethnicity object to be created, without the ethnicityId fields", required = true)
            @RequestBody EthnicityDto ethnicityDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** EthnicitiesApi - update");
        if (ethnicityId != ethnicityDto.id) {
            throw new InvalidDataException()
        }
        Ethnicity ethnicity = ethnicityService.updateFromDto(ethnicityDto)
        return new ResponseEntity<EthnicityDto>(EthnicityDto.mapFromEntity(ethnicity), HttpStatus.OK);
    }
}
