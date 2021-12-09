package uk.ac.reigate.predicates

import com.querydsl.core.types.Ops
import com.querydsl.core.types.Predicate
import com.querydsl.core.types.dsl.BooleanOperation

import uk.ac.reigate.domain.academic.QCourse

/**
 * This class defines a set of search Predicates that can be used with QueryDsl based queries to 
 * find courses that match given criteria.
 * 
 * @author Michael Horgan
 *
 */
final class CoursePredicates {
    
    /**
     * This predicate will find any course where the valid from year is greater than the supplied academicYear
     *
     * @param name the name parameter to search for
     */
    static Predicate courseValidFrom(Integer yearId) {
        return QCourse.course.validFrom.id.loe(yearId)
    }
    
    /**
     * This predicate will find any course where the valid to year is less than the supplied academicYear 
     * or where the valid to year is set to null
     *
     * @param name the name parameter to search for
     */
    static Predicate courseValidTo(Integer yearId) {
        return QCourse.course.validTo.id.goe(yearId).or(QCourse.course.validTo.id.isNull())
    }
    
    /**
     * This predicate will find any course where the valid to year is less than the supplied academicYear
     * or where the valid to year is set to null
     *
     * @param name the name parameter to search for
     */
    static Predicate courseValidInYear(Integer yearId) {
        return new BooleanOperation(Ops.AND, courseValidFrom(yearId),courseValidTo(yearId))
    }
    
    /**
     * This predicate will find any course matching the cours spec supplied.
     * 
     * @param spec a three letter course spec code to search for
     */
    static Predicate courseSpecIs(String spec) {
        return QCourse.course.spec.eq(spec)
    }
    
    /**
     * This predicate will find any course matching the cours spec supplied.
     * 
     * @param spec a three letter course spec code to search for
     */
    static Predicate courseSpecIsLike(String spec) {
        return QCourse.course.spec.contains(spec)
    }
    
    /**
     * This predicate will find any course that is flagged as being published.
     */
    static Predicate coursePublished() {
        return QCourse.course.published.eq(true)
    }
    
    /**
     * This predicate will find any course that is flagged as being published.
     */
    static Predicate coursePublishedAndValidInYear(Integer yearId) {
        return new BooleanOperation(Ops.AND, courseValidInYear(yearId), coursePublished())
    }
}
