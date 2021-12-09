package uk.ac.reigate.services

//import static org.springframework.util.Assert

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import lombok.RequiredArgsConstructor
import uk.ac.reigate.domain.academic.ExternalResultsArchive
import uk.ac.reigate.dto.ExternalResultsArchiveDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.ExternalResultsArchiveRepository
import uk.ac.reigate.repositories.academic.StudentRepository
import uk.ac.reigate.services.student.StudentService

@Service
@RequiredArgsConstructor
class ExternalResultsArchiveService implements ICoreDataService<ExternalResultsArchive, Integer>, IDtoCreateUpdateService<ExternalResultsArchiveDto, ExternalResultsArchive>{
    
    @Autowired
    ExternalResultsArchiveRepository externalResultsArchiveRepository
    
    @Autowired
    private final StudentService studentService
    
    
    /**
     * Default NoArgs constructor
     */
    ExternalResultsArchiveService() {}
    
    /**
     * Autowired Constructor
     *
     * @param externalResultsArchiveRepository
     */
    ExternalResultsArchiveService(ExternalResultsArchiveRepository externalResultsArchiveRepository, StudentService studentService) {
        super();
        this.externalResultsArchiveRepository = externalResultsArchiveRepository;
        this.studentService = studentService;
    }
    /**
     * Find an individual ExternalResultsArchive using the ExternalResultsArchive ID fields
     *
     * @param id the ID fields to search for
     * @return the ExternalResultsArchive object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    ExternalResultsArchive findById(Integer id) {
        return externalResultsArchiveRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all ExternalResultsArchive
     *
     * @return a List of ExternalResultsArchive
     */
    @Override
    @Transactional(readOnly = true)
    List<ExternalResultsArchive> findAll() {
        return externalResultsArchiveRepository.findAll();
    }
    
    /**
     * This method is used to retrieve the student entry qualifications that a specific studentId and externalResultsArchiveId
     * @param studentId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public  ExternalResultsArchive getByExternalResultsArchives(Integer studentId, Integer externalResultId){
        return externalResultsArchiveRepository.findByStudent_IdAndId(studentId, externalResultId);
    }
    
    /**
     * This method is used to retrieve the list of student entry qualifications that a specific studentId
     * @param studentId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public  List<ExternalResultsArchive> getByStudent(Integer studentId){
        return externalResultsArchiveRepository.findByStudent_Id(studentId);
    }
    
    /**
     * This service method is used to create an ExternalResultsArchive object in the database from a partial or complete ExternalResultsArchive object.
     *
     * @param externalResultsArchive the partial or complete ExternalResultsArchive object to be saved
     * @return the saved version of the BursaryType object
     */
    @Transactional
    public ExternalResultsArchive updateFromDto(ExternalResultsArchiveDto externalResultsArchiveDto) {
        if (externalResultsArchiveDto == null) {
            throw new InvalidDataException("Cannot update externalResultsArchiveDto from null object.")
        }
        ExternalResultsArchive externalResultsArchive = findById(externalResultsArchiveDto.id)
        if (externalResultsArchiveDto.studentId != null) {
            externalResultsArchive.student= studentService.findById(externalResultsArchiveDto.studentId)
        }
        externalResultsArchive.courseSpec = externalResultsArchiveDto.courseSpec;
        externalResultsArchive.levelDescription = externalResultsArchiveDto.levelDescription;
        externalResultsArchive.subjectDescription = externalResultsArchiveDto.subjectDescription;
        externalResultsArchive.syllabus = externalResultsArchiveDto.syllabus;
        externalResultsArchive.grade = externalResultsArchiveDto.grade;
        externalResultsArchive.mark = externalResultsArchiveDto.mark;
        externalResultsArchive.maxMark = externalResultsArchiveDto.maxMark;
        externalResultsArchive.dateAchieved = externalResultsArchiveDto.dateAchieved;
        externalResultsArchive.series = externalResultsArchiveDto.series;
        externalResultsArchive.year = externalResultsArchiveDto.year;
        externalResultsArchive.examType = externalResultsArchiveDto.examType;
        return save(externalResultsArchive)
    }
    
    /**
     * This service method is used to create an ExternalResultsArchive object in the database from a partial or complete ExternalResultsArchive object.
     *
     * @param externalResultsArchive the partial or complete ExternalResultsArchive object to be saved
     * @return the saved version of the BursaryType object
     */
    @Transactional
    public ExternalResultsArchive createFromDto(ExternalResultsArchiveDto externalResultsArchiveDto) {
        if (externalResultsArchiveDto == null) {
            throw new InvalidDataException("Cannot create externalResultsArchiveDto from null object.")
        }
        ExternalResultsArchive externalResultsArchive = new ExternalResultsArchive()
        if (externalResultsArchiveDto.studentId != null) {
            externalResultsArchive.student= studentService.findById(externalResultsArchiveDto.studentId)
        }
        externalResultsArchive.courseSpec = externalResultsArchiveDto.courseSpec;
        externalResultsArchive.levelDescription = externalResultsArchiveDto.levelDescription;
        externalResultsArchive.subjectDescription = externalResultsArchiveDto.subjectDescription;
        externalResultsArchive.syllabus = externalResultsArchiveDto.syllabus;
        externalResultsArchive.grade = externalResultsArchiveDto.grade;
        externalResultsArchive.mark = externalResultsArchiveDto.mark;
        externalResultsArchive.maxMark = externalResultsArchiveDto.maxMark;
        externalResultsArchive.dateAchieved = externalResultsArchiveDto.dateAchieved;
        externalResultsArchive.series = externalResultsArchiveDto.series;
        externalResultsArchive.year = externalResultsArchiveDto.year;
        externalResultsArchive.examType = externalResultsArchiveDto.examType;
        return save(externalResultsArchive)
    }
    
    @Override
    public ExternalResultsArchive save(ExternalResultsArchive externalResultsArchive) {
        return externalResultsArchiveRepository.save(externalResultsArchive)
    }
    
    /**
     * This methods throws an InvalidOperationException when called. ExternalResultsArchive should not be deleted.
     */
    @Override
    public void delete(ExternalResultsArchive obj) {
        throw new InvalidOperationException("ExternalResultsArchive should not be deleted")
    }
    
    
}
