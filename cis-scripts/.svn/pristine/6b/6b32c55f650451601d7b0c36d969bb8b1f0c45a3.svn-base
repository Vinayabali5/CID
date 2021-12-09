package uk.ac.reigate.services.schoolimport

//import static org.springframework.util.Assert

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.StudentType
import uk.ac.reigate.model.PageInfo
import uk.ac.reigate.model.SearchResult
import uk.ac.reigate.repositories.lookup.StudentTypeRepository
import uk.ac.reigate.utils.ValidationUtils;

@Service
class StudentTypeService {
    
    @Autowired
    StudentTypeRepository studentTypeRepository
    
    /**
     * Default NoArgs constructor
     */
    StudentTypeService() {}
    
    /**
     * Autowired Constructor
     *
     * @param studentTypeRepository
     */
    StudentTypeService(StudentTypeRepository studentTypeRepository) {
        this.studentTypeRepository = studentTypeRepository;
    }
    
    /**
     * Find an individual studentType using the studentTypes ID fields
     *
     * @param id the ID fields to search for
     * @return the StudentType object that matches the ID supplied, or null if not found
     */
    @Transactional(readOnly = true)
    StudentType findStudentType(Integer id) {
        return studentTypeRepository.findOne(id);
    }
    
    /**
     * Find a single page of StudentType objects
     * @return a SearchResult set with the list of StudentTypes
     */
    @Transactional(readOnly = true)
    SearchResult<StudentType> findStudentTypes() {
        List<StudentType> studentTypes = studentTypeRepository.findAll();
        int resultsCount = studentTypes.size()
        return new SearchResult<>(resultsCount, studentTypes);
    }
    
    @Transactional
    public StudentType saveStudentType(Integer id, String code, String description) {
        ValidationUtils.assertNotBlank(code, "code cannot be blank");
        ValidationUtils.assertNotNull(description, "description is mandatory");
        
        StudentType studentType = null;
        
        if (id != null) {
            studentType = studentTypeRepository.findOne(id);
            
            studentType.setCode(code);
            studentType.setDescription(description);
            
            studentTypeRepository.save(studentType);
        } else {
            studentType = studentTypeRepository.save(new StudentType(code, description));
        }
        
        return studentType;
    }
    
    /**
     * This service method is used to save a complete StudentType object in the database
     *
     * @param studentType the new StudentType object to be saved
     * @return the saved version of the StudentType object
     */
    @Transactional
    public StudentType saveStudentType(StudentType studentType) {
        return studentTypeRepository.save(studentType)
    }
    
    /**
     * This service method is used to update an StudentType object in the database from a partial or complete StudentType object.
     *
     * @param studentType the partial or complete StudentType object to be saved
     * @return the saved version of the StudentType object
     */
    @Transactional
    public StudentType updateStudentType(StudentType studentType) {
        StudentType studentTypeToSave = studentTypeRepository.findOne(studentType.id)
        studentTypeToSave.code = studentType.code != null ? studentType.code : studentTypeToSave.code
        studentTypeToSave.description = studentType.description != null ? studentType.description : studentTypeToSave.description
        return studentTypeRepository.save(studentTypeToSave)
    }
    
    /**
     * Saves a list of StudentType objects to the database
     *
     * @param studentTypes a list of StudentTypes to be saved to the database
     * @return the list of save StudentType objects
     */
    @Transactional
    public List<StudentType> saveStudentTypes(List<StudentType> studentTypes) {
        return studentTypes.collect { studentType -> saveStudentType(studentType) };
    }
    
    
    
}
