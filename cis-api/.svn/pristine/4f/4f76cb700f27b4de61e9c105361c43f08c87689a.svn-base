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
import uk.ac.reigate.domain.lookup.VolunteeringExperience
import uk.ac.reigate.dto.lookup.VolunteeringExperienceDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.lookup.VolunteeringExperienceService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/volunteering-experiences", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/volunteering-experiences", description = "the volunteeringExperiences API")
public class VolunteeringExperiencesApi implements ICoreDataBaseApi<VolunteeringExperienceDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(VolunteeringExperiencesApi.class);
    
    @Autowired
    private final VolunteeringExperienceService volunteeringExperienceService;
    
    /**
     * Default NoArgs constructor
     */
    VolunteeringExperiencesApi() {}
    
    /**
     * Autowired constructor
     */
    VolunteeringExperiencesApi(VolunteeringExperienceService volunteeringExperienceService) {
        this.volunteeringExperienceService = volunteeringExperienceService;
    }
    
    /**
     * This method is used to retrieve a full list of all the VolunteeringExperienceDto objects
     *
     * @return A ResponseEntity with the corresponding list of VolunteeringExperienceDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of VolunteeringExperience entities", notes = "A GET request to the VolunteeringExperiences endpoint returns an array of all the volunteeringExperiences in the system.", response = VolunteeringExperienceDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of volunteeringExperiences")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<VolunteeringExperienceDto>> getAll() throws NotFoundException {
        LOGGER.info("** VolunteeringExperiencesApi - volunteeringExperiencesGet");
        List<VolunteeringExperience> volunteeringExperiences = volunteeringExperienceService.findAll();
        return new ResponseEntity<List<VolunteeringExperienceDto>>(VolunteeringExperienceDto.mapFromList(volunteeringExperiences), HttpStatus.OK);
    }
    
    /**
     * This method is used to retrieve an instance of a VolunteeringExperienceDto object as identified by the volunteeringExperienceId provided
     *
     * @param volunteeringExperienceId the volunteeringExperience ID for the VolunteeringExperience object retrieve
     * @return A ResponseEntity with the corresponding VolunteeringExperienceDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a VolunteeringExperience identified by the volunteeringExperienceId", notes = "A getGET request to the VolunteeringExperience instance endpoint will retrieve an instance of a VolunteeringExperience entity as identified by the volunteeringExperienceId provided in the URI.", response = VolunteeringExperienceDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the VolunteeringExperience as identified by the volunteeringExperienceId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{volunteeringExperienceId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<VolunteeringExperienceDto> getById(
            @ApiParam(value = "The unique ID of the VolunteeringExperience to retrieve", required = true)
            @PathVariable("volunteeringExperienceId") Integer volunteeringExperienceId
    ) throws NotFoundException {
        LOGGER.info("** VolunteeringExperiencesApi - volunteeringExperiencesVolunteeringExperienceIdGet");
        VolunteeringExperience volunteeringExperience = volunteeringExperienceService.findById(volunteeringExperienceId);
        if (volunteeringExperience == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<VolunteeringExperienceDto>(VolunteeringExperienceDto.mapFromEntity(volunteeringExperience), HttpStatus.OK);
    }
    
    /**
     * This method is used to create a new instance of a VolunteeringExperience from the supplied VolunteeringExperienceDto
     *
     * @param volunteeringExperience the VolunteeringExperienceDto to use to create the new VolunteeringExperience object
     * @return A ResponseEntity with the newly created VolunteeringExperience object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new VolunteeringExperience entity", notes = "A POST request to the VolunteeringExperiences endpoint with a VolunteeringExperience object in the request body will create a new VolunteeringExperience entity in the database.", response = VolunteeringExperienceDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created VolunteeringExperience entity including the volunteeringExperienceId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<VolunteeringExperienceDto> create(
            @ApiParam(value = "The VolunteeringExperience object to be created, without the volunteeringExperienceId fields", required = true)
            @RequestBody @Valid VolunteeringExperienceDto volunteeringExperienceDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** VolunteeringExperiencesApi - volunteeringExperiencesPOST");
        if (volunteeringExperienceDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        VolunteeringExperience volunteeringExperience = volunteeringExperienceService.createFromDto(volunteeringExperienceDto)
        return new ResponseEntity<VolunteeringExperienceDto>(VolunteeringExperienceDto.mapFromEntity(volunteeringExperience), HttpStatus.CREATED);
    }
    
    /**
     * The volunteeringExperiencesVolunteeringExperienceIdPut is used to update
     *
     * @param volunteeringExperienceId the volunteeringExperience ID for the VolunteeringExperience object to update
     * @param volunteeringExperience the new data for the VolunteeringExperience object
     * @return the newly updated VolunteeringExperienceDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a VolunteeringExperience entity", notes = "A PUT request to the VolunteeringExperience instance endpoint with a VolunteeringExperience object in the request body will update an existing VolunteeringExperience entity in the database.", response = VolunteeringExperienceDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated VolunteeringExperience object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{volunteeringExperienceId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<VolunteeringExperienceDto> update(
            @ApiParam(value = "The unique ID of the VolunteeringExperience to retrieve", required = true)
            @PathVariable("volunteeringExperienceId") Integer volunteeringExperienceId,
            @ApiParam(value = "The VolunteeringExperience object to be created, without the volunteeringExperienceId fields", required = true)
            @RequestBody VolunteeringExperienceDto volunteeringExperienceDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** VolunteeringExperiencesApi - volunteeringExperiencesPUT");
        if (volunteeringExperienceId != volunteeringExperienceDto.id) {
            throw new InvalidDataException()
        }
        VolunteeringExperience volunteeringExperience = volunteeringExperienceService.updateFromDto(volunteeringExperienceDto)
        return new ResponseEntity<VolunteeringExperienceDto>(VolunteeringExperienceDto.mapFromEntity(volunteeringExperience), HttpStatus.OK);
    }
}
