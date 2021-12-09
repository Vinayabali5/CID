package uk.ac.reigate.api.ilp;

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
import uk.ac.reigate.domain.ilp.StatementBankType
import uk.ac.reigate.domain.ilp.StatementBank
import uk.ac.reigate.dto.StatementBankDto
import uk.ac.reigate.dto.ilp.StatementBankTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.ilp.StatementBankTypeService
import uk.ac.reigate.services.ilp.StatementBankService


@Controller
@RequestMapping(value = "/statement-bank-types", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/statement-bank-types", description = "the iLPStatementBankTypes API")
public class StatementBankTypesApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StatementBankTypesApi.class);
    
    @Autowired
    private final StatementBankTypeService iLPStatementBankTypeService;
    
    @Autowired
    private final StatementBankService statementBankService;
    
    
    /**
     * Default NoArgs constructor
     */
    StatementBankTypesApi() {}
    
    /**
     * Autowired constructor
     */
    StatementBankTypesApi(StatementBankTypeService iLPStatementBankTypeService) {
        this.iLPStatementBankTypeService = iLPStatementBankTypeService;
    }
    
    /**
     * The iLPStatementBankTypesGet method is used to retrieve a full list of all the ILPStatementBankTypeDto objects
     *
     * @return A ResponseEntity with the corresponding list of ILPStatementBankTypeDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of ILPStatementBankType entities", notes = "A GET request to the ILPStatementBankTypes endpoint returns an array of all the iLPStatementBankTypes in the system.", response = StatementBankTypeDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of iLPStatementBankTypes")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StatementBankTypeDto>> getAll() throws NotFoundException {
        LOGGER.info("** ILPStatementBankTypesApi - iLPStatementBankTypesGet");
        List<StatementBankType> iLPStatementBankTypes = iLPStatementBankTypeService.findAll();
        return new ResponseEntity<List<StatementBankTypeDto>>(StatementBankTypeDto.mapFromList(iLPStatementBankTypes), HttpStatus.OK);
    }
    
    
    
    /**
     * The iLPStatementBankTypesILPStatementBankTypeIdGet method is used to retrieve an instance of a ILPStatementBankTypeDto object as identified by the iLPStatementBankTypeId provided
     *
     * @param iLPStatementBankTypeId the iLPStatementBankType ID for the ILPStatementBankType object retrieve
     * @return A ResponseEntity with the corresponding ILPStatementBankTypeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a ILPStatementBankType identified by the iLPStatementBankTypeId", notes = "A getGET request to the ILPStatementBankType instance endpoint will retrieve an instance of a ILPStatementBankType entity as identified by the iLPStatementBankTypeId provided in the URI.", response = StatementBankTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the ILPStatementBankType as identified by the iLPStatementBankTypeId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{iLPStatementBankTypeId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StatementBankTypeDto> getById(
            @ApiParam(value = "The unique ID of the ILPStatementBankType to retrieve", required = true)
            @PathVariable("iLPStatementBankTypeId") Integer iLPStatementBankTypeId
    ) throws NotFoundException {
        LOGGER.info("** ILPStatementBankTypesApi - iLPStatementBankTypesILPStatementBankTypeIdGet");
        StatementBankType iLPStatementBankType = iLPStatementBankTypeService.findById(iLPStatementBankTypeId);
        if (iLPStatementBankType == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<StatementBankTypeDto>(StatementBankTypeDto.mapFromEntity(iLPStatementBankType), HttpStatus.OK);
    }
    
    /**
     * The iLPStatementBankTypesILPStatementBankTypeIdGet method is used to retrieve an instance of a StatementBankDto object as identified by the iLPStatementBankTypeId provided
     *
     * @param iLPStatementBankTypeId the iLPStatementBankType ID for the ILPStatementBankType object retrieve
     * @return A ResponseEntity with the corresponding ILPStatementBankTypeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a ILPStatementBankType identified by the iLPStatementBankTypeId", notes = "A getGET request to the ILPStatementBankType instance endpoint will retrieve an instance of a ILPStatementBankType entity as identified by the iLPStatementBankTypeId provided in the URI.", response = StatementBankDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the ILPStatementBankType as identified by the iLPStatementBankTypeId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{iLPStatementBankTypeId}/statements", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StatementBankDto>> getAllStatements(
            @ApiParam(value = "The unique ID of the ILPStatementBankType to retrieve", required = true)
            @PathVariable("iLPStatementBankTypeId") Integer iLPStatementBankTypeId
    ) throws NotFoundException {
        LOGGER.info("** ILPStatementBankTypesApi - iLPStatementBankTypesILPStatementBankTypeIdGet");
        List<StatementBank> statementBanks = statementBankService.findByILPStatementBankType(iLPStatementBankTypeId);
        if (statementBanks == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<List<StatementBankDto>>(StatementBankDto.mapFromList(statementBanks), HttpStatus.OK);
    }
    
    /**
     * This method is used to create a new instance of a StatementBankType from the supplied StatementBankTypeDto
     *
     * @param statementBank the StatementBankTypeDto to use to create the new StatementBankType object
     * @return A ResponseEntity with the newly created StatementBankType object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new StatementBankType entity", notes = "A POST request to the StatementBankTypes endpoint with a StatementBankType object in the request body will create a new StatementBankType entity in the database.", response = StatementBankTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created StatementBankType entity including the statementBankId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StatementBankTypeDto> create(
            @ApiParam(value = "The StatementBankType object to be created, without the statementBankId fields", required = true)
            @RequestBody @Valid StatementBankTypeDto statementBank
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StatementBankTypesApi - statementBanksPOST");
        if (statementBank.id == null) {
            throw new InvalidDataException(400, "ID field should be provided when creating")
        }
        StatementBankType statementBankSaved = iLPStatementBankTypeService.createFromDto(statementBank)
        return new ResponseEntity<StatementBankTypeDto>(StatementBankTypeDto.mapFromEntity(statementBankSaved), HttpStatus.CREATED);
    }
    /**
     * The iLPStatementBankTypesILPStatementBankTypeIdPut is used to update
     *
     * @param iLPStatementBankTypeId the iLPStatementBankType ID for the ILPStatementBankType object to update
     * @param iLPStatementBankType the new data for the ILPStatementBankType object
     * @return the newly updated ILPStatementBankTypeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a ILPStatementBankType entity", notes = "A PUT request to the ILPStatementBankType instance endpoint with a ILPStatementBankType object in the request body will update an existing ILPStatementBankType entity in the database.", response = StatementBankTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated ILPStatementBankType object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{iLPStatementBankTypeId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StatementBankTypeDto> update(
            @ApiParam(value = "The unique ID of the ILPStatementBankType to retrieve", required = true)
            @PathVariable("iLPStatementBankTypeId") Integer iLPStatementBankTypeId,
            @ApiParam(value = "The ILPStatementBankType object to be created, without the iLPStatementBankTypeId fields", required = true)
            @RequestBody StatementBankTypeDto iLPStatementBankType
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** ILPStatementBankTypesApi - iLPStatementBankTypesPUT");
        if (iLPStatementBankTypeId != iLPStatementBankType.id) {
            throw new InvalidDataException()
        }
        StatementBankType iLPStatementBankTypeSaved = iLPStatementBankTypeService.updateFromDto(iLPStatementBankType)
        return new ResponseEntity<StatementBankTypeDto>(StatementBankTypeDto.mapFromEntity(iLPStatementBankTypeSaved), HttpStatus.OK);
    }
}
