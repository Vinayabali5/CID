package uk.ac.reigate.domain.ilp

import groovy.transform.EqualsAndHashCode

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Student

/**
 * Primary Key class for the StaffInterestedInStudent view
 */
@EqualsAndHashCode(includeFields=true)
class StudentRelatedStaffPk implements Serializable {
    
    Student student
    
    Staff staff
    
    public StudentRelatedStaffPk() {}
}
