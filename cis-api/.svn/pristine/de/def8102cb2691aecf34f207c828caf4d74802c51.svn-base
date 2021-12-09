package uk.ac.reigate.dto.enrolment;

import static org.junit.Assert.*

import org.junit.Test

public class EnrolmentCheckDtoTest {
    
    @Test
    public void testConstructor_EnrolmentCheckDto() {
        EnrolmentCheckDto enrolmentCheckDto1 = new EnrolmentCheckDto("a", "b", "c")
        EnrolmentCheckDto enrolmentCheckDto2 = new EnrolmentCheckDto("a", "b", "c")
        assertNotEquals(enrolmentCheckDto1, enrolmentCheckDto2)
    }
    
    @Test
    public void testNoArgsConstructor() {
        EnrolmentCheckResultsDto enrolmentCheckResultsDto = new EnrolmentCheckResultsDto();
        assertNotNull(enrolmentCheckResultsDto)
    }
    
    @Test
    public void testConstructor_EnrolmentCheckResultsDto() {
        String[] specs = 'a'
        String status = 'active'
        List<EnrolmentOptionDto> options = ['a', 'b']
        EnrolmentCheckResultsDto enrolmentCheckResultsDto1 = new EnrolmentCheckResultsDto(specs, status, options)
        EnrolmentCheckResultsDto enrolmentCheckResultsDto2 = new EnrolmentCheckResultsDto(specs, status, options)
        assertNotEquals(enrolmentCheckResultsDto1, enrolmentCheckResultsDto2)
    }
}
