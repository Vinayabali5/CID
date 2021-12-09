package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.learning_support.ReferralReason
import uk.ac.reigate.domain.learning_support.StudentReferralReason

public class StudentReferralReasonDtoTest {
    
    private StudentReferralReason studentReferralReason1
    
    private StudentReferralReason studentReferralReason2
    
    private StudentReferralReason studentReferralReason3
    
    private List<StudentReferralReason> studentReferralReasons
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    ReferralReason createReferralReason() {
        ReferralReason referralReason = new ReferralReason()
        referralReason.id = 1
        return referralReason
    }
    
    @Before
    public void setup() {
        studentReferralReason1 = new StudentReferralReason(
                id: 1,
                student: createStudent(),
                referralReason:createReferralReason(),
                primary:true
                );
        studentReferralReason2 = new StudentReferralReason(
                id: 2,
                student: createStudent(),
                referralReason:createReferralReason(),
                primary:true
                );
        studentReferralReason3 = new StudentReferralReason(
                id: 2,
                student: createStudent(),
                referralReason: null,
                primary:true
                );
        studentReferralReasons = Arrays.asList(studentReferralReason1, studentReferralReason2);
    }
    
    @Test
    public void testMapFromStudentReferralReasonEntity(){
        StudentReferralReasonDto studentReferralReasonTest = StudentReferralReasonDto.mapFromEntity( studentReferralReason1 )
        assertEquals( studentReferralReasonTest.id, studentReferralReason1.id );
        assertEquals( studentReferralReasonTest.studentId, studentReferralReason1.student.id );
        assertEquals( studentReferralReasonTest.referralReasonId, studentReferralReason1.referralReason.id);
        assertEquals( studentReferralReasonTest.primary, studentReferralReason1.primary);
    }
    
    @Test
    public void testMapFromStudentReferralReasonsEntities(){
        List<StudentReferralReasonDto> studentReferralReasonsDtoTest = StudentReferralReasonDto.mapFromList( studentReferralReasons )
        assertEquals( studentReferralReasonsDtoTest[0].id, studentReferralReason1.id );
        assertEquals( studentReferralReasonsDtoTest[0].studentId, studentReferralReason1.student.id );
        assertEquals( studentReferralReasonsDtoTest[0].referralReasonId, studentReferralReason1.referralReason.id);
        assertEquals( studentReferralReasonsDtoTest[0].primary, studentReferralReason1.primary);
        assertEquals( studentReferralReasonsDtoTest[1].id, studentReferralReason2.id );
        assertEquals( studentReferralReasonsDtoTest[1].studentId, studentReferralReason2.student.id );
        assertEquals( studentReferralReasonsDtoTest[1].referralReasonId, studentReferralReason2.referralReason.id);
        assertEquals( studentReferralReasonsDtoTest[1].primary, studentReferralReason2.primary);
    }
    
    
    @Test
    public void testEquals_Same() {
        StudentReferralReasonDto studentReferralReasonDto1 = new StudentReferralReasonDto(studentReferralReason1)
        StudentReferralReasonDto studentReferralReasonDto2 = new StudentReferralReasonDto(studentReferralReason1)
        assertEquals(studentReferralReasonDto1, studentReferralReasonDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StudentReferralReasonDto studentReferralReasonDto1 = new StudentReferralReasonDto(studentReferralReason1)
        StudentReferralReasonDto studentReferralReasonDto2 = new StudentReferralReasonDto(studentReferralReason1)
        assertEquals(studentReferralReasonDto1, studentReferralReasonDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentReferralReasonDto studentReferralReasonDto1 = new StudentReferralReasonDto(studentReferralReason1)
        StudentReferralReasonDto studentReferralReasonDto2 = new StudentReferralReasonDto(studentReferralReason1)
        assertEquals(studentReferralReasonDto1.hashCode(), studentReferralReasonDto2.hashCode())
    }
    
    @Test
    public void testHashCodeDifferent() {
        StudentReferralReasonDto studentReferralReasonDto1 = new StudentReferralReasonDto(studentReferralReason1)
        StudentReferralReasonDto studentReferralReasonDto2 = new StudentReferralReasonDto(studentReferralReason1)
        assertEquals(studentReferralReasonDto1.hashCode(), studentReferralReasonDto2.hashCode())
    }
    
    
    @Test
    public void testConstructor_StudentReferralReason() {
        StudentReferralReasonDto studentReferralReasonDto = new StudentReferralReasonDto(studentReferralReason1)
        assertEquals( studentReferralReasonDto.id, studentReferralReason1.id )
        assertEquals( studentReferralReasonDto.referralReasonId, studentReferralReason1.referralReason.id )
        assertEquals( studentReferralReasonDto.primary, studentReferralReason1.primary )
    }
    
    @Test
    public void testConstructor_NullStudentReferralReason() {
        StudentReferralReason studentReferralReason = null
        StudentReferralReasonDto studentReferralReasonDto = new StudentReferralReasonDto(studentReferralReason)
        assertEquals( studentReferralReason, null )
    }
    
    @Test
    public void testMethod_Get_NullReferralReasonDescription() {
        StudentReferralReasonDto studentReferralReasonDto1 = new StudentReferralReasonDto(studentReferralReason3)
        assertEquals(studentReferralReasonDto1.referralReason, studentReferralReasonDto1.get_ReferralReasonDescription())
    }
    
    @Test
    public void testMethod_Get_ReferralReasonDescription() {
        StudentReferralReasonDto studentReferralReasonDto1 = new StudentReferralReasonDto(studentReferralReason1)
        assertEquals(studentReferralReasonDto1.referralReason.reason, studentReferralReasonDto1.get_ReferralReasonDescription())
    }
}
