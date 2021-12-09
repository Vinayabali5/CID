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
import uk.ac.reigate.domain.staff.StaffPayment
import uk.ac.reigate.dto.staff.StaffPaymentDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.staff.StaffPaymentService


@Controller
@RequestMapping(value = "/staff-payments", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/staff-payments", description = "the staffPayments API")
public class StaffPaymentsApi  {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StaffPaymentsApi.class);
    
    @Autowired
    private final StaffPaymentService staffPaymentService;
    
    /**
     * Default NoArgs constructor
     */
    StaffPaymentsApi() {}
    
    /**
     * Autowired constructor
     */
    StaffPaymentsApi(StaffPaymentService staffPaymentService) {
        this.staffPaymentService = staffPaymentService;
    }
    
    /**
     * The staffPaymentsGet method is used to retrieve a full list of all the StaffPaymentDto objects
     *
     * @return A ResponseEntity with the corresponding list of StaffPaymentDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StaffPayment entities", notes = "A GET request to the Nationalities endpoint returns an array of all the staffPayments in the system.", response = StaffPaymentDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of staffPayments")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StaffPaymentDto>> getAll() throws NotFoundException {
        LOGGER.info("** StaffPaymentsApi - staffPaymentsGet");
        List<StaffPayment> staffPayments = staffPaymentService.findAll();
        return new ResponseEntity<List<StaffPaymentDto>>(StaffPaymentDto.mapFromList(staffPayments), HttpStatus.OK);
    }
    
    /**
     * The staffPaymentsStaffPaymentIdGet method is used to retrieve an instance of a StaffPaymentDto object as identified by the staffPaymentId provided
     *
     * @param staffPaymentId the staffPayment ID for the StaffPayment object retrieve
     * @return A ResponseEntity with the corresponding StaffPaymentDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StaffPayment identified by the staffPaymentId", notes = "A getGET request to the StaffPayment instance endpoint will retrieve an instance of a StaffPayment entity as identified by the staffPaymentId provided in the URI.", response = StaffPaymentDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StaffPayment as identified by the staffPaymentId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{staffPaymentId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StaffPaymentDto> getById(
            @ApiParam(value = "The unique ID of the StaffPayment to retrieve", required = true)
            @PathVariable("staffPaymentId") Integer staffPaymentId
    ) throws NotFoundException {
        LOGGER.info("** StaffPaymentsApi - staffPaymentsStaffPaymentIdGet");
        StaffPayment staffPayment = staffPaymentService.findById(staffPaymentId);
        if (staffPayment == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<StaffPaymentDto>(StaffPaymentDto.mapFromEntity(staffPayment), HttpStatus.OK);
    }
    
    @RequestMapping(value = "staff/{staffId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StaffPaymentDto>> getByStaffId(
            @ApiParam(value = "The unique ID of the Staff to retrieve", required = true)
            @PathVariable("staffId") Integer staffId
    ) throws NotFoundException {
        LOGGER.info("** StaffPaymentsApi - staffPaymentsStaffPaymentIdGet");
        List<StaffPayment> staffPayments = staffPaymentService.findByStaffId(staffId);
        if (staffPayments == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<List<StaffPaymentDto>>(StaffPaymentDto.mapFromList(staffPayments), HttpStatus.OK);
    }
}
