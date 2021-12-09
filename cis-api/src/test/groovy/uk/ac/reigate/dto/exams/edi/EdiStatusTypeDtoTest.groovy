package uk.ac.reigate.dto.exams.edi

import static org.junit.Assert.*
import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.exams.edi.EdiStatusType

class EdiStatusTypeDtoTest {
    
    private EdiStatusType ediStatusType1
    
    private EdiStatusType ediStatusType2
    
    private List<EdiStatusType> ediStatusTypes
    
    @Before
    public void setup() {
        this.ediStatusType1 = new EdiStatusType(
                id: 1,
                code: 'Test',
                description: 'Testing'
                )
        this.ediStatusType2 = new EdiStatusType(
                id: 1,
                code: 'Test',
                description: 'Testing'
                )
        this.ediStatusTypes = Arrays.asList(ediStatusType1, ediStatusType2)
    }
    
    @Test
    public void testConstructor() {
        EdiStatusTypeDto ediStatusTypeDto = new EdiStatusTypeDto(ediStatusType1)
        assertEquals( ediStatusTypeDto.id, ediStatusType1.id);
        assertEquals( ediStatusTypeDto.code, ediStatusType1.code);
        assertEquals( ediStatusTypeDto.description, ediStatusType1.description);
    }
    
    @Test
    public void testMapFromEntity() {
        EdiStatusTypeDto ediStatusTypeDto = EdiStatusTypeDto.mapFromEntity(ediStatusType1)
        assertEquals( ediStatusTypeDto.id, ediStatusType1.id)
        assertEquals( ediStatusTypeDto.code, ediStatusType1.code)
        assertEquals( ediStatusTypeDto.description, ediStatusType1.description)
    }
    
    @Test
    public void testMapFromList() {
        List<EdiStatusTypeDto> ediStatusTypeDto = EdiStatusTypeDto.mapFromList(ediStatusTypes)
        assertEquals( ediStatusTypeDto[0].id, ediStatusType1.id)
        assertEquals( ediStatusTypeDto[0].code, ediStatusType1.code)
        assertEquals( ediStatusTypeDto[0].description, ediStatusType1.description)
        assertEquals( ediStatusTypeDto[1].id, ediStatusType2.id)
        assertEquals( ediStatusTypeDto[1].code, ediStatusType2.code)
        assertEquals( ediStatusTypeDto[1].description, ediStatusType2.description)
    }
}
