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
import uk.ac.reigate.domain.staff.PaymentReason
import uk.ac.reigate.dto.staff.PaymentReasonDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.staff.PaymentReasonService


@Controller
@RequestMapping(value = "/payment-reasons", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/payment-reasons", description = "the paymentReasons API")
public class PaymentReasonsApi implements ICoreDataBaseApi<PaymentReasonDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentReasonsApi.class);
    
    @Autowired
    private final PaymentReasonService paymentReasonService;
    
    /**
     * Default NoArgs constructor
     */
    PaymentReasonsApi() {}
    
    /**
     * Autowired constructor
     */
    PaymentReasonsApi(PaymentReasonService paymentReasonService) {
        this.paymentReasonService = paymentReasonService;
    }
    
    /**
     * The paymentReasonsGet method is used to retrieve a full list of all the PaymentReasonDto objects
     *
     * @return A ResponseEntity with the corresponding list of PaymentReasonDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of PaymentReason entities", notes = "A GET request to the PaymentReasons endpoint returns an array of all the paymentReasons in the system.", response = PaymentReasonDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of paymentReasons")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<PaymentReasonDto>> getAll() throws NotFoundException {
        LOGGER.info("** PaymentReasonsApi - paymentReasonsGet");
        List<PaymentReason> paymentReasons = paymentReasonService.findAll();
        return new ResponseEntity<List<PaymentReasonDto>>(PaymentReasonDto.mapFromList(paymentReasons), HttpStatus.OK);
    }
    
    /**
     * The paymentReasonsPost method is used to create a new instance of a PaymentReason from the supplied PaymentReasonDto
     *
     * @param paymentReason the PaymentReasonDto to use to create the new PaymentReason object
     * @return A ResponseEntity with the newly created PaymentReason object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new PaymentReason entity", notes = "A POST request to the PaymentReasons endpoint with a PaymentReason object in the request body will create a new PaymentReason entity in the database.", response = PaymentReasonDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created PaymentReason entity including the paymentReasonId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<PaymentReasonDto> create(
            @ApiParam(value = "The PaymentReason object to be created, without the paymentReasonId fields", required = true)
            @RequestBody @Valid PaymentReasonDto paymentReasonDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** PaymentReasonsApi - paymentReasonsPOST");
        if (paymentReasonDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        PaymentReason paymentReason = paymentReasonService.createFromDto(paymentReasonDto)
        return new ResponseEntity<PaymentReasonDto>(PaymentReasonDto.mapFromEntity(paymentReason), HttpStatus.CREATED);
    }
    
    /**
     * The paymentReasonsPaymentReasonIdGet method is used to retrieve an instance of a PaymentReasonDto object as identified by the paymentReasonId provided
     *
     * @param paymentReasonId the paymentReason ID for the PaymentReason object retrieve
     * @return A ResponseEntity with the corresponding PaymentReasonDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a PaymentReason identified by the paymentReasonId", notes = "A getGET request to the PaymentReason instance endpoint will retrieve an instance of a PaymentReason entity as identified by the paymentReasonId provided in the URI.", response = PaymentReasonDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the PaymentReason as identified by the paymentReasonId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{paymentReasonId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<PaymentReasonDto> getById(
            @ApiParam(value = "The unique ID of the PaymentReason to retrieve", required = true)
            @PathVariable("paymentReasonId") Integer paymentReasonId
    ) throws NotFoundException {
        LOGGER.info("** PaymentReasonsApi - paymentReasonsPaymentReasonIdGet");
        PaymentReason paymentReason = paymentReasonService.findById(paymentReasonId);
        if (paymentReason == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<PaymentReasonDto>(PaymentReasonDto.mapFromEntity(paymentReason), HttpStatus.OK);
    }
    
    /**
     * The paymentReasonsPaymentReasonIdPut is used to update
     *
     * @param paymentReasonId the paymentReason ID for the PaymentReason object to update
     * @param paymentReason the new data for the PaymentReason object
     * @return the newly updated PaymentReasonDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a PaymentReason entity", notes = "A PUT request to the PaymentReason instance endpoint with a PaymentReason object in the request body will update an existing PaymentReason entity in the database.", response = PaymentReasonDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated PaymentReason object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{paymentReasonId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<PaymentReasonDto> update(
            @ApiParam(value = "The unique ID of the PaymentReason to retrieve", required = true)
            @PathVariable("paymentReasonId") Integer paymentReasonId,
            @ApiParam(value = "The PaymentReason object to be created, without the paymentReasonId fields", required = true)
            @RequestBody PaymentReasonDto paymentReasonDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** PaymentReasonsApi - paymentReasonsPUT");
        if (paymentReasonId != paymentReasonDto.id) {
            throw new InvalidDataException()
        }
        PaymentReason paymentReason = paymentReasonService.updateFromDto(paymentReasonDto)
        return new ResponseEntity<PaymentReasonDto>(PaymentReasonDto.mapFromEntity(paymentReason), HttpStatus.OK);
    }
}
