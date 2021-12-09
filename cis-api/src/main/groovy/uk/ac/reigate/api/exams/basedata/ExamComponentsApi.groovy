package uk.ac.reigate.api.exams.basedata

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

import uk.ac.reigate.api.ICoreDataApi
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.dto.DepartmentDto
import uk.ac.reigate.dto.exams.basedata.ExamComponentDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.exams.ExamDtoConverterService
import uk.ac.reigate.services.exams.basedata.ExamComponentService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

@Controller
@RequestMapping(value = "/components", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/components", description = "the exam components basedata API")
public class ExamComponentsApi implements ICoreDataApi<ExamComponentDto, Integer> {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(ExamComponentsApi.class);
    
    @Autowired
    private final ExamComponentService examComponentService;
    
    /**
     * Default NoArgs constructor
     */
    ExamComponentsApi() {}
    
    /**
     * Autowired constructor
     */
    ExamComponentsApi(ExamComponentService examComponentService) {
        this.examComponentService = examComponentService;
    }
    
    /**
     * The examComponentsGet method is used to retrieve a full list of all the ExamComponentDto objects
     * 
     * @return A responseEntity with the corresponding list of ExamComponentDto objects
     * @throws NotFoundException if nothing is found then the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of ExamComponent entities", notes = "A GET request to the ExamComponents endpoint returns an array of all the examComponents in the system.", response = ExamComponentDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of examComponents")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<ExamComponentDto>> getAll() throws NotFoundException {
        LOGGER.info("** ExamComponentsApi - examComponentsGet");
        List<ExamComponent> examComponents = examComponentService.findAll();
        return new ResponseEntity<List<ExamComponentDto>>(ExamComponentDto.mapFromList(examComponents), HttpStatus.OK);
    }
    
    /**
     * The examComponentsExamComponentIdGet method is used to retrieve an instance of an ExamComponentDto object as identified by the examComponentId provided
     *
     * @param examComponentId the examComponent ID for the ExamComponent object to retrieve
     * @return A ResponseEntity with the corresponding ExamComponentDto object
     * @throws NotFoundException if nothing is found then the NotFoundException is thrown.
     */
    @ApiOperation(value = "retrieves an individual instance of an ExamComponent identified by the examComponentId", notes = "A GET request to the ExamComponent endpoint will retrieve an instance of an ExamComponent entity as identified by the examComponentId provided in the URI.", response = ExamComponentDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the ExamComponent as identified by the examComponentId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified ID cannot be found in the database.")
    ])
    @RequestMapping(value = "/{examComponentId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<ExamComponentDto> getById(
            @ApiParam(value = "The unique ID of the ExamComponent to retrieve.", required = true)
            @PathVariable("examComponentId") Integer examComponentId
    ) throws NotFoundException {
        LOGGER.info("** ExamComponentsApi - examComponentsExamComponentsIdGet");
        ExamComponent examComponent = examComponentService.findById(examComponentId);
        if (examComponent == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<ExamComponentDto>(ExamComponentDto.mapFromEntity(examComponent), HttpStatus.OK);
    }
    
    /**
     * The examComponentsExamComponentIdGetByDateAndSession method is used to retrieve a list of ExamComponentDto objects as identified by examDate and examSession
     *
     * @param examdate the date for the ExamComponent objects to retrieve
     * @param examSession the session (A or P) for the ExamComponent objects to retrieve
     * @return A ResponseEntity with the corresponding ExamComponentDto object
     * @throws NotFoundException if nothing is found then the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieve a collection of ExamComponent entities identified by the examDate and examSession",
    notes = "A GET request to the ExamComponent endpoint will retrieve a collection of ExamComponent entities as identified by the examDate and examSession provided in the URI.", response = ExamComponentDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a list of ExamComponents as identified by the examDate and examSession"),
        @ApiResponse(code = 404, message = "?.")
    ])
    @RequestMapping(value = "/{examDate}/{examSession}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<ExamComponentDto>> getExamDateAndSession(
            @ApiParam(value = "The examDate of the examComponents to retrieve.", required = true)
            @PathVariable("examDate") Long examTimestamp,
            @ApiParam(value = "The examSession of the ExamComponents to retrieve.", required = true)
            @PathVariable("examSession") String examSession
    ) throws NotFoundException {
        LOGGER.info("** ExamComponentsApi - examComponentsExamDateAndSessionGet");
        Date examDate = new Date((long)examTimestamp);
        List<ExamComponent> examComponents = examComponentService.findExamComponentsByDateAndSession(examDate, examSession);
        if (examComponents == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<List<ExamComponentDto>>(ExamComponentDto.mapFromList(examComponents), HttpStatus.OK);
    }
    
    /**
     * The examComponentsPost method is used to create a new instance of an ExamComponent from the supplied ExamComponentDto
     * 
     * @param examComponent the ExamComponentDto to use to create the new ExamComponent object
     * @return A ResponseEntity with the newly created ExamComponent object
     * @throws InvalidDataException if there is an issue         with the data provided in the requestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new ExamComponent entity", notes = "A POST request to the ExamComponents endpoint with an ExamComponent object in the request body will create a new ExamComponent entity in the database.", response = ExamComponentDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created ExamComponent entity including the examComponentId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<ExamComponentDto> create(
            @ApiParam(value = "The ExamComponent object to be created, without the examComponentId fields", required = true)
            @RequestBody @Valid ExamComponentDto examComponent
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** ExamComponentsApi - examBoardsPOST");
        if (examComponent.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating");
        }
        ExamComponent examComponentSaved = examComponentService.createFromDto(examComponent);
        return new ResponseEntity<ExamComponentDto>(ExamComponentDto.mapFromEntity(examComponentSaved), HttpStatus.CREATED);
    }
    
    /**
     * The examComponentsExamComponentIdPut is used to update an instance of an ExamComponent from the supplied ExamComponentDto object
     * 
     * @param examComponentId the examComponent ID for the ExamComponent object to update
     * @param examComponent the new data for the ExamComponent object
     * @return the newly updated ExamComponentDto object
     * @throws NotFoundException if nothing is found then the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDatException is thrown 
     */
    @ApiOperation(value = "Used to update an ExamComponent entity", notes = "A PUT request to the ExamComponent instance endpoint with an ExamComponent object in the request body will update an existing ExamComponent entity in the database", response = ExamComponentDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated ExamComponent object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating that the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified ID cannot be found in the database.")
    ])
    @RequestMapping(value = "/{examComponentId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<ExamComponentDto> update(
            @ApiParam(value = "The unique ID of the ExamComponent to update", required = true)
            @PathVariable("examComponentId") Integer examComponentId,
            @ApiParam(value = "The ExamComponent object to be created, without the examComponentId fields", required = true)
            @RequestBody ExamComponentDto examComponent
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** ExamComponentsApi - examComponentsExamComponentIdPut");
        if (examComponentId != examComponent.id) {
            throw new InvalidDataException();
        }
        ExamComponent examComponentSaved = examComponentService.updateFromDto(examComponent);
        return new ResponseEntity<ExamComponentDto>(ExamComponentDto.mapFromEntity(examComponentSaved), HttpStatus.OK);
    }
}
