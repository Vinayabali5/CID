package uk.ac.reigate.dto.integration

import static org.junit.Assert.*
import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Address
import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.academic.School
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.lookup.Ethnicity
import uk.ac.reigate.domain.lookup.Gender
import uk.ac.reigate.domain.lookup.Title

class ApplicationImportDTOTest {
    
    private Student student1
    
    private Student student2
    
    Student createStudent() {
        Student student = new Student(
                id: 190001,
                person: createPerson(),
                countryOfResidence : 'UK',
                school: new School(id: 1, name: 'Reigate school'),
                ehcp: true,
                ethnicity: new Ethnicity(id: 1, code: 'Asian/Indian')
                )
    }
    
    Student createStudent2() {
        Student student = new Student(
                id: 190001,
                person: createPerson2(),
                countryOfResidence : 'UK',
                school: null,
                ehcp: true,
                ethnicity: null
                )
    }
    
    School createSchool() {
        School school = new School(
                id: 1,
                name: 'Reigate School',
                urn : '34737483',
                ukprn : '34324343'
                )
    }
    Address createAddress() {
        Address address = new Address(
                line1: 'Test',
                line2: 'line1',
                line3: 'Line3',
                line4: 'coulsdon',
                line5: 'london',
                postcode: 'Cr53Fr'
                )
    }
    
    Person createPerson2() {
        Person person = new Person(
                id: 1,
                firstName : 'Vinaya',
                surname : 'Bali',
                middleNames : 'mv',
                preferredName : 'Vin',
                previousSurname: 'Bali',
                dob : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                gender: null,
                title : null,
                home: '07829387923',
                mobile : '8374983723',
                email : 'mbvinaya@gmail.com',
                address : null
                )
    }
    
    Person createPerson() {
        Person person = new Person(
                id: 1,
                firstName : 'Vinaya',
                surname : 'Bali',
                middleNames : 'mv',
                preferredName : 'Vin',
                previousSurname: 'Bali',
                dob : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                gender: new Gender(id: 2, code: 'Male'),
                title : new Title(id: 1, code:'Mr'),
                home: '07829387923',
                mobile : '8374983723',
                email : 'mbvinaya@gmail.com',
                address : createAddress()
                )
    }
    
    @Before
    public void setup() {
        this.student1 = createStudent()
        this.student2 = createStudent2()
    }
    
    @Test
    public void testConstructor() {
        ApplicationImportDTO applicationImportDTO = new ApplicationImportDTO(student1)
        assertEquals( applicationImportDTO.id, student1.id);
        assertEquals( applicationImportDTO.firstName, student1.person.firstName);
        assertEquals( applicationImportDTO.surname, student1.person.surname);
        assertEquals( applicationImportDTO.middleNames, student1.person.middleNames);
        assertEquals( applicationImportDTO.preferredName, student1.person.preferredName);
        assertEquals( applicationImportDTO.previousSurname, student1.person.previousSurname);
        assertEquals( applicationImportDTO.genderCode, student1.person.gender.code);
        assertEquals( applicationImportDTO.title, student1.person.title.code);
        assertEquals( applicationImportDTO.home, student1.person.home);
        assertEquals( applicationImportDTO.mobile, student1.person.mobile);
        assertEquals( applicationImportDTO.countryOfResidence, student1.countryOfResidence);
        assertEquals( applicationImportDTO.schoolName, student1.school.name);
        assertEquals( applicationImportDTO.schoolUrn, student1.school.urn);
        assertEquals( applicationImportDTO.schoolUkprn, student1.school.ukprn);
        assertEquals( applicationImportDTO.ehcp, student1.ehcp);
        assertEquals( applicationImportDTO.ethnicityCode, student1.ethnicity.code);
    }
    
    @Test
    public void testConstructorNullPerson() {
        ApplicationImportDTO applicationImportDTO = new ApplicationImportDTO(student2)
        assertEquals( applicationImportDTO.id, student2.id);
        assertEquals( applicationImportDTO.firstName, student2.person.firstName);
        assertEquals( applicationImportDTO.surname, student2.person.surname);
        assertEquals( applicationImportDTO.middleNames, student2.person.middleNames);
        assertEquals( applicationImportDTO.preferredName, student2.person.preferredName);
        assertEquals( applicationImportDTO.previousSurname, student2.person.previousSurname);
        assertEquals( applicationImportDTO.genderCode, student2.person.gender);
        assertEquals( applicationImportDTO.title, student2.person.title);
        assertEquals( applicationImportDTO.home, student2.person.home);
        assertEquals( applicationImportDTO.mobile, student2.person.mobile);
        assertEquals( applicationImportDTO.countryOfResidence, student2.countryOfResidence);
        assertEquals( applicationImportDTO.schoolName, student2.school);
        assertEquals( applicationImportDTO.schoolUrn, student2.school);
        assertEquals( applicationImportDTO.schoolUkprn, student2.school);
        assertEquals( applicationImportDTO.ehcp, student2.ehcp);
        assertEquals( applicationImportDTO.ethnicityCode, student2.ethnicity);
    }
}
