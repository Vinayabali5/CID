package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

import uk.ac.reigate.domain.Staff

@Entity
@Table(name = "`StaffInterestedInStudent`", schema = "Data")
@EqualsAndHashCode(includeFields=true)
@IdClass(StaffInterestedInStudentPk.class)
class StaffInterestedInStudent implements Serializable {
    
    @Id
    @OneToOne
    @JoinColumn(name = "student_id")
    Student student
    
    @Id
    @OneToOne
    @JoinColumn(name = "[InterestedStaffId]")
    Staff staff
    
    @Id
    @Column(name = "[Interest]")
    String interest
    
    @Column(name = "pastoral")
    Boolean pastoral
    
    @Column(name = "departmental")
    Boolean departmental
    
    @Column(name = "[CourseGroupSpec]")
    String courseGroupSpec
    
    @Column(name = "[StaffInitials]")
    String staffInitials
    
    @Column(name = "[StaffKnownAs]")
    String staffKnownAs
    
    @Column(name = "`StaffEmail`")
    String staffEmail
}
