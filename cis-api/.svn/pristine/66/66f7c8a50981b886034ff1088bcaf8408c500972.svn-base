package uk.ac.reigate.services.attendance

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Enrolment
import uk.ac.reigate.domain.attendance.StudentAttendanceByCourseGroupForPeriod
import uk.ac.reigate.domain.interimreport.InterimReport
import uk.ac.reigate.repositories.attendance.StudentAttendanceByCourseGroupForPeriodRepository
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.enrolments.EnrolmentService
import uk.ac.reigate.services.interimreport.InterimReportService

@Service
class StudentAttendanceByCourseGroupForPeriodService {
    
    @Autowired
    StudentAttendanceByCourseGroupForPeriodRepository studentAttendanceByCourseGroupForPeriodRepository
    
    @Autowired
    private final AcademicYearService academicYearService
    
    @Autowired
    private final InterimReportService interimReportService
    
    @Autowired
    EnrolmentService enrolmentService;
    /**
     * Default NoArgs constructor
     */
    StudentAttendanceByCourseGroupForPeriodService() {}
    
    /**
     * Autowired Constructor
     *
     * @param studentAttendanceByCourseGroupForPeriodRepository
     */
    StudentAttendanceByCourseGroupForPeriodService(StudentAttendanceByCourseGroupForPeriodRepository studentAttendanceByCourseGroupForPeriodRepository) {
        this.studentAttendanceByCourseGroupForPeriodRepository = studentAttendanceByCourseGroupForPeriodRepository;
    }
    
    @Transactional(readOnly = true)
    StudentAttendanceByCourseGroupForPeriod getAttendanceForPeriod(Integer studentId, Integer courseGroupId, Date startDate, Date endDate) {
        return studentAttendanceByCourseGroupForPeriodRepository.findByStudentIdAndCourseGroupIdForDateRange(studentId, courseGroupId, startDate, endDate)
    }
    
    @Transactional(readOnly = true)
    List<StudentAttendanceByCourseGroupForPeriod> findAttendanceList(Integer courseGroupId) {
        AcademicYear academicYear = academicYearService.getCurrentAcademicYear()
        List<StudentAttendanceByCourseGroupForPeriod> studentInterimReports = new ArrayList<StudentAttendanceByCourseGroupForPeriod>();
        // This will retrieve the list of current enrolled students with end date is set to null
        List<Enrolment> enrolmentList = enrolmentService.findCurrentCourseGroupAndYear(courseGroupId, academicYear.id)
        // Iterate list retrieving previous IR Information
        if(enrolmentList != null) {
            enrolmentList.each { it ->
                Integer studentId = it.student.id
                InterimReport previousInterimReport = interimReportService.getPrevious()
                InterimReport currentInterimReport = interimReportService.getCurrent()
                StudentAttendanceByCourseGroupForPeriod studentAttendanceByCourseGroupForPeriod = studentAttendanceByCourseGroupForPeriodRepository.findByStudent_IdAndCourseGroup_IdAndInterimReport_Id(studentId, courseGroupId, currentInterimReport.id)
                studentInterimReports.add(studentAttendanceByCourseGroupForPeriod)
            }
        }
        return studentInterimReports
    }
    
    @Transactional(readOnly = true)
    StudentAttendanceByCourseGroupForPeriod getAttendanceByStudentIdAndCourseGroupId(Integer studentId, Integer courseGroupId) {
        AcademicYear academicYear = academicYearService.getCurrentAcademicYear()
        Date startDate = academicYear.startDate
        Date endDate = academicYear.endDate
        return studentAttendanceByCourseGroupForPeriodRepository.findByStudentIdAndCourseGroupIdForDateRange(studentId, courseGroupId, startDate, endDate)
    }
    
    @Transactional(readOnly = true)
    StudentAttendanceByCourseGroupForPeriod getAttendanceByStudentIdAndCourseGroupIdAndIR(Integer studentId, Integer courseGroupId, Integer interimReportId) {
        InterimReport interimReport = interimReportService.findById(interimReportId)
        Date startDate = interimReport.startDate
        Date endDate = interimReport.endDate
        return studentAttendanceByCourseGroupForPeriodRepository.findByStudentIdAndCourseGroupIdForDateRange(studentId, courseGroupId, startDate, endDate)
    }
}
