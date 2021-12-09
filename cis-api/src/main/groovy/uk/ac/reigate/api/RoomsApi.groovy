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
import uk.ac.reigate.domain.Room
import uk.ac.reigate.dto.RoomDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.RoomService
import uk.ac.reigate.services.lookup.RoomTypeService


@Controller
@RequestMapping(value = "/rooms", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/rooms", description = "the rooms API")
public class RoomsApi implements ICoreDataBaseApi<RoomDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomsApi.class);
    
    @Autowired
    private final RoomService roomService;
    
    @Autowired
    private final RoomTypeService roomTypeService;
    
    /**
     * Default NoArgs constructor
     */
    RoomsApi() {}
    
    /**
     * Autowired constructor
     */
    RoomsApi(RoomService roomService) {
        this.roomService = roomService;
    }
    
    /**
     * The roomsGet method is used to retrieve a full list of all the RoomDto objects
     *
     * @return A ResponseEntity with the corresponding list of RoomDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of Room entities", notes = "A GET request to the Rooms endpoint returns an array of all the rooms in the system.", response = RoomDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of rooms")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<RoomDto>> getAll() throws NotFoundException {
        LOGGER.info("** RoomsApi - roomsGet");
        List<Room> rooms = roomService.findAll();
        return new ResponseEntity<List<RoomDto>>(RoomDto.mapFromList(rooms), HttpStatus.OK);
    }
    
    /**
     * The roomsRoomIdGet method is used to retrieve an instance of a RoomDto object as identified by the roomId provided
     *
     * @param roomId the room ID for the Room object retrieve
     * @return A ResponseEntity with the corresponding RoomDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a Room identified by the roomId", notes = "A getGET request to the Room instance endpoint will retrieve an instance of a Room entity as identified by the roomId provided in the URI.", response = RoomDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Room as identified by the roomId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{roomId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<RoomDto> getById(
            @ApiParam(value = "The unique ID of the Room to retrieve", required = true)
            @PathVariable("roomId") Integer roomId
    ) throws NotFoundException {
        LOGGER.info("** RoomsApi - roomsRoomIdGet");
        Room room = roomService.findById(roomId);
        if (room == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<RoomDto>(RoomDto.mapFromEntity(room), HttpStatus.OK);
    }
    
    /**
     * The roomsPost method is used to create a new instance of a Room from the supplied RoomDto
     *
     * @param room the RoomDto to use to create the new Room object
     * @return A ResponseEntity with the newly created Room object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new Room entity", notes = "A POST request to the Rooms endpoint with a Room object in the request body will create a new Room entity in the database.", response = RoomDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created Room entity including the roomId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<RoomDto> create(
            @ApiParam(value = "The Room object to be created, without the roomId fields", required = true)
            @RequestBody @Valid RoomDto room
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** RoomsApi - roomsPOST");
        if (room.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        
        Room roomSaved = roomService.createFromDto(room)
        return new ResponseEntity<RoomDto>(RoomDto.mapFromEntity(roomSaved), HttpStatus.CREATED);
    }
    
    /**
     * The roomsRoomIdPut is used to update
     *
     * @param roomId the room ID for the Room object to update
     * @param room the new data for the Room object
     * @return the newly updated RoomDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a Room entity", notes = "A PUT request to the Room instance endpoint with a Room object in the request body will update an existing Room entity in the database.", response = RoomDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated Room object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{roomId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<RoomDto> update(
            @ApiParam(value = "The unique ID of the Room to retrieve", required = true)
            @PathVariable("roomId") Integer roomId,
            @ApiParam(value = "The Room object to be created, without the roomId fields", required = true)
            @RequestBody RoomDto room
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** RoomsApi - roomsPUT");
        if (roomId != room.id) {
            throw new InvalidDataException()
        }
        Room roomSaved = roomService.updateFromDto(room)
        return new ResponseEntity<RoomDto>(RoomDto.mapFromEntity(roomSaved), HttpStatus.OK);
    }
}
