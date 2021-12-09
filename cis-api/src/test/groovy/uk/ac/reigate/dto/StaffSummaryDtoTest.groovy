package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.lookup.StaffType
import uk.ac.reigate.exceptions.InvalidDataException


public class StaffSummaryDtoTest {
    
    private Staff staff1
    
    private Staff staff2
    
    private List<Staff> staffs
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Before
    public void setup() {
        staff1 = new Staff(
                id: 1,
                person: new Person(id:1),
                type: new StaffType(id:1),
                initials:'Staff'
                );
        staff2 = new Staff(
                id: 2,
                initials:'MIS Developer'
                );
        staffs = Arrays.asList(staff1, staff2);
    }
    
    @Test
    public void testMapFromStaffEntity(){
        StaffSummaryDto staffTest = StaffSummaryDto.mapFromEntity( staff1 )
        assertEquals( staffTest.id, staff1.id );
        assertEquals( staffTest.initials, staff1.initials);
    }
    
    @Test
    public void testMapFromStaffsEntities(){
        List<StaffSummaryDto> staffSummaryDtoTest = StaffSummaryDto.mapFromList( staffs )
        assertEquals( staffSummaryDtoTest[0].id, staff1.id );
        assertEquals( staffSummaryDtoTest[0].initials, staff1.initials);
        assertEquals( staffSummaryDtoTest[1].id, staff2.id );
        assertEquals( staffSummaryDtoTest[1].initials, staff2.initials);
    }
    
    @Test
    public void testEquals_Same() {
        StaffSummaryDto staffSummaryDto1 = new StaffSummaryDto(staff1)
        StaffSummaryDto staffSummaryDto2 = new StaffSummaryDto(staff1)
        assertEquals(staffSummaryDto1, staffSummaryDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StaffSummaryDto staffSummaryDto1 = new StaffSummaryDto(staff1)
        StaffSummaryDto staffSummaryDto2 = new StaffSummaryDto(staff2)
        assertNotEquals(staffSummaryDto1, staffSummaryDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StaffSummaryDto staffSummaryDto1 = new StaffSummaryDto(staff1)
        StaffSummaryDto staffSummaryDto2 = new StaffSummaryDto(staff1)
        assertEquals(staffSummaryDto1.hashCode(), staffSummaryDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StaffSummaryDto staffSummaryDto1 = new StaffSummaryDto(staff1)
        StaffSummaryDto staffSummaryDto2 = new StaffSummaryDto(staff2)
        assertNotEquals(staffSummaryDto1.hashCode(), staffSummaryDto2.hashCode())
    }
    
    @Test
    public void testConstructor_Staff() {
        StaffSummaryDto staffSummaryDto = new StaffSummaryDto(staff1)
        assertEquals( staffSummaryDto.initials, staff1.initials )
    }
    
    @Test
    public void testConstructor_NullStaff() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create StaffSummaryDto from null object.")
        Staff staff = null
        StaffSummaryDto staffSummaryDto = new StaffSummaryDto(staff)
    }
}
