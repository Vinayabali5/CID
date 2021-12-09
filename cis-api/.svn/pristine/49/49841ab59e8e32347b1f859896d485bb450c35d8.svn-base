package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.ilr.RestrictedUseIndicator

public class StudentDataSharingOptionsDtoTest {
    
    private Student student1
    
    private Student student2
    
    private Student student3
    
    private StudentDataSharingOptionsDto studentDataSharingOptionsDto
    
    private List<Student> students
    
    @Before
    public void setup() {
        student1 = new Student(
                id: 1,
                restrictedUseIndicator: new RestrictedUseIndicator(id:1),
                contactByPost: true,
                contactByPhone: true,
                contactByEmail: true,
                lrsOptOut: false
                );
        student2 = new Student(
                id: 2,
                restrictedUseIndicator: new RestrictedUseIndicator(id:1),
                contactByPost: true,
                contactByPhone: true,
                contactByEmail: true,
                lrsOptOut: false
                );
        student3 = new Student(
                id: 2,
                restrictedUseIndicator: null,
                contactByPost: true,
                contactByPhone: true,
                contactByEmail: true,
                lrsOptOut: false
                );
        students = Arrays.asList(student1, student2);
    }
    
    @Test
    public void testEquals_Same() {
        StudentDataSharingOptionsDto studentAdmissionDto1 = new StudentDataSharingOptionsDto(student1)
        StudentDataSharingOptionsDto studentAdmissionDto2 = new StudentDataSharingOptionsDto(student1)
        assertEquals(studentAdmissionDto1, studentAdmissionDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StudentDataSharingOptionsDto studentAdmissionDto1 = new StudentDataSharingOptionsDto(student1)
        StudentDataSharingOptionsDto studentAdmissionDto2 = new StudentDataSharingOptionsDto(student2)
        assertNotEquals(studentAdmissionDto1, studentAdmissionDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentDataSharingOptionsDto studentAdmissionDto1 = new StudentDataSharingOptionsDto(student1)
        StudentDataSharingOptionsDto studentAdmissionDto2 = new StudentDataSharingOptionsDto(student1)
        assertEquals(studentAdmissionDto1.hashCode(), studentAdmissionDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StudentDataSharingOptionsDto studentAdmissionDto1 = new StudentDataSharingOptionsDto(student1)
        StudentDataSharingOptionsDto studentAdmissionDto2 = new StudentDataSharingOptionsDto(student2)
        assertNotEquals(studentAdmissionDto1.hashCode(), studentAdmissionDto2.hashCode())
    }
    
    @Test
    public void testConstructor_Student() {
        StudentDataSharingOptionsDto studentAdmissionDto = new StudentDataSharingOptionsDto(student1)
        assertEquals( studentAdmissionDto.restrictedUseIndicatorId, student1.restrictedUseIndicator.id )
        assertEquals( studentAdmissionDto.contactByPost, student1.contactByPost )
        assertEquals( studentAdmissionDto.contactByPhone, student1.contactByPhone )
        assertEquals( studentAdmissionDto.contactByEmail, student1.contactByEmail )
        assertEquals( studentAdmissionDto.lrsOptOut, student1.lrsOptOut )
    }
    
    @Test
    public void testConstructor_NullRestrictedUseIndicator() {
        StudentDataSharingOptionsDto studentAdmissionDto = new StudentDataSharingOptionsDto(student3)
        assertEquals( studentAdmissionDto.restrictedUseIndicatorId, student3.restrictedUseIndicator )
        assertEquals( studentAdmissionDto.contactByPost, student3.contactByPost )
        assertEquals( studentAdmissionDto.contactByPhone, student3.contactByPhone )
        assertEquals( studentAdmissionDto.contactByEmail, student3.contactByEmail )
        assertEquals( studentAdmissionDto.lrsOptOut, student3.lrsOptOut )
    }
    
    @Test
    public void testConstructor_updateStudentDataSharing() {
        Student student = new Student(id:1)
        StudentDataSharingOptionsDto studentAdmissionDto = new StudentDataSharingOptionsDto(student1)
        RestrictedUseIndicator restrictedUseIndicator = new RestrictedUseIndicator(id:1)
        Student updateStudentDataSharing = StudentDataSharingOptionsDto.updateStudentDataSharing(student, studentAdmissionDto, restrictedUseIndicator)
        assertEquals( updateStudentDataSharing.restrictedUseIndicator, student.restrictedUseIndicator )
        assertEquals( updateStudentDataSharing.contactByPost, student.contactByPost )
        assertEquals( updateStudentDataSharing.contactByPhone, student.contactByPhone )
        assertEquals( updateStudentDataSharing.contactByEmail, student.contactByEmail )
        assertEquals( updateStudentDataSharing.lrsOptOut, student.lrsOptOut )
    }
    
    @Test
    public void testConstructor_NullStudent() {
        Student student = null
        StudentDataSharingOptionsDto studentAdmissionDto = new StudentDataSharingOptionsDto(student)
        assertEquals( student, null )
    }
    
    @Test
    public void testConstructor_StudentDto() {
        StudentDataSharingOptionsDto studentAdmissionDto = new StudentDataSharingOptionsDto(190001, new RestrictedUseIndicator(id:1), true, true, true, false)
        assertEquals( studentAdmissionDto.restrictedUseIndicatorId, student1.restrictedUseIndicator.id )
        assertEquals( studentAdmissionDto.contactByPost, student1.contactByPost )
        assertEquals( studentAdmissionDto.contactByPhone, student1.contactByPhone )
        assertEquals( studentAdmissionDto.contactByEmail, student1.contactByEmail )
        assertEquals( studentAdmissionDto.lrsOptOut, student1.lrsOptOut )
    }
}