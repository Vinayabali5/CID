package uk.ac.reigate.dto

import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*
import uk.ac.reigate.domain.academic.SchoolReference
import uk.ac.reigate.domain.academic.Student

class SchoolReferenceDtoTest {
    
    private SchoolReference schoolReference1
    
    private SchoolReference schoolReference2
    
    private List<SchoolReference> schoolReferences
    
    @Before
    public void setup() {
        schoolReference1 = new SchoolReference(
                student : new Student(id: 200001),
                meetingTargets : 4,
                effort : 3,
                workEthic : 4,
                homeworkCompletion : 4,
                behaviour : 4,
                organisation : 3,
                attainmentPotential : 5,
                year10Attendance : 1.1,
                year10AttendanceComment : 'Test 10',
                year11Attendance : 1.1,
                year11AttendanceComment : 'Test 11',
                reliability : 4,
                independence : 6,
                sociability : 7,
                relationshipWithStaff : 8,
                recommend : true,
                recommendComment : null,
                behaviouralIssues : false,
                behaviouralIssuesComment : 'positive Comments',
                responsibilitiesExtraCurricular : 'None',
                senco : false
                )
        schoolReference2 = new SchoolReference(
                student : new Student(),
                meetingTargets : 4,
                effort : 3,
                workEthic : 4,
                homeworkCompletion : 4,
                behaviour : 4,
                organisation : 3,
                attainmentPotential : 5,
                year10Attendance : 1.1,
                year10AttendanceComment : 'Test 10',
                year11Attendance : 1.1,
                year11AttendanceComment : 'Test 11',
                reliability : 4,
                independence : 6,
                sociability : 7,
                relationshipWithStaff : 8,
                recommend : true,
                recommendComment : null,
                behaviouralIssues : false,
                behaviouralIssuesComment : 'positive Comments',
                responsibilitiesExtraCurricular : 'None',
                senco : false
                )
        schoolReferences = Arrays.asList(schoolReference1, schoolReference2)
    }
    
    @Test
    public void testConstructor() {
        SchoolReferenceDto dto = new SchoolReferenceDto(schoolReference1)
        assertEquals(dto.studentId, schoolReference1.student.id)
        assertEquals(dto.meetingTargets, schoolReference1.meetingTargets)
        assertEquals(dto.effort, schoolReference1.effort)
        assertEquals(dto.workEthic, schoolReference1.workEthic)
        assertEquals(dto.homeworkCompletion, schoolReference1.homeworkCompletion)
        assertEquals(dto.behaviour, schoolReference1.behaviour)
    }
    
    @Test
    public void testConstructorNullDto() {
        SchoolReference schoolReference = null
        SchoolReferenceDto dto = new SchoolReferenceDto(schoolReference)
        assertEquals(schoolReference, null)
    }
    
    @Test
    public void testConstructorNullStudent() {
        SchoolReferenceDto dto = new SchoolReferenceDto(schoolReference2)
        assertEquals(dto.studentId, null)
        assertEquals(dto.meetingTargets, schoolReference2.meetingTargets)
        assertEquals(dto.effort, schoolReference2.effort)
        assertEquals(dto.workEthic, schoolReference2.workEthic)
        assertEquals(dto.homeworkCompletion, schoolReference2.homeworkCompletion)
        assertEquals(dto.behaviour, schoolReference2.behaviour)
    }
    
    @Test
    public void testMapFromEntity() {
        SchoolReferenceDto dto = SchoolReferenceDto.mapFromEntity(schoolReference1)
        assertEquals(dto.studentId, schoolReference1.student.id)
        assertEquals(dto.meetingTargets, schoolReference1.meetingTargets)
        assertEquals(dto.effort, schoolReference1.effort)
        assertEquals(dto.workEthic, schoolReference1.workEthic)
        assertEquals(dto.homeworkCompletion, schoolReference1.homeworkCompletion)
        assertEquals(dto.behaviour, schoolReference1.behaviour)
    }
    
    @Test
    public void testMapFromList() {
        List<SchoolReferenceDto> dto = SchoolReferenceDto.mapFromList(schoolReferences)
        assertEquals(dto[0].studentId, schoolReference1.student.id)
        assertEquals(dto[0].meetingTargets, schoolReference1.meetingTargets)
        assertEquals(dto[0].effort, schoolReference1.effort)
        assertEquals(dto[0].workEthic, schoolReference1.workEthic)
        assertEquals(dto[0].homeworkCompletion, schoolReference1.homeworkCompletion)
        assertEquals(dto[0].behaviour, schoolReference1.behaviour)
        assertEquals(dto[1].studentId, null)
        assertEquals(dto[1].meetingTargets, schoolReference2.meetingTargets)
        assertEquals(dto[1].effort, schoolReference2.effort)
        assertEquals(dto[1].workEthic, schoolReference2.workEthic)
        assertEquals(dto[1].homeworkCompletion, schoolReference2.homeworkCompletion)
        assertEquals(dto[1].behaviour, schoolReference2.behaviour)
    }
}
