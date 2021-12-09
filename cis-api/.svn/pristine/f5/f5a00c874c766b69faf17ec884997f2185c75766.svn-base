package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.ilp.Correspondence
import uk.ac.reigate.dto.CorrespondenceDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.StudentRepository
import uk.ac.reigate.repositories.ilp.CorrespondenceRepository
import uk.ac.reigate.repositories.register.AttendanceCodeRepository
import uk.ac.reigate.services.ilp.LetterService
import uk.ac.reigate.services.student.StudentService

@Service
class CorrespondenceService implements ICoreDataService<Correspondence, Integer>, IDtoCreateUpdateService<CorrespondenceDto, Correspondence>{
    
    @Autowired
    CorrespondenceRepository correspondenceRepository
    
    @Autowired
    StudentService studentService;
    
    @Autowired
    CourseGroupService courseGroupService;
    
    @Autowired
    LetterService letterService;
    
    @Autowired
    CorrespondenceTypeService correspondenceTypeService;
    
    
    /**
     * Default NoArgs constructor
     */
    CorrespondenceService() {}
    
    /**
     * Autowired Constructor
     *
     * @param correspondenceRepository
     */
    CorrespondenceService(CorrespondenceRepository correspondenceRepository, StudentService studentService, CourseGroupService courseGroupService, LetterService letterService, CorrespondenceTypeService correspondenceTypeService) {
        super();
        this.correspondenceRepository = correspondenceRepository;
        this.studentService = studentService
        this.courseGroupService = courseGroupService
        this.letterService = letterService
        this.correspondenceTypeService = correspondenceTypeService
    }
    
    /**
     * Find an individual contactType using the Correspondence ID fields
     *
     * @param id the ID fields to search for
     * @return the Correspondence object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Correspondence findById(Integer id) {
        return correspondenceRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of Correspondence objects
     * @return a List of Correspondences
     */
    @Override
    @Transactional(readOnly = true)
    List<Correspondence> findAll() {
        return correspondenceRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Correspondence object in the database
     *
     * @param correspondence the new Correspondence object to be saved
     * @return the saved version of the Correspondence object
     */
    @Override
    @Transactional
    public Correspondence save(Correspondence correspondence) {
        return correspondenceRepository.save(correspondence)
    }
    
    /**
     * This service method is used to create an Correspondence object in the database from a partial or complete Correspondence object.
     *
     * @param correspondence the partial or complete Correspondence object to be saved
     * @return the saved version of the Correspondence object
     */
    @Transactional
    public Correspondence createFromDto(CorrespondenceDto correspondenceDto) {
        if(correspondenceDto == null ) {
            throw new InvalidDataException("Cannot create Correspondence from null object.")
        }
        Correspondence correspondence = new Correspondence()
        if(correspondenceDto.studentId != null) {
            correspondence.student = studentService.findById(correspondenceDto.studentId)
        }
        correspondence.correspondence = correspondenceDto.correspondence
        if(correspondenceDto.courseId != null) {
            correspondence.course = courseGroupService.findById(correspondenceDto.courseId)
        }
        correspondence.date = correspondenceDto.date
        correspondence.from = correspondenceDto.from
        correspondence.to = correspondenceDto.to
        if(correspondenceDto.letterId != null) {
            correspondence.letter = letterService.findById(correspondenceDto.letterId)
        }
        correspondence.staffAdvised = correspondenceDto.staffAdvised
        if(correspondenceDto.typeId != null) {
            correspondence.type = correspondenceTypeService.findById(correspondenceDto.typeId)
        }
        correspondence.producedBy = correspondenceDto.producedBy
        correspondence.privateEntry = correspondenceDto.privateEntry
        correspondence.processStage = correspondenceDto.processStage
        correspondence.attachmentsSent = correspondenceDto.attachmentsSent
        return correspondenceRepository.save(correspondence)
    }
    
    /**
     * This service method is used to update an Correspondence object in the database from a partial or complete Correspondence object.
     *
     * @param correspondence the partial or complete Correspondence object to be saved
     * @return the saved version of the Correspondence object
     */
    @Transactional
    public Correspondence updateFromDto(CorrespondenceDto correspondenceDto) {
        if(correspondenceDto == null ) {
            throw new InvalidDataException("Cannot create Correspondence from null object.")
        }
        Correspondence correspondence = findById(correspondenceDto.id)
        if(correspondenceDto.studentId != null) {
            correspondence.student = studentService.findById(correspondenceDto.studentId)
        }
        correspondence.correspondence = correspondenceDto.correspondence
        if(correspondenceDto.courseId != null) {
            correspondence.course = courseGroupService.findById(correspondenceDto.courseId)
        }
        correspondence.date = correspondenceDto.date
        correspondence.from = correspondenceDto.from
        correspondence.to = correspondenceDto.to
        if(correspondenceDto.letterId != null) {
            correspondence.letter = letterService.findById(correspondenceDto.letterId)
        }
        correspondence.staffAdvised = correspondenceDto.staffAdvised
        if(correspondenceDto.typeId != null) {
            correspondence.type = correspondenceTypeService.findById(correspondenceDto.typeId)
        }
        correspondence.producedBy = correspondenceDto.producedBy
        correspondence.privateEntry = correspondenceDto.privateEntry
        correspondence.processStage = correspondenceDto.processStage
        correspondence.attachmentsSent = correspondenceDto.attachmentsSent
        return correspondenceRepository.save(correspondence)
    }
    /**
     * Saves a list of Correspondence objects to the database
     *
     * @param correspondences a list of Correspondences to be saved to the database
     * @return the list of save Correspondence objects
     */
    @Transactional
    public List<Correspondence> saveCorrespondences(List<Correspondence> correspondences) {
        return correspondences.collect { correspondence -> save(correspondence) };
    }
    
    /**
     * @param studentId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public  List<Correspondence> getByStudent(Integer studentId){
        return correspondenceRepository.findByStudent_Id(studentId);
    }
    
    /**
     * @param studentId
     * @param correspondanceId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public  Correspondence getByStudentAndCorrespondence(Integer studentId, Integer correspondanceId){
        return correspondenceRepository.findByStudent_IdAndId(studentId, correspondanceId);
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Correspondence should not be deleted.
     */
    @Override
    public void delete(Correspondence obj) {
        throw new InvalidOperationException("Correspondence Objects should not be deleted")
    }
}
