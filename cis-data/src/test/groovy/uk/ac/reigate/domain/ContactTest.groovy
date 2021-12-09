package uk.ac.reigate.domain;

import static org.junit.Assert.*

import java.util.Date;

import javax.persistence.OneToOne;

import org.junit.Test

import uk.ac.reigate.domain.Staff;
import uk.ac.reigate.domain.academic.CourseGroup;
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.lookup.ContactType;
import uk.ac.reigate.domain.lookup.Subject


public class ContactTest {
    
    Person createPerson() {
        Person person = new Person()
    }
    
    Person createContact() {
        Person contact = new Person()
    }
    
    ContactType createContactType() {
        ContactType contactType = new ContactType()
    }
    
    
    
    @Test
    void testConstructor_AllFieldsWithoutId() {
        
        Person person = createPerson()
        Person contact = createContact()
        ContactType contactType = createContactType()
        Boolean contactable = true
        Boolean preferred = false
        
        Contact contactt = new Contact(person, contact, contactType, contactable, preferred)
        
        assertNotNull(contactt)
        assertEquals(contactt.person.id, person.id)
        assertEquals(contactt.contact.id, contact.id)
        assertEquals(contactt.contactType, contactType)
        assertEquals(contactt.contactable, contactable)
        assertEquals(contactt.preferred, preferred)
    }
    
    @Test
    void testConstructor_AllFieldsWithId() {
        Integer id = 1
        Person person = createPerson()
        Person contact = createContact()
        ContactType contactType = createContactType()
        Boolean contactable = true
        Boolean preferred = false
        
        Contact contactt = new Contact(id, person, contact, contactType, contactable, preferred)
        
        assertNotNull(contact)
        assertEquals(contactt.person.id, person.id)
        assertEquals(contactt.contact.id, contact.id)
        assertEquals(contactt.contactType, contactType)
        assertEquals(contactt.contactable, contactable)
        assertEquals(contactt.preferred, preferred)
    }
    
    @Test
    void testMethod_ToString() {
        Contact contacte = new Contact()
        Person person = createPerson()
        contacte.person = person
        
        assertEquals(contacte.person.id, contacte.toString())
    }
}
