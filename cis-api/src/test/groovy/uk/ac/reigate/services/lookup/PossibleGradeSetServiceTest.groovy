package uk.ac.reigate.services.lookup

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertFalse
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import uk.ac.reigate.domain.lookup.PossibleGradeSet
import uk.ac.reigate.dto.lookup.PossibleGradeDto
import uk.ac.reigate.dto.lookup.PossibleGradeSetDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.PossibleGradeSetRepository
import uk.ac.reigate.services.lookup.PossibleGradeService
import uk.ac.reigate.services.lookup.PossibleGradeSetService

@RunWith(MockitoJUnitRunner.class)
class PossibleGradeSetServiceTest {
    
    @Mock
    private PossibleGradeSetRepository possibleGradeSetRepository;
    
    @Mock
    private PossibleGradeService possibleGradeService;
    
    @InjectMocks
    private PossibleGradeSetService possibleGradeSetService;
    
    private PossibleGradeSet possibleGradeSet
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    PossibleGradeSet createPossibleGradeSet() {
        return new PossibleGradeSet(
                id: 1,
                code: 'Test',
                description: 'Testing'
                )
    }
    
    PossibleGradeSetDto createDto() {
        PossibleGradeSet sampleData = createPossibleGradeSet()
        return new PossibleGradeSetDto(
                id: sampleData.id,
                code: sampleData.code,
                description: sampleData.description
                )
    }
    
    @Before
    public void setup() {
        possibleGradeSetRepository = mock(PossibleGradeSetRepository.class);
        possibleGradeService = mock(PossibleGradeService.class);
        
        this.possibleGradeSetService = new PossibleGradeSetService(possibleGradeSetRepository, possibleGradeService);
        
        possibleGradeSet = createPossibleGradeSet()
        
        when(possibleGradeSetRepository.findById(1)).thenReturn(new Optional(new PossibleGradeSet()));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        PossibleGradeSetService service = new PossibleGradeSetService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindPossibleGradeSets() {
        List<PossibleGradeSet> result = possibleGradeSetService.findAll();
        verify(possibleGradeSetRepository, times(1)).findAll()
        verifyNoMoreInteractions(possibleGradeSetRepository)
    }
    
    @Test
    public void testFindPossibleGradeSet() {
        PossibleGradeSet result = possibleGradeSetService.findById(1);
        verify(possibleGradeSetRepository, times(1)).findById(1)
        verifyNoMoreInteractions(possibleGradeSetRepository)
    }
    
    @Test
    public void testSaveNewPossibleGradeSet() {
        PossibleGradeSet savedPossibleGradeSet = possibleGradeSetService.save(possibleGradeSet);
        verify(possibleGradeSetRepository, times(1)).save(any(PossibleGradeSet.class))
        verifyNoMoreInteractions(possibleGradeSetRepository)
    }
    
    @Test
    public void testSavePossibleGradeSet() {
        PossibleGradeSet savedPossibleGradeSet = possibleGradeSetService.save(possibleGradeSet);
        verify(possibleGradeSetRepository, times(1)).save(any(PossibleGradeSet.class))
        verifyNoMoreInteractions(possibleGradeSetRepository)
    }
    
    @Test
    public void testSavePossibleGradeSets() {
        List<PossibleGradeSet> savedPossibleGradeSets = possibleGradeSetService.savePossibleGradeSets([
            new PossibleGradeSet(id: 1),
            new PossibleGradeSet(id: 2)
        ]);
        verify(possibleGradeSetRepository, times(2)).save(any(PossibleGradeSet.class))
        verifyNoMoreInteractions(possibleGradeSetRepository)
    }
    
    @Test
    public void testSavePossibleGradeSetByFields_WithNullId() {
        PossibleGradeSet savedPossibleGradeSet = possibleGradeSetService.save(possibleGradeSet);
        verify(possibleGradeSetRepository, times(1)).save(any())
        verifyNoMoreInteractions(possibleGradeSetRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        PossibleGradeSetDto dto = new PossibleGradeSetDto(id: 1, code: 'Test')
        possibleGradeSetService.createFromDto(dto)
        verify(possibleGradeSetRepository, times(1)).save(any(PossibleGradeSet.class))
        verifyNoMoreInteractions(possibleGradeSetRepository)
    }
    
    @Test
    public void testCreateFromDto_withGrades() {
        PossibleGradeSetDto dto = createDto()
        dto.grades = [
            new PossibleGradeDto(id: 1, code: 'Test', gradeSetId: 1)
        ]
        dto.grades.collect{
            when(possibleGradeService.createFromDto(it)).thenReturn(null)
        }
        possibleGradeSetService.createFromDto(dto)
        verify(possibleGradeSetRepository, times(1)).save(any(PossibleGradeSet.class))
        verifyNoMoreInteractions(possibleGradeSetRepository)
    }
    
    @Test
    public void testUpdateFromDto_withGrades() {
        PossibleGradeSetDto dto = createDto();
        dto.grades = [
            new PossibleGradeDto(id: 1, code: 'Test', gradeSetId: 1)
        ]
        !dto.grades.empty
        dto.grades.collect{
            it.id = 1
            when(possibleGradeService.updateFromDto(it)).thenReturn(null)
        }
        possibleGradeSetService.updateFromDto(dto)
        verify(possibleGradeSetRepository, times(1)).findById(dto.id)
    }
    
    @Test
    public void testUpdateFromDto_withNullGradesEmpty() {
        PossibleGradeSetDto dto = createDto();
        dto.grades = []
        !dto.grades.empty
        dto.grades.collect{
            it.id = null
            when(possibleGradeService.createFromDto(it)).thenReturn(null)
        }
        possibleGradeSetService.updateFromDto(dto)
        verify(possibleGradeSetRepository, times(1)).findById(dto.id)
    }
    
    @Test
    public void testUpdateFromDto_withNullGrades() {
        PossibleGradeSetDto dto = createDto();
        dto.grades = [
            new PossibleGradeDto(code: 'Test', gradeSetId: 1)
        ]
        !dto.grades.empty
        dto.grades.collect{
            it.id = null
            when(possibleGradeService.createFromDto(it)).thenReturn(null)
        }
        possibleGradeSetService.updateFromDto(dto)
        verify(possibleGradeSetRepository, times(1)).findById(dto.id)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create possibleGradeSet from null object.")
        PossibleGradeSetDto dto = null
        possibleGradeSetService.createFromDto(dto)
        verifyNoMoreInteractions(possibleGradeSetRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update possibleGradeSet from null object.")
        PossibleGradeSetDto dto = null
        possibleGradeSetService.updateFromDto(dto)
        verifyNoMoreInteractions(possibleGradeSetRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        possibleGradeSetService.delete(possibleGradeSet)
        assertThatExceptionOfType(InvalidDataException.class)
        verifyNoMoreInteractions(possibleGradeSetRepository)
    }
}

