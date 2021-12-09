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
import uk.ac.reigate.domain.staff.Religion
import uk.ac.reigate.dto.staff.ReligionDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.staff.ReligionService


@Controller
@RequestMapping(value = "/religions", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/religions", description = "the religions API")
public class ReligionsApi implements ICoreDataBaseApi<ReligionDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ReligionsApi.class);
    
    @Autowired
    private final ReligionService religionService;
    
    /**
     * Default NoArgs constructor
     */
    ReligionsApi() {}
    
    /**
     * Autowired constructor
     */
    ReligionsApi(ReligionService religionService) {
        this.religionService = religionService;
    }
    
    /**
     * The religionsGet method is used to retrieve a full list of all the ReligionDto objects
     *
     * @return A ResponseEntity with the corresponding list of ReligionDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of Religion entities", notes = "A GET request to the Religions endpoint returns an array of all the religions in the system.", response = ReligionDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of religions")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<ReligionDto>> getAll() throws NotFoundException {
        LOGGER.info("** ReligionsApi - religionsGet");
        List<Religion> religions = religionService.findAll();
        return new ResponseEntity<List<ReligionDto>>(ReligionDto.mapFromList(religions), HttpStatus.OK);
    }
    
    /**
     * The religionsPost method is used to create a new instance of a Religion from the supplied ReligionDto
     *
     * @param religion the ReligionDto to use to create the new Religion object
     * @return A ResponseEntity with the newly created Religion object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new Religion entity", notes = "A POST request to the Religions endpoint with a Religion object in the request body will create a new Religion entity in the database.", response = ReligionDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created Religion entity including the religionId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<ReligionDto> create(
            @ApiParam(value = "The Religion object to be created, without the religionId fields", required = true)
            @RequestBody @Valid ReligionDto religionDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** ReligionsApi - religionsPOST");
        if (religionDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        Religion religion = religionService.createFromDto(religionDto)
        return new ResponseEntity<ReligionDto>(ReligionDto.mapFromEntity(religion), HttpStatus.CREATED);
    }
    
    /**
     * The religionsReligionIdGet method is used to retrieve an instance of a ReligionDto object as identified by the religionId provided
     *
     * @param religionId the religion ID for the Religion object retrieve
     * @return A ResponseEntity with the corresponding ReligionDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a Religion identified by the religionId", notes = "A getGET request to the Religion instance endpoint will retrieve an instance of a Religion entity as identified by the religionId provided in the URI.", response = ReligionDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Religion as identified by the religionId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{religionId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<ReligionDto> getById(
            @ApiParam(value = "The unique ID of the Religion to retrieve", required = true)
            @PathVariable("religionId") Integer religionId
    ) throws NotFoundException {
        LOGGER.info("** ReligionsApi - religionsReligionIdGet");
        Religion religion = religionService.findById(religionId);
        if (religion == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<ReligionDto>(ReligionDto.mapFromEntity(religion), HttpStatus.OK);
    }
    
    /**
     * The religionsReligionIdPut is used to update
     *
     * @param religionId the religion ID for the Religion object to update
     * @param religion the new data for the Religion object
     * @return the newly updated ReligionDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a Religion entity", notes = "A PUT request to the Religion instance endpoint with a Religion object in the request body will update an existing Religion entity in the database.", response = ReligionDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated Religion object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{religionId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<ReligionDto> update(
            @ApiParam(value = "The unique ID of the Religion to retrieve", required = true)
            @PathVariable("religionId") Integer religionId,
            @ApiParam(value = "The Religion object to be created, without the religionId fields", required = true)
            @RequestBody ReligionDto religionDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** ReligionsApi - religionsPUT");
        if (religionId != religionDto.id) {
            throw new InvalidDataException()
        }
        Religion religion = religionService.updateFromDto(religionDto)
        return new ResponseEntity<ReligionDto>(ReligionDto.mapFromEntity(religion), HttpStatus.OK);
    }
}
