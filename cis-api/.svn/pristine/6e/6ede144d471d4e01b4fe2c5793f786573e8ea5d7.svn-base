package uk.ac.reigate.dto.exams.edi

import static org.junit.Assert.*
import org.junit.Test

class EdiFileDtoTest {
    
    @Test
    public void testConstructor() {
        EdiFileDto ediFileDto = new EdiFileDto(1, 'test', '1A')
        assertEquals(ediFileDto.examBoardId, 1)
        assertEquals(ediFileDto.examYear, 'test')
        assertEquals(ediFileDto.examSeries, '1A')
    }
    
    @Test
    void testMethod_ToString() {
        Integer examBoardId = 1
        String examYear = '2020'
        String examSeries = '1A'
        EdiFileDto ediFileDto = new EdiFileDto(examBoardId, examYear, examSeries)
        assertEquals("EdiFileDto [examBoardId=" + examBoardId + ", examYear=" + examYear + ", examSeries=" + examSeries +"]", ediFileDto.toString())
    }
}
