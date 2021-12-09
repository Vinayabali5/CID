package uk.ac.reigate.services.risk_assessment

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertEquals
import static org.mockito.Mockito.*
import static org.junit.Assert.assertNotNull

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import uk.ac.reigate.domain.risk_assessment.RiskLevel
import uk.ac.reigate.dto.risk_assessment.RiskLevelDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.risk_assessment.RiskLevelRepository


class RiskLevelServiceTest {
    
    @Mock
    private RiskLevelRepository riskLevelRepository;
    
    @InjectMocks
    private RiskLevelService riskLevelService;
    
    private RiskLevel riskLevel
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample RiskLevel data object to use for the testing
     * 
     * @return a sample RiskLevel data object
     */
    RiskLevel createRiskLevel() {
        return new RiskLevel(
                id: 1,
                code: 'R1',
                description: 'High Risk',
                priority: 11,
                sendEmail: true,
                sendEmailSafeguarding: true
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample RiskLevel created at setup
     * 
     * @return a RiskLevelDto object based on the sample RiskLevel
     */
    RiskLevelDto createDto() {
        return new RiskLevelDto(
                id: riskLevel.id,
                code: riskLevel.code,
                description: riskLevel.description,
                priority: riskLevel.priority,
                sendEmail: riskLevel.sendEmail,
                sendEmailSafeguarding : riskLevel.sendEmailSafeguarding
                )
    }
    
    /**
     * This method is used to set up the tests for the RiskLevelService
     */
    @Before
    public void setup() {
        this.riskLevelRepository = Mockito.mock(RiskLevelRepository.class);
        this.riskLevelService = new RiskLevelService(riskLevelRepository);
        
        riskLevel = createRiskLevel()
        
        when(riskLevelRepository.save(any(RiskLevel.class))).thenReturn(riskLevel);
        when(riskLevelRepository.findById(1)).thenReturn(new Optional(riskLevel));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        RiskLevelService service = new RiskLevelService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<RiskLevel> result = riskLevelService.findAll();
        verify(riskLevelRepository, times(1)).findAll()
        verifyNoMoreInteractions(riskLevelRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        RiskLevel result = riskLevelService.findById(1);
        verify(riskLevelRepository, times(1)).findById(1)
        verifyNoMoreInteractions(riskLevelRepository)
    }
    
    @Test
    public void testFindByCode() {
        RiskLevel result = riskLevelService.findByCode('Test');
        verify(riskLevelRepository, times(1)).findByCode('Test')
        verifyNoMoreInteractions(riskLevelRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        RiskLevel savedRiskLevel = riskLevelService.save(riskLevel);
        verify(riskLevelRepository, times(1)).save(any())
        verifyNoMoreInteractions(riskLevelRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<RiskLevel> savedRiskLevels = riskLevelService.saveRiskLevels([riskLevel, riskLevel]);
        verify(riskLevelRepository, times(2)).save(riskLevel)
        verifyNoMoreInteractions(riskLevelRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        RiskLevelDto dto = createDto()
        RiskLevel riskLevelSaved = riskLevelService.createFromDto(dto)
        verify(riskLevelRepository, times(1)).save(any(RiskLevel.class))
        verifyNoMoreInteractions(riskLevelRepository)
        assertEquals(dto.id, riskLevel.id)
        assertEquals(dto.code, riskLevel.code)
        assertEquals(dto.description, riskLevel.description)
        assertEquals(dto.priority, riskLevel.priority)
        assertEquals(dto.sendEmail, riskLevel.sendEmail)
        assertEquals(dto.sendEmailSafeguarding, riskLevel.sendEmailSafeguarding)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create riskLevel from null object.")
        RiskLevelDto dto = null
        riskLevelService.createFromDto(dto)
        verifyNoMoreInteractions(riskLevelRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        RiskLevelDto dto = createDto()
        RiskLevel riskLevelSaved = riskLevelService.updateFromDto(dto)
        verify(riskLevelRepository, times(1)).findById(riskLevel.id)
        verify(riskLevelRepository, times(1)).save(riskLevel)
        verifyNoMoreInteractions(riskLevelRepository)
        assertEquals(riskLevel.id, riskLevelSaved.id)
        assertEquals(riskLevel.code, riskLevelSaved.code)
        assertEquals(riskLevel.description, riskLevelSaved.description)
        assertEquals(riskLevel.priority, riskLevelSaved.priority)
        assertEquals(riskLevel.sendEmail, riskLevelSaved.sendEmail)
        assertEquals(riskLevel.sendEmailSafeguarding, riskLevelSaved.sendEmailSafeguarding)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update riskLevel from null object.")
        RiskLevelDto dto = null
        riskLevelService.updateFromDto(dto)
        verifyNoMoreInteractions(riskLevelRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        riskLevelService.delete(riskLevel)
        verifyNoMoreInteractions(riskLevelRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}