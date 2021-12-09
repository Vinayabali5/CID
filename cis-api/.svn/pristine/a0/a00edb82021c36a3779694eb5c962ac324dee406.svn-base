package uk.ac.reigate.api.ilp;

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
import uk.ac.reigate.domain.ilp.ILPInterview
import uk.ac.reigate.dto.ilp.ILPInterviewDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.ilp.ILPInterviewService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the ilpInterviews API")
public class ILPInterviewsApi implements ICoreDataBaseApi<ILPInterviewDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ILPInterviewsApi.class);
    
    @Autowired
    private final ILPInterviewService ilpInterviewService
    
    /**
     * Default NoArgs constructor
     */
    ILPInterviewsApi() {}
    
    /**
     * Autowired constructor
     */
    ILPInterviewsApi(ILPInterviewService ilpInterviewService) {
        this.ilpInterviewService = ilpInterviewService;
    }
    
    /**
     * The ilpInterviewsILPInterviewIdGet method is used to retrieve an instance of a ILPInterviewDto object as identified by the studentId and ilpInterviewId provided
     *
     * @param studentId, ilpInterviewId the student ID and ILPInterview Id for the ILPInterview object retrieve
     * @return A ResponseEntity with the corresponding ILPInterviewDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a ILPInterview identified by the ilpInterviewId", notes = "A getGET request to the ILPInterview instance endpoint will retrieve an instance of a ILPInterview entity as identified by the ilpInterviewId provided in the URI.", response = ILPInterviewDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the ILPInterview as identified by the ilpInterviewId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = [
        "/ilpInterviews/{ilpInterviewId}",
        "/ilp-interviews/{ilpInterviewId}"
    ], produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<ILPInterviewDto> getById(
            @ApiParam(value = "The unique ID of the ILPInterview to retrieve", required = true)
            @PathVariable("ilpInterviewId") Integer ilpInterviewId
    ) throws NotFoundException {
        LOGGER.info("** ILPInterviewsApi - getById");
        ILPInterview ilpInterview = ilpInterviewService.findById(ilpInterviewId);
        if (ilpInterview == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<ILPInterviewDto>(ILPInterviewDto.mapFromEntity(ilpInterview), HttpStatus.OK);
    }
    
    /**
     * The ilpInterviewsPost method is used to create a new instance of a ILPInterview from the supplied ILPInterviewDto
     *
     * @param ilpInterview the ILPInterviewDto to use to create the new ILPInterview object
     * @return A ResponseEntity with the newly created ILPInterview object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new ILPInterview entity", notes = "A POST request to the ILPInterviews endpoint with a ILPInterview object in the request body will create a new ILPInterview entity in the database.", response = ILPInterviewDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created ILPInterview entity including the ilpInterviewId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = [
        "/ilpInterviews",
        "/ilp-interviews"
    ], produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<ILPInterviewDto> create(
            @ApiParam(value = "The ILPInterview object to be created, without the ilpInterviewId fields", required = true)
            @RequestBody @Valid ILPInterviewDto ilpInterviewDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** ILPInterviewsApi - create");
        if (ilpInterviewDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        ILPInterview ilpInterview = ilpInterviewService.createFromDto(ilpInterviewDto)
        return new ResponseEntity<ILPInterviewDto>(ILPInterviewDto.mapFromEntity(ilpInterview), HttpStatus.CREATED);
    }
    
    /**
     * The ilpInterviewsILPInterviewIdPut is used to update
     *
     * @param ilpInterviewId the ilpInterview ID for the ILPInterview object to update
     * @param ilpInterview the new data for the ILPInterview object
     * @return the newly updated ILPInterviewDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a ILPInterview entity", notes = "A PUT request to the ILPInterview instance endpoint with a ILPInterview object in the request body will update an existing ILPInterview entity in the database.", response = ILPInterviewDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated ILPInterview object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = [
        "/ilpInterviews/{ilpInterviewId}",
        "/ilp-interviews/{ilpInterviewId}"
    ], produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<ILPInterviewDto> update(
            @ApiParam(value = "The unique ID of the ILPInterview to retrieve", required = true)
            @PathVariable("ilpInterviewId") Integer ilpInterviewId,
            @ApiParam(value = "The ILPInterview object to be created, without the ilpInterviewId fields", required = true)
            @RequestBody ILPInterviewDto ilpInterviewDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** ILPInterviewsApi - ilpInterviewsPUT");
        if (ilpInterviewId != ilpInterviewDto.id) {
            throw new InvalidDataException()
        }
        ILPInterview ilpInterview = ilpInterviewService.updateFromDto(ilpInterviewDto)
        return new ResponseEntity<ILPInterviewDto>(ILPInterviewDto.mapFromEntity(ilpInterview), HttpStatus.OK);
    }
    
    /**
     * The ilpInterviewsStudentIdGet method is used to retrieve an instance of a ILPInterviewDto object as identified by the studentId provided
     *
     * @param studentId the student ID for the ILPInterview object retrieve
     * @return A ResponseEntity with the corresponding ILPInterviewDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a ILPInterview identified by the ilpInterviewId", notes = "A getGET request to the ILPInterview instance endpoint will retrieve an instance of a ILPInterview entity as identified by the ilpInterviewId provided in the URI.", response = ILPInterviewDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the ILPInterview as identified by the ilpInterviewId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = [
        "/students/{studentId}/ilpInterviews",
        "/students/{studentId}/ilp-interviews"
    ], produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<ILPInterviewDto> getByStudentId(
            @ApiParam(value = "The unique ID of the ILPInterview to retrieve", required = true)
            @PathVariable("studentId") Integer studentId
    ) throws NotFoundException {
        LOGGER.info("** ILPInterviewsApi - getByStudentId");
        List<ILPInterview> ilpInterview = ilpInterviewService.getByStudent(studentId);
        if (ilpInterview == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<ILPInterviewDto>(ILPInterviewDto.mapFromList(ilpInterview), HttpStatus.OK);
    }
}