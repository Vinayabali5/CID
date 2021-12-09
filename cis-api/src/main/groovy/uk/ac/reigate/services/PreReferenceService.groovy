package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.PreReference
import uk.ac.reigate.dto.PreReferenceDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.PreReferenceRepository
import uk.ac.reigate.services.lookup.PossibleGradeSetService

@Service
class PreReferenceService  {
    
    @Autowired
    PreReferenceRepository preReferenceRepository
    
    /**
     * Default NoArgs constructor
     */
    PreReferenceService() {}
    
    /**
     * Autowired Constructor
     *
     * @param preReferenceRepository
     */
    PreReferenceService(PreReferenceRepository preReferenceRepository) {
        this.preReferenceRepository = preReferenceRepository;
    }
    
    /**
     * Find an individual preReference using the preReferences ID fields
     *
     * @param id the ID fields to search for
     * @return the PreReference object that matches the ID supplied, or null if not found
     */
    @Transactional(readOnly = true)
    PreReference findByStudentIdAndCourseId(Integer studentId, Integer courseId) {
        return preReferenceRepository.findByStudentIdAndCourseId(studentId, courseId)
    }
}
