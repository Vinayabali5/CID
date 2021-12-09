package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Address
import uk.ac.reigate.domain.Contact
import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.lookup.Gender
import uk.ac.reigate.domain.lookup.LegalSex
import uk.ac.reigate.domain.lookup.Title
import uk.ac.reigate.domain.security.Role

public class PersonDtoTest {
    
    private Title mr
    
    private Title mrs
    
    private Gender male
    
    private Gender female
    
    private LegalSex Female
    
    private Address address
    
    private Person person1
    
    private Person person2
    
    private Person person3
    
    private List<Person> people
    
    private Set<Role> roles
    
    @Before
    public void setupTests() {
        this.mr = new Title(id: 1, description: 'Mr')
        this.mrs = new Title(id: 1, description: 'Mrs')
        this.male =  new Gender(id: 1, code: 'M', description: 'Male')
        this.female =  new Gender(id: 1, code: 'F', description: 'Female')
        this.Female = new LegalSex(id:1, code: 'F')
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
                username: 'vbm',
                contacts: [
                    new Contact()]
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
        this.person3 = new Person(
                id: 2,
                title: null,
                firstName: 'Vinaya',
                preferredName: 'Vin',
                surname: 'Bali',
                legalSurname: 'Smiths',
                middleNames: 'MB',
                previousSurname: 'Uday',
                dob: new SimpleDateFormat("yyyy/MM/dd").parse('1991/11/11'),
                gender: null,
                legalSex: null,
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
    
    PersonDto generatePersonDto() {
        return generatePerson1Dto()
    }
    
    PersonDto generatePerson1Dto() {
        return new PersonDto(person1)
    }
    
    PersonDto generatePerson2Dto() {
        return new PersonDto(person2)
    }
    
    @Test
    void testConstructor_AllFieldsPerson() {
        PersonDto person = new PersonDto( person1 )
        assertEquals(person.firstName, person1.firstName)
        assertEquals(person.preferredName, person1.preferredName)
        assertEquals(person.middleNames, person1.middleNames)
        assertEquals(person.surname, person1.surname)
        assertEquals(person.legalSurname, person1.legalSurname)
        assertEquals(person.previousSurname, person1.previousSurname)
        assertEquals(person.home, person1.home)
        assertEquals(person.mobile, person1.mobile)
        assertEquals(person.work, person1.work)
        assertEquals(person.email, person1.email)
        assertEquals(person.contacts, ContactDto.mapFromList(person1.contacts))
    }
    
    
    @Test
    public void testMapFromPersonEntityTest(){
        PersonDto personTest = PersonDto.mapFromEntity( person1 );
        assertEquals("failed: ids not equal", personTest.id, person1.id );
        assertEquals("failed: titles not equal", personTest.titleId, person1.title.id);
        assertEquals("failed: firstName not equal", personTest.firstName, person1.firstName);
        assertEquals("failed: preferredName not equal", personTest.preferredName, person1.preferredName);
        assertEquals("failed: surname not equal", personTest.surname, person1.surname);
        assertEquals("failed: legalSurname not equal", personTest.legalSurname, person1.legalSurname);
        assertEquals("failed: middleNames not equal", personTest.middleNames, person1.middleNames);
        assertEquals("failed: previousSurname not equal", personTest.previousSurname, person1.previousSurname);
        assertEquals("failed: dob not equal", personTest.dob, person1.dob);
        assertEquals("failed: gender not equal", personTest.genderId, person1.gender.id);
        assertEquals("failed: address not equal", personTest.addressId, person1.address.id);
        assertEquals("failed: home not equal", personTest.home, person1.home);
        assertEquals("failed: mobile not equal", personTest.mobile, person1.mobile);
        assertEquals("failed: work not equal", personTest.work, person1.work);
        assertEquals("failed: email not equal", personTest.email, person1.email);
    }
    
    @Test
    public void testMapFromPeopleEntitiesTest(){
        List<PersonDto> peopleTest = PersonDto.mapFromList(people)
        assertEquals( peopleTest[0].id, person1.id );
        assertEquals( peopleTest[0].titleId, person1.title.id);
        assertEquals( peopleTest[0].firstName, person1.firstName);
        assertEquals( peopleTest[0].preferredName, person1.preferredName);
        assertEquals( peopleTest[0].surname, person1.surname);
        assertEquals( peopleTest[0].legalSurname, person1.legalSurname);
        assertEquals( peopleTest[0].middleNames, person1.middleNames);
        assertEquals( peopleTest[0].previousSurname, person1.previousSurname);
        assertEquals( peopleTest[0].dob, person1.dob);
        assertEquals( peopleTest[0].genderId, person1.gender.id);
        assertEquals( peopleTest[0].addressId, person1.address.id);
        assertEquals( peopleTest[0].home, person1.home);
        assertEquals( peopleTest[0].mobile, person1.mobile);
        assertEquals( peopleTest[0].work, person1.work);
        assertEquals( peopleTest[0].email, person1.email);
    }
    
    
    @Test
    public void testEquals_Different(){
        PersonDto personDto1 = new PersonDto(person1)
        PersonDto personDto2 = new PersonDto(person2)
        assertNotEquals(personDto1, personDto2)
    }
    
    @Test
    public void testEquals_Same() {
        PersonDto personDto1 = new PersonDto(person1)
        PersonDto personDto2 = new PersonDto(person1)
        assertEquals(personDto1, personDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        PersonDto personDto1 = new PersonDto(person1)
        PersonDto personDto2 = new PersonDto(person1)
        assertEquals(personDto1.hashCode(), personDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different(){
        PersonDto personDto1 = new PersonDto(person1)
        PersonDto personDto2 = new PersonDto(person2)
        assertNotEquals(personDto1.hashCode(), personDto2.hashCode())
    }
    
    @Test
    public void testMethod_Get_NullTitleDescription() {
        PersonDto personDto1 = new PersonDto(person3)
        assertEquals(personDto1.title, personDto1.get_TitleDescription())
    }
    
    @Test
    public void testMethod_Get_TitleDescription() {
        PersonDto personDto1 = new PersonDto(person1)
        assertEquals(personDto1.title.description, personDto1.get_TitleDescription())
    }
    
    @Test
    public void testMethod_Get_NullGenderCode() {
        PersonDto personDto1 = new PersonDto(person3)
        assertEquals(personDto1.gender, personDto1.get_GenderCode())
    }
    
    @Test
    public void testMethod_Get_GenderCode() {
        PersonDto personDto1 = new PersonDto(person1)
        assertEquals(personDto1.gender.code, personDto1.get_GenderCode())
    }
    
    @Test
    public void testMethod_Get_NullLegalSexCode() {
        PersonDto personDto1 = new PersonDto(person3)
        assertEquals(personDto1.legalSex, personDto1.get_LegalSexCode())
    }
    
    @Test
    public void testMethod_Get_LegalSexCode() {
        PersonDto personDto1 = new PersonDto(person1)
        assertEquals(personDto1.legalSex.code, personDto1.get_LegalSexCode())
    }
}