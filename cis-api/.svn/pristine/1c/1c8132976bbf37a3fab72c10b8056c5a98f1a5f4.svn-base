package uk.ac.reigate.api.risk_assessment;

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
import uk.ac.reigate.domain.risk_assessment.RiskLevel
import uk.ac.reigate.dto.risk_assessment.RiskLevelDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.risk_assessment.RiskLevelService

@Controller
@RequestMapping(value = "/risk-levels", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/risk-levels", description = "the riskLevels API")
public class RiskLevelsApi implements ICoreDataApi<RiskLevelDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RiskLevelsApi.class);
    
    @Autowired
    private final RiskLevelService riskLevelService;
    
    /**
     * Default NoArgs constructor
     */
    RiskLevelsApi() {}
    
    /**
     * Autowired constructor
     */
    RiskLevelsApi(RiskLevelService riskLevelService) {
        this.riskLevelService = riskLevelService;
    }
    
    /**
     * This method is used to retrieve a full list of all the RiskLevelDto objects
     *
     * @return A ResponseEntity with the corresponding list of RiskLevelDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of RiskLevel entities", notes = "A GET request to the RiskLevels endpoint returns an array of all the riskLevels in the system.", response = RiskLevelDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of riskLevels")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<RiskLevelDto>> getAll() throws NotFoundException {
        LOGGER.info("** RiskLevelsApi - riskLevelsGet");
        List<RiskLevel> riskLevels = riskLevelService.findAll();
        return new ResponseEntity<List<RiskLevelDto>>(RiskLevelDto.mapFromList(riskLevels), HttpStatus.OK);
    }
    
    /**
     * This method is used to retrieve an instance of a RiskLevelDto object as identified by the riskLevelId provided
     *
     * @param riskLevelId the riskLevel ID for the RiskLevel object retrieve
     * @return A ResponseEntity with the corresponding RiskLevelDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a RiskLevel identified by the riskLevelId", notes = "A getGET request to the RiskLevel instance endpoint will retrieve an instance of a RiskLevel entity as identified by the riskLevelId provided in the URI.", response = RiskLevelDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the RiskLevel as identified by the riskLevelId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{riskLevelId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<RiskLevelDto> getById(
            @ApiParam(value = "The unique ID of the RiskLevel to retrieve", required = true)
            @PathVariable("riskLevelId") Integer riskLevelId
    ) throws NotFoundException {
        LOGGER.info("** RiskLevelsApi - riskLevelsRiskLevelIdGet");
        RiskLevel riskLevel = riskLevelService.findById(riskLevelId);
        if (riskLevel == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<RiskLevelDto>(RiskLevelDto.mapFromEntity(riskLevel), HttpStatus.OK);
    }
    
    /**
     * This method is used to create a new instance of a RiskLevel from the supplied RiskLevelDto
     *
     * @param riskLevel the RiskLevelDto to use to create the new RiskLevel object
     * @return A ResponseEntity with the newly created RiskLevel object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new RiskLevel entity", notes = "A POST request to the RiskLevels endpoint with a RiskLevel object in the request body will create a new RiskLevel entity in the database.", response = RiskLevelDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created RiskLevel entity including the riskLevelId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<RiskLevelDto> create(
            @ApiParam(value = "The RiskLevel object to be created, without the riskLevelId fields", required = true)
            @RequestBody @Valid RiskLevelDto riskLevel
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** RiskLevelsApi - riskLevelsPOST");
        if (riskLevel.id == null) {
            throw new InvalidDataException(400, "ID field should be provided when creating")
        }
        RiskLevel riskLevelSaved = riskLevelService.createFromDto(riskLevel)
        return new ResponseEntity<RiskLevelDto>(RiskLevelDto.mapFromEntity(riskLevelSaved), HttpStatus.CREATED);
    }
    
    /**
     * The riskLevelsRiskLevelIdPut is used to update
     * 
     * @param riskLevelId the riskLevel ID for the RiskLevel object to update
     * @param riskLevel the new data for the RiskLevel object
     * @return the newly updated RiskLevelDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a RiskLevel entity", notes = "A PUT request to the RiskLevel instance endpoint with a RiskLevel object in the request body will update an existing RiskLevel entity in the database.", response = RiskLevelDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated RiskLevel object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{riskLevelId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<RiskLevelDto> update(
            @ApiParam(value = "The unique ID of the RiskLevel to retrieve", required = true)
            @PathVariable("riskLevelId") Integer riskLevelId,
            @ApiParam(value = "The RiskLevel object to be created, without the riskLevelId fields", required = true)
            @RequestBody RiskLevelDto riskLevel
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** RiskLevelsApi - riskLevelsPUT");
        if (riskLevelId != riskLevel.id) {
            throw new InvalidDataException()
        }
        RiskLevel riskLevelSaved = riskLevelService.updateFromDto(riskLevel)
        return new ResponseEntity<RiskLevelDto>(RiskLevelDto.mapFromEntity(riskLevelSaved), HttpStatus.OK);
    }
}
