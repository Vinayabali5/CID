package uk.ac.reigate.services.exams.basedata

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import com.querydsl.core.types.dsl.BooleanExpression

import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.exams.basedata.ExamSeries
import uk.ac.reigate.dto.exams.basedata.ExamSeriesDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.exams.basedata.ExamSeriesRepository
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.exams.ExamBoardService
import uk.ac.reigate.util.exception.BadRequestException

class ExamSeriesServiceTest {
    
    @Mock
    private ExamSeriesRepository examSeriesRepository
    
    @Mock
    private AcademicYearService academicYearService
    
    @Mock
    private ExamBoardService examBoardService
    
    @InjectMocks
    private ExamSeriesService examSeriesService
    
    private ExamSeries examSeries
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    ExamSeries createExamSeries() {
        return new ExamSeries(
                id: 1,
                examYear : '2020',
                examSeries : 'PM',
                nextSequenceNo : 10,
                entrySubmitted : true
                )
    }
    
    ExamSeriesDto createDto() {
        ExamSeries sampleExamSeries = createExamSeries();
        return new ExamSeriesDto(
                id: sampleExamSeries.id,
                examYear: sampleExamSeries.examYear,
                nextSequenceNo : sampleExamSeries.nextSequenceNo,
                entrySubmitted : sampleExamSeries.entrySubmitted
                )
    }
    
    @Before
    public void setup() {
        examSeriesRepository = mock(ExamSeriesRepository.class);
        academicYearService = mock(AcademicYearService.class);
        examBoardService = mock(ExamBoardService.class);
        
        examSeriesService = new ExamSeriesService(examSeriesRepository, academicYearService, examBoardService)
        examSeries = createExamSeries()
        when(examSeriesRepository.findById(examSeries.id)).thenReturn(new Optional(new ExamSeries()))
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        ExamSeriesService service = new ExamSeriesService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<ExamSeries> result = examSeriesService.findAll()
        verify(examSeriesRepository, times(1)).findAll()
        verifyNoMoreInteractions(examSeriesRepository)
    }
    
    @Test
    public void testFindById() {
        ExamSeries result = examSeriesService.findById(1)
        verify(examSeriesRepository, times(1)).findById(1)
        verifyNoMoreInteractions(examSeriesRepository)
    }
    
    @Test
    public void testSave() {
        examSeriesService.save(examSeries)
        verify(examSeriesRepository, times(1)).save(examSeries)
        verifyNoMoreInteractions(examSeriesRepository)
    }
    
    @Test
    public void testFindExamSeriesList() {
        Integer examBoardId = 1
        Integer academicYearId = 1
        List<ExamSeries> result = examSeriesService.findExamSeriesList(examBoardId, academicYearId)
        List<ExamSeries> examSeriesList
        verify(examSeriesRepository, times(1)).findByExamBoard_IdAndAcademicYear_Id(1, 1)
        verifyNoMoreInteractions(examSeriesRepository)
    }
    
    @Test
    public void testFindExamSeriesListByExamBoardId() {
        Integer examBoardId = 1
        Integer academicYearId = null
        List<ExamSeries> result = examSeriesService.findExamSeriesList(examBoardId, academicYearId)
        List<ExamSeries> examSeriesList
        verify(examSeriesRepository, times(1)).findByExamBoard_Id(1)
        verifyNoMoreInteractions(examSeriesRepository)
    }
    
    @Test
    public void testFindExamSeriesListByAcademicId() {
        Integer examBoardId = null
        Integer academicYearId = 1
        List<ExamSeries> result = examSeriesService.findExamSeriesList(examBoardId, academicYearId)
        List<ExamSeries> examSeriesList
        verify(examSeriesRepository, times(1)).findByAcademicYear_Id(1)
        verifyNoMoreInteractions(examSeriesRepository)
    }
    
    @Test
    public void testFindExamSeriesListNullIds() {
        Integer examBoardId = null
        Integer academicYearId = null
        List<ExamSeries> result = examSeriesService.findExamSeriesList(examBoardId, academicYearId)
        List<ExamSeries> examSeriesList
        verify(examSeriesRepository, times(1)).findAll()
        verifyNoMoreInteractions(examSeriesRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("ExamSeries should not be deleted");
        examSeriesService.delete(examSeries)
        verifyNoMoreInteractions(examSeriesRepository)
    }
    
    //@Test
    public void testFindAllBoolean() {
        BooleanExpression booleanExpression
        List<ExamSeries> result = examSeriesService.findAll(booleanExpression)
        verify(examSeriesRepository, times(1)).findAll(booleanExpression)
        verifyNoMoreInteractions(examSeriesRepository)
    }
    
    @Test
    public void testFindByExamYearAndExamSeries() {
        List<ExamSeries> result = examSeriesService.findByExamYearAndExamSeries('2020', '1A')
        verify(examSeriesRepository, times(1)).findByExamYearAndExamSeries('2020', '1A')
        verifyNoMoreInteractions(examSeriesRepository)
    }
    
    @Test
    public void testFindByExamBoardYearAndSeries() {
        ExamBoard examBoard = new ExamBoard(id: 1)
        ExamSeries result = examSeriesService.findByExamBoardYearAndSeries(examBoard, '2020', '1A')
        verify(examSeriesRepository, times(1)).findByExamBoardAndExamYearAndExamSeries(examBoard, '2020', '1A')
        verifyNoMoreInteractions(examSeriesRepository)
    }
    
    @Test
    public void testCreateFromDto() {
        ExamSeriesDto dto = createDto()
        examSeriesService.createFromDto(dto)
        verify(examSeriesRepository, times(1)).save(any(ExamSeries.class))
        verifyNoMoreInteractions(examSeriesRepository)
    }
    
    @Test
    public void testCreatefromDto_withhNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create Exam Series from null object.")
        ExamSeriesDto dto = null
        examSeriesService.createFromDto(dto)
        verifyNoMoreInteractions(examSeriesRepository)
    }
    
    @Test
    public void testCreateFromDto_withExamBoardId() {
        ExamSeriesDto dto = createDto()
        dto.examBoardId = 1
        when(examBoardService.findById(dto.examBoardId)).thenReturn(null);
        examSeriesService.createFromDto(dto)
        verify(examSeriesRepository, times(1)).save(any(ExamSeries.class))
        verifyNoMoreInteractions(examSeriesRepository)
    }
    
    @Test
    public void testCreateFromDto_withAcademicYearId() {
        ExamSeriesDto dto = createDto()
        dto.academicYearId = 20
        when(academicYearService.findById(dto.academicYearId)).thenReturn(null);
        examSeriesService.createFromDto(dto)
        verify(examSeriesRepository, times(1)).save(any(ExamSeries.class))
        verifyNoMoreInteractions(examSeriesRepository)
    }
    
    @Test
    public void testUpdateFromDto() {
        ExamSeriesDto dto = createDto()
        examSeriesService.updateFromDto(dto)
        verify(examSeriesRepository, times(1)).findById(examSeries.id)
        verify(examSeriesRepository, times(1)).save(any(ExamSeries.class))
        verifyNoMoreInteractions(examSeriesRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNoId() {
        ExamSeriesDto dto = createDto()
        dto.id = null
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update Exam Series from null ID.")
        examSeriesService.updateFromDto(dto)
        verifyNoMoreInteractions(examSeriesRepository)
    }
    
    @Test
    public void testUpdateFromDto_withExamBoardId() {
        ExamSeriesDto dto = createDto()
        dto.examBoardId = 1
        when(examBoardService.findById(dto.examBoardId)).thenReturn(null)
        examSeriesService.updateFromDto(dto)
        verify(examBoardService, times(1)).findById(dto.examBoardId)
        verifyNoMoreInteractions(examBoardService)
    }
    
    @Test
    public void testUpdateFromDto_withAcademicYearId() {
        ExamSeriesDto dto = createDto()
        dto.academicYearId = 20
        when(academicYearService.findById(dto.academicYearId)).thenReturn(null)
        examSeriesService.updateFromDto(dto)
        verify(academicYearService, times(1)).findById(dto.academicYearId)
        verifyNoMoreInteractions(academicYearService)
    }
    
    @Test
    public void testDeleteId() {
        ExamSeries result = examSeriesService.delete(1)
        examSeriesRepository.findById(1)
        result = new ExamSeries(id:1)
        examSeriesRepository.delete(result)
    }
    
}
