package uk.ac.reigate.dto.search

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.School
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.admissions.ApplicationStatus
import uk.ac.reigate.domain.lookup.TutorGroup

class StudentSearchDtoTest {
    
    private Student student1
    
    private Student student2
    
    private StudentYear studentYear
    
    Person createPerson() {
        Person person = new Person(
                id: 1,
                firstName : 'Vinaya',
                surname : 'Bali',
                preferredName: 'vin',
                middleNames : 'uday',
                previousSurname: 'bal',
                legalSurname : 'bennikuppe'
                )
    }
    
    Person createPerson2() {
        Person person = new Person(
                id: 1,
                firstName : 'Vinaya',
                surname : 'Bali',
                preferredName: null,
                middleNames : null,
                previousSurname: null,
                legalSurname : null
                )
    }
    
    @Before
    public void setup() {
        this.student1 = new Student(
                id: 190001,
                referenceNo :'190001',
                person : createPerson(),
                school : new School(id: 1),
                status: new ApplicationStatus(id: 1)
                )
        this.student2 = new Student(
                id: 190002,
                referenceNo :'190001',
                person : createPerson2(),
                school : new School(id: 1),
                status: null
                
                )
        this.studentYear = new StudentYear(
                year : new AcademicYear(id: 18),
                endDate : new SimpleDateFormat("yyyy/MM/dd").parse('2014/09/01'),
                candidateNo : 190001,
                tutorGroup: new TutorGroup(id: 1)
                )
    }
    
    @Test
    public void testDefaultConstructor() {
        StudentSearchDto dto = new StudentSearchDto()
        assertEquals( dto.academicYearId, null);
        assertEquals( dto.studentId, null);
        assertEquals( dto.studentReference, '')
        assertEquals( dto.studentName, '')
        assertEquals( dto.studentType, '')
        assertEquals( dto.studentSchool, '')
        assertEquals( dto.endDate, null)
        assertEquals( dto.tutorGroup, '')
    }
    
    @Test
    public void testConstructor() {
        StudentSearchDto dto = new StudentSearchDto(student1, studentYear)
        assertEquals( dto.academicYearId, studentYear.year.id);
        assertEquals( dto.studentId, student1.id);
        assertEquals( dto.studentReference, student1.referenceNo)
    }
    
    @Test
    public void testConstructorNullObject() {
        StudentSearchDto dto = new StudentSearchDto(student2, studentYear)
        assertEquals( dto.academicYearId, studentYear.year.id);
        assertEquals( dto.studentId, student2.id);
        assertEquals( dto.studentReference, student2.referenceNo)
    }
}
