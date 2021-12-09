package uk.ac.reigate.services.exams

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.exams.Results
import uk.ac.reigate.dto.exams.ResultsDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.exams.ResultsRepository
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.student.StudentService

class ResultsServiceTest {
    
    @Mock
    private ResultsRepository resultsRepository
    
    @Mock
    private AcademicYearService academicYearService
    
    @Mock
    private StudentService studentService
    
    @Mock
    private ExamBoardService examBoardService
    
    private Results result
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    @InjectMocks
    ResultsService resultsService
    
    Results createResults() {
        return new Results(
                id: 1,
                academicYear: new AcademicYear(id: 1),
                examBoard : new ExamBoard(id: 1),
                student : new Student(id: 190001),
                examSeries : 'A',
                examYear : '2010',
                candidateNo : 20002
                )
    }
    
    ResultsDto createDto() {
        Results sampleResults = createResults()
        return new ResultsDto(
                id: sampleResults.id,
                academicYearId : sampleResults.academicYear.id,
                examBoardId : sampleResults.examBoard.id,
                studentId: sampleResults.student.id,
                examSeries: sampleResults.examSeries,
                examYear : sampleResults.examYear,
                candidateNo : sampleResults.candidateNo
                )
    }
    
    @Before
    public void setup() {
        resultsRepository = mock(ResultsRepository.class)
        academicYearService = mock(AcademicYearService.class)
        studentService = mock(StudentService.class)
        examBoardService = mock(ExamBoardService.class)
        
        resultsService = new ResultsService(resultsRepository, academicYearService, studentService, examBoardService)
        result = createResults()
        when(resultsRepository.findById(1)).thenReturn(new Optional(new Results()));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        ResultsService service = new ResultsService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<Results> result = resultsService.findAll();
        verify(resultsRepository, times(1)).findAll()
        verifyNoMoreInteractions(resultsRepository)
    }
    
    @Test
    public void testFindById() {
        Results result = resultsService.findById(1);
        verify(resultsRepository, times(1)).findById(1)
        verifyNoMoreInteractions(resultsRepository)
    }
    
    @Test
    public void testGetByStudent() {
        List<Results> result = resultsService.getByStudentId(190001)
        verify(resultsRepository, times(1)).findByStudent_Id(190001)
        verifyNoMoreInteractions(resultsRepository)
    }
    
    @Test
    public void testSave() {
        resultsService.save(result);
        verify(resultsRepository, times(1)).save(result)
        verifyNoMoreInteractions(resultsRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        resultsService.delete(result)
        verifyNoMoreInteractions(resultsRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    @Test
    public void testUpdateFromDto_withDto() {
        ResultsDto dto = createDto()
        resultsService.updateFromDto(dto)
        when(resultsService.findById(dto.id)).thenReturn(null);
        verify(resultsRepository, times(1)).save(any(Results.class))
    }
    
    @Test
    public void testUpdateFromDto_withDtoNullId() {
        ResultsDto dto = new ResultsDto(id:1)
        dto.studentId = null
        dto.examBoardId = null
        dto.academicYearId = null
        resultsService.updateFromDto(dto)
        when(resultsService.findById(dto.id)).thenReturn(null);
        verify(resultsRepository, times(1)).save(any(Results.class))
    }
    
    @Test
    public void testUpdateFromDto_withDtoWithNoId() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update resultsDto from null objects");
        // Initialise Test
        ResultsDto dto = null
        resultsService.updateFromDto(dto)
        // Verify Results
        verifyNoMoreInteractions(resultsRepository)
    }
}
