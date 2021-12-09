package uk.ac.reigate.repositories.exams.basedata

import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.PagingAndSortingRepository

import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.exams.basedata.ExamSeries

public interface ExamSeriesRepository extends PagingAndSortingRepository<ExamSeries, Integer>, QuerydslPredicateExecutor<ExamSeries> {
    
    ExamSeries findByExamBoardAndExamYearAndExamSeries(ExamBoard examBoard, String examYear, String examSeries);
    
    List<ExamSeries> findByExamYearAndExamSeries(String examYear, String examSeries);
    
    List<ExamSeries> findByExamBoard_Id(Integer examBoardId);
    
    List<ExamSeries> findByAcademicYear_Id(Integer yearId);
    
    List<ExamSeries> findByExamBoard_IdAndAcademicYear_Id(Integer examBoardId, Integer yearId);
    
    List<ExamSeries> findByExamBoard_Id(Integer examBoardId, Pageable pageable);
}
