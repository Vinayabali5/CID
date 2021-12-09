package uk.ac.reigate.api.ilr;

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

import uk.ac.reigate.api.ICoreDataApi
import uk.ac.reigate.domain.ilr.Outcome
import uk.ac.reigate.dto.ilr.OutcomeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.ilr.OutcomeService


@Controller
@RequestMapping(value = "/outcomes", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/outcomes", description = "the outcomes API")
public class OutcomesApi implements ICoreDataApi<OutcomeDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OutcomesApi.class);
    
    @Autowired
    private final OutcomeService outcomeService;
    
    /**
     * Default NoArgs constructor
     */
    OutcomesApi() {}
    
    /**
     * Autowired constructor
     */
    OutcomesApi(OutcomeService outcomeService) {
        this.outcomeService = outcomeService;
    }
    
    /**
     * The outcomesGet method is used to retrieve a full list of all the OutcomeDto objects
     *
     * @return A ResponseEntity with the corresponding list of OutcomeDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of Outcome entities", notes = "A GET request to the Outcomes endpoint returns an array of all the outcomes in the system.", response = OutcomeDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of outcomes")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<OutcomeDto>> getAll() throws NotFoundException {
        LOGGER.info("** OutcomesApi - outcomesGet");
        List<Outcome> outcomes = outcomeService.findAll();
        return new ResponseEntity<List<OutcomeDto>>(OutcomeDto.mapFromList(outcomes), HttpStatus.OK);
    }
    
    /**
     * The outcomesPost method is used to create a new instance of a Outcome from the supplied OutcomeDto
     *
     * @param outcome the OutcomeDto to use to create the new Outcome object
     * @return A ResponseEntity with the newly created Outcome object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new Outcome entity", notes = "A POST request to the Outcomes endpoint with a Outcome object in the request body will create a new Outcome entity in the database.", response = OutcomeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created Outcome entity including the outcomeId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<OutcomeDto> create(
            @ApiParam(value = "The Outcome object to be created, without the outcomeId fields", required = true)
            @RequestBody @Valid OutcomeDto outcome
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** OutcomesApi - outcomesPOST");
        if (outcome.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        Outcome outcomeSaved = outcomeService.createFromDto(outcome)
        return new ResponseEntity<OutcomeDto>(OutcomeDto.mapFromEntity(outcomeSaved), HttpStatus.CREATED);
    }
    
    /**
     * The outcomesOutcomeIdGet method is used to retrieve an instance of a OutcomeDto object as identified by the outcomeId provided
     *
     * @param outcomeId the outcome ID for the Outcome object retrieve
     * @return A ResponseEntity with the corresponding OutcomeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a Outcome identified by the outcomeId", notes = "A getGET request to the Outcome instance endpoint will retrieve an instance of a Outcome entity as identified by the outcomeId provided in the URI.", response = OutcomeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Outcome as identified by the outcomeId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{outcomeId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<OutcomeDto> getById(
            @ApiParam(value = "The unique ID of the Outcome to retrieve", required = true)
            @PathVariable("outcomeId") Integer outcomeId
    ) throws NotFoundException {
        LOGGER.info("** OutcomesApi - outcomesOutcomeIdGet");
        Outcome outcome = outcomeService.findById(outcomeId);
        if (outcome == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<OutcomeDto>(OutcomeDto.mapFromEntity(outcome), HttpStatus.OK);
    }
    
    /**
     * The outcomesOutcomeIdPut is used to update
     *
     * @param outcomeId the outcome ID for the Outcome object to update
     * @param outcome the new data for the Outcome object
     * @return the newly updated OutcomeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a Outcome entity", notes = "A PUT request to the Outcome instance endpoint with a Outcome object in the request body will update an existing Outcome entity in the database.", response = OutcomeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated Outcome object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{outcomeId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<OutcomeDto> update(
            @ApiParam(value = "The unique ID of the Outcome to retrieve", required = true)
            @PathVariable("outcomeId") Integer outcomeId,
            @ApiParam(value = "The Outcome object to be created, without the outcomeId fields", required = true)
            @RequestBody OutcomeDto outcome
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** OutcomesApi - outcomesPUT");
        if (outcomeId != outcome.id) {
            throw new InvalidDataException()
        }
        Outcome outcomeSaved = outcomeService.updateFromDto(outcome)
        return new ResponseEntity<OutcomeDto>(OutcomeDto.mapFromEntity(outcomeSaved), HttpStatus.OK);
    }
}