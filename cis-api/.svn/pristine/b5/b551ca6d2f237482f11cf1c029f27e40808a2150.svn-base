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
import uk.ac.reigate.domain.cristal.InterimReportEffortGrade
import uk.ac.reigate.dto.cristal.InterimReportEffortGradeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.cristal.InterimReportEffortGradeService


@Controller
@RequestMapping(value = "/interim-report-effort-grades", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/interim-report-effort-grades", description = "the interimReportEffortGrades API")
public class InterimReportEffortGradeApi implements ICoreDataBaseApi<InterimReportEffortGradeDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(InterimReportEffortGradeApi.class);
    
    @Autowired
    private final InterimReportEffortGradeService interimReportEffortGradeService;
    
    /**
     * Default NoArgs constructor
     */
    InterimReportEffortGradeApi() {}
    
    /**
     * Autowired constructor
     */
    InterimReportEffortGradeApi(InterimReportEffortGradeService interimReportEffortGradeService) {
        this.interimReportEffortGradeService = interimReportEffortGradeService;
    }
    
    /**
     * The interimReportEffortGradesGet method is used to retrieve a full list of all the InterimReportEffortGradeDto objects
     *
     * @return A ResponseEntity with the corresponding list of InterimReportEffortGradeDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of InterimReportEffortGrade entities", notes = "A GET request to the InterimReportEffortGrades endpoint returns an array of all the interimReportEffortGrades in the system.", response = InterimReportEffortGradeDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of interimReportEffortGrades")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<InterimReportEffortGradeDto>> interimReportEffortGradesGet() throws NotFoundException {
        LOGGER.info("** InterimReportEffortGradesApi - interimReportEffortGradesGet");
        List<InterimReportEffortGrade> interimReportEffortGrades = interimReportEffortGradeService.findAll();
        return new ResponseEntity<List<InterimReportEffortGradeDto>>(InterimReportEffortGradeDto.mapFromList(interimReportEffortGrades), HttpStatus.OK);
    }
    
    /**
     * The interimReportEffortGradesPost method is used to create a new instance of a InterimReportEffortGrade from the supplied InterimReportEffortGradeDto
     *
     * @param interimReportEffortGrade the InterimReportEffortGradeDto to use to create the new InterimReportEffortGrade object
     * @return A ResponseEntity with the newly created InterimReportEffortGrade object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new InterimReportEffortGrade entity", notes = "A POST request to the InterimReportEffortGrades endpoint with a InterimReportEffortGrade object in the request body will create a new InterimReportEffortGrade entity in the database.", response = InterimReportEffortGradeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created InterimReportEffortGrade entity including the interimReportEffortGradeId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<InterimReportEffortGradeDto> create(
            @ApiParam(value = "The InterimReportEffortGrade object to be created, without the interimReportEffortGradeId fields", required = true)
            @RequestBody @Valid InterimReportEffortGradeDto interimReportEffortGradeDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** InterimReportEffortGradesApi - interimReportEffortGradesPOST");
        if (interimReportEffortGradeDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        InterimReportEffortGrade interimReportEffortGrade = interimReportEffortGradeService.createFromDto(interimReportEffortGradeDto)
        return new ResponseEntity<InterimReportEffortGradeDto>(InterimReportEffortGradeDto.mapFromEntity(interimReportEffortGrade), HttpStatus.CREATED);
    }
    
    /**
     * The interimReportEffortGradesInterimReportEffortGradeIdGet method is used to retrieve an instance of a InterimReportEffortGradeDto object as identified by the interimReportEffortGradeId provided
     *
     * @param interimReportEffortGradeId the interimReportEffortGrade ID for the InterimReportEffortGrade object retrieve
     * @return A ResponseEntity with the corresponding InterimReportEffortGradeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a InterimReportEffortGrade identified by the interimReportEffortGradeId", notes = "A getGET request to the InterimReportEffortGrade instance endpoint will retrieve an instance of a InterimReportEffortGrade entity as identified by the interimReportEffortGradeId provided in the URI.", response = InterimReportEffortGradeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the InterimReportEffortGrade as identified by the interimReportEffortGradeId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{interimReportEffortGradeId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<InterimReportEffortGradeDto> getById(
            @ApiParam(value = "The unique ID of the InterimReportEffortGrade to retrieve", required = true)
            @PathVariable("interimReportEffortGradeId") Integer interimReportEffortGradeId
    ) throws NotFoundException {
        LOGGER.info("** InterimReportEffortGradesApi - interimReportEffortGradesInterimReportEffortGradeIdGet");
        InterimReportEffortGrade interimReportEffortGrade = interimReportEffortGradeService.findById(interimReportEffortGradeId);
        if (interimReportEffortGrade == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<InterimReportEffortGradeDto>(InterimReportEffortGradeDto.mapFromEntity(interimReportEffortGrade), HttpStatus.OK);
    }
    
    /**
     * The interimReportEffortGradesInterimReportEffortGradeIdPut is used to update
     *
     * @param interimReportEffortGradeId the interimReportEffortGrade ID for the InterimReportEffortGrade object to update
     * @param interimReportEffortGrade the new data for the InterimReportEffortGrade object
     * @return the newly updated InterimReportEffortGradeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a InterimReportEffortGrade entity", notes = "A PUT request to the InterimReportEffortGrade instance endpoint with a InterimReportEffortGrade object in the request body will update an existing InterimReportEffortGrade entity in the database.", response = InterimReportEffortGradeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated InterimReportEffortGrade object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{interimReportEffortGradeId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<InterimReportEffortGradeDto> update(
            @ApiParam(value = "The unique ID of the InterimReportEffortGrade to retrieve", required = true)
            @PathVariable("interimReportEffortGradeId") Integer interimReportEffortGradeId,
            @ApiParam(value = "The InterimReportEffortGrade object to be created, without the interimReportEffortGradeId fields", required = true)
            @RequestBody InterimReportEffortGradeDto interimReportEffortGradeDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** InterimReportEffortGradesApi - interimReportEffortGradesPUT");
        if (interimReportEffortGradeId != interimReportEffortGradeDto.id) {
            throw new InvalidDataException()
        }
        InterimReportEffortGrade interimReportEffortGrade = interimReportEffortGradeService.updateFromDto(interimReportEffortGradeDto)
        return new ResponseEntity<InterimReportEffortGradeDto>(InterimReportEffortGradeDto.mapFromEntity(interimReportEffortGrade), HttpStatus.OK);
    }
}
