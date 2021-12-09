package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity



@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "entry_qualification_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class EntryQualification extends BaseEntity {
    
    @Column(name="title")
    String title
    
    @OneToOne
    @JoinColumn(name = "entry_qualification_type_id")
    EntryQualificationType type
    
    @Column(name="basic_list")
    Boolean basicList
    
    @Column(name="short_course")
    Boolean shortCourse
    
    @Column(name="data_match_code", length = 5)
    String dataMatchCode
    
    @Column(name="web_link_code")
    Integer webLinkCode
    
    @Column(name="OLD_ID")
    String OLDID
    
    /**
     * Default No Args constructor
     */
    EntryQualification(){}
    
    /**
     * The default toString method
     */
    String toString() {
        return type + " " + title;
    }
}
