package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode

import uk.ac.reigate.domain.Staff

/**
 * Primary Key class for the StaffInterestedInStudent view
 */
@EqualsAndHashCode(includeFields=true)
class StaffInterestedInStudentPk implements Serializable {
    
    Student student
    
    Staff staff
    
    String interest
    
    public StaffInterestedInStudentPk() {}
}
