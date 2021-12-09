package uk.ac.reigate.predicates

import com.querydsl.core.types.Ops
import com.querydsl.core.types.Predicate
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.core.types.dsl.BooleanOperation

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.QStudent

/**
 * This class defines a set of search Predicates that can be used with QueryDsl based queries to 
 * find students that match given criteria.
 * 
 * @author Michael Horgan
 *
 */
final class StudentPredicates {
    
    /**
     * This predicate will find any student where their first name matches the supplied name.
     * 	
     * @param name the name parameter to search for
     */
    static Predicate firstNameLike(String name) {
        return QStudent.student.person.firstName.contains(name)
    }
    
    /**
     * This predicate will find any student where their preferred name matches the supplied name.
     * 	
     * @param name the name parameter to search for
     */
    static Predicate preferredNameLike(String name) {
        return QStudent.student.person.preferredName.contains(name)
    }
    
    /**
     * This predicate will find any student where their surname matches the supplied name.
     * 	
     * @param name the name parameter to search for
     */
    static Predicate surnameLike(String name) {
        return QStudent.student.person.surname.contains(name)
    }
    
    /**
     * This predicate will find any student where their legal surname matches the supplied name.
     * 	
     * @param name the name parameter to search for
     */
    static Predicate legalSurnameLike(String name){
        return QStudent.student.person.legalSurname.contains(name)
    }
    
    /**
     * This predicate will find any student where their previous surname matches the supplied name.
     * 	
     * @param name the name parameter to search for
     */
    static Predicate previousSurnameLike(String name) {
        return QStudent.student.person.previousSurname.contains(name)
    }
    
    /**
     * This predicate will find any student where their middle names matches the supplied name.
     * 	
     * @param name the name parameter to search for
     */
    static Predicate middleNamesLike(String name) {
        return QStudent.student.person.middleNames.contains(name)
    }
    
    /**
     * This predicate will find any student where any of their names matches the supplied name.
     *
     * @param name the name parameter to search for
     */
    static Predicate anySurnameLike(String name) {
        return new BooleanOperation(Ops.OR, surnameLike(name), legalSurnameLike(name), previousSurnameLike(name))
    }
    
    /**
     * This predicate will find any student where any of their names matches the supplied name.
     *
     * @param name the name parameter to search for
     */
    static Predicate anyForenamesLike(String name) {
        return new BooleanOperation(Ops.OR, firstNameLike(name), preferredNameLike(name), middleNamesLike(name))
    }
    
    
    /**
     * This predicate will find any student where any of their names matches the supplied name.
     * 	
     * @param name the name parameter to search for
     */
    static Predicate anyNameLike(String name) {
        return new BooleanOperation(Ops.OR, firstNameLike(name), preferredNameLike(name), surnameLike(name), legalSurnameLike(name), previousSurnameLike(name), middleNamesLike(name))
    }
    
    /**
     * This predicate will find any student where they have a student year record for the supplied year.
     * 	
     * @param year the academicYear parameter to search for
     */
    static Predicate studentInYear(AcademicYear year) {
        return QStudent.student.studentYears.any().year.eq(year)
    }
}
