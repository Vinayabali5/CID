package uk.ac.reigate.dto.admissions;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Person

public class StudentSearchDtoTest {
    
    @Test
    public void testConstructorEquals_Different() {
        StudentSearchDto studentSearchDto1 = new StudentSearchDto(190001, '1', 'vinaya', 'reigate', 'test')
        StudentSearchDto studentSearchDto2 = new StudentSearchDto(190003, '1', 'vinaya', 'reigate', 'test')
        assertNotEquals(studentSearchDto1, studentSearchDto2)
    }
    
    @Test
    public void testConstructorEquals_Same() {
        StudentSearchDto studentSearchDto = new StudentSearchDto(190001, '1', 'vinaya', 'reigate', 'test')
        assertEquals(studentSearchDto.studentId, 190001)
        assertEquals(studentSearchDto.referenceNo, '1')
        assertEquals(studentSearchDto.personName, 'vinaya')
        assertEquals(studentSearchDto.schoolName, 'reigate')
        assertEquals(studentSearchDto.status, 'test')
    }
}
