package uk.ac.reigate.dto.lookup;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.lookup.BursaryType

public class BursaryTypeDtoTest {
    
    private BursaryType bursaryType1
    
    private BursaryType bursaryType2
    
    private List<BursaryType> bursaryTypes
    
    @Before
    public void setup() {
        this.bursaryType1 = new BursaryType(
                id: 1,
                code: 'A',
                description: 'A BursaryType'
                );
        this.bursaryType2 = new BursaryType(
                id: 2,
                code: 'B',
                description: 'B BursaryType'
                );
        this.bursaryTypes = Arrays.asList(this.bursaryType1, this.bursaryType2);
    }
    
    @Test
    void testConstructor_nullObject() {
        BursaryType bursaryType = null
        BursaryTypeDto bursaryTypeTest = new BursaryTypeDto( bursaryType )
        assertEquals( bursaryType, null);
    }
    
    @Test
    void testConstructor_bursaryType() {
        BursaryTypeDto bursaryTypeTest = new BursaryTypeDto( bursaryType1 )
        assertEquals( bursaryTypeTest.id, bursaryType1.id );
        assertEquals( bursaryTypeTest.code, bursaryType1.code);
        assertEquals( bursaryTypeTest.description, bursaryType1.description);
    }
    
    @Test
    public void testMapFromBursaryTypeEntity(){
        BursaryTypeDto bursaryTypeTest = BursaryTypeDto.mapFromEntity( bursaryType1 )
        assertEquals( bursaryTypeTest.id, bursaryType1.id );
        assertEquals( bursaryTypeTest.code, bursaryType1.code);
        assertEquals( bursaryTypeTest.description, bursaryType1.description);
    }
    
    @Test
    public void testMapFromBursaryTypesEntities(){
        List<BursaryTypeDto> bursaryTypesTest = BursaryTypeDto.mapFromList( this.bursaryTypes )
        assertEquals( bursaryTypesTest[0].id, bursaryType1.id );
        assertEquals( bursaryTypesTest[0].code, bursaryType1.code );
        assertEquals( bursaryTypesTest[0].description, bursaryType1.description);
        assertEquals( bursaryTypesTest[1].id, bursaryType2.id );
        assertEquals( bursaryTypesTest[1].code, bursaryType2.code );
        assertEquals( bursaryTypesTest[1].description, bursaryType2.description);
    }
    
    @Test
    public void testEquals_Same() {
        BursaryTypeDto bursaryTypeDto1 = new BursaryTypeDto(bursaryType1)
        BursaryTypeDto bursaryTypeDto2 = new BursaryTypeDto(bursaryType1)
        assertEquals( bursaryTypeDto1, bursaryTypeDto2)
    }
    
    @Test
    public void testEquals_Different() {
        BursaryTypeDto bursaryTypeDto1 = new BursaryTypeDto(bursaryType1)
        BursaryTypeDto bursaryTypeDto2 = new BursaryTypeDto(bursaryType2)
        assertNotEquals( bursaryTypeDto1, bursaryTypeDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        BursaryTypeDto bursaryTypeDto1 = new BursaryTypeDto(bursaryType1)
        BursaryTypeDto bursaryTypeDto2 = new BursaryTypeDto(bursaryType1)
        assertEquals( bursaryTypeDto1.hashCode(), bursaryTypeDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        BursaryTypeDto bursaryTypeDto1 = new BursaryTypeDto(bursaryType1)
        BursaryTypeDto bursaryTypeDto2 = new BursaryTypeDto(bursaryType2)
        assertNotEquals( bursaryTypeDto1.hashCode(), bursaryTypeDto2.hashCode())
    }
    
    @Test
    public void testConstructor_BursaryType() {
        BursaryTypeDto bursaryTypeDto = new BursaryTypeDto(bursaryType1)
        assertEquals( bursaryTypeDto.code, bursaryType1.code )
        assertEquals( bursaryTypeDto.description, bursaryType1.description )
    }
}
