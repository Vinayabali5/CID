package uk.ac.reigate.domain.ilp

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity

@Entity
@Table(name="ilp_interview_type", schema = "ILP")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "ilp_interview_type_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class ILPInterviewType extends BaseEntity{
    
    @Column(name = "ilp_interview_type", columnDefinition = "nvarchar")
    String type
    
    @Column(name = "require_course_group_id", columnDefinition = "bit")
    Boolean requireCourseGroupId
    
    @Column(name = "allow_lip_referral", columnDefinition = "bit")
    Boolean allowLipReferral
    
    @Column(name = "allow_office_action", columnDefinition = "bit")
    Boolean allowOfficeAction
    
    @Column(name = "allow_email_related_staff", columnDefinition = "bit")
    Boolean allowEmailRelatedStaff
    
    @Column(name = "default_to_private", columnDefinition = "bit")
    Boolean defaultToPrivate
    
    @Column(name = "require_target", columnDefinition = "bit")
    Boolean requireTarget
    
    ILPInterviewType() {}
    
    String toString(){
        return type;
    }
}
