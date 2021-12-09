package uk.ac.reigate.dto.interimreport;

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.AcademicYear;
import uk.ac.reigate.domain.interimreport.InterimReport
import uk.ac.reigate.dto.interimreport.InterimReportSummaryDto

import static org.junit.Assert.*

public class InterimReportSummaryDtoTest {
    
    private InterimReport interimReport1
    
    private InterimReport interimReport2
    
    private List<InterimReport> interimReports
    
    AcademicYear createAcademicYear() {
        AcademicYear year = new AcademicYear()
    }
    
    @Before
    public void setup() {
        interimReport1 = new InterimReport(
                id: 1,
                year: createAcademicYear(),
                description:'MAth'
                );
        interimReport2 = new InterimReport(
                id: 2,
                year: createAcademicYear(),
                description:'MAth'
                );
        interimReports = Arrays.asList(interimReport1, interimReport2);
    }
    
    @Test
    public void testMapFromInterimReportEntity(){
        InterimReportSummaryDto interimReportTest = InterimReportSummaryDto.mapFromEntity( interimReport1 )
        assertEquals( interimReportTest.id, interimReport1.id );
        assertEquals( interimReportTest.description, interimReport1.description);
    }
    
    @Test
    public void testMapFromInterimReportsEntities(){
        List<InterimReportSummaryDto> interimReportsDtoTest = InterimReportSummaryDto.mapFromList( interimReports )
        assertEquals( interimReportsDtoTest[0].id, interimReport1.id );
        assertEquals( interimReportsDtoTest[0].description, interimReport1.description);
        assertEquals( interimReportsDtoTest[1].id, interimReport2.id );
        assertEquals( interimReportsDtoTest[1].description, interimReport2.description);
    }
    
    @Test
    public void testEquals_Same() {
        InterimReportSummaryDto interimReportDto1 = new InterimReportSummaryDto(interimReport1)
        InterimReportSummaryDto interimReportDto2 = new InterimReportSummaryDto(interimReport1)
        assertEquals(interimReportDto1, interimReportDto2)
    }
    
    @Test
    public void testEquals_Different() {
        InterimReportSummaryDto interimReportDto1 = new InterimReportSummaryDto(interimReport1)
        InterimReportSummaryDto interimReportDto2 = new InterimReportSummaryDto(interimReport2)
        assertNotEquals(interimReportDto1, interimReportDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        InterimReportSummaryDto interimReportDto1 = new InterimReportSummaryDto(interimReport1)
        InterimReportSummaryDto interimReportDto2 = new InterimReportSummaryDto(interimReport1)
        assertEquals(interimReportDto1.hashCode(), interimReportDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        InterimReportSummaryDto interimReportDto1 = new InterimReportSummaryDto(interimReport1)
        InterimReportSummaryDto interimReportDto2 = new InterimReportSummaryDto(interimReport2)
        assertNotEquals(interimReportDto1.hashCode(), interimReportDto2.hashCode())
    }
    
    @Test
    public void testConstructor_InterimReport() {
        InterimReportSummaryDto interimReportTest= new InterimReportSummaryDto(interimReport1)
        assertEquals( interimReportTest.description, interimReport1.description);
    }
}
