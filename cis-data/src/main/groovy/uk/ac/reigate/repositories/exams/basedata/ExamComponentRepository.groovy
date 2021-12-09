package uk.ac.reigate.repositories.exams.basedata

import javax.persistence.TemporalType
import javax.transaction.Transactional

import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.Temporal
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param

import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.domain.exams.basedata.ExamSeries

@Transactional
public interface ExamComponentRepository extends PagingAndSortingRepository<ExamComponent, Integer> {
    
    List<ExamComponent> findByCode(String code)
    
    /**
     * Find all examComponents where timetableDate is between start and end date and timetableSession equals timetableSession 
     */
    @Query("SELECT c FROM ExamComponent c WHERE c.timetableSession = :timetableSession AND CAST(c.timetableDate AS date) = :timetableDateStart")
    List<ExamComponent> findByTimetableDateAndTimetableSession(@Param(value = "timetableDateStart") @Temporal(TemporalType.DATE) Date timetableDateStart, @Param(value = "timetableSession") String timetableSession)
    
    ExamComponent findByExamSeriesAndCode(ExamSeries examSeries, String code)
}
