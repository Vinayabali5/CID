package uk.ac.reigate.services.exams.basedata

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.basedata.ExamSeries
import uk.ac.reigate.domain.exams.basedata.Syllabus
import uk.ac.reigate.dto.exams.basedata.ExamOptionDto
import uk.ac.reigate.dto.exams.basedata.ExamSeriesDto
import uk.ac.reigate.dto.exams.basedata.SyllabusSummaryDto
import uk.ac.reigate.repositories.exams.basedata.ExamOptionRepository
import uk.ac.reigate.services.exams.edi.ExamTypeService

class ExamOptionServiceTest {
    
    @Mock
    ExamOptionRepository examOptionRepository
    
    @Mock
    ExamTypeService examTypeService
    
    @Mock
    SyllabusService syllabusService
    
    @Mock
    ExamSeriesService examSeriesService
    
    @InjectMocks
    ExamOptionService examOptionService
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    private ExamOption examOption
    
    ExamOption createExamOption() {
        return new ExamOption(
                id: 1,
                optionEntryCode: 'test12',
                syllabus : new Syllabus(),
                examTypeQualificationCert : 'test',
                examTypeLevelCert : 'AQA',
                examTypeItem : '1',
                examTypeQualificationUnit: 'Math',
                examTypeLevelUnit: 'AQA',
                process : '1',
                qcaClassificationCode: 'Test',
                qcaAccreditationNo: '12121212',
                optionTitle: 'AQA',
                feeDefined: '1',
                examinationFee : 1
                )
    }
    
    ExamOptionDto createDto() {
        ExamOption sampleExamOption = createExamOption();
        return new ExamOptionDto(
                id: sampleExamOption.id,
                optionEntryCode: sampleExamOption.optionEntryCode,
                syllabusId : sampleExamOption.syllabus.id,
                examTypeQualificationCert : sampleExamOption.examTypeQualificationCert,
                examTypeLevelCert: sampleExamOption.examTypeLevelCert,
                examTypeItem : sampleExamOption.examTypeItem,
                examTypeQualificationUnit : sampleExamOption.examTypeQualificationUnit,
                examTypeLevelUnit: sampleExamOption.examTypeLevelUnit,
                process: sampleExamOption.process,
                qcaClassificationCode: sampleExamOption.qcaClassificationCode,
                optionTitle: sampleExamOption.optionTitle,
                feeDefined : sampleExamOption.feeDefined,
                examinationFee : sampleExamOption.examinationFee
                )
    }
    
    @Before
    public void setup() {
        examOptionRepository = mock(ExamOptionRepository.class);
        examTypeService = mock(ExamTypeService.class);
        syllabusService = mock(SyllabusService.class);
        examSeriesService = mock(ExamSeriesService.class)
        
        examOptionService = new ExamOptionService(examOptionRepository, examTypeService, syllabusService, examSeriesService)
        examOption = createExamOption()
        when(examOptionRepository.findById(examOption.id)).thenReturn(new Optional(new ExamOption()))
        //when(examOptionRepository.findBySyllabus(examOption.syllabus)).thenReturn(null)
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        ExamOptionService service = new ExamOptionService()
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<ExamOption> result = examOptionService.findAll()
        verify(examOptionRepository, times(1)).findAll()
        verifyNoMoreInteractions(examOptionRepository)
    }
    
    @Test
    public void testFindById() {
        ExamOption result = examOptionService.findById(1)
        verify(examOptionRepository, times(1)).findById(1)
        verifyNoMoreInteractions(examOptionRepository)
    }
    
    @Test
    public void testSearchByOptionEntryCode() {
        List<ExamOption> result = examOptionService.searchByOptionEntryCode('test')
        verify(examOptionRepository, times(1)).findByOptionEntryCodeContaining('test')
        verifyNoMoreInteractions(examOptionRepository)
    }
    
    @Test
    public void testFindExamOption() {
        List<ExamOption> result = examOptionService.findExamOptions(1)
        Syllabus syllabus = new Syllabus()
        syllabus.id = 1
        examOptionRepository.findBySyllabus(syllabus)
    }
    
    @Test
    public void testSave() {
        examOptionService.save(examOption)
        verify(examOptionRepository, times(1)).save(examOption)
        verifyNoMoreInteractions(examOptionRepository)
    }
    
    @Test
    public void testDelete() {
        examOptionService.delete(examOption)
    }
    
    @Test
    public void testDeleteExamOption() {
        examOptionService.deleteExamOption(1)
        ExamOption deleteExamOption = examOptionService.findById(1)
        examOptionService.delete(examOption)
    }
    
    @Test
    public void testFindByOptionEntryCode() {
        ExamOption result = examOptionService.findByOptionEntryCode('AQA')
        verify(examOptionRepository, times(1)).findByOptionEntryCode('AQA')
        verifyNoMoreInteractions(examOptionRepository)
    }
    
    @Test
    public void testFindByExamSeries() {
        ExamSeries examSeries = new ExamSeries(id: 1)
        Syllabus syllabus = new Syllabus(id: 1)
        String entryCode = 'test'
        ExamOption result = examOptionService.findByExamSeriesAndSyllabusAndCode(examSeries, syllabus, entryCode)
        verify(examOptionRepository, times(1)).findBySyllabus_ExamSeriesAndSyllabusAndOptionEntryCode(examSeries, syllabus, entryCode)
        verifyNoMoreInteractions(examOptionRepository)
    }
    
    @Test
    public void testFindByExamSeriesAndCode() {
        ExamSeries examSeries = new ExamSeries(id : 1)
        String entryCode = 'test'
        ExamOption result = examOptionService.findByExamSeriesAndCode(examSeries, entryCode)
        verify(examOptionRepository, times(1)).findBySyllabus_ExamSeriesAndOptionEntryCode(examSeries, entryCode)
        verifyNoMoreInteractions(examOptionRepository)
    }
    
    @Test
    public void testFindByOptionEntryCodeAndExamSeries() {
        ExamSeries examSeries = new ExamSeries(id: 1)
        List<ExamOption> result = examOptionService.findByOptionEntryCodeAndExamSeries('AQA', examSeries)
        verify(examOptionRepository, times(1)).findByOptionEntryCode('AQA').find(){
            it.syllabus.examSeries = examSeries
        }
        verifyNoMoreInteractions(examOptionRepository)
    }
    
    @Test
    public void testCreateFromDto() {
        ExamOptionDto dto = createDto()
        examOptionService.createFromDto(dto)
        verify(examOptionRepository, times(1)).save(any(ExamOption.class))
        verifyNoMoreInteractions(examOptionRepository)
    }
    
    @Test
    public void testCreateFromDto_withSyllabusId() {
        ExamOptionDto dto = createDto()
        dto.syllabus = new SyllabusSummaryDto(id:1 )
        dto.syllabus.id = 1
        when(syllabusService.findById(dto.syllabus.id)).thenReturn(null);
        examOptionService.createFromDto(dto)
        verify(examOptionRepository, times(1)).save(any(ExamOption.class))
        verifyNoMoreInteractions(examOptionRepository)
    }
    
    @Test
    public void testCreateFromDto_withSyllabusNullId() {
        ExamOptionDto dto = createDto()
        dto.syllabus = new SyllabusSummaryDto()
        dto.syllabus.code = 'AQA'
        dto.syllabus.examSeries = new ExamSeriesDto(id:1)
        when(syllabusService.findByEntryCodeAndExamSeries('AQA', examSeriesService.findById(dto.syllabus.examSeries.id))).thenReturn(null);
        examOptionService.createFromDto(dto)
        verify(examOptionRepository, times(1)).save(any(ExamOption.class))
        verifyNoMoreInteractions(examOptionRepository)
    }
    
    @Test
    public void testCreateFromDto_withSyllabusNullCode() {
        ExamOptionDto dto = createDto()
        dto.syllabus = new SyllabusSummaryDto()
        dto.syllabus.id = null
        dto.syllabus.code = null
        examOptionService.createFromDto(dto)
        verify(examOptionRepository, times(1)).save(any(ExamOption.class))
        verifyNoMoreInteractions(examOptionRepository)
    }
    
    
    @Test
    public void testUpdateFromDto_withNullSyllabusCode() {
        ExamOptionDto dto = createDto()
        dto.syllabus = new SyllabusSummaryDto()
        dto.syllabus.id = null
        dto.syllabus.code = null
        examOptionService.updateFromDto(dto)
        verify(examOptionRepository, times(1)).findById(examOption.id)
        verify(examOptionRepository, times(1)).save(any(ExamOption.class))
        verifyNoMoreInteractions(examOptionRepository)
    }
    
    
    @Test
    public void testCreateFromDto_WithExamTypeCertId() {
        ExamOptionDto dto = createDto()
        dto.examTypeCertId = 1
        when(examTypeService.findById(dto.examTypeCertId)).thenReturn(null);
        examOptionService.createFromDto(dto)
        verify(examOptionRepository, times(1)).save(any(ExamOption.class))
        verifyNoMoreInteractions(examOptionRepository)
    }
    
    @Test
    public void testCreateFromDto_WithExamTypeUnitId() {
        ExamOptionDto dto = createDto()
        dto.examTypeUnitId = 1
        when(examTypeService.findById(dto.examTypeUnitId)).thenReturn(null);
        examOptionService.createFromDto(dto)
        verify(examOptionRepository, times(1)).save(any(ExamOption.class))
        verifyNoMoreInteractions(examOptionRepository)
    }
    
    @Test
    public void testUpdateFromDto() {
        ExamOptionDto dto = createDto()
        examOptionService.updateFromDto(dto)
        verify(examOptionRepository, times(1)).findById(examOption.id)
        verify(examOptionRepository, times(1)).save(any(ExamOption.class))
        verifyNoMoreInteractions(examOptionRepository)
    }
    
    @Test
    public void testUpdateFromDto_withDto() {
        ExamOptionDto dto = createDto()
        examOptionService.updateFromDto(dto)
        verify(examOptionRepository, times(1)).findById(examOption.id)
        verify(examOptionRepository, times(1)).save(any(ExamOption.class))
        verifyNoMoreInteractions(examOptionRepository)
    }
    
    @Test
    public void testUpdateFromDto_withExamTypeCertId() {
        ExamOptionDto dto = createDto()
        dto.examTypeCertId = 1
        when(examTypeService.findById(dto.examTypeCertId)).thenReturn(null);
        examOptionService.updateFromDto(dto)
        verify(examTypeService, times(1)).findById(dto.examTypeCertId)
        verifyNoMoreInteractions(examTypeService)
    }
    
    @Test
    public void testUpdateFromDto_withExamTypeUnitId() {
        ExamOptionDto dto = createDto()
        dto.examTypeUnitId = 1
        when(examTypeService.findById(dto.examTypeUnitId)).thenReturn(null);
        examOptionService.updateFromDto(dto)
        verify(examTypeService, times(1)).findById(dto.examTypeUnitId)
        verifyNoMoreInteractions(examTypeService)
    }
    
    @Test
    public void testUpdateFromDto_withSyllabus() {
        ExamOptionDto dto = createDto()
        dto.syllabus = new SyllabusSummaryDto(id: 1)
        dto.syllabus.id = 1
        when(syllabusService.findById(1)).thenReturn(null);
        examOptionService.updateFromDto(dto)
        verify(syllabusService, times(1)).findById(dto.syllabus.id)
        verifyNoMoreInteractions(syllabusService)
    }
    
    @Test
    public void testUpdateFromDto_withSyllabusNullId() {
        ExamOptionDto dto = createDto()
        dto.syllabus = new SyllabusSummaryDto()
        //dto.syllabus.id = null
        dto.syllabus.code = 'AQA'
        dto.syllabus.examSeries = new ExamSeriesDto(id: 1)
        when(syllabusService.findByEntryCodeAndExamSeries('AQA', examSeriesService.findById(dto.syllabus.examSeries.id))).thenReturn(null);
        examOptionService.updateFromDto(dto)
        verify(syllabusService, times(1)).findByEntryCodeAndExamSeries('AQA', examSeriesService.findById(1))
        verifyNoMoreInteractions(syllabusService)
    }
}
