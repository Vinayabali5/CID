package uk.ac.reigate.services.exams.edi

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.edi.EdiAuditEntryLog
import uk.ac.reigate.domain.exams.edi.EdiAuditEntryLogPk
import uk.ac.reigate.domain.exams.edi.EdiAuditFileLog
import uk.ac.reigate.dto.exams.edi.EdiAuditEntryLogDto
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.exams.edi.EdiAuditEntryLogRepository

class EdiAudiEntryLogServiceTest {
    
    @Mock
    private EdiAuditEntryLogRepository ediAuditEntryLogRepository
    
    @InjectMocks
    private EdiAuditEntryLogService ediAuditEntryLogService
    
    private EdiAuditEntryLog ediAuditEntryLog
    
    private EdiAuditEntryLogPk ediAuditEntryLogPk
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    EdiAuditEntryLog createEdiAuditEntryLog() {
        return new EdiAuditEntryLog(
                student : new Student(id: 190001),
                examOption: new ExamOption(id: 1),
                ediAuditFileLog: new EdiAuditFileLog(id: 1)
                )
    }
    
    EdiAuditEntryLogDto createDto() {
        EdiAuditEntryLog sampleEdiAuditEntryLog = createEdiAuditEntryLog()
        return new EdiAuditEntryLogDto(
                studentId : sampleEdiAuditEntryLog.student.id,
                examOptionId : sampleEdiAuditEntryLog.examOption.id,
                ediAuditFileLogId : sampleEdiAuditEntryLog.ediAuditFileLog.id
                )
    }
    
    @Before
    public void setup() {
        ediAuditEntryLogRepository = mock(EdiAuditEntryLogRepository.class)
        
        ediAuditEntryLog = createEdiAuditEntryLog()
        
        ediAuditEntryLogService = new EdiAuditEntryLogService(ediAuditEntryLogRepository)
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        EdiAuditEntryLogService service = new EdiAuditEntryLogService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<EdiAuditEntryLog> result = ediAuditEntryLogService.findAll();
        verify(ediAuditEntryLogRepository, times(1)).findAll()
        verifyNoMoreInteractions(ediAuditEntryLogRepository)
    }
    
    @Test
    public void testFindById() {
        EdiAuditEntryLog result = ediAuditEntryLogService.findById(ediAuditEntryLogPk)
        verify(ediAuditEntryLogRepository, times(1)).findById(ediAuditEntryLogPk)
        verifyNoMoreInteractions(ediAuditEntryLogRepository)
    }
    
    @Test
    public void testGetByStudent() {
        EdiAuditEntryLog result = ediAuditEntryLogService.findByStudent(190001)
        verify(ediAuditEntryLogRepository, times(1)).findByStudent_Id(190001)
        verifyNoMoreInteractions(ediAuditEntryLogRepository)
    }
    
    @Test
    public void testSave() {
        EdiAuditEntryLogService result = ediAuditEntryLogService.save(ediAuditEntryLog)
        verify(ediAuditEntryLogRepository, times(1)).save(ediAuditEntryLog)
        verifyNoMoreInteractions(ediAuditEntryLogRepository)
    }
    
    
    @Test
    public void testFindByStudentAndOption() {
        EdiAuditEntryLog result = ediAuditEntryLogService.getByStudentAndYear(190001, '2020')
        verify(ediAuditEntryLogRepository, times(1)).findBystduent_IdAndExamOption(190001, '2020')
        verifyNoMoreInteractions(ediAuditEntryLogRepository)
    }
    
    @Test
    public void testFindByStudentAndExamOption() {
        Student student = new Student(id: 190001)
        ExamOption examOption = new ExamOption(id: 1)
        EdiAuditEntryLog result = ediAuditEntryLogService.findByStudentAndOption(student, examOption)
        ediAuditEntryLogService.findById(new EdiAuditEntryLogPk(student, examOption))
    }
    
    //@Test
    public void testFindByStudent() {
        Student student = new Student(id: 190001)
        EdiAuditEntryLog result = ediAuditEntryLogService.findByStudent(student)
        ediAuditEntryLogService.findById(new EdiAuditEntryLogPk(student))
    }
    
    @Test
    public void testGetByYear() {
        List<EdiAuditEntryLog> result = ediAuditEntryLogService.getByYear('2000')
        verify(ediAuditEntryLogRepository, times(1)).findByExamOption('2000')
        verifyNoMoreInteractions(ediAuditEntryLogRepository)
    }
    
    @Test
    public void testGetByOptionYearId() {
        List<EdiAuditEntryLog> result = ediAuditEntryLogService.getByStudentAndYear(19001, '2020')
        verify(ediAuditEntryLogRepository, times(1)).findBystduent_IdAndExamOption(19001, '2020')
        verifyNoMoreInteractions(ediAuditEntryLogRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("EdiAuditEntryLog should not be deleted")
        ediAuditEntryLogService.delete(ediAuditEntryLog)
        verifyNoMoreInteractions(ediAuditEntryLogService)
    }
}
