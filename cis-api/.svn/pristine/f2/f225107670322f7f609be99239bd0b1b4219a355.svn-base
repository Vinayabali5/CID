package uk.ac.reigate.dto.admissions;

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Address
import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.School
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.lookup.Gender
import uk.ac.reigate.domain.lookup.LegalSex
import uk.ac.reigate.domain.lookup.Title

import static org.junit.Assert.*

public class ApplicationNewFormDtoTest {
    
    private Student student1
    
    private Student student2
    
    private Student student3
    
    private List<Student> students
    
    private Address address
    
    private Person person1
    
    private Person person2
    
    @Before
    public void setup() {
        this.address = new Address(1, 'Flat D', 'Stag', 'Stanley', 'west', 'park', 'Wallington', '', 'E161FF', '', '')
        this.person1 = new Person(
                id: 1,
                title: new Title(id:1),
                firstName: 'John',
                preferredName: 'Jon',
                surname: 'Smith',
                legalSurname: 'Smiths',
                middleNames: 'Anon',
                previousSurname: 'Jones',
                dob: new SimpleDateFormat("yyyy/MM/dd").parse('1991/01/31'),
                gender: new Gender(id:1),
                legalSex: new LegalSex(id:1),
                address : address,
                home: '0123456789',
                mobile: '0123456789',
                work: '0123456789',
                email: 'john.smith@gmail.com',
                enabled: true,
                roles: null,
                username: 'vbm');
        this.person2 = new Person(
                id: 1,
                title: null,
                firstName: 'John',
                preferredName: 'Jon',
                surname: 'Smith',
                legalSurname: 'Smiths',
                middleNames: 'Anon',
                previousSurname: 'Jones',
                dob: null,
                gender: null,
                legalSex: null,
                address : address,
                home: '0123456789',
                mobile: '0123456789',
                work: '0123456789',
                email: 'john.smith@gmail.com',
                enabled: true,
                roles: null,
                username: 'vbm')
        student1 = new Student(
                id: 1,
                person: person1,
                admissionsNotes: 'test',
                school : new School(id:1),
                academicYear : new AcademicYear(id:1)
                );
        student2 = new Student(
                id: 2,
                person: person1,
                admissionsNotes: 'test',
                );
        student3 = new Student(
                id: 1,
                person: person2,
                admissionsNotes: 'test',
                school : null,
                academicYear : null
                );
        students = Arrays.asList(student1, student2);
    }
    
    @Test
    void testConstructor_applicationForm() {
        ApplicationNewFormDto applicationFormDto = new ApplicationNewFormDto( student1)
        assertEquals( applicationFormDto.id, student1.id);
        assertEquals( applicationFormDto.admissionsNotes, student1.admissionsNotes);
        assertEquals( applicationFormDto.referenceNo, student1.referenceNo);
        assertEquals( applicationFormDto.dob, student1.person.dob);
        assertEquals( applicationFormDto.legalSexId, student1.person.legalSex.id);
        assertEquals( applicationFormDto.genderId, student1.person.gender.id);
        assertEquals( applicationFormDto.titleId, student1.person.title.id);
    }
    
    @Test
    void testConstructor_NullApplicationForm() {
        ApplicationNewFormDto applicationFormDto = new ApplicationNewFormDto( student3)
        assertEquals( applicationFormDto.id, student1.id);
        assertEquals( applicationFormDto.admissionsNotes, student1.admissionsNotes);
        assertEquals( applicationFormDto.referenceNo, student1.referenceNo);
        assertEquals( applicationFormDto.dob, null);
        assertEquals( applicationFormDto.legalSexId, null);
        assertEquals( applicationFormDto.genderId, null);
        assertEquals( applicationFormDto.titleId, null);
    }
    
    @Test
    public void testMapFromStudentEntity(){
        ApplicationNewFormDto studentTest = ApplicationNewFormDto.mapFromEntity( student1 )
        assertEquals( studentTest.id, student1.id );
        assertEquals( studentTest.admissionsNotes, student1.admissionsNotes );
        assertEquals( studentTest.referenceNo, student1.referenceNo );
        assertEquals( studentTest.dob, student1.person.dob );
        assertEquals( studentTest.legalSexId, student1.person.legalSex.id );
        assertEquals( studentTest.genderId, student1.person.gender.id );
        assertEquals( studentTest.titleId, student1.person.title.id );
    }
    
    @Test
    public void testMapFromStudentsEntities(){
        List<ApplicationNewFormDto> applicationNewFormDtoTest = ApplicationNewFormDto.mapFromList( students )
        assertEquals( applicationNewFormDtoTest[0].id, student1.id );
        assertEquals( applicationNewFormDtoTest[0].admissionsNotes, student1.admissionsNotes );
        assertEquals( applicationNewFormDtoTest[0].referenceNo, student1.referenceNo );
        assertEquals( applicationNewFormDtoTest[0].dob, student1.person.dob );
        assertEquals( applicationNewFormDtoTest[0].legalSexId, student1.person.legalSex.id );
        assertEquals( applicationNewFormDtoTest[0].genderId, student1.person.gender.id );
        assertEquals( applicationNewFormDtoTest[0].titleId, student1.person.title.id );
        assertEquals( applicationNewFormDtoTest[1].id, student2.id );
        assertEquals( applicationNewFormDtoTest[1].admissionsNotes, student2.admissionsNotes );
        assertEquals( applicationNewFormDtoTest[1].referenceNo, student2.referenceNo );
        assertEquals( applicationNewFormDtoTest[1].dob, student2.person.dob );
        assertEquals( applicationNewFormDtoTest[1].legalSexId, student2.person.legalSex.id );
        assertEquals( applicationNewFormDtoTest[1].genderId, student2.person.gender.id );
        assertEquals( applicationNewFormDtoTest[1].titleId, student2.person.title.id );
    }
    
    @Test
    public void testEquals_Same() {
        ApplicationNewFormDto applicationNewFormDto1 = new ApplicationNewFormDto(student1)
        ApplicationNewFormDto applicationNewFormDto2 = new ApplicationNewFormDto(student1)
        assertEquals(applicationNewFormDto1, applicationNewFormDto2)
    }
    
    @Test
    public void testEquals_Different() {
        ApplicationNewFormDto applicationNewFormDto1 = new ApplicationNewFormDto(student1)
        ApplicationNewFormDto applicationNewFormDto2 = new ApplicationNewFormDto(student2)
        assertNotEquals(applicationNewFormDto1, applicationNewFormDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        ApplicationNewFormDto applicationNewFormDto1 = new ApplicationNewFormDto(student1)
        ApplicationNewFormDto applicationNewFormDto2 = new ApplicationNewFormDto(student1)
        assertEquals(applicationNewFormDto1.hashCode(), applicationNewFormDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        ApplicationNewFormDto applicationNewFormDto1 = new ApplicationNewFormDto(student1)
        ApplicationNewFormDto applicationNewFormDto2 = new ApplicationNewFormDto(student2)
        assertNotEquals(applicationNewFormDto1.hashCode(), applicationNewFormDto2.hashCode())
    }
}
