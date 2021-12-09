package uk.ac.reigate.services.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.admissions.CollegeFundPaid
import uk.ac.reigate.domain.lookup.StudentRemarkPermission
import uk.ac.reigate.domain.lookup.TutorGroup
import uk.ac.reigate.dto.StudentAdmissionDto
import uk.ac.reigate.dto.StudentDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.StudentRepository
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.CollegeFundPaidService
import uk.ac.reigate.services.CourseGroupService
import uk.ac.reigate.services.CourseService
import uk.ac.reigate.services.DestinationService
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.LLDDHealthProblemService
import uk.ac.reigate.services.SchoolReportStatusService
import uk.ac.reigate.services.SchoolService
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.TutorGroupService
import uk.ac.reigate.services.admissions.ApplicationStatusService
import uk.ac.reigate.services.admissions.OfferTypeService
import uk.ac.reigate.services.enrolments.EnrolmentService
import uk.ac.reigate.services.ilr.EthnicityService
import uk.ac.reigate.services.ilr.RestrictedUseIndicatorService
import uk.ac.reigate.services.lookup.StudentTypeService
import uk.ac.reigate.services.risk_assessment.RiskLevelService

@Service
class StudentService implements ICoreDataService<Student, Integer>{
    
    @Autowired
    StudentRepository studentRepository
    
    @Autowired
    StudentYearService studentYearService
    
    @Autowired
    AcademicYearService academicYearService
    
    @Autowired
    StudentTypeService studentTypeService
    
    @Autowired
    TutorGroupService tutorGroupService
    
    @Autowired
    CourseService courseService
    
    @Autowired
    CourseGroupService courseGroupService
    
    @Autowired
    EthnicityService ethnicityService
    
    @Autowired
    SchoolReportStatusService schoolReportStatusService
    
    @Autowired
    CollegeFundPaidService collegeFundPaidService
    
    @Autowired
    StaffService staffService
    
    @Autowired
    RestrictedUseIndicatorService restrictedUseIndicatorService
    
    @Autowired
    SchoolService schoolService
    
    @Autowired
    EnrolmentService enrolmentService
    
    @Autowired
    DestinationService destinationService
    
    @Autowired
    StudentRemarkPermissionService studentRemarkPermissionService
    
    @Autowired
    LLDDHealthProblemService llddHealthProblemService
    
    @Autowired
    RiskLevelService riskLevelService
    
    @Autowired
    ApplicationStatusService applicationStatusService
    
    @Autowired
    OfferTypeService offerTypeService
    
    /**
     * Default NoArgs constructor
     */
    StudentService() {}
    
    /**
     * Autowired constructor
     * 
     * @param studentRepository
     */
    StudentService(StudentRepository studentRepository, StudentYearService studentYearService, AcademicYearService academicYearService,
    StudentTypeService studentTypeService, TutorGroupService tutorGroupService, CourseService courseService,
    CourseGroupService courseGroupService, EthnicityService ethnicityService, SchoolReportStatusService schoolReportStatusService,
    CollegeFundPaidService collegeFundPaidService, StaffService staffService, RestrictedUseIndicatorService restrictedUseIndicatorService,
    SchoolService schoolService, EnrolmentService enrolmentService, DestinationService destinationService,
    StudentRemarkPermissionService studentRemarkPermissionService, LLDDHealthProblemService llddHealthProblemService, RiskLevelService riskLevelService,
    ApplicationStatusService applicationStatusService, OfferTypeService offerTypeService) {
        this.studentRepository = studentRepository
        this.studentYearService = studentYearService
        this.academicYearService = academicYearService
        this.studentTypeService = studentTypeService
        this.tutorGroupService = tutorGroupService;
        this.courseService = courseService;
        this.courseGroupService = courseGroupService;
        this.ethnicityService = ethnicityService;
        this.schoolReportStatusService = schoolReportStatusService;
        this.collegeFundPaidService = collegeFundPaidService;
        this.staffService = staffService;
        this.restrictedUseIndicatorService = restrictedUseIndicatorService;
        this.schoolService = schoolService;
        this.enrolmentService = enrolmentService;
        this.destinationService = destinationService;
        this.studentRemarkPermissionService = studentRemarkPermissionService;
        this.llddHealthProblemService = llddHealthProblemService;
        this.riskLevelService = riskLevelService;
        this.applicationStatusService = applicationStatusService;
        this.offerTypeService = offerTypeService;
    }
    
    /**
     * This service method is used to retrieve an individual Student object from the database.
     * 
     * @param id the id of the member of student to retrieve
     * @return the Student object identified by the id
     */
    @Override
    @Transactional(readOnly = true)
    Student findById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }
    
    /**
     * This service method is used to retrieve all instances of the Student object from the database.
     * 
     * @return A List of Student objects
     */
    @Override
    @Transactional(readOnly = true)
    List<Student> findAll() {
        return studentRepository.findAll();
    }
    
    /**
     * This service method is used to retrieve all instances of the Student object by Person and year from the database.
     *
     * @return A List of Student objects
     */
    public List<Student> findByPersonSurnameAndDob(String surname, Date dob) {
        return studentRepository.findByPerson_SurnameAndPerson_Dob(surname, dob)
    }
    
    /**
     * This service method is used to retrieve all instances of the Student object by Person and year from the database.
     *
     * @return A List of Student objects
     */
    public List<Student> findByPersonInAndStudentYears_Year(Collection<Person> person, AcademicYear year) {
        return studentRepository.findByPersonInAndStudentYears_Year(person, year)
    }
    
    /**
     * This service method is used to retrieve all instances of the Student object from ref no and year from the database.
     *
     * @return A List of Student objects
     */
    public List<Student> findByReferenceNoContainingIgnoreCaseAndStudentYears_Year(String referenceNo, AcademicYear year) {
        return studentRepository.findByReferenceNoContainingIgnoreCaseAndStudentYears_Year(referenceNo, year)
    }
    
    public Student findByStudentIdAndYear(Integer studentId, AcademicYear year) {
        return studentRepository.findByIdAndStudentYears_Year(studentId, year)
    }
    
    /**
     * This service method is used to retrieve all instances of the Student object by next year from the database.
     *
     * @return A List of Student objects
     */
    public List<Student> findAllApplication() {
        return studentRepository.findAllByStudentYears_Year(this.academicYearService.getNextAcademicYear())
    }
    /**
     * This service method is used to save a complete instance of a Student object to the database.
     * 
     * @param student a complete Student object to persist to the database 
     * @return the saved version of the Student object 
     */
    @Override
    @PreAuthorize("@securityChecker.checkWriter(authentication) or hasAnyRole('First Aid Coordinator', 'ROLE_First Aid Coordinator', 'ROLE_Service User', 'ROLE_Quals on Entry', 'Quals on Entry')")
    @Transactional
    public Student save(Student student) {
        return studentRepository.save(student)
    }
    
    /**
     * This service method is used to save a list of complete Student objects to the database. 
     * 
     * @param students a list of Student objects to persist to the database
     * @return the saved version of the list of Student objects
     */
    @Transactional
    public List<Student> saveStudents(List<Student> students) {
        return students.collect { student -> save( student ) };
    }
    
    /**
     * This service method is used to retrieve an individual Student object from the database.
     *
     * @param id the id of the member of student to retrieve
     * @return the Student object identified by the id
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    @Transactional(readOnly = true)
    List<Student> findCurrentStudents() {
        return studentRepository.findCurrent();
    }
    
    /**
     * This method is used to retrieve a list of the Student objects for the supplied Student.
     * 
     * @param year the AcademicYear object to use for the search
     * @return a List of Student objects for the year
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    List<Student> findStudentsInYear(AcademicYear year) {
        List<Student> students = studentRepository.findAllByStudentYears_Year();
        return students;
    }
    
    /**
     * This service method is used to design to update a single students remark permission
     *
     * @param student the partial Student object to be saved
     * @return the saved version of the Student object
     */
    Student updateStudentRemarkPermission(Student student, StudentRemarkPermission remarkPermission) {
        //Student s = findById(student.id);
        student.studentRemarkPermission = remarkPermission;
        return save(student);
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Student should not be deleted.
     */
    @Override
    public void delete(Student obj) {
        throw new InvalidOperationException("Student should not be deleted")
    }
    
    /**
     * This service method is used to update Student object in the database from a partial Student object.
     *
     * @param student the partial Student object to be saved
     * @return the saved version of the Student object
     */
    Student updateCollegeFundPaid(Student student, CollegeFundPaid collegeFundPaid, Integer collegeFundPaidYears){
        student.collegeFundPaid = collegeFundPaid
        student.collegeFundPaidYears = collegeFundPaidYears
        return save(student);
    }
    
    /**
     * This service method is used to update a StudentAdmission object in the database from a partial or complete Student object.
     *
     * @param student the partial or complete Student object to be saved
     * @return the saved version of the Student object
     */
    @Transactional
    public Student updateFromDto(StudentDto studentDto) {
        if (studentDto == null) {
            throw new InvalidDataException("Cannot update student from null object.")
        }
        if(studentDto.id == null) {
            throw new InvalidDataException("Cannot update student from null Id.")
        }
        Student student = findById(studentDto.id)
        if(studentDto.previousSchoolId != null) {
            student.school = schoolService.findById(studentDto.previousSchoolId)
        }
        if(studentDto.ethnicityId != null) {
            student.ethnicity = ethnicityService.findById(studentDto.ethnicityId)
        }
        if(studentDto.restrictedUseIndicatorId != null) {
            student.restrictedUseIndicator = restrictedUseIndicatorService.findById(studentDto.restrictedUseIndicatorId)
        }
        if(studentDto.llddHealthProblemId != null) {
            student.llddHealthProblem = llddHealthProblemService.findById(studentDto.llddHealthProblemId)
        }
        student.riskLevel = studentDto.riskLevelId != null ? riskLevelService.findById(studentDto.riskLevelId) : null
        student.studentRemarkPermission =  studentDto.studentRemarkPermissionId != null ? studentRemarkPermissionService.findById(studentDto.studentRemarkPermissionId) : null
        student.uln = studentDto.uln
        student.uci = studentDto.uci
        student.studentEmail = studentDto.studentEmail
        student.medicalNote = studentDto.medicalNote
        student.resident = studentDto.resident
        student.contactByPost = studentDto.contactByPost
        student.contactByPhone = studentDto.contactByPhone
        student.contactByEmail = studentDto.contactByEmail
        student.monitorable = studentDto.monitorable
        student.possibleAspire = studentDto.possibleAspire
        student.schoolReportNotSeen = studentDto.schoolReportNotSeen
        student.noShowAtInterview = studentDto.noShowAtInterview
        student.freeMealsWhileAtSchool = studentDto.freeMealsWhileAtSchool
        student.parentsUniversityEducated = studentDto.parentsUniversityEducated
        student.learningSupportNeedsDetails = studentDto.learningSupportNeedsDetails
        return save(student)
    }
    
    
    /**
     * This service method is used to update a StudentAdmission object in the database from a partial or complete Student object.
     *
     * @param student the partial or complete Student object to be saved
     * @return the saved version of the Student object
     */
    @Transactional
    public Student updateFromAdmissionDto(StudentAdmissionDto studentAdmissionDto) {
        if (studentAdmissionDto == null) {
            throw new InvalidDataException("Cannot update studentAdmission from null object.")
        }
        if(studentAdmissionDto.id == null) {
            throw new InvalidDataException("Cannot update studentAdmission from null Id.")
        }
        Student student = findById(studentAdmissionDto.id)
        if(studentAdmissionDto.interviewerId != null) {
            student.interviewer = staffService.findById(studentAdmissionDto.interviewerId)
        }
        if(studentAdmissionDto.schoolReportStatusId != null) {
            student.schoolReportStatus = schoolReportStatusService.findById(studentAdmissionDto.schoolReportStatusId)
        }
        if(studentAdmissionDto.restrictedUseIndicatorId != null) {
            student.restrictedUseIndicator = restrictedUseIndicatorService.findById(studentAdmissionDto.restrictedUseIndicatorId)
        }
        if(studentAdmissionDto.collegeFundPaidId != null) {
            student.collegeFundPaid = collegeFundPaidService.findById(studentAdmissionDto.collegeFundPaidId)
        }
        if(studentAdmissionDto.ethnicityId != null) {
            student.ethnicity = ethnicityService.findById(studentAdmissionDto.ethnicityId)
        }
        if(studentAdmissionDto.offerTypeId != null) {
            student.offerType = offerTypeService.findById(studentAdmissionDto.offerTypeId)
        }
        if(studentAdmissionDto.statusId != null) {
            student.status = applicationStatusService.findById(studentAdmissionDto.statusId)
        }
        student.admissionsNotes = studentAdmissionDto.admissionsNotes
        student.refRequested = studentAdmissionDto.refRequested
        student.refReceived = studentAdmissionDto.refReceived
        student.interviewDate = studentAdmissionDto.interviewDate
        student.received = studentAdmissionDto.received
        student.reportReceived = studentAdmissionDto.schoolReportReceived
        student.reportRequested = studentAdmissionDto.schoolReportRequested
        student.blueCard = studentAdmissionDto.blueCard
        student.learningSupportOnIntro = studentAdmissionDto.learningSupportOnIntro
        student.cannotAttendIntro = studentAdmissionDto.cannotAttendIntroDay
        student.cannotAttendInduction = studentAdmissionDto.cannotAttendInductionDay
        student.inductionDate = studentAdmissionDto.inductionDate
        student.enrolmentInterviewDate = studentAdmissionDto.enrolmentInterviewDate
        student.enrolmentInterviewTime = studentAdmissionDto.enrolmentInterviewTime
        student.acceptanceReceived = studentAdmissionDto.acceptanceReceived
        student.ehcp = studentAdmissionDto.ehcp
        student.lookedAfterChildOrAdopted = studentAdmissionDto.lookedAfterChildOrAdopted
        student.childrenServicesInvolvedAtSchool = studentAdmissionDto.childrenServicesInvolvedAtSchool
        student.otherSocialSupportIssues = studentAdmissionDto.otherSocialSupportIssues
        student.contactByPost = studentAdmissionDto.contactByPost
        student.contactByPhone = studentAdmissionDto.contactByPhone
        student.contactByEmail = studentAdmissionDto.contactByEmail
        student.lrsOptOut = studentAdmissionDto.lrsOptOut
        student.collegeFundPaidYears = studentAdmissionDto.collegeFundPaidYears
        student.possibleAspire = studentAdmissionDto.possibleAspire
        student.schoolReportNotSeen = studentAdmissionDto.schoolReportNotSeen
        student.noShowAtInterview = studentAdmissionDto.noShowAtInterview
        student.freeMealsWhileAtSchool = studentAdmissionDto.freeMealsWhileAtSchool
        student.parentsUniversityEducated = studentAdmissionDto.parentsUniversityEducated
        student.interviewBy = studentAdmissionDto.interviewBy
        student.learningSupportNeedsDetails = studentAdmissionDto.learningSupportNeedsDetails
        return save(student)
    }
    
    /**
     * This method is used to retrieve a list of the Students by academicYearId and tutorGroup.
     *
     * @param academicYearId the ID for the AcademicYear to use for the search 
     * @param  tutorGroup the ID for the TutorGroup to use for the search
     * @return a List of Student objects for the Student
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    @Transactional(readOnly = true)
    List<Student> findByTutorGroup(AcademicYear academicYear, TutorGroup tutorGroup) {
        return studentRepository.findByStudentYears_Year_IdAndTutorGroup_Id(academicYear.id, tutorGroup.id);
    }
    
    /**
     * This method is used to retrieve a list of the Students by academicYearId and tutorGroupId.
     *
     * @param academicYearId the ID for the AcademicYear to use for the search 
     * @param  tutorGroupId the ID for the TutorGroup to use for the search
     * @return a List of Student objects for the Student
     */
    @Transactional(readOnly = true)
    List<Student> findByYearAndTutorGroup(Integer academicYearId, Integer tutorGroupId) {
        return studentRepository.findByAcademicYear_IdAndTutorGroup_Id(academicYearId, tutorGroupId);
    }
    
    /**
     * This method is used to retrieve a list of the Course objects for the supplied Student.
     * 
     * @param student the Student object to use for the search
     * @return a List of Course objects for the Student
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    List<Course> findStudentCourses(Student student) {
        return courseService.findByStudent(student)
    }
    
    /**
     * This method is used to retrieve a list of the CourseGroup objects for the supplied Student.
     *
     * @param student the Student object to use for the search
     * @return a List of CourseGroup objects for the Student
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    List<CourseGroup> findStudentCourseGroups(Student student) {
        return courseGroupService.findByStudent(student)
    }
    
    /**
     * This method is used to retrieve a list of the CourseGroup objects for the supplied Student and AcademicYear.
     *
     * @param student the Student object to use for the search
     * @param year the AcademicYear to use for the search
     * @return a List of CourseGroup objects for the Student for the specified AcademicYear
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    List<CourseGroup> findStudentCourseGroupsByYear(Student student, AcademicYear year) {
        return courseGroupService.findByStudentAndYear(student, year)
    }
    
    /**
     * This method is used to retrieve a list of the CourseGroup objects for the supplied Student and AcademicYear.
     *
     * @param student the Student object to use for the search
     * @param yearId the ID for the AcademicYear to use for the search
     * @return a List of CourseGroup objects for the Student for the specified AcademicYear
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    List<CourseGroup> findStudentCourseGroupsByYearId(Student student, Integer yearId) {
        AcademicYear year = academicYearService.findById(yearId)
        return courseGroupService.findByStudentAndYear(student, year)
    }
}
