package uk.ac.reigate.domain.cristal

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

import uk.ac.reigate.domain.BaseEntity
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.register.AttendanceCode

@Entity
@Table(name = '[Master_Register_All]', schema = "Cristal")
class MasterRegister extends BaseEntity {
    
    @Column(name='Session_Ref')
    Integer sessionRef
    
    @OneToOne
    @JoinColumn(name = 'Student_Ref')
    Student student
    
    @Column(name = 'Subject_Code', columnDefinition = 'nvarchar')
    String subjectCode
    
    @Column(name='`Group`', columnDefinition = 'nvarchar')
    String group
    
    @OneToOne
    @JoinColumn(name = 'Attendance', referencedColumnName = 'Code', columnDefinition = 'nvarchar')
    AttendanceCode attendance
    
    @OneToOne
    @JoinColumn(name = 'academic_year_id')
    AcademicYear academicYear
    
    @Column(name = 'Notes', columnDefinition = 'nvarchar')
    String notes
    
    MasterRegister() {}
    
    String toString(){
        return student.id;
    }
}
