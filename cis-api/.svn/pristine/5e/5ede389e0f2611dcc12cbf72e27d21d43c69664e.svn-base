package uk.ac.reigate.dto.interimreport;

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.AcademicYear;
import uk.ac.reigate.domain.interimreport.InterimReport
import uk.ac.reigate.dto.interimreport.InterimReportDto

import static org.junit.Assert.*



public class InterimReportDtoTest {
    
    private InterimReport interimReport1
    
    private InterimReport interimReport2
    
    private InterimReport interimReport3
    
    private List<InterimReport> interimReports
    
    AcademicYear createAcademicYear() {
        AcademicYear year = new AcademicYear()
    }
    
    @Before
    public void setup() {
        interimReport1 = new InterimReport(
                id: 1,
                year: createAcademicYear(),
                description:'MAth',
                startDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                endDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                publishDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                active: true
                );
        interimReport2 = new InterimReport(
                id: 2,
                year: createAcademicYear(),
                description:'MAth',
                startDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                endDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                publishDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                active: true
                );
        interimReport3 = new InterimReport(
                id: 2,
                year: null,
                description:'MAth',
                startDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                endDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                publishDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                active: true
                );
        interimReports = Arrays.asList(interimReport1, interimReport2);
    }
    
    @Test
    public void testMapFromInterimReportEntity(){
        InterimReportDto interimReportTest = InterimReportDto.mapFromEntity( interimReport1 )
        assertEquals( interimReportTest.id, interimReport1.id );
        assertEquals( interimReportTest.description, interimReport1.description);
        assertEquals( interimReportTest.startDate, interimReport1.startDate)
        assertEquals( interimReportTest.endDate, interimReport1.endDate)
        assertEquals( interimReportTest.yearId, interimReport1.year.id)
        assertEquals( interimReportTest.publishDate, interimReport1.publishDate)
    }
    
    @Test
    public void testMapFromInterimReportsEntities(){
        List<InterimReportDto> interimReportsDtoTest = InterimReportDto.mapFromList( interimReports )
        assertEquals( interimReportsDtoTest[0].id, interimReport1.id );
        assertEquals( interimReportsDtoTest[0].description, interimReport1.description);
        assertEquals( interimReportsDtoTest[0].startDate, interimReport1.startDate);
        assertEquals( interimReportsDtoTest[0].endDate, interimReport1.endDate);
        assertEquals( interimReportsDtoTest[0].yearId, interimReport1.year.id);
        assertEquals( interimReportsDtoTest[0].publishDate, interimReport1.publishDate);
        assertEquals( interimReportsDtoTest[1].id, interimReport2.id );
        assertEquals( interimReportsDtoTest[1].description, interimReport2.description);
        assertEquals( interimReportsDtoTest[1].startDate, interimReport2.startDate);
        assertEquals( interimReportsDtoTest[1].endDate, interimReport2.endDate);
        assertEquals( interimReportsDtoTest[1].yearId, interimReport2.year.id);
        assertEquals( interimReportsDtoTest[1].publishDate, interimReport2.publishDate);
    }
    
    @Test
    public void testEquals_Same() {
        InterimReportDto interimReportDto1 = new InterimReportDto(interimReport1)
        InterimReportDto interimReportDto2 = new InterimReportDto(interimReport1)
        assertEquals(interimReportDto1, interimReportDto2)
    }
    
    @Test
    public void testEquals_Different() {
        InterimReportDto interimReportDto1 = new InterimReportDto(interimReport1)
        InterimReportDto interimReportDto2 = new InterimReportDto(interimReport2)
        assertNotEquals(interimReportDto1, interimReportDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        InterimReportDto interimReportDto1 = new InterimReportDto(interimReport1)
        InterimReportDto interimReportDto2 = new InterimReportDto(interimReport1)
        assertEquals(interimReportDto1.hashCode(), interimReportDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        InterimReportDto interimReportDto1 = new InterimReportDto(interimReport1)
        InterimReportDto interimReportDto2 = new InterimReportDto(interimReport2)
        assertNotEquals(interimReportDto1.hashCode(), interimReportDto2.hashCode())
    }
    
    @Test
    public void testConstructor_InterimReport() {
        InterimReportDto interimReportTest= new InterimReportDto(interimReport1)
        assertEquals( interimReportTest.description, interimReport1.description);
        assertEquals( interimReportTest.startDate, interimReport1.startDate)
        assertEquals( interimReportTest.endDate, interimReport1.endDate)
        assertEquals( interimReportTest.yearId, interimReport1.year.id)
        assertEquals( interimReportTest.publishDate, interimReport1.publishDate)
    }
    
    @Test
    public void testConstructor_NullInterimReport() {
        InterimReport interReport = null
        InterimReportDto interimReportTest = new InterimReportDto(interReport)
        assertEquals( interimReportTest.description, null);
    }
    
    @Test
    public void testConstructor_NullAcademicYear() {
        InterimReportDto interimReportTest= new InterimReportDto(interimReport3)
        assertEquals( interimReportTest.description, interimReport3.description);
        assertEquals( interimReportTest.startDate, interimReport3.startDate)
        assertEquals( interimReportTest.endDate, interimReport3.endDate)
        assertEquals( interimReportTest.yearId, interimReport3.year)
        assertEquals( interimReportTest.publishDate, interimReport3.publishDate)
    }
}
