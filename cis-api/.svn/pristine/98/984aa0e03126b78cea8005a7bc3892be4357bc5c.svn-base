package uk.ac.reigate.api;

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
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Enrolment
import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.ilp.ILPInterview
import uk.ac.reigate.domain.interimreport.StudentInterimReport
import uk.ac.reigate.dto.CourseDto
import uk.ac.reigate.dto.CourseGroupDto
import uk.ac.reigate.dto.EnrolmentDto
import uk.ac.reigate.dto.exams.basedata.ExamOptionDto
import uk.ac.reigate.dto.ilp.ILPInterviewDto
import uk.ac.reigate.dto.interimreport.StudentInterimReportDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.CourseGroupService
import uk.ac.reigate.services.CourseService
import uk.ac.reigate.services.LevelService
import uk.ac.reigate.services.SubjectService
import uk.ac.reigate.services.enrolments.EnrolmentService;
import uk.ac.reigate.services.exams.CourseOptionService
import uk.ac.reigate.services.exams.ExamBoardService
import uk.ac.reigate.services.ilp.ILPInterviewService
import uk.ac.reigate.services.interimreport.StudentInterimReportService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

@Controller
@RequestMapping(value = "/courses", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/courses", description = "the courses API")
public class CoursesApi implements ICoreDataYearSpecificApi<CourseDto, Integer> {
    private ExamBoard examBoard
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CoursesApi.class);
    
    @Autowired
    private final CourseService courseService;
    
    @Autowired
    private final CourseGroupService courseGroupService;
    
    @Autowired
    private final LevelService levelService;
    
    @Autowired
    private final SubjectService subjectService;
    
    @Autowired
    private final ExamBoardService examBoardService;
    
    @Autowired
    private final AcademicYearService academicYearService;
    
    @Autowired
    private final EnrolmentService enrolmentService;
    
    @Autowired
    private final CourseOptionService courseOptionService;
    
    @Autowired
    private final ILPInterviewService iLPInterviewService;
    
    @Autowired
    private final StudentInterimReportService studentInterimReportService
    /**
     * Default NoArgs constructor
     */
    CoursesApi() {}
    
    /**
     * Autowired constructor
     */
    CoursesApi(CourseService courseService, AcademicYearService academicYearService, CourseGroupService courseGroupService) {
        this.courseService = courseService;
    }
    
    /**
     * The courseGroupsGet method is used to retrieve a full list of all the CourseDto objects
     *
     * @return A ResponseEntity with the corresponding list of CourseGroupDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of Course entities", notes = "A GET request to the Courses endpoint returns an array of all the courses in the system.", response = CourseDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of courses")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<CourseDto>> getAll(
            @ApiParam(value = "The Id of the Year to retrieve", required = false)
            @RequestParam(value = "yearId", required = false) Integer yearId
    ) throws NotFoundException {
        LOGGER.info("** CoursesApi - getAll");
        List<Course> courseList
        if (yearId){
            courseList = courseService.findAllCoursesValidInYear(yearId)
        } else {
            courseList = courseService.findAll()
        }
        if (courseList == null){
            throw new NotFoundException()
        }
        return new ResponseEntity<List<CourseDto>>(CourseDto.mapFromList(courseList), HttpStatus.OK)
    }
    
    
    
    /**
     * The coursesPost method is used to create a new instance of a Course from the supplied CourseDto
     *
     * @param course the CourseDto to use to create the new Course object
     * @return A ResponseEntity with the newly created Course object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new Course entity", notes = "A POST request to the Courses endpoint with a Course object in the request body will create a new Course entity in the database.", response = CourseDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created Course entity including the courseId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<CourseDto> create(
            @ApiParam(value = "The Course object to be created, without the courseId fields", required = true)
            @RequestBody @Valid CourseDto course
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** CoursesApi - createCourse");
        if (course.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        Course courseSaved = courseService.createFromDto(course)
        return new ResponseEntity<CourseDto>(CourseDto.mapFromEntity(courseSaved), HttpStatus.CREATED);
    }
    
    @Override
    public ResponseEntity<CourseDto> getById(Integer id) {
        return getById(id, null);
    }
    
    /**
     * The coursesCourseIdGet method is used to retrieve an instance of a CourseDto object as identified by the courseId provided
     *
     * @param courseId the course ID for the Course object to retrieve
     * @param yearId (optional) the year ID for the Course object to retrieve
     * @return A ResponseEntity with the corresponding CourseDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a Course identified by the courseId", notes = "A getGET request to the Course instance endpoint will retrieve an instance of a Course entity as identified by the courseId provided in the URI.", response = CourseDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Course as identified by the courseId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{courseId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<CourseDto> getById(
            @ApiParam(value = "The unique ID of the Course to retrieve", required = true)
            @PathVariable("courseId") Integer courseId,
            @ApiParam(value = "The code of the AcademicYear to retrieve", required = false)
            @RequestParam(value = "yearId", required = false) Integer yearId
    ) throws NotFoundException {
        LOGGER.info("** CoursesApi - getCourseById: $courseId");
        Course course
        if (yearId != null) {
            course = courseService.getCourseByIdAndYearId(courseId, yearId)
        } else {
            course = courseService.findById(courseId)
        }
        
        if (course == null) {
            throw new NotFoundException()
        }
        return new ResponseEntity<CourseDto>(CourseDto.mapFromEntity(course), HttpStatus.OK)
    }
    
    /**
     * The coursesCourseIdGet method is used to retrieve an instance of a CourseDto object as identified by the courseId provided
     *
     * @param courseId the course ID for the Course object to retrieve
     * @param yearId (optional) the year ID for the Course object to retrieve
     * @return A ResponseEntity with the corresponding CourseDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a Course identified by the courseGroupId", notes = "A getGET request to the Course instance endpoint will retrieve an instance of a Course entity as identified by the courseId provided in the URI.", response = CourseDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Course as identified by the courseId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{courseId}/interim-reports", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentInterimReportDto>> getInterimReports(
            @ApiParam(value = "The unique ID of the Course to retrieve", required = true)
            @PathVariable("courseId") Integer courseId
    ) throws NotFoundException {
        LOGGER.info("** CoursesApi - getEnrolments");
        List<StudentInterimReport> studentInterimReportList = studentInterimReportService.findByCourseId(courseId)
        return new ResponseEntity<List<StudentInterimReportDto>>(StudentInterimReportDto.mapFromList(studentInterimReportList), HttpStatus.OK)
    }
    
    /**
     * The coursesCourseIdPut is used to update
     *
     * @param courseId the course ID for the Course object to update
     * @param course the new data for the Course object
     * @return the newly updated CourseDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a Course entity", notes = "A PUT request to the Course instance endpoint with a Course object in the request body will update an existing Course entity in the database.", response = CourseDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated Course object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{courseId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<CourseDto> update(
            @ApiParam(value = "The unique ID of the Course to retrieve", required = true)
            @PathVariable("courseId") Integer courseId,
            @ApiParam(value = "The Course object to be created, without the courseId fields", required = true)
            @RequestBody CourseDto course
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** CoursesApi - updateCourse");
        if (courseId != course.id) {
            throw new InvalidDataException()
        }
        Course courseSaved = courseService.updateFromDto(course)
        return new ResponseEntity<CourseDto>(CourseDto.mapFromEntity(courseSaved), HttpStatus.OK);
    }
    
    /**
     * The CoursesGet method is used to retrieve a list of the CourseDto objects with academicYear filter
     *
     * @return A ResponseEntity with the corresponding list of CourseDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of Course entities", notes = "A GET request to the Courses endpoint returns an array of all the courses in the system.", response = CourseDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of courses")
    ])
    @RequestMapping(value = "/search", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<CourseDto>> search(
            @RequestParam(value = "year", required = false) String year,
            @RequestParam(value = "spec", required = true) String spec
    ) throws NotFoundException {
        LOGGER.info("** CoursesApi - search");
        AcademicYear academicYear
        if (year) {
            LOGGER.info("CourseApi Searching for Year Code: " + year);
            academicYear = academicYearService.findByCode(year)
        }
        if (academicYear == null) {
            LOGGER.info("CourseApi No Year Found or Supplied - Using default")
            academicYear = academicYearService.getCurrentAcademicYear()
        }
        List<Course> courseList = courseService.searchByYearAndSpec(academicYear, spec)
        
        if (courseList.size() != 0) {
            LOGGER.info("II Results found: " + courseList.size())
            List<CourseDto> courseSearchResults = new ArrayList<CourseDto>()
            return new ResponseEntity<List<CourseDto>>(CourseDto.mapFromList(courseList), HttpStatus.OK)
        }
    }
    
    /**
     * The courseEnrolmentsId method is used to retrieve a list of enrolment by Course objects.
     *
     * @return A ResponseEntity with the corresponding list of EnrolmentDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a Course identified by the courseGroupId", notes = "A getGET request to the Course instance endpoint will retrieve an instance of a Course entity as identified by the courseId provided in the URI.", response = CourseDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Course as identified by the courseId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{courseId}/enrolments", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<EnrolmentDto>> getEnrolments(
            @ApiParam(value = "The unique ID of the Course to retrieve", required = true)
            @PathVariable("courseId") Integer courseId,
            @ApiParam(value = "The code of the AcademicYear to retrieve", required = false)
            @RequestParam(value = "yearId", required = false) Integer yearId
    ) throws NotFoundException {
        LOGGER.info("** CoursesApi - getEnrolments");
        AcademicYear academicYear
        List<Enrolment> enrolmentList
        if (yearId != null) {
            LOGGER.info("II Searching for Year ID: " + yearId);
            academicYear = academicYearService.findById(yearId)
        }
        if (academicYear == null) {
            LOGGER.info("II No Year Found or Supplied - Using default")
            academicYear = academicYearService.getCurrentAcademicYear()
            enrolmentList = enrolmentService.findByCourseId(courseId)
        } else {
            enrolmentList = enrolmentService.findByCourseAndYear(courseId, academicYear)
        }
        return new ResponseEntity<List<EnrolmentDto>>(EnrolmentDto.mapFromList(enrolmentList), HttpStatus.OK)
    }
    
    /**
     * The coursesGetByCourseGroup method is used to retrieve a list of courseGroup by Course objects.
     *
     * @return A ResponseEntity with the corresponding list of CourseGroupDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a Course identified by the courseGroupId", notes = "A getGET request to the Course instance endpoint will retrieve an instance of a Course entity as identified by the courseId provided in the URI.", response = CourseDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Course as identified by the courseId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = [
        "/{courseId}/courseGroups",
        "/{courseId}/course-groups"
    ], produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<CourseGroupDto>> getCourseGroups(
            @ApiParam(value = "The unique ID of the Course to retrieve", required = true)
            @PathVariable("courseId") Integer courseId,
            @ApiParam(value = "The Id of the AcademicYear to retrieve", required = false)
            @RequestParam(value = "yearId", required = false) Integer yearId
    ) throws NotFoundException {
        LOGGER.info("** CoursesApi - getCourseGroups");
        AcademicYear academicYear
        if (yearId) {
            LOGGER.info("CourseApi Searching for Year ID: " + yearId);
            academicYear = academicYearService.findById(yearId)
        } else {
            academicYear = academicYearService.getCurrentAcademicYear()
        }
        List<CourseGroup> courseByCourseGroup = courseGroupService.searchBycourseAndYear(courseId, academicYear)
        
        return new ResponseEntity<List<CourseGroupDto>>(CourseGroupDto.mapFromList(courseByCourseGroup), HttpStatus.OK)
    }
    
    @RequestMapping(value = "/{courseId}/exam-options", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<ExamOptionDto>> getCoursesExamOptions(
            @ApiParam(value = "The unique ID of the Course to retrieve", required = true)
            @PathVariable("courseId") Integer courseId,
            @ApiParam(value = "The Id of the AcademicYear to retrieve", required = false)
            @RequestParam(value = "yearId", required = false) Integer yearId
    ){
        List<ExamOption> examOptions
        if (yearId != null) {
            examOptions = courseOptionService.findCourseExamOptions(courseId, yearId)
        } else {
            examOptions = courseOptionService.findCourseExamOptions(courseId)
        }
        return new ResponseEntity<List<ExamOptionDto>>(ExamOptionDto.mapFromList(examOptions), HttpStatus.OK)
    }
    
    
    @RequestMapping(value = "/{courseId}/syllabus", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<ExamOptionDto>> getCoursesSyllabus(
            @ApiParam(value = "The unique ID of the Course to retrieve", required = true)
            @PathVariable("courseId") Integer courseId,
            @ApiParam(value = "The Id of the AcademicYear to retrieve", required = false)
            @RequestParam(value = "yearId", required = false) Integer yearId
    ){
        // TODO: Change this method to return syllabus DTO objects instead of exam options
        List<ExamOption> examOptions
        if (yearId != null) {
            examOptions = courseOptionService.findCourseExamOptions(courseId, yearId)
        } else {
            examOptions = courseOptionService.findCourseExamOptions(courseId)
        }
        return new ResponseEntity<List<ExamOptionDto>>(ExamOptionDto.mapFromList(examOptions), HttpStatus.OK)
    }
    
    @RequestMapping(value = [
        "/{courseId}/ilpInterviews",
        "/{courseId}/ilp-interviews"
    ], produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<ILPInterviewDto>> getILPInterviewsByCourseId(
            @ApiParam(value = "The unique ID of the ILPInterview to retrieve", required = true)
            @PathVariable("courseId") Integer courseId,
            @ApiParam(value = "The id of the AcademicYear to retrieve", required = false)
            @RequestParam(value = "yearId", required = false) Integer yearId
    ) throws NotFoundException {
        LOGGER.info("** CourseGroupsApi - getAllILPInterviewsByCourseGroup");
        AcademicYear academicYear
        if (yearId) {
            LOGGER.info("CourseApi Searching for Year ID: " + yearId);
            academicYear = academicYearService.findById(yearId)
        } else {
            academicYear = academicYearService.getCurrentAcademicYear()
        }
        List<ILPInterview> iLPInterviews = iLPInterviewService.findByCourseAndYear(courseId, academicYear)
        if (iLPInterviews == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<List<ILPInterviewDto>>(ILPInterviewDto.mapFromList(iLPInterviews), HttpStatus.OK);
    }
}