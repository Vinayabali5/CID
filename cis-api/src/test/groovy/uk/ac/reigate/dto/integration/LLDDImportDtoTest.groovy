package uk.ac.reigate.dto.integration

import static org.junit.Assert.*
import org.junit.Before
import org.junit.Test

import uk.ac.reigate.dto.LLDDHealthProblemCategoryDto

class LLDDImportDtoTest {
    
    private LLDDHealthProblemCategoryDto lldd
    
    @Before
    public void setup() {
        this.lldd = new LLDDHealthProblemCategoryDto(
                code: 'test',
                description: 'testing'
                )
    }
    
    @Test
    public void testConstructor() {
        LLDDImportDto dto = new LLDDImportDto(lldd)
        assertEquals(dto.code, lldd.code)
        assertEquals(dto.description, lldd.description)
    }
}
