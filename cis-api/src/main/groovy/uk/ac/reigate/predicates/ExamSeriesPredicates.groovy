package uk.ac.reigate.predicates

import com.querydsl.core.types.Predicate

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.exams.basedata.QExamSeries

class ExamSeriesPredicates {
    
    /**
     * This predicate will find any Exam Series where the Academic Year matches the yearId supplied
     *
     * @param yearId the yearId parameter to search for
     */
    static Predicate examSeriesInYear(Integer yearId) {
        return QExamSeries.examSeries1.academicYear.id.eq(yearId)
    }
    
    /**
     * This predicate will find any Exam Series where the Academic Year matches the year supplied
     *
     * @param year the AcademicYear to search for
     */
    static Predicate examSeriesInYear(AcademicYear year) {
        return QExamSeries.examSeries1.academicYear.eq(year)
    }
}
