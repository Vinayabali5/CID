package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Address
import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.lookup.Gender
import uk.ac.reigate.domain.lookup.LegalSex
import uk.ac.reigate.domain.lookup.Title
import uk.ac.reigate.domain.security.Role

public class PersonSummaryDtoTest {
    
    private Title mr
    
    private Title mrs
    
    private Gender male
    
    private Gender female
    
    private LegalSex Female
    
    private Address address
    
    private Person person1
    
    private Person person2
    
    private List<Person> people
    
    private Set<Role> roles
    
    @Before
    public void setupTests() {
        this.mr = new Title(id: 1, description: 'Mr')
        this.mrs = new Title()
        this.male =  new Gender()
        this.female =  new Gender()
        this.address = new Address(1, 'Flat D', 'Stag', 'Stanley', 'west', 'park', 'Wallington', '', 'E161FF', '', '')
        this.person1 = new Person(
                id: 1,
                title: mr,
                firstName: 'John',
                preferredName: 'Jon',
                surname: 'Smith',
                legalSurname: 'Smiths',
                middleNames: 'Anon',
                previousSurname: 'Jones',
                dob: new SimpleDateFormat("yyyy/MM/dd").parse('1991/01/31'),
                gender: male,
                legalSex: Female,
                address : address,
                home: '0123456789',
                mobile: '0123456789',
                work: '0123456789',
                email: 'john.smith@gmail.com',
                enabled: true,
                roles: null,
                username: 'vbm'
                );
        this.person2 = new Person(
                id: 2,
                title: mrs,
                firstName: 'Vinaya',
                preferredName: 'Vin',
                surname: 'Bali',
                legalSurname: 'Smiths',
                middleNames: 'MB',
                previousSurname: 'Uday',
                dob: new SimpleDateFormat("yyyy/MM/dd").parse('1991/11/11'),
                gender: female,
                legalSex: Female,
                address : address,
                home: '07809176666',
                mobile: null,
                work: null,
                email: 'mbvinayabali@gmail.com',
                enabled: true,
                roles: null,
                username: 'vbm'
                );
        this.people = Arrays.asList(person1, person2);
    }
    
    PersonSummaryDto generatePersonSummaryDto() {
        return generatePerson1Dto()
    }
    
    PersonSummaryDto generatePerson1Dto() {
        return new PersonSummaryDto(person1)
    }
    
    PersonSummaryDto generatePerson2Dto() {
        return new PersonSummaryDto(person2)
    }
    
    @Test
    void testConstructor_AllFieldsPerson() {
        PersonSummaryDto person = new PersonSummaryDto( person1 )
        assertEquals(person.firstName, person1.firstName)
        assertEquals(person.preferredName, person1.preferredName)
        assertEquals(person.middleNames, person1.middleNames)
        assertEquals(person.surname, person1.surname)
        assertEquals(person.legalSurname, person1.legalSurname)
        assertEquals(person.previousSurname, person1.previousSurname)
    }
    
    
    @Test
    public void testMapFromPersonEntityTest(){
        PersonSummaryDto personTest = PersonSummaryDto.mapFromEntity( person1 );
        assertEquals("failed: ids not equal", personTest.id, person1.id );
        assertEquals("failed: titles not equal", personTest.titleId, person1.title.id);
        assertEquals("failed: firstName not equal", personTest.firstName, person1.firstName);
        assertEquals("failed: preferredName not equal", personTest.preferredName, person1.preferredName);
        assertEquals("failed: surname not equal", personTest.surname, person1.surname);
        assertEquals("failed: legalSurname not equal", personTest.legalSurname, person1.legalSurname);
        assertEquals("failed: middleNames not equal", personTest.middleNames, person1.middleNames);
        assertEquals("failed: previousSurname not equal", personTest.previousSurname, person1.previousSurname);
    }
    
    @Test
    public void testMapFromPeopleEntitiesTest(){
        List<PersonSummaryDto> peopleTest = PersonSummaryDto.mapFromList(people)
        assertEquals( peopleTest[0].id, person1.id );
        assertEquals( peopleTest[0].titleId, person1.title.id);
        assertEquals( peopleTest[0].firstName, person1.firstName);
        assertEquals( peopleTest[0].preferredName, person1.preferredName);
        assertEquals( peopleTest[0].surname, person1.surname);
        assertEquals( peopleTest[0].legalSurname, person1.legalSurname);
        assertEquals( peopleTest[0].middleNames, person1.middleNames);
        assertEquals( peopleTest[0].previousSurname, person1.previousSurname);
    }
    
    
    @Test
    public void testEquals_Different(){
        PersonSummaryDto personDto1 = new PersonSummaryDto(person1)
        PersonSummaryDto personDto2 = new PersonSummaryDto(person2)
        assertNotEquals(personDto1, personDto2)
    }
    
    @Test
    public void testEquals_Same() {
        PersonSummaryDto personDto1 = new PersonSummaryDto(person1)
        PersonSummaryDto personDto2 = new PersonSummaryDto(person1)
        assertEquals(personDto1, personDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        PersonSummaryDto personDto1 = new PersonSummaryDto(person1)
        PersonSummaryDto personDto2 = new PersonSummaryDto(person1)
        assertEquals(personDto1.hashCode(), personDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different(){
        PersonSummaryDto personDto1 = new PersonSummaryDto(person1)
        PersonSummaryDto personDto2 = new PersonSummaryDto(person2)
        assertNotEquals(personDto1.hashCode(), personDto2.hashCode())
    }
    
    @Test
    public void testMethod_Get_NullTitleDescription() {
        Person person = new Person(id: 1, title: null)
        PersonSummaryDto personDto1 = new PersonSummaryDto(person)
        assertEquals(personDto1.title, personDto1.get_TitleDescription())
    }
    
    @Test
    public void testMethod_Get_TitleDescription() {
        PersonSummaryDto personDto1 = new PersonSummaryDto(person1)
        assertEquals(personDto1.title.description, personDto1.get_TitleDescription())
    }
}
