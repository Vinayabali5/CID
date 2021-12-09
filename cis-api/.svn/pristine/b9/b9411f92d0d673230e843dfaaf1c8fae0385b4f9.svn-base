package uk.ac.reigate.api.lookup;

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
import uk.ac.reigate.domain.lookup.LegalSex
import uk.ac.reigate.dto.lookup.LegalSexDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.lookup.LegalSexService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/legal-sex", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/legal-sex", description = "the legalSex API")
public class LegalSexApi implements ICoreDataApi<LegalSexDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(LegalSexApi.class);
    
    @Autowired
    private final LegalSexService legalSexService;
    
    /**
     * Default NoArgs constructor
     */
    LegalSexApi() {}
    
    /**
     * Autowired constructor
     */
    LegalSexApi(LegalSexService legalSexService) {
        this.legalSexService = legalSexService;
    }
    
    /**
     * This method is used to retrieve a full list of all the LegalSexDto objects
     *
     * @return A ResponseEntity with the corresponding list of LegalSexDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of LegalSex entities", notes = "A GET request to the LegalSexs endpoint returns an array of all the legalSexs in the system.", response = LegalSexDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of legalSexs")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<LegalSexDto>> getAll() throws NotFoundException {
        LOGGER.info("** LegalSexsApi - legalSexsGet");
        List<LegalSex> legalSexs = legalSexService.findAll();
        return new ResponseEntity<List<LegalSexDto>>(LegalSexDto.mapFromList(legalSexs), HttpStatus.OK);
    }
    
    /**
     * This method is used to retrieve an instance of a LegalSexDto object as identified by the legalSexId provided
     *
     * @param legalSexId the legalSex ID for the LegalSex object retrieve
     * @return A ResponseEntity with the corresponding LegalSexDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a LegalSex identified by the legalSexId", notes = "A getGET request to the LegalSex instance endpoint will retrieve an instance of a LegalSex entity as identified by the legalSexId provided in the URI.", response = LegalSexDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the LegalSex as identified by the legalSexId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{legalSexId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<LegalSexDto> getById(
            @ApiParam(value = "The unique ID of the LegalSex to retrieve", required = true)
            @PathVariable("legalSexId") Integer legalSexId
    ) throws NotFoundException {
        LOGGER.info("** LegalSexsApi - legalSexsLegalSexIdGet");
        LegalSex legalSex = legalSexService.findById(legalSexId);
        if (legalSex == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<LegalSexDto>(LegalSexDto.mapFromEntity(legalSex), HttpStatus.OK);
    }
    
    /**
     * This method is used to create a new instance of a LegalSex from the supplied LegalSexDto
     *
     * @param legalSex the LegalSexDto to use to create the new LegalSex object
     * @return A ResponseEntity with the newly created LegalSex object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new LegalSex entity", notes = "A POST request to the LegalSexs endpoint with a LegalSex object in the request body will create a new LegalSex entity in the database.", response = LegalSexDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created LegalSex entity including the legalSexId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<LegalSexDto> create(
            @ApiParam(value = "The LegalSex object to be created, without the legalSexId fields", required = true)
            @RequestBody @Valid LegalSexDto legalSex
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** LegalSexsApi - legalSexsPOST");
        if (legalSex.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        LegalSex legalSexSaved = legalSexService.createFromDto(legalSex)
        return new ResponseEntity<LegalSexDto>(LegalSexDto.mapFromEntity(legalSexSaved), HttpStatus.CREATED);
    }
    
    /**
     * The legalSexsLegalSexIdPut is used to update
     * 
     * @param legalSexId the legalSex ID for the LegalSex object to update
     * @param legalSex the new data for the LegalSex object
     * @return the newly updated LegalSexDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a LegalSex entity", notes = "A PUT request to the LegalSex instance endpoint with a LegalSex object in the request body will update an existing LegalSex entity in the database.", response = LegalSexDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated LegalSex object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{legalSexId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<LegalSexDto> update(
            @ApiParam(value = "The unique ID of the LegalSex to retrieve", required = true)
            @PathVariable("legalSexId") Integer legalSexId,
            @ApiParam(value = "The LegalSex object to be created, without the legalSexId fields", required = true)
            @RequestBody LegalSexDto legalSex
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** LegalSexsApi - legalSexsPUT");
        if (legalSexId != legalSex.id) {
            throw new InvalidDataException()
        }
        LegalSex legalSexSaved = legalSexService.updateFromDto(legalSex)
        return new ResponseEntity<LegalSexDto>(LegalSexDto.mapFromEntity(legalSexSaved), HttpStatus.OK);
    }
}
