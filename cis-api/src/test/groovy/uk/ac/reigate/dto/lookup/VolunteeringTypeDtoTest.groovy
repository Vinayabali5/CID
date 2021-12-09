package uk.ac.reigate.dto.lookup;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.lookup.VolunteeringType

public class VolunteeringTypeDtoTest {
    
    private VolunteeringType volunteeringType1
    
    private VolunteeringType volunteeringType2
    
    private List<VolunteeringType> volunteeringTypes
    
    @Before
    public void setup() {
        volunteeringType1 = new VolunteeringType(
                id: 1,
                code:'Int',
                description:'Internal VolunteeringType'
                );
        volunteeringType2 = new VolunteeringType(
                id: 2,
                code:'Ext',
                description:'External VolunteeringType'
                );
        volunteeringTypes = Arrays.asList(volunteeringType1, volunteeringType2);
    }
    
    @Test
    public void testMapFromVolunteeringTypeEntity(){
        VolunteeringTypeDto volunteeringTypeTest = VolunteeringTypeDto.mapFromEntity( volunteeringType1 )
        assertEquals( volunteeringTypeTest.id, volunteeringType1.id );
        assertEquals( volunteeringTypeTest.code, volunteeringType1.code);
        assertEquals( volunteeringTypeTest.description, volunteeringType1.description);
    }
    
    @Test
    public void testMapFromVolunteeringTypesEntities(){
        List<VolunteeringTypeDto> volunteeringTypeDtoTest = VolunteeringTypeDto.mapFromList( volunteeringTypes )
        assertEquals( volunteeringTypeDtoTest[0].id, volunteeringType1.id );
        assertEquals( volunteeringTypeDtoTest[0].code, volunteeringType1.code);
        assertEquals( volunteeringTypeDtoTest[0].description, volunteeringType1.description);
        assertEquals( volunteeringTypeDtoTest[1].id, volunteeringType2.id );
        assertEquals( volunteeringTypeDtoTest[1].code, volunteeringType2.code);
        assertEquals( volunteeringTypeDtoTest[1].description, volunteeringType2.description);
    }
    
    @Test
    public void testEquals_Same() {
        VolunteeringTypeDto volunteeringTypeDto1 = new VolunteeringTypeDto(volunteeringType1)
        VolunteeringTypeDto volunteeringTypeDto2 = new VolunteeringTypeDto(volunteeringType1)
        assertEquals(volunteeringTypeDto1, volunteeringTypeDto2)
    }
    
    @Test
    public void testEquals_Different() {
        VolunteeringTypeDto volunteeringTypeDto1 = new VolunteeringTypeDto(volunteeringType1)
        VolunteeringTypeDto volunteeringTypeDto2 = new VolunteeringTypeDto(volunteeringType2)
        assertNotEquals(volunteeringTypeDto1, volunteeringTypeDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        VolunteeringTypeDto volunteeringTypeDto1 = new VolunteeringTypeDto(volunteeringType1)
        VolunteeringTypeDto volunteeringTypeDto2 = new VolunteeringTypeDto(volunteeringType1)
        assertEquals(volunteeringTypeDto1.hashCode(), volunteeringTypeDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        VolunteeringTypeDto volunteeringTypeDto1 = new VolunteeringTypeDto(volunteeringType1)
        VolunteeringTypeDto volunteeringTypeDto2 = new VolunteeringTypeDto(volunteeringType2)
        assertNotEquals(volunteeringTypeDto1.hashCode(), volunteeringTypeDto2.hashCode())
    }
    
    @Test
    public void testConstructor_VolunteeringType() {
        VolunteeringTypeDto volunteeringTypeDto = new VolunteeringTypeDto(volunteeringType1)
        assertEquals( volunteeringTypeDto.code, volunteeringType1.code )
        assertEquals( volunteeringTypeDto.description, volunteeringType1.description )
    }
}
