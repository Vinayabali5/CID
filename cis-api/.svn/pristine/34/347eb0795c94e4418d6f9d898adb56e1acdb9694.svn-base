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

import uk.ac.reigate.api.ICoreDataBaseApi
import uk.ac.reigate.domain.lookup.VolunteeringType
import uk.ac.reigate.dto.lookup.VolunteeringTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.lookup.VolunteeringTypeService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/volunteering-types", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/volunteering-types", description = "the volunteeringTypes API")
public class VolunteeringTypesApi implements ICoreDataBaseApi<VolunteeringTypeDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(VolunteeringTypesApi.class);
    
    @Autowired
    private final VolunteeringTypeService volunteeringTypeService;
    
    /**
     * Default NoArgs constructor
     */
    VolunteeringTypesApi() {}
    
    /**
     * Autowired constructor
     */
    VolunteeringTypesApi(VolunteeringTypeService volunteeringTypeService) {
        this.volunteeringTypeService = volunteeringTypeService;
    }
    
    /**
     * This method is used to retrieve a full list of all the VolunteeringTypeDto objects
     *
     * @return A ResponseEntity with the corresponding list of VolunteeringTypeDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of VolunteeringType entities", notes = "A GET request to the VolunteeringTypes endpoint returns an array of all the volunteeringTypes in the system.", response = VolunteeringTypeDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of volunteeringTypes")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<VolunteeringTypeDto>> getAll() throws NotFoundException {
        LOGGER.info("** VolunteeringTypesApi - volunteeringTypesGet");
        List<VolunteeringType> volunteeringTypes = volunteeringTypeService.findAll();
        return new ResponseEntity<List<VolunteeringTypeDto>>(VolunteeringTypeDto.mapFromList(volunteeringTypes), HttpStatus.OK);
    }
    
    /**
     * This method is used to retrieve an instance of a VolunteeringTypeDto object as identified by the volunteeringTypeId provided
     *
     * @param volunteeringTypeId the volunteeringType ID for the VolunteeringType object retrieve
     * @return A ResponseEntity with the corresponding VolunteeringTypeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a VolunteeringType identified by the volunteeringTypeId", notes = "A getGET request to the VolunteeringType instance endpoint will retrieve an instance of a VolunteeringType entity as identified by the volunteeringTypeId provided in the URI.", response = VolunteeringTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the VolunteeringType as identified by the volunteeringTypeId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{volunteeringTypeId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<VolunteeringTypeDto> getById(
            @ApiParam(value = "The unique ID of the VolunteeringType to retrieve", required = true)
            @PathVariable("volunteeringTypeId") Integer volunteeringTypeId
    ) throws NotFoundException {
        LOGGER.info("** VolunteeringTypesApi - volunteeringTypesVolunteeringTypeIdGet");
        VolunteeringType volunteeringType = volunteeringTypeService.findById(volunteeringTypeId);
        if (volunteeringType == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<VolunteeringTypeDto>(VolunteeringTypeDto.mapFromEntity(volunteeringType), HttpStatus.OK);
    }
    
    /**
     * This method is used to create a new instance of a VolunteeringType from the supplied VolunteeringTypeDto
     *
     * @param volunteeringType the VolunteeringTypeDto to use to create the new VolunteeringType object
     * @return A ResponseEntity with the newly created VolunteeringType object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new VolunteeringType entity", notes = "A POST request to the VolunteeringTypes endpoint with a VolunteeringType object in the request body will create a new VolunteeringType entity in the database.", response = VolunteeringTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created VolunteeringType entity including the volunteeringTypeId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<VolunteeringTypeDto> create(
            @ApiParam(value = "The VolunteeringType object to be created, without the volunteeringTypeId fields", required = true)
            @RequestBody @Valid VolunteeringTypeDto volunteeringTypeDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** VolunteeringTypesApi - volunteeringTypesPOST");
        if (volunteeringTypeDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        VolunteeringType volunteeringType = volunteeringTypeService.createFromDto(volunteeringTypeDto)
        return new ResponseEntity<VolunteeringTypeDto>(VolunteeringTypeDto.mapFromEntity(volunteeringType), HttpStatus.CREATED);
    }
    
    /**
     * The volunteeringTypesVolunteeringTypeIdPut is used to update
     *
     * @param volunteeringTypeId the volunteeringType ID for the VolunteeringType object to update
     * @param volunteeringType the new data for the VolunteeringType object
     * @return the newly updated VolunteeringTypeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a VolunteeringType entity", notes = "A PUT request to the VolunteeringType instance endpoint with a VolunteeringType object in the request body will update an existing VolunteeringType entity in the database.", response = VolunteeringTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated VolunteeringType object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{volunteeringTypeId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<VolunteeringTypeDto> update(
            @ApiParam(value = "The unique ID of the VolunteeringType to retrieve", required = true)
            @PathVariable("volunteeringTypeId") Integer volunteeringTypeId,
            @ApiParam(value = "The VolunteeringType object to be created, without the volunteeringTypeId fields", required = true)
            @RequestBody VolunteeringTypeDto volunteeringTypeDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** VolunteeringTypesApi - volunteeringTypesPUT");
        if (volunteeringTypeId != volunteeringTypeDto.id) {
            throw new InvalidDataException()
        }
        VolunteeringType volunteeringType = volunteeringTypeService.updateFromDto(volunteeringTypeDto)
        return new ResponseEntity<VolunteeringTypeDto>(VolunteeringTypeDto.mapFromEntity(volunteeringType), HttpStatus.OK);
    }
}
