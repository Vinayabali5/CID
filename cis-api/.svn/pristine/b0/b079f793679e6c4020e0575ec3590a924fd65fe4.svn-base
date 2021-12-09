package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.SimilarNamedStudent
import uk.ac.reigate.repositories.academic.SimilarNamedStudentRepository

@Service
class SimilarNamedStudentService  {
    
    @Autowired
    SimilarNamedStudentRepository similarNamedStudentRepository
    
    /**
     * Default NoArgs constructor
     */
    SimilarNamedStudentService() {}
    
    /**
     * Autowired Constructor
     *
     * @param similarNamedStudentRepository
     */
    SimilarNamedStudentService(SimilarNamedStudentRepository similarNamedStudentRepository) {
        this.similarNamedStudentRepository = similarNamedStudentRepository;
    }
    
    @Transactional(readOnly = true)
    List<SimilarNamedStudent> findByStudentId(Integer studentId) {
        return similarNamedStudentRepository.findByStudent_Id(studentId)
    }
}