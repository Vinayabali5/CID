package uk.ac.reigate.api.lookup;

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
import uk.ac.reigate.domain.RoomType
import uk.ac.reigate.dto.lookup.RoomTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.lookup.RoomTypeService


@Controller
@RequestMapping(value = "/roomTypes", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/roomTypes", description = "the roomTypes API")
public class RoomTypesApi implements ICoreDataBaseApi<RoomTypeDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomTypesApi.class);
    
    @Autowired
    private final RoomTypeService roomTypeService;
    
    /**
     * Default NoArgs constructor
     */
    RoomTypesApi() {}
    
    /**
     * Autowired constructor
     */
    RoomTypesApi(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }
    
    /**
     * The roomTypesGet method is used to retrieve a full list of all the RoomTypeDto objects
     *
     * @return A ResponseEntity with the corresponding list of RoomTypeDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of RoomType entities", notes = "A GET request to the RoomTypes endpoint returns an array of all the roomTypes in the system.", response = RoomTypeDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of roomTypes")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<RoomTypeDto>> getAll() throws NotFoundException {
        LOGGER.info("** RoomTypesApi - roomTypesGet");
        List<RoomType> roomTypes = roomTypeService.findAll();
        return new ResponseEntity<List<RoomTypeDto>>(RoomTypeDto.mapFromList(roomTypes), HttpStatus.OK);
    }
    
    /**
     * The roomTypesPost method is used to create a new instance of a RoomType from the supplied RoomTypeDto
     *
     * @param roomType the RoomTypeDto to use to create the new RoomType object
     * @return A ResponseEntity with the newly created RoomType object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new RoomType entity", notes = "A POST request to the RoomTypes endpoint with a RoomType object in the request body will create a new RoomType entity in the database.", response = RoomTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created RoomType entity including the roomTypeId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<RoomTypeDto> create(
            @ApiParam(value = "The RoomType object to be created, without the roomTypeId fields", required = true)
            @RequestBody @Valid RoomTypeDto roomType
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** RoomTypesApi - roomTypesPOST");
        if (roomType.id == null) {
            throw new InvalidDataException(400, "ID field should be provided when creating")
        }
        RoomType roomTypeSaved = roomTypeService.createFromDto(roomType)
        return new ResponseEntity<RoomTypeDto>(RoomTypeDto.mapFromEntity(roomTypeSaved), HttpStatus.CREATED);
    }
    
    /**
     * The roomTypesRoomTypeIdGet method is used to retrieve an instance of a RoomTypeDto object as identified by the roomTypeId provided
     *
     * @param roomTypeId the roomType ID for the RoomType object retrieve
     * @return A ResponseEntity with the corresponding RoomTypeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a RoomType identified by the roomTypeId", notes = "A getGET request to the RoomType instance endpoint will retrieve an instance of a RoomType entity as identified by the roomTypeId provided in the URI.", response = RoomTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the RoomType as identified by the roomTypeId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{roomTypeId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<RoomTypeDto> getById(
            @ApiParam(value = "The unique ID of the RoomType to retrieve", required = true)
            @PathVariable("roomTypeId") Integer roomTypeId
    ) throws NotFoundException {
        LOGGER.info("** RoomTypesApi - roomTypesRoomTypeIdGet");
        RoomType roomType = roomTypeService.findById(roomTypeId);
        if (roomType == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<RoomTypeDto>(RoomTypeDto.mapFromEntity(roomType), HttpStatus.OK);
    }
    
    /**
     * The roomTypesRoomTypeIdPut is used to update
     *
     * @param roomTypeId the roomType ID for the RoomType object to update
     * @param roomType the new data for the RoomType object
     * @return the newly updated RoomTypeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a RoomType entity", notes = "A PUT request to the RoomType instance endpoint with a RoomType object in the request body will update an existing RoomType entity in the database.", response = RoomTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated RoomType object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{roomTypeId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<RoomTypeDto> update(
            @ApiParam(value = "The unique ID of the RoomType to retrieve", required = true)
            @PathVariable("roomTypeId") Integer roomTypeId,
            @ApiParam(value = "The RoomType object to be created, without the roomTypeId fields", required = true)
            @RequestBody RoomTypeDto roomType
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** RoomTypesApi - roomTypesPUT");
        if (roomTypeId != roomType.id) {
            throw new InvalidDataException()
        }
        RoomType roomTypeSaved = roomTypeService.updateFromDto(roomType)
        return new ResponseEntity<RoomTypeDto>(RoomTypeDto.mapFromEntity(roomTypeSaved), HttpStatus.OK);
    }
}
