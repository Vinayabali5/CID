package uk.ac.reigate.domain

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.validation.constraints.NotNull

import com.fasterxml.jackson.annotation.JsonIgnore

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.lookup.ContactType

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Contact extends BaseEntity implements Serializable {
    
    /**
     * The Person for whom this is a contact for 
     */
    @JsonIgnore
    @NotNull
    @OneToOne(cascade=[CascadeType.PERSIST,CascadeType.MERGE], fetch=FetchType.LAZY)
    @JoinColumn(name='person_id')
    Person person
    
    /**
     * The Person object that is the contact for the person 
     */
    @NotNull
    @OneToOne(cascade=[CascadeType.PERSIST,CascadeType.MERGE], fetch=FetchType.EAGER)
    @JoinColumn(name='contact_id')
    Person contact
    
    /**
     * The ContactType of this particular contact
     */
    @OneToOne
    @JoinColumn(name='contact_type_id')
    ContactType contactType
    
    /**
     * This fields determines if this person can be contacted 
     */
    @Column(name="contactable")
    Boolean contactable
    
    /**
     * This fields determines if this person is the preferred contact (primary contact)
     */
    @Column(name="preferred")
    Boolean preferred
    
    @Column(name="alternative_address")
    Boolean alternativeAddress
    
    /**
     * Default No Args constructor
     */
    Contact() {
        contactable = false
        preferred = false
        alternativeAddress = false
    }
    
    /**
     * Constructor to create a prepopluated contact with all requried fields
     * 
     * @param person The person to create a contact for
     * @param contact The contact to link to the person
     * @param contactType The type of the contact
     * @param contactable If the contact is contactable
     * @param preferred  If the contact is the preferred/primary contact
     */
    Contact(Integer id, Person person, Person contact, ContactType contactType, Boolean contactable, Boolean preferred) {
        this.id = id;
        this.person = person
        this.contact = contact
        this.contactType = contactType
        this.contactable = contactable
        this.preferred = preferred
    }
    
    Contact(Person person, Person contact, ContactType contactType, Boolean contactable, Boolean preferred) {
        this(null, person, contact, contactType, contactable, preferred);
    }
    
    public getContactId(){}
    
    /**
     * The default toString method
     */
    String toString(){
        return person.id;
    }
}

