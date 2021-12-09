package uk.ac.reigate.api;

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
import uk.ac.reigate.domain.academic.WorkPlacementMode
import uk.ac.reigate.dto.WorkPlacementModeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.WorkPlacementModeService


@Controller
@RequestMapping(value = "/work-placement-modes", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/work-placement-modes", description = "the workPlacementModes API")
public class WorkPlacementModesApi implements ICoreDataBaseApi<WorkPlacementModeDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkPlacementModesApi.class);
    
    @Autowired
    private final WorkPlacementModeService workPlacementModeService;
    
    /**
     * Default NoArgs constructor
     */
    WorkPlacementModesApi() {}
    
    /**
     * Autowired constructor
     */
    WorkPlacementModesApi(WorkPlacementModeService workPlacementModeService) {
        this.workPlacementModeService = workPlacementModeService;
    }
    
    /**
     * This method is used to retrieve a full list of all the WorkPlacementModeDto objects
     *
     * @return A ResponseEntity with the corresponding list of WorkPlacementModeDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of WorkPlacementMode entities", notes = "A GET request to the WorkPlacementModes endpoint returns an array of all the workPlacementModes in the system.", response = WorkPlacementModeDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of workPlacementModes")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<WorkPlacementModeDto>> getAll() throws NotFoundException {
        LOGGER.info("** WorkPlacementModesApi - workPlacementModesGet");
        List<WorkPlacementMode> workPlacementModes = workPlacementModeService.findAll();
        return new ResponseEntity<List<WorkPlacementModeDto>>(WorkPlacementModeDto.mapFromList(workPlacementModes), HttpStatus.OK);
    }
    
    /**
     * This method is used to retrieve an instance of a WorkPlacementModeDto object as identified by the workPlacementModeId provided
     *
     * @param workPlacementModeId the workPlacementMode ID for the WorkPlacementMode object retrieve
     * @return A ResponseEntity with the corresponding WorkPlacementModeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a WorkPlacementMode identified by the workPlacementModeId", notes = "A getGET request to the WorkPlacementMode instance endpoint will retrieve an instance of a WorkPlacementMode entity as identified by the workPlacementModeId provided in the URI.", response = WorkPlacementModeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the WorkPlacementMode as identified by the workPlacementModeId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{workPlacementModeId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<WorkPlacementModeDto> getById(
            @ApiParam(value = "The unique ID of the WorkPlacementMode to retrieve", required = true)
            @PathVariable("workPlacementModeId") Integer workPlacementModeId
    ) throws NotFoundException {
        LOGGER.info("** WorkPlacementModesApi - workPlacementModesWorkPlacementModeIdGet");
        WorkPlacementMode workPlacementMode = workPlacementModeService.findById(workPlacementModeId);
        if (workPlacementMode == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<WorkPlacementModeDto>(WorkPlacementModeDto.mapFromEntity(workPlacementMode), HttpStatus.OK);
    }
    
    /**
     * This method is used to create a new instance of a WorkPlacementMode from the supplied WorkPlacementModeDto
     *
     * @param workPlacementMode the WorkPlacementModeDto to use to create the new WorkPlacementMode object
     * @return A ResponseEntity with the newly created WorkPlacementMode object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new WorkPlacementMode entity", notes = "A POST request to the WorkPlacementModes endpoint with a WorkPlacementMode object in the request body will create a new WorkPlacementMode entity in the database.", response = WorkPlacementModeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created WorkPlacementMode entity including the workPlacementModeId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<WorkPlacementModeDto> create(
            @ApiParam(value = "The WorkPlacementMode object to be created, without the workPlacementModeId fields", required = true)
            @RequestBody @Valid WorkPlacementModeDto workPlacementModeDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** WorkPlacementModesApi - workPlacementModesPOST");
        if (workPlacementModeDto.id == null) {
            throw new InvalidDataException(400, "ID field should be provided when creating")
        }
        WorkPlacementMode workPlacementMode = workPlacementModeService.createFromDto(workPlacementModeDto)
        return new ResponseEntity<WorkPlacementModeDto>(WorkPlacementModeDto.mapFromEntity(workPlacementMode), HttpStatus.CREATED);
    }
    
    /**
     * The workPlacementModesWorkPlacementModeIdPut is used to update
     *
     * @param workPlacementModeId the workPlacementMode ID for the WorkPlacementMode object to update
     * @param workPlacementMode the new data for the WorkPlacementMode object
     * @return the newly updated WorkPlacementModeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a WorkPlacementMode entity", notes = "A PUT request to the WorkPlacementMode instance endpoint with a WorkPlacementMode object in the request body will update an existing WorkPlacementMode entity in the database.", response = WorkPlacementModeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated WorkPlacementMode object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{workPlacementModeId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<WorkPlacementModeDto> update(
            @ApiParam(value = "The unique ID of the WorkPlacementMode to retrieve", required = true)
            @PathVariable("workPlacementModeId") Integer workPlacementModeId,
            @ApiParam(value = "The WorkPlacementMode object to be created, without the workPlacementModeId fields", required = true)
            @RequestBody WorkPlacementModeDto workPlacementModeDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** WorkPlacementModesApi - workPlacementModesPUT");
        if (workPlacementModeId != workPlacementModeDto.id) {
            throw new InvalidDataException()
        }
        WorkPlacementMode workPlacementMode = workPlacementModeService.updateFromDto(workPlacementModeDto)
        return new ResponseEntity<WorkPlacementModeDto>(WorkPlacementModeDto.mapFromEntity(workPlacementMode), HttpStatus.OK);
    }
}
