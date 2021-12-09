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
import uk.ac.reigate.domain.academic.PreReference
import uk.ac.reigate.dto.PreReferenceDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.PreReferenceService


@Controller
@RequestMapping(value = "/preReferences", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/preReferences", description = "the preReferences API")
public class PreReferencesApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PreReferencesApi.class);
    
    @Autowired
    private final PreReferenceService preReferenceService;
    
    /**
     * Default NoArgs constructor
     */
    PreReferencesApi() {}
    
    /**
     * Autowired constructor
     */
    PreReferencesApi(PreReferenceService preReferenceService) {
        this.preReferenceService = preReferenceService;
    }
    
    /**
     * The preReferencesGet method is used to retrieve a full list of all the PreReferenceDto objects
     *
     * @return A ResponseEntity with the corresponding list of PreReferenceDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of PreReference entities", notes = "A GET request to the PreReferences endpoint returns an array of all the preReferences in the system.", response = PreReferenceDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of preReferences")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<PreReferenceDto>> getAll() throws NotFoundException {
        LOGGER.info("** PreReferencesApi - preReferencesGet");
        List<PreReference> preReferences = preReferenceService.findAll();
        return new ResponseEntity<List<PreReferenceDto>>(PreReferenceDto.mapFromList(preReferences), HttpStatus.OK);
    }
    
    /**
     * The preReferencesPreReferenceIdGet method is used to retrieve an instance of a PreReferenceDto object as identified by the preReferenceId provided
     *
     * @param preReferenceId the preReference ID for the PreReference object retrieve
     * @return A ResponseEntity with the corresponding PreReferenceDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a PreReference identified by the preReferenceId", notes = "A getGET request to the PreReference instance endpoint will retrieve an instance of a PreReference entity as identified by the preReferenceId provided in the URI.", response = PreReferenceDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the PreReference as identified by the preReferenceId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{studentId}/{courseId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<PreReferenceDto> getById(
            @ApiParam(value = "The unique ID of the PreReference to retrieve", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value = "The unique ID of the PreReference to retrieve", required = true)
            @PathVariable("courseId") Integer courseId
    ) throws NotFoundException {
        LOGGER.info("** PreReferencesApi - preReferencesPreReferenceIdGet");
        PreReference preReference = preReferenceService.findByStudentIdAndCourseId(studentId, courseId);
        if (preReference == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<PreReferenceDto>(PreReferenceDto.mapFromEntity(preReference), HttpStatus.OK);
    }
}
