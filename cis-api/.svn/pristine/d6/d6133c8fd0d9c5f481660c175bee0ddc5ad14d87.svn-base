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
import uk.ac.reigate.domain.academic.EntryQualificationType
import uk.ac.reigate.dto.EntryQualificationTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.EntryQualificationTypeService


@Controller
@RequestMapping(value = "/entryQualificationTypes", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/entryQualificationTypes", description = "the entryQualificationTypes API")
public class EntryQualificationTypesApi implements ICoreDataBaseApi<EntryQualificationTypeDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EntryQualificationTypesApi.class);
    
    @Autowired
    private final EntryQualificationTypeService entryQualificationTypeService;
    
    /**
     * Default NoArgs constructor
     */
    EntryQualificationTypesApi() {}
    
    /**
     * Autowired constructor
     */
    EntryQualificationTypesApi(EntryQualificationTypeService entryQualificationTypeService) {
        this.entryQualificationTypeService = entryQualificationTypeService;
    }
    
    /**
     * The entryQualificationTypesGet method is used to retrieve a full list of all the EntryQualificationTypeDto objects
     *
     * @return A ResponseEntity with the corresponding list of EntryQualificationTypeDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of EntryQualificationType entities", notes = "A GET request to the EntryQualificationTypes endpoint returns an array of all the entryQualificationTypes in the system.", response = EntryQualificationTypeDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of entryQualificationTypes")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<EntryQualificationTypeDto>> getAll() throws NotFoundException {
        LOGGER.info("** EntryQualificationTypesApi - entryQualificationTypesGet");
        List<EntryQualificationType> entryQualificationTypes = entryQualificationTypeService.findAll();
        return new ResponseEntity<List<EntryQualificationTypeDto>>(EntryQualificationTypeDto.mapFromList(entryQualificationTypes), HttpStatus.OK);
    }
    
    /**
     * The entryQualificationTypesPost method is used to create a new instance of a EntryQualificationType from the supplied EntryQualificationTypeDto
     *
     * @param entryQualificationType the EntryQualificationTypeDto to use to create the new EntryQualificationType object
     * @return A ResponseEntity with the newly created EntryQualificationType object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new EntryQualificationType entity", notes = "A POST request to the EntryQualificationTypes endpoint with a EntryQualificationType object in the request body will create a new EntryQualificationType entity in the database.", response = EntryQualificationTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created EntryQualificationType entity including the entryQualificationTypeId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<EntryQualificationTypeDto> create(
            @ApiParam(value = "The EntryQualificationType object to be created, without the entryQualificationTypeId fields", required = true)
            @RequestBody @Valid EntryQualificationTypeDto entryQualificationType
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** EntryQualificationTypesApi - entryQualificationTypesPOST");
        if (entryQualificationType.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        EntryQualificationType entryQualificationTypeSaved = entryQualificationTypeService.createFromDto(entryQualificationType)
        return new ResponseEntity<EntryQualificationTypeDto>(EntryQualificationTypeDto.mapFromEntity(entryQualificationTypeSaved), HttpStatus.CREATED);
    }
    
    /**
     * The entryQualificationTypesEntryQualificationTypeIdGet method is used to retrieve an instance of a EntryQualificationTypeDto object as identified by the entryQualificationTypeId provided
     *
     * @param entryQualificationTypeId the entryQualificationType ID for the EntryQualificationType object retrieve
     * @return A ResponseEntity with the corresponding EntryQualificationTypeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a EntryQualificationType identified by the entryQualificationTypeId", notes = "A getGET request to the EntryQualificationType instance endpoint will retrieve an instance of a EntryQualificationType entity as identified by the entryQualificationTypeId provided in the URI.", response = EntryQualificationTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the EntryQualificationType as identified by the entryQualificationTypeId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{entryQualificationTypeId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<EntryQualificationTypeDto> getById(
            @ApiParam(value = "The unique ID of the EntryQualificationType to retrieve", required = true)
            @PathVariable("entryQualificationTypeId") Integer entryQualificationTypeId
    ) throws NotFoundException {
        LOGGER.info("** EntryQualificationTypesApi - entryQualificationTypesEntryQualificationTypeIdGet");
        EntryQualificationType entryQualificationType = entryQualificationTypeService.findById(entryQualificationTypeId);
        if (entryQualificationType == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<EntryQualificationTypeDto>(EntryQualificationTypeDto.mapFromEntity(entryQualificationType), HttpStatus.OK);
    }
    
    /**
     * The entryQualificationTypesEntryQualificationTypeIdPut is used to update
     *
     * @param entryQualificationTypeId the entryQualificationType ID for the EntryQualificationType object to update
     * @param entryQualificationType the new data for the EntryQualificationType object
     * @return the newly updated EntryQualificationTypeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a EntryQualificationType entity", notes = "A PUT request to the EntryQualificationType instance endpoint with a EntryQualificationType object in the request body will update an existing EntryQualificationType entity in the database.", response = EntryQualificationTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated EntryQualificationType object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{entryQualificationTypeId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<EntryQualificationTypeDto> update(
            @ApiParam(value = "The unique ID of the EntryQualificationType to retrieve", required = true)
            @PathVariable("entryQualificationTypeId") Integer entryQualificationTypeId,
            @ApiParam(value = "The EntryQualificationType object to be created, without the entryQualificationTypeId fields", required = true)
            @RequestBody EntryQualificationTypeDto entryQualificationType
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** EntryQualificationTypesApi - entryQualificationTypesPUT");
        if (entryQualificationTypeId != entryQualificationType.id) {
            throw new InvalidDataException()
        }
        EntryQualificationType entryQualificationTypeSaved = entryQualificationTypeService.updateFromDto(entryQualificationType)
        return new ResponseEntity<EntryQualificationTypeDto>(EntryQualificationTypeDto.mapFromEntity(entryQualificationTypeSaved), HttpStatus.OK);
    }
}
