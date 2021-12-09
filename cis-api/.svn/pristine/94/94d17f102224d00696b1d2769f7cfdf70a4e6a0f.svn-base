package uk.ac.reigate.dto.careers;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.CareersRecordType



public class CareersRecordTypeDtoTest {
    
    private CareersRecordType careersRecordType1
    
    private CareersRecordType careersRecordType2
    
    private List<CareersRecordType> careersRecordTypes
    
    @Before
    public void setup() {
        careersRecordType1 = new CareersRecordType(
                id: 1,
                code:'I',
                description:'Internal Placement'
                );
        careersRecordType2 = new CareersRecordType(
                id: 2,
                code:'E',
                description:'External Placement'
                );
        careersRecordTypes = Arrays.asList(careersRecordType1, careersRecordType2);
    }
    
    @Test
    public void testMapFromCareersRecordTypeEntity(){
        CareersRecordTypeDto careersRecordTypeTest = CareersRecordTypeDto.mapFromEntity( careersRecordType1 )
        assertEquals( careersRecordTypeTest.id, careersRecordType1.id );
        assertEquals( careersRecordTypeTest.code, careersRecordType1.code);
        assertEquals( careersRecordTypeTest.description, careersRecordType1.description);
    }
    
    @Test
    public void testMapFromCareersRecordTypesEntities(){
        List<CareersRecordTypeDto> careersRecordTypesDtoTest = CareersRecordTypeDto.mapFromList( careersRecordTypes )
        assertEquals( careersRecordTypesDtoTest[0].id, careersRecordType1.id );
        assertEquals( careersRecordTypesDtoTest[0].code, careersRecordType1.code);
        assertEquals( careersRecordTypesDtoTest[0].description, careersRecordType1.description);
        assertEquals( careersRecordTypesDtoTest[1].id, careersRecordType2.id );
        assertEquals( careersRecordTypesDtoTest[1].code, careersRecordType2.code);
        assertEquals( careersRecordTypesDtoTest[1].description, careersRecordType2.description);
    }
    
    
    @Test
    public void testEquals_Same() {
        CareersRecordTypeDto careersRecordTypeDto1 = new CareersRecordTypeDto(careersRecordType1)
        CareersRecordTypeDto careersRecordTypeDto2 = new CareersRecordTypeDto(careersRecordType1)
        assertEquals(careersRecordTypeDto1, careersRecordTypeDto2)
    }
    
    @Test
    public void testEquals_Different() {
        CareersRecordTypeDto careersRecordTypeDto1 = new CareersRecordTypeDto(careersRecordType1)
        CareersRecordTypeDto careersRecordTypeDto2 = new CareersRecordTypeDto(careersRecordType2)
        assertNotEquals(careersRecordTypeDto1, careersRecordTypeDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        CareersRecordTypeDto careersRecordTypeDto1 = new CareersRecordTypeDto(careersRecordType1)
        CareersRecordTypeDto careersRecordTypeDto2 = new CareersRecordTypeDto(careersRecordType1)
        assertEquals(careersRecordTypeDto1.hashCode(), careersRecordTypeDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        CareersRecordTypeDto careersRecordTypeDto1 = new CareersRecordTypeDto(careersRecordType1)
        CareersRecordTypeDto careersRecordTypeDto2 = new CareersRecordTypeDto(careersRecordType2)
        assertNotEquals(careersRecordTypeDto1.hashCode(), careersRecordTypeDto2.hashCode())
    }
    
    @Test
    public void testConstructor_CareersRecordType() {
        CareersRecordTypeDto careersRecordTypeDto = new CareersRecordTypeDto(careersRecordType1)
        assertEquals( careersRecordTypeDto.code, careersRecordType1.code )
        assertEquals( careersRecordTypeDto.description, careersRecordType1.description )
    }
    
    @Test
    public void testConstructor_NullCareersRecordType() {
        CareersRecordType careersRecordType = null
        CareersRecordTypeDto careersRecordTypeDto = new CareersRecordTypeDto(careersRecordType)
        assertEquals( careersRecordType, null )
    }
}
