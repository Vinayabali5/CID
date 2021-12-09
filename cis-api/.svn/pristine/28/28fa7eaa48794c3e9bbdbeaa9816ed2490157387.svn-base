package uk.ac.reigate.services.enrolments

import java.text.SimpleDateFormat

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.Enrolment
import uk.ac.reigate.domain.academic.PreReference
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.dto.EnrolmentDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.mappers.WorkingCombinationsMapper
import uk.ac.reigate.model.allocation.WorkingCombination
import uk.ac.reigate.model.enrolment.EnrolmentProgrammeChange
import uk.ac.reigate.repositories.academic.EnrolmentRepository
import uk.ac.reigate.services.AcademicYearService;
import uk.ac.reigate.services.CentralMonitoringService
import uk.ac.reigate.services.CourseGroupService;
import uk.ac.reigate.services.CourseService
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.PreReferenceService
import uk.ac.reigate.services.ilr.AimTypeService
import uk.ac.reigate.services.ilr.CompletionStatusService
import uk.ac.reigate.services.ilr.FundingModelService
import uk.ac.reigate.services.ilr.OutcomeService
import uk.ac.reigate.services.ilr.SourceOfFundingService
import uk.ac.reigate.services.ilr.WithdrawalReasonService
import uk.ac.reigate.services.student.StudentService

@Service
class EnrolmentService implements ICoreDataService<Enrolment, Integer>{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EnrolmentService.class);
    
    @Autowired
    JdbcTemplate jdbcTemplate
    
    @Autowired
    private final AcademicYearService academicYearService;
    
    @Autowired
    private final CourseGroupService courseGroupService;
    
    @Autowired
    private final CourseService courseService;
    
    @Autowired
    private final OutcomeService outcomeService;
    
    @Autowired
    private final FundingModelService fundingModelService;
    
    @Autowired
    private final SourceOfFundingService sourceOfFundingService;
    
    @Autowired
    private final AimTypeService aimTypeService;
    
    @Autowired
    private final WithdrawalReasonService withdrawalReasonService;
    
    @Autowired
    private final StudentService studentService;
    
    @Autowired
    private final CompletionStatusService completionStatusService;
    
    @Autowired
    private final CentralMonitoringService centralMonitoringService;
    
    @Autowired
    EnrolmentRepository enrolmentRepository
    
    private final SimpleDateFormat sqlDate = new SimpleDateFormat("yyyyMMdd");
    
    @Autowired
    PreReferenceService preReferenceService
    
    /**
     * Default NoArgs constructor
     */
    EnrolmentService() {}
    
    /**
     * Autowired Constructor
     * 
     * @param enrolmentRepository 
     */
    EnrolmentService(EnrolmentRepository enrolmentRepository, AcademicYearService academicYearService, CourseGroupService courseGroupService, CourseService courseService, OutcomeService outcomeService, FundingModelService fundingModelService, SourceOfFundingService sourceOfFundingService,
    AimTypeService aimTypeService, WithdrawalReasonService withdrawalReasonService, StudentService studentService, CompletionStatusService completionStatusService, CentralMonitoringService centralMonitoringService) {
        super();
        this.enrolmentRepository = enrolmentRepository;
        this.academicYearService = academicYearService;
        this.courseGroupService = courseGroupService;
        this.courseService = courseService;
        this.outcomeService = outcomeService;
        this.fundingModelService = fundingModelService;
        this.sourceOfFundingService = sourceOfFundingService;
        this.aimTypeService = aimTypeService;
        this.withdrawalReasonService = withdrawalReasonService;
        this.studentService = studentService;
        this.completionStatusService = completionStatusService;
        this.centralMonitoringService = centralMonitoringService;
    }
    
    /**
     * This service method is used to retrieve an individual Enrolment object from the database.
     * 
     * @param id the id of the Enrolment object to retrieve
     * @return the Enrolment object identified by the id
     */
    @Override
    @Transactional(readOnly = true)
    Enrolment findById(Integer id) {
        return enrolmentRepository.findById(id).orElse(null)
    }
    
    /**
     * This service method is used to retrieve all instances of the Enrolment object from the database.
     * 
     * @return A List of Enrolment objects
     */
    @Override
    @Transactional(readOnly = true)
    List<Enrolment> findAll() {
        return enrolmentRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Enrolment object in the database
     * 
     * @param enrolment the new Enrolment object to be saved
     * @return the saved version of the Enrolment object
     */
    @Override
    @Transactional
    public Enrolment save(Enrolment enrolment) {
        return enrolmentRepository.save(enrolment)
    }
    
    /**
     * This service method is used to save a list of complete Enrolment objects to the database. 
     * 
     * @param enrolments a list of Enrolment objects to persist to the database
     * @return the saved version of the list of Enrolment objects
     */
    @Transactional
    public List<Enrolment> saveEnrolments(List<Enrolment> enrolments) {
        return enrolments.collect { enrolment -> save(enrolment) };
    }
    
    /**
     * This Service is used to retrieve the enrolment data by course
     * 
     * @param course
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List <Enrolment> findByCourse(Course course) {
        return enrolmentRepository.findByCourse(course)
    }
    
    /**
     * This service method is used to retireve the enrolments for a specified student and year combination.
     * 
     * @param student The Student object to use for the search
     * @param year The AcademicYear object to use for the search
     * @return A List of Enrolment objects for the specified student and year
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<Enrolment> findByStudentAndYear(Student student, AcademicYear year) {
        return enrolmentRepository.findByStudentAndYear(student, year);
    }
    
    /**
     * @param studentId
     * @param yearId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<Enrolment> findByStudentAndYearId(Integer studentId, Integer yearId){
        // return enrolmentRepository.findByStudent_IdAndYear_Id(studentId, yearId)
        List<Enrolment> list = enrolmentRepository.findByStudent_IdAndYear_Id(studentId, yearId)
        list.each { it ->
            PreReference preReference = preReferenceService.findByStudentIdAndCourseId(it.student.id, it.course.id)
            it.reference = preReference
        }
    }
    
    /**
     * @param studentId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<Enrolment> findByStudentId(Integer studentId){
        // return enrolmentRepository.findByStudent_Id(studentId)
        List<Enrolment> list = enrolmentRepository.findByStudent_Id(studentId)
        list.each { it ->
            PreReference preReference = preReferenceService.findByStudentIdAndCourseId(it.student.id, it.course.id)
            it.reference = preReference
        }
    }
    
    /**
     * This Service is used to retrieve the enrolment data by courseGroup
     * 
     * @param courseGroup
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List <Enrolment> findByCourseGroup(Integer courseGroupId) {
        List <Enrolment> enrolment = enrolmentRepository.findByCourseGroup_Id(courseGroupId)
    }
    
    /**
     * @param courseGroupId
     * @param year
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List <Enrolment> findByCourseGroupAndYear(Integer courseGroupId, AcademicYear year) {
        List <Enrolment> enrolment = enrolmentRepository.findByCourseGroup_IdAndYear(courseGroupId, year)
    }
    
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List <Enrolment> findCurrentCourseGroupAndYear(Integer courseGroupId, Integer yearId) {
        List <Enrolment> enrolment = enrolmentRepository.findByCurrentCourseGroup_IdAndYear(courseGroupId, yearId)
    }
    
    /**
     * This Service is used to retrieve the enrolment data by courseGroup
     *
     * @param courseGroup
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List <Enrolment> findCurrentCourseGroup(Integer courseGroupId) {
        List <Enrolment> enrolment = enrolmentRepository.findByCurrentCourseGroup_Id(courseGroupId)
    }
    
    /**
     * @param courseGroupId
     * @param year
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List <Enrolment> findCurrentCourseGroupAndYear(Integer courseGroupId, AcademicYear year) {
        List <Enrolment> enrolment = enrolmentRepository.findByCourseGroup_IdAndYear(courseGroupId, year)
    }
    
    /**
     * @param courseId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List <Enrolment> findByCourseId(Integer courseId) {
        List <Enrolment> enrolment = enrolmentRepository.findByCourse_Id(courseId)
    }
    
    /**
     * @param courseId
     * @param year
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List <Enrolment> findByCourseAndYear(Integer courseId, AcademicYear year) {
        List <Enrolment> enrolment = enrolmentRepository.findByCourse_IdAndYear(courseId, year)
    }
    
    /**
     * @param year
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List <Enrolment> findByYearId(Integer yearId) {
        List <Enrolment> enrolment = enrolmentRepository.findByYear_Id(yearId)
    }
    
    /**
     * This service method is used to create an Enrolment object in the database from a partial or complete Enrolment object.
     *
     * @param enrolment the partial or complete Enrolment object to be saved
     * @return the saved version of the Enrolment object
     */
    @Transactional
    public Enrolment createFromDto(EnrolmentDto enrolmentDto) {
        Enrolment enrolment = new Enrolment()
        if (enrolmentDto.studentId != null) {
            enrolment.student = studentService.findById(enrolmentDto.studentId)
        }
        if (enrolmentDto.yearId != null){
            enrolment.year = academicYearService.findById(enrolmentDto.yearId)
        }
        if (enrolmentDto.courseId != null){
            enrolment.course = courseService.findById(enrolmentDto.courseId)
        }
        if (enrolmentDto.courseGroupId != null){
            enrolment.courseGroup = courseGroupService.findById(enrolmentDto.courseGroupId)
        }
        enrolment.startDate = enrolmentDto.startDate
        enrolment.startDate = enrolmentDto.startDate
        enrolment.endDate = enrolmentDto.endDate
        enrolment.qualificationStartDate = enrolmentDto.qualificationStartDate
        enrolment.plannedEndDate = enrolmentDto.plannedEndDate
        if (enrolmentDto.aimTypeId != null){
            enrolment.aimType = aimTypeService.findById(enrolmentDto.aimTypeId)
        }
        if (enrolmentDto.completionStatusId != null){
            enrolment.completionStatus = completionStatusService.findById(enrolmentDto.completionStatusId)
        }
        if (enrolmentDto.outcomeId != null){
            enrolment.outcome = outcomeService.findById(enrolmentDto.outcomeId)
        }
        if (enrolmentDto.withdrawalReasonId != null){
            enrolment.withdrawalReason = withdrawalReasonService.findById(enrolmentDto.withdrawalReasonId)
        }
        if (enrolmentDto.centralMonitoringId != null){
            enrolment.centralMonitoring = centralMonitoringService.findById(enrolmentDto.centralMonitoringId)
        }
        if (enrolmentDto.grade == null || enrolmentDto.grade == "") {
            enrolment.grade = null
        } else {
            enrolment.grade = enrolmentDto.grade
        }
        enrolment.ilr = enrolmentDto.ilr
        enrolment.plh = enrolmentDto.plh
        enrolment.peeph = enrolmentDto.peeph
        if (enrolmentDto.fundingModelId != null){
            enrolment.fundingModel = fundingModelService.findById(enrolmentDto.fundingModelId)
        }
        if (enrolmentDto.sourceOfFundingId != null){
            enrolment.sourceOfFunding = sourceOfFundingService.findById(enrolmentDto.sourceOfFundingId)
        }
        enrolment.notes = enrolmentDto.notes
        enrolment.learningAimReferenceOverride = enrolmentDto.learningAimReferenceOverride
        return save(enrolment)
    }
    
    /**
     * This service method is used to update an Enrolment object in the database from a partial or complete Enrolment object.
     *
     * @param enrolment the partial or complete Enrolment object to be saved
     * @return the saved version of the Enrolment object
     */
    @Transactional
    public Enrolment updateFromDto(EnrolmentDto enrolmentDto) {
        if (enrolmentDto.enrolmentId == null) {
            throw new InvalidDataException("enrolment ID should not be null when updating")
        }
        Enrolment enrolment = findById(enrolmentDto.enrolmentId)
        if (enrolmentDto.studentId != null) {
            enrolment.student = studentService.findById(enrolmentDto.studentId)
        }
        if (enrolmentDto.yearId != null){
            enrolment.year = academicYearService.findById(enrolmentDto.yearId)
        }
        if (enrolmentDto.courseId != null){
            enrolment.course = courseService.findById(enrolmentDto.courseId)
        }
        if (enrolmentDto.courseGroupId != null){
            enrolment.courseGroup = courseGroupService.findById(enrolmentDto.courseGroupId)
        }
        enrolment.startDate = enrolmentDto.startDate
        enrolment.startDate = enrolmentDto.startDate
        enrolment.endDate = enrolmentDto.endDate
        enrolment.qualificationStartDate = enrolmentDto.qualificationStartDate
        enrolment.plannedEndDate = enrolmentDto.plannedEndDate
        if (enrolmentDto.aimTypeId != null){
            enrolment.aimType = aimTypeService.findById(enrolmentDto.aimTypeId)
        }
        if (enrolmentDto.completionStatusId != null){
            enrolment.completionStatus = completionStatusService.findById(enrolmentDto.completionStatusId)
        }
        if (enrolmentDto.outcomeId != null){
            enrolment.outcome = outcomeService.findById(enrolmentDto.outcomeId)
        }
        if (enrolmentDto.withdrawalReasonId != null){
            enrolment.withdrawalReason = withdrawalReasonService.findById(enrolmentDto.withdrawalReasonId)
        } else {
            enrolment.withdrawalReason = null
        }
        if (enrolmentDto.centralMonitoringId != null){
            enrolment.centralMonitoring = centralMonitoringService.findById(enrolmentDto.centralMonitoringId)
        }
        if (enrolmentDto.grade == null || enrolmentDto.grade == "") {
            enrolment.grade = null
        } else {
            enrolment.grade = enrolmentDto.grade
        }
        enrolment.ilr = enrolmentDto.ilr
        enrolment.plh = enrolmentDto.plh
        enrolment.peeph = enrolmentDto.peeph
        if (enrolmentDto.fundingModelId != null){
            enrolment.fundingModel = fundingModelService.findById(enrolmentDto.fundingModelId)
        }
        if (enrolmentDto.sourceOfFundingId != null){
            enrolment.sourceOfFunding = sourceOfFundingService.findById(enrolmentDto.sourceOfFundingId)
        }
        enrolment.notes = enrolmentDto.notes
        enrolment.learningAimReferenceOverride = enrolmentDto.learningAimReferenceOverride
        return save(enrolment)
    }
    
    /**
     * This service method is used to retrieve a list of working combinations based on a comma separated list
     * of course specs. 
     * 
     * @param specs a array of string that contain the specification codes for the course combination to check
     * @return a list of possible working combinations
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    List<WorkingCombination> findWorkingCombinations(String[] specs) {
        String requestList = specs.toString();
        def sql = "EXEC [Allocation].[FindWorkingCombinationsFromList] @request_set = " + requestList + ", @separator = ','";
        List<WorkingCombination> list = jdbcTemplate.query(sql, new WorkingCombinationsMapper());
        return list;
    }
    
    /**
     * This service method is used to retrieve a list of working combinations based on a comma separated list
     * of course specs for a given date. 
     * 
     * @param specs a array of string that contain the specification codes for the course combination to check
     * @param date a date on which to check the validity of the programme
     * @return a list of possible working combinations
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    List<WorkingCombination> findWorkingCombinationsOnDate(String[] specs, Date date) {
        String requestList = specs.toString();
        def sql = "EXEC [Allocation].[FindWorkingCombinationsFromList] @request_set = " + requestList + ", @separator = ',', @ref_date='" + sqlDate.format(date) + "'";
        List<WorkingCombination> list = jdbcTemplate.query(sql, new WorkingCombinationsMapper());
        return list;
    }
    
    /**
     * This method is used to perform an entire programme change for a given student. 
     * 
     * @param EnrolmentProgrammeChange 
     */
    @PreAuthorize("@securityChecker.checkEnrolmentsReadWrite(authentication)")
    @Transactional
    Boolean changeProgramme(EnrolmentProgrammeChange programmeChange) {
        if (programmeChange && programmeChange.studentId != null && programmeChange.courseGroups.size() > 0) {
            String courseGroupIdList = programmeChange.courseGroups.collect { it.courseGroupId }.join(',');
            String dateString = sqlDate.format(programmeChange.changeDate);
            if (programmeChange.academicYearId == null) {
                AcademicYear year = academicYearService.findByDate(programmeChange.changeDate)
                if (year != null) {
                    programmeChange.academicYearId = year.id
                } else {
                    programmeChange.academicYearId = academicYearService.getCurrentAcademicYear().id
                }
            }
            String sql = "EXEC [EnrolmentManagement].[ProcessProgrammeChange] @StudentId = $programmeChange.studentId, @AcademicYearId = $programmeChange.academicYearId, @ChangeDate = '$dateString', @NewEnrolments = '$courseGroupIdList', @PerformChange = 1";
            LOGGER.info("II EnrolmentService - execute SQL: $sql");
            try {
                jdbcTemplate.execute(sql);
            } catch (DataAccessException dae) {
                LOGGER.error("EE EnrolmentService - Error Processing Enrolment Programme Change: $sql");
                LOGGER.error(dae.getMessage());
                LOGGER.error(dae.getMostSpecificCause());
                return new Boolean(false);
            } catch (Exception e) {
                LOGGER.error("EE EnrolmentService - Error Processing Enrolment Programme Change: $sql");
                LOGGER.error(e.message);
                return new Boolean(false);
            }
            return new Boolean(true);
        }
    }
    
    @Override
    public void delete(Enrolment obj) {
        throw new InvalidOperationException("Enolrment should not be deleted")
    }
}
