package uk.ac.reigate.services.lookup

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import uk.ac.reigate.domain.lookup.PossibleGrade
import uk.ac.reigate.dto.lookup.PossibleGradeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.PossibleGradeRepository
import uk.ac.reigate.repositories.lookup.PossibleGradeSetRepository
import uk.ac.reigate.services.lookup.PossibleGradeService
import uk.ac.reigate.services.lookup.PossibleGradeSetService


class PossibleGradeServiceTest {
    
    @Mock
    private PossibleGradeRepository possibleGradeRepository;
    
    @InjectMocks
    private PossibleGradeService possibleGradeService;
    
    @Mock
    private PossibleGradeSetService possibleGradeSetService
    
    private PossibleGradeSetRepository possibleGradeSetRepository
    
    private PossibleGrade possibleGrade;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    PossibleGrade createPossibleGrade() {
        return new PossibleGrade(
                id: 1,
                code: 'M',
                description: 'Male',
                grade: 'A',
                ucasPoints: 10,
                useForKeyAssessment: true
                )
    }
    
    PossibleGradeDto createDto() {
        PossibleGrade sampleData = createPossibleGrade()
        return new PossibleGradeDto(
                id: sampleData.id,
                code: sampleData.code,
                description: sampleData.description,
                grade: sampleData.grade,
                ucasPoints: sampleData.ucasPoints,
                useForKeyAssessment: sampleData.useForKeyAssessment
                )
    }
    
    @Before
    public void setup() {
        possibleGradeRepository = mock(PossibleGradeRepository.class);
        possibleGradeSetService = mock(PossibleGradeSetService.class);
        
        this.possibleGradeService = new PossibleGradeService(possibleGradeRepository, possibleGradeSetService);
        
        possibleGrade = createPossibleGrade()
        
        when(possibleGradeRepository.findById(possibleGrade.id)).thenReturn(new Optional(new PossibleGrade()));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        PossibleGradeService service = new PossibleGradeService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindPossibleGrade() {
        List<PossibleGrade> result = possibleGradeService.findAll();
        verify(possibleGradeRepository, times(1)).findAll()
        verifyNoMoreInteractions(possibleGradeRepository)
    }
    
    @Test
    public void testFindByPossibleGradeSet() {
        List<PossibleGrade> result = possibleGradeService.findByPossibleGradeSet(10);
        verify(possibleGradeRepository, times(1)).findByGradeSet_Id(10)
        verifyNoMoreInteractions(possibleGradeRepository)
    }
    
    @Test
    public void testFindPossibleGradeById() {
        PossibleGrade result = possibleGradeService.findById(1);
        verify(possibleGradeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(possibleGradeRepository)
    }
    
    @Test
    public void testSave() {
        possibleGrade.id = null
        possibleGradeService.save(possibleGrade);
        verify(possibleGradeRepository, times(1)).save(possibleGrade)
        verifyNoMoreInteractions(possibleGradeRepository)
    }
    
    @Test
    public void testSaveList() {
        List<PossibleGrade> savedpossibleGrades = possibleGradeService.savePossibleGrades([possibleGrade, possibleGrade]);
        verify(possibleGradeRepository, times(2)).save(possibleGrade)
        verifyNoMoreInteractions(possibleGradeRepository)
    }
    
    @Test
    public void testSavePossibleGrade() {
        possibleGradeService.save(possibleGrade);
        verify(possibleGradeRepository, times(1)).save(possibleGrade)
        verifyNoMoreInteractions(possibleGradeRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        PossibleGradeDto dto = new PossibleGradeDto(id: 1, code: 'Test')
        possibleGradeService.createFromDto(dto)
        verify(possibleGradeRepository, times(1)).save(any(PossibleGrade.class))
        verifyNoMoreInteractions(possibleGradeRepository)
    }
    
    @Test
    public void testCreateFromDto_withGradeSetId() {
        PossibleGradeDto dto = createDto()
        dto.gradeSetId = 1
        when(possibleGradeSetService.findById(dto.gradeSetId)).thenReturn(null);
        possibleGradeService.createFromDto(dto)
        verify(possibleGradeRepository, times(1)).save(any(PossibleGrade.class))
        verifyNoMoreInteractions(possibleGradeRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        PossibleGradeDto dto = new PossibleGradeDto(id: 1, code: 'Test')
        possibleGradeService.updateFromDto(dto)
        verify(possibleGradeRepository, times(1)).findById(possibleGrade.id)
        verify(possibleGradeRepository, times(1)).save(any(PossibleGrade.class))
        verifyNoMoreInteractions(possibleGradeRepository)
    }
    
    @Test
    public void tesUpdateFromDto_withGradeSetId() {
        PossibleGradeDto dto = createDto()
        dto.gradeSetId = 1
        when(possibleGradeSetService.findById(dto.gradeSetId)).thenReturn(null);
        possibleGradeService.updateFromDto(dto)
        verify(possibleGradeSetService, times(1)).findById(dto.id)
        verifyNoMoreInteractions(possibleGradeSetService)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create possibleGradeDto from null object.")
        PossibleGradeDto dto = null
        possibleGradeService.createFromDto(dto)
        verifyNoMoreInteractions(possibleGradeRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update possibleGradeDto from null object.")
        PossibleGradeDto dto = null
        possibleGradeService.updateFromDto(dto)
        verifyNoMoreInteractions(possibleGradeRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        possibleGradeService.delete(possibleGrade)
        verifyNoMoreInteractions(possibleGradeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}

