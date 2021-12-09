package uk.ac.reigate.dto.risk_assessment;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.risk_assessment.StudentRiskAssessment


public class StudentRiskAssessmentDtoTest {
    
    private StudentRiskAssessment studentRiskAssessment1
    
    private StudentRiskAssessment studentRiskAssessment2
    
    private StudentRiskAssessment studentRiskAssessment3
    
    private List<StudentRiskAssessment> studentRiskAssessments
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    Staff createStaff() {
        Staff staff = new Staff()
        staff.id = 1
        staff.person = new Person(id: 1, firstName: 'vinaya', surname: 'bali')
        return staff
    }
    
    @Before
    public void setup() {
        studentRiskAssessment1 = new StudentRiskAssessment(
                id: 1,
                student: createStudent(),
                completeByStaff:createStaff(),
                riskToStudent: 'high',
                actionsToMinimiseRisk: 'risk',
                riskToOtherStudents : 'yes',
                riskToStaff : 'unknown',
                whoToInform : 'Safeguarding team',
                otherAgenciesInvolved : 'No',
                agencyContactDetails : 'none'
                );
        studentRiskAssessment2 = new StudentRiskAssessment(
                id: 2,
                student: createStudent(),
                completeByStaff: new Staff(id: 1, person : null),
                riskToStudent: 'high',
                actionsToMinimiseRisk: 'risk',
                riskToOtherStudents : 'yes',
                riskToStaff : 'unknown',
                whoToInform : 'Safeguarding team',
                otherAgenciesInvolved : 'No',
                agencyContactDetails : 'none'
                );
        studentRiskAssessment3 = new StudentRiskAssessment(
                id: 3,
                student: null,
                completeByStaff:null,
                riskToStudent: 'high',
                actionsToMinimiseRisk: 'risk',
                riskToOtherStudents : 'yes',
                riskToStaff : 'unknown',
                whoToInform : 'Safeguarding team',
                otherAgenciesInvolved : 'No',
                agencyContactDetails : 'none'
                );
        studentRiskAssessments = Arrays.asList(studentRiskAssessment1, studentRiskAssessment2);
    }
    
    @Test
    public void testMapFromStudentRiskAssessmentEntity(){
        StudentRiskAssessmentDto studentRiskAssessmentTest = StudentRiskAssessmentDto.mapFromEntity( studentRiskAssessment1 )
        assertEquals( studentRiskAssessmentTest.studentId, studentRiskAssessment1.student.id );
        assertEquals( studentRiskAssessmentTest.completeByStaffId, studentRiskAssessment1.completeByStaff.id);
        assertEquals( studentRiskAssessmentTest.actionsToMinimiseRisk, studentRiskAssessment1.actionsToMinimiseRisk);
        assertEquals( studentRiskAssessmentTest.riskToOtherStudents, studentRiskAssessment1.riskToOtherStudents)
        assertEquals( studentRiskAssessmentTest.riskToStaff, studentRiskAssessment1.riskToStaff)
        assertEquals( studentRiskAssessmentTest.whoToInform, studentRiskAssessment1.whoToInform)
        assertEquals( studentRiskAssessmentTest.otherAgenciesInvolved, studentRiskAssessment1.otherAgenciesInvolved)
        assertEquals( studentRiskAssessmentTest.agencyContactDetails, studentRiskAssessment1.agencyContactDetails)
    }
    
    @Test
    public void testMapFromStudentRiskAssessmentsEntities(){
        List<StudentRiskAssessmentDto> studentRiskAssessmentsDtoTest = StudentRiskAssessmentDto.mapFromList( studentRiskAssessments )
        assertEquals( studentRiskAssessmentsDtoTest[0].studentId, studentRiskAssessment1.student.id );
        assertEquals( studentRiskAssessmentsDtoTest[0].completeByStaffId, studentRiskAssessment1.completeByStaff.id);
        assertEquals( studentRiskAssessmentsDtoTest[0].actionsToMinimiseRisk, studentRiskAssessment1.actionsToMinimiseRisk);
        assertEquals( studentRiskAssessmentsDtoTest[0].riskToOtherStudents, studentRiskAssessment1.riskToOtherStudents)
        assertEquals( studentRiskAssessmentsDtoTest[0].riskToStaff, studentRiskAssessment1.riskToStaff)
        assertEquals( studentRiskAssessmentsDtoTest[0].whoToInform, studentRiskAssessment1.whoToInform)
        assertEquals( studentRiskAssessmentsDtoTest[0].otherAgenciesInvolved, studentRiskAssessment1.otherAgenciesInvolved)
        assertEquals( studentRiskAssessmentsDtoTest[0].agencyContactDetails, studentRiskAssessment1.agencyContactDetails)
        assertEquals( studentRiskAssessmentsDtoTest[1].studentId, studentRiskAssessment2.student.id );
        assertEquals( studentRiskAssessmentsDtoTest[1].completeByStaffId, studentRiskAssessment2.completeByStaff.id);
        assertEquals( studentRiskAssessmentsDtoTest[1].actionsToMinimiseRisk, studentRiskAssessment2.actionsToMinimiseRisk);
        assertEquals( studentRiskAssessmentsDtoTest[1].riskToOtherStudents, studentRiskAssessment2.riskToOtherStudents)
        assertEquals( studentRiskAssessmentsDtoTest[1].riskToStaff, studentRiskAssessment2.riskToStaff)
        assertEquals( studentRiskAssessmentsDtoTest[1].whoToInform, studentRiskAssessment2.whoToInform)
        assertEquals( studentRiskAssessmentsDtoTest[1].otherAgenciesInvolved, studentRiskAssessment2.otherAgenciesInvolved)
        assertEquals( studentRiskAssessmentsDtoTest[1].agencyContactDetails, studentRiskAssessment2.agencyContactDetails)
    }
    
    
    @Test
    public void testEquals_Same() {
        StudentRiskAssessmentDto studentRiskAssessmentDto1 = new StudentRiskAssessmentDto(studentRiskAssessment1)
        StudentRiskAssessmentDto studentRiskAssessmentDto2 = new StudentRiskAssessmentDto(studentRiskAssessment1)
        assertEquals(studentRiskAssessmentDto1, studentRiskAssessmentDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentRiskAssessmentDto studentRiskAssessmentDto1 = new StudentRiskAssessmentDto(studentRiskAssessment1)
        StudentRiskAssessmentDto studentRiskAssessmentDto2 = new StudentRiskAssessmentDto(studentRiskAssessment1)
        assertEquals(studentRiskAssessmentDto1.hashCode(), studentRiskAssessmentDto2.hashCode())
    }
    
    @Test
    public void testConstructor_StudentRiskAssessment() {
        StudentRiskAssessmentDto studentRiskAssessmentTest = new StudentRiskAssessmentDto(studentRiskAssessment1)
        assertEquals( studentRiskAssessmentTest.completeByStaffId, studentRiskAssessment1.completeByStaff.id )
        assertEquals( studentRiskAssessmentTest.actionsToMinimiseRisk, studentRiskAssessment1.actionsToMinimiseRisk);
        assertEquals( studentRiskAssessmentTest.riskToOtherStudents, studentRiskAssessment1.riskToOtherStudents)
        assertEquals( studentRiskAssessmentTest.riskToStaff, studentRiskAssessment1.riskToStaff)
        assertEquals( studentRiskAssessmentTest.whoToInform, studentRiskAssessment1.whoToInform)
        assertEquals( studentRiskAssessmentTest.otherAgenciesInvolved, studentRiskAssessment1.otherAgenciesInvolved)
        assertEquals( studentRiskAssessmentTest.agencyContactDetails, studentRiskAssessment1.agencyContactDetails)
    }
    
    @Test
    public void testConstructor_NullStudent() {
        StudentRiskAssessmentDto studentRiskAssessmentTest = new StudentRiskAssessmentDto(studentRiskAssessment3)
        assertEquals( studentRiskAssessmentTest.completeByStaffId, studentRiskAssessment3.completeByStaff )
        assertEquals( studentRiskAssessmentTest.actionsToMinimiseRisk, studentRiskAssessment1.actionsToMinimiseRisk);
        assertEquals( studentRiskAssessmentTest.riskToOtherStudents, studentRiskAssessment1.riskToOtherStudents)
        assertEquals( studentRiskAssessmentTest.riskToStaff, studentRiskAssessment1.riskToStaff)
        assertEquals( studentRiskAssessmentTest.whoToInform, studentRiskAssessment1.whoToInform)
        assertEquals( studentRiskAssessmentTest.otherAgenciesInvolved, studentRiskAssessment1.otherAgenciesInvolved)
        assertEquals( studentRiskAssessmentTest.agencyContactDetails, studentRiskAssessment1.agencyContactDetails)
    }
    
    @Test
    public void testConstructor_NullStudentRiskAssessment() {
        StudentRiskAssessment studentRiskAssessment = null
        StudentRiskAssessmentDto studentRiskAssessmentDto = new StudentRiskAssessmentDto(studentRiskAssessment)
        assertEquals( studentRiskAssessment, null )
    }
}
