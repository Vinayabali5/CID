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

import uk.ac.reigate.domain.ilr.LLDDHealthProblemCategory
import uk.ac.reigate.domain.learning_support.ReferralReason
import uk.ac.reigate.dto.ReferralReasonDto
import uk.ac.reigate.exceptions.DataAlreadyExistsException
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.LLDDHealthProblemCategoryService
import uk.ac.reigate.services.ReferralReasonService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/referralReasons", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/referralReasons", description = "the referralReasons API")
public class ReferralReasonsApi implements ICoreDataApi<ReferralReasonDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ReferralReasonsApi.class);
    
    @Autowired
    private final ReferralReasonService referralReasonService;
    
    /** 
     * Default NoArgs constructor
     */
    ReferralReasonsApi() {}
    
    /**
     * Autowired constructor
     */
    ReferralReasonsApi(ReferralReasonService referralReasonService) {
        this.referralReasonService = referralReasonService;
    }
    
    /**
     * The referralReasonsGet method is used to retrieve a full list of all the ReferralReasonDto objects
     *
     * @return A ResponseEntity with the corresponding list of ReferralReasonDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of ReferralReason entities", notes = "A GET request to the ReferralReasons endpoint returns an array of all the referralReasons in the system.", response = ReferralReasonDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of referralReasons")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<ReferralReasonDto>> getAll() throws NotFoundException {
        LOGGER.info("** ReferralReasonsApi - referralReasonsGet");
        List<ReferralReason> referralReasons = referralReasonService.findAll();
        return new ResponseEntity<List<ReferralReasonDto>>(ReferralReasonDto.mapFromList(referralReasons), HttpStatus.OK);
    }
    
    /**
     * The referralReasonsPost method is used to create a new instance of a ReferralReason from the supplied ReferralReasonDto
     *
     * @param referralReason the ReferralReasonDto to use to create the new ReferralReason object
     * @return A ResponseEntity with the newly created ReferralReason object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new ReferralReason entity", notes = "A POST request to the ReferralReasons endpoint with a ReferralReason object in the request body will create a new ReferralReason entity in the database.", response = ReferralReasonDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created ReferralReason entity including the referralReasonId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<ReferralReasonDto> create(
            @ApiParam(value = "The ReferralReason object to be created, without the referralReasonId fields", required = true)
            @RequestBody @Valid ReferralReasonDto referralReason
    ) throws NotFoundException, InvalidDataException, DataAlreadyExistsException {
        LOGGER.info("** ReferralReasonsApi - referralReasonsPOST");
        if (referralReason.id == null) {
            throw new NotFoundException()
        }
        ReferralReason referralReason1 = referralReasonService.findById(referralReason.id);
        if (referralReason1 != null) {
            throw new DataAlreadyExistsException("An ReferralReason already exists with the supplied ID.");
        }
        ReferralReason referralReasonSaved = referralReasonService.createFromDto(referralReason)
        return new ResponseEntity<ReferralReasonDto>(ReferralReasonDto.mapFromEntity(referralReasonSaved), HttpStatus.CREATED);
    }
    
    /**
     * The referralReasonsReferralReasonIdGet method is used to retrieve an instance of a ReferralReasonDto object as identified by the referralReasonId provided
     *
     * @param referralReasonId the referralReason ID for the ReferralReason object retrieve
     * @return A ResponseEntity with the corresponding ReferralReasonDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a ReferralReason identified by the referralReasonId", notes = "A getGET request to the ReferralReason instance endpoint will retrieve an instance of a ReferralReason entity as identified by the referralReasonId provided in the URI.", response = ReferralReasonDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the ReferralReason as identified by the referralReasonId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{referralReasonId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<ReferralReasonDto> getById(
            @ApiParam(value = "The unique ID of the ReferralReason to retrieve", required = true)
            @PathVariable("referralReasonId") Integer referralReasonId
    ) throws NotFoundException {
        LOGGER.info("** ReferralReasonsApi - referralReasonsReferralReasonIdGet");
        ReferralReason referralReason = referralReasonService.findById(referralReasonId);
        if (referralReason == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<ReferralReasonDto>(ReferralReasonDto.mapFromEntity(referralReason), HttpStatus.OK);
    }
    
    /**
     * The referralReasonsReferralReasonIdPut is used to update
     *
     * @param referralReasonId the referralReason ID for the ReferralReason object to update
     * @param referralReason the new data for the ReferralReason object
     * @return the newly updated ReferralReasonDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a ReferralReason entity", notes = "A PUT request to the ReferralReason instance endpoint with a ReferralReason object in the request body will update an existing ReferralReason entity in the database.", response = ReferralReasonDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated ReferralReason object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{referralReasonId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<ReferralReasonDto> update(
            @ApiParam(value = "The unique ID of the ReferralReason to retrieve", required = true)
            @PathVariable("referralReasonId") Integer referralReasonId,
            @ApiParam(value = "The ReferralReason object to be created, without the referralReasonId fields", required = true)
            @RequestBody ReferralReasonDto referralReason
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** ReferralReasonsApi - referralReasonsPUT");
        if (referralReasonId != referralReason.id) {
            throw new InvalidDataException()
        }
        ReferralReason referralReasonSaved = referralReasonService.updateFromDto(referralReason)
        return new ResponseEntity<ReferralReasonDto>(ReferralReasonDto.mapFromEntity(referralReasonSaved), HttpStatus.OK);
    }
}
