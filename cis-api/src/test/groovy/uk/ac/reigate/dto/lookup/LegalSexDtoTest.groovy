package uk.ac.reigate.dto.lookup;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.lookup.LegalSex

public class LegalSexDtoTest {
    
    private LegalSex legalSex1
    
    private LegalSex legalSex2
    
    private List<LegalSex> legalSexs
    
    @Before
    public void setup() {
        this.legalSex1 = new LegalSex(
                id: 1,
                code: 'A',
                description: 'Male'
                );
        this.legalSex2 = new LegalSex(
                id: 2,
                code: 'B',
                description: 'Female'
                );
        this.legalSexs = Arrays.asList(this.legalSex1, this.legalSex2);
    }
    
    @Test
    void testConstructor_nullObject() {
        LegalSex legalSex = null
        LegalSexDto legalSexTest = new LegalSexDto( legalSex )
        assertEquals( legalSex, null);
    }
    
    @Test
    void testConstructor_legalSex() {
        LegalSexDto legalSexTest = new LegalSexDto( legalSex1 )
        assertEquals( legalSexTest.id, legalSex1.id );
        assertEquals( legalSexTest.code, legalSex1.code);
        assertEquals( legalSexTest.description, legalSex1.description);
    }
    
    @Test
    public void testMapFromLegalSexEntity(){
        LegalSexDto legalSexTest = LegalSexDto.mapFromEntity( legalSex1 )
        assertEquals( legalSexTest.id, legalSex1.id );
        assertEquals( legalSexTest.code, legalSex1.code);
        assertEquals( legalSexTest.description, legalSex1.description);
    }
    
    @Test
    public void testMapFromLegalSexsEntities(){
        List<LegalSexDto> legalSexsTest = LegalSexDto.mapFromList( this.legalSexs )
        assertEquals( legalSexsTest[0].id, legalSex1.id );
        assertEquals( legalSexsTest[0].code, legalSex1.code );
        assertEquals( legalSexsTest[0].description, legalSex1.description);
        assertEquals( legalSexsTest[1].id, legalSex2.id );
        assertEquals( legalSexsTest[1].code, legalSex2.code );
        assertEquals( legalSexsTest[1].description, legalSex2.description);
    }
    
    @Test
    public void testEquals_Same() {
        LegalSexDto legalSexDto1 = new LegalSexDto(legalSex1)
        LegalSexDto legalSexDto2 = new LegalSexDto(legalSex1)
        assertEquals( legalSexDto1, legalSexDto2)
    }
    
    @Test
    public void testEquals_Different() {
        LegalSexDto legalSexDto1 = new LegalSexDto(legalSex1)
        LegalSexDto legalSexDto2 = new LegalSexDto(legalSex2)
        assertNotEquals( legalSexDto1, legalSexDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        LegalSexDto legalSexDto1 = new LegalSexDto(legalSex1)
        LegalSexDto legalSexDto2 = new LegalSexDto(legalSex1)
        assertEquals( legalSexDto1.hashCode(), legalSexDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        LegalSexDto legalSexDto1 = new LegalSexDto(legalSex1)
        LegalSexDto legalSexDto2 = new LegalSexDto(legalSex2)
        assertNotEquals( legalSexDto1.hashCode(), legalSexDto2.hashCode())
    }
    
    @Test
    public void testConstructor_LegalSex() {
        LegalSexDto legalSexDto = new LegalSexDto(legalSex1)
        assertEquals( legalSexDto.code, legalSex1.code )
        assertEquals( legalSexDto.description, legalSex1.description )
    }
}
