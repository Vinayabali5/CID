package uk.ac.reigate.dto.risk_assessment;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.risk_assessment.StudentSafetyPlan


public class StudentSafetyPlanDtoTest {
    
    private StudentSafetyPlan studentSafetyPlan1
    
    private StudentSafetyPlan studentSafetyPlan2
    
    private StudentSafetyPlan studentSafetyPlan3
    
    private List<StudentSafetyPlan> studentSafetyPlans
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    Staff createStaff() {
        Staff staff = new Staff()
        staff.id = 1
        return staff
    }
    
    
    @Before
    public void setup() {
        studentSafetyPlan1 = new StudentSafetyPlan(
                id: 1,
                student: createStudent(),
                completedWith:createStaff(),
                dateCompleted: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                howToReduceRiskAtHome: 'test',
                warningSignsOrTriggers: 'test'
                );
        studentSafetyPlan2 = new StudentSafetyPlan(
                id: 2,
                student: createStudent(),
                completedWith:createStaff(),
                dateCompleted: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                howToReduceRiskAtHome: 'test',
                warningSignsOrTriggers: 'test'
                );
        studentSafetyPlan3 = new StudentSafetyPlan(
                id: 3,
                student: null,
                completedWith: null,
                dateCompleted: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                howToReduceRiskAtHome: 'test',
                warningSignsOrTriggers: 'test'
                );
        studentSafetyPlans = Arrays.asList(studentSafetyPlan1, studentSafetyPlan2);
    }
    
    @Test
    public void testMapFromStudentSafetyPlanEntity(){
        StudentSafetyPlanDto studentSafetyPlanTest = StudentSafetyPlanDto.mapFromEntity( studentSafetyPlan1 )
        assertEquals( studentSafetyPlanTest.studentId, studentSafetyPlan1.student.id );
        assertEquals( studentSafetyPlanTest.howToReduceRiskAtHome, studentSafetyPlan1.howToReduceRiskAtHome);
        assertEquals( studentSafetyPlanTest.completedWithId, studentSafetyPlan1.completedWith.id);
        assertEquals( studentSafetyPlanTest.dateCompleted, studentSafetyPlan1.dateCompleted)
        assertEquals( studentSafetyPlanTest.howToReduceRiskAtHome, studentSafetyPlan1.howToReduceRiskAtHome)
        assertEquals( studentSafetyPlanTest.warningSignsOrTriggers, studentSafetyPlan1.warningSignsOrTriggers)
    }
    
    @Test
    public void testMapFromStudentSafetyPlansEntities(){
        List<StudentSafetyPlanDto> studentSafetyPlanTest = StudentSafetyPlanDto.mapFromList( studentSafetyPlans )
        assertEquals( studentSafetyPlanTest[0].studentId, studentSafetyPlan1.student.id );
        assertEquals( studentSafetyPlanTest[0].howToReduceRiskAtHome, studentSafetyPlan1.howToReduceRiskAtHome);
        assertEquals( studentSafetyPlanTest[0].completedWithId, studentSafetyPlan1.completedWith.id);
        assertEquals( studentSafetyPlanTest[0].dateCompleted, studentSafetyPlan1.dateCompleted)
        assertEquals( studentSafetyPlanTest[0].howToReduceRiskAtHome, studentSafetyPlan1.howToReduceRiskAtHome)
        assertEquals( studentSafetyPlanTest[0].warningSignsOrTriggers, studentSafetyPlan1.warningSignsOrTriggers)
        assertEquals( studentSafetyPlanTest[1].studentId, studentSafetyPlan2.student.id );
        assertEquals( studentSafetyPlanTest[1].howToReduceRiskAtHome, studentSafetyPlan2.howToReduceRiskAtHome);
        assertEquals( studentSafetyPlanTest[1].completedWithId, studentSafetyPlan2.completedWith.id);
        assertEquals( studentSafetyPlanTest[1].dateCompleted, studentSafetyPlan2.dateCompleted)
        assertEquals( studentSafetyPlanTest[1].howToReduceRiskAtHome, studentSafetyPlan2.howToReduceRiskAtHome)
        assertEquals( studentSafetyPlanTest[1].warningSignsOrTriggers, studentSafetyPlan2.warningSignsOrTriggers)
    }
    
    
    @Test
    public void testEquals_Same() {
        StudentSafetyPlanDto studentSafetyPlanDto1 = new StudentSafetyPlanDto(studentSafetyPlan1)
        StudentSafetyPlanDto studentSafetyPlanDto2 = new StudentSafetyPlanDto(studentSafetyPlan1)
        assertEquals(studentSafetyPlanDto1, studentSafetyPlanDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentSafetyPlanDto studentSafetyPlanDto1 = new StudentSafetyPlanDto(studentSafetyPlan1)
        StudentSafetyPlanDto studentSafetyPlanDto2 = new StudentSafetyPlanDto(studentSafetyPlan1)
        assertEquals(studentSafetyPlanDto1.hashCode(), studentSafetyPlanDto2.hashCode())
    }
    
    @Test
    public void testConstructor_StudentSafetyPlan() {
        StudentSafetyPlanDto studentSafetyPlanTest = new StudentSafetyPlanDto(studentSafetyPlan1)
        assertEquals( studentSafetyPlanTest.studentId, studentSafetyPlan1.student.id );
        assertEquals( studentSafetyPlanTest.howToReduceRiskAtHome, studentSafetyPlan1.howToReduceRiskAtHome);
        assertEquals( studentSafetyPlanTest.completedWithId, studentSafetyPlan1.completedWith.id);
        assertEquals( studentSafetyPlanTest.dateCompleted, studentSafetyPlan1.dateCompleted)
        assertEquals( studentSafetyPlanTest.howToReduceRiskAtHome, studentSafetyPlan1.howToReduceRiskAtHome)
        assertEquals( studentSafetyPlanTest.warningSignsOrTriggers, studentSafetyPlan1.warningSignsOrTriggers)
    }
    
    @Test
    public void testConstructor_NullStudent() {
        StudentSafetyPlanDto studentSafetyPlanTest = new StudentSafetyPlanDto(studentSafetyPlan3)
        assertEquals( studentSafetyPlanTest.studentId, studentSafetyPlan3.student );
        assertEquals( studentSafetyPlanTest.howToReduceRiskAtHome, studentSafetyPlan3.howToReduceRiskAtHome);
        assertEquals( studentSafetyPlanTest.completedWithId, studentSafetyPlan3.completedWith);
        assertEquals( studentSafetyPlanTest.dateCompleted, studentSafetyPlan3.dateCompleted)
        assertEquals( studentSafetyPlanTest.howToReduceRiskAtHome, studentSafetyPlan3.howToReduceRiskAtHome)
        assertEquals( studentSafetyPlanTest.warningSignsOrTriggers, studentSafetyPlan3.warningSignsOrTriggers)
    }
    
    @Test
    public void testConstructor_NullStudentSafetyPlan() {
        StudentSafetyPlan studentSafetyPlan = null
        StudentSafetyPlanDto studentSafetyPlanDto = new StudentSafetyPlanDto(studentSafetyPlan)
        assertEquals( studentSafetyPlan, null )
    }
}
