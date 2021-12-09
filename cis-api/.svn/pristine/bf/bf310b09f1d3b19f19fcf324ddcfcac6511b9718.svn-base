package uk.ac.reigate.services.interimreport

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Enrolment
import uk.ac.reigate.domain.attendance.StudentAttendanceByCourseGroupForPeriod
import uk.ac.reigate.domain.interimreport.InterimReport
import uk.ac.reigate.domain.interimreport.InterimReportsDue
import uk.ac.reigate.domain.interimreport.InterimReportsDuePk
import uk.ac.reigate.domain.interimreport.StudentInterimReport
import uk.ac.reigate.dto.interimreport.InterimReportDataCollectionDto
import uk.ac.reigate.repositories.interimreport.InterimReportsDueRepository
import uk.ac.reigate.repositories.interimreport.StudentInterimReportRepository
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.CourseGroupService
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.PersonService
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.attendance.StudentAttendanceByCourseGroupForPeriodService
import uk.ac.reigate.services.cristal.InterimReportEffortGradeService
import uk.ac.reigate.services.enrolments.EnrolmentService

/**
 * This service class is used to process data for Course Group Interim Reports. 
 * 
 *
 */
@Service
class InterimReportsDueService implements ICoreDataService<InterimReportsDue, InterimReportsDuePk>{
    
    @Autowired
    InterimReportsDueRepository interimReportsDueRepository
    
    @Autowired
    CourseGroupService courseGroupService;
    
    @Autowired
    StaffService staffService;
    
    @Autowired
    AcademicYearService academicYearService;
    
    @Autowired
    PersonService personService
    
    @Autowired
    EnrolmentService enrolmentService;
    
    @Autowired
    InterimReportService interimReportService
    
    @Autowired
    StudentInterimReportRepository studentInterimReportRepository
    
    @Autowired
    InterimReportEffortGradeService interimReportEffortGradeService
    
    @Autowired
    StudentAttendanceByCourseGroupForPeriodService studentAttendanceByCourseGroupForPeriodService
    /**
     * Default NoArgs constructor
     */
    InterimReportsDueService() {}
    
    InterimReportsDueService(InterimReportsDueRepository interimReportsDueRepository) {
        this.interimReportsDueRepository = interimReportsDueRepository;
    }
    /**
     * This method is used to retrieve the list of InterimReportsDue.
     *
     * @return the list of InterimReportsDue
     */
    @Override
    @Transactional(readOnly = true)
    public List<InterimReportsDue> findAll() {
        return interimReportsDueRepository.findAll()
    }
    
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<InterimReportsDue> findMyInterimReports(staffId) {
        List<InterimReportsDue> myReports = new ArrayList<InterimReportsDue>();
        List<CourseGroup> courseGroups = new ArrayList<CourseGroup>();
        Integer yearId = academicYearService.getCurrentAcademicYear().id;
        courseGroups.addAll(courseGroupService.findByTeacherAndYear(staffId, yearId))
        if(courseGroups) {
            courseGroups.each { it ->
                InterimReportsDue interimReportsDue = interimReportsDueRepository.findByCourseGroup_Id(it.id)
                if(interimReportsDue) {
                    myReports.add(interimReportsDue)
                } else {
                    return null
                }
            }
        }
        return myReports
    }
    
    /**
     * This method is used to retrieve the list of interim report data collection.
     * @return
     */
    public List<InterimReportDataCollectionDto> findCurrentReviewList(Integer courseGroupId) {
        AcademicYear academicYear = academicYearService.getCurrentAcademicYear()
        // This will retrieve the list of current enrolled students with end date is set to null
        List<Enrolment> enrolmentList = enrolmentService.findCurrentCourseGroupAndYear(courseGroupId, academicYear.id)
        List<StudentInterimReport> studentInterimReports = new ArrayList<StudentInterimReport>();
        List<StudentAttendanceByCourseGroupForPeriod> studentAttendanceByCourseGroupForPeriods = new ArrayList<StudentAttendanceByCourseGroupForPeriod>();
        List<InterimReportDataCollectionDto> interimReportDataCollectionDtos = new ArrayList<InterimReportDataCollectionDto>();
        // Iterate list retrieving previous IR Information
        if(enrolmentList) {
            enrolmentList.each { it ->
                Integer studentId = it.student.id
                // check the IR for the student (if no previous IR is then set effort grades to 4)
                InterimReport previousInterimReport = interimReportService.getPrevious()
                InterimReport currentInterimReport = interimReportService.getCurrent()
                StudentInterimReport currentStudentInterimReport = studentInterimReportRepository.findByStudent_IdAndCourseGroup_IdAndInterimReport_Id(studentId, courseGroupId, currentInterimReport.id)
                if(currentStudentInterimReport == null) {
                    StudentInterimReport previousStudentInterimReport = studentInterimReportRepository.findByStudent_IdAndCourseGroup_IdAndInterimReport_Id(studentId, courseGroupId, previousInterimReport.id)
                    if(previousStudentInterimReport == null) {
                        currentStudentInterimReport = previousStudentInterimReport
                        currentStudentInterimReport.motivation.id = 4
                        currentStudentInterimReport.classEthic.id = 4
                        currentStudentInterimReport.timeManagement.id = 4
                        currentStudentInterimReport.keyAssessment1 = null
                        currentStudentInterimReport.keyAssessment2 = null
                        currentStudentInterimReport.keyAssessment3 = null
                    } else {
                        currentStudentInterimReport = previousStudentInterimReport
                        currentStudentInterimReport.keyAssessment1 = null
                        currentStudentInterimReport.keyAssessment2 = null
                        currentStudentInterimReport.keyAssessment3 = null
                    }
                }
                if(currentStudentInterimReport.interimReport == null) {
                    StudentAttendanceByCourseGroupForPeriod studentAttendanceByCourseGroupForPeriod = studentAttendanceByCourseGroupForPeriodService.getAttendanceByStudentIdAndCourseGroupId(studentId, courseGroupId)
                }
                StudentAttendanceByCourseGroupForPeriod studentAttendanceByCourseGroupForPeriod = studentAttendanceByCourseGroupForPeriodService.getAttendanceByStudentIdAndCourseGroupIdAndIR(studentId, courseGroupId, currentStudentInterimReport.interimReport.id)
                interimReportDataCollectionDtos.add(new InterimReportDataCollectionDto(currentStudentInterimReport, studentAttendanceByCourseGroupForPeriod))
            }
        }
        return interimReportDataCollectionDtos
    }
    
    @Override
    public InterimReportsDue findById(InterimReportsDuePk id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public InterimReportsDue save(InterimReportsDue obj) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public void delete(InterimReportsDue obj) {
        // TODO Auto-generated method stub
        
    }
}
