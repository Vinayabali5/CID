package uk.ac.reigate.api;

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

import uk.ac.reigate.domain.register.AttendanceCode
import uk.ac.reigate.dto.AttendanceCodeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.AttendanceCodeService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/attendanceCodes", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/attendanceCodes", description = "the attendanceCodes API")
public class AttendanceCodesApi implements ICoreDataApi<AttendanceCodeDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AttendanceCodesApi.class);
    
    @Autowired
    private final AttendanceCodeService attendanceCodeService;
    
    /**
     * Default NoArgs constructor
     */
    AttendanceCodesApi() {}
    
    /**
     * Autowired constructor
     */
    AttendanceCodesApi(AttendanceCodeService attendanceCodeService) {
        this.attendanceCodeService = attendanceCodeService;
    }
    
    /**
     * This method is used to retrieve a full list of all the AttendanceCodeDto objects
     *
     * @return A ResponseEntity with the corresponding list of AttendanceCodeDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of AttendanceCode entities", notes = "A GET request to the AttendanceCodes endpoint returns an array of all the attendanceCodes in the system.", response = AttendanceCodeDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of attendanceCodes")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<AttendanceCodeDto>> getAll() throws NotFoundException {
        LOGGER.info("** AttendanceCodesApi - getAll");
        List<AttendanceCode> attendanceCodes = attendanceCodeService.findAll();
        return new ResponseEntity<List<AttendanceCodeDto>>(AttendanceCodeDto.mapFromList(attendanceCodes), HttpStatus.OK);
    }
    
    /**
     * This method is used to create a new instance of a AttendanceCode from the supplied AttendanceCodeDto
     *
     * @param attendanceCode the AttendanceCodeDto to use to create the new AttendanceCode object
     * @return A ResponseEntity with the newly created AttendanceCode object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new AttendanceCode entity", notes = "A POST request to the AttendanceCodes endpoint with a AttendanceCode object in the request body will create a new AttendanceCode entity in the database.", response = AttendanceCodeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created AttendanceCode entity including the attendanceCodeId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<AttendanceCodeDto> create(
            @ApiParam(value = "The AttendanceCode object to be created, without the attendanceCodeId fields", required = true)
            @RequestBody @Valid AttendanceCodeDto attendanceCodeDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** AttendanceCodesApi - create");
        AttendanceCode attendanceCode = attendanceCodeService.createFromDto(attendanceCodeDto)
        return new ResponseEntity<AttendanceCodeDto>(AttendanceCodeDto.mapFromEntity(attendanceCode), HttpStatus.CREATED);
    }
    
    /**
     * This method is used to retrieve an instance of a AttendanceCodeDto object as identified by the attendanceCodeId provided
     *
     * @param attendanceCodeId the attendanceCode ID for the AttendanceCode object retrieve
     * @return A ResponseEntity with the corresponding AttendanceCodeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a AttendanceCode identified by the attendanceCodeId", notes = "A getGET request to the AttendanceCode instance endpoint will retrieve an instance of a AttendanceCode entity as identified by the attendanceCodeId provided in the URI.", response = AttendanceCodeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the AttendanceCode as identified by the attendanceCodeId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{attendanceCodeId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<AttendanceCodeDto> getById(
            @ApiParam(value = "The unique ID of the AttendanceCode to retrieve", required = true)
            @PathVariable("attendanceCodeId") Integer attendanceCodeId
    ) throws NotFoundException {
        LOGGER.info("** AttendanceCodesApi - getById");
        AttendanceCode attendanceCode = attendanceCodeService.findById(attendanceCodeId);
        if (attendanceCode == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<AttendanceCodeDto>(AttendanceCodeDto.mapFromEntity(attendanceCode), HttpStatus.OK);
    }
    
    
    /**
     * This method is used to update an AttendanceCode object from the supplied AttendanceCodeDto object. 
     *
     * @param attendanceCodeId the attendanceCode ID for the AttendanceCode object to update
     * @param attendanceCode the AttendanceCodeDto object to use for the update
     * @return the updated AttendanceCodeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a AttendanceCode entity", notes = "A PUT request to the AttendanceCode instance endpoint with a AttendanceCode object in the request body will update an existing AttendanceCode entity in the database.", response = AttendanceCodeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated AttendanceCode object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{attendanceCodeId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<AttendanceCodeDto> update (
            @ApiParam(value = "The unique ID of the AttendanceCode to retrieve", required = true)
            @PathVariable("attendanceCodeId") Integer attendanceCodeId,
            @ApiParam(value = "The AttendanceCode object to be created, without the attendanceCodeId fields", required = true)
            @RequestBody AttendanceCodeDto attendanceCodeDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** AttendanceCodesApi - attendanceCodePUT");
        if (attendanceCodeId != attendanceCodeDto.id) {
            throw new InvalidDataException()
        }
        AttendanceCode attendanceCode = attendanceCodeService.updateFromDto(attendanceCodeDto)
        return new ResponseEntity<AttendanceCodeDto>(AttendanceCodeDto.mapFromEntity(attendanceCode), HttpStatus.OK);
    }
}
