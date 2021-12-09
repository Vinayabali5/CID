package uk.ac.reigate.api

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

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
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.security.access.annotation.Secured
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import uk.ac.reigate.domain.ilp.Correspondence
import uk.ac.reigate.dto.CorrespondenceDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.CorrespondenceService

@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the correspondences API")
public class CorrespondencesApi implements ICoreDataApi<CorrespondenceDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CorrespondencesApi.class);
    
    @Autowired
    private final CorrespondenceService correspondenceService;
    
    /**
     * Default NoArgs constructor
     */
    CorrespondencesApi() {}
    
    /**
     * Autowired constructor
     */
    CorrespondencesApi(CorrespondenceService correspondenceService) {
        this.correspondenceService = correspondenceService;
    }
    
    /**
     * The correspondencesStudentIdGet method is used to retrieve an instance of a CorrespondenceDto object as identified by the studentId provided
     *
     * @param studentId the student ID for the Correspondence object retrieve
     * @return A ResponseEntity with the corresponding CorrespondenceDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a Correspondence identified by the correspondenceId",
    notes = "A getGET request to the Correspondence instance endpoint will retrieve an instance of a Correspondence entity as identified by the correspondenceId provided in the URI.",
    response = CorrespondenceDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Correspondence as identified by the correspondenceId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/students/{studentId}/correspondence", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<CorrespondenceDto> getByStudentId(
            @ApiParam(value = "The unique ID of the Correspondence to retrieve", required = true)
            @PathVariable("studentId") Integer studentId
    ) throws NotFoundException {
        LOGGER.info("** CorrespondencesApi - correspondencesCorrespondenceIdGet");
        List<Correspondence> correspondence = correspondenceService.getByStudent(studentId);
        if (correspondence == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<CorrespondenceDto>(CorrespondenceDto.mapFromList(correspondence), HttpStatus.OK);
    }
    
    /**
     * The correspondencesPost method is used to create a new instance of a Correspondence from the supplied CorrespondenceDto
     *
     * @param correspondence the CorrespondenceDto to use to create the new Correspondence object
     * @return A ResponseEntity with the newly created Correspondence object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new Correspondence entity", notes = "A POST request to the Correspondences endpoint with a Correspondence object in the request body will create a new Correspondence entity in the database.", response = CorrespondenceDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created Correspondence entity including the correspondenceId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "/correspondence", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<CorrespondenceDto> create(
            @ApiParam(value = "The Correspondence object to be created, without the correspondenceId fields", required = true)
            @RequestBody @Valid CorrespondenceDto correspondence
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** CorrespondencesApi - correspondencesPOST");
        if (correspondence.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        Correspondence correspondenceSaved = correspondenceService.createFromDto(correspondence)
        return new ResponseEntity<CorrespondenceDto>(CorrespondenceDto.mapFromEntity(correspondenceSaved), HttpStatus.CREATED);
    }
    
    /**
     * The correspondencesCorrespondenceIdGet method is used to retrieve an instance of a CorrespondenceDto object as identified by the studentId and correspondenceId provided
     *
     * @param studentId, correspondenceId the student ID and Correspondence Id for the Correspondence object retrieve
     * @return A ResponseEntity with the corresponding CorrespondenceDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a Correspondence identified by the correspondenceId", notes = "A getGET request to the Correspondence instance endpoint will retrieve an instance of a Correspondence entity as identified by the correspondenceId provided in the URI.", response = CorrespondenceDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Correspondence as identified by the correspondenceId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/students/{studentId}/ilpCorrespondence/{correspondenceId} ", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<CorrespondenceDto> getByIdAndStudentId(
            @ApiParam(value = "The unique ID of the Student to retrieve", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value = "The unique ID of the Correspondence to retrieve", required = true)
            @PathVariable("correspondenceId") Integer correspondenceId) throws NotFoundException {
        LOGGER.info("** CorrespondencesApi - correspondencesCorrespondenceIdGet");
        Correspondence correspondence = correspondenceService.getByStudentAndCorrespondence(studentId, correspondenceId);
        if (correspondence == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<CorrespondenceDto>(CorrespondenceDto.mapFromEntity(correspondence), HttpStatus.OK);
    }
    
    /**
     * The correspondencesCorrespondenceIdPut is used to update
     *
     * @param correspondenceId the correspondence ID for the Correspondence object to update
     * @param correspondence the new data for the Correspondence object
     * @return the newly updated CorrespondenceDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a Correspondence entity", notes = "A PUT request to the Correspondence instance endpoint with a Correspondence object in the request body will update an existing Correspondence entity in the database.", response = CorrespondenceDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated Correspondence object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/correspondence/{correspondenceId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<CorrespondenceDto> update(
            @ApiParam(value = "The unique ID of the Correspondence to retrieve", required = true)
            @PathVariable("correspondenceId") Integer correspondenceId,
            @ApiParam(value = "The Correspondence object to be created, without the correspondenceId fields", required = true)
            @RequestBody CorrespondenceDto correspondence
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** CorrespondencesApi - correspondencesPUT");
        if (correspondenceId != correspondence.id) {
            throw new InvalidDataException()
        }
        Correspondence correspondenceSaved = correspondenceService.updateFromDto(correspondence)
        return new ResponseEntity<CorrespondenceDto>(CorrespondenceDto.mapFromEntity(correspondenceSaved), HttpStatus.OK);
    }
    
    @Override
    public ResponseEntity<CorrespondenceDto> getById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public ResponseEntity<List<CorrespondenceDto>> getAll() {
        // TODO Auto-generated method stub
        return null;
    }
}
