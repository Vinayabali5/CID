package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode;

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.validation.constraints.NotNull
import javax.xml.bind.annotation.XmlRootElement

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity
import uk.ac.reigate.domain.lookup.SchoolPriority
import uk.ac.reigate.domain.lookup.SchoolType

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "school_id"))
])
@XmlRootElement(name="school")
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class School extends BaseEntity implements Serializable {
    
    /**
     * The name of the school
     */
    @Column(name="name")
    @NotNull
    String name
    
    /**
     * The type of school
     */
    @NotNull
    @OneToOne
    @JoinColumn(name='school_type_id')
    SchoolType type
    
    /**
     * The schools DfE unique reference number
     */
    @Column(name="urn")
    String urn
    
    /**
     * The schools UK provider reference number
     */
    @Column(name="ukprn")
    String ukprn
    
    /**
     * The admissions priority of the school
     */
    @OneToOne
    @JoinColumn(name='school_priority_id')
    SchoolPriority priority
    
    /**
     * The Address of the school
     */
    @Column(name="line1")
    String line1
    
    @Column(name="line2")
    String line2
    
    @Column(name="line3")
    String line3
    
    @Column(name="postcode")
    String postcode
    
    @Column(name= "telephone")
    String telephone
    
    @Column(name= "head_title")
    String headTitle
    
    @Column(name = "head_first_name")
    String headFirstName
    
    @Column(name = "head_surname")
    String headSurname
    
    @Column(name = "contact_title")
    String contactTitle
    
    @Column(name = "contact_first_name")
    String contactFirstName
    
    @Column(name = "contact_surname")
    String contactSurname
    
    @Column(name = "contact_email")
    String contactEmail
    
    @Column(name="use_in_online_applications")
    Boolean useInOnlineApplications
    
    
    School(){}
    
    /**
     * toString method that returns the "name (type)" of the School
     */
    String toString() {
        return name + ' (' + type + ')'
    }
}
