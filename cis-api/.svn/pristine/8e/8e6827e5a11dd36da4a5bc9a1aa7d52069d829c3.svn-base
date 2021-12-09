package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentVolunteeringLog
import uk.ac.reigate.domain.lookup.StudentRole
import uk.ac.reigate.domain.lookup.VolunteeringExperience
import uk.ac.reigate.domain.lookup.VolunteeringType

public class StudentVolunteeringLogDtoTest {
    
    private StudentVolunteeringLog studentWorkPlacement1
    
    private StudentVolunteeringLog studentWorkPlacement2
    
    private StudentVolunteeringLog studentWorkPlacement3
    
    private List<StudentVolunteeringLog> studentWorkPlacements
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    @Before
    public void setup() {
        studentWorkPlacement1 = new StudentVolunteeringLog(
                id: 1,
                student: createStudent(),
                date: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                hours : 1.0f,
                volunteeringType : new VolunteeringType(id:1),
                volunteeringExperience: new VolunteeringExperience(id:1),
                studentRole : new StudentRole(id:1),
                note : 'test'
                );
        studentWorkPlacement2 = new StudentVolunteeringLog(
                id: 2,
                student: createStudent(),
                date: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                hours : 1.0f,
                volunteeringType : new VolunteeringType(id:1),
                volunteeringExperience: new VolunteeringExperience(id:1),
                studentRole : new StudentRole(id:1),
                note : 'test'
                );
        studentWorkPlacement3 = new StudentVolunteeringLog(
                id: 2,
                student: null,
                date: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                hours : 1.0f,
                volunteeringType : null,
                note : 'test'
                );
        studentWorkPlacements = Arrays.asList(studentWorkPlacement1, studentWorkPlacement2);
    }
    
    @Test
    public void testMapFromStudentVolunteeringLogEntity(){
        StudentVolunteeringLogDto studentVolunteeringLogTest = StudentVolunteeringLogDto.mapFromEntity( studentWorkPlacement1 )
        assertEquals( studentVolunteeringLogTest.id, studentWorkPlacement1.id );
        assertEquals( studentVolunteeringLogTest.date, studentWorkPlacement1.date);
        assertEquals( studentVolunteeringLogTest.hours, studentWorkPlacement1.hours, 1.0f);
        assertEquals( studentVolunteeringLogTest.note, studentWorkPlacement1.note);
    }
    
    @Test
    public void testMapFromStudentVolunteeringLogsEntities(){
        List<StudentVolunteeringLogDto> studentWorkPlacementsDtoTest = StudentVolunteeringLogDto.mapFromList( studentWorkPlacements )
        assertEquals( studentWorkPlacementsDtoTest[0].id, studentWorkPlacement1.id );
        assertEquals( studentWorkPlacementsDtoTest[0].date, studentWorkPlacement1.date);
        assertEquals( studentWorkPlacementsDtoTest[0].hours, studentWorkPlacement1.hours, 1.0f);
        assertEquals( studentWorkPlacementsDtoTest[0].note, studentWorkPlacement1.note);
    }
    
    @Test
    public void testEquals_Same() {
        StudentVolunteeringLogDto studentVolunteeringLog1 = new StudentVolunteeringLogDto(studentWorkPlacement1)
        StudentVolunteeringLogDto studentVolunteeringLog2 = new StudentVolunteeringLogDto(studentWorkPlacement1)
        assertEquals(studentVolunteeringLog1, studentVolunteeringLog2)
    }
    
    @Test
    public void testEquals_Different() {
        StudentVolunteeringLogDto studentVolunteeringLog1 = new StudentVolunteeringLogDto(studentWorkPlacement1)
        StudentVolunteeringLogDto studentVolunteeringLog2 = new StudentVolunteeringLogDto(studentWorkPlacement2)
        assertNotEquals(studentVolunteeringLog1, studentVolunteeringLog2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentVolunteeringLogDto studentVolunteeringLog1 = new StudentVolunteeringLogDto(studentWorkPlacement1)
        StudentVolunteeringLogDto studentVolunteeringLog2 = new StudentVolunteeringLogDto(studentWorkPlacement1)
        assertEquals(studentVolunteeringLog1.hashCode(), studentVolunteeringLog2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StudentVolunteeringLogDto studentVolunteeringLog1 = new StudentVolunteeringLogDto(studentWorkPlacement1)
        StudentVolunteeringLogDto studentVolunteeringLog2 = new StudentVolunteeringLogDto(studentWorkPlacement2)
        assertNotEquals(studentVolunteeringLog1.hashCode(), studentVolunteeringLog2.hashCode())
    }
    
    @Test
    public void testConstructor_NullStudent() {
        StudentVolunteeringLogDto studentVolunteeringLogTest = new StudentVolunteeringLogDto(studentWorkPlacement3)
        assertEquals( studentVolunteeringLogTest.id, studentWorkPlacement3.id );
        assertEquals( studentVolunteeringLogTest.date, studentWorkPlacement1.date);
        assertEquals( studentVolunteeringLogTest.hours, studentWorkPlacement1.hours, 1.0f);
        assertEquals( studentVolunteeringLogTest.note, studentWorkPlacement1.note);
    }
    
    @Test
    public void testConstructor_NullStudentVolunteeringLog() {
        StudentVolunteeringLog studentWorkPlacement = null
        StudentVolunteeringLogDto studentVolunteeringLog = new StudentVolunteeringLogDto(studentWorkPlacement)
        assertEquals( studentWorkPlacement, null)
    }
    
    @Test
    public void testMethod_Get_NullVolunteeringTypeDescription() {
        StudentVolunteeringLogDto studentVolunteeringLog1 = new StudentVolunteeringLogDto(studentWorkPlacement3)
        assertEquals(studentVolunteeringLog1.volunteeringType, studentVolunteeringLog1.get_VolunteeringTypeDescription())
    }
    
    @Test
    public void testMethod_Get_VolunteeringTypeDescription() {
        StudentVolunteeringLogDto studentVolunteeringLog1 = new StudentVolunteeringLogDto(studentWorkPlacement1)
        assertEquals(studentVolunteeringLog1.volunteeringType.description, studentVolunteeringLog1.get_VolunteeringTypeDescription())
    }
    
    @Test
    public void testMethod_Get_NullVolunteeringExperienceDescription() {
        StudentVolunteeringLogDto studentVolunteeringLog1 = new StudentVolunteeringLogDto(studentWorkPlacement3)
        assertEquals(studentVolunteeringLog1.volunteeringExperience, studentVolunteeringLog1.get_VolunteeringExperienceDescription())
    }
    
    @Test
    public void testMethod_Get_VolunteeringExperienceDescription() {
        StudentVolunteeringLogDto studentVolunteeringLog1 = new StudentVolunteeringLogDto(studentWorkPlacement1)
        assertEquals(studentVolunteeringLog1.volunteeringExperience.description, studentVolunteeringLog1.get_VolunteeringExperienceDescription())
    }
    
    @Test
    public void testMethod_Get_NullStudentRoleDescription() {
        StudentVolunteeringLogDto studentVolunteeringLog1 = new StudentVolunteeringLogDto(studentWorkPlacement3)
        assertEquals(studentVolunteeringLog1.studentRole, studentVolunteeringLog1.get_StudentRoleDescription())
    }
    
    @Test
    public void testMethod_Get_StudentRoleDescription() {
        StudentVolunteeringLogDto studentVolunteeringLog1 = new StudentVolunteeringLogDto(studentWorkPlacement1)
        assertEquals(studentVolunteeringLog1.studentRole.description, studentVolunteeringLog1.get_StudentRoleDescription())
    }
}