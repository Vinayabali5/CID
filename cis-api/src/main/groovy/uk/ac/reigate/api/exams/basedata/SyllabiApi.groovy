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
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

import uk.ac.reigate.api.ICoreDataYearSpecificApi
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.basedata.Syllabus
import uk.ac.reigate.dto.exams.basedata.ExamOptionDto
import uk.ac.reigate.dto.exams.basedata.SyllabusDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.exams.ExamDtoConverterService
import uk.ac.reigate.services.exams.basedata.ExamOptionService
import uk.ac.reigate.services.exams.basedata.ExamSeriesService
import uk.ac.reigate.services.exams.basedata.SyllabusService

@Controller
@RequestMapping(value = ["/syllabi", "/syllabus"], produces = [MediaType.APPLICATION_JSON_VALUE])
@Api(value = "/syllabi", description = "The Exam basedata Syllabus Resource API")
public class SyllabiApi implements ICoreDataYearSpecificApi<SyllabusDto, Integer> {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(SyllabiApi.class);
    
    @Autowired
    SyllabusService syllabusService
    
    @Autowired
    ExamOptionService examOptionService
    
    /**
     * Default No Args constructor
     */
    SyllabiApi() {}
    
    /**
     * Default Autowired constructor
     */
    SyllabiApi(SyllabusService syllabusService) {
        this.syllabusService = syllabusService;
    }
    
    /**
     * The syllabiGet method is used to retrieve a (non paged) collection of syllabi entities of the syllabusDto objects
     *
     * @param examBoardId ID of examBoard to retrieve results for
     * @param examYear exam year to retrieve results for
     * @param examSeries exam series to retrieve results for
     * @return A ResponseEntity with the corresponding list of syllabusDto objects
     * @throws NotFoundException If nothing is found then the NotFoundException is thrown
     */
    @CrossOrigin
    @Override
    @ApiOperation(value = "Collection of All syllabus entities", notes = "A GET request to the Syllabi endpoint returns an array of ALL the syllabi in the system for the particular year Id", response = SyllabusDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of syllabi")
    ])
    @RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<SyllabusDto>> getAll(
            @ApiParam(value = "year Id", name = "yearId", required = false)
            @RequestParam(value = "yearId", required = false) Integer yearId
    ) throws NotFoundException {
        LOGGER.info("** SyllabiApi - getAllSyllabus")
        List<Syllabus> syllabus
        if (yearId != null) {
            syllabus = syllabusService.findByYearId(yearId)
        } else {
            syllabus = syllabusService.findAll()
        }
        return new ResponseEntity<List<SyllabusDto>>(SyllabusDto.mapFromList(syllabus), HttpStatus.OK);
    }
    
    /**
     * This method is used to search the syllabus by syllabusCode
     * @param syllabusCode
     * @return
     * @throws NotFoundException
     */
    @ApiOperation(value = "Performs a search for syllabi based on given parameters.", response = SyllabusDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of Syllabi objects")
    ])
    @RequestMapping(value="/search", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<SyllabusDto>> search(
            @ApiParam(value = "syllabus Code", name = "syllabusCode", required = true)
            @RequestParam(value = "syllabusCode", required = true) String syllabusCode
    ) throws NotFoundException {
        List<Syllabus> syllabi = syllabusService.findByCode(syllabusCode)
        return new ResponseEntity<List<SyllabusDto>>(SyllabusDto.mapFromList(syllabi), HttpStatus.OK);
    }
    
    /**
     * The syllabusSyllabusIdGet method is used to retrieve an instance of a SyllabusDto object as identified by the syllabusId provided
     *
     * @param syllabusId The syllabus ID for the Syllabus object to retrieve
     * @return A ResponseEntity with the corresponding SyllabusDto object
     * @throws NotFoundException If nothing is found then the NotFoundException is thrown
     */
    @Override
    @ApiOperation(value = "Retrieves an individual instance of a Syllabus identified by the syllabusId", notes = "A GET request to the Syllabus instance endpoint will retrieve an instance of a Syllabus entity as identified by the syllabusId provided in the URI.", response = SyllabusDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Syllabus as identified by the syllabusId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified ID cannot be found in the database.")
    ])
    @RequestMapping(value = "/{syllabusId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<SyllabusDto> getById(
            @ApiParam(value = "The unique ID of the Syllabus to retrieve", required = true)
            @PathVariable("syllabusId") Integer syllabusId
    ) throws NotFoundException {
        LOGGER.info("** SyllabiApi - syllabusSyllabusIdGet");
        Syllabus syllabus = syllabusService.findById(syllabusId);
        if (syllabus == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<SyllabusDto>(SyllabusDto.mapFromEntity(syllabus), HttpStatus.OK);
    }
    
    /**
     * The syllabusPost method is used to create a new instance of a Syllabus object from the supplied SyllabusDto entity
     *
     *  @param syllabus The SyllabusDto to use to create the new Syllabus object
     *  @return A ResponseEntity with the newly created SyllabusDto object
     *  @throws InvalidDataException If there is an issue with the data provided in the RequesetBody then an InvalidDataException is thrown
     */
    @Override
    @ApiOperation(value = "Creates a new Syllabus entity",
    notes = "A POST request to the Syllabi endpoint with a Syllabus object in the request body will create a new Syllabus entity in the database.",
    response = SyllabusDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created Syllabus entity including the syllabusId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating that the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<SyllabusDto> create(
            @ApiParam(value = "The syllabus object to be created, without the syllabusId field", required = true)
            @RequestBody @Valid SyllabusDto syllabus
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** SyllabusApi - syllabusPost");
        if (syllabus.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when created");
        }
        Syllabus savedSyllabus = syllabusService.createFromDto(syllabus);
        return new ResponseEntity<SyllabusDto>(SyllabusDto.mapFromEntity(savedSyllabus), HttpStatus.CREATED);
    }
    
    /**
     * The syllabusSyllabusIdPut is used to update an instance of a SyllabusDto as identified by the syllabusId provided
     *
     * @param syllabusId The syllabus ID for the Syllabus object to update
     * @param syllabus The new daya for the Syllabus object
     * @return The newly updated SyllabusDto object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody  then an InvalidDataException is thrown
     */
    @Override
    @ApiOperation(value = "Used to update a Syllabus entity",
    notes = "A PUT request to the Syllabus instance endpoint with a SyllabusDto object in the request body will update an existing Syllabus entity in the database",
    response = SyllabusDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated SyllabusDto object"),
        @ApiResponse(code = 400, message = "Returns an Error object stating that the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens is the specified ID cannot be found in the database.")
    ])
    @RequestMapping(value = "/{syllabusId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<SyllabusDto> update(
            @ApiParam(value = "The unique ID of the Syllabus to retrieve", required = true)
            @PathVariable("syllabusId") Integer syllabusId,
            @ApiParam(value = "The Syllabus object to be updated, with the syllabusId field", required = true)
            @RequestBody SyllabusDto syllabus
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** SyllabusApi - syllabusSyllabusIdPut");
        if (syllabusId != syllabus.id) {
            throw new InvalidDataException();
        }
        Syllabus savedSyllabus = syllabusService.updateFromDto(syllabus);
        return new ResponseEntity<SyllabusDto>(SyllabusDto.mapFromEntity(savedSyllabus), HttpStatus.OK);
    }
    
    /**
     * This method is used to retrieve a collection of ExamOptionDto objects for a specified syllabusId.
     *
     * @param syllabusId syllabus ID to retrieve results for
     * @return A ResponseEntity with the corresponding list of optionDto objects
     * @throws NotFoundException If nothing is found then the NotFoundException is thrown
     */
    @ApiOperation(value = "Retrieves a collection of ExamOption entities for a specified syllabusId",
    notes = "A GET request to the ExamOptions endpoint returns an array of the examOptions for a specified syllabusId in the system",
    response = ExamOptionDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns an array of options"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that no resources could be found. This hapens if the specified syllabusId cannot be found in the database.")
    ])
    @RequestMapping(value = [
        "/{syllabusId}/options",
        "/{syllabusId}/exam-options"
    ], produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<ExamOptionDto>> getSyllabusOptions(
            @ApiParam(value = "The unique ID of the Syllabus to retrieve", required = true)
            @PathVariable("syllabusId") Integer syllabusId
    ) throws NotFoundException {
        LOGGER.info("** ExamOptionApi - examOptionGetBySyllabusId");
        List<ExamOption> examOption = examOptionService.findExamOptions(syllabusId);
        return new ResponseEntity<List<ExamOptionDto>>(ExamOptionDto.mapFromList(examOption), HttpStatus.OK);
    }
}
