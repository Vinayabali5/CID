package uk.ac.reigate.dto

import static org.junit.Assert.*
import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.AlternativePeriod
import uk.ac.reigate.domain.academic.Block

class AlternativePeriodDtoTest {
    
    private AlternativePeriod alternativePeriod1
    
    private AlternativePeriod alternativePeriod2
    
    private List<AlternativePeriod> alternativePeriods
    
    @Before
    public void setup() {
        this.alternativePeriod1 = new AlternativePeriod(
                id: 1,
                code: 'Test',
                description : 'Testing',
                block : new Block(id: 1, description: 'test'),
                day : 4,
                dayPeriod : 5
                )
        this.alternativePeriod2 = new AlternativePeriod(
                id: 1,
                code: 'Test',
                description : 'Testing',
                block : new Block(),
                day : 4,
                dayPeriod : 5
                )
        this.alternativePeriods = Arrays.asList(alternativePeriod1, alternativePeriod2)
    }
    
    @Test
    public void testConstructor() {
        AlternativePeriodDto dto = new AlternativePeriodDto(alternativePeriod1)
        assertEquals(dto.id, alternativePeriod1.id)
        assertEquals(dto.code, alternativePeriod1.code)
        assertEquals(dto.description, alternativePeriod1.description)
        assertEquals(dto.blockId, alternativePeriod1.block.id)
        assertEquals(dto.day, alternativePeriod1.day)
        assertEquals(dto.dayPeriod, alternativePeriod1.dayPeriod)
    }
    
    @Test
    public void testConstructorNullDto() {
        AlternativePeriodDto dto = null
        assertEquals(dto, null)
    }
    
    @Test
    public void testConstructorNullBlock() {
        AlternativePeriodDto dto = new AlternativePeriodDto(alternativePeriod2)
        assertEquals(dto.id, alternativePeriod2.id)
        assertEquals(dto.code, alternativePeriod2.code)
        assertEquals(dto.description, alternativePeriod2.description)
        assertEquals(dto.blockId, null)
        assertEquals(dto.day, alternativePeriod2.day)
        assertEquals(dto.dayPeriod, alternativePeriod2.dayPeriod)
    }
    
    @Test
    public void testMapFromEntity() {
        AlternativePeriodDto dto = AlternativePeriodDto.mapFromEntity(alternativePeriod1)
        assertEquals(dto.id, alternativePeriod1.id)
        assertEquals(dto.code, alternativePeriod1.code)
        assertEquals(dto.description, alternativePeriod1.description)
        assertEquals(dto.blockId, alternativePeriod1.block.id)
        assertEquals(dto.day, alternativePeriod1.day)
        assertEquals(dto.dayPeriod, alternativePeriod1.dayPeriod)
    }
    
    @Test
    public void testMapFromList() {
        List<AlternativePeriodDto> dto = AlternativePeriodDto.mapFromList(alternativePeriods)
        assertEquals(dto[0].id, alternativePeriod1.id)
        assertEquals(dto[0].code, alternativePeriod1.code)
        assertEquals(dto[0].description, alternativePeriod1.description)
        assertEquals(dto[0].blockId, alternativePeriod1.block.id)
        assertEquals(dto[0].day, alternativePeriod1.day)
        assertEquals(dto[0].dayPeriod, alternativePeriod1.dayPeriod)
        assertEquals(dto[1].id, alternativePeriod2.id)
        assertEquals(dto[1].code, alternativePeriod2.code)
        assertEquals(dto[1].description, alternativePeriod2.description)
        assertEquals(dto[1].blockId, null)
        assertEquals(dto[1].day, alternativePeriod2.day)
        assertEquals(dto[1].dayPeriod, alternativePeriod2.dayPeriod)
    }
    
    @Test
    public void test_get_BlockDescription() {
        AlternativePeriodDto dto = new AlternativePeriodDto(alternativePeriod1)
        assertEquals(dto.block.description, dto.get_BlockDescription())
    }
    
    @Test
    public void test_get_NullBlockDescription() {
        AlternativePeriod alternativePeriod = new AlternativePeriod(id: 1,
        code: 'Test', block: null)
        AlternativePeriodDto dto = new AlternativePeriodDto(alternativePeriod)
        assertEquals(dto.block, dto.get_BlockDescription())
    }
}
