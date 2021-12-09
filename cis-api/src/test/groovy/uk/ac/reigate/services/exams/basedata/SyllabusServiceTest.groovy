package uk.ac.reigate.services.exams.basedata

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.exams.basedata.ExamSeries
import uk.ac.reigate.domain.exams.basedata.Syllabus
import uk.ac.reigate.dto.exams.basedata.SyllabusDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.exams.basedata.SyllabusRepository

class SyllabusServiceTest {
    
    @Mock
    private SyllabusRepository syllabusRepository
    
    @Mock
    private ExamSeriesService examSeriesService
    
    @Mock
    private ExamOptionService examOptionService
    
    @InjectMocks
    private SyllabusService syllabusService
    
    private Syllabus syllabus
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    Syllabus createSyllabus() {
        return new Syllabus(
                examSeries : new ExamSeries(id: 1),
                code : 'PM',
                title : 'MAT'
                )
    }
    
    SyllabusDto createDto() {
        Syllabus sampleSyllabus = createSyllabus();
        return new SyllabusDto(
                examSeries: sampleSyllabus.examSeries,
                code : sampleSyllabus.code,
                title : sampleSyllabus.title
                )
    }
    
    @Before
    public void setup() {
        syllabusRepository = mock(SyllabusRepository.class);
        examSeriesService = mock(ExamSeriesService.class);
        examOptionService = mock(ExamOptionService.class);
        
        syllabusService = new SyllabusService(syllabusRepository, examSeriesService, examOptionService)
        syllabus = createSyllabus()
        when(syllabusRepository.findById(syllabus.id)).thenReturn(new Optional(new Syllabus()))
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        SyllabusService service = new SyllabusService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<Syllabus> result = syllabusService.findAll()
        verify(syllabusRepository, times(1)).findAll()
        verifyNoMoreInteractions(syllabusRepository)
    }
    
    @Test
    public void testFindById() {
        Syllabus result = syllabusService.findById(1)
        verify(syllabusRepository, times(1)).findById(1)
        verifyNoMoreInteractions(syllabusRepository)
    }
    
    @Test
    public void testSave() {
        syllabusService.save(syllabus)
        verify(syllabusRepository, times(1)).save(syllabus)
        verifyNoMoreInteractions(syllabusRepository)
    }
    
    @Test
    public void testFindSyllabusList() {
        List<Syllabus> result = syllabusService.findByYearId(1)
        List<Syllabus> syllabusList
        verify(syllabusRepository, times(1)).findByYearId(1)
        verifyNoMoreInteractions(syllabusRepository)
    }
    
    @Test
    public void testFindByExamSeriesAndSyllabusCode() {
        ExamSeries examSeries = new ExamSeries(id: 1)
        Syllabus result = syllabusService.findByExamSeriesAndSyllabusCode(examSeries, '2020')
        verify(syllabusRepository, times(1)).findByExamSeriesAndCode(examSeries, '2020')
        verifyNoMoreInteractions(syllabusRepository)
    }
    
    // @Test
    public void testCreateFromDto() {
        SyllabusDto dto = createDto()
        syllabusService.createFromDto(dto)
        verify(syllabusRepository, times(1)).save(any(Syllabus.class))
        verifyNoMoreInteractions(syllabusRepository)
    }
    
    @Test
    public void testCreatefromDto_withhNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create syllabusDto from null object.")
        SyllabusDto dto = null
        syllabusService.createFromDto(dto)
        verifyNoMoreInteractions(syllabusRepository)
    }
    
    // @Test
    public void testUpdateFromDto() {
        SyllabusDto dto = createDto()
        syllabusService.updateFromDto(dto)
        verify(syllabusRepository, times(1)).findById(syllabus.id)
        verify(syllabusRepository, times(1)).save(any(Syllabus.class))
        verifyNoMoreInteractions(syllabusRepository)
    }
    
    //@Test
    public void testUpdateFromDto_withNoId() {
        SyllabusDto dto = createDto()
        dto.id = null
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create syllabusDto from null object.")
        syllabusService.updateFromDto(dto)
        verifyNoMoreInteractions(syllabusRepository)
    }
    
    //@Test
    public void testUpdateFromDto_withExamBoardId() {
        SyllabusDto dto = new SyllabusDto(id: 1, examSeriesId : 1, )
        dto.examSeriesId = 1
        when(examOptionService.findById(dto.examSeriesId)).thenReturn(null)
        syllabusService.updateFromDto(dto)
        verify(examSeriesService, times(1)).findById(dto.examSeriesId)
        verifyNoMoreInteractions(examSeriesService)
    }
    
    //@Test
    public void testDeleteId() {
        Syllabus result = syllabusService.deleteSyllabus(1)
        syllabusRepository.findById(1)
        result = new Syllabus(id:1)
        syllabusRepository.delete(result)
    }
    
}
