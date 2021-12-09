package uk.ac.reigate.domain.ilp

import groovy.transform.EqualsAndHashCode

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Student

@Entity
@Table(name="[StudentRelatedStaff]", schema = "ILP")
@EqualsAndHashCode(includeFields=true)
@IdClass(StudentRelatedStaffPk.class)
class StudentRelatedStaff implements Serializable {
    
    @Id
    @OneToOne
    @JoinColumn(name = "student_id")
    Student student
    
    @Id
    @OneToOne
    @JoinColumn(name = "[StaffId]")
    Staff staff
    
    @Column(name="[StaffInitials]")
    String staffInitials
    
    @Column(name="[StaffName]")
    String staffName
    
    @Column(name="relationship")
    String relationship
}
