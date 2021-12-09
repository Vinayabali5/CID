package uk.ac.reigate.api.admissions;

import javax.validation.Valid

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
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
import uk.ac.reigate.api.ICoreDataApi
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.admissions.Interview
import uk.ac.reigate.dto.admissions.InterviewDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.repositories.academic.StudentRepository
import uk.ac.reigate.repositories.academic.StudentYearRepository
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.FacultyService
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.admissions.InterviewService

@Controller
@RequestMapping(value = "/interviews", produces = [ MediaType.APPLICATION_JSON_VALUE ])
@Api(value = "/interviews", description = "the interviews API")
public class InterviewsApi implements ICoreDataApi<InterviewDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(InterviewsApi.class);
    
    @Autowired
    private final InterviewService interviewService;
    
    @Autowired
    private final FacultyService facultyService;
    
    @Autowired
    private final StaffService staffService;
    
    @Autowired
    private final StudentRepository studentRepository
    
    @Autowired
    private final AcademicYearService academicYearService
    
    @Autowired
    private final StudentYearRepository studentYearRepository
    /**
     * Default NoArgs constructor
     */
    InterviewsApi() {}
    
    /**
     * Autowired constructor
     */
    InterviewsApi(InterviewService interviewService) {
        this.interviewService = interviewService;
    }
    
    /**
     * The interviewsGet method is used to retrieve a studentById
     *
     * @return A ResponseEntity with the corresponding list of InterviewDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @RequestMapping(value='/getByStudent/{id}', produces = [
        MediaType.APPLICATION_JSON_VALUE
    ], method = RequestMethod.GET)
    public ResponseEntity<InterviewDto> getByStudent(@PathVariable(value='id') Integer id) {
        LOGGER.info("*** InterviewRestController.getByStudent")
        Student student = studentRepository.findById(id).orElse(null)
        AcademicYear nextYear = academicYearService.getNextAcademicYear()
        StudentYear studentYear = studentYearRepository.findByStudentAndYear(student, nextYear)
        if (student != null && studentYear != null) {
            InterviewDto interview = new InterviewDto(student, studentYear)
            // Create blank interview DTO if no interview data exists
            return new ResponseEntity<InterviewDto>(interview, HttpStatus.OK)
        } else {
            throw new MissingResourceException('Cannot find an application with id: ' + id)
        }
    }
    
    /**
     * This method is used to update a Interview object from the supplied InterviewDto object.
     *
     * @param interviewId the interview ID for the Interview object to update
     * @param interview the new data for the Interview object
     * @return the newly updated InterviewDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a Interview entity", notes = "A PUT request to the Interview instance endpoint with a Interview object in the request body will update an existing Interview entity in the database.", response = InterviewDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated Interview object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{studentId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<InterviewDto> update(
            @ApiParam(value = "The unique ID of the Interview to retrieve", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value = "The Interview object to be created, without the interviewId fields", required = true)
            @RequestBody @Valid InterviewDto interviewDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** InterviewsApi - update");
        if (studentId != interviewDto.studentId) {
            throw new InvalidDataException()
        }
        Student interviewSaved = interviewService.updateFromDto(interviewDto)
        StudentYear studentYear = interviewService.updateDto(interviewDto)
        InterviewDto interview = new InterviewDto(interviewSaved, studentYear)
        return new ResponseEntity<InterviewDto>(interview, HttpStatus.OK)
    }
    
    @Override
    public ResponseEntity<InterviewDto> getById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public ResponseEntity<InterviewDto> create(InterviewDto dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public ResponseEntity<List<InterviewDto>> getAll() {
        // TODO Auto-generated method stub
        return null;
    }
}
