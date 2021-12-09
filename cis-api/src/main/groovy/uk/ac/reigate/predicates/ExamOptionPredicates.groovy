package uk.ac.reigate.predicates

import com.querydsl.core.types.Predicate

import uk.ac.reigate.domain.exams.basedata.QExamOption

class ExamOptionPredicates {
    
    static Predicate examOptionsInYear(Integer yearId) {
        return QExamOption.examOption.syllabus.examSeries.academicYear.id.eq(yearId)
    }
}
