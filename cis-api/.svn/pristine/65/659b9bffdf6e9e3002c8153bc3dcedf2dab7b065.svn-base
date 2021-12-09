package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.mockito.Mockito.*
import static org.junit.Assert.assertNotNull

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.Mockito

import uk.ac.reigate.domain.learning_support.InitialAssessmentLevel
import uk.ac.reigate.dto.InitialAssessmentLevelDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.learning_support.InitialAssessmentLevelRepository


class InitialAssessmentLevelServiceTest {
    
    private InitialAssessmentLevelRepository initialAssessmentLevelRepository;
    
    private InitialAssessmentLevelService initialAssessmentLevelService;
    
    private InitialAssessmentLevel initialAssessmentLevel;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    @Before
    public void setup() {
        this.initialAssessmentLevelRepository = Mockito.mock(InitialAssessmentLevelRepository.class);
        this.initialAssessmentLevelService = new InitialAssessmentLevelService(initialAssessmentLevelRepository);
        
        initialAssessmentLevel = new InitialAssessmentLevel(
                id: 1,
                initialAssessmentLevel: 'M',
                abbrv: 'M'
                )
        
        when(initialAssessmentLevelRepository.findById(1)).thenReturn(new Optional(initialAssessmentLevel));
    }
    
    @Test
    public void testFindAll() {
        List<InitialAssessmentLevel> result = initialAssessmentLevelService.findAll();
        verify(initialAssessmentLevelRepository, times(1)).findAll()
        verifyNoMoreInteractions(initialAssessmentLevelRepository)
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        InitialAssessmentLevelService service = new InitialAssessmentLevelService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindById() {
        InitialAssessmentLevel result = initialAssessmentLevelService.findById(1);
        verify(initialAssessmentLevelRepository, times(1)).findById(1)
        verifyNoMoreInteractions(initialAssessmentLevelRepository)
    }
    
    @Test
    public void testSave() {
        InitialAssessmentLevel savedInitialAssessmentLevel = initialAssessmentLevelService.save(initialAssessmentLevel);
        verify(initialAssessmentLevelRepository, times(1)).save(any())
        verifyNoMoreInteractions(initialAssessmentLevelRepository)
    }
    
    @Test
    public void testSaveInitialAssessmentLevel() {
        InitialAssessmentLevel savedInitialAssessmentLevel = initialAssessmentLevelService.save(initialAssessmentLevel);
        verify(initialAssessmentLevelRepository, times(1)).save(any())
        verifyNoMoreInteractions(initialAssessmentLevelRepository)
    }
    
    @Test
    public void testSaveInitialAssessmentLevels() {
        List<InitialAssessmentLevel> savedInitialAssessmentLevels = initialAssessmentLevelService.saveInitialAssessmentLevels([
            new InitialAssessmentLevel(id: 1),
            new InitialAssessmentLevel(id: 2)
        ]);
        verify(initialAssessmentLevelRepository, times(2)).save(any(InitialAssessmentLevel.class))
        verifyNoMoreInteractions(initialAssessmentLevelRepository)
    }
    
    @Test
    public void testSaveInitialAssessmentLevelByFields() {
        InitialAssessmentLevel savedInitialAssessmentLevel = initialAssessmentLevelService.save(initialAssessmentLevel);
        verify(initialAssessmentLevelRepository, times(1)).save(any())
        verifyNoMoreInteractions(initialAssessmentLevelRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create initialAssessmentLevelDto from null object.")
        InitialAssessmentLevelDto dto = null
        initialAssessmentLevelService.createFromDto(dto)
        verifyNoMoreInteractions(initialAssessmentLevelRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        InitialAssessmentLevelDto dto = new InitialAssessmentLevelDto(id: 1, initialAssessmentLevel: '123')
        initialAssessmentLevelService.createFromDto(dto)
        verify(initialAssessmentLevelRepository, times(1)).save(any(InitialAssessmentLevel.class))
        verifyNoMoreInteractions(initialAssessmentLevelRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        InitialAssessmentLevelDto dto = new InitialAssessmentLevelDto(id: 1, initialAssessmentLevel: '123')
        initialAssessmentLevelService.updateFromDto(dto)
        verify(initialAssessmentLevelRepository, times(1)).findById(initialAssessmentLevel.id)
        verify(initialAssessmentLevelRepository, times(1)).save(initialAssessmentLevel)
        verifyNoMoreInteractions(initialAssessmentLevelRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update initialAssessmentLevelDto from null object.")
        InitialAssessmentLevelDto dto = null
        initialAssessmentLevelService.updateFromDto(dto)
        verifyNoMoreInteractions(initialAssessmentLevelRepository)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        initialAssessmentLevelService.delete(initialAssessmentLevel)
        verifyNoMoreInteractions(initialAssessmentLevelRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}

