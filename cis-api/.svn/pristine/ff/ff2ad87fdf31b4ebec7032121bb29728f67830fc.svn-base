package uk.ac.reigate.services.exams.seatingplan

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.exams.seatingplan.ExamSession
import uk.ac.reigate.dto.exams.seatingplan.ExamSessionDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.exams.seatingplan.ExamSessionRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.utils.ValidationUtils;;

@Service
public class ExamSessionService implements ICoreDataService<ExamSession, Integer>{
    private final static Logger log = LoggerFactory.getLogger(ExamSessionService.class.getName())
    
    @Autowired
    ExamSessionRepository examSessionRepository
    
    /**
     * Default NoArgs constructor
     */
    ExamSessionService() {}
    
    /**
     * Autowired constructor
     * 
     * @param examSessionRepository
     */
    ExamSessionService(ExamSessionRepository examSessionRepository) {
        this.examSessionRepository = examSessionRepository;
    }
    
    /**
     * Find an individual ExamSession by examSessionId
     * 
     * @param examSessionId - the ID to search for
     * @return ExamSession - the ExamSession object that matches the ID, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    public ExamSession findById(Integer id) {
        return examSessionRepository.findById(id).orElse(null)
    }
    
    /**
     * Find an individual ExamSession by date and session
     * 
     * @param date
     * @param session
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    @Transactional(readOnly = true)
    public findExamSessionDateAndSession(Date date, String session) {
        return examSessionRepository.findByDateAndSession(date, session);
    }
    
    /**
     * Find all ExamSession objects
     *         
     * @return a SearchResult set with the list of ExamSessions
     */
    @Override
    @Transactional(readOnly = true)
    public List<ExamSession> findAll() {
        return examSessionRepository.findAll();
    }
    
    /**
     * Save an ExamSession object to the database
     *     
     * @param examSession - the ExamSession object to save
     * @return the saved ExamSession object
     */
    @Override
    @Transactional
    public ExamSession save(ExamSession examSession) {
        return examSessionRepository.save(examSession);
    }
    
    /**
     * This service method is used to update the ExamSession object based on the partial or complete object.
     *
     * @param examSession
     * @return
     */
    @Transactional
    public ExamSession createFromDto(ExamSessionDto examSession) {
        if(examSession == null) {
            throw new InvalidDataException("Cannot create destination from null object.")
        }
        ExamSession examSessionToSave = new ExamSession()
        examSessionToSave.date = examSession.date != null ? examSession.date : examSessionToSave.date
        examSessionToSave.session = examSession.session != null ? examSession.session : examSessionToSave.session
        return save(examSessionToSave);
    }
    
    /**
     * This service method is used to update the ExamSession object based on the partial or complete object.
     * 
     * @param examSession
     * @return
     */
    @Transactional
    public ExamSession updateFromDto(ExamSessionDto examSession) {
        if(examSession == null) {
            throw new InvalidDataException("Cannot update destination from null object.")
        }
        ExamSession examSessionToSave = findById(examSession.id)
        examSessionToSave.date = examSession.date != null ? examSession.date : examSessionToSave.date
        examSessionToSave.session = examSession.session != null ? examSession.session : examSessionToSave.session
        return save(examSessionToSave);
    }
    
    /**
     * Delete an ExamSession object from the database
     * 
     * @param examSessionId - the ID of the ExamSession object to delete    
     */
    @Transactional
    public deleteById(Integer id) {
        ExamSession examSession = findById(id)
        delete(examSession)
    }
    
    /**
     * @param ExamSession
     */
    @Override
    public void delete(ExamSession ExamSession) {
        examSessionRepository.delete(ExamSession)
    }
}
