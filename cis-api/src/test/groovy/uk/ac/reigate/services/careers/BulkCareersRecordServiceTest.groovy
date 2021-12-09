package uk.ac.reigate.services.careers

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentCareersRecord
import uk.ac.reigate.dto.careers.BulkCareersRecordDto
import uk.ac.reigate.repositories.academic.StudentCareersRecordRepository
import uk.ac.reigate.services.CareersRecordTypeService
import uk.ac.reigate.services.StudentCareersRecordService
import uk.ac.reigate.services.student.StudentService

@RunWith(MockitoJUnitRunner.class)
class BulkCareersRecordServiceTest {
    
    @Mock
    private StudentService studentService
    
    @Mock
    private StudentCareersRecordService studentCareersRecordService
    
    @Mock
    private CareersRecordTypeService careersRecordTypeService
    
    @InjectMocks
    private BulkCareersRecordService bulkCareersRecordService;
    
    private StudentCareersRecord studentCareersRecord
    
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        BulkCareersRecordService service = new BulkCareersRecordService();
        assertNotNull(service)
    }
    
    @Test
    public void testCreateMassILPEntries_NullStudentList() {
        BulkCareersRecordDto dto = new BulkCareersRecordDto(organiser: 'Reigate')
        bulkCareersRecordService.createMassILPEntries(dto)
    }
}