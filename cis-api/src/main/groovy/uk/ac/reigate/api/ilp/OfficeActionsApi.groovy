package uk.ac.reigate.api.ilp

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
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import uk.ac.reigate.domain.ilp.OfficeAction
import uk.ac.reigate.dto.ilp.OfficeActionDto
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.ilp.OfficeActionService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

@Controller
@RequestMapping(value = "/office-actions", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/office-actions")
class OfficeActionsApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OfficeActionsApi.class);
    
    @Autowired
    private final OfficeActionService officeActionService;
    
    /**
     * Default NoArgs constructor
     */
    OfficeActionsApi() {}
    
    /**
     * Autowired constructor
     */
    OfficeActionsApi(OfficeActionService officeActionService) {
        this.officeActionService = officeActionService;
    }
    
    /**
     * The officeActionsGet method is used to retrieve a full list of all the OfficeActionDto objects
     *
     * @return A ResponseEntity with the corresponding list of OfficeActionDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of OfficeAction entities", notes = "A GET request to the OfficeActions endpoint returns an array of all the officeActions in the system.", response = OfficeActionDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of officeActions")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<OfficeActionDto>> getAll() throws NotFoundException {
        LOGGER.info("** OfficeActionsApi - officeActionsGet");
        List<OfficeAction> officeActions = officeActionService.findAll();
        return new ResponseEntity<List<OfficeActionDto>>(OfficeActionDto.mapFromList(officeActions), HttpStatus.OK);
    }
    
    /**
     * The officeActionsOfficeActionIdGet method is used to retrieve an instance of a OfficeActionDto object as identified by the officeActionId provided
     *
     * @param officeActionId the officeAction ID for the OfficeAction object retrieve
     * @return A ResponseEntity with the corresponding OfficeActionDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a OfficeAction identified by the officeActionId", notes = "A getGET request to the OfficeAction instance endpoint will retrieve an instance of a OfficeAction entity as identified by the officeActionId provided in the URI.", response = OfficeActionDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the OfficeAction as identified by the officeActionId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{officeActionId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<OfficeActionDto> getById(
            @ApiParam(value = "The unique ID of the OfficeAction to retrieve", required = true)
            @PathVariable("officeActionId") Integer officeActionId
    ) throws NotFoundException {
        LOGGER.info("** OfficeActionsApi - officeActionsOfficeActionIdGet");
        OfficeAction officeAction = officeActionService.findById(officeActionId);
        if (officeAction == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<OfficeActionDto>(OfficeActionDto.mapFromEntity(officeAction), HttpStatus.OK);
    }
}
