package uk.ac.reigate.dto.admissions;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Person

public class DuplicateApplicationDtoTest {
    
    @Test
    public void testEquals_Same() {
        DuplicateApplicationDto duplicateApplicationDto1 = new DuplicateApplicationDto(190001, new Person(id:1 ))
        DuplicateApplicationDto duplicateApplicationDto2 = new DuplicateApplicationDto(190001, new Person(id:1 ))
        // assertEquals(duplicateApplicationDto1, duplicateApplicationDto2)
    }
    
    @Test
    public void testConstructor_DuplicateApplication() {
        DuplicateApplicationDto duplicateApplicationDto = new DuplicateApplicationDto(190001, new Person(id:1 ))
    }
}
