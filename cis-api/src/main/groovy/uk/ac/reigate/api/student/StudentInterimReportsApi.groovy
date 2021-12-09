package uk.ac.reigate.api.student;

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

import uk.ac.reigate.domain.interimreport.StudentInterimReport
import uk.ac.reigate.dto.interimreport.StudentInterimReportDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.interimreport.InterimReportService
import uk.ac.reigate.services.interimreport.StudentInterimReportService
import uk.ac.reigate.services.student.StudentService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

import javax.validation.Valid


@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the studentInterimReports API")
public class StudentInterimReportsApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentInterimReportsApi.class);
    
    @Autowired
    private final StudentInterimReportService studentInterimReportService;
    
    @Autowired
    private final StudentService studentService;
    
    @Autowired
    private final InterimReportService interimReportService;
    
    @Autowired
    private final AcademicYearService academicYearService;
    /**
     * Default NoArgs constructor
     */
    StudentInterimReportsApi() {}
    
    /**
     * Autowired constructor
     */
    StudentInterimReportsApi(StudentInterimReportService studentInterimReportService, InterimReportService interimReportService) {
        this.studentInterimReportService = studentInterimReportService;
    }
    
    
    /**
     * The StudentInterimReportsGet method is used to retrieve a full list of students by the StudentInterimReportDto objects
     *
     * @return A ResponseEntity with the corresponding list of StudentInterimReportDto objects for a given yearId
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StudentInterimReport entities", notes = "A GET request to the StudentInterimReports endpoint returns an array of all the StudentInterimReports in the system.", response = StudentInterimReportDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of StudentInterimReports for a yearId")
    ])
    @RequestMapping(value = [
        "/students/{studentId}/interimReports",
        "/students/{studentId}/interim-reports"
    ], produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentInterimReportDto>> studentInterimReportGet(
            @ApiParam(value = "The unique ID of the Student retrieves the List of interimReports for the selected student", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value = "The year ID of the Student Interim Report to retrieve", required = false)
            @RequestParam(value = "yearId", required = false) Integer yearId
    ) throws NotFoundException {
        LOGGER.info("** StudentInterimReportsApi - StudentInterimReportsGet");
        List<StudentInterimReport> studentInterimReportList = new ArrayList<StudentInterimReport>();
        if (yearId) {
            studentInterimReportList = studentInterimReportService.findByStudentAndYearId(studentId, yearId)
        } else {
            studentInterimReportList= studentInterimReportService.getByStudentId(studentId);
        }
        if (studentInterimReportList == null) {
            throw new NotFoundException();
        }
        
        return new ResponseEntity<List<StudentInterimReportDto>>(StudentInterimReportDto.mapFromList(studentInterimReportList), HttpStatus.OK);
    }
    
    /**
     * This method is used to retrieve an instance of a StudentInterimReportDto object as identified by the studentInterimReportId provided
     *
     * @param studentInterimReportId the studentInterimReport ID for the StudentInterimReport object retrieve
     * @return A ResponseEntity with the corresponding StudentInterimReportDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentInterimReport identified by the studentInterimReportId", notes = "A getGET request to the StudentInterimReport instance endpoint will retrieve an instance of a StudentInterimReport entity as identified by the studentInterimReportId provided in the URI.", response = StudentInterimReportDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentInterimReport as identified by the studentInterimReportId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/student-interim-report/{studentInterimReportId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentInterimReportDto> getById(
            @ApiParam(value = "The unique ID of the StudentInterimReport to retrieve", required = true)
            @PathVariable("studentInterimReportId") Integer studentInterimReportId
    ) throws NotFoundException {
        LOGGER.info("** StudentInterimReportsApi - getById");
        StudentInterimReport studentInterimReport = studentInterimReportService.findById(studentInterimReportId);
        if (studentInterimReport == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<StudentInterimReportDto>(StudentInterimReportDto.mapFromEntity(studentInterimReport), HttpStatus.OK);
    }
    
    /**
     * This method is used to retrieve an instance of a StudentInterimReportDto object as identified by the studentInterimReportId provided
     *
     * @param studentInterimReportId the studentInterimReport ID for the StudentInterimReport object retrieve
     * @return A ResponseEntity with the corresponding StudentInterimReportDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentInterimReport identified by the studentInterimReportId", notes = "A getGET request to the StudentInterimReport instance endpoint will retrieve an instance of a StudentInterimReport entity as identified by the studentInterimReportId provided in the URI.", response = StudentInterimReportDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentInterimReport as identified by the studentInterimReportId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/student-interim-report/{interimReportId}/courseGroup/{courseGroupId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentInterimReportDto> getByInterimReportIdAndCourseGroupId(
            @ApiParam(value = "The unique ID of the StudentInterimReport to retrieve", required = true)
            @PathVariable("interimReportId") Integer interimReportId,
            @ApiParam(value = "The unique courseGroupId of the StudentInterimReport to retrieve", required = true)
            @PathVariable("courseGroupId") Integer courseGroupId
    ) throws NotFoundException {
        LOGGER.info("** StudentInterimReportsApi - getById");
        List<StudentInterimReport> studentInterimReports = studentInterimReportService.findByCourseGroupIdAndInterimReportId(courseGroupId, interimReportId);
        if (studentInterimReports == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<StudentInterimReportDto>(StudentInterimReportDto.mapFromList(studentInterimReports), HttpStatus.OK);
    }
    
    /**
     * This method is used to update
     *
     * @param studentInterimReportId the StudentInterimReport ID for the StudentInterimReport object to update
     * @param studentInterimReport the new data for the StudentInterimReport object
     * @return the newly updated StudentInterimReportDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a StudentInterimReport entity", notes = "A PUT request to the StudentInterimReport instance endpoint with a StudentInterimReport object in the request body will update an existing StudentInterimReport entity in the database.", response = StudentInterimReportDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated StudentInterimReport object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/student-interim-report/{studentInterimReportId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StudentInterimReportDto> update(
            @ApiParam(value = "The unique ID of the StudentInterimReport to retrieve", required = true)
            @PathVariable("studentInterimReportId") Integer studentInterimReportId,
            @ApiParam(value = "The StudentInterimReport object to be created, without the studentInterimReportId fields", required = true)
            @RequestBody StudentInterimReportDto studentInterimReport
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentInterimReportsApi - update");
        if (studentInterimReportId != studentInterimReport.id) {
            throw new InvalidDataException()
        }
        StudentInterimReport studentInterimReportSaved = studentInterimReportService.updateFromDto(studentInterimReport)
        return new ResponseEntity<StudentInterimReportDto>(StudentInterimReportDto.mapFromEntity(studentInterimReportSaved), HttpStatus.OK);
    }
    
    @ApiOperation(value = "Creates a new StudentInterimReport entity", notes = "A POST request to the StudentInterimReports endpoint with a StudentInterimReport object in the request body will create a new StudentInterimReport entity in the database.", response = StudentInterimReportDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created StudentInterimReport entity including the studentInterimReportId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "/student-interim-report", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StudentInterimReportDto> create(
            @ApiParam(value = "The StudentInterimReport object to be created, without the masterReviewId fields", required = true)
            @RequestBody @Valid StudentInterimReportDto studentInterimReport
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentInterimReportsApi - studentInterimReportsPOST");
        StudentInterimReport studentInterimReportSaved = studentInterimReportService.createFromDto(studentInterimReport)
        return new ResponseEntity<StudentInterimReportDto>(StudentInterimReportDto.mapFromEntity(studentInterimReportSaved), HttpStatus.OK);
    }
}

