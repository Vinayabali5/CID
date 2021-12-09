package uk.ac.reigate.services.student;

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.learning_support.StudentLearningSupport
import uk.ac.reigate.dto.StudentLearningSupportDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.learning_support.StudentLearningSupportRepository
import uk.ac.reigate.services.lookup.SupportTypeService


public class StudentLearningSupportServiceTest {
    
    @Mock
    private StudentLearningSupportRepository studentLearningSupportRepository;
    
    @Mock
    private StudentService studentService;
    
    @Mock
    private SupportTypeService supportTypeService;
    
    @InjectMocks
    private StudentLearningSupportService studentLearningSupportService;
    
    private StudentLearningSupport studentLearningSupport
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    StudentLearningSupport createStudentLearningSupport() {
        return new StudentLearningSupport(
                id: 1,
                concessionApplication: true
                )
    }
    
    StudentLearningSupportDto createDto() {
        StudentLearningSupport sampleStudentLearningSupport = createStudentLearningSupport()
        return new StudentLearningSupportDto(
                studentId: sampleStudentLearningSupport.id,
                concessionApplication: sampleStudentLearningSupport.concessionApplication
                )
    }
    
    @Before
    public void setup() {
        studentLearningSupportRepository = mock(StudentLearningSupportRepository.class);
        studentService = mock(StudentService.class);
        supportTypeService = mock(SupportTypeService.class);
        
        studentLearningSupportService = new StudentLearningSupportService(studentLearningSupportRepository, studentService, supportTypeService);
        
        studentLearningSupport = createStudentLearningSupport()
        when(studentLearningSupportRepository.findById(1)).thenReturn(new Optional(new StudentLearningSupport()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentLearningSupportService service = new StudentLearningSupportService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<StudentLearningSupport> result = studentLearningSupportService.findAll();
        verify(studentLearningSupportRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentLearningSupportRepository)
    }
    
    @Test
    public void testGetByStudentId() {
        List<StudentLearningSupport> result = studentLearningSupportService.findByStudent(190001);
        verify(studentLearningSupportRepository, times(1)).findByStudent_Id(190001)
        verifyNoMoreInteractions(studentLearningSupportRepository)
    }
    
    //@Test
    public void testGetByStudent() {
        Student student = new Student(id:19001)
        List<StudentLearningSupport> result = studentLearningSupportService.findByStudent(student);
        verify(studentLearningSupportRepository, times(1)).findByStudent(student)
        verifyNoMoreInteractions(studentLearningSupportRepository)
    }
    
    @Test
    public void testFindStudentLearningSupport() {
        StudentLearningSupport result = studentLearningSupportService.findStudentLearningSupport(190001);
        verify(studentLearningSupportRepository, times(1)).findByStudent_Id(190001)
        verifyNoMoreInteractions(studentLearningSupportRepository)
    }
    
    @Test
    public void testFindById() {
        StudentLearningSupport result = studentLearningSupportService.findById(1);
    }
    
    @Test
    public void testSave() {
        studentLearningSupport.id = null
        studentLearningSupportService.save(studentLearningSupport);
        verify(studentLearningSupportRepository, times(1)).save(studentLearningSupport)
        verifyNoMoreInteractions(studentLearningSupportRepository)
    }
    
    @Test
    public void testSaveStudentLearningSupport() {
        studentLearningSupportService.save(studentLearningSupport);
        verify(studentLearningSupportRepository, times(1)).save(studentLearningSupport)
        verifyNoMoreInteractions(studentLearningSupportRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        StudentLearningSupportDto dto = createDto()
        studentLearningSupportService.createFromDto(dto)
        verify(studentLearningSupportRepository, times(1)).save(any(StudentLearningSupport.class))
        verifyNoMoreInteractions(studentLearningSupportRepository)
    }
    
    
    @Test
    public void testCreateFromDto_dtoWithStudentId() {
        StudentLearningSupportDto dto = createDto()
        dto.studentId = 1
        when(studentService.findById(dto.studentId)).thenReturn(null);
        studentLearningSupportService.createFromDto(dto)
        verify(studentLearningSupportRepository, times(1)).save(any(StudentLearningSupport.class))
        verifyNoMoreInteractions(studentLearningSupportRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithEntryQualificationId() {
        StudentLearningSupportDto dto = createDto()
        dto.supportTypeId = 1
        when(supportTypeService.findById(dto.supportTypeId)).thenReturn(null);
        studentLearningSupportService.createFromDto(dto)
        verify(studentLearningSupportRepository, times(1)).save(any(StudentLearningSupport.class))
        verifyNoMoreInteractions(studentLearningSupportRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithEntryQualificationId() {
        StudentLearningSupportDto dto = createDto()
        dto.supportTypeId = 1
        when(supportTypeService.findById(dto.supportTypeId)).thenReturn(null);
        studentLearningSupportService.updateFromDto(dto)
        verify(supportTypeService, times(1)).findById(dto.supportTypeId)
        verifyNoMoreInteractions(supportTypeService)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create studentLearningSupportDto from null object.")
        StudentLearningSupportDto dto = createDto()
        dto.studentId = null
        studentLearningSupportService.createFromDto(dto)
        verifyNoMoreInteractions(studentLearningSupportRepository)
    }
    
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update studentLearningSupportDto from null object.")
        StudentLearningSupportDto dto = createDto()
        dto.studentId = null
        studentLearningSupportService.updateFromDto(dto)
        verifyNoMoreInteractions(studentLearningSupportRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithStudentId() {
        StudentLearningSupportDto dto = createDto()
        dto.studentId = 1
        when(studentService.findById(dto.studentId)).thenReturn(null);
        // Initialise Test
        studentLearningSupportService.updateFromDto(dto)
        // Verify Results
        verify(studentService, times(1)).findById(dto.studentId)
        verifyNoMoreInteractions(studentService)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("StudentLearningSupport should not be deleted")
        studentLearningSupportService.delete(studentLearningSupport)
    }
}
