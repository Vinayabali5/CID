package uk.ac.reigate.services

import static org.junit.Assert.assertNotNull
import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

import uk.ac.reigate.domain.lookup.Level
import uk.ac.reigate.dto.lookup.LevelDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.LevelRepository
import uk.ac.reigate.services.lookup.PossibleGradeSetService

@RunWith(MockitoJUnitRunner.class)
class LevelServiceTest {
    
    @Mock
    private LevelRepository levelRepository;
    
    @Mock
    private PossibleGradeSetService possibleGradeSetService
    
    @InjectMocks
    private LevelService levelService;
    
    private Level level
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    Level createLevel() {
        return new Level(
                id: 1,
                code: 'A',
                description: 'A Level'
                )
    }
    
    LevelDto createDto() {
        Level sampleData = createLevel();
        return new LevelDto(
                id: sampleData.id,
                code: sampleData.code,
                description: sampleData.description
                )
    }
    
    
    @Before
    public void setup() {
        levelRepository = mock(LevelRepository.class);
        possibleGradeSetService = mock(PossibleGradeSetService.class);
        
        levelService = new LevelService(levelRepository, possibleGradeSetService);
        level = createLevel()
        when(levelRepository.findById(level.id)).thenReturn(new Optional(new Level()));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        LevelService service = new LevelService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindLevels() {
        List<Level> result = levelService.findAll();
        verify(levelRepository, times(1)).findAll()
        verifyNoMoreInteractions(levelRepository)
    }
    
    @Test
    public void testFindLevel() {
        Level result = levelService.findById(1);
        verify(levelRepository, times(1)).findById(1)
        verifyNoMoreInteractions(levelRepository)
    }
    
    @Test
    public void testSaveNewLevel() {
        Level savedLevel = levelService.save(level);
        verify(levelRepository, times(1)).save(any(Level.class))
        verifyNoMoreInteractions(levelRepository)
    }
    
    @Test
    public void testSaveLevel() {
        Level savedLevel = levelService.save(level);
        verify(levelRepository, times(1)).save(any(Level.class))
        verifyNoMoreInteractions(levelRepository)
    }
    
    @Test
    public void testSaveLevels() {
        List<Level> savedLevels = levelService.saveLevels([
            new Level(id: 1),
            new Level(id: 2)
        ]);
        verify(levelRepository, times(2)).save(any(Level.class))
        verifyNoMoreInteractions(levelRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        LevelDto dto = new LevelDto(id: 1, code: 'A')
        levelService.createFromDto(dto)
        verify(levelRepository, times(1)).save(any(Level.class))
        verifyNoMoreInteractions(levelRepository)
    }
    
    @Test
    public void testCreateFromDto_withPossibleGradeSetId () {
        LevelDto dto = createDto()
        dto.possibleGradeSetId = 1
        levelService.createFromDto(dto)
        when(possibleGradeSetService.findById(dto.possibleGradeSetId)).thenReturn(null)
        verify(levelRepository, times(1)).save(any(Level.class))
        verifyNoMoreInteractions(levelRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        LevelDto dto = new LevelDto(id: 1, code: 'A')
        levelService.updateFromDto(dto)
        verify(levelRepository, times(1)).findById(level.id)
        verify(levelRepository, times(1)).save(any(Level.class))
        verifyNoMoreInteractions(levelRepository)
    }
    
    @Test
    public void testUpdateFromDto_withPossibleGradeSetId () {
        LevelDto dto = createDto()
        dto.possibleGradeSetId = 1
        when(possibleGradeSetService.findById(dto.possibleGradeSetId)).thenReturn(null)
        levelService.updateFromDto(dto)
        verify(possibleGradeSetService, times(1)).findById(dto.possibleGradeSetId)
        verifyNoMoreInteractions(possibleGradeSetService)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create Level from null object.")
        LevelDto dto = null
        levelService.createFromDto(dto)
        verifyNoMoreInteractions(levelRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullId() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create Level from null Id.")
        LevelDto dto = new LevelDto(code:'Test')
        levelService.updateFromDto(dto)
        verifyNoMoreInteractions(levelRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update Level from null object.")
        LevelDto dto = null
        levelService.updateFromDto(dto)
        verifyNoMoreInteractions(levelRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        levelService.delete(level)
        verifyNoMoreInteractions(levelRepository)
    }
}

