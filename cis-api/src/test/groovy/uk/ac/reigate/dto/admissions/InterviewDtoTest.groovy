package uk.ac.reigate.dto.admissions;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Address
import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.School
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.admissions.OfferType
import uk.ac.reigate.domain.lookup.Gender
import uk.ac.reigate.domain.lookup.LegalSex
import uk.ac.reigate.domain.lookup.StudentType
import uk.ac.reigate.domain.lookup.Title

public class InterviewDtoTest {
    
    private Student student
    
    private StudentYear studentYear
    
    private Student student1
    
    private StudentYear studentYear1
    
    private List<Student> students
    
    private Address address
    
    private Person person
    
    @Before
    public void setup() {
        this.address = new Address(1, 'Flat D', 'Stag', 'Stanley', 'west', 'park', 'Wallington', '', 'E161FF', '', '')
        this.person = new Person(
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
                username: 'vbm')
        student = new Student(
                id: 1,
                person: person,
                school: new School(id:1),
                interviewer : new Staff(id:1 ),
                interviewDate: new SimpleDateFormat("yyyy/MM/dd").parse('1991/01/31'),
                offerType : new OfferType(id:1, code: 'A', description: 'offered' ),
                );
        studentYear = new StudentYear(
                student: new Student(id:1 ),
                studentType : new StudentType(id:1, code: 'A', description: 'Active')
                );
        student1 = new Student(
                id: 1,
                person: person,
                school: new School(id:1),
                interviewer : null,
                interviewDate: new SimpleDateFormat("yyyy/MM/dd").parse('1991/01/31'),
                offerType : null
                );
        studentYear1 = new StudentYear(
                student: new Student(id:1 ),
                studentType : null
                );
    }
    
    @Test
    void testConstructor_interviewDto() {
        InterviewDto interviewDto = new InterviewDto( student, studentYear )
        assertEquals( interviewDto.studentId, student.id);
        assertEquals( interviewDto.surname, student.person.surname);
        assertEquals( interviewDto.middleNames, student.person.middleNames);
        assertEquals( interviewDto.dob, student.person.dob);
        assertEquals( interviewDto.school, student.school);
        assertEquals( interviewDto.studentTypeId, studentYear.studentType.id);
    }
    
    @Test
    void testConstructor_NullDto() {
        InterviewDto interviewDto = new InterviewDto( student1, studentYear1 )
        assertEquals( interviewDto.studentId, student1.id);
        assertEquals( interviewDto.surname, student1.person.surname);
        assertEquals( interviewDto.middleNames, student1.person.middleNames);
        assertEquals( interviewDto.dob, student1.person.dob);
        assertEquals( interviewDto.school, student1.school);
        assertEquals( interviewDto.studentTypeId, null);
    }
    
    @Test
    public void testMethod_Get_OfferTypeDescription() {
        InterviewDto interviewDto = new InterviewDto(student, studentYear)
        assertEquals(interviewDto.offerType.description, interviewDto.get_OfferTypeDescription())
    }
    
    @Test
    public void testMethod_Get_NullOfferTypeDescription() {
        InterviewDto interviewDto = new InterviewDto(student1, studentYear)
        assertEquals(interviewDto.offerType, interviewDto.get_OfferTypeDescription())
    }
    
    @Test
    public void testMethod_Get_StudentTypeDescription() {
        InterviewDto interviewDto = new InterviewDto(student, studentYear)
        assertEquals(interviewDto.studentType.description, interviewDto.get_StudentTypeDescription())
    }
    
    @Test
    public void testMethod_Get_NullStudentTypeDescription() {
        InterviewDto interviewDto = new InterviewDto(student, studentYear1)
        assertEquals(interviewDto.studentType, interviewDto.get_StudentTypeDescription())
    }
}
