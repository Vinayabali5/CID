package uk.ac.reigate.services.interimreport

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.Enrolment
import uk.ac.reigate.domain.attendance.StudentCourseGroupAttendance
import uk.ac.reigate.domain.interimreport.CourseGroupInterimReport
import uk.ac.reigate.domain.interimreport.InterimReport
import uk.ac.reigate.domain.interimreport.StudentInterimReport
import uk.ac.reigate.dto.interimreport.CourseGroupInterimReportDto
import uk.ac.reigate.dto.interimreport.StudentCourseGroupInterimReportDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.attendance.StudentCourseGroupAttendanceRepository
import uk.ac.reigate.repositories.interimreport.CourseGroupInterimReportRepository
import uk.ac.reigate.services.CourseGroupService
import uk.ac.reigate.services.StaffService

/**
 * This service class is used to process data for Course Group Interim Reports. 
 * 
 * @author Michael Horgan
 *
 */
@Service
class CourseGroupInterimReportService {
    
    @Autowired
    InterimReportService interimReportService
    
    @Autowired
    CourseGroupService courseGroupService
    
    @Autowired
    StudentInterimReportService studentInterimReportService
    
    @Autowired
    CourseGroupInterimReportRepository courseGroupInterimReportRepository
    
    @Autowired
    StudentCourseGroupAttendanceRepository studentCourseGroupAttendanceRepository
    
    @Autowired
    StaffService staffService
    
    /**
     * Default NoArgs constructor
     */
    CourseGroupInterimReportService() {}
    
    /**
     * Autowired Constructor
     *
     * @param interimReportRepository
     */
    CourseGroupInterimReportService(InterimReportService interimReportService, CourseGroupService courseGroupService, StudentInterimReportService studentInterimReportService, CourseGroupInterimReportRepository courseGroupInterimReportRepository, StudentCourseGroupAttendanceRepository studentCourseGroupAttendanceRepository, StaffService staffService) {
        this.interimReportService = interimReportService;
        this.courseGroupService= courseGroupService;
        this.studentInterimReportService = studentInterimReportService;
        this.courseGroupInterimReportRepository = courseGroupInterimReportRepository;
        this.studentCourseGroupAttendanceRepository = studentCourseGroupAttendanceRepository;
    }
    
    List<StudentCourseGroupInterimReportDto> getCourseGroupInterimReportData(Integer interimReportId, Integer courseGroupId) {
        InterimReport interimReport = interimReportService.findById(interimReportId)
        InterimReport previousInterimReport = interimReportService.getPrevious(interimReport)
        
        List<Enrolment> enrolments = courseGroupService.getCourseGroupEnrolments(courseGroupId)
        
        List<StudentCourseGroupInterimReportDto> output = enrolments.collect { Enrolment enrolment ->
            StudentInterimReport studentInterimReport = studentInterimReportService.findByStudentAndCourseGroupAndInterimReport(enrolment.student.id, courseGroupId, interimReportId)
            StudentInterimReport studentPreviousInterimReport = studentInterimReportService.findByStudentAndCourseGroupAndInterimReport(enrolment.student.id, courseGroupId, previousInterimReport.id)
            StudentCourseGroupAttendance attendance = studentCourseGroupAttendanceRepository.findByStudentIdAndCourseGroupIdForDateRange(enrolment.student.id, courseGroupId, interimReport.startDate, interimReport.endDate)
            return new StudentCourseGroupInterimReportDto(enrolment, studentInterimReport, studentPreviousInterimReport, attendance)
        }
        
        return output
    }
    
    /**
     * This method is used to retrieve the current active interim report for the Course Group InterimReport.
     *
     * @return the current active interim report for the Course Group InterimReport
     */
    public List<CourseGroupInterimReport> getCurrent() {
        InterimReport currentInterimReport = interimReportService.getCurrent()
        return courseGroupInterimReportRepository.findByInterimReport(currentInterimReport)
    }
    
    /**
     * This method is used to retrieve the previous interim report for the Course Group InterimReport.
     *
     * @return the previous interim report for the Course Group InterimReport
     */
    public List<CourseGroupInterimReport> getPrevious() {
        InterimReport previousInterimReport = interimReportService.getPrevious()
        return courseGroupInterimReportRepository.findByInterimReport(previousInterimReport)
    }
    
    /**
     * This method is used to retrieve the Course Group InterimReport by InterimReportId and CourseGroupId.
     *
     * @return the previous interim report for the Course Group InterimReport
     */
    public CourseGroupInterimReport findByInterimReportIdAndCourseGroupId(Integer interimReportId, Integer courseGroupId) {
        return courseGroupInterimReportRepository.findByInterimReportIdAndCourseGroupId(interimReportId, courseGroupId)
    }
    
    /**
     * This service method is used to save a complete CourseGroupInterimReport object in the database
     *
     * @param courseGroupInterimReport the new CourseGroupInterimReport object to be saved
     * @return the saved version of the CourseGroupInterimReport object
     */
    @Transactional
    public CourseGroupInterimReport save(CourseGroupInterimReport courseGroupInterimReport) {
        return courseGroupInterimReportRepository.save(courseGroupInterimReport)
    }
    
    /**
     * This service method is used to update an CourseGroupInterimReport object in the database from a partial or complete CourseGroupInterimReport object.
     *
     * @param courseGroupInterimReport the partial or complete CourseGroupInterimReport object to be saved
     * @return the saved version of the CourseGroupInterimReport object
     */
    @Transactional
    public CourseGroupInterimReport updateFromDto(CourseGroupInterimReportDto courseGroupInterimReport) {
        if (courseGroupInterimReport == null) {
            throw new InvalidDataException("Cannot update courseGroupInterimReportDto from null object.")
        }
        CourseGroupInterimReport courseGroupInterimReportToSave = findByInterimReportIdAndCourseGroupId(courseGroupInterimReport.interimReportId, courseGroupInterimReport.courseGroupId)
        if (courseGroupInterimReport.staffCompletedId != null) {
            courseGroupInterimReportToSave.staffCompleted = staffService.findById(courseGroupInterimReport.staffCompletedId)
        }
        courseGroupInterimReportToSave.complete = courseGroupInterimReport.complete
        return save(courseGroupInterimReportToSave)
    }
}
