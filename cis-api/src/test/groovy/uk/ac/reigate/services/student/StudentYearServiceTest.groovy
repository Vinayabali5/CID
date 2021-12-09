package uk.ac.reigate.services.student;

import static org.junit.Assert.assertNotNull
import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.dto.StudentWarningDto
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.StudentYearRepository
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.AttendanceMonitoringService
import uk.ac.reigate.services.DestinationService
import uk.ac.reigate.services.PunctualityMonitoringService
import uk.ac.reigate.services.TutorGroupService
import uk.ac.reigate.services.lookup.StudentTypeService


public class StudentYearServiceTest {
    
    @Mock
    private StudentTypeService studentTypeService
    
    @Mock
    private TutorGroupService tutorGroupService
    
    @Mock
    private AcademicYearService academicYearService
    
    @Mock
    private StudentService studentService
    
    @Mock
    private StudentYearRepository studentYearRepository
    
    @Mock
    private AttendanceMonitoringService attendanceMonitoringService
    
    @Mock
    private PunctualityMonitoringService punctualityMonitoringService
    
    @Mock
    private DestinationService destinationService;
    
    @InjectMocks
    private StudentYearService studentYearService;
    
    private StudentYear studentYear
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    @Before
    public void setup() {
        studentYearRepository = mock(StudentYearRepository.class)
        studentYearService = new StudentYearService(studentYearRepository)
        
        // when(studentYearService.findByStudentAndYear(190001, 19)).thenReturn(new Optional(studentYear));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentYearService service = new StudentYearService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<StudentYear> result = studentYearService.findAll();
        verify(studentYearRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentYearRepository)
    }
    
    @Test
    public void testSave() {
        StudentYear savedStudentYear = studentYearService.save(studentYear);
        verify(studentYearRepository, times(1)).save(any())
        verifyNoMoreInteractions(studentYearRepository)
    }
    
    @Test
    public void testSaveList() {
        List<StudentYear> savedStudentYears = studentYearService.saveStudentYears([
            studentYear,
            studentYear
        ]);
        verify(studentYearRepository, times(2)).save(studentYear)
        verifyNoMoreInteractions(studentYearRepository)
    }
    
    @Test
    public void testGetByStudentAndYear() {
        StudentYear result = studentYearService.findByStudentAndYear(190001, 19);
        verify(studentYearRepository, times(1)).findByStudent_IdAndYear_Id(190001, 19)
        verifyNoMoreInteractions(studentYearRepository)
    }
    
    @Test
    public void testFindByStudent_IdAndYearr() {
        AcademicYear year = new AcademicYear(id:18)
        StudentYear result = studentYearService.findByStudent_IdAndYear(1, year);
        verify(studentYearRepository, times(1)).findByStudent_IdAndYear(1, year)
        verifyNoMoreInteractions(studentYearRepository)
    }
    
    @Test
    public void testFindByTutorGroupAndYear() {
        AcademicYear year = new AcademicYear(id:18)
        List<StudentYear> result = studentYearService.findByTutorGroupAndYear(1, year);
        verify(studentYearRepository, times(1)).findByTutorGroup_IdAndYear(1, year)
        verifyNoMoreInteractions(studentYearRepository)
    }
    
    @Test
    public void testFindByTutorGroupAndYearId() {
        List<StudentYear> result = studentYearService.findByTutorGroupAndYearId(1, 19);
        verify(studentYearRepository, times(1)).findByTutorGroup_IdAndYear_Id(1, 19)
        verifyNoMoreInteractions(studentYearRepository)
    }
    
    @Test
    public void testFindByTutorGroup() {
        List<StudentYear> result = studentYearService.findByTutorGroup(1);
        verify(studentYearRepository, times(1)).findByTutorGroup_Id(1)
        verifyNoMoreInteractions(studentYearRepository)
    }
    
    @Test
    public void testFindByStudent() {
        Student student = new Student(id:19001)
        List<StudentYear> result = studentYearService.findByStudent(student);
        verify(studentYearRepository, times(1)).findByStudent(student)
        verifyNoMoreInteractions(studentYearRepository)
    }
    
    @Test
    public void testUpdateTutorGroupNull() {
        thrown.expect(Exception.class)
        thrown.expectMessage("Could not locate the student/year combination")
        StudentYear studentYear = studentYearService.updateTutorGroup(190001, 19, 1)
        verify(studentYearRepository, times(1)).findByStudentAndYear(190001, 19)
    }
    
    
    @Test
    public void testUpdateStudentWarningNull() {
        thrown.expect(Exception.class)
        thrown.expectMessage("Could not locate the student/year combination");
        StudentWarningDto studentWarningDto = new StudentWarningDto(studentId: 190001, yearId:19)
        StudentYear studentYear = studentYearService.updateStudentWarning(studentWarningDto)
        verify(studentYearRepository, times(1)).findByStudentAndYear(190001, 19)
    }
    
    //@Test
    public void testUpdateStudentWarning() {
        StudentWarningDto studentWarningDto = new StudentWarningDto(studentId: 190001, yearId:19)
        studentYearService.updateStudentWarning(studentWarningDto)
        studentWarningDto.attendanceMonitoringId = 1
        when(studentYearService.findByStudentAndYear(190001, 19)).thenReturn(new StudentYear(student: new Student(id:190001), year: new AcademicYear(id: 1)))
        StudentYear studentYear = new StudentYear(student: new Student(id:190001), year: new AcademicYear(id: 1))
        
        when(attendanceMonitoringService.findById(studentWarningDto.attendanceMonitoringId)).thenReturn(null)
        verify(studentYearRepository, times(1)).save(any(StudentYear.class))
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        studentYearService.delete(studentYear)
        verifyNoMoreInteractions(studentYearRepository)
        assertThatExceptionOfType(InvalidOperationException.class)
    }
}
