package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Address
import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.lookup.Gender
import uk.ac.reigate.domain.lookup.LegalSex
import uk.ac.reigate.domain.lookup.StaffType
import uk.ac.reigate.domain.lookup.Title



public class StaffDtoTest {
    
    private Person person
    
    private StaffType type
    
    private Staff staff1
    
    private Staff staff2
    
    private List<Staff> staffs
    
    @Before
    public void setupTests() {
        this.person =  new Person(id:1)
        this.type = new StaffType()
        this.staff1 = new Staff(
                id: 1,
                person: person,
                type: type,
                onTimetable: true,
                initials: 'vbm',
                knownAs: 'vinaya',
                networkLogin:'vbm',
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09'),
                staffRef: 11,
                staffDetailsId: 1
                );
        this.staff2 = new Staff(
                id: 2,
                person: person,
                type: type,
                onTimetable: true,
                initials: 'vbm',
                knownAs: 'vinaya',
                networkLogin:'vbm',
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09'),
                staffRef: 12,
                staffDetailsId: 2
                
                );
        this.staffs = Arrays.asList(staff1, staff2);
    }
    
    StaffDto generateStaffDto() {
        return generateStaff1Dto()
    }
    
    StaffDto generateStaff1Dto() {
        return new StaffDto(staff1)
    }
    
    StaffDto generateStaff2Dto() {
        return new StaffDto(staff2)
    }
    
    @Test
    public void testMapFromStaffEntityTest() {
        StaffDto staffTest = StaffDto.mapFromEntity( staff1 )
        assertEquals( staffTest.id, staff1.id);
        assertEquals( staffTest.personId, staff1.person.id);
        assertEquals( staffTest.typeId, staff1.type.id);
        assertEquals( staffTest.initials, staff1.initials);
        assertEquals( staffTest.onTimetable, staff1.onTimetable);
        assertEquals( staffTest.knownAs, staff1.knownAs);
        assertEquals( staffTest.networkLogin, staff1.networkLogin);
        assertEquals( staffTest.startDate, staff1.startDate);
        assertEquals( staffTest.endDate, staff1.endDate);
    }
    
    @Test
    public void testMapFromStaffsEntitiesTest(){
        List<StaffDto> staffTest = StaffDto.mapFromList( staffs )
        assertEquals( staffTest[0].id, staff1.id);
        assertEquals( staffTest[0].personId, staff1.person.id);
        assertEquals( staffTest[0].typeId, staff1.type.id);
        assertEquals( staffTest[0].initials, staff1.initials);
        assertEquals( staffTest[0].onTimetable, staff1.onTimetable);
        assertEquals( staffTest[0].knownAs, staff1.knownAs);
        assertEquals( staffTest[0].networkLogin, staff1.networkLogin);
        assertEquals( staffTest[0].startDate, staff1.startDate);
        assertEquals( staffTest[0].endDate, staff1.endDate);
    }
    
    @Test
    public void testEquals_Same() {
        StaffDto staffDto1 = new StaffDto(staff1)
        StaffDto staffDto2 = new StaffDto(staff1)
        assertEquals(staffDto1, staffDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StaffDto staffDto1 = new StaffDto(staff1)
        StaffDto staffDto2 = new StaffDto(staff2)
        assertNotEquals(staffDto1, staffDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StaffDto staffDto1 = new StaffDto(staff1)
        StaffDto staffDto2 = new StaffDto(staff1)
        assertEquals(staffDto1.hashCode(), staffDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StaffDto staffDto1 = new StaffDto(staff1)
        StaffDto staffDto2 = new StaffDto(staff2)
        assertNotEquals(staffDto1.hashCode(), staffDto2.hashCode())
    }
}
