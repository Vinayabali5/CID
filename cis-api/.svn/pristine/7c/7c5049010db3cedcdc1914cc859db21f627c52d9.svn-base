package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.lookup.TutorGroup


public class PastoralMonitorDtoTest {
    
    private StudentYear studentYear1
    
    private StudentYear studentYear2
    
    private StudentYear studentYear3
    
    private List<StudentYear> studentYears
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    Student createStudent2() {
        Student student = new Student()
        student.id = 2
        return student
    }
    
    @Before
    public void setup() {
        studentYear1 = new StudentYear(
                student: createStudent(),
                year: new AcademicYear(id: 20),
                pastoralMonitor: new Staff(id: 1, knownAs: 'vinaya'),
                tutorGroup : new TutorGroup(id: 1, seniorTutor: new Staff(id: 1, knownAs:'vinaya'))
                );
        studentYear2 = new StudentYear(
                student: createStudent2(),
                year: new AcademicYear(id: 20),
                pastoralMonitor: new Staff(id: 1, knownAs: 'vinaya'),
                tutorGroup : new TutorGroup(id: 1, seniorTutor: new Staff(id: 1, knownAs:'vinaya'))
                );
        studentYear3 = new StudentYear(
                student: null,
                year: null,
                pastoralMonitor: null,
                tutorGroup : new TutorGroup(id: 1, seniorTutor: null)
                );
        studentYears = Arrays.asList(studentYear1, studentYear2);
    }
    
    @Test
    void testConstructor_pastoralMonitor() {
        PastoralMonitorDto pastoralMonitorTest = new PastoralMonitorDto( studentYear1 )
        assertEquals( pastoralMonitorTest.studentId, studentYear1.student.id);
        assertEquals( pastoralMonitorTest.yearId, studentYear1.year.id);
    }
    
    @Test
    void testConstructor_NullStudent() {
        PastoralMonitorDto pastoralMonitorTest = new PastoralMonitorDto( studentYear3 )
        assertEquals( pastoralMonitorTest.studentId, studentYear3.student);
        assertEquals( pastoralMonitorTest.yearId, studentYear3.year);
    }
    
    @Test
    public void testConstructor_NullPastoralMonitor() {
        StudentYear pastoralMonitor = null
        PastoralMonitorDto pastoralMonitorDto = new PastoralMonitorDto(pastoralMonitor)
        assertEquals( pastoralMonitor, null);
    }
    
    @Test
    public void testMapFromPastoralMonitorEntity(){
        PastoralMonitorDto pastoralMonitorTest = PastoralMonitorDto.mapFromEntity( studentYear1 )
        assertEquals( pastoralMonitorTest.studentId, studentYear1.student.id);
        assertEquals( pastoralMonitorTest.yearId, studentYear1.year.id);
    }
    
    
    @Test
    public void testEquals_Same() {
        PastoralMonitorDto pastoralMonitorDto1 = new PastoralMonitorDto(studentYear1)
        PastoralMonitorDto pastoralMonitorDto2 = new PastoralMonitorDto(studentYear1)
        assertEquals(pastoralMonitorDto1, pastoralMonitorDto2)
    }
    
    @Test
    public void testEquals_Different() {
        PastoralMonitorDto pastoralMonitorDto1 = new PastoralMonitorDto(studentYear1)
        PastoralMonitorDto pastoralMonitorDto2 = new PastoralMonitorDto(studentYear2)
        assertNotEquals(pastoralMonitorDto1, pastoralMonitorDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        PastoralMonitorDto pastoralMonitorDto1 = new PastoralMonitorDto(studentYear1)
        PastoralMonitorDto pastoralMonitorDto2 = new PastoralMonitorDto(studentYear1)
        assertEquals(pastoralMonitorDto1.hashCode(), pastoralMonitorDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        PastoralMonitorDto pastoralMonitorDto1 = new PastoralMonitorDto(studentYear1)
        PastoralMonitorDto pastoralMonitorDto2 = new PastoralMonitorDto(studentYear2)
        assertNotEquals(pastoralMonitorDto1.hashCode(), pastoralMonitorDto2.hashCode())
    }
    
    @Test
    public void testMethod_Get_NullPastoralMonitor() {
        PastoralMonitorDto pastoralMonitorDto1 = new PastoralMonitorDto(studentYear3)
        assertEquals(pastoralMonitorDto1.pastoralMonitor, pastoralMonitorDto1.get_PastoralMonitor())
    }
    
    @Test
    public void testMethod_Get_PastoralMonitor() {
        PastoralMonitorDto pastoralMonitorDto1 = new PastoralMonitorDto(studentYear1)
        assertEquals(pastoralMonitorDto1.pastoralMonitor.knownAs, pastoralMonitorDto1.get_PastoralMonitor())
    }
}
