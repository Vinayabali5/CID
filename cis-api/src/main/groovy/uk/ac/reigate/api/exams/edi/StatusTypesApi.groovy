package uk.ac.reigate.api.exams.edi;

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

import uk.ac.reigate.domain.exams.edi.StatusType
import uk.ac.reigate.dto.exams.edi.StatusTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.lookup.StatusTypeService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

@Controller
@RequestMapping(value = "/statusTypes", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/statusTypes", description = "the statusTypes API")
public class StatusTypesApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StatusTypesApi.class);
    
    @Autowired
    private final StatusTypeService statusTypeService;
    
    /**
     * Default NoArgs constructor
     */
    StatusTypesApi() {}
    
    /**
     * Autowired constructor
     */
    StatusTypesApi(StatusTypeService statusTypeService) {
        this.statusTypeService = statusTypeService;
    }
    
    /**
     * The statusTypesGet method is used to retrieve a full list of all the StatusTypeDto objects
     *
     * @return A ResponseEntity with the corresponding list of StatusTypeDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StatusType entities", notes = "A GET request to the StatusTypes endpoint returns an array of all the statusTypes in the system.", response = StatusTypeDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of statusTypes")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StatusTypeDto>> getAll() throws NotFoundException {
        LOGGER.info("** StatusTypesApi - statusTypesGet");
        List<StatusType> statusTypes = statusTypeService.findAll();
        return new ResponseEntity<List<StatusTypeDto>>(StatusTypeDto.mapFromList(statusTypes), HttpStatus.OK);
    }
    
    /**
     * The statusTypesPost method is used to create a new instance of a StatusType from the supplied StatusTypeDto
     *
     * @param statusType the StatusTypeDto to use to create the new StatusType object
     * @return A ResponseEntity with the newly created StatusType object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new StatusType entity", notes = "A POST request to the StatusTypes endpoint with a StatusType object in the request body will create a new StatusType entity in the database.", response = StatusTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created StatusType entity including the statusTypeId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StatusTypeDto> create(
            @ApiParam(value = "The StatusType object to be created, without the statusTypeId fields", required = true)
            @RequestBody @Valid StatusTypeDto statusType
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StatusTypesApi - statusTypesPOST");
        if (statusType.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        StatusType statusTypeSaved = statusTypeService.createFromDto(statusType)
        return new ResponseEntity<StatusTypeDto>(StatusTypeDto.mapFromEntity(statusTypeSaved), HttpStatus.CREATED);
    }
    
    /**
     * The statusTypesStatusTypeIdGet method is used to retrieve an instance of a StatusTypeDto object as identified by the statusTypeId provided
     *
     * @param statusTypeId the statusType ID for the StatusType object retrieve
     * @return A ResponseEntity with the corresponding StatusTypeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StatusType identified by the statusTypeId", notes = "A getGET request to the StatusType instance endpoint will retrieve an instance of a StatusType entity as identified by the statusTypeId provided in the URI.", response = StatusTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StatusType as identified by the statusTypeId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{statusTypeId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StatusTypeDto> getById(
            @ApiParam(value = "The unique ID of the StatusType to retrieve", required = true)
            @PathVariable("statusTypeId") Integer statusTypeId
    ) throws NotFoundException {
        LOGGER.info("** StatusTypesApi - statusTypesStatusTypeIdGet");
        StatusType statusType = statusTypeService.findById(statusTypeId);
        if (statusType == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<StatusTypeDto>(StatusTypeDto.mapFromEntity(statusType), HttpStatus.OK);
    }
    
    /**
     * The statusTypesStatusTypeIdPut is used to update
     *
     * @param statusTypeId the statusType ID for the StatusType object to update
     * @param statusType the new data for the StatusType object
     * @return the newly updated StatusTypeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a StatusType entity", notes = "A PUT request to the StatusType instance endpoint with a StatusType object in the request body will update an existing StatusType entity in the database.", response = StatusTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated StatusType object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{statusTypeId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StatusTypeDto> update(
            @ApiParam(value = "The unique ID of the StatusType to retrieve", required = true)
            @PathVariable("statusTypeId") Integer statusTypeId,
            @ApiParam(value = "The StatusType object to be created, without the statusTypeId fields", required = true)
            @RequestBody StatusTypeDto statusType
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StatusTypesApi - statusTypesPUT");
        if (statusTypeId != statusType.id) {
            throw new InvalidDataException()
        }
        StatusType statusTypeSaved = statusTypeService.updateFromDto(statusType)
        return new ResponseEntity<StatusTypeDto>(StatusTypeDto.mapFromEntity(statusTypeSaved), HttpStatus.OK);
    }
}
