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
import org.springframework.web.bind.annotation.RequestParam

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.exams.basedata.ExamSeries
import uk.ac.reigate.dto.exams.basedata.ExamSeriesDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.exams.basedata.ExamSeriesService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

@Controller
@RequestMapping(value = '/exam-series', produces = [APPLICATION_JSON_VALUE])
@Api(value = "/ExamSeriesApi", description = "The Exam ExamSeries Resource API")
public class ExamSeriesApi {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(ExamSeriesApi.class)
    
    @Autowired
    ExamSeriesService examSeriesService
    
    /**
     * Default No Args constructor    
     */
    ExamSeriesApi() {}
    
    /**
     * Default Autowired constructor
     */
    ExamSeriesApi(ExamSeriesService examSeriesService) {
        this.examSeriesService = examSeriesService;
    }
    
    /**
     * This method is used to retrieve a List of ExamSeries objects of the examSeriesDto objects
     * 
     * @param examBoardId ID of the examBoard to retrieve results for
     * @return A ResponseEntity with the corresponding list of examSeriesDto objects
     * @throws NotFoundException If nothing is found then the NotFoundException is thrown
     */
    @ApiOperation(value = "Collection of All examSeries entities",
    notes = "A GET request to the examSeries endpoint returns an array of ALL the examSeries in the system",
    response = ExamSeriesDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of examSeries")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<ExamSeriesDto>> getAll(
            @ApiParam(value = "exam Board Id", name = "examBoardId", required = false)
            @RequestParam(value = "examBoardId", required = false) Integer examBoardId,
            @ApiParam(value ="yearId", name = "yearId", required = false)
            @RequestParam(value = "yearId", required= false) Integer yearId
    ) throws NotFoundException {
        LOGGER.info("** ExamBoardApi - examSeriesGetNonPageable");
        List<ExamSeries> examSeries = examSeriesService.findExamSeriesList(examBoardId, yearId);
        return new ResponseEntity<List<ExamSeriesDto>>(ExamSeriesDto.mapFromList(examSeries), HttpStatus.OK);
    }
    
    /**
     * The examSeriesExamSeriesGet method is used to retrieve an instance of an ExamSeriesDto object as identified by the examSeriesId provided
     * 
     * @param examSeriesId The examSeriesId for the ExamSeriesDto object
     * @returns A ResponseEntity with the corresponding ExamSeriesDto object
     * @throws NotFoundException If nothing is found then the NotFoundException is thrown
     */
    @ApiOperation(value = "Retrieves an individual instance of an ExamSeries identified by the examSeriesId",
    notes = "A GET request to the ExamSeries instance endpoint will retrieve an instance of an ExamSeries entity as identified by the examSeriesId provided in the URI.",
    response = ExamSeriesDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the ExamSeries as identified by the examSeriesId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified ID cannot be found in the database.")
    ])
    @RequestMapping(value = "/{examSeriesId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<ExamSeriesDto> getById(
            @ApiParam(value = "This unique ID of the ExamSeries to retrieve", required = true)
            @PathVariable("examSeriesId") Integer examSeriesId
    ) throws NotFoundException {
        LOGGER.info("** ExamSeriesApi - examSeriesExamSeriesIdGet");
        ExamSeries examSeries = examSeriesService.findById(examSeriesId);
        if (examSeries == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<ExamSeriesDto>(ExamSeriesDto.mapFromEntity(examSeries), HttpStatus.OK);
    }
    
    /**
     * This method is used to create or load an instance of an ExamSeries object from the supplied ExamSeriesDto object. If the ExamSeriesDto 
     * object is found to exist in the database then the details for this are loaded an returned. 
     *
     *  @param examSeries The examSeriesDto to use to create the new ExamSeries object
     *  @return A ResponseEntity with the newly created ExamSeriesDto object
     *  @throws InvalidDataException If there is an issue with the data provided in the RequesetBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new ExamSeries entity",
    notes = "A POST request to the ExamSeries endpoint with an ExamSeries object in the request body will create a new ExamSeries entity in the database.",
    response = ExamSeriesDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created ExamSeries entity including the examSeriesId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating that the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<ExamSeriesDto> create(
            @ApiParam(value = "The examSeries object to be created, without the examSeriesId field", required = true)
            @RequestBody @Valid ExamSeriesDto examSeries
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** ExamSeriesApi - examSeriesPost");
        if (examSeries.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when created");
        }
        if (examSeries.academicYearId == null){
            throw new InvalidDataException("No Academic Year details supplied")
        }
        ExamSeries newExamSeries = examSeriesService.createFromDto(examSeries)
        return new ResponseEntity<ExamSeriesDto>(ExamSeriesDto.mapFromEntity(newExamSeries), HttpStatus.CREATED);
    }
    
    /**
     * The examSeriesExamSeriesIdPut is used to update an instance of a ExamSeriesDto as identified by the examSeriesId provided
     *
     * @param examSeriesId The examSeries ID for the ExamSeries object to update
     * @param examSeries The new data for the Syllabus object
     * @return The newly updated ExamSeriesDto object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a ExamSeries entity",
    notes = "A PUT request to the ExamSeries instance endpoint with a ExamSeriesDto object in the request body will update an existing ExamSeries entity in the database",
    response = ExamSeriesDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated ExamSeriesDto object"),
        @ApiResponse(code = 400, message = "Returns an Error object stating that the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens is the specified ID cannot be found in the database.")
    ])
    @RequestMapping(value = "/{examSeriesId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<ExamSeriesDto> update(
            @ApiParam(value = "The unique ID of the ExamSeries to retrieve", required = true)
            @PathVariable("examSeriesId") Integer examSeriesId,
            @ApiParam(value = "The ExamSeries object to be updated, with the examSeriesId field", required = true)
            @RequestBody ExamSeriesDto examSeries
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** ExamSeriesApi - examSeriesExamSeriesIdPut");
        if (examSeriesId != examSeries.id) {
            throw new InvalidDataException();
        }
        ExamSeries savedExamSeries = examSeriesService.updateFromDto(examSeries);
        return new ResponseEntity<ExamSeriesDto>(ExamSeriesDto.mapFromEntity(savedExamSeries),HttpStatus.OK);
    }
}
