package uk.ac.reigate.dto.exams.edi

import static org.junit.Assert.*
import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.exams.edi.StatusType

class StatusTypeDtoTest {
    
    private StatusType statusType1
    
    private StatusType statusType2
    
    private List<StatusType> statusTypes
    
    @Before
    public void setup() {
        this.statusType1 = new StatusType(
                id: 1,
                code: 'Test',
                description: 'Testing'
                )
        this.statusType2 = new StatusType(
                id: 1,
                code: 'Test',
                description: 'Testing'
                )
        this.statusTypes = Arrays.asList(statusType1, statusType2)
    }
    
    @Test
    public void testConstructor() {
        StatusTypeDto statusTypeDto = new StatusTypeDto(statusType1)
        assertEquals( statusTypeDto.id, statusType1.id);
        assertEquals( statusTypeDto.code, statusType1.code);
        assertEquals( statusTypeDto.description, statusType1.description);
    }
    
    @Test
    public void testMapFromEntity() {
        StatusTypeDto statusTypeDto = StatusTypeDto.mapFromEntity(statusType1)
        assertEquals( statusTypeDto.id, statusType1.id)
        assertEquals( statusTypeDto.code, statusType1.code)
        assertEquals( statusTypeDto.description, statusType1.description)
    }
    
    @Test
    public void testMapFromList() {
        List<StatusTypeDto> statusTypeDto = StatusTypeDto.mapFromList(statusTypes)
        assertEquals( statusTypeDto[0].id, statusType1.id)
        assertEquals( statusTypeDto[0].code, statusType1.code)
        assertEquals( statusTypeDto[0].description, statusType1.description)
        assertEquals( statusTypeDto[1].id, statusType2.id)
        assertEquals( statusTypeDto[1].code, statusType2.code)
        assertEquals( statusTypeDto[1].description, statusType2.description)
    }
}
