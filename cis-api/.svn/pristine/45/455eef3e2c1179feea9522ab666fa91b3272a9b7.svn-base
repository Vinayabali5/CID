package uk.ac.reigate.services.email

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.dto.email.EmailStaffListDto
import uk.ac.reigate.model.email.EmailMessage
import uk.ac.reigate.repositories.StaffRepository
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.integration.email.EmailService


class StaffEmailingServiceTest {
    
    @Mock
    private StaffRepository staffRepository;
    
    @InjectMocks
    private StaffService staffService;
    
    @InjectMocks
    private StaffEmailingService staffEmailingService;
    
    private Staff staff
    
    private EmailStaffListDto emailStaffListDto
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a DTO object based on the sample EmailStaffListDto created at setup
     *
     * @return a EmailStaffListDtoDto object based on the sample EmailStaffListDto
     */
    EmailStaffListDto createDto() {
        return new EmailStaffListDto(List<Integer> staffList, Integer staffId, String staffFrom, String subject, String message)
    }
    
    @Before
    public void setup() {
        this.staffRepository = Mockito.mock(StaffRepository.class);
        // this.staffService = new StaffService(staffRepository, personService, staffTypeService);
    }
    
    // @Test
    public void testEmailMessage() {
        EmailMessage email = new EmailMessage()
        EmailStaffListDto dto = new EmailStaffListDto(staffList : [19001, 19002], staffId: 1465, staffFrom : 'vinaya', subject : 'Test', message: 'T')
        assertNotNull(email)
    }
}