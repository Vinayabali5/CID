package uk.ac.reigate.predicates

import com.querydsl.core.types.Predicate

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.QCourseGroup

class CourseGroupPredicates {
    
    /**
     * This predicate will find any courseGroup where the year id is equal to the supplied AcademicYear
     *
     * @param yearId a AcademicYear to search for 
     */
    static Predicate courseGroupValidInYear(AcademicYear year){
        return QCourseGroup.courseGroup.year.id.eq(year.id)
    }
    
    /**
     * This predicate will find any courseGroup where the year id is equal to the supplied yearId
     *
     * @param yearId a yearId to search for
     */
    static Predicate courseGroupValidInYear(Integer yearId){
        return QCourseGroup.courseGroup.year.id.eq(yearId)
    }
}
