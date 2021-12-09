package uk.ac.reigate.api.staff;

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
import uk.ac.reigate.domain.staff.AbsenceReason
import uk.ac.reigate.dto.staff.AbsenceReasonDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.staff.AbsenceReasonService


@Controller
@RequestMapping(value = "/absence-reasons", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/absence-reasons", description = "the absenceReasons API")
public class AbsenceReasonsApi implements ICoreDataBaseApi<AbsenceReasonDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AbsenceReasonsApi.class);
    
    @Autowired
    private final AbsenceReasonService absenceReasonService;
    
    /**
     * Default NoArgs constructor
     */
    AbsenceReasonsApi() {}
    
    /**
     * Autowired constructor
     */
    AbsenceReasonsApi(AbsenceReasonService absenceReasonService) {
        this.absenceReasonService = absenceReasonService;
    }
    
    /**
     * The absenceReasonsGet method is used to retrieve a full list of all the AbsenceReasonDto objects
     *
     * @return A ResponseEntity with the corresponding list of AbsenceReasonDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of AbsenceReason entities", notes = "A GET request to the Nationalities endpoint returns an array of all the absenceReasons in the system.", response = AbsenceReasonDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of absenceReasons")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<AbsenceReasonDto>> getAll() throws NotFoundException {
        LOGGER.info("** AbsenceReasonsApi - absenceReasonsGet");
        List<AbsenceReason> absenceReasons = absenceReasonService.findAll();
        return new ResponseEntity<List<AbsenceReasonDto>>(AbsenceReasonDto.mapFromList(absenceReasons), HttpStatus.OK);
    }
    
    /**
     * The absenceReasonsPost method is used to create a new instance of a AbsenceReason from the supplied AbsenceReasonDto
     *
     * @param absenceReason the AbsenceReasonDto to use to create the new AbsenceReason object
     * @return A ResponseEntity with the newly created AbsenceReason object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new AbsenceReason entity", notes = "A POST request to the Nationalities endpoint with a AbsenceReason object in the request body will create a new AbsenceReason entity in the database.", response = AbsenceReasonDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created AbsenceReason entity including the absenceReasonId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<AbsenceReasonDto> create(
            @ApiParam(value = "The AbsenceReason object to be created, without the absenceReasonId fields", required = true)
            @RequestBody @Valid AbsenceReasonDto absenceReasonDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** AbsenceReasonsApi - absenceReasonsPOST");
        if (absenceReasonDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        AbsenceReason absenceReason = absenceReasonService.createFromDto(absenceReasonDto)
        return new ResponseEntity<AbsenceReasonDto>(AbsenceReasonDto.mapFromEntity(absenceReason), HttpStatus.CREATED);
    }
    
    /**
     * The absenceReasonsAbsenceReasonIdGet method is used to retrieve an instance of a AbsenceReasonDto object as identified by the absenceReasonId provided
     *
     * @param absenceReasonId the absenceReason ID for the AbsenceReason object retrieve
     * @return A ResponseEntity with the corresponding AbsenceReasonDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a AbsenceReason identified by the absenceReasonId", notes = "A getGET request to the AbsenceReason instance endpoint will retrieve an instance of a AbsenceReason entity as identified by the absenceReasonId provided in the URI.", response = AbsenceReasonDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the AbsenceReason as identified by the absenceReasonId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{absenceReasonId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<AbsenceReasonDto> getById(
            @ApiParam(value = "The unique ID of the AbsenceReason to retrieve", required = true)
            @PathVariable("absenceReasonId") Integer absenceReasonId
    ) throws NotFoundException {
        LOGGER.info("** AbsenceReasonsApi - absenceReasonsAbsenceReasonIdGet");
        AbsenceReason absenceReason = absenceReasonService.findById(absenceReasonId);
        if (absenceReason == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<AbsenceReasonDto>(AbsenceReasonDto.mapFromEntity(absenceReason), HttpStatus.OK);
    }
    
    /**
     * The absenceReasonsAbsenceReasonIdPut is used to update
     *
     * @param absenceReasonId the absenceReason ID for the AbsenceReason object to update
     * @param absenceReason the new data for the AbsenceReason object
     * @return the newly updated AbsenceReasonDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a AbsenceReason entity", notes = "A PUT request to the AbsenceReason instance endpoint with a AbsenceReason object in the request body will update an existing AbsenceReason entity in the database.", response = AbsenceReasonDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated AbsenceReason object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{absenceReasonId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<AbsenceReasonDto> update(
            @ApiParam(value = "The unique ID of the AbsenceReason to retrieve", required = true)
            @PathVariable("absenceReasonId") Integer absenceReasonId,
            @ApiParam(value = "The AbsenceReason object to be created, without the absenceReasonId fields", required = true)
            @RequestBody AbsenceReasonDto absenceReasonDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** AbsenceReasonsApi - absenceReasonsPUT");
        if (absenceReasonId != absenceReasonDto.id) {
            throw new InvalidDataException()
        }
        AbsenceReason absenceReason = absenceReasonService.updateFromDto(absenceReasonDto)
        return new ResponseEntity<AbsenceReasonDto>(AbsenceReasonDto.mapFromEntity(absenceReason), HttpStatus.OK);
    }
}
