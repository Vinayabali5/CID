package uk.ac.reigate.api.attendance;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.attendance.StudentAttendance
import uk.ac.reigate.domain.attendance.StudentAttendanceByCourseGroupForPeriod
import uk.ac.reigate.dto.attendance.StudentAttendanceByCourseGroupForPeriodDto
import uk.ac.reigate.dto.attendance.StudentAttendanceDto
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.attendance.StudentAttendanceByCourseGroupForPeriodService
import uk.ac.reigate.services.attendance.StudentAttendanceService


@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the studentAttendances API")
public class StudentAttendanceApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentAttendanceApi.class);
    
    @Autowired
    private final StudentAttendanceService studentAttendanceService;
    
    @Autowired
    private final AcademicYearService academicYearService
    
    @Autowired
    private final StudentAttendanceByCourseGroupForPeriodService studentAttendanceByCourseGroupForPeriodService
    
    
    /**
     * Default NoArgs constructor
     */
    StudentAttendanceApi() {}
    
    /**
     * Autowired constructor
     */
    StudentAttendanceApi(StudentAttendanceService studentAttendanceService) {
        this.studentAttendanceService = studentAttendanceService;
    }
    
    /**
     * The studentCourseGroupAttendancesStudentCourseGroupAttendanceIdGet method is used to retrieve an instance of a StudentCourseGroupAttendanceDto object as identified by the studentCourseGroupAttendanceId provided
     *
     * @param studentCourseGroupAttendanceId the studentCourseGroupAttendance ID for the StudentCourseGroupAttendance object retrieve
     * @return A ResponseEntity with the corresponding StudentCourseGroupAttendanceDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentCourseGroupAttendance identified by the studentCourseGroupAttendanceId", notes = "A getGET request to the StudentCourseGroupAttendance instance endpoint will retrieve an instance of a StudentCourseGroupAttendance entity as identified by the studentCourseGroupAttendanceId provided in the URI.", response = StudentAttendanceDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentCourseGroupAttendance as identified by the studentCourseGroupAttendanceId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "students/{studentId}/attendance/course/{courseId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentAttendanceDto>> searchStudentAttendanceByCourseId(
            @ApiParam(value = "The unique studentID of the StudentCourseGroupAttendance to retrieve", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value = "The unique CourseID of the StudentCourseGroupAttendance to retrieve", required = true)
            @PathVariable("courseId") Integer courseId,
            @ApiParam(value = "The yearId of the AcademicYear to search", required = false)
            @RequestParam(value = "yearId", required = false) Integer yearId,
            @ApiParam(value = "The startDate of the StudentCourseGroupAttendance to search", required = false)
            @RequestParam(value = "startDate", required = false) Date startDate,
            @ApiParam(value = "The endDate of the StudentCourseGroupAttendance to search", required = false)
            @RequestParam(value = "endDate", required = false) Date endDate
    ) throws NotFoundException {
        LOGGER.info("** StudentCourseGroupAttendancesApi - studentCourseGroupAttendancesStudentCourseGroupAttendanceIdGet");
        AcademicYear academicYear
        if (yearId) {
            LOGGER.info("II Searching for Year ID: " + yearId);
            academicYear = academicYearService.findById(yearId)
        }
        if (academicYear == null) {
            LOGGER.info("II No Year Found or Supplied - Using default")
            academicYear = academicYearService.getCurrentAcademicYear()
        }
        if(academicYear != null && startDate != null && endDate != null) {
            StudentAttendance studentAttendances = studentAttendanceService.searchByYearStudentIdAndCourseId(academicYear, studentId, courseId, startDate, endDate);
        } else {
            StudentAttendance studentAttendances = studentAttendanceService.findByStudentIdAndCourseId(studentId, courseId)
            return new ResponseEntity<StudentAttendanceDto>(StudentAttendanceDto.mapFromEntity(studentAttendances), HttpStatus.OK);
        }
    }
    
    /**
     * The StudentAttendanceByCourseGroupForPeriodIdGet method is used to retrieve an instance of a StudentAttendanceByCourseGroupForPeriodDto object as identified by the studentId, courseGroupId provided
     *
     * @param StudentAttendanceByCourseGroupForPeriod object retrieve
     * @return A ResponseEntity with the corresponding StudentAttendanceByCourseGroupForPeriodDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @RequestMapping(value = "students/{studentId}/attendance/course-group/{courseGroupId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentAttendanceByCourseGroupForPeriodDto> getAttendanceForPeriod(
            @ApiParam(value = "The unique studentID of the StudentCourseGroupAttendance to retrieve", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value = "The unique CourseID of the StudentCourseGroupAttendance to retrieve", required = true)
            @PathVariable("courseGroupId") Integer courseGroupId,
            @ApiParam(value = "The unique CourseID of the StudentCourseGroupAttendance to retrieve", required = false)
            @RequestParam(value = "interimReportId", required = false) Integer interimReportId,
            @ApiParam(value = "The startDate of the StudentCourseGroupAttendance to search", required = false)
            @RequestParam(value = "startDate", required = false) Long startDateTimeStamp,
            @ApiParam(value = "The endDate of the StudentCourseGroupAttendance to search", required = false)
            @RequestParam(value = "endDate", required = false) Long endDateTimeStamp
    ) throws NotFoundException {
        
        // TODO: Add interim report ID parameter (required: false)
        // TODO: check parameter conflicts. either provider start date and end date, or interim report id. throw invalid data exception
        // TODO: set start and end dates for retrieval.
        LOGGER.info("** StudentAttendanceByCourseGroupForPeriodsApi - StudentAttendanceByCourseGroupForPeriodIdGet");
        if(startDateTimeStamp != null && endDateTimeStamp != null && interimReportId != null) {
            Date startDate = new Date((long)startDateTimeStamp);
            Date endDate = new Date((long)endDateTimeStamp);
            StudentAttendanceByCourseGroupForPeriod studentAttendanceByCourseGroupForPeriod = studentAttendanceByCourseGroupForPeriodService.getAttendanceForPeriod(studentId, courseGroupId, startDate, endDate)
        } else {
            StudentAttendanceByCourseGroupForPeriod studentAttendanceByCourseGroupForPeriod = studentAttendanceByCourseGroupForPeriodService.getAttendanceByStudentIdAndCourseGroupId(studentId, courseGroupId)
            return new ResponseEntity<StudentAttendanceByCourseGroupForPeriodDto>(StudentAttendanceByCourseGroupForPeriodDto.mapFromEntity(studentAttendanceByCourseGroupForPeriod), HttpStatus.OK);
        }
    }
    
}
