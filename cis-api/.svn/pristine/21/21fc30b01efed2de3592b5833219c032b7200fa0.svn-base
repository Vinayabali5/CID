package uk.ac.reigate.api;

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
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import uk.ac.reigate.domain.academic.SchoolReference
import uk.ac.reigate.dto.SchoolReferenceDto
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.SchoolReferenceService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/schoolReferences", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/schoolReferences", description = "the schoolReferences API")
public class SchoolReferencesApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolReferencesApi.class);
    
    @Autowired
    private final SchoolReferenceService schoolReferenceService;
    
    /**
     * Default NoArgs constructor
     */
    SchoolReferencesApi() {}
    
    /**
     * Autowired constructor
     */
    SchoolReferencesApi(SchoolReferenceService schoolReferenceService) {
        this.schoolReferenceService = schoolReferenceService;
    }
    
    /**
     * The schoolReferencesGet method is used to retrieve a full list of all the SchoolReferenceDto objects
     *
     * @return A ResponseEntity with the corresponding list of SchoolReferenceDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of SchoolReference entities", notes = "A GET request to the SchoolReferences endpoint returns an array of all the schoolReferences in the system.", response = SchoolReferenceDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of schoolReferences")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<SchoolReferenceDto>> getAll() throws NotFoundException {
        LOGGER.info("** SchoolReferencesApi - schoolReferencesGet");
        List<SchoolReference> schoolReferences = schoolReferenceService.findAll();
        return new ResponseEntity<List<SchoolReferenceDto>>(SchoolReferenceDto.mapFromList(schoolReferences), HttpStatus.OK);
    }
    
    
    /**
     * The schoolReferencesSchoolReferenceIdGet method is used to retrieve an instance of a SchoolReferenceDto object as identified by the schoolReferenceId provided
     *
     * @param schoolReferenceId the schoolReference ID for the SchoolReference object retrieve
     * @return A ResponseEntity with the corresponding SchoolReferenceDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a SchoolReference identified by the schoolReferenceId", notes = "A getGET request to the SchoolReference instance endpoint will retrieve an instance of a SchoolReference entity as identified by the schoolReferenceId provided in the URI.", response = SchoolReferenceDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the SchoolReference as identified by the schoolReferenceId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{studentId}/schoolReferences", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<SchoolReferenceDto> getByStudentId(
            @ApiParam(value = "The unique ID of the SchoolReference to retrieve", required = true)
            @PathVariable("studentId") Integer studentId
    ) throws NotFoundException {
        LOGGER.info("** SchoolReferencesApi - schoolReferencesSchoolReferenceIdGet");
        SchoolReference schoolReference = schoolReferenceService.findSchoolReference(studentId);
        //        if (schoolReference == null) {
        //            throw new NotFoundException();
        //        }
        return new ResponseEntity<SchoolReferenceDto>(SchoolReferenceDto.mapFromEntity(schoolReference), HttpStatus.OK);
    }
}
