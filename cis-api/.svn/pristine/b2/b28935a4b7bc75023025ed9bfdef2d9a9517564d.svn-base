package uk.ac.reigate.services.exams

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.StudentOptionEntry
import uk.ac.reigate.domain.exams.StudentOptionEntryPk
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.edi.EdiStatusType
import uk.ac.reigate.domain.exams.edi.StatusType
import uk.ac.reigate.dto.exams.StudentOptionEntryDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.exams.StudentOptionEntryRepository
import uk.ac.reigate.services.EdiStatusTypeService
import uk.ac.reigate.services.exams.basedata.ExamOptionService
import uk.ac.reigate.services.lookup.StatusTypeService
import uk.ac.reigate.services.student.StudentService

class StudentOptionEntryServiceTest {
    
    @Mock
    private StudentOptionEntryRepository studentOptionEntryRepository
    
    @Mock
    private StudentService studentService
    
    @Mock
    private StatusTypeService statusTypeService
    
    @Mock
    private EdiStatusTypeService ediStatusTypeService
    
    @Mock
    private ExamOptionService examOptionService
    
    @InjectMocks
    private StudentOptionEntryService studentOptionEntryService
    
    private StudentOptionEntry studentOptionEntry
    
    private StudentOptionEntryPk studentOptionEntryPk
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    StudentOptionEntry createStudentOptionEntry() {
        return new StudentOptionEntry(
                student : new Student(id: 190001),
                examOption: new ExamOption(id: 1),
                statusType: new StatusType(),
                ediStatusType : new EdiStatusType(),
                resit: true,
                privateStudent: true
                )
    }
    
    StudentOptionEntryDto createDto() {
        StudentOptionEntry sampleStudentOptionEntry = createStudentOptionEntry()
        return new StudentOptionEntryDto(
                studentId : sampleStudentOptionEntry.student.id,
                examOptionId : sampleStudentOptionEntry.examOption.id,
                statusTypeId : sampleStudentOptionEntry.statusType.id,
                ediStatusTypeId: sampleStudentOptionEntry.ediStatusType.id,
                resit: true,
                privateStudent: true
                )
    }
    
    @Before
    public void setup() {
        studentOptionEntryRepository = mock(StudentOptionEntryRepository.class)
        studentService = mock(StudentService.class)
        statusTypeService = mock(StatusTypeService.class)
        ediStatusTypeService = mock(EdiStatusTypeService.class)
        examOptionService = mock(ExamOptionService.class)
        
        studentOptionEntry = createStudentOptionEntry()
        
        studentOptionEntryService = new StudentOptionEntryService(studentOptionEntryRepository, studentService, statusTypeService, ediStatusTypeService, examOptionService)
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        StudentOptionEntryService service = new StudentOptionEntryService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<StudentOptionEntry> result = studentOptionEntryService.findAll();
        verify(studentOptionEntryRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentOptionEntryRepository)
    }
    
    @Test
    public void testFindById() {
        StudentOptionEntry result = studentOptionEntryService.findById(studentOptionEntryPk)
        verify(studentOptionEntryRepository, times(1)).findById(studentOptionEntryPk)
        verifyNoMoreInteractions(studentOptionEntryRepository)
    }
    
    @Test
    public void testGetByStudent() {
        StudentOptionEntry result = studentOptionEntryService.getByStudent(190001)
        verify(studentOptionEntryRepository, times(1)).findByStudent_Id(190001)
        verifyNoMoreInteractions(studentOptionEntryRepository)
    }
    
    @Test
    public void testSave() {
        StudentOptionEntryService result = studentOptionEntryService.save(studentOptionEntry)
        verify(studentOptionEntryRepository, times(1)).save(studentOptionEntry)
        verifyNoMoreInteractions(studentOptionEntryRepository)
    }
    
    @Test
    public void testDeleteById() {
        Boolean result = studentOptionEntryService.deleteById(1, 2)
        studentOptionEntryRepository.deleteById(new StudentOptionEntryPk(1, 2))
    }
    
    @Test
    public void testFindByStudentAndOption() {
        StudentOptionEntry result = studentOptionEntryService.findByStudentAndOption(190001, 1)
        verify(studentOptionEntryRepository, times(1)).findByStudent_IdAndExamOption_Id(190001, 1)
        verifyNoMoreInteractions(studentOptionEntryRepository)
    }
    
    @Test
    public void testFindByStudentAndExamOption() {
        Student student = new Student(id: 190001)
        ExamOption examOption = new ExamOption(id: 1)
        StudentOptionEntry result = studentOptionEntryService.findByStudentAndExamOption(student, examOption)
        studentOptionEntryService.findById(new StudentOptionEntryPk(student, examOption))
    }
    
    @Test
    public void testGetByComponentId() {
        List<StudentOptionEntry> result = studentOptionEntryService.getByComponentId(1)
        verify(studentOptionEntryRepository, times(1)).findByExamOption_OptionComponents_ExamComponentId(1)
        verifyNoMoreInteractions(studentOptionEntryRepository)
    }
    
    @Test
    public void testGetByComponentIdAndLive() {
        List<StudentOptionEntry> result = studentOptionEntryService.getByComponentIdAndLive(1)
        verify(studentOptionEntryRepository, times(1)).findByExamOption_OptionComponents_ExamComponentIdAndStatusType_Id(1, 1)
        verifyNoMoreInteractions(studentOptionEntryRepository)
    }
    
    @Test
    public void testGetByOptionYearId() {
        StudentOptionEntry result = studentOptionEntryService.getByOptionYearId(1, 190001)
        verify(studentOptionEntryRepository, times(1)).findByOptionYearIdAndStudentId(1, 190001)
        verifyNoMoreInteractions(studentOptionEntryRepository)
    }
    
    @Test
    public void testDeleteByStudentAndExamOption() {
        Student student = new Student(id: 190001)
        ExamOption examOption = new ExamOption(id: 1)
        Boolean result = studentOptionEntryService.deleteByStudentAndExamOption(student, examOption)
        studentOptionEntryService.deleteById(190001, 1)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create a studentOptionEntry with a null object.")
        StudentOptionEntryDto dto = null
        studentOptionEntryService.createFromDto(dto)
        verifyNoMoreInteractions(studentOptionEntryRepository)
    }
    
    @Test
    public void testCreateFromDto() {
        StudentOptionEntryDto dto = createDto()
        studentOptionEntryService.createFromDto(dto)
        verify(studentOptionEntryRepository, times(1)).save(any(StudentOptionEntry.class))
        verifyNoMoreInteractions(studentOptionEntryRepository)
    }
    
    @Test
    public void testCreateFromDtoStatusType() {
        StudentOptionEntryDto dto = createDto()
        dto.statusTypeId = 1
        when(statusTypeService.findById(dto.statusTypeId)).thenReturn(null)
        studentOptionEntryService.createFromDto(dto)
        verify(studentOptionEntryRepository, times(1)).save(any(StudentOptionEntry.class))
        verifyNoMoreInteractions(studentOptionEntryRepository)
    }
    
    @Test
    public void testCreateFromDtoEdiStatusType() {
        StudentOptionEntryDto dto = createDto()
        dto.ediStatusTypeId = 1
        when(ediStatusTypeService.findById(dto.ediStatusTypeId)).thenReturn(null)
        studentOptionEntryService.createFromDto(dto)
        verify(studentOptionEntryRepository, times(1)).save(any(StudentOptionEntry.class))
        verifyNoMoreInteractions(studentOptionEntryRepository)
    }
}
