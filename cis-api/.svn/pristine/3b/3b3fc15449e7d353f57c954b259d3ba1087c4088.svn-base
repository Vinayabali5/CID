package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.lookup.ReportingPeriod

public class ReportingPeriodDtoTest {
    
    private ReportingPeriod reportingPeriod1
    
    private ReportingPeriod reportingPeriod2
    
    private List<ReportingPeriod> reportingPeriods
    
    @Before
    public void setup() {
        this.reportingPeriod1 = new ReportingPeriod(
                id: 1,
                academicYear: new AcademicYear(id:1),
                name: 'A',
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2017/09/01')
                );
        this.reportingPeriod2 = new ReportingPeriod(
                id: 2,
                academicYear: null,
                name: 'B',
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('20175/09/01')
                );
        this.reportingPeriods = Arrays.asList(this.reportingPeriod1, this.reportingPeriod2);
    }
    
    @Test
    void testConstructor_reportingPeriod() {
        ReportingPeriodDto reportingPeriodTest = new ReportingPeriodDto( reportingPeriod1 )
        assertEquals( reportingPeriodTest.id, reportingPeriod1.id );
        assertEquals( reportingPeriodTest.name, reportingPeriod1.name);
        assertEquals( reportingPeriodTest.startDate, reportingPeriod1.startDate);
    }
    
    @Test
    void testConstructor_NullAcademicYear() {
        ReportingPeriodDto reportingPeriodTest = new ReportingPeriodDto( reportingPeriod2 )
        assertEquals( reportingPeriodTest.id, reportingPeriod2.id );
        assertEquals( reportingPeriodTest.name, reportingPeriod2.name);
        assertEquals( reportingPeriodTest.academicYearId, reportingPeriod2.academicYear );
        assertEquals( reportingPeriodTest.startDate, reportingPeriod2.startDate);
    }
    
    @Test
    public void testMapFromReportingPeriodEntity(){
        ReportingPeriodDto reportingPeriodTest = ReportingPeriodDto.mapFromEntity( reportingPeriod1 )
        assertEquals( reportingPeriodTest.id, reportingPeriod1.id );
        assertEquals( reportingPeriodTest.name, reportingPeriod1.name);
        assertEquals( reportingPeriodTest.startDate, reportingPeriod1.startDate);
    }
    
    @Test
    public void testMapFromReportingPeriodsEntities(){
        List<ReportingPeriodDto> reportingPeriodsTest = ReportingPeriodDto.mapFromList( this.reportingPeriods )
        assertEquals( reportingPeriodsTest[0].id, reportingPeriod1.id );
        assertEquals( reportingPeriodsTest[0].name, reportingPeriod1.name );
        assertEquals( reportingPeriodsTest[0].startDate, reportingPeriod1.startDate);
        assertEquals( reportingPeriodsTest[1].id, reportingPeriod2.id );
        assertEquals( reportingPeriodsTest[1].name, reportingPeriod2.name );
        assertEquals( reportingPeriodsTest[1].startDate, reportingPeriod2.startDate);
    }
    
    @Test
    public void testEquals_Same() {
        ReportingPeriodDto reportingPeriodDto1 = new ReportingPeriodDto(reportingPeriod1)
        ReportingPeriodDto reportingPeriodDto2 = new ReportingPeriodDto(reportingPeriod1)
        assertEquals( reportingPeriodDto1, reportingPeriodDto2)
    }
    
    @Test
    public void testEquals_Different() {
        ReportingPeriodDto reportingPeriodDto1 = new ReportingPeriodDto(reportingPeriod1)
        ReportingPeriodDto reportingPeriodDto2 = new ReportingPeriodDto(reportingPeriod2)
        assertNotEquals( reportingPeriodDto1, reportingPeriodDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        ReportingPeriodDto reportingPeriodDto1 = new ReportingPeriodDto(reportingPeriod1)
        ReportingPeriodDto reportingPeriodDto2 = new ReportingPeriodDto(reportingPeriod1)
        assertEquals( reportingPeriodDto1.hashCode(), reportingPeriodDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        ReportingPeriodDto reportingPeriodDto1 = new ReportingPeriodDto(reportingPeriod1)
        ReportingPeriodDto reportingPeriodDto2 = new ReportingPeriodDto(reportingPeriod2)
        assertNotEquals( reportingPeriodDto1.hashCode(), reportingPeriodDto2.hashCode())
    }
    
    @Test
    public void testConstructor_ReportingPeriod() {
        ReportingPeriodDto reportingPeriodDto = new ReportingPeriodDto(reportingPeriod1)
        assertEquals( reportingPeriodDto.name, reportingPeriod1.name )
        assertEquals( reportingPeriodDto.startDate, reportingPeriod1.startDate )
        assertEquals( reportingPeriodDto.endDate, reportingPeriod1.endDate )
    }
}
