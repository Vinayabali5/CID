package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import uk.ac.reigate.domain.academic.AcademicYear;
import uk.ac.reigate.domain.academic.Holiday
import uk.ac.reigate.exceptions.InvalidDataException

public class HolidayDtoTest {
    
    private AcademicYear year
    
    private Holiday holiday1
    
    private Holiday holiday2
    
    private Holiday holiday3
    
    private List<Holiday> holidays
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Before
    public void setup() {
        this.year = new AcademicYear()
        this.holiday1 = new Holiday(
                id: 1,
                year: year,
                description: 'Academic Year 15/16',
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09'),
                halfTerm: true
                );
        this.holiday2 = new Holiday(
                id: 2,
                year: year,
                description: 'Academic Year 15/15',
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/08/09'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2013/08/09'),
                halfTerm: true
                );
        this.holiday3 = new Holiday(
                id: 3,
                year: null,
                description: 'Academic Year 15/15',
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/08/09'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2013/08/09'),
                halfTerm: true
                );
        this.holidays = Arrays.asList(this.holiday1, this.holiday2);
    }
    
    HolidayDto generateHolidayDto() {
        return generateHoliday1Dto()
    }
    
    HolidayDto generateHoliday1Dto() {
        return new HolidayDto(holiday1.id, holiday1.year.id, holiday1.description, holiday1.startDate, holiday1.endDate, holiday1.halfTerm)
    }
    
    HolidayDto generateHoliday2Dto() {
        return new HolidayDto(holiday2.id, holiday2.year.id, holiday2.description, holiday2.startDate, holiday2.endDate, holiday2.halfTerm)
    }
    
    @Test
    public void testConstructor_NullHoliday() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create HolidayDto from null object.")
        Holiday holiday = null
        HolidayDto holidayDto = new HolidayDto(holiday)
    }
    
    @Test
    public void testConstructor_NullYear() {
        HolidayDto holidayTest = new HolidayDto(holiday3)
        assertEquals( holidayTest.id, holiday3.id);
        assertEquals( holidayTest.yearId, null);
        assertEquals( holidayTest.description, holiday3.description);
        assertEquals( holidayTest.startDate, holiday3.startDate);
        assertEquals( holidayTest.endDate, holiday3.endDate);
    }
    
    @Test
    public void testMapFromHolidayEntity() {
        HolidayDto holidayTest = HolidayDto.mapFromEntity( holiday1 );
        assertEquals( holidayTest.id, holiday1.id);
        assertEquals( holidayTest.yearId, holiday1.year.id);
        assertEquals( holidayTest.description, holiday1.description);
        assertEquals( holidayTest.startDate, holiday1.startDate);
        assertEquals( holidayTest.endDate, holiday1.endDate);
    }
    
    @Test
    public void testMapFromHolidaysEntities(){
        List<HolidayDto> holidayTest = HolidayDto.mapFromList( holidays )
        assertEquals( holidayTest [0].id, holiday1.id);
        assertEquals( holidayTest [0].yearId, holiday1.year.id);
        assertEquals( holidayTest [0].description, holiday1.description);
        assertEquals( holidayTest [0].startDate, holiday1.startDate);
        assertEquals( holidayTest [0].endDate, holiday1.endDate);
        assertEquals( holidayTest [1].id, holiday2.id );
        assertEquals( holidayTest [1].yearId,  holiday2.year.id);
        assertEquals( holidayTest [1].description, holiday2.description );
        assertEquals( holidayTest [1].startDate, holiday2.startDate);
        assertEquals( holidayTest [1].endDate, holiday2.endDate);
    }
    
    @Test
    public void testEquals_Same() {
        HolidayDto holidayDto1 = new HolidayDto(holiday1)
        HolidayDto holidayDto2 = new HolidayDto(holiday1)
        assertEquals(holidayDto1, holidayDto2)
    }
    
    @Test
    public void testEquals_Different() {
        HolidayDto holidayDto1 = new HolidayDto(holiday1)
        HolidayDto holidayDto2 = new HolidayDto(holiday2)
        assertNotEquals(holidayDto1, holidayDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        HolidayDto holidayDto1 = new HolidayDto(holiday1)
        HolidayDto holidayDto2 = new HolidayDto(holiday1)
        assertEquals(holidayDto1.hashCode(), holidayDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        HolidayDto holidayDto1 = new HolidayDto(holiday1)
        HolidayDto holidayDto2 = new HolidayDto(holiday2)
        assertNotEquals(holidayDto1.hashCode(), holidayDto2.hashCode())
    }
    
    @Test
    public void testMethod_Get_NullYearDescription() {
        HolidayDto holidayDto1 = new HolidayDto(holiday3)
        assertEquals(holidayDto1.year, holidayDto1.get_YearDescription())
    }
    
    @Test
    public void testMethod_Get_YearDescription() {
        HolidayDto holidayDto1 = new HolidayDto(holiday1)
        assertEquals(holidayDto1.year.description, holidayDto1.get_YearDescription())
    }
}
