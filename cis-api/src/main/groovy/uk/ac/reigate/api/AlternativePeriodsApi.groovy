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
import uk.ac.reigate.domain.academic.AlternativePeriod
import uk.ac.reigate.dto.AlternativePeriodDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.BlockService
import uk.ac.reigate.services.AlternativePeriodService


@Controller
@RequestMapping(value = "/alternative-periods", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/alternative-periods", description = "the alternativePeriods API")
public class AlternativePeriodsApi implements ICoreDataApi<AlternativePeriodDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AlternativePeriodsApi.class);
    
    @Autowired
    private final AlternativePeriodService alternativePeriodService;
    
    @Autowired
    private final BlockService blockService;
    
    /**
     * Default NoArgs constructor
     */
    AlternativePeriodsApi() {}
    
    /**
     * Autowired constructor
     */
    AlternativePeriodsApi(AlternativePeriodService alternativePeriodService) {
        this.alternativePeriodService = alternativePeriodService;
    }
    
    /**
     * The alternativePeriodsGet method is used to retrieve a full list of all the AlternativePeriodDto objects
     *
     * @return A ResponseEntity with the corresponding list of AlternativePeriodDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of AlternativePeriod entities", notes = "A GET request to the AlternativePeriods endpoint returns an array of all the alternativePeriods in the system.", response = AlternativePeriodDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of alternativePeriods")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<AlternativePeriodDto>> getAll() throws NotFoundException {
        LOGGER.info("** AlternativePeriodsApi - alternativePeriodsGet");
        List<AlternativePeriod> alternativePeriods = alternativePeriodService.findAll();
        return new ResponseEntity<List<AlternativePeriodDto>>(AlternativePeriodDto.mapFromList(alternativePeriods), HttpStatus.OK);
    }
    
    /**
     * The alternativePeriodsPost method is used to create a new instance of a AlternativePeriod from the supplied AlternativePeriodDto
     *
     * @param alternativePeriod the AlternativePeriodDto to use to create the new AlternativePeriod object
     * @return A ResponseEntity with the newly created AlternativePeriod object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new AlternativePeriod entity", notes = "A POST request to the AlternativePeriods endpoint with a AlternativePeriod object in the request body will create a new AlternativePeriod entity in the database.", response = AlternativePeriodDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created AlternativePeriod entity including the alternativePeriodId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<AlternativePeriodDto> create(
            @ApiParam(value = "The AlternativePeriod object to be created, without the alternativePeriodId fields", required = true)
            @RequestBody @Valid AlternativePeriodDto alternativePeriod
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** AlternativePeriodsApi - alternativePeriodsPOST");
        if (alternativePeriod.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        AlternativePeriod alternativePeriodSaved = alternativePeriodService.createFromDto(alternativePeriod)
        return new ResponseEntity<AlternativePeriodDto>(AlternativePeriodDto.mapFromEntity(alternativePeriodSaved), HttpStatus.CREATED);
    }
    
    /**
     * The alternativePeriodsAlternativePeriodIdGet method is used to retrieve an instance of a AlternativePeriodDto object as identified by the alternativePeriodId provided
     *
     * @param alternativePeriodId the alternativePeriod ID for the AlternativePeriod object retrieve
     * @return A ResponseEntity with the corresponding AlternativePeriodDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a AlternativePeriod identified by the alternativePeriodId", notes = "A getGET request to the AlternativePeriod instance endpoint will retrieve an instance of a AlternativePeriod entity as identified by the alternativePeriodId provided in the URI.", response = AlternativePeriodDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the AlternativePeriod as identified by the alternativePeriodId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{alternativePeriodId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<AlternativePeriodDto> getById(
            @ApiParam(value = "The unique ID of the AlternativePeriod to retrieve", required = true)
            @PathVariable("alternativePeriodId") Integer alternativePeriodId
    ) throws NotFoundException {
        LOGGER.info("** AlternativePeriodsApi - alternativePeriodsAlternativePeriodIdGet");
        AlternativePeriod alternativePeriod = alternativePeriodService.findById(alternativePeriodId);
        if (alternativePeriod == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<AlternativePeriodDto>(AlternativePeriodDto.mapFromEntity(alternativePeriod), HttpStatus.OK);
    }
    
    /**
     * The alternativePeriodsAlternativePeriodIdPut is used to update
     *
     * @param alternativePeriodId the alternativePeriod ID for the AlternativePeriod object to update
     * @param alternativePeriod the new data for the AlternativePeriod object
     * @return the newly updated AlternativePeriodDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a AlternativePeriod entity", notes = "A PUT request to the AlternativePeriod instance endpoint with a AlternativePeriod object in the request body will update an existing AlternativePeriod entity in the database.", response = AlternativePeriodDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated AlternativePeriod object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{alternativePeriodId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<AlternativePeriodDto> update(
            @ApiParam(value = "The unique ID of the AlternativePeriod to retrieve", required = true)
            @PathVariable("alternativePeriodId") Integer alternativePeriodId,
            @ApiParam(value = "The AlternativePeriod object to be created, without the alternativePeriodId fields", required = true)
            @RequestBody AlternativePeriodDto alternativePeriod
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** AlternativePeriodsApi - alternativePeriodsPUT");
        if (alternativePeriodId != alternativePeriod.id) {
            throw new InvalidDataException()
        }
        AlternativePeriod alternativePeriodSaved = alternativePeriodService.updateFromDto(alternativePeriod)
        return new ResponseEntity<AlternativePeriodDto>(AlternativePeriodDto.mapFromEntity(alternativePeriodSaved), HttpStatus.OK);
    }
}
