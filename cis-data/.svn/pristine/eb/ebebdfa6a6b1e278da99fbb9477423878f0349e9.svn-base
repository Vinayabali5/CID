package uk.ac.reigate.domain.ilp

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity;
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Student

@Entity
@Table(name="v_correspondence", schema = "ILP")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "correspondence_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Correspondence extends BaseEntity {
    
    @OneToOne
    @JoinColumn(name="academic_year_id")
    AcademicYear year
    
    @OneToOne
    @JoinColumn(name="student_id")
    Student student
    
    @OneToOne
    @JoinColumn(name="course_group_id")
    CourseGroup course
    
    @Column(name = "correspondence", columnDefinition="nvarchar")
    String correspondence
    
    @Column(name = "message_title", columnDefinition="nvarchar")
    String title
    
    @Column(name = "correspondence_date")
    Date date
    
    @Column(name = "correspondence_from", columnDefinition="nvarchar")
    String from
    
    @Column(name = "correspondence_to", columnDefinition="nvarchar")
    String to
    
    @OneToOne
    @JoinColumn(name = "letter_id")
    Letter letter
    
    @Column(name = "staff_advised")
    Date staffAdvised
    
    @OneToOne
    @JoinColumn(name = "correspondence_type_id")
    CorrespondenceType type
    
    @Column(name = "produced_by", columnDefinition="nchar")
    String producedBy
    
    @Column(name = "private")
    Boolean privateEntry
    
    @Column(name = 'process_stage', columnDefinition="tinyint")
    Integer processStage
    
    @Column(name = "attachments_sent", columnDefinition="nvarchar")
    String attachmentsSent
    
    Correspondence(){}
    
    String toString(){
        return student.id;
    }
}
