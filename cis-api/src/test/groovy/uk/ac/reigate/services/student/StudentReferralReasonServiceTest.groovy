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
import uk.ac.reigate.domain.learning_support.StudentReferralReason
import uk.ac.reigate.dto.StudentReferralReasonDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.learning_support.StudentReferralReasonRepository
import uk.ac.reigate.services.ReferralReasonService


public class StudentReferralReasonServiceTest {
    
    @Mock
    private StudentReferralReasonRepository studentReferralReasonRepository;
    
    @Mock
    private StudentService studentService;
    
    @Mock
    private ReferralReasonService referralReasonService;
    
    @InjectMocks
    private StudentReferralReasonService studentReferralReasonService;
    
    private StudentReferralReason studentReferralReason
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    StudentReferralReason createStudentReferralReason() {
        return new StudentReferralReason(
                id: 1,
                primary: true
                )
    }
    
    StudentReferralReasonDto createDto() {
        StudentReferralReason sampleStudentReferralReason = createStudentReferralReason()
        return new StudentReferralReasonDto(
                id: sampleStudentReferralReason.id,
                primary: sampleStudentReferralReason.primary
                )
    }
    
    @Before
    public void setup() {
        studentReferralReasonRepository = mock(StudentReferralReasonRepository.class);
        studentService = mock(StudentService.class);
        referralReasonService = mock(ReferralReasonService.class);
        
        studentReferralReasonService = new StudentReferralReasonService(studentReferralReasonRepository, studentService, referralReasonService);
        
        studentReferralReason = createStudentReferralReason()
        when(studentReferralReasonRepository.findById(1)).thenReturn(new Optional(new StudentReferralReason()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentReferralReasonService service = new StudentReferralReasonService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<StudentReferralReason> result = studentReferralReasonService.findAll();
        verify(studentReferralReasonRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentReferralReasonRepository)
    }
    
    @Test
    public void testGetByStudent() {
        List<StudentReferralReason> result = studentReferralReasonService.getByStudentId(190001);
        verify(studentReferralReasonRepository, times(1)).findByStudent_Id(190001)
        verifyNoMoreInteractions(studentReferralReasonRepository)
    }
    
    @Test
    public void testFindStudentReferralReason() {
        Student student = new Student(id:190001)
        List<StudentReferralReason> result = studentReferralReasonService.getByStudent(student);
        verify(studentReferralReasonRepository, times(1)).findByStudent(student)
        verifyNoMoreInteractions(studentReferralReasonRepository)
    }
    
    @Test
    public void testFindById() {
        StudentReferralReason result = studentReferralReasonService.findById(1);
        verify(studentReferralReasonRepository, times(1)).findById(1)
        verifyNoMoreInteractions(studentReferralReasonRepository)
    }
    
    @Test
    public void testSave() {
        studentReferralReason.id = null
        studentReferralReasonService.save(studentReferralReason);
        verify(studentReferralReasonRepository, times(1)).save(studentReferralReason)
        verifyNoMoreInteractions(studentReferralReasonRepository)
    }
    
    @Test
    public void testSaveStudentReferralReason() {
        studentReferralReasonService.save(studentReferralReason);
        verify(studentReferralReasonRepository, times(1)).save(studentReferralReason)
        verifyNoMoreInteractions(studentReferralReasonRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        StudentReferralReasonDto dto = createDto()
        studentReferralReasonService.createFromDto(dto)
        verify(studentReferralReasonRepository, times(1)).save(any(StudentReferralReason.class))
        verifyNoMoreInteractions(studentReferralReasonRepository)
    }
    
    
    @Test
    public void testCreateFromDto_dtoWithStudentId() {
        StudentReferralReasonDto dto = createDto()
        dto.studentId = 1
        when(studentService.findById(dto.studentId)).thenReturn(null);
        studentReferralReasonService.createFromDto(dto)
        verify(studentReferralReasonRepository, times(1)).save(any(StudentReferralReason.class))
        verifyNoMoreInteractions(studentReferralReasonRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithEntryQualificationId() {
        StudentReferralReasonDto dto = createDto()
        dto.referralReasonId = 1
        when(referralReasonService.findById(dto.referralReasonId)).thenReturn(null);
        studentReferralReasonService.createFromDto(dto)
        verify(studentReferralReasonRepository, times(1)).save(any(StudentReferralReason.class))
        verifyNoMoreInteractions(studentReferralReasonRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithReferralReasonId() {
        StudentReferralReasonDto dto = createDto()
        dto.referralReasonId = 1
        when(referralReasonService.findById(dto.referralReasonId)).thenReturn(null);
        studentReferralReasonService.updateFromDto(dto)
        verify(referralReasonService, times(1)).findById(dto.referralReasonId)
        verifyNoMoreInteractions(referralReasonService)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create studentReferralReasonDto from null object.")
        StudentReferralReasonDto dto = null
        studentReferralReasonService.createFromDto(dto)
        verifyNoMoreInteractions(studentReferralReasonRepository)
    }
    
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update studentReferralReasonDto from null object.")
        StudentReferralReasonDto dto = null
        studentReferralReasonService.updateFromDto(dto)
        verifyNoMoreInteractions(studentReferralReasonRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithStudentId() {
        StudentReferralReasonDto dto = createDto()
        dto.studentId = 1
        when(studentService.findById(dto.studentId)).thenReturn(null);
        // Initialise Test
        studentReferralReasonService.updateFromDto(dto)
        // Verify Results
        verify(studentService, times(1)).findById(dto.studentId)
        verifyNoMoreInteractions(studentService)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        studentReferralReasonService.delete(studentReferralReason)
        verify(studentReferralReasonRepository, times(1)).delete(studentReferralReason)
        verifyNoMoreInteractions(studentReferralReasonRepository)
    }
    
    @Test
    public void testDeleteId() {
        studentReferralReasonService.delete(studentReferralReason.id)
        verify(studentReferralReasonRepository, times(1)).deleteById(studentReferralReason.id)
        verifyNoMoreInteractions(studentReferralReasonRepository)
    }
}
