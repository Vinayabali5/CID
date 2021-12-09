package uk.ac.reigate.services.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.learning_support.StudentSpecialCategory
import uk.ac.reigate.dto.StudentSpecialCategoryDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.learning_support.StudentSpecialCategoryRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.SpecialCategoryService
import uk.ac.reigate.services.StaffService

@Service
class StudentSpecialCategoryService implements ICoreDataService<StudentSpecialCategory, Integer>{
    
    @Autowired
    StudentSpecialCategoryRepository studentSpecialCategoryRepository
    
    @Autowired
    SpecialCategoryService specialCategoryService;
    
    @Autowired
    StaffService staffService;
    
    @Autowired
    StudentService studentService;
    
    /**
     * Default NoArgs constructor
     */
    StudentSpecialCategoryService() {}
    
    /**
     * Autowired Constructor
     *
     * @param studentSpecialCategoryRepository
     */
    StudentSpecialCategoryService(StudentSpecialCategoryRepository studentSpecialCategoryRepository, SpecialCategoryService specialCategoryService, StaffService staffService, StudentService studentService) {
        super();
        this.studentSpecialCategoryRepository = studentSpecialCategoryRepository;
        this.specialCategoryService = specialCategoryService;
        this.staffService = staffService;
        this.studentService = studentService;
    }
    
    /**
     * Find an individual studentSpecialCategory using the studentSpecialCategorys ID fields
     *
     * @param id the ID fields to search for
     * @return the StudentSpecialCategory object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    StudentSpecialCategory findById(Integer id) {
        return studentSpecialCategoryRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of StudentSpecialCategory objects
     * @return a List of StudentSpecialCategorys
     */
    @Override
    @Transactional(readOnly = true)
    List<StudentSpecialCategory> findAll() {
        return studentSpecialCategoryRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete StudentSpecialCategory object in the database
     *
     * @param studentSpecialCategory the new StudentSpecialCategory object to be saved
     * @return the saved version of the StudentSpecialCategory object
     */
    @Override
    @Transactional
    public StudentSpecialCategory save(StudentSpecialCategory studentSpecialCategory) {
        return studentSpecialCategoryRepository.save(studentSpecialCategory)
    }
    
    
    /**
     * Saves a list of StudentSpecialCategory objects to the database
     *
     * @param studentSpecialCategorys a list of StudentSpecialCategorys to be saved to the database
     * @return the list of save StudentSpecialCategory objects
     */
    @Transactional
    public List<StudentSpecialCategory> saveStudentSpecialCategorys(List<StudentSpecialCategory> studentSpecialCategories) {
        return studentSpecialCategories.collect { studentSpecialCategory -> save(studentSpecialCategory) };
    }
    
    public StudentSpecialCategory createFromDto(StudentSpecialCategoryDto studentSpecialCategoryDto) {
        if(studentSpecialCategoryDto == null) {
            throw new InvalidDataException("Cannot create studentSpecialCategoryDto from null object.")
        }
        StudentSpecialCategory studentSpecialCategory = new StudentSpecialCategory()
        if(studentSpecialCategoryDto.studentId != null) {
            studentSpecialCategory.student = studentService.findById(studentSpecialCategoryDto.studentId)
        }
        if(studentSpecialCategoryDto.specialCategoryId != null){
            studentSpecialCategory.specialCategory = specialCategoryService.findById(studentSpecialCategoryDto.specialCategoryId)
        }
        if(studentSpecialCategoryDto.staffRequestingId != null){
            studentSpecialCategory.staffRequesting = staffService.findById(studentSpecialCategoryDto.staffRequestingId)
        }
        if(studentSpecialCategoryDto.riskAssessmentToBeCompletedById != null){
            studentSpecialCategory.riskAssessmentToBeCompletedBy = staffService.findById(studentSpecialCategoryDto.riskAssessmentToBeCompletedById)
        }
        if(studentSpecialCategoryDto.staffConcernedId != null){
            studentSpecialCategory.staffConcerned = staffService.findById(studentSpecialCategoryDto.staffConcernedId)
        }
        if(studentSpecialCategoryDto.riskAssessmentRaisedById != null){
            studentSpecialCategory.riskAssessmentRaisedBy = staffService.findById(studentSpecialCategoryDto.riskAssessmentRaisedById)
        }
        if(studentSpecialCategoryDto.riskAssessmentCarriedOutById != null){
            studentSpecialCategory.riskAssessmentCarriedOutBy = staffService.findById(studentSpecialCategoryDto.riskAssessmentCarriedOutById)
        }
        studentSpecialCategory.requestDate = studentSpecialCategoryDto.requestDate
        studentSpecialCategory.specialConfirmed = studentSpecialCategoryDto.specialConfirmed
        studentSpecialCategory.classificationDate = studentSpecialCategoryDto.classificationDate
        studentSpecialCategory.closedDate = studentSpecialCategoryDto.closedDate
        studentSpecialCategory.monitoringNotes = studentSpecialCategoryDto.monitoringNotes
        studentSpecialCategory.riskAssessmentRequired = studentSpecialCategoryDto.riskAssessmentRequired
        studentSpecialCategory.informationConfidential = studentSpecialCategoryDto.informationConfidential
        studentSpecialCategory.writtenEvidence = studentSpecialCategoryDto.writtenEvidence
        studentSpecialCategory.passToStaffConcerned = studentSpecialCategoryDto.passToStaffConcerned
        studentSpecialCategory.riskToStudentOrOthers = studentSpecialCategoryDto.riskToStudentOrOthers
        studentSpecialCategory.emergencyContactNos = studentSpecialCategoryDto.emergencyContactNos
        studentSpecialCategory.outsideAgenciesInvolved = studentSpecialCategoryDto.outsideAgenciesInvolved
        studentSpecialCategory.toBeInformedPotentialRisks = studentSpecialCategoryDto.toBeInformedPotentialRisks
        studentSpecialCategory.riskAssessmentRaisedDate = studentSpecialCategoryDto.riskAssessmentRaisedDate
        studentSpecialCategory.riskAssessmentCarriedOutDate = studentSpecialCategoryDto.riskAssessmentCarriedOutDate
        studentSpecialCategory.inEventEmergency = studentSpecialCategoryDto.inEventEmergency
        return save(studentSpecialCategory)
    }
    
    public StudentSpecialCategory updateFromDto(StudentSpecialCategoryDto studentSpecialCategoryDto) {
        if(studentSpecialCategoryDto == null) {
            throw new InvalidDataException("Cannot update studentSpecialCategoryDto from null object.")
        }
        StudentSpecialCategory studentSpecialCategory = findById(studentSpecialCategoryDto.id)
        if(studentSpecialCategoryDto.studentId != null) {
            studentSpecialCategory.student = studentService.findById(studentSpecialCategoryDto.studentId)
        }
        if(studentSpecialCategoryDto.specialCategoryId != null){
            studentSpecialCategory.specialCategory = specialCategoryService.findById(studentSpecialCategoryDto.specialCategoryId)
        }
        if(studentSpecialCategoryDto.staffRequestingId != null){
            studentSpecialCategory.staffRequesting = staffService.findById(studentSpecialCategoryDto.staffRequestingId)
        }
        if(studentSpecialCategoryDto.riskAssessmentToBeCompletedById != null){
            studentSpecialCategory.riskAssessmentToBeCompletedBy = staffService.findById(studentSpecialCategoryDto.riskAssessmentToBeCompletedById)
        }
        if(studentSpecialCategoryDto.staffConcernedId != null){
            studentSpecialCategory.staffConcerned = staffService.findById(studentSpecialCategoryDto.staffConcernedId)
        }
        if(studentSpecialCategoryDto.riskAssessmentRaisedById != null){
            studentSpecialCategory.riskAssessmentRaisedBy = staffService.findById(studentSpecialCategoryDto.riskAssessmentRaisedById)
        }
        if(studentSpecialCategoryDto.riskAssessmentCarriedOutById != null){
            studentSpecialCategory.riskAssessmentCarriedOutBy = staffService.findById(studentSpecialCategoryDto.riskAssessmentCarriedOutById)
        }
        studentSpecialCategory.requestDate = studentSpecialCategoryDto.requestDate
        studentSpecialCategory.specialConfirmed = studentSpecialCategoryDto.specialConfirmed
        studentSpecialCategory.classificationDate = studentSpecialCategoryDto.classificationDate
        studentSpecialCategory.closedDate = studentSpecialCategoryDto.closedDate
        studentSpecialCategory.monitoringNotes = studentSpecialCategoryDto.monitoringNotes
        studentSpecialCategory.riskAssessmentRequired = studentSpecialCategoryDto.riskAssessmentRequired
        studentSpecialCategory.informationConfidential = studentSpecialCategoryDto.informationConfidential
        studentSpecialCategory.writtenEvidence = studentSpecialCategoryDto.writtenEvidence
        studentSpecialCategory.passToStaffConcerned = studentSpecialCategoryDto.passToStaffConcerned
        studentSpecialCategory.riskToStudentOrOthers = studentSpecialCategoryDto.riskToStudentOrOthers
        studentSpecialCategory.emergencyContactNos = studentSpecialCategoryDto.emergencyContactNos
        studentSpecialCategory.outsideAgenciesInvolved = studentSpecialCategoryDto.outsideAgenciesInvolved
        studentSpecialCategory.toBeInformedPotentialRisks = studentSpecialCategoryDto.toBeInformedPotentialRisks
        studentSpecialCategory.riskAssessmentRaisedDate = studentSpecialCategoryDto.riskAssessmentRaisedDate
        studentSpecialCategory.riskAssessmentCarriedOutDate = studentSpecialCategoryDto.riskAssessmentCarriedOutDate
        studentSpecialCategory.inEventEmergency = studentSpecialCategoryDto.inEventEmergency
        return save(studentSpecialCategory)
    }
    /**
     * @param studentId
     * @return
     */
    public  List<StudentSpecialCategory> getByStudent(Integer studentId){
        return studentSpecialCategoryRepository.findByStudent_Id(studentId);
    }
    
    /**
     * This methods throws an InvalidOperationException when called. StudentSpecialCategory should not be deleted.
     */
    @Override
    public void delete(StudentSpecialCategory obj) {
        throw new InvalidOperationException("StudentSpecialCategory should not be deleted")
    }
}
