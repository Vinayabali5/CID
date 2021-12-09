package uk.ac.reigate.api.ilp;

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

import uk.ac.reigate.domain.ilp.StatementBank
import uk.ac.reigate.dto.StatementBankDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.ilp.StatementBankService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/statement-bank", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/statement-bank", description = "the statementBanks API")
public class StatementBankApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StatementBankApi.class);
    
    @Autowired
    private final StatementBankService statementBankService;
    
    /**
     * Default NoArgs constructor
     */
    StatementBankApi() {}
    
    /**
     * Autowired constructor
     */
    StatementBankApi(StatementBankService statementBankService) {
        this.statementBankService = statementBankService;
    }
    
    /**
     * The statementBanksGet method is used to retrieve a full list of all the StatementBankDto objects
     *
     * @return A ResponseEntity with the corresponding list of StatementBankDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StatementBank entities", notes = "A GET request to the StatementBanks endpoint returns an array of all the statementBanks in the system.", response = StatementBankDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of statementBanks")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StatementBankDto>> getAll() throws NotFoundException {
        LOGGER.info("** StatementBanksApi - statementBanksGet");
        List<StatementBank> statementBanks = statementBankService.findAll();
        return new ResponseEntity<List<StatementBankDto>>(StatementBankDto.mapFromList(statementBanks), HttpStatus.OK);
    }
    
    /**
     * The statementBanksGet method is used to retrieve a full list of all the StatementBankDto objects
     *
     * @return A ResponseEntity with the corresponding list of StatementBankDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StatementBank entities", notes = "A GET request to the StatementBanks endpoint returns an array of all the statementBanks in the system.", response = StatementBankDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of statementBanks")
    ])
    @RequestMapping(value = "/mass-letters", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StatementBankDto>> getMassLetters() throws NotFoundException {
        LOGGER.info("** StatementBanksApi - statementBanksGet");
        List<StatementBank> statementBanks = statementBankService.findUseForMassLetters();
        return new ResponseEntity<List<StatementBankDto>>(StatementBankDto.mapFromList(statementBanks), HttpStatus.OK);
    }
    
    
    /**
     * The statementBanksStatementBankIdGet method is used to retrieve an instance of a StatementBankDto object as identified by the statementBankId provided
     *
     * @param statementBankId the statementBank ID for the StatementBank object retrieve
     * @return A ResponseEntity with the corresponding StatementBankDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StatementBank identified by the statementBankId", notes = "A getGET request to the StatementBank instance endpoint will retrieve an instance of a StatementBank entity as identified by the statementBankId provided in the URI.", response = StatementBankDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StatementBank as identified by the statementBankId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{statementBankId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StatementBankDto> getById(
            @ApiParam(value = "The unique ID of the StatementBank to retrieve", required = true)
            @PathVariable("statementBankId") Integer statementBankId
    ) throws NotFoundException {
        LOGGER.info("** StatementBanksApi - statementBanksStatementBankIdGet");
        StatementBank statementBank = statementBankService.findById(statementBankId);
        if (statementBank == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<StatementBankDto>(StatementBankDto.mapFromEntity(statementBank), HttpStatus.OK);
    }
    
    /**
     * The statementBanksStatementBankIdPOST is used to create
     *
     * @param statementBankId the statementBank ID for the StatementBank object to update
     * @param statementBank the new data for the StatementBank object
     * @return the newly updated StatementBankDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to create a StatementBank entity", notes = "A POST request to the StatementBank instance endpoint with a StatementBank object in the request body will create a new StatementBank entity in the database.", response = StatementBankDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated StatementBank object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StatementBankDto> create(
            @ApiParam(value = "The StatementBank object to be created, without the statementBankId fields", required = true)
            @RequestBody StatementBankDto statementBank
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StatementBanksApi - statementBanksPOST");
        if (statementBank.id != null) {
            throw new InvalidDataException()
        }
        StatementBank statementBankSaved = statementBankService.createFromDto(statementBank)
        return new ResponseEntity<StatementBankDto>(StatementBankDto.mapFromEntity(statementBankSaved), HttpStatus.OK);
    }
    
    /**
     * The statementBanksStatementBankIdPut is used to update
     *
     * @param statementBankId the statementBank ID for the StatementBank object to update
     * @param statementBank the new data for the StatementBank object
     * @return the newly updated StatementBankDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a StatementBank entity", notes = "A PUT request to the StatementBank instance endpoint with a StatementBank object in the request body will update an existing StatementBank entity in the database.", response = StatementBankDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated StatementBank object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{statementBankId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StatementBankDto> update(
            @ApiParam(value = "The unique ID of the StatementBank to retrieve", required = true)
            @PathVariable("statementBankId") Integer statementBankId,
            @ApiParam(value = "The StatementBank object to be created, without the statementBankId fields", required = true)
            @RequestBody StatementBankDto statementBank
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StatementBanksApi - statementBanksPUT");
        if (statementBankId != statementBank.id) {
            throw new InvalidDataException()
        }
        StatementBank statementBankSaved = statementBankService.updateFromDto(statementBank)
        return new ResponseEntity<StatementBankDto>(StatementBankDto.mapFromEntity(statementBankSaved), HttpStatus.OK);
    }
}
