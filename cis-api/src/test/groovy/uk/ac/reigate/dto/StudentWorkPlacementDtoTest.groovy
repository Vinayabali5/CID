package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentWorkPlacement
import uk.ac.reigate.domain.academic.WorkPlacementMode

public class StudentWorkPlacementDtoTest {
    
    private StudentWorkPlacement studentWorkPlacement1
    
    private StudentWorkPlacement studentWorkPlacement2
    
    private StudentWorkPlacement studentWorkPlacement3
    
    private List<StudentWorkPlacement> studentWorkPlacements
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    @Before
    public void setup() {
        studentWorkPlacement1 = new StudentWorkPlacement(
                id: 1,
                student: createStudent(),
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                endDate:new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/05'),
                placementHours : 1.0f,
                workPlacementMode : new WorkPlacementMode(id:1),
                employer : 'test'
                );
        studentWorkPlacement2 = new StudentWorkPlacement(
                id: 2,
                student: createStudent(),
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                endDate:new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/05'),
                placementHours : 1.0f,
                workPlacementMode : new WorkPlacementMode(id:1),
                employer : 'test'
                );
        studentWorkPlacement3 = new StudentWorkPlacement(
                id: 2,
                student: null,
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                endDate:new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/05'),
                placementHours : 1.0f,
                workPlacementMode : null,
                employer : 'test'
                );
        studentWorkPlacements = Arrays.asList(studentWorkPlacement1, studentWorkPlacement2);
    }
    
    @Test
    public void testMapFromStudentWorkPlacementEntity(){
        StudentWorkPlacementDto studentWorkPlacementTest = StudentWorkPlacementDto.mapFromEntity( studentWorkPlacement1 )
        assertEquals( studentWorkPlacementTest.id, studentWorkPlacement1.id );
        assertEquals( studentWorkPlacementTest.endDate, studentWorkPlacement1.endDate);
    }
    
    @Test
    public void testMapFromStudentWorkPlacementsEntities(){
        List<StudentWorkPlacementDto> studentWorkPlacementsDtoTest = StudentWorkPlacementDto.mapFromList( studentWorkPlacements )
        assertEquals( studentWorkPlacementsDtoTest[0].id, studentWorkPlacement1.id );
        assertEquals( studentWorkPlacementsDtoTest[0].endDate, studentWorkPlacement1.endDate);
    }
    
    @Test
    public void testEquals_Same() {
        StudentWorkPlacementDto studentWorkPlacementDto1 = new StudentWorkPlacementDto(studentWorkPlacement1)
        StudentWorkPlacementDto studentWorkPlacementDto2 = new StudentWorkPlacementDto(studentWorkPlacement1)
        assertEquals(studentWorkPlacementDto1, studentWorkPlacementDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StudentWorkPlacementDto studentWorkPlacementDto1 = new StudentWorkPlacementDto(studentWorkPlacement1)
        StudentWorkPlacementDto studentWorkPlacementDto2 = new StudentWorkPlacementDto(studentWorkPlacement2)
        assertNotEquals(studentWorkPlacementDto1, studentWorkPlacementDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentWorkPlacementDto studentWorkPlacementDto1 = new StudentWorkPlacementDto(studentWorkPlacement1)
        StudentWorkPlacementDto studentWorkPlacementDto2 = new StudentWorkPlacementDto(studentWorkPlacement1)
        assertEquals(studentWorkPlacementDto1.hashCode(), studentWorkPlacementDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StudentWorkPlacementDto studentWorkPlacementDto1 = new StudentWorkPlacementDto(studentWorkPlacement1)
        StudentWorkPlacementDto studentWorkPlacementDto2 = new StudentWorkPlacementDto(studentWorkPlacement2)
        assertNotEquals(studentWorkPlacementDto1.hashCode(), studentWorkPlacementDto2.hashCode())
    }
    
    @Test
    public void testConstructor_NullStudent() {
        StudentWorkPlacementDto studentWorkPlacementDto = new StudentWorkPlacementDto(studentWorkPlacement3)
        assertEquals( studentWorkPlacementDto.id, studentWorkPlacement3.id );
        assertEquals( studentWorkPlacementDto.endDate, studentWorkPlacement3.endDate);
    }
    
    @Test
    public void testConstructor_NullStudentWorkPlacement() {
        StudentWorkPlacement studentWorkPlacement = null
        StudentWorkPlacementDto studentWorkPlacementDto = new StudentWorkPlacementDto(studentWorkPlacement)
        assertEquals( studentWorkPlacement, null)
    }
    
    @Test
    public void testMethod_Get_NullWorkPlacementModeDescription() {
        StudentWorkPlacementDto studentWorkPlacementDto1 = new StudentWorkPlacementDto(studentWorkPlacement3)
        assertEquals(studentWorkPlacementDto1.workPlacementMode, studentWorkPlacementDto1.get_WorkPlacementModeDescription())
    }
    
    @Test
    public void testMethod_Get_WorkPlacementModeDescription() {
        StudentWorkPlacementDto studentWorkPlacementDto1 = new StudentWorkPlacementDto(studentWorkPlacement1)
        assertEquals(studentWorkPlacementDto1.workPlacementMode.description, studentWorkPlacementDto1.get_WorkPlacementModeDescription())
    }
}