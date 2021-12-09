package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.security.InvalidParameterException
import static org.assertj.core.api.Assertions.assertThatExceptionOfType

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.lookup.BursaryType

public class StudentBursaryDtoTest {
    
    private StudentYear studentYear1
    
    private StudentYear studentYear2
    
    private StudentYear studentYear3
    
    private List<StudentYear> studentYears
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Before
    public void setup() {
        this.studentYear1 = new StudentYear(
                student: new Student(id:190001),
                year: new AcademicYear(id:18),
                bursaryType: new BursaryType(id:1),
                gb: true,
                db: true,
                freeMealsEligibility: true,
                receivingFreeMeals: false,
                removedFromFreeMeals: true
                );
        this.studentYear2 = new StudentYear(
                student: new Student(id:190003),
                year: new AcademicYear(id:18),
                bursaryType: new BursaryType(id:1),
                gb: true,
                db: true,
                freeMealsEligibility: true,
                receivingFreeMeals: false,
                removedFromFreeMeals: true
                );
        this.studentYear3 = new StudentYear(
                student: null,
                year: null,
                bursaryType: null,
                gb: null,
                db: null,
                freeMealsEligibility: null,
                receivingFreeMeals: null,
                removedFromFreeMeals: null
                );
        this.studentYears = Arrays.asList(studentYear1, studentYear2);
    }
    
    @Test
    void testConstructor_Nullstudent() {
        StudentBursaryDto studentBursaryDto = new StudentBursaryDto( studentYear3 )
        assertEquals( studentBursaryDto.studentId, studentYear3.student);
        assertEquals( studentBursaryDto.gb, studentYear3.gb);
        assertEquals( studentBursaryDto.db, studentYear3.db);
        assertEquals( studentBursaryDto.freeMealsEligibility, studentYear3.freeMealsEligibility);
        assertEquals( studentBursaryDto.receivingFreeMeals, studentYear3.receivingFreeMeals);
    }
    
    @Test
    void testConstructor_student() {
        StudentBursaryDto studentBursaryDto = new StudentBursaryDto( studentYear1 )
        assertEquals( studentBursaryDto.studentId, studentYear1.student.id);
        assertEquals( studentBursaryDto.gb, studentYear1.gb);
        assertEquals( studentBursaryDto.db, studentYear1.db);
        assertEquals( studentBursaryDto.freeMealsEligibility, studentYear1.freeMealsEligibility);
        assertEquals( studentBursaryDto.receivingFreeMeals, studentYear1.receivingFreeMeals);
    }
    
    @Test
    public void testMapFromStudentEntity(){
        StudentBursaryDto studentTest = StudentBursaryDto.mapFromStudentBursaryEntity( studentYear1 )
        assertEquals( studentTest.studentId, studentYear1.student.id );
    }
    
    @Test
    public void testEquals_Same() {
        StudentBursaryDto studentBursaryDto1 = new StudentBursaryDto(studentYear1)
        StudentBursaryDto studentBursaryDto2 = new StudentBursaryDto(studentYear1)
        assertEquals(studentBursaryDto1, studentBursaryDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StudentBursaryDto studentBursaryDto1 = new StudentBursaryDto(studentYear1)
        StudentBursaryDto studentBursaryDto2 = new StudentBursaryDto(studentYear2)
        assertNotEquals(studentBursaryDto1, studentBursaryDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentBursaryDto studentBursaryDto1 = new StudentBursaryDto(studentYear1)
        StudentBursaryDto studentBursaryDto2 = new StudentBursaryDto(studentYear1)
        assertEquals(studentBursaryDto1.hashCode(), studentBursaryDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StudentBursaryDto studentBursaryDto1 = new StudentBursaryDto(studentYear1)
        StudentBursaryDto studentBursaryDto2 = new StudentBursaryDto(studentYear2)
        assertNotEquals(studentBursaryDto1.hashCode(), studentBursaryDto2.hashCode())
    }
    
    @Test
    public void testConstructor_StudentBursary() {
        StudentYear studentYear = null
        StudentBursaryDto studentBursaryDto = new StudentBursaryDto(studentYear)
        assertEquals(studentYear, null)
    }
    
    @Test
    public void testMethod_Get_NullBursaryTypeDescription() {
        StudentBursaryDto studentBursaryDto1 = new StudentBursaryDto(studentYear3)
        assertEquals(studentBursaryDto1.bursaryType, studentBursaryDto1.get_BursaryTypeDescription())
    }
    
    @Test
    public void testMethod_Get_BursaryTypeDescription() {
        StudentBursaryDto studentBursaryDto1 = new StudentBursaryDto(studentYear1)
        assertEquals(studentBursaryDto1.bursaryType.description, studentBursaryDto1.get_BursaryTypeDescription())
    }
}
