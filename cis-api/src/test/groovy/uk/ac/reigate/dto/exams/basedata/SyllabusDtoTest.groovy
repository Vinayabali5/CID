package uk.ac.reigate.dto.exams.basedata;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.basedata.ExamSeries
import uk.ac.reigate.domain.exams.basedata.Syllabus

public class SyllabusDtoTest {
    
    private Syllabus syllabus1
    
    private Syllabus syllabus2
    
    private Syllabus syllabus3
    
    private List<Syllabus> syllabusList
    
    @Before
    public void setup() {
        syllabus1 = new Syllabus(
                id: 1,
                examSeries : new ExamSeries(id: 1),
                code: 'maths',
                title: 'MA',
                examOptions: [
                    new ExamOption(id:1 )]
                );
        syllabus2 = new Syllabus(
                id: 2,
                examSeries : new ExamSeries(id: 2),
                code: 'maths',
                title: 'MA',
                examOptions: [
                    new ExamOption(id:1 )]
                );
        syllabus3 = new Syllabus(
                id: 2,
                examSeries : null,
                code: 'maths',
                title: 'MA',
                examOptions: [
                    new ExamOption(id:1 )]
                );
        syllabusList = Arrays.asList(syllabus1, syllabus2);
    }
    
    @Test
    public void testMapFromSyllabusEntity(){
        SyllabusDto syllabusTest = SyllabusDto.mapFromEntity( syllabus1 )
        assertEquals( syllabusTest.id, syllabus1.id );
        assertEquals( syllabusTest.examSeriesId, syllabus1.examSeries.id);
        assertEquals( syllabusTest.code, syllabus1.code);
        assertEquals( syllabusTest.title, syllabus1.title);
    }
    
    @Test
    public void testMapFromSyllabussEntities(){
        List<SyllabusDto> syllabusTest = SyllabusDto.mapFromList( syllabusList )
        assertEquals( syllabusTest[0].id, syllabus1.id );
        assertEquals( syllabusTest[0].examSeriesId, syllabus1.examSeries.id);
        assertEquals( syllabusTest[0].code, syllabus1.code);
        assertEquals( syllabusTest[0].title, syllabus1.title);
        assertEquals( syllabusTest[1].id, syllabus2.id );
        assertEquals( syllabusTest[1].examSeriesId, syllabus2.examSeries.id);
        assertEquals( syllabusTest[1].code, syllabus2.code);
        assertEquals( syllabusTest[1].title, syllabus2.title);
    }
    
    @Test
    public void testConstructor_Syllabus() {
        SyllabusDto syllabusTest = new SyllabusDto(syllabus1)
        assertEquals( syllabusTest.id, syllabus1.id );
        assertEquals( syllabusTest.examSeriesId, syllabus1.examSeries.id);
        assertEquals( syllabusTest.code, syllabus1.code);
        assertEquals( syllabusTest.title, syllabus1.title);
    }
    
    @Test
    public void testConstructor_NullExamSeries() {
        SyllabusDto syllabusTest = new SyllabusDto(syllabus3)
        assertEquals( syllabusTest.id, syllabus3.id );
        assertEquals( syllabusTest.examSeriesId, syllabus3.examSeries);
        assertEquals( syllabusTest.code, syllabus3.code);
        assertEquals( syllabusTest.title, syllabus3.title);
    }
    
    @Test
    public void testEquals_Same() {
        SyllabusDto syllabusDto1 = new SyllabusDto(syllabus1);
        SyllabusDto syllabusDto2 = new SyllabusDto(syllabus1);
        assertEquals( syllabusDto1, syllabusDto2)
    }
    
    @Test
    public void testEquals_Different() {
        SyllabusDto syllabusDto1 = new SyllabusDto(syllabus1);
        SyllabusDto syllabusDto2 = new SyllabusDto(syllabus2);
        assertNotEquals( syllabusDto1, syllabusDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        SyllabusDto syllabusDto1 = new SyllabusDto(syllabus1);
        SyllabusDto syllabusDto2 = new SyllabusDto(syllabus1);
        assertEquals( syllabusDto1.hashCode(), syllabusDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        SyllabusDto syllabusDto1 = new SyllabusDto(syllabus1);
        SyllabusDto syllabusDto2 = new SyllabusDto(syllabus2);
        assertNotEquals( syllabusDto1.hashCode(), syllabusDto2.hashCode())
    }
}
