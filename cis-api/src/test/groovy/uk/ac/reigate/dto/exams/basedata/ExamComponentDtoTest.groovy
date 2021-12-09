package uk.ac.reigate.dto.exams.basedata;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.domain.exams.basedata.ExamSeries

public class ExamComponentDtoTest {
    
    private ExamComponent examComponent1
    
    private ExamComponent examComponent2
    
    private ExamComponent examComponent3
    
    private List<ExamComponent> examComponents
    
    @Before
    public void setupTests() {
        this.examComponent1 = new ExamComponent(
                id: 1,
                examSeries: new ExamSeries(id: 1),
                code: 'T',
                title: 'TT',
                teacherMarks: 'Test',
                maximumMark: 10,
                gradeset : 'A',
                dueDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                timetabled: 'Mat',
                timetableDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                timetableSession: 'test',
                timeAllowed : 5
                );
        this.examComponent2 = new ExamComponent(
                id: 2,
                examSeries: new ExamSeries(id: 1),
                code: 'T',
                title: 'TT',
                teacherMarks: 'Test',
                maximumMark: 10,
                gradeset : 'A',
                dueDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                timetabled: 'Mat',
                timetableDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                timetableSession: 'test',
                timeAllowed : 5
                );
        this.examComponent3 = new ExamComponent(
                id: 2,
                examSeries: null,
                code: 'T',
                title: 'TT',
                teacherMarks: 'Test',
                maximumMark: 10,
                gradeset : 'A',
                dueDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                timetabled: 'Mat',
                timetableDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                timetableSession: 'test',
                timeAllowed : 5
                );
        this.examComponents = Arrays.asList(examComponent1, examComponent2);
    }
    
    ExamComponentDto generateExamComponentDto() {
        return generateExamComponent1Dto()
    }
    
    ExamComponentDto generateExamComponent1Dto(){
        return new ExamComponentDto(examComponent1)
    }
    
    ExamComponentDto generateExamComponent2Dto(){
        return new ExamComponentDto(examComponent2)
    }
    
    @Test
    public void testMapFromExamComponentEntityTest(){
        ExamComponentDto examComponentTest = ExamComponentDto.mapFromEntity( examComponent1 )
        assertEquals( examComponentTest.id, examComponent1.id );
        assertEquals( examComponentTest.examSeriesId, examComponent1.examSeries.id);
        assertEquals( examComponentTest.code, examComponent1.code);
        assertEquals( examComponentTest.title, examComponent1.title);
        assertEquals( examComponentTest.teacherMarks, examComponent1.teacherMarks);
        assertEquals( examComponentTest.maximumMark, examComponent1.maximumMark);
        assertEquals( examComponentTest.gradeset, examComponent1.gradeset);
        assertEquals( examComponentTest.dueDate, examComponent1.dueDate);
        assertEquals( examComponentTest.timetabled, examComponent1.timetabled);
        assertEquals( examComponentTest.timetableDate, examComponent1.timetableDate);
        assertEquals( examComponentTest.timetableSession, examComponent1.timetableSession);
        assertEquals( examComponentTest.timeAllowed, examComponent1.timeAllowed);
    }
    
    @Test
    public void testMapFromExamComponentEntitiesTest(){
        List<ExamComponentDto> examComponentTest = ExamComponentDto.mapFromList(examComponents)
        assertEquals( examComponentTest[0].id, examComponent1.id );
        assertEquals( examComponentTest[0].examSeriesId, examComponent1.examSeries.id);
        assertEquals( examComponentTest[0].code, examComponent1.code);
        assertEquals( examComponentTest[0].title, examComponent1.title);
        assertEquals( examComponentTest[0].teacherMarks, examComponent1.teacherMarks);
        assertEquals( examComponentTest[0].maximumMark, examComponent1.maximumMark);
        assertEquals( examComponentTest[0].gradeset, examComponent1.gradeset);
        assertEquals( examComponentTest[0].dueDate, examComponent1.dueDate);
        assertEquals( examComponentTest[0].timetabled, examComponent1.timetabled);
        assertEquals( examComponentTest[0].timetableDate, examComponent1.timetableDate);
        assertEquals( examComponentTest[0].timetableSession, examComponent1.timetableSession);
        assertEquals( examComponentTest[0].timeAllowed, examComponent1.timeAllowed);
        assertEquals( examComponentTest[1].id, examComponent2.id );
        assertEquals( examComponentTest[1].examSeriesId, examComponent2.examSeries.id);
        assertEquals( examComponentTest[1].code, examComponent2.code);
        assertEquals( examComponentTest[1].title, examComponent2.title);
        assertEquals( examComponentTest[1].teacherMarks, examComponent2.teacherMarks);
        assertEquals( examComponentTest[1].maximumMark, examComponent2.maximumMark);
        assertEquals( examComponentTest[1].gradeset, examComponent2.gradeset);
        assertEquals( examComponentTest[1].dueDate, examComponent2.dueDate);
        assertEquals( examComponentTest[1].timetabled, examComponent2.timetabled);
        assertEquals( examComponentTest[1].timetableDate, examComponent2.timetableDate);
        assertEquals( examComponentTest[1].timetableSession, examComponent2.timetableSession);
        assertEquals( examComponentTest[1].timeAllowed, examComponent2.timeAllowed);
    }
    
    @Test
    public void testEquals_Same() {
        ExamComponentDto examComponentDto1 = new ExamComponentDto(examComponent1)
        ExamComponentDto examComponentDto2 = new ExamComponentDto(examComponent1)
        assertEquals( examComponentDto1, examComponentDto2)
    }
    
    @Test
    public void testEquals_Different() {
        ExamComponentDto examComponentDto1 = new ExamComponentDto(examComponent1)
        ExamComponentDto examComponentDto2 = new ExamComponentDto(examComponent2)
        assertNotEquals( examComponentDto1, examComponentDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        ExamComponentDto examComponentDto1 = new ExamComponentDto(examComponent1)
        ExamComponentDto examComponentDto2 = new ExamComponentDto(examComponent1)
        assertEquals( examComponentDto1.hashCode(), examComponentDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        ExamComponentDto examComponentDto1 = new ExamComponentDto(examComponent1)
        ExamComponentDto examComponentDto2 = new ExamComponentDto(examComponent2)
        assertNotEquals( examComponentDto1.hashCode(), examComponentDto2.hashCode())
    }
    
    @Test
    public void testConstructor_ExamComponent() {
        ExamComponentDto examComponentTest = new ExamComponentDto(examComponent1)
        assertEquals( examComponentTest.examSeriesId, examComponent1.examSeries.id);
        assertEquals( examComponentTest.code, examComponent1.code);
        assertEquals( examComponentTest.title, examComponent1.title);
        assertEquals( examComponentTest.teacherMarks, examComponent1.teacherMarks);
        assertEquals( examComponentTest.maximumMark, examComponent1.maximumMark);
        assertEquals( examComponentTest.gradeset, examComponent1.gradeset);
        assertEquals( examComponentTest.dueDate, examComponent1.dueDate);
        assertEquals( examComponentTest.timetabled, examComponent1.timetabled);
        assertEquals( examComponentTest.timetableDate, examComponent1.timetableDate);
        assertEquals( examComponentTest.timetableSession, examComponent1.timetableSession);
        assertEquals( examComponentTest.timeAllowed, examComponent1.timeAllowed);
    }
    
    @Test
    public void testConstructor_NullAcademicYear() {
        ExamComponentDto examComponentTest = new ExamComponentDto(examComponent3)
        assertEquals( examComponentTest.examSeriesId, examComponent3.examSeries);
        assertEquals( examComponentTest.code, examComponent3.code);
        assertEquals( examComponentTest.title, examComponent3.title);
        assertEquals( examComponentTest.teacherMarks, examComponent3.teacherMarks);
        assertEquals( examComponentTest.maximumMark, examComponent3.maximumMark);
        assertEquals( examComponentTest.gradeset, examComponent3.gradeset);
        assertEquals( examComponentTest.dueDate, examComponent3.dueDate);
        assertEquals( examComponentTest.timetabled, examComponent3.timetabled);
        assertEquals( examComponentTest.timetableDate, examComponent3.timetableDate);
        assertEquals( examComponentTest.timetableSession, examComponent3.timetableSession);
        assertEquals( examComponentTest.timeAllowed, examComponent3.timeAllowed);
    }
}
