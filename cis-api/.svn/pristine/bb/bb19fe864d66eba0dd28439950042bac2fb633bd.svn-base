package uk.ac.reigate.api.staff;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import uk.ac.reigate.api.ICoreDataBaseApi
import uk.ac.reigate.domain.staffsignin.StaffSignin
import uk.ac.reigate.dto.staffsignin.StaffSignInDto
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.staffsignin.StaffSigninService


@Controller
@RequestMapping(value = "/staff-signin", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/staff-signin", description = "the staffSignins API")
public class StaffSigninApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StaffSigninApi.class);
    
    @Autowired
    private final StaffSigninService staffSigninService;
    
    /**
     * Default NoArgs constructor
     */
    StaffSigninApi() {}
    
    /**
     * Autowired constructor
     */
    StaffSigninApi(StaffSigninService staffSigninService) {
        this.staffSigninService = staffSigninService;
    }
    
    /**
     * This method is used to retrieve a full list of all the StaffSigninDto objects
     *
     * @return A ResponseEntity with the corresponding list of StaffSigninDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StaffSignin entities", notes = "A GET request to the StaffSignins endpoint returns an array of all the staffSignins in the system.", response = StaffSignInDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of staffSignins")
    ])
    @RequestMapping(value = "staff/{staffId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StaffSignInDto>> getStaffId(
            @ApiParam(value = "The unique ID of the StaffSignin to retrieve", required = true)
            @PathVariable("staffId") Integer staffId
    ) throws NotFoundException {
        LOGGER.info("** StaffSigninsApi - staffSigninsStaffSigninIdGet");
        List<StaffSignin> staffSigninList = staffSigninService.findByStaff(staffId)
        if (staffSigninList == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<List<StaffSignInDto>>(StaffSignInDto.mapFromList(staffSigninList), HttpStatus.OK);
    }
    
    /**
     * This method is used to retrieve an instance of a StaffSigninDto object as identified by the staffSigninId provided
     *
     * @param staffSigninId the staffSignin ID for the StaffSignin object retrieve
     * @return A ResponseEntity with the corresponding StaffSigninDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StaffSignin identified by the staffSigninId", notes = "A getGET request to the StaffSignin instance endpoint will retrieve an instance of a StaffSignin entity as identified by the staffSigninId provided in the URI.", response = StaffSignInDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StaffSignin as identified by the staffSigninId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{staffSigninId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StaffSignInDto> getById(
            @ApiParam(value = "The unique ID of the StaffSignin to retrieve", required = true)
            @PathVariable("staffSigninId") Integer staffSigninId
    ) throws NotFoundException {
        LOGGER.info("** StaffSigninsApi - staffSigninsStaffSigninIdGet");
        StaffSignin staffSignin = staffSigninService.findById(staffSigninId);
        if (staffSignin == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<StaffSignInDto>(StaffSignInDto.mapFromEntity(staffSignin), HttpStatus.OK);
    }
}
