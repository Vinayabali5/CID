package uk.ac.reigate.dto.exams.basedata;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Faculty
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.basedata.ExamSeries

public class ExamSeriesDtoTest {
    
    private ExamBoard examBoard
    
    private AcademicYear academicYear
    
    private ExamSeries examSeries1
    
    private ExamSeries examSeries2
    
    private ExamSeries examSeries3
    
    private List<ExamSeries> examSeriess
    
    @Before
    public void setupTests() {
        this.examSeries1 = new ExamSeries(
                id: 1,
                academicYear: new AcademicYear(id: 20, description: '2018'),
                examBoard : new ExamBoard(id:1, boardIdentifier: '1A'),
                examSeries : '1A',
                examYear : '2020',
                entrySubmitted: true,
                nextSequenceNo : 11
                );
        this.examSeries2 = new ExamSeries(
                id: 2,
                academicYear: new AcademicYear(id: 20),
                examBoard : new ExamBoard(id:1, boardIdentifier: '1A'),
                examSeries : '1A',
                examYear : '2020',
                entrySubmitted: true,
                nextSequenceNo : 11
                );
        this.examSeries3 = new ExamSeries(
                id: 2,
                academicYear: null,
                examBoard : null,
                examSeries : '1A',
                examYear : '2020',
                entrySubmitted: true,
                nextSequenceNo : 11
                );
        this.examSeriess = Arrays.asList(examSeries1, examSeries2);
    }
    
    ExamSeriesDto generateExamSeriesDto() {
        return generateExamSeries1Dto()
    }
    
    ExamSeriesDto generateExamSeries1Dto(){
        return new ExamSeriesDto(examSeries1)
    }
    
    ExamSeriesDto generateExamSeries2Dto(){
        return new ExamSeriesDto(examSeries2)
    }
    
    @Test
    public void testMapFromExamSeriesEntityTest(){
        ExamSeriesDto examSeriesTest = ExamSeriesDto.mapFromEntity( examSeries1 )
        assertEquals( examSeriesTest.id, examSeries1.id );
        assertEquals( examSeriesTest.academicYearId, examSeries1.academicYear.id);
        assertEquals( examSeriesTest.examSeries, examSeries1.examSeries);
        assertEquals( examSeriesTest.entrySubmitted, examSeries1.entrySubmitted);
        assertEquals( examSeriesTest.nextSequenceNo, examSeries1.nextSequenceNo);
    }
    
    @Test
    public void testMapFromExamSeriesEntitiesTest(){
        List<ExamSeriesDto> examSeriesTest = ExamSeriesDto.mapFromList(examSeriess)
        assertEquals( examSeriesTest[0].id, examSeries1.id );
        assertEquals( examSeriesTest[0].academicYearId, examSeries1.academicYear.id);
        assertEquals( examSeriesTest[0].examSeries, examSeries1.examSeries);
        assertEquals( examSeriesTest[0].entrySubmitted, examSeries1.entrySubmitted);
        assertEquals( examSeriesTest[0].nextSequenceNo, examSeries1.nextSequenceNo);
        assertEquals( examSeriesTest[1].id, examSeries2.id );
        assertEquals( examSeriesTest[1].academicYearId, examSeries2.academicYear.id);
        assertEquals( examSeriesTest[1].examSeries, examSeries2.examSeries);
        assertEquals( examSeriesTest[1].entrySubmitted, examSeries2.entrySubmitted);
        assertEquals( examSeriesTest[1].nextSequenceNo, examSeries2.nextSequenceNo);
    }
    
    @Test
    public void testEquals_Same() {
        ExamSeriesDto examSeriesDto1 = new ExamSeriesDto(examSeries1)
        ExamSeriesDto examSeriesDto2 = new ExamSeriesDto(examSeries1)
        assertEquals( examSeriesDto1, examSeriesDto2)
    }
    
    @Test
    public void testEquals_Different() {
        ExamSeriesDto examSeriesDto1 = new ExamSeriesDto(examSeries1)
        ExamSeriesDto examSeriesDto2 = new ExamSeriesDto(examSeries2)
        assertNotEquals( examSeriesDto1, examSeriesDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        ExamSeriesDto examSeriesDto1 = new ExamSeriesDto(examSeries1)
        ExamSeriesDto examSeriesDto2 = new ExamSeriesDto(examSeries1)
        assertEquals( examSeriesDto1.hashCode(), examSeriesDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        ExamSeriesDto examSeriesDto1 = new ExamSeriesDto(examSeries1)
        ExamSeriesDto examSeriesDto2 = new ExamSeriesDto(examSeries2)
        assertNotEquals( examSeriesDto1.hashCode(), examSeriesDto2.hashCode())
    }
    
    @Test
    public void testConstructor_ExamSeries() {
        ExamSeriesDto examSeriesTest = new ExamSeriesDto(examSeries1)
        assertEquals( examSeriesTest.id, examSeries1.id );
        assertEquals( examSeriesTest.academicYearId, examSeries1.academicYear.id);
        assertEquals( examSeriesTest.examSeries, examSeries1.examSeries);
        assertEquals( examSeriesTest.entrySubmitted, examSeries1.entrySubmitted);
        assertEquals( examSeriesTest.nextSequenceNo, examSeries1.nextSequenceNo);
    }
    
    @Test
    public void testConstructor_NullAcademicYear() {
        ExamSeriesDto examSeriesTest = new ExamSeriesDto(examSeries3)
        assertEquals( examSeriesTest.id, examSeries3.id );
        assertEquals( examSeriesTest.academicYearId, examSeries3.academicYear);
        assertEquals( examSeriesTest.examSeries, examSeries3.examSeries);
        assertEquals( examSeriesTest.entrySubmitted, examSeries3.entrySubmitted);
        assertEquals( examSeriesTest.nextSequenceNo, examSeries3.nextSequenceNo);
    }
    
    @Test
    public void testMethod_Get_AcademicYearDesc() {
        ExamSeriesDto examSeriesDto1 = new ExamSeriesDto(examSeries1)
        assertEquals(examSeriesDto1.academicYear.description, examSeriesDto1.get_AcademicYearDesc())
    }
    
    @Test
    public void testMethod_Get_NullAcademicYearDesc() {
        ExamSeriesDto examSeriesDto1 = new ExamSeriesDto(examSeries3)
        assertEquals(examSeriesDto1.academicYear, examSeriesDto1.get_AcademicYearDesc())
    }
}
