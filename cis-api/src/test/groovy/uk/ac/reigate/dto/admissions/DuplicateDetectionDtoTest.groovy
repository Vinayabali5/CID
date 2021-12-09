package uk.ac.reigate.dto.admissions;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.admissions.ApplicationStatus


public class DuplicateDetectionDtoTest {
    
    private DuplicateDetectionDto duplicateDetectionDto1
    
    @Before
    public void setup() {
        this.duplicateDetectionDto1 =  new DuplicateDetectionDto(
                surname: 'bali',
                dob:new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01')
                );
    }
    
    @Test
    void testConstructor_academicYear() {
        DuplicateDetectionDto duplicateDetectionTest = new DuplicateDetectionDto( duplicateDetectionDto1 )
        assertEquals( duplicateDetectionTest.dob, duplicateDetectionDto1.dob );
        assertEquals( duplicateDetectionTest.surname, duplicateDetectionDto1.surname);
    }
    
    @Test
    public void testMapFromEntity() {
        DuplicateDetectionDto duplicateDetectionTest = DuplicateDetectionDto.mapFromEntity(duplicateDetectionDto1)
        assertEquals( duplicateDetectionTest.surname, duplicateDetectionDto1.surname );
        assertEquals( duplicateDetectionTest.dob, duplicateDetectionDto1.dob );
    }
}