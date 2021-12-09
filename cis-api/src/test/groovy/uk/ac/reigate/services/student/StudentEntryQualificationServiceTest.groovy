package uk.ac.reigate.services.student;

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.StudentEntryQualification
import uk.ac.reigate.dto.StudentEntryQualificationDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.academic.StudentEntryQualificationRepository;
import uk.ac.reigate.services.EntryQualificationService
import uk.ac.reigate.services.exams.ExamBoardService


public class StudentEntryQualificationServiceTest {
    
    @Mock
    private StudentEntryQualificationRepository studentEntryQualificationRepository;
    
    @Mock
    private StudentService studentService;
    
    @Mock
    private EntryQualificationService entryQualificationService;
    
    @Mock
    private ExamBoardService examBoardService;
    
    @InjectMocks
    private StudentEntryQualificationService studentEntryQualificationService;
    
    private StudentEntryQualification studentEntryQualification
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    StudentEntryQualification createStudentEntryQualification() {
        return new StudentEntryQualification(
                id: 1,
                grade: 'A'
                )
    }
    
    StudentEntryQualificationDto createDto() {
        StudentEntryQualification sampleStudentEntryQualification = createStudentEntryQualification()
        return new StudentEntryQualificationDto(
                studentEntryQualificationId: sampleStudentEntryQualification.id,
                grade: sampleStudentEntryQualification.grade
                )
    }
    
    @Before
    public void setup() {
        studentEntryQualificationRepository = mock(StudentEntryQualificationRepository.class);
        studentService = mock(StudentService.class);
        entryQualificationService = mock(EntryQualificationService.class);
        examBoardService = mock(ExamBoardService.class)
        
        studentEntryQualificationService = new StudentEntryQualificationService(studentEntryQualificationRepository, studentService, entryQualificationService, examBoardService);
        
        studentEntryQualification = createStudentEntryQualification()
        when(studentEntryQualificationRepository.findById(1)).thenReturn(new Optional(new StudentEntryQualification()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentEntryQualificationService service = new StudentEntryQualificationService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<StudentEntryQualification> result = studentEntryQualificationService.findAll();
        verify(studentEntryQualificationRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentEntryQualificationRepository)
    }
    
    @Test
    public void testGetByStudent() {
        List<StudentEntryQualification> result = studentEntryQualificationService.getByStudent(190001);
        verify(studentEntryQualificationRepository, times(1)).findByStudent_Id(190001)
        verifyNoMoreInteractions(studentEntryQualificationRepository)
    }
    
    @Test
    public void testFindById() {
        StudentEntryQualification result = studentEntryQualificationService.findById(1);
        verify(studentEntryQualificationRepository, times(1)).findById(1)
        verifyNoMoreInteractions(studentEntryQualificationRepository)
    }
    
    @Test
    public void testGetByStudentEntryQualifications() {
        List<StudentEntryQualification> result = studentEntryQualificationService.getByStudentEntryQualifications(190001, 1);
        verify(studentEntryQualificationRepository, times(1)).findByStudent_IdAndId(190001, 1)
        verifyNoMoreInteractions(studentEntryQualificationRepository)
    }
    
    @Test
    public void testSave() {
        studentEntryQualification.id = null
        studentEntryQualificationService.save(studentEntryQualification);
        verify(studentEntryQualificationRepository, times(1)).save(studentEntryQualification)
        verifyNoMoreInteractions(studentEntryQualificationRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<StudentEntryQualification> savedStudentEntryQualifications = studentEntryQualificationService.saveStudentEntryQualifications([
            studentEntryQualification,
            studentEntryQualification
        ]);
        verify(studentEntryQualificationRepository, times(2)).save(studentEntryQualification)
        verifyNoMoreInteractions(studentEntryQualificationRepository)
    }
    
    @Test
    public void testSaveStudentEntryQualification() {
        studentEntryQualificationService.save(studentEntryQualification);
        verify(studentEntryQualificationRepository, times(1)).save(studentEntryQualification)
        verifyNoMoreInteractions(studentEntryQualificationRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        StudentEntryQualificationDto dto = new StudentEntryQualificationDto(studentEntryQualificationId: 1, grade: '123')
        studentEntryQualificationService.createFromDto(dto)
        verify(studentEntryQualificationRepository, times(1)).save(any(StudentEntryQualification.class))
        verifyNoMoreInteractions(studentEntryQualificationRepository)
    }
    
    
    @Test
    public void testCreateFromDto_dtoWithStudentId() {
        StudentEntryQualificationDto dto = createDto()
        dto.studentId = 1
        when(studentService.findById(dto.studentId)).thenReturn(null);
        studentEntryQualificationService.createFromDto(dto)
        verify(studentEntryQualificationRepository, times(1)).save(any(StudentEntryQualification.class))
        verifyNoMoreInteractions(studentEntryQualificationRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithEntryQualificationId() {
        StudentEntryQualificationDto dto = createDto()
        dto.entryQualificationId = 1
        when(entryQualificationService.findById(dto.entryQualificationId)).thenReturn(null);
        studentEntryQualificationService.createFromDto(dto)
        verify(studentEntryQualificationRepository, times(1)).save(any(StudentEntryQualification.class))
        verifyNoMoreInteractions(studentEntryQualificationRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithDate() {
        StudentEntryQualificationDto dto = createDto()
        dto.date = new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09')
        dto.checked = true
        studentEntryQualificationService.createFromDto(dto)
        verify(studentEntryQualificationRepository, times(1)).save(any(StudentEntryQualification.class))
        verifyNoMoreInteractions(studentEntryQualificationRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithExamBoardId() {
        StudentEntryQualificationDto dto = createDto()
        dto.examBoardId = 1
        when(examBoardService.findById(dto.examBoardId)).thenReturn(null);
        studentEntryQualificationService.createFromDto(dto)
        verify(studentEntryQualificationRepository, times(1)).save(any(StudentEntryQualification.class))
        verifyNoMoreInteractions(studentEntryQualificationRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithEntryQualificationId() {
        StudentEntryQualificationDto dto = createDto()
        dto.entryQualificationId = 1
        when(entryQualificationService.findById(dto.entryQualificationId)).thenReturn(null);
        studentEntryQualificationService.updateFromDto(dto)
        verify(entryQualificationService, times(1)).findById(dto.entryQualificationId)
        verifyNoMoreInteractions(entryQualificationService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithDate() {
        StudentEntryQualificationDto dto = createDto()
        dto.date = new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09')
        dto.checked = true
        studentEntryQualificationService.updateFromDto(dto)
        verify(studentEntryQualificationRepository, times(1)).findById(dto.studentEntryQualificationId)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithExamBoardId() {
        StudentEntryQualificationDto dto = createDto()
        dto.examBoardId = 1
        when(examBoardService.findById(dto.examBoardId)).thenReturn(null);
        studentEntryQualificationService.updateFromDto(dto)
        verify(examBoardService, times(1)).findById(dto.examBoardId)
        verifyNoMoreInteractions(examBoardService)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create studentEntryQualificationDto from null object.")
        StudentEntryQualificationDto dto = null
        studentEntryQualificationService.createFromDto(dto)
        verifyNoMoreInteractions(studentEntryQualificationRepository)
    }
    
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update studentEntryQualificationDto from null object.")
        StudentEntryQualificationDto dto = null
        studentEntryQualificationService.updateFromDto(dto)
        verifyNoMoreInteractions(studentEntryQualificationRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithStudentId() {
        StudentEntryQualificationDto dto = createDto()
        dto.studentId = 1
        when(studentService.findById(dto.studentId)).thenReturn(null);
        // Initialise Test
        studentEntryQualificationService.updateFromDto(dto)
        // Verify Results
        verify(studentService, times(1)).findById(dto.studentId)
        verifyNoMoreInteractions(studentService)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        studentEntryQualificationService.delete(studentEntryQualification)
        verifyNoMoreInteractions(studentEntryQualificationRepository)
    }
    
    @Test
    public void testDeleteById() {
        studentEntryQualificationService.delete(1)
        verify(studentEntryQualificationRepository, times(1)).deleteById(1)
        verifyNoMoreInteractions(studentEntryQualificationRepository)
    }
}
