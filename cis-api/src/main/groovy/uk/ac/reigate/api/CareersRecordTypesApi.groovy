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
import uk.ac.reigate.domain.academic.CareersRecordType
import uk.ac.reigate.dto.careers.CareersRecordTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.CareersRecordTypeService


@Controller
@RequestMapping(value = "/careers-record-types", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/careers-record-types", description = "the careersRecordTypes API")
public class CareersRecordTypesApi implements ICoreDataBaseApi<CareersRecordTypeDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CareersRecordTypesApi.class);
    
    @Autowired
    private final CareersRecordTypeService careersRecordTypeService;
    
    /**
     * Default NoArgs constructor
     */
    CareersRecordTypesApi() {}
    
    /**
     * Autowired constructor
     */
    CareersRecordTypesApi(CareersRecordTypeService careersRecordTypeService) {
        this.careersRecordTypeService = careersRecordTypeService;
    }
    
    /**
     * This method is used to retrieve a full list of all the CareersRecordTypeDto objects
     *
     * @return A ResponseEntity with the corresponding list of CareersRecordTypeDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of CareersRecordType entities", notes = "A GET request to the CareersRecordTypes endpoint returns an array of all the careersRecordTypes in the system.", response = CareersRecordTypeDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of careersRecordTypes")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<CareersRecordTypeDto>> getAll() throws NotFoundException {
        LOGGER.info("** CareersRecordTypesApi - careersRecordTypesGet");
        List<CareersRecordType> careersRecordTypes = careersRecordTypeService.findAll();
        return new ResponseEntity<List<CareersRecordTypeDto>>(CareersRecordTypeDto.mapFromList(careersRecordTypes), HttpStatus.OK);
    }
    
    /**
     * This method is used to retrieve an instance of a CareersRecordTypeDto object as identified by the careersRecordTypeId provided
     *
     * @param careersRecordTypeId the careersRecordType ID for the CareersRecordType object retrieve
     * @return A ResponseEntity with the corresponding CareersRecordTypeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a CareersRecordType identified by the careersRecordTypeId", notes = "A getGET request to the CareersRecordType instance endpoint will retrieve an instance of a CareersRecordType entity as identified by the careersRecordTypeId provided in the URI.", response = CareersRecordTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the CareersRecordType as identified by the careersRecordTypeId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{careersRecordTypeId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<CareersRecordTypeDto> getById(
            @ApiParam(value = "The unique ID of the CareersRecordType to retrieve", required = true)
            @PathVariable("careersRecordTypeId") Integer careersRecordTypeId
    ) throws NotFoundException {
        LOGGER.info("** CareersRecordTypesApi - careersRecordTypesCareersRecordTypeIdGet");
        CareersRecordType careersRecordType = careersRecordTypeService.findById(careersRecordTypeId);
        if (careersRecordType == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<CareersRecordTypeDto>(CareersRecordTypeDto.mapFromEntity(careersRecordType), HttpStatus.OK);
    }
    
    /**
     * This method is used to create a new instance of a CareersRecordType from the supplied CareersRecordTypeDto
     *
     * @param careersRecordType the CareersRecordTypeDto to use to create the new CareersRecordType object
     * @return A ResponseEntity with the newly created CareersRecordType object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new CareersRecordType entity", notes = "A POST request to the CareersRecordTypes endpoint with a CareersRecordType object in the request body will create a new CareersRecordType entity in the database.", response = CareersRecordTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created CareersRecordType entity including the careersRecordTypeId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<CareersRecordTypeDto> create(
            @ApiParam(value = "The CareersRecordType object to be created, without the careersRecordTypeId fields", required = true)
            @RequestBody @Valid CareersRecordTypeDto careersRecordTypeDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** CareersRecordTypesApi - careersRecordTypesPOST");
        if (careersRecordTypeDto.id != null) {
            throw new InvalidDataException(400, "ID field should be provided when creating")
        }
        CareersRecordType careersRecordType = careersRecordTypeService.createFromDto(careersRecordTypeDto)
        return new ResponseEntity<CareersRecordTypeDto>(CareersRecordTypeDto.mapFromEntity(careersRecordType), HttpStatus.CREATED);
    }
    
    /**
     * The careersRecordTypesCareersRecordTypeIdPut is used to update
     *
     * @param careersRecordTypeId the careersRecordType ID for the CareersRecordType object to update
     * @param careersRecordType the new data for the CareersRecordType object
     * @return the newly updated CareersRecordTypeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a CareersRecordType entity", notes = "A PUT request to the CareersRecordType instance endpoint with a CareersRecordType object in the request body will update an existing CareersRecordType entity in the database.", response = CareersRecordTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated CareersRecordType object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{careersRecordTypeId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<CareersRecordTypeDto> update(
            @ApiParam(value = "The unique ID of the CareersRecordType to retrieve", required = true)
            @PathVariable("careersRecordTypeId") Integer careersRecordTypeId,
            @ApiParam(value = "The CareersRecordType object to be created, without the careersRecordTypeId fields", required = true)
            @RequestBody CareersRecordTypeDto careersRecordTypeDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** CareersRecordTypesApi - careersRecordTypesPUT");
        if (careersRecordTypeId != careersRecordTypeDto.id) {
            throw new InvalidDataException()
        }
        CareersRecordType careersRecordType = careersRecordTypeService.updateFromDto(careersRecordTypeDto)
        return new ResponseEntity<CareersRecordTypeDto>(CareersRecordTypeDto.mapFromEntity(careersRecordType), HttpStatus.OK);
    }
}
