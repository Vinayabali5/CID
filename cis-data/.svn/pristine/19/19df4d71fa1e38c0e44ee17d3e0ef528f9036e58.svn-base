package uk.ac.reigate.repositories.exams.edi


import org.springframework.data.jpa.repository.Query
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param;

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.edi.EdiAuditEntryLog
import uk.ac.reigate.domain.exams.edi.EdiAuditEntryLogPk

interface EdiAuditEntryLogRepository extends CrudRepository<EdiAuditEntryLog, EdiAuditEntryLogPk>, QuerydslPredicateExecutor<EdiAuditEntryLog> {
    
    EdiAuditEntryLog findByStudent(Student student)
    
    EdiAuditEntryLog findByStudent_Id(Integer studentId)
    
    @Query("select s from EdiAuditEntryLog s where s.examOption.syllabus.examSeries.examYear = :examYear")
    List<EdiAuditEntryLog> findByExamOption(@Param("examYear") String examYear)
    
    @Query("select s from EdiAuditEntryLog s where (:studentId != NULL AND s.student.id = :studentId) and s.examOption.syllabus.examSeries.examYear = :examYear")
    List<EdiAuditEntryLog> findBystduent_IdAndExamOption(@Param("studentId") Integer studentId, @Param("examYear") String examYear)
}
