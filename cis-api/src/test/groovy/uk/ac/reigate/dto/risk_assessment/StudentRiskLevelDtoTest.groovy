package uk.ac.reigate.dto.risk_assessment;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.risk_assessment.RiskLevel
import uk.ac.reigate.domain.risk_assessment.StudentRiskLevel


public class StudentRiskLevelDtoTest {
    
    private StudentRiskLevel studentRiskLevel1
    
    private StudentRiskLevel studentRiskLevel2
    
    private StudentRiskLevel studentRiskLevel3
    
    private List<StudentRiskLevel> studentRiskLevels
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    Staff createStaff() {
        Staff staff = new Staff()
        staff.id = 1
        staff.person = new Person(id: 1, firstName: 'vinaya', surname: 'Bali')
        return staff
    }
    
    RiskLevel riskLevel() {
        RiskLevel riskLevel = new RiskLevel()
        riskLevel.id = 1
        return riskLevel
    }
    
    @Before
    public void setup() {
        studentRiskLevel1 = new StudentRiskLevel(
                id: 1,
                student: createStudent(),
                riskLevel: new RiskLevel(id: 1),
                staffRequesting:createStaff(),
                dateRequested: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                dateForReview: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                confidential: true,
                evidence : true,
                riskAssessmentRequired : true,
                safetyPlanRequired : true,
                riskNotes : 'No'
                );
        studentRiskLevel2 = new StudentRiskLevel(
                id: 2,
                student: createStudent(),
                riskLevel: new RiskLevel(id: 1),
                staffRequesting:createStaff(),
                dateRequested: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                dateForReview: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                confidential: true,
                evidence : true,
                riskAssessmentRequired : true,
                safetyPlanRequired : true,
                riskNotes : 'No'
                );
        studentRiskLevel3 = new StudentRiskLevel(
                id: 3,
                student: null,
                riskLevel: null,
                staffRequesting:null,
                dateRequested: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                dateForReview: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                confidential: true,
                evidence : true,
                riskAssessmentRequired : true,
                safetyPlanRequired : true,
                riskNotes : 'No'
                );
        studentRiskLevels = Arrays.asList(studentRiskLevel1, studentRiskLevel2);
    }
    
    @Test
    public void testMapFromStudentRiskLevelEntity(){
        StudentRiskLevelDto studentRiskLevelTest = StudentRiskLevelDto.mapFromEntity( studentRiskLevel1 )
        assertEquals( studentRiskLevelTest.studentId, studentRiskLevel1.student.id );
        assertEquals( studentRiskLevelTest.staffRequestingId, studentRiskLevel1.staffRequesting.id);
        assertEquals( studentRiskLevelTest.dateRequested, studentRiskLevel1.dateRequested);
        assertEquals( studentRiskLevelTest.confidential, studentRiskLevel1.confidential)
        assertEquals( studentRiskLevelTest.evidence, studentRiskLevel1.evidence)
        assertEquals( studentRiskLevelTest.riskAssessmentRequired, studentRiskLevel1.riskAssessmentRequired)
        assertEquals( studentRiskLevelTest.safetyPlanRequired, studentRiskLevel1.safetyPlanRequired)
        assertEquals( studentRiskLevelTest.riskNotes, studentRiskLevel1.riskNotes)
    }
    
    @Test
    public void testMapFromStudentRiskLevelsEntities(){
        List<StudentRiskLevelDto> studentRiskLevelsDtoTest = StudentRiskLevelDto.mapFromList( studentRiskLevels )
        assertEquals( studentRiskLevelsDtoTest[0].studentId, studentRiskLevel1.student.id );
        assertEquals( studentRiskLevelsDtoTest[0].staffRequestingId, studentRiskLevel1.staffRequesting.id);
        assertEquals( studentRiskLevelsDtoTest[0].dateRequested, studentRiskLevel1.dateRequested);
        assertEquals( studentRiskLevelsDtoTest[0].confidential, studentRiskLevel1.confidential)
        assertEquals( studentRiskLevelsDtoTest[0].evidence, studentRiskLevel1.evidence)
        assertEquals( studentRiskLevelsDtoTest[0].riskAssessmentRequired, studentRiskLevel1.riskAssessmentRequired)
        assertEquals( studentRiskLevelsDtoTest[0].safetyPlanRequired, studentRiskLevel1.safetyPlanRequired)
        assertEquals( studentRiskLevelsDtoTest[0].riskNotes, studentRiskLevel1.riskNotes)
        assertEquals( studentRiskLevelsDtoTest[1].studentId, studentRiskLevel2.student.id );
        assertEquals( studentRiskLevelsDtoTest[1].staffRequestingId, studentRiskLevel2.staffRequesting.id);
        assertEquals( studentRiskLevelsDtoTest[1].dateRequested, studentRiskLevel2.dateRequested);
        assertEquals( studentRiskLevelsDtoTest[1].confidential, studentRiskLevel2.confidential)
        assertEquals( studentRiskLevelsDtoTest[1].evidence, studentRiskLevel2.evidence)
        assertEquals( studentRiskLevelsDtoTest[1].riskAssessmentRequired, studentRiskLevel2.riskAssessmentRequired)
        assertEquals( studentRiskLevelsDtoTest[1].safetyPlanRequired, studentRiskLevel2.safetyPlanRequired)
        assertEquals( studentRiskLevelsDtoTest[1].riskNotes, studentRiskLevel2.riskNotes)
    }
    
    
    @Test
    public void testEquals_Same() {
        StudentRiskLevelDto studentRiskLevelDto1 = new StudentRiskLevelDto(studentRiskLevel1)
        StudentRiskLevelDto studentRiskLevelDto2 = new StudentRiskLevelDto(studentRiskLevel1)
        assertEquals(studentRiskLevelDto1, studentRiskLevelDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentRiskLevelDto studentRiskLevelDto1 = new StudentRiskLevelDto(studentRiskLevel1)
        StudentRiskLevelDto studentRiskLevelDto2 = new StudentRiskLevelDto(studentRiskLevel1)
        assertEquals(studentRiskLevelDto1.hashCode(), studentRiskLevelDto2.hashCode())
    }
    
    @Test
    public void testConstructor_StudentRiskLevel() {
        StudentRiskLevelDto studentRiskLevelTest = new StudentRiskLevelDto(studentRiskLevel1)
        assertEquals( studentRiskLevelTest.staffRequestingId, studentRiskLevel1.staffRequesting.id )
        assertEquals( studentRiskLevelTest.dateRequested, studentRiskLevel1.dateRequested);
        assertEquals( studentRiskLevelTest.confidential, studentRiskLevel1.confidential)
        assertEquals( studentRiskLevelTest.evidence, studentRiskLevel1.evidence)
        assertEquals( studentRiskLevelTest.riskAssessmentRequired, studentRiskLevel1.riskAssessmentRequired)
        assertEquals( studentRiskLevelTest.safetyPlanRequired, studentRiskLevel1.safetyPlanRequired)
        assertEquals( studentRiskLevelTest.riskNotes, studentRiskLevel1.riskNotes)
    }
    
    @Test
    public void testConstructor_NullStudent() {
        StudentRiskLevelDto studentRiskLevelTest = new StudentRiskLevelDto(studentRiskLevel3)
        assertEquals( studentRiskLevelTest.staffRequestingId, studentRiskLevel3.staffRequesting )
        assertEquals( studentRiskLevelTest.dateRequested, studentRiskLevel1.dateRequested);
        assertEquals( studentRiskLevelTest.confidential, studentRiskLevel1.confidential)
        assertEquals( studentRiskLevelTest.evidence, studentRiskLevel1.evidence)
        assertEquals( studentRiskLevelTest.riskAssessmentRequired, studentRiskLevel1.riskAssessmentRequired)
        assertEquals( studentRiskLevelTest.safetyPlanRequired, studentRiskLevel1.safetyPlanRequired)
        assertEquals( studentRiskLevelTest.riskNotes, studentRiskLevel1.riskNotes)
    }
    
    @Test
    public void testConstructor_NullStudentRiskLevel() {
        StudentRiskLevel studentRiskLevel = null
        StudentRiskLevelDto studentRiskLevelDto = new StudentRiskLevelDto(studentRiskLevel)
        assertEquals( studentRiskLevel, null )
    }
    
    @Test
    public void testMethod_Get_RiskLevelCode() {
        StudentRiskLevelDto studentRiskLevelDto1 = new StudentRiskLevelDto(studentRiskLevel1)
        assertEquals(studentRiskLevelDto1.riskLevel.code, studentRiskLevelDto1.get_RiskLevelCode())
    }
    
    @Test
    public void testMethod_Get_NullRiskLevelCode() {
        StudentRiskLevelDto studentRiskLevelDto1 = new StudentRiskLevelDto(studentRiskLevel3)
        assertEquals(studentRiskLevelDto1.riskLevel, studentRiskLevelDto1.get_RiskLevelCode())
    }
    
    @Test
    public void testMethod_Get_RiskLevelDescription() {
        StudentRiskLevelDto studentRiskLevelDto1 = new StudentRiskLevelDto(studentRiskLevel1)
        assertEquals(studentRiskLevelDto1.riskLevel.description, studentRiskLevelDto1.get_RiskLevelDescription())
    }
    
    @Test
    public void testMethod_Get_NullRiskLevelDescription() {
        StudentRiskLevelDto studentRiskLevelDto1 = new StudentRiskLevelDto(studentRiskLevel3)
        assertEquals(studentRiskLevelDto1.riskLevel, studentRiskLevelDto1.get_RiskLevelDescription())
    }
    
    @Test
    public void testMethod_GetStaffRequestingName() {
        StudentRiskLevelDto studentRiskLevelDto1 = new StudentRiskLevelDto(studentRiskLevel1)
        assertEquals(studentRiskLevelDto1.staffRequesting.person.surname + '-' + studentRiskLevelDto1.staffRequesting.person.firstName, studentRiskLevelDto1.get_StaffRequestingName())
    }
    
    @Test
    public void testMethod_NullGetStaffRequestingName() {
        StudentRiskLevelDto studentRiskLevelDto1 = new StudentRiskLevelDto(studentRiskLevel3)
        assertEquals(studentRiskLevelDto1.staffRequesting.person, studentRiskLevelDto1.get_StaffRequestingName())
    }
}
