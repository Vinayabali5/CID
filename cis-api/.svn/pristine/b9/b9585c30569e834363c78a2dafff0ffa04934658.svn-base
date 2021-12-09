package uk.ac.reigate.services.admissions

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.dto.admissions.InterviewDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.admissions.InterviewRepository
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.lookup.StudentTypeService
import uk.ac.reigate.services.student.StudentService
import uk.ac.reigate.services.student.StudentYearService

@Service
class InterviewService implements ICoreDataService<Student, Integer> {
    
    @Autowired
    InterviewRepository interviewRepository
    
    @Autowired
    private final StudentService studentService;
    
    @Autowired
    private final StaffService staffService;
    
    @Autowired
    private final OfferTypeService offerTypeService;
    
    @Autowired
    private final StudentTypeService studentTypeService;
    
    @Autowired
    private final StudentYearService studentYearService
    
    @Autowired
    private final AcademicYearService academicYearService
    
    /**
     * Default NoArgs constructor
     */
    InterviewService() {}
    
    /**
     * Autowired Constructor
     *
     * @param interviewRepository
     */
    InterviewService(InterviewRepository interviewRepository, StudentService studentService, StaffService staffService, OfferTypeService offerTypeService, StudentTypeService studentTypeService, StudentYearService studentYearService, AcademicYearService academicYearService) {
        super();
        this.interviewRepository = interviewRepository;
        this.studentService= studentService;
        this.staffService= staffService;
        this.offerTypeService= offerTypeService;
        this.studentTypeService = studentTypeService;
        this.studentYearService = studentYearService;
        this.academicYearService = academicYearService;
    }
    
    /**
     * This service method is used to update a Interview object in the database from a partial or complete Interview object.
     *
     * @param interview the partial or complete Interview object to be saved
     * @return the saved version of the Interview object
     */
    @PreAuthorize("@securityChecker.checkWriter(authentication) or hasAnyRole('ROLE_Admissions', 'ROLE_Admissions - Data Entry', 'ROLE_Admissions - Interviewer')")
    public Student updateFromDto(InterviewDto interviewDto) {
        if(interviewDto.studentId == null) {
            throw new InvalidDataException("Student ID should not be null when updating")
        }
        Student student = findById(interviewDto.studentId)
        AcademicYear year = academicYearService.getNextAcademicYear()
        StudentYear studentYearToUpdate = studentYearService.findByStudentAndYear(student.id, year.id)
        if(interviewDto.interviewerId != null){
            student.interviewer = staffService.findById(interviewDto.interviewerId)
        }
        if(interviewDto.offerTypeId != null){
            student.offerType = offerTypeService.findById(interviewDto.offerTypeId)
        }
        if(interviewDto.studentTypeId != null){
            studentYearToUpdate.studentType = studentTypeService.findById(interviewDto.studentTypeId)
        }
        student.interviewDate = interviewDto.interviewDate;
        student.possibleAspire = interviewDto.possibleAspire;
        student.possibleMvd = interviewDto.possibleMvd;
        student.learningSupportOnIntro = interviewDto.learningSupportOnIntro;
        student.schoolReportNotSeen = interviewDto.schoolReportNotSeen;
        student.noShowAtInterview = interviewDto.noShowAtInterview;
        student.careerAims = interviewDto.careerAims;
        student.workVoluntaryExperience = interviewDto.workVoluntaryExperience;
        student.hobbiesInterestsOtherAchievements = interviewDto.hobbiesInterestsOtherAchievements;
        student.favoriteSubject = interviewDto.favoriteSubject;
        student.courseworkOrExams = interviewDto.courseworkOrExams;
        student.reasonsForReigateCollege = interviewDto.reasonsForReigateCollege;
        student.interviewBy = interviewDto.interviewBy;
        student.otherSchoolCollegeAppliedFor = interviewDto.otherSchoolCollegeAppliedFor;
        student.learningSupportNeeds = interviewDto.learningSupportNeeds;
        student.learningSupportNeedsDetails = interviewDto.learningSupportNeedsDetails;
        Student savedApplication = studentService.save(student)
        StudentYear savedStudentYear = studentYearService.save(studentYearToUpdate)
        return savedApplication
    }
    
    @PreAuthorize("@securityChecker.checkWriter(authentication) or hasAnyRole('ROLE_Admissions', 'ROLE_Admissions - Data Entry', 'ROLE_Admissions - Interviewer')")
    @Transactional
    public StudentYear updateDto(InterviewDto interviewDto) {
        if(interviewDto.studentId == null) {
            throw new InvalidDataException("Student ID should not be null when updating")
        }
        Student student = findById(interviewDto.studentId)
        AcademicYear year = academicYearService.getNextAcademicYear()
        StudentYear studentYearToUpdate = studentYearService.findByStudentAndYear(student.id, year.id)
        if(interviewDto.studentTypeId != null){
            studentYearToUpdate.studentType = studentTypeService.findById(interviewDto.studentTypeId)
        }
        StudentYear savedStudentYear = studentYearService.save(studentYearToUpdate)
        return savedStudentYear
    }
    
    @Override
    @Transactional(readOnly = true)
    Student findById(Integer id) {
        return studentService.findById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    List<Student> findAll() {
        return studentService.findAll();
    }
    
    @Transactional
    public Student save(Student student) {
        return studentService.save(student)
    }
    
    @Override
    public void delete(Student obj) {
        throw new InvalidOperationException("Student should not be deleted.")
    }
}
