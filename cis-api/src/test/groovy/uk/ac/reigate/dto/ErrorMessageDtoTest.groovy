package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Person

public class ErrorMessageDtoTest {
    
    @Test
    public void testConstructor_ErrorMessageDto() {
        ErrorMessageDto errorMessageDtoDto = new ErrorMessageDto('Test', 'reigate')
        assertEquals( errorMessageDtoDto.message, 'Test');
        assertEquals( errorMessageDtoDto.devMessage, 'reigate');
    }
}
