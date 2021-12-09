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
import uk.ac.reigate.domain.lookup.BursaryType
import uk.ac.reigate.dto.lookup.BursaryTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.lookup.BursaryTypeService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/bursary-types", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/bursary-types", description = "the bursaryTypes API")
public class BursaryTypesApi implements ICoreDataBaseApi<BursaryTypeDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BursaryTypesApi.class);
    
    @Autowired
    private final BursaryTypeService bursaryTypeService;
    
    /**
     * Default NoArgs constructor
     */
    BursaryTypesApi() {}
    
    /**
     * Autowired constructor
     */
    BursaryTypesApi(BursaryTypeService bursaryTypeService) {
        this.bursaryTypeService = bursaryTypeService;
    }
    
    /**
     * This method is used to retrieve a full list of all the BursaryTypeDto objects
     *
     * @return A ResponseEntity with the corresponding list of BursaryTypeDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of BursaryType entities", notes = "A GET request to the BursaryTypes endpoint returns an array of all the bursaryTypes in the system.", response = BursaryTypeDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of bursaryTypes")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<BursaryTypeDto>> getAll() throws NotFoundException {
        LOGGER.info("** BursaryTypesApi - bursaryTypesGet");
        List<BursaryType> bursaryTypes = bursaryTypeService.findAll();
        return new ResponseEntity<List<BursaryTypeDto>>(BursaryTypeDto.mapFromList(bursaryTypes), HttpStatus.OK);
    }
    
    /**
     * This method is used to retrieve an instance of a BursaryTypeDto object as identified by the bursaryTypeId provided
     *
     * @param bursaryTypeId the bursaryType ID for the BursaryType object retrieve
     * @return A ResponseEntity with the corresponding BursaryTypeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a BursaryType identified by the bursaryTypeId", notes = "A getGET request to the BursaryType instance endpoint will retrieve an instance of a BursaryType entity as identified by the bursaryTypeId provided in the URI.", response = BursaryTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the BursaryType as identified by the bursaryTypeId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{bursaryTypeId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<BursaryTypeDto> getById(
            @ApiParam(value = "The unique ID of the BursaryType to retrieve", required = true)
            @PathVariable("bursaryTypeId") Integer bursaryTypeId
    ) throws NotFoundException {
        LOGGER.info("** BursaryTypesApi - bursaryTypesBursaryTypeIdGet");
        BursaryType bursaryType = bursaryTypeService.findById(bursaryTypeId);
        if (bursaryType == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<BursaryTypeDto>(BursaryTypeDto.mapFromEntity(bursaryType), HttpStatus.OK);
    }
    
    /**
     * This method is used to create a new instance of a BursaryType from the supplied BursaryTypeDto
     *
     * @param bursaryType the BursaryTypeDto to use to create the new BursaryType object
     * @return A ResponseEntity with the newly created BursaryType object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new BursaryType entity", notes = "A POST request to the BursaryTypes endpoint with a BursaryType object in the request body will create a new BursaryType entity in the database.", response = BursaryTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created BursaryType entity including the bursaryTypeId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<BursaryTypeDto> create(
            @ApiParam(value = "The BursaryType object to be created, without the bursaryTypeId fields", required = true)
            @RequestBody @Valid BursaryTypeDto bursaryTypeDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** BursaryTypesApi - bursaryTypesPOST");
        if (bursaryTypeDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        BursaryType bursaryType = bursaryTypeService.createFromDto(bursaryTypeDto)
        return new ResponseEntity<BursaryTypeDto>(BursaryTypeDto.mapFromEntity(bursaryType), HttpStatus.CREATED);
    }
    
    /**
     * The bursaryTypesBursaryTypeIdPut is used to update
     *
     * @param bursaryTypeId the bursaryType ID for the BursaryType object to update
     * @param bursaryType the new data for the BursaryType object
     * @return the newly updated BursaryTypeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a BursaryType entity", notes = "A PUT request to the BursaryType instance endpoint with a BursaryType object in the request body will update an existing BursaryType entity in the database.", response = BursaryTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated BursaryType object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{bursaryTypeId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<BursaryTypeDto> update(
            @ApiParam(value = "The unique ID of the BursaryType to retrieve", required = true)
            @PathVariable("bursaryTypeId") Integer bursaryTypeId,
            @ApiParam(value = "The BursaryType object to be created, without the bursaryTypeId fields", required = true)
            @RequestBody BursaryTypeDto bursaryTypeDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** BursaryTypesApi - bursaryTypesPUT");
        if (bursaryTypeId != bursaryTypeDto.id) {
            throw new InvalidDataException()
        }
        BursaryType bursaryType = bursaryTypeService.updateFromDto(bursaryTypeDto)
        return new ResponseEntity<BursaryTypeDto>(BursaryTypeDto.mapFromEntity(bursaryType), HttpStatus.OK);
    }
}
