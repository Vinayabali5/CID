package uk.ac.reigate.predicates

import com.querydsl.core.types.Predicate
import com.querydsl.core.types.dsl.BooleanExpression

import uk.ac.reigate.domain.exams.QCourseOption
import uk.ac.reigate.domain.exams.basedata.ExamSeries

final class CourseOptionPredicates {
    
    /**
     * This boolean expression will find any CourseOptions where the AcademicYear matches the supplied ID
     *
     * @param yearId the yearId parameter to search for
     */
    static BooleanExpression year(Integer yearId) {
        return QCourseOption.courseOption.examOption.isNotNull()
                .and(QCourseOption.courseOption.examOption.syllabus.isNotNull())
                .and(QCourseOption.courseOption.examOption.syllabus.examSeries.isNotNull())
                .and(QCourseOption.courseOption.examOption.syllabus.examSeries.academicYear.isNotNull())
                .and(QCourseOption.courseOption.examOption.syllabus.examSeries.academicYear.id.eq(yearId))
    }
    
    /**
     * This boolean expression will find any CourseOptions where the Course matches the supplied ID
     *
     * @param courseId the courseId parameter to search for
     */
    static BooleanExpression course(Integer courseId) {
        return QCourseOption.courseOption.course.id.eq(courseId)
    }
    
    /**
     * This predicate will find any CourseOptions where the Course and Year matches the supplied IDs
     *
     * @param courseId the courseId parameter to search for
     * @param yearId the yearId parameter to search for
     */
    static Predicate courseAndYear(Integer courseId, Integer yearId) {
        return course(courseId).and(year(yearId))
    }
    
    /**
     * This predicate will find any CourseOptions where they are in the given list of ExamSeries
     *  
     * @param examSeries list of ExamSeries to return the CourseOptions for
     */
    static Predicate courseOptionForExamSeriesList(List<ExamSeries> examSeries) {
        return QCourseOption.courseOption.examOption.syllabus.examSeries.in(examSeries)
    }
}