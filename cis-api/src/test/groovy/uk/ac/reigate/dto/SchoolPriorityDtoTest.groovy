package uk.ac.reigate.dto;

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.lookup.SchoolPriority;

import static org.junit.Assert.*

public class SchoolPriorityDtoTest {
    
    private SchoolPriority schoolPriority1
    
    private SchoolPriority schoolPriority2
    
    private List<SchoolPriority> schoolPriorities
    
    @Before
    public void setup() {
        schoolPriority1 = new SchoolPriority(
                id: 1,
                code:'A',
                description:'A School'
                );
        schoolPriority2 = new SchoolPriority(
                id: 2,
                code:'B',
                description:'B school'
                );
        schoolPriorities = Arrays.asList(schoolPriority1, schoolPriority2);
    }
    
    @Test
    public void testMapFromSchoolPriorityEntity(){
        SchoolPriorityDto schoolPriorityTest = SchoolPriorityDto.mapFromEntity( schoolPriority1 )
        assertEquals( schoolPriorityTest.id, schoolPriority1.id );
        assertEquals( schoolPriorityTest.code, schoolPriority1.code);
        assertEquals( schoolPriorityTest.description, schoolPriority1.description);
    }
    
    @Test
    public void testMapFromSchoolPrioritysEntities(){
        List<SchoolPriorityDto> schoolPrioritysDtoTest = SchoolPriorityDto.mapFromList( schoolPriorities )
        assertEquals( schoolPrioritysDtoTest[0].id, schoolPriority1.id );
        assertEquals( schoolPrioritysDtoTest[0].code, schoolPriority1.code);
        assertEquals( schoolPrioritysDtoTest[0].description, schoolPriority1.description);
        assertEquals( schoolPrioritysDtoTest[1].id, schoolPriority2.id );
        assertEquals( schoolPrioritysDtoTest[1].code, schoolPriority2.code);
        assertEquals( schoolPrioritysDtoTest[1].description, schoolPriority2.description);
    }
    
    @Test
    public void testEquals_Same() {
        SchoolPriorityDto schoolPriorityDto1 = new SchoolPriorityDto(schoolPriority1)
        SchoolPriorityDto schoolPriorityDto2 = new SchoolPriorityDto(schoolPriority1)
        assertEquals(schoolPriorityDto1, schoolPriorityDto2)
    }
    
    @Test
    public void testEquals_Different() {
        SchoolPriorityDto schoolPriorityDto1 = new SchoolPriorityDto(schoolPriority1)
        SchoolPriorityDto schoolPriorityDto2 = new SchoolPriorityDto(schoolPriority2)
        assertNotEquals(schoolPriorityDto1, schoolPriorityDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        SchoolPriorityDto schoolPriorityDto1 = new SchoolPriorityDto(schoolPriority1)
        SchoolPriorityDto schoolPriorityDto2 = new SchoolPriorityDto(schoolPriority1)
        assertEquals(schoolPriorityDto1.hashCode(), schoolPriorityDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        SchoolPriorityDto schoolPriorityDto1 = new SchoolPriorityDto(schoolPriority1)
        SchoolPriorityDto schoolPriorityDto2 = new SchoolPriorityDto(schoolPriority2)
        assertNotEquals(schoolPriorityDto1.hashCode(), schoolPriorityDto2.hashCode())
    }
    
    @Test
    public void testConstructor_SchoolPriority() {
        SchoolPriorityDto schoolPriorityDto = new SchoolPriorityDto(schoolPriority1)
        assertEquals( schoolPriorityDto.code, schoolPriority1.code )
        assertEquals( schoolPriorityDto.description, schoolPriority1.description )
    }
    
    @Test
    public void testConstructor_NullSchoolPriority() {
        SchoolPriority schoolPriority = null
        SchoolPriorityDto schoolPriorityDto = new SchoolPriorityDto(schoolPriority)
        assertEquals( schoolPriority, null )
    }
}