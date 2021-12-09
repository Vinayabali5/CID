package uk.ac.reigate.dto.exams.basedata;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.basedata.ExamSeries
import uk.ac.reigate.domain.exams.basedata.Syllabus

public class SyllabusSummaryDtoTest {
    
    private Syllabus syllabus1
    
    private Syllabus syllabus2
    
    private List<Syllabus> syllabusList
    
    @Before
    public void setup() {
        syllabus1 = new Syllabus(
                id: 1,
                examSeries : new ExamSeries(id: 1),
                code: 'maths',
                title: 'MA'
                )
        syllabus2 = new Syllabus(
                id: 2,
                examSeries : new ExamSeries(id: 2),
                code: 'maths',
                title: 'MA'
                )
        syllabusList = Arrays.asList(syllabus1, syllabus2);
    }
    
    @Test
    public void testMapFromSyllabusEntity(){
        SyllabusSummaryDto syllabusTest = SyllabusSummaryDto.mapFromEntity( syllabus1 )
        assertEquals( syllabusTest.id, syllabus1.id );
        assertEquals( syllabusTest.code, syllabus1.code);
        assertEquals( syllabusTest.title, syllabus1.title);
    }
    
    @Test
    public void testMapFromSyllabussEntities(){
        List<SyllabusSummaryDto> syllabusTest = SyllabusSummaryDto.mapFromList( syllabusList )
        assertEquals( syllabusTest[0].id, syllabus1.id );
        assertEquals( syllabusTest[0].code, syllabus1.code);
        assertEquals( syllabusTest[0].title, syllabus1.title);
        assertEquals( syllabusTest[1].id, syllabus2.id );
        assertEquals( syllabusTest[1].code, syllabus2.code);
        assertEquals( syllabusTest[1].title, syllabus2.title);
    }
    
    @Test
    public void testConstructor_Syllabus() {
        SyllabusSummaryDto syllabusTest = new SyllabusSummaryDto(syllabus1)
        assertEquals( syllabusTest.id, syllabus1.id );
        assertEquals( syllabusTest.code, syllabus1.code);
        assertEquals( syllabusTest.title, syllabus1.title);
    }
    
    @Test
    public void testEquals_Same() {
        SyllabusSummaryDto syllabusDto1 = new SyllabusSummaryDto(syllabus1);
        SyllabusSummaryDto syllabusDto2 = new SyllabusSummaryDto(syllabus1);
        assertEquals( syllabusDto1, syllabusDto2)
    }
    
    @Test
    public void testEquals_Different() {
        SyllabusSummaryDto syllabusDto1 = new SyllabusSummaryDto(syllabus1);
        SyllabusSummaryDto syllabusDto2 = new SyllabusSummaryDto(syllabus2);
        assertNotEquals( syllabusDto1, syllabusDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        SyllabusSummaryDto syllabusDto1 = new SyllabusSummaryDto(syllabus1);
        SyllabusSummaryDto syllabusDto2 = new SyllabusSummaryDto(syllabus1);
        assertEquals( syllabusDto1.hashCode(), syllabusDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        SyllabusSummaryDto syllabusDto1 = new SyllabusSummaryDto(syllabus1);
        SyllabusSummaryDto syllabusDto2 = new SyllabusSummaryDto(syllabus2);
        assertNotEquals( syllabusDto1.hashCode(), syllabusDto2.hashCode())
    }
}
