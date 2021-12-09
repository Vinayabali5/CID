package uk.ac.reigate.api.cristal;

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
import uk.ac.reigate.domain.cristal.CristalRoom
import uk.ac.reigate.dto.cristal.CristalRoomDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.cristal.CristalRoomService


@Controller
@RequestMapping(value = "/cristal-rooms", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/cristal-rooms", description = "the cristalRooms API")
public class CristalRoomsApi implements ICoreDataBaseApi<CristalRoomDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CristalRoomsApi.class);
    
    @Autowired
    private final CristalRoomService cristalRoomService;
    
    
    /**
     * Default NoArgs constructor
     */
    CristalRoomsApi() {}
    
    /**
     * Autowired constructor
     */
    CristalRoomsApi(CristalRoomService cristalRoomService) {
        this.cristalRoomService = cristalRoomService;
    }
    
    /**
     * The cristalRoomsGet method is used to retrieve a full list of all the CristalRoomDto objects
     *
     * @return A ResponseEntity with the corresponding list of CristalRoomDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of CristalRoom entities", notes = "A GET request to the CristalRooms endpoint returns an array of all the cristalRooms in the system.", response = CristalRoomDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of cristalRooms")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<CristalRoomDto>> getAll() throws NotFoundException {
        LOGGER.info("** CristalRoomsApi - cristalRoomsGet");
        List<CristalRoom> cristalRooms = cristalRoomService.findAll();
        return new ResponseEntity<List<CristalRoomDto>>(CristalRoomDto.mapFromList(cristalRooms), HttpStatus.OK);
    }
    
    /**
     * The cristalRoomsCristalRoomIdGet method is used to retrieve an instance of a CristalRoomDto object as identified by the cristalRoomId provided
     *
     * @param cristalRoomId the cristalRoom ID for the CristalRoom object retrieve
     * @return A ResponseEntity with the corresponding CristalRoomDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a CristalRoom identified by the cristalRoomId", notes = "A getGET request to the CristalRoom instance endpoint will retrieve an instance of a CristalRoom entity as identified by the cristalRoomId provided in the URI.", response = CristalRoomDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the CristalRoom as identified by the cristalRoomId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{roomId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<CristalRoomDto> getById(
            @ApiParam(value = "The unique ID of the CristalRoom to retrieve", required = true)
            @PathVariable("roomId") Integer roomId
    ) throws NotFoundException {
        LOGGER.info("** CristalRoomsApi - cristalRoomsCristalRoomIdGet");
        CristalRoom cristalRoom = cristalRoomService.findById(roomId);
        if (cristalRoom == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<CristalRoomDto>(CristalRoomDto.mapFromEntity(cristalRoom), HttpStatus.OK);
    }
    
    /**
     * The cristalRoomsPost method is used to create a new instance of a CristalRoom from the supplied CristalRoomDto
     *
     * @param cristalRoom the CristalRoomDto to use to create the new CristalRoom object
     * @return A ResponseEntity with the newly created CristalRoom object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new CristalRoom entity", notes = "A POST request to the CristalRooms endpoint with a CristalRoom object in the request body will create a new CristalRoom entity in the database.", response = CristalRoomDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created CristalRoom entity including the cristalRoomId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<CristalRoomDto> create(
            @ApiParam(value = "The CristalRoom object to be created, without the cristalRoomId fields", required = true)
            @RequestBody @Valid CristalRoomDto cristalRoom
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** CristalRoomsApi - cristalRoomsPOST");
        CristalRoom cristalRoomSaved = cristalRoomService.createFromDto(cristalRoom)
        return new ResponseEntity<CristalRoomDto>(CristalRoomDto.mapFromEntity(cristalRoomSaved), HttpStatus.CREATED);
    }
    
    /**
     * The cristalRoomsCristalRoomIdPut is used to update
     *
     * @param cristalRoomId the cristalRoom ID for the CristalRoom object to update
     * @param cristalRoom the new data for the CristalRoom object
     * @return the newly updated CristalRoomDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a CristalRoom entity", notes = "A PUT request to the CristalRoom instance endpoint with a CristalRoom object in the request body will update an existing CristalRoom entity in the database.", response = CristalRoomDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated CristalRoom object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{roomId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<CristalRoomDto> update(
            @ApiParam(value = "The unique ID of the CristalRoom to retrieve", required = true)
            @PathVariable("roomId") Integer roomId,
            @ApiParam(value = "The CristalRoom object to be created, without the cristalRoomId fields", required = true)
            @RequestBody CristalRoomDto cristalRoom
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** CristalRoomsApi - cristalRoomsPUT");
        if (cristalRoom != cristalRoom) {
            throw new InvalidDataException()
        }
        CristalRoom cristalRoomSaved = cristalRoomService.updateFromDto(cristalRoom)
        return new ResponseEntity<CristalRoomDto>(CristalRoomDto.mapFromEntity(cristalRoomSaved), HttpStatus.OK);
    }
}
