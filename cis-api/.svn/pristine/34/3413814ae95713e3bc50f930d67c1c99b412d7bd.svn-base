package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.register.RegisteredSession
import uk.ac.reigate.dto.SessionDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.RegisteredSessionRepository

@Service
class RegisteredSessionService implements ICoreDataService<RegisteredSession, Integer>, IDtoCreateUpdateService<SessionDto, RegisteredSession>{
    
    @Autowired
    RegisteredSessionRepository registeredSessionRepository
    
    @Autowired
    private final PeriodService periodService;
    
    
    /**
     * Default NoArgs constructor
     */
    RegisteredSessionService() {}
    
    /**
     * Autowired Constructor
     *
     * @param sessionRepository
     */
    RegisteredSessionService(RegisteredSessionRepository registeredSessionRepository, PeriodService periodService) {
        this.registeredSessionRepository = registeredSessionRepository
        this.periodService = periodService
    }
    
    /**
     * Find an individual session using the sessions ID fields
     *
     * @param id the ID fields to search for
     * @return the Session object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    RegisteredSession findById(Integer id) {
        return registeredSessionRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all sessions
     *
     * @return a SearchResult set with the list of Sessions
     */
    @Override
    @Transactional(readOnly = true)
    List<RegisteredSession> findAll() {
        return registeredSessionRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Session object in the database
     *
     * @param session the new Session object to be saved
     * @return the saved version of the Session object
     */
    @Override
    @Transactional
    public RegisteredSession save(RegisteredSession session) {
        return registeredSessionRepository.save(session)
    }
    
    /**
     * Saves a list of Session objects to the database
     *
     * @param sessions a list of Sessions to be saved to the database
     * @return the list of save Session objects
     */
    @Transactional
    public List<RegisteredSession> saveSessions(List<RegisteredSession> sessions) {
        return sessions.collect { session -> save(session) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. RegisteredSession should not be deleted.
     */
    @Override
    public void delete(RegisteredSession obj) {
        throw new InvalidOperationException("RegisteredSession should not be deleted")
    }
    
    /**
     * This service method is used to create a RegisteredSession object in the database from a partial or complete RegisteredSession object.
     *
     * @param registeredSession the partial or complete RegisteredSession object to be saved
     * @return the saved version of the RegisteredSession object
     */
    @Transactional
    public RegisteredSession createFromDto(SessionDto session) {
        if (session == null) {
            throw new InvalidDataException("Cannot create sessionDto from null object.")
        }
        RegisteredSession registeredSessionToSave = new RegisteredSession()
        registeredSessionToSave.date = session.date;
        if (session.periodId != null) {
            registeredSessionToSave.period = periodService.findById(session.periodId)
        }
        return save(registeredSessionToSave)
    }
    
    /**
     * This service method is used to create a RegisteredSession object in the database from a partial or complete RegisteredSession object.
     *
     * @param registeredSession the partial or complete RegisteredSession object to be saved
     * @return the saved version of the RegisteredSession object
     */
    @Transactional
    public RegisteredSession updateFromDto(SessionDto session) {
        if (session == null) {
            throw new InvalidDataException("Cannot update sessionDto from null object.")
        }
        RegisteredSession registeredSessionToSave = findById(session.id)
        registeredSessionToSave.date = session.date;
        if (session.periodId != null) {
            registeredSessionToSave.period = periodService.findById(session.periodId)
        }
        return save(registeredSessionToSave)
    }
}
