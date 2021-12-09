package uk.ac.reigate.services.exams.basedata

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.domain.exams.basedata.ExamSeries
import uk.ac.reigate.dto.exams.basedata.ExamComponentDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.exams.basedata.ExamComponentRepository

class ExamComponentServiceTest {
    
    @Mock
    private ExamComponentRepository examComponentRepository
    
    @Mock
    private ExamSeriesService examSeriesService
    
    @InjectMocks
    private ExamComponentService examComponentService
    
    private ExamComponent examComponent
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    ExamComponent createExamComponent() {
        return new ExamComponent(
                id: 1,
                examSeries : new ExamSeries(),
                code: 'test12345678',
                title: 'test',
                teacherMarks: '1',
                maximumMark: 1,
                gradeset : 'ABCD',
                dueDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                timetabled : '1',
                timetableDate : new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                timetableSession : '1',
                timeAllowed : 5
                )
    }
    
    ExamComponentDto createDto() {
        ExamComponent sampleExamComponent = createExamComponent()
        return new ExamComponentDto(
                id: sampleExamComponent.id,
                examSeriesId : sampleExamComponent.examSeries.id,
                code : sampleExamComponent.code,
                title: sampleExamComponent.title,
                teacherMarks : sampleExamComponent.teacherMarks,
                maximumMark : sampleExamComponent.maximumMark,
                gradeset : sampleExamComponent.gradeset,
                dueDate : sampleExamComponent.dueDate,
                timetabled : sampleExamComponent.timetabled,
                timetableDate : sampleExamComponent.timetableDate,
                timetableSession: sampleExamComponent.timetableSession,
                timeAllowed : sampleExamComponent.timeAllowed
                )
    }
    
    @Before
    public void setup() {
        examComponentRepository = mock(ExamComponentRepository.class)
        examSeriesService = mock(ExamSeriesService.class)
        
        examComponentService = new ExamComponentService(examComponentRepository, examSeriesService)
        
        examComponent = createExamComponent()
        when(examComponentRepository.findById(examComponent.id)).thenReturn(new Optional(new ExamComponent()));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        ExamComponentService service = new ExamComponentService();
        assertNotNull(service);
    }
    
    @Test
    public void testFindById() {
        ExamComponent result = examComponentService.findById(1)
        verify(examComponentRepository, times(1)).findById(1)
        verifyNoMoreInteractions(examComponentRepository)
    }
    
    @Test
    public void testFindAll() {
        List<ExamComponent> result = examComponentService.findAll()
        verify(examComponentRepository, times(1)).findAll()
        verifyNoMoreInteractions(examComponentRepository)
    }
    
    @Test
    public void testFindByExamSeriesAndCode() {
        ExamSeries examSeries = new ExamSeries(id:1)
        ExamComponent result = examComponentService.findByExamSeriesAndCode(examSeries, 'test')
        verify(examComponentRepository, times(1)).findByExamSeriesAndCode(examSeries, 'test')
        verifyNoMoreInteractions(examComponentRepository)
    }
    
    @Test
    public void testFindByExamComponentsByDateAndSession() {
        Date timetableDate = new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09')
        String timetableSession = 'Pm'
        List<ExamSeries> examSeries = examComponentService.findExamComponentsByDateAndSession(timetableDate, timetableSession)
        verify(examComponentRepository, times(1)).findByTimetableDateAndTimetableSession(timetableDate, timetableSession)
        verifyNoMoreInteractions(examComponentRepository)
    }
    
    @Test
    public void testSave() {
        examComponentService.save(examComponent);
        verify(examComponentRepository, times(1)).save(examComponent)
        verifyNoMoreInteractions(examComponentRepository)
    }
    
    @Test
    public void testDeleteWithId() {
        examComponentService.delete(1)
        examComponentService.findById(1)
    }
    
    @Test
    public void testDelete() {
        examComponentService.delete(examComponent)
        verify(examComponentRepository, times(1)).delete(examComponent)
        verifyNoMoreInteractions(examComponentRepository)
    }
    
    @Test
    public void testCreateFromDto() {
        ExamComponentDto dto = createDto()
        examComponentService.createFromDto(dto)
        verify(examComponentRepository, times(1)).save(any(ExamComponent.class))
        verifyNoMoreInteractions(examComponentRepository)
    }
    
    @Test
    public void testCreateFromDto_withExamSeriesId() {
        ExamComponentDto dto = createDto()
        dto.examSeriesId = 1
        when(examSeriesService.findById(dto.examSeriesId)).thenReturn(null)
        examComponentService.createFromDto(dto)
        verify(examComponentRepository, times(1)).save(any(ExamComponent.class))
        verifyNoMoreInteractions(examComponentRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create ExamComponent from null object.")
        ExamComponentDto dto = null
        examComponentService.createFromDto(dto)
        verifyNoMoreInteractions(examComponentRepository)
    }
    
    @Test
    public void testUpdateFromDto() {
        ExamComponentDto dto = createDto()
        examComponentService.updateFromDto(dto)
        verify(examComponentRepository, times(1)).findById(examComponent.id)
        verify(examComponentRepository, times(1)).save(any(ExamComponent.class))
        verifyNoMoreInteractions(examComponentRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullId() {
        ExamComponentDto dto = createDto()
        dto.id = null
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update ExamComponent from null object.");
        examComponentService.updateFromDto(dto)
        verifyNoMoreInteractions(examComponentRepository)
    }
    
    @Test
    public void testUpdateFromDto_withExamSeriesId() {
        ExamComponentDto dto = createDto()
        dto.examSeriesId = 1
        when(examSeriesService.findById(dto.examSeriesId)).thenReturn(null)
        examComponentService.updateFromDto(dto)
        verify(examSeriesService, times(1)).findById(dto.examSeriesId)
        verifyNoMoreInteractions(examSeriesService)
    }
}
