package uk.ac.reigate.dto;

import org.junit.Test

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.admissions.CollegeFundPaid

public class StudentCollegeFundPaidDtoTest {
    
    @Test
    public void testEquals_Same() {
        StudentCollegeFundPaidDto studentSearchDto1 = new StudentCollegeFundPaidDto(190001, 1, 'vinaya', 1)
        StudentCollegeFundPaidDto studentSearchDto2 = new StudentCollegeFundPaidDto(190001, 1, 'vinaya', 1)
        // assertEquals(duplicateApplicationDto1, duplicateApplicationDto2)
    }
    
    @Test
    public void testConstructor_StudentCollegeFundPaidDto() {
        StudentCollegeFundPaidDto duplicateApplicationDto = new StudentCollegeFundPaidDto(new Student(id:190001), new CollegeFundPaid(id:1))
    }
}