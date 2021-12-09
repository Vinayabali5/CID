package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.ilp.StudentRelatedStaff

public class StudentRelatedStaffDtoTest {
    
    private StudentRelatedStaff studentRelatedStaff1
    
    private StudentRelatedStaff studentRelatedStaff2
    
    private StudentRelatedStaff studentRelatedStaff3
    
    private List<StudentRelatedStaff> studentRelatedStaffs
    
    @Before
    public void setup() {
        this.studentRelatedStaff1 = new StudentRelatedStaff(
                student: new Student(id:190001),
                staff: new Staff(id:1),
                staffInitials: 'A',
                staffName: 'Amy',
                relationship: 'staff',
                );
        this.studentRelatedStaff2 = new StudentRelatedStaff(
                student: new Student(id:190004),
                staff: new Staff(id:1),
                staffInitials: 'B',
                staffName: 'Alex',
                relationship: 'staff',
                );
        this.studentRelatedStaff3 = new StudentRelatedStaff(
                student: null,
                staff: null,
                staffInitials: 'A',
                staffName: 'Amy',
                relationship: 'staff',
                );
        this.studentRelatedStaffs = Arrays.asList(this.studentRelatedStaff1, this.studentRelatedStaff2);
    }
    
    @Test
    void testConstructor_studentRelatedStaff() {
        StudentRelatedStaffDto studentRelatedStaffTest = new StudentRelatedStaffDto( studentRelatedStaff1 )
        assertEquals( studentRelatedStaffTest.studentId, studentRelatedStaff1.student.id );
        assertEquals( studentRelatedStaffTest.staffInitials, studentRelatedStaff1.staffInitials);
        assertEquals( studentRelatedStaffTest.staffName, studentRelatedStaff1.staffName);
    }
    
    @Test
    public void testMapFromStudentRelatedStaffEntity(){
        StudentRelatedStaffDto studentRelatedStaffTest = StudentRelatedStaffDto.mapFromEntity( studentRelatedStaff1 )
        assertEquals( studentRelatedStaffTest.studentId, studentRelatedStaff1.student.id );
        assertEquals( studentRelatedStaffTest.staffInitials, studentRelatedStaff1.staffInitials);
        assertEquals( studentRelatedStaffTest.staffName, studentRelatedStaff1.staffName);
    }
    
    @Test
    public void testMapFromStudentRelatedStaffsEntities(){
        List<StudentRelatedStaffDto> studentRelatedStaffsTest = StudentRelatedStaffDto.mapFromList( this.studentRelatedStaffs )
        assertEquals( studentRelatedStaffsTest[0].studentId, studentRelatedStaff1.student.id );
        assertEquals( studentRelatedStaffsTest[0].staffInitials, studentRelatedStaff1.staffInitials );
        assertEquals( studentRelatedStaffsTest[0].staffName, studentRelatedStaff1.staffName);
        assertEquals( studentRelatedStaffsTest[1].studentId, studentRelatedStaff2.student.id );
        assertEquals( studentRelatedStaffsTest[1].staffInitials, studentRelatedStaff2.staffInitials );
        assertEquals( studentRelatedStaffsTest[1].staffName, studentRelatedStaff2.staffName);
    }
    
    @Test
    public void testEquals_Same() {
        StudentRelatedStaffDto studentRelatedStaffDto1 = new StudentRelatedStaffDto(studentRelatedStaff1)
        StudentRelatedStaffDto studentRelatedStaffDto2 = new StudentRelatedStaffDto(studentRelatedStaff1)
        assertEquals( studentRelatedStaffDto1, studentRelatedStaffDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StudentRelatedStaffDto studentRelatedStaffDto1 = new StudentRelatedStaffDto(studentRelatedStaff1)
        StudentRelatedStaffDto studentRelatedStaffDto2 = new StudentRelatedStaffDto(studentRelatedStaff2)
        assertNotEquals( studentRelatedStaffDto1, studentRelatedStaffDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentRelatedStaffDto studentRelatedStaffDto1 = new StudentRelatedStaffDto(studentRelatedStaff1)
        StudentRelatedStaffDto studentRelatedStaffDto2 = new StudentRelatedStaffDto(studentRelatedStaff1)
        assertEquals( studentRelatedStaffDto1.hashCode(), studentRelatedStaffDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StudentRelatedStaffDto studentRelatedStaffDto1 = new StudentRelatedStaffDto(studentRelatedStaff1)
        StudentRelatedStaffDto studentRelatedStaffDto2 = new StudentRelatedStaffDto(studentRelatedStaff2)
        assertNotEquals( studentRelatedStaffDto1.hashCode(), studentRelatedStaffDto2.hashCode())
    }
    
    @Test
    public void testConstructor_StudentRelatedStaff() {
        StudentRelatedStaffDto studentRelatedStaffDto = new StudentRelatedStaffDto(studentRelatedStaff1)
        assertEquals( studentRelatedStaffDto.staffInitials, studentRelatedStaff1.staffInitials )
        assertEquals( studentRelatedStaffDto.staffName, studentRelatedStaff1.staffName )
        assertEquals( studentRelatedStaffDto.relationship, studentRelatedStaff1.relationship )
    }
    
    @Test
    public void testConstructor_NullStudent() {
        StudentRelatedStaffDto studentRelatedStaffDto = new StudentRelatedStaffDto(studentRelatedStaff3)
        assertEquals( studentRelatedStaffDto.staffInitials, studentRelatedStaff3.staffInitials )
        assertEquals( studentRelatedStaffDto.staffName, studentRelatedStaff3.staffName )
        assertEquals( studentRelatedStaffDto.relationship, studentRelatedStaff3.relationship )
    }
    
    @Test
    public void testConstructor_NullStudentRelatedStaff() {
        StudentRelatedStaff studentRelatedStaff = null
        StudentRelatedStaffDto studentRelatedStaffDto = new StudentRelatedStaffDto(studentRelatedStaff)
        assertEquals( studentRelatedStaff, null)
    }
}
