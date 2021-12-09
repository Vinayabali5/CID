package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentDukeOfEdinburgh
import uk.ac.reigate.domain.academic.WorkPlacementMode

public class StudentDukeOfEdinburghDtoTest {
    
    private StudentDukeOfEdinburgh studentDukeOfEdinburgh1
    
    private StudentDukeOfEdinburgh studentDukeOfEdinburgh2
    
    private StudentDukeOfEdinburgh studentDukeOfEdinburgh3
    
    private List<StudentDukeOfEdinburgh> studentDukeOfEdinburghs
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    @Before
    public void setup() {
        studentDukeOfEdinburgh1 = new StudentDukeOfEdinburgh(
                id: 1,
                student: createStudent(),
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                endDate:new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/05'),
                hours : 1.0f,
                voluntaryOrganisation : 'test',
                note: 'test'
                );
        studentDukeOfEdinburgh2 = new StudentDukeOfEdinburgh(
                id: 2,
                student: createStudent(),
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                endDate:new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/05'),
                hours : 1.0f,
                voluntaryOrganisation : 'test',
                note: 'test'
                );
        studentDukeOfEdinburgh3 = new StudentDukeOfEdinburgh(
                id: 2,
                student: null,
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                endDate:new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/05'),
                hours : 1.0f,
                voluntaryOrganisation : 'test',
                note: 'test'
                );
        studentDukeOfEdinburghs = Arrays.asList(studentDukeOfEdinburgh1, studentDukeOfEdinburgh2);
    }
    
    @Test
    public void testMapFromStudentDukeOfEdinburghEntity(){
        StudentDukeOfEdinburghDto studentDukeOfEdinburghTest = StudentDukeOfEdinburghDto.mapFromEntity( studentDukeOfEdinburgh1 )
        assertEquals( studentDukeOfEdinburghTest.id, studentDukeOfEdinburgh1.id );
        assertEquals( studentDukeOfEdinburghTest.startDate, studentDukeOfEdinburgh1.startDate);
        assertEquals( studentDukeOfEdinburghTest.endDate, studentDukeOfEdinburgh1.endDate);
        assertEquals( studentDukeOfEdinburghTest.voluntaryOrganisation, studentDukeOfEdinburgh1.voluntaryOrganisation);
        assertEquals( studentDukeOfEdinburghTest.note, studentDukeOfEdinburgh1.note);
    }
    
    @Test
    public void testMapFromStudentDukeOfEdinburghsEntities(){
        List<StudentDukeOfEdinburghDto> studentDukeOfEdinburghsDtoTest = StudentDukeOfEdinburghDto.mapFromList( studentDukeOfEdinburghs )
        assertEquals( studentDukeOfEdinburghsDtoTest[0].id, studentDukeOfEdinburgh1.id );
        assertEquals( studentDukeOfEdinburghsDtoTest[0].startDate, studentDukeOfEdinburgh1.startDate);
        assertEquals( studentDukeOfEdinburghsDtoTest[0].endDate, studentDukeOfEdinburgh1.endDate);
        assertEquals( studentDukeOfEdinburghsDtoTest[0].voluntaryOrganisation, studentDukeOfEdinburgh1.voluntaryOrganisation);
        assertEquals( studentDukeOfEdinburghsDtoTest[0].note, studentDukeOfEdinburgh1.note);
    }
    
    @Test
    public void testEquals_Same() {
        StudentDukeOfEdinburghDto studentDukeOfEdinburghDto1 = new StudentDukeOfEdinburghDto(studentDukeOfEdinburgh1)
        StudentDukeOfEdinburghDto studentDukeOfEdinburghDto2 = new StudentDukeOfEdinburghDto(studentDukeOfEdinburgh1)
        assertEquals(studentDukeOfEdinburghDto1, studentDukeOfEdinburghDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StudentDukeOfEdinburghDto studentDukeOfEdinburghDto1 = new StudentDukeOfEdinburghDto(studentDukeOfEdinburgh1)
        StudentDukeOfEdinburghDto studentDukeOfEdinburghDto2 = new StudentDukeOfEdinburghDto(studentDukeOfEdinburgh2)
        assertNotEquals(studentDukeOfEdinburghDto1, studentDukeOfEdinburghDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentDukeOfEdinburghDto studentDukeOfEdinburghDto1 = new StudentDukeOfEdinburghDto(studentDukeOfEdinburgh1)
        StudentDukeOfEdinburghDto studentDukeOfEdinburghDto2 = new StudentDukeOfEdinburghDto(studentDukeOfEdinburgh1)
        assertEquals(studentDukeOfEdinburghDto1.hashCode(), studentDukeOfEdinburghDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StudentDukeOfEdinburghDto studentDukeOfEdinburghDto1 = new StudentDukeOfEdinburghDto(studentDukeOfEdinburgh1)
        StudentDukeOfEdinburghDto studentDukeOfEdinburghDto2 = new StudentDukeOfEdinburghDto(studentDukeOfEdinburgh2)
        assertNotEquals(studentDukeOfEdinburghDto1.hashCode(), studentDukeOfEdinburghDto2.hashCode())
    }
    
    @Test
    public void testConstructor_NullStudent() {
        StudentDukeOfEdinburghDto studentDukeOfEdinburghTest = new StudentDukeOfEdinburghDto(studentDukeOfEdinburgh3)
        assertEquals( studentDukeOfEdinburghTest.id, studentDukeOfEdinburgh3.id );
        assertEquals( studentDukeOfEdinburghTest.startDate, studentDukeOfEdinburgh1.startDate);
        assertEquals( studentDukeOfEdinburghTest.endDate, studentDukeOfEdinburgh1.endDate);
        assertEquals( studentDukeOfEdinburghTest.voluntaryOrganisation, studentDukeOfEdinburgh1.voluntaryOrganisation);
        assertEquals( studentDukeOfEdinburghTest.note, studentDukeOfEdinburgh1.note);
    }
    
    @Test
    public void testConstructor_NullStudentDukeOfEdinburgh() {
        StudentDukeOfEdinburgh studentDukeOfEdinburgh = null
        StudentDukeOfEdinburghDto studentDukeOfEdinburghDto = new StudentDukeOfEdinburghDto(studentDukeOfEdinburgh)
        assertEquals( studentDukeOfEdinburgh, null)
    }
}