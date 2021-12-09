package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Person

public class UserInfoDTOTest {
    
    @Test
    public void testConstructor_ErrorMessageDto() {
        UserInfoDTO errorMessageDtoDto = new UserInfoDTO('vinaya.balakrishna')
        assertEquals( errorMessageDtoDto.username, 'vinaya.balakrishna');
    }
}
