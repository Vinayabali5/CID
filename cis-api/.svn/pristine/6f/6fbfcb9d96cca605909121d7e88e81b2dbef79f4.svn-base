package uk.ac.reigate.services.interimreport

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Enrolment
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.interimreport.InterimReport
import uk.ac.reigate.domain.interimreport.StudentInterimReport
import uk.ac.reigate.dto.interimreport.StudentInterimReportDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.interimreport.StudentInterimReportRepository
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.CourseGroupService
import uk.ac.reigate.services.CourseService
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IStudentDataService
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.cristal.InterimReportEffortGradeService
import uk.ac.reigate.services.enrolments.EnrolmentService
import uk.ac.reigate.services.lookup.PossibleGradeService
import uk.ac.reigate.services.student.StudentService

@Service
class StudentInterimReportService implements ICoreDataService<StudentInterimReport, Integer>, IStudentDataService<List<StudentInterimReport>> {
    
    @Autowired
    StudentInterimReportRepository studentInterimReportRepository
    
    @Autowired
    InterimReportEffortGradeService interimReportEffortGradeService
    
    @Autowired
    private final StudentService studentService;
    
    @Autowired
    AcademicYearService academicYearService
    
    @Autowired
    EnrolmentService enrolmentService;
    
    @Autowired
    private final StaffService staffService;
    
    @Autowired
    private final CourseService courseService;
    
    @Autowired
    private final CourseGroupService courseGroupService;
    
    @Autowired
    private final InterimReportService interimReportService;
    
    @Autowired
    private final PossibleGradeService possibleGradeService;
    
    /**
     * Default NoArgs constructor
     */
    StudentInterimReportService() {}
    
    StudentInterimReportService(StudentInterimReportRepository studentInterimReportRepository, StudentService studentService, StaffService staffService, CourseService courseService, CourseGroupService courseGroupService, InterimReportService interimReportService, PossibleGradeService possibleGradeService, InterimReportEffortGradeService interimReportEffortGradeService){
        super();
        this.studentInterimReportRepository = studentInterimReportRepository;
        this.studentService = studentService;
        this.staffService = staffService;
        this.courseService = courseService;
        this.courseGroupService = courseGroupService;
        this.interimReportService = interimReportService;
        this.possibleGradeService = possibleGradeService;
        this.interimReportEffortGradeService = interimReportEffortGradeService;
    }
    
    /**
     * Find an single StudentInterimReport using the StudentInterimReport ID field
     *
     * @param id the ID fields to search for
     * @return the StudentInterimReport object that matches the ID supplied, or null if not found
     *
     */
    @Override
    @Transactional(readOnly = true)
    StudentInterimReport findById(Integer id) {
        return studentInterimReportRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all StudentInterimReport data objects. 
     *
     * @return a List of StudentInterimReport
     */
    @Override
    @Transactional(readOnly = true)
    List<StudentInterimReport> findAll() {
        return studentInterimReportRepository.findAll();
    }
    
    /**
     * This method is used to retrieve a list of student interim reports that a specific student data object.
     * 
     * @param student The Student object to use for the search
     * @return a List of StudentInterimReport data objects
     */
    public List<StudentInterimReport> getByStudent(Student student){
        return studentInterimReportRepository.findByStudent(student);
    }
    
    /**
     * This method is used to retrieve a list of student interim reports that a specific studentId.
     * 
     * @param studentId The studentId to use for the search
     * @return a List of StudentInterimReport data objects
     */
    public List<StudentInterimReport> getByStudentId(Integer studentId){
        return studentInterimReportRepository.findByStudent_Id(studentId);
    }
    
    /**
     * This service method is used to update a StudentInterimReport object in the database from StudentInterimReport object
     *
     * @param studentInterimReport the StudentInterimReport object to be loaded
     * @return the saved version of the studentInterimReport object
     */
    @Transactional
    public StudentInterimReport updateFromDto(StudentInterimReportDto studentInterimReport) {
        if(studentInterimReport == null ) {
            throw new InvalidDataException("Cannot update StudentInterimReport from null object.")
        }
        StudentInterimReport studentInterimReportToSave = findById(studentInterimReport.id)
        studentInterimReportToSave.student = studentInterimReport.studentId != null ? studentService.findById(studentInterimReport.studentId) : null
        studentInterimReportToSave.interimReport = studentInterimReport.interimReportId != null ? interimReportService.findById(studentInterimReport.interimReportId) : null
        studentInterimReportToSave.course = studentInterimReport.courseId != null ? courseService.findById(studentInterimReport.courseId) : null
        studentInterimReportToSave.courseGroup = studentInterimReport.courseGroupId != null ? courseGroupService.findById(studentInterimReport.courseGroupId) : null
        studentInterimReportToSave.staff = studentInterimReport.staffId != null ? staffService.findById(studentInterimReport.staffId) : null
        studentInterimReportToSave.currentPredictedGrade = studentInterimReport.currentPredictedGradeId != null ? possibleGradeService.findById(studentInterimReport.currentPredictedGradeId) : null
        studentInterimReportToSave.keyAssessment1 = studentInterimReport.keyAssessment1Id != null ? possibleGradeService.findById(studentInterimReport.keyAssessment1Id) : null
        studentInterimReportToSave.keyAssessment2 = studentInterimReport.keyAssessment2Id != null ? possibleGradeService.findById(studentInterimReport.keyAssessment2Id) : null
        studentInterimReportToSave.keyAssessment3 = studentInterimReport.keyAssessment3Id != null ? possibleGradeService.findById(studentInterimReport.keyAssessment3Id) : null
        studentInterimReportToSave.motivation = studentInterimReport.motivationId != null ? interimReportEffortGradeService.findById(studentInterimReport.motivationId) : null
        studentInterimReportToSave.classEthic = studentInterimReport.classEthicId != null ? interimReportEffortGradeService.findById(studentInterimReport.classEthicId) : null
        studentInterimReportToSave.timeManagement = studentInterimReport.timeManagementId != null ? interimReportEffortGradeService.findById(studentInterimReport.timeManagementId) : null
        studentInterimReportToSave.totalPossible = studentInterimReport.totalPossible
        studentInterimReportToSave.absence = studentInterimReport.absence
        studentInterimReportToSave.authorisedAbsence = studentInterimReport.authorisedAbsence
        studentInterimReportToSave.late = studentInterimReport.late
        return save(studentInterimReportToSave)
    }
    
    @Transactional
    public StudentInterimReport createFromDto(StudentInterimReportDto studentInterimReport) {
        if(studentInterimReport == null ) {
            throw new InvalidDataException("Cannot update StudentInterimReport from null object.")
        }
        StudentInterimReport studentInterimReportToSave = new StudentInterimReport()
        studentInterimReportToSave.student = studentInterimReport.studentId != null ? studentService.findById(studentInterimReport.studentId) : null
        studentInterimReportToSave.interimReport = interimReportService.getCurrent();
        studentInterimReportToSave.course = studentInterimReport.courseId != null ? courseService.findById(studentInterimReport.courseId) : null
        studentInterimReportToSave.courseGroup = studentInterimReport.courseGroupId != null ? courseGroupService.findById(studentInterimReport.courseGroupId) : null
        studentInterimReportToSave.staff = studentInterimReport.staffId != null ? staffService.findById(studentInterimReport.staffId) : null
        studentInterimReportToSave.currentPredictedGrade = studentInterimReport.currentPredictedGradeId != null ? possibleGradeService.findById(studentInterimReport.currentPredictedGradeId) : null
        studentInterimReportToSave.keyAssessment1 = studentInterimReport.keyAssessment1Id != null ? possibleGradeService.findById(studentInterimReport.keyAssessment1Id) : null
        studentInterimReportToSave.keyAssessment2 = studentInterimReport.keyAssessment2Id != null ? possibleGradeService.findById(studentInterimReport.keyAssessment2Id) : null
        studentInterimReportToSave.keyAssessment3 = studentInterimReport.keyAssessment3Id != null ? possibleGradeService.findById(studentInterimReport.keyAssessment3Id) : null
        studentInterimReportToSave.motivation = studentInterimReport.motivationId != null ? interimReportEffortGradeService.findById(studentInterimReport.motivationId) : null
        studentInterimReportToSave.classEthic = studentInterimReport.classEthicId != null ? interimReportEffortGradeService.findById(studentInterimReport.classEthicId) : null
        studentInterimReportToSave.timeManagement = studentInterimReport.timeManagementId != null ? interimReportEffortGradeService.findById(studentInterimReport.timeManagementId) : null
        studentInterimReportToSave.totalPossible = studentInterimReport.totalPossible
        studentInterimReportToSave.absence = studentInterimReport.absence
        studentInterimReportToSave.authorisedAbsence = studentInterimReport.authorisedAbsence
        studentInterimReportToSave.late = studentInterimReport.late
        return save(studentInterimReportToSave)
    }
    
    /**
     * @param studentId
     * @param yearId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<StudentInterimReport> findByStudentAndYearId(Integer studentId, Integer yearId){
        return studentInterimReportRepository.findByStudent_IdAndInterimReport_Year_Id(studentId, yearId)
    }
    
    
    /**
     * This service method is used to save a complete StudentInterimReport object in the database
     *
     * @param studentInterimReport the new StudentInterimReport object to be saved
     * @return the saved version of the StudentInterimReport object
     */
    @Override
    @Transactional
    public StudentInterimReport save(StudentInterimReport studentInterimReport) {
        return studentInterimReportRepository.save(studentInterimReport)
    }
    
    /**
     * This service method is used to delete a complete StudentInterimReport object in the database
     *
     * @param studentInterimReport the  StudentInterimReport object to be deleted
     * 
     */
    @Override
    public void delete(StudentInterimReport studentInterimReport) {
        studentInterimReportRepository.delete(studentInterimReport)
    }
    
    public List <StudentInterimReport> findByCourseId(Integer courseId) {
        List <StudentInterimReport> studentInterimReport = studentInterimReportRepository.findByCourse_Id(courseId)
        return studentInterimReport
    }
    
    public List <StudentInterimReport> findByCourseGroupId(Integer courseGroupId) {
        List <StudentInterimReport> studentInterimReport = studentInterimReportRepository.findByCourseGroup_Id(courseGroupId)
        return studentInterimReport
    }
    
    public List <StudentInterimReport> findByCourseGroupIdAndInterimReportId(Integer courseGroupId, Integer interimReportId) {
        List <StudentInterimReport> studentInterimReport = studentInterimReportRepository.findByCourseGroup_IdAndInterimReport_Id(courseGroupId, interimReportId)
        return studentInterimReport
    }
    
    public StudentInterimReport findByStudentAndCourseGroupAndInterimReport(Integer studentId, Integer courseGroupId, Integer interimReportId) {
        return studentInterimReportRepository.findByStudent_IdAndCourseGroup_IdAndInterimReport_Id(studentId, courseGroupId, interimReportId)
    }
}

