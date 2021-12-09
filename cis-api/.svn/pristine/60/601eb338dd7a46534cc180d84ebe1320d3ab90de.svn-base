package uk.ac.reigate.services.exams.edi

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.edi.EdiAuditEntryLog
import uk.ac.reigate.domain.exams.edi.EdiAuditEntryLogPk
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.exams.edi.EdiAuditEntryLogRepository
import uk.ac.reigate.services.ICoreDataService

@Service
class EdiAuditEntryLogService implements ICoreDataService<EdiAuditEntryLog, EdiAuditEntryLogPk>{
    
    @Autowired
    EdiAuditEntryLogRepository ediAuditEntryLogRepository
    
    /**
     * Default No Args constructor
     */
    EdiAuditEntryLogService() {}
    
    /**
     * Autowired constructor
     *
     * @param EdiAuditEntryLogRepository
     */
    EdiAuditEntryLogService(EdiAuditEntryLogRepository ediAuditEntryLogRepository) {
        this.ediAuditEntryLogRepository = ediAuditEntryLogRepository;
    }
    
    /**
     * Find an individual EdiAuditEntryLog by student, examOption
     *
     * @param student - student to search for
     * @return an individual ediAuditEntryLog object
     */
    @Transactional(readOnly = true)
    EdiAuditEntryLog findByStudentAndOption(Student student, ExamOption examOption){
        findById(new EdiAuditEntryLogPk(student, examOption))
    }
    
    /**
     * This method is used to find an individual EdiAuditEntryLog by
     * 
     * @param student
     * @return an individual ediAuditEntryLog object
     */
    @Transactional(readOnly = true)
    EdiAuditEntryLog findByStudent(Student student){
        findById(new EdiAuditEntryLogPk(student))
    }
    
    /**
     * This method is used find an individual EdiAuditEntryLog by StudenyId
     * 
     * @param studentId
     * @return an individual ediAuditEntryLog object
     */
    EdiAuditEntryLog findByStudent(Integer studentId){
        return ediAuditEntryLogRepository.findByStudent_Id(studentId)
    }
    
    /**
     * This method is used to retrieve the list of EdiAuditEntryLog
     * 
     * @return a list of ediAuditEntryLog object
     */
    @Transactional(readOnly = true)
    List<EdiAuditEntryLog> findAll() {
        return ediAuditEntryLogRepository.findAll();
    }
    
    /**
     * This method is used to retrieve the list of EdiAuditEntryLog by examYear.
     * 
     * @param examYear
     * @return a list of ediAuditEntryLog object
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<EdiAuditEntryLog> getByYear(String examYear){
        List<EdiAuditEntryLog> students = ediAuditEntryLogRepository.findByExamOption(examYear)
        return students
    }
    
    /**
     * This method is used to retrieve the list of EdiAuditEntryLog by studentId, examYear.
     * @param studentId
     * @param examYear
     * @return a list of ediAuditEntryLog object
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<EdiAuditEntryLog> getByStudentAndYear(Integer studentId, String examYear){
        List<EdiAuditEntryLog> students = ediAuditEntryLogRepository.findBystduent_IdAndExamOption(studentId, examYear)
        return students
    }
    
    /**
     * This method is used to save the EdiAuditEntryLog to the database.
     */
    @Transactional
    public EdiAuditEntryLog save(EdiAuditEntryLog ediAuditEntryLog) {
        return ediAuditEntryLogRepository.save(ediAuditEntryLog)
    }
    
    /**
     * This method is used to find an individual EdiAuditEntryLog by studentID.
     */
    @Override
    public EdiAuditEntryLog findById(EdiAuditEntryLogPk id) {
        return ediAuditEntryLogRepository.findById(id).orElse(null)
    }
    
    /**
     * This method is used to delete the EdiAuditEntryLog.
     */
    @Override
    public void delete(EdiAuditEntryLog obj) {
        throw new InvalidOperationException("EdiAuditEntryLog should not be deleted")
    }
}
