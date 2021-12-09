package uk.ac.reigate.services.exams.edi

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.exams.edi.EdiAuditFileLog
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.exams.edi.EdiAuditFileLogRepository
import uk.ac.reigate.services.ICoreDataService

@Service
class EdiAuditFileLogService implements ICoreDataService<EdiAuditFileLog, Integer>{
    
    @Autowired
    EdiAuditFileLogRepository ediAuditFileLogRepository
    
    /**
     * Default No Args constructor
     */
    EdiAuditFileLogService() {}
    
    
    EdiAuditFileLogService(EdiAuditFileLogRepository ediAuditFileLogRepository) {
        this.ediAuditFileLogRepository = ediAuditFileLogRepository;
    }
    
    
    /**
     * This method is used to retrieve the list of the EdiAuditFileLog
     */
    @Transactional(readOnly = true)
    List<EdiAuditFileLog> findAll() {
        return ediAuditFileLogRepository.findAll();
    }
    
    /**
     * This method is used to save EdiAuditFileLog object to the database.
     */
    @Transactional
    public EdiAuditFileLog save(EdiAuditFileLog ediAuditFileLog) {
        return ediAuditFileLogRepository.save(ediAuditFileLog)
    }
    
    
    /**
     * This method is used to retrieve an individual EdiAuditFileLog object.
     */
    @Override
    public EdiAuditFileLog findById(Integer id) {
        return ediAuditFileLogRepository.findById(id).orElse(null)
    }
    
    /**
     * This method is used to delete the EdiAudirFileLog.
     */
    @Override
    public void delete(EdiAuditFileLog obj) {
        throw new InvalidOperationException("EdiAuditFileLog should not be deleted")
    }
}
