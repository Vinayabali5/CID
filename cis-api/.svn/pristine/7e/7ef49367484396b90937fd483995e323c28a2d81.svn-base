package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import uk.ac.reigate.domain.lookup.SchoolReportStatus
import uk.ac.reigate.dto.SchoolReportStatusDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.SchoolReportStatusRepository


class SchoolReportStatusServiceTest {
    
    @Mock
    private SchoolReportStatusRepository schoolReportStatusRepository;
    
    @InjectMocks
    private SchoolReportStatusService schoolReportStatusService;
    
    private SchoolReportStatus schoolReportStatus
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample SchoolReportStatus data object to use for the testing
     * 
     * @return a sample SchoolReportStatus data object
     */
    SchoolReportStatus createSchoolReportStatus() {
        return new SchoolReportStatus(
                id: 1,
                code: '1',
                description: 'SchoolReportStatus 1'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample SchoolReportStatus created at setup
     * 
     * @return a SchoolReportStatusDto object based on the sample SchoolReportStatus
     */
    SchoolReportStatusDto createDto() {
        return new SchoolReportStatusDto(
                id: schoolReportStatus.id,
                code: schoolReportStatus.code,
                description: schoolReportStatus.description
                )
    }
    
    /**
     * This method is used to set up the tests for the SchoolReportStatusService
     */
    @Before
    public void setup() {
        this.schoolReportStatusRepository = Mockito.mock(SchoolReportStatusRepository.class);
        this.schoolReportStatusService = new SchoolReportStatusService(schoolReportStatusRepository);
        
        schoolReportStatus = createSchoolReportStatus()
        
        when(schoolReportStatusRepository.save(any(SchoolReportStatus.class))).thenReturn(schoolReportStatus);
        when(schoolReportStatusRepository.findById(1)).thenReturn(new Optional(schoolReportStatus));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        SchoolReportStatusService service = new SchoolReportStatusService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<SchoolReportStatus> result = schoolReportStatusService.findAll();
        verify(schoolReportStatusRepository, times(1)).findAll()
        verifyNoMoreInteractions(schoolReportStatusRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        SchoolReportStatus result = schoolReportStatusService.findById(1);
        verify(schoolReportStatusRepository, times(1)).findById(1)
        verifyNoMoreInteractions(schoolReportStatusRepository)
    }
    
    @Test
    public void testFindByDesc() {
        SchoolReportStatus result = schoolReportStatusService.findByDesc('test');
        verify(schoolReportStatusRepository, times(1)).findByDescription('test')
        verifyNoMoreInteractions(schoolReportStatusRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        SchoolReportStatus savedSchoolReportStatus = schoolReportStatusService.save(schoolReportStatus);
        verify(schoolReportStatusRepository, times(1)).save(any())
        verifyNoMoreInteractions(schoolReportStatusRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<SchoolReportStatus> savedSchoolReportStatuss = schoolReportStatusService.saveSchoolReportStatuss([
            schoolReportStatus,
            schoolReportStatus
        ]);
        verify(schoolReportStatusRepository, times(2)).save(schoolReportStatus)
        verifyNoMoreInteractions(schoolReportStatusRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        SchoolReportStatusDto dto = createDto()
        SchoolReportStatus schoolReportStatusSaved = schoolReportStatusService.createFromDto(dto)
        verify(schoolReportStatusRepository, times(1)).save(any(SchoolReportStatus.class))
        verifyNoMoreInteractions(schoolReportStatusRepository)
        assertEquals(dto.id, schoolReportStatus.id)
        assertEquals(dto.code, schoolReportStatus.code)
        assertEquals(dto.description, schoolReportStatus.description)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create schoolReportStatusDto from null object.")
        SchoolReportStatusDto dto = null
        schoolReportStatusService.createFromDto(dto)
        verifyNoMoreInteractions(schoolReportStatusRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        SchoolReportStatusDto dto = createDto()
        SchoolReportStatus schoolReportStatusSaved = schoolReportStatusService.updateFromDto(dto)
        verify(schoolReportStatusRepository, times(1)).findById(schoolReportStatus.id)
        verify(schoolReportStatusRepository, times(1)).save(schoolReportStatus)
        verifyNoMoreInteractions(schoolReportStatusRepository)
        assertEquals(schoolReportStatus.id, schoolReportStatusSaved.id)
        assertEquals(schoolReportStatus.code, schoolReportStatusSaved.code)
        assertEquals(schoolReportStatus.description, schoolReportStatusSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        SchoolReportStatusDto dto = createDto()
        SchoolReportStatus schoolReportStatusSaved = schoolReportStatusService.updateFromDto(dto)
        verify(schoolReportStatusRepository, times(1)).findById(schoolReportStatus.id)
        verify(schoolReportStatusRepository, times(1)).save(schoolReportStatus)
        verifyNoMoreInteractions(schoolReportStatusRepository)
        assertEquals(schoolReportStatus.id, schoolReportStatusSaved.id)
        assertEquals(schoolReportStatus.code, schoolReportStatusSaved.code)
        assertEquals(schoolReportStatus.description, schoolReportStatusSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update schoolReportStatusDto from null object.")
        SchoolReportStatusDto dto = null
        schoolReportStatusService.updateFromDto(dto)
        verifyNoMoreInteractions(schoolReportStatusRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        schoolReportStatusService.delete(schoolReportStatus)
        verifyNoMoreInteractions(schoolReportStatusRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}