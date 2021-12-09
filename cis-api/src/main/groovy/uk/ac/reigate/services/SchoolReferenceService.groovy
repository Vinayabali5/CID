package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.SchoolReference
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.SchoolReferenceRepository

@Service
class SchoolReferenceService implements ICoreDataService<SchoolReference, Integer>{
    
    @Autowired
    SchoolReferenceRepository schoolReferenceRepository
    
    /**
     * Default NoArgs constructor
     */
    SchoolReferenceService() {}
    
    /**
     * Autowired Constructor
     *
     * @param schoolReferenceRepository
     */
    SchoolReferenceService(SchoolReferenceRepository schoolReferenceRepository) {
        this.schoolReferenceRepository = schoolReferenceRepository
    }
    
    /**
     * Find an individual schoolReference using the schoolReferences ID fields
     *
     * @param id the ID fields to search for
     * @return the SchoolReference object that matches the ID supplied, or null if not found
     */
    @Transactional(readOnly = true)
    SchoolReference findSchoolReference(Integer studentId) {
        return schoolReferenceRepository.findByStudentId(studentId);
    }
    
    /**
     * Find a single page of SchoolReference objects
     * @return a SearchResult set with the list of SchoolReferences
     */
    @Transactional(readOnly = true)
    List<SchoolReference> findAll() {
        return schoolReferenceRepository.findAll();
    }
    
    /**
     * This method is used to reterieve the SchoolReference by Id.
     */
    @Override
    public SchoolReference findById(Integer id) {
        return schoolReferenceRepository.findById(id).orElse(null)
    }
    
    /**
     * This method is used to save the SchoolReference to the database.
     */
    @Override
    public SchoolReference save(SchoolReference obj) {
        return schoolReferenceRepository.save(obj)
    }
    
    /**
     * This method is used to delete the SchoolReference from the database.
     */
    @Override
    public void delete(SchoolReference obj) {
        throw new InvalidOperationException("SchoolReference should not be deleted")
    }
}
