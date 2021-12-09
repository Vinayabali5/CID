package uk.ac.reigate.dto.admissions;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Address
import uk.ac.reigate.domain.Contact
import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.lookup.ContactType
import uk.ac.reigate.domain.lookup.Gender
import uk.ac.reigate.domain.lookup.LegalSex
import uk.ac.reigate.domain.lookup.Title

public class ContactDtoTest {
    
    private Contact contact1
    
    private Contact contact2
    
    private Contact contact3
    
    private List<Contact> contacts
    
    @Before
    public void setupTests() {
        this.contact1 = new Contact(
                id: 1,
                person: new Person(id:1),
                contact: new Person(id:2, title: new Title(id: 1, description: 'Mr'), gender : new Gender(id: 1, code: 'M')),
                contactType : new ContactType(id: 1,
                name:'M',
                description:'Mother'),
                contactable : true,
                preferred : true
                );
        this.contact2 = new Contact(
                id: 2,
                person: new Person(id:1),
                contact: new Person(id:2, title: null, gender: null),
                contactType : new ContactType(id:1),
                contactable : true,
                preferred : true
                );
        this.contact3 = new Contact(
                id: 1,
                person: null,
                contact: null,
                contactType : null,
                contactable : true,
                preferred : true
                );
        this.contacts = Arrays.asList(contact1, contact2);
    }
    
    ContactDto generateContactDto() {
        return generateContact1Dto()
    }
    
    ContactDto generateContact1Dto() {
        return new ContactDto(contact1)
    }
    
    ContactDto generateContact2Dto() {
        return new ContactDto(contact2)
    }
    
    @Test
    void testConstructor_contact() {
        ContactDto contactTest = new ContactDto( contact1 );
        assertEquals("failed: ids not equal", contactTest.id, contact1.id);
        assertEquals("failed: persons not equal", contactTest.personId, contact1.person.id);
        assertEquals("failed: contacts not equal", contactTest.contactId, contact1.contact.id);
        assertEquals("failed: contactTypes not equal", contactTest.contactTypeId, contact1.contactType.id)
        assertEquals("failed: contactable not equal", contactTest.contactable, contact1.contactable);
        assertEquals("failed: preferred not equal", contactTest.preferred, contact1.preferred);
    }
    
    @Test
    void testConstructor_NullContact() {
        Contact contact = null
        ContactDto contactTest = new ContactDto( contact );
        assertEquals(contact, null);
    }
    
    @Test
    void testConstructor_NullPerson() {
        ContactDto contactTest = new ContactDto( contact3 );
        assertEquals("failed: ids not equal", contactTest.id, contact1.id);
        assertEquals("failed: persons not equal", contactTest.personId, null);
        assertEquals("failed: contacts not equal", contactTest.contactId, null);
        assertEquals("failed: contactTypes not equal", contactTest.contactTypeId, null)
        assertEquals("failed: contactable not equal", contactTest.contactable, contact1.contactable);
        assertEquals("failed: preferred not equal", contactTest.preferred, contact1.preferred);
    }
    
    @Test
    public void testMapFromContactEntity() {
        ContactDto contactTest = ContactDto.mapFromEntity( contact1 );
        assertEquals("failed: ids not equal", contactTest.id, contact1.id);
        assertEquals("failed: persons not equal", contactTest.personId, contact1.person.id);
        assertEquals("failed: contacts not equal", contactTest.contactId, contact1.contact.id);
        assertEquals("failed: contactTypes not equal", contactTest.contactTypeId, contact1.contactType.id)
        assertEquals("failed: contactable not equal", contactTest.contactable, contact1.contactable);
        assertEquals("failed: preferred not equal", contactTest.preferred, contact1.preferred);
    }
    
    
    @Test
    public void testMapFromContactsEntities(){
        List<ContactDto> contactTest = ContactDto.mapFromList( contacts )
        assertEquals( contactTest[0].id, contact1.id );
        assertEquals( contactTest[0].personId, contact1.person.id);
        assertEquals( contactTest[0].contactId, contact1.contact.id);
        assertEquals( contactTest[0].contactTypeId, contact1.contactType.id);
        assertEquals( contactTest[0].contactable, contact1.contactable );
        assertEquals( contactTest[0].preferred, contact1.preferred );
        assertEquals( contactTest[1].id, contact2.id );
        assertEquals( contactTest[1].personId, contact2.person.id);
        assertEquals( contactTest[1].contactId, contact2.contact.id);
        assertEquals( contactTest[1].contactTypeId, contact2.contactType.id);
        assertEquals( contactTest[1].contactable, contact2.contactable );
        assertEquals( contactTest[1].preferred, contact2.preferred );
    }
    
    @Test
    public void testEquals_Same() {
        ContactDto contactDto1 = new ContactDto(contact1)
        ContactDto contactDto2 = new ContactDto(contact1)
        assertEquals(contactDto1, contactDto2)
    }
    
    @Test
    public void testEquals_Different() {
        ContactDto contactDto1 = new ContactDto(contact1)
        ContactDto contactDto2 = new ContactDto(contact2)
        assertNotEquals(contactDto1, contactDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        ContactDto contactDto1 = new ContactDto(contact1)
        ContactDto contactDto2 = new ContactDto(contact1)
        assertEquals(contactDto1.hashCode(), contactDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        ContactDto contactDto1 = new ContactDto(contact1)
        ContactDto contactDto2 = new ContactDto(contact2)
        assertNotEquals(contactDto1.hashCode(), contactDto2.hashCode())
    }
    
    @Test
    public void testMethod_Get_ContactTypeDescription() {
        ContactDto contactDto1 = new ContactDto(contact1)
        assertEquals(contactDto1.contactType.description, contactDto1.get_ContactTypeDescription())
    }
    
    @Test
    public void testMethod_Get_NullContactTypeDescription() {
        ContactDto contactDto1 = new ContactDto(contact3)
        assertEquals(contactDto1.contactType, contactDto1.get_ContactTypeDescription())
    }
    
    @Test
    public void testMethod_Get_TitleDescription() {
        ContactDto contactDto1 = new ContactDto(contact1)
        assertEquals(contactDto1.contact.title.description, contactDto1.get_TitleDescription())
    }
    
    @Test
    public void testMethod_Get_NullContactTitleDescription() {
        ContactDto contactDto1 = new ContactDto(contact2)
        assertEquals(contactDto1.contact.title, contactDto1.get_TitleDescription())
    }
    
    @Test
    public void testMethod_Get_GenderCode() {
        ContactDto contactDto1 = new ContactDto(contact1)
        assertEquals(contactDto1.contact.gender.code, contactDto1.get_GenderCode())
    }
    
    @Test
    public void testMethod_Get_NullGenderCode() {
        ContactDto contactDto1 = new ContactDto(contact2)
        assertEquals(contactDto1.contact.gender, contactDto1.get_GenderCode())
    }
}
