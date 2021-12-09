package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.learning_support.LearningSupportVisit
import uk.ac.reigate.exceptions.InvalidDataException

public class LearningSupportVisitDtoTest {
    
    private LearningSupportVisit learningSupportVisit1
    
    private LearningSupportVisit learningSupportVisit2
    
    private LearningSupportVisit learningSupportVisit3
    
    private List<LearningSupportVisit> learningSupportVisits
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    @Before
    public void setup() {
        learningSupportVisit1 = new LearningSupportVisit(
                id: 1,
                student: createStudent(),
                date : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                duration : 2,
                details : 'vcb',
                time : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01')
                );
        learningSupportVisit2 = new LearningSupportVisit(
                id: 2,
                student: createStudent(),
                date : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                duration : 2,
                details : 'vcb',
                time : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01')
                );
        learningSupportVisit3 = new LearningSupportVisit(
                id: 3,
                student: null,
                date : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                duration : 2,
                details : 'vcb',
                time : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01')
                );
        
        learningSupportVisits = Arrays.asList(learningSupportVisit1, learningSupportVisit2);
    }
    
    @Test
    public void testMapFromLearningSupportVisitEntity(){
        LearningSupportVisitDto learningSupportVisitTest = LearningSupportVisitDto.mapFromEntity( learningSupportVisit1 )
        assertEquals( learningSupportVisitTest.id, learningSupportVisit1.id );
        assertEquals( learningSupportVisitTest.details, learningSupportVisit1.details);
        assertEquals( learningSupportVisitTest.date, learningSupportVisit1.date)
        assertEquals( learningSupportVisitTest.duration, learningSupportVisit1.duration)
        assertEquals( learningSupportVisitTest.time, learningSupportVisit1.time)
    }
    
    @Test
    public void testMapFromLearningSupportVisitsEntities(){
        List<LearningSupportVisitDto> learningSupportVisitsDtoTest = LearningSupportVisitDto.mapFromList( learningSupportVisits )
        assertEquals( learningSupportVisitsDtoTest[0].id, learningSupportVisit1.id );
        assertEquals( learningSupportVisitsDtoTest[0].studentId, learningSupportVisit1.student.id);
        assertEquals( learningSupportVisitsDtoTest[0].details, learningSupportVisit1.details);
        assertEquals( learningSupportVisitsDtoTest[0].date, learningSupportVisit1.date);
        assertEquals( learningSupportVisitsDtoTest[0].duration, learningSupportVisit1.duration);
        assertEquals( learningSupportVisitsDtoTest[1].id, learningSupportVisit2.id );
        assertEquals( learningSupportVisitsDtoTest[1].time, learningSupportVisit2.time);
        assertEquals( learningSupportVisitsDtoTest[1].details, learningSupportVisit2.details);
        assertEquals( learningSupportVisitsDtoTest[1].date, learningSupportVisit2.date);
        assertEquals( learningSupportVisitsDtoTest[1].duration, learningSupportVisit2.duration);
    }
    
    @Test
    public void testEquals_Same() {
        LearningSupportVisitDto learningSupportVisitDto1 = new LearningSupportVisitDto(learningSupportVisit1 )
        LearningSupportVisitDto learningSupportVisitDto2 = new LearningSupportVisitDto(learningSupportVisit1 )
        assertEquals(learningSupportVisitDto1, learningSupportVisitDto2)
    }
    
    @Test
    public void testEquals_Different() {
        LearningSupportVisitDto learningSupportVisitDto1 = new LearningSupportVisitDto(learningSupportVisit1)
        LearningSupportVisitDto learningSupportVisitDto2 = new LearningSupportVisitDto(learningSupportVisit2)
        assertNotEquals(learningSupportVisitDto1, learningSupportVisitDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        LearningSupportVisitDto learningSupportVisitDto1 = new LearningSupportVisitDto(learningSupportVisit1)
        LearningSupportVisitDto learningSupportVisitDto2 = new LearningSupportVisitDto(learningSupportVisit1)
        assertEquals(learningSupportVisitDto1.hashCode(), learningSupportVisitDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        LearningSupportVisitDto learningSupportVisitDto1 = new LearningSupportVisitDto(learningSupportVisit1)
        LearningSupportVisitDto learningSupportVisitDto2 = new LearningSupportVisitDto(learningSupportVisit2)
        assertNotEquals(learningSupportVisitDto1.hashCode(), learningSupportVisitDto2.hashCode())
    }
    
    @Test
    public void testConstructor_LearningSupportVisit() {
        LearningSupportVisitDto learningSupportVisitTest= new LearningSupportVisitDto(learningSupportVisit1)
        assertEquals( learningSupportVisitTest.time, learningSupportVisit1.time);
        assertEquals( learningSupportVisitTest.details, learningSupportVisit1.details);
        assertEquals( learningSupportVisitTest.date, learningSupportVisit1.date)
        assertEquals( learningSupportVisitTest.duration, learningSupportVisit1.duration)
    }
    
    @Test
    public void testConstructor_NullStudent() {
        LearningSupportVisitDto learningSupportVisitTest= new LearningSupportVisitDto(learningSupportVisit3)
        assertEquals( learningSupportVisitTest.studentId, learningSupportVisit3.student);
        assertEquals( learningSupportVisitTest.time, learningSupportVisit3.time);
        assertEquals( learningSupportVisitTest.details, learningSupportVisit3.details);
        assertEquals( learningSupportVisitTest.date, learningSupportVisit3.date)
        assertEquals( learningSupportVisitTest.duration, learningSupportVisit3.duration)
    }
    
    
    @Test
    public void testConstructor_NullCollegeFundPaid() {
        LearningSupportVisit learningSupportVisit = null
        LearningSupportVisitDto learningSupportVisitDto = new LearningSupportVisitDto(learningSupportVisit)
        assertEquals( learningSupportVisit, null);
    }
}
