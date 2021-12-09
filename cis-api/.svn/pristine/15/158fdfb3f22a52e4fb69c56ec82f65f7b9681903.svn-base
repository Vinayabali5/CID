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
import uk.ac.reigate.domain.staff.SexualOrientation
import uk.ac.reigate.dto.staff.SexualOrientationDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.staff.SexualOrientationService


@Controller
@RequestMapping(value = "/sexual-orientations", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/sexual-orientations", description = "the sexualOrientations API")
public class SexaulOrientationsApi implements ICoreDataBaseApi<SexualOrientationDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SexaulOrientationsApi.class);
    
    @Autowired
    private final SexualOrientationService sexualOrientationService;
    
    /**
     * Default NoArgs constructor
     */
    SexaulOrientationsApi() {}
    
    /**
     * Autowired constructor
     */
    SexaulOrientationsApi(SexualOrientationService sexualOrientationService) {
        this.sexualOrientationService = sexualOrientationService;
    }
    
    /**
     * The sexualOrientationsGet method is used to retrieve a full list of all the SexualOrientationDto objects
     *
     * @return A ResponseEntity with the corresponding list of SexualOrientationDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of SexualOrientation entities", notes = "A GET request to the SexualOrientations endpoint returns an array of all the sexualOrientations in the system.", response = SexualOrientationDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of sexualOrientations")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<SexualOrientationDto>> getAll() throws NotFoundException {
        LOGGER.info("** SexualOrientationsApi - sexualOrientationsGet");
        List<SexualOrientation> sexualOrientations = sexualOrientationService.findAll();
        return new ResponseEntity<List<SexualOrientationDto>>(SexualOrientationDto.mapFromList(sexualOrientations), HttpStatus.OK);
    }
    
    /**
     * The sexualOrientationsPost method is used to create a new instance of a SexualOrientation from the supplied SexualOrientationDto
     *
     * @param sexualOrientation the SexualOrientationDto to use to create the new SexualOrientation object
     * @return A ResponseEntity with the newly created SexualOrientation object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new SexualOrientation entity", notes = "A POST request to the SexualOrientations endpoint with a SexualOrientation object in the request body will create a new SexualOrientation entity in the database.", response = SexualOrientationDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created SexualOrientation entity including the sexualOrientationId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<SexualOrientationDto> create(
            @ApiParam(value = "The SexualOrientation object to be created, without the sexualOrientationId fields", required = true)
            @RequestBody @Valid SexualOrientationDto sexualOrientationDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** SexualOrientationsApi - sexualOrientationsPOST");
        if (sexualOrientationDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        SexualOrientation sexualOrientation = sexualOrientationService.createFromDto(sexualOrientationDto)
        return new ResponseEntity<SexualOrientationDto>(SexualOrientationDto.mapFromEntity(sexualOrientation), HttpStatus.CREATED);
    }
    
    /**
     * The sexualOrientationsSexualOrientationIdGet method is used to retrieve an instance of a SexualOrientationDto object as identified by the sexualOrientationId provided
     *
     * @param sexualOrientationId the sexualOrientation ID for the SexualOrientation object retrieve
     * @return A ResponseEntity with the corresponding SexualOrientationDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a SexualOrientation identified by the sexualOrientationId", notes = "A getGET request to the SexualOrientation instance endpoint will retrieve an instance of a SexualOrientation entity as identified by the sexualOrientationId provided in the URI.", response = SexualOrientationDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the SexualOrientation as identified by the sexualOrientationId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{sexualOrientationId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<SexualOrientationDto> getById(
            @ApiParam(value = "The unique ID of the SexualOrientation to retrieve", required = true)
            @PathVariable("sexualOrientationId") Integer sexualOrientationId
    ) throws NotFoundException {
        LOGGER.info("** SexualOrientationsApi - sexualOrientationsSexualOrientationIdGet");
        SexualOrientation sexualOrientation = sexualOrientationService.findById(sexualOrientationId);
        if (sexualOrientation == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<SexualOrientationDto>(SexualOrientationDto.mapFromEntity(sexualOrientation), HttpStatus.OK);
    }
    
    /**
     * The sexualOrientationsSexualOrientationIdPut is used to update
     *
     * @param sexualOrientationId the sexualOrientation ID for the SexualOrientation object to update
     * @param sexualOrientation the new data for the SexualOrientation object
     * @return the newly updated SexualOrientationDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a SexualOrientation entity", notes = "A PUT request to the SexualOrientation instance endpoint with a SexualOrientation object in the request body will update an existing SexualOrientation entity in the database.", response = SexualOrientationDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated SexualOrientation object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{sexualOrientationId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<SexualOrientationDto> update(
            @ApiParam(value = "The unique ID of the SexualOrientation to retrieve", required = true)
            @PathVariable("sexualOrientationId") Integer sexualOrientationId,
            @ApiParam(value = "The SexualOrientation object to be created, without the sexualOrientationId fields", required = true)
            @RequestBody SexualOrientationDto sexualOrientationDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** SexualOrientationsApi - sexualOrientationsPUT");
        if (sexualOrientationId != sexualOrientationDto.id) {
            throw new InvalidDataException()
        }
        SexualOrientation sexualOrientation = sexualOrientationService.updateFromDto(sexualOrientationDto)
        return new ResponseEntity<SexualOrientationDto>(SexualOrientationDto.mapFromEntity(sexualOrientation), HttpStatus.OK);
    }
}
