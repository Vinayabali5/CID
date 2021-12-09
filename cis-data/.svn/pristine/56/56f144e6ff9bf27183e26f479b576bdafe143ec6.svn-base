package uk.ac.reigate.repositories.exams.basedata

import javax.transaction.Transactional

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param

import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.basedata.ExamSeries
import uk.ac.reigate.domain.exams.basedata.Syllabus

@Transactional
public interface ExamOptionRepository extends PagingAndSortingRepository<ExamOption, Integer> {
    
    List<ExamOption> findByOptionEntryCode(String optionEntryCode);
    
    @Query("SELECT eo from ExamOption eo WHERE optionEntryCode = :optionEntryCode AND eo.syllabus.examSeries.academicYear.id = :yearId")
    List<ExamOption> findByOptionEntryCodeAndYear(@Param(value = "yearId") Integer yearId, @Param(value = "optionEntryCode")  String optionEntryCode);
    
    List<ExamOption> findByOptionEntryCodeContaining(String optionEntryCode);
    
    List<ExamOption> findBySyllabus(Syllabus syllabus);
    
    List<ExamOption> findBySyllabus(Syllabus syllabus, PageRequest pageRequest);
    
    ExamOption findBySyllabus_ExamSeriesAndOptionEntryCode(ExamSeries examSeries, String optionEntryCode)
    
    ExamOption findBySyllabus_ExamSeriesAndSyllabusAndOptionEntryCode(ExamSeries examSeries, Syllabus syllabus, String optionEntryCode)
}
