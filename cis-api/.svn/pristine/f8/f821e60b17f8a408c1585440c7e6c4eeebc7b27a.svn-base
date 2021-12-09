package uk.ac.reigate.services.student;

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.register.StudentOverallAttendance
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.register.StudentOverallAttendanceRepository


public class StudentOverallAttendanceServiceTest {
    
    @Mock
    private StudentOverallAttendanceRepository studentOverallAttendanceRepository;
    
    @InjectMocks
    private StudentOverallAttendanceService studentOverallAttendanceService;
    
    private StudentOverallAttendance studentOverallAttendance
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    
    @Before
    public void setup() {
        studentOverallAttendanceRepository = mock(StudentOverallAttendanceRepository.class);
        
        studentOverallAttendanceService = new StudentOverallAttendanceService(studentOverallAttendanceRepository);
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentOverallAttendanceService service = new StudentOverallAttendanceService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<StudentOverallAttendance> result = studentOverallAttendanceService.findAll();
        verify(studentOverallAttendanceRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentOverallAttendanceRepository)
    }
    
    @Test
    public void testFindStudentOverallAttendanceByYear() {
        StudentOverallAttendance result = studentOverallAttendanceService.findStudentOverallAttendanceByYear(190001, 19);
        verify(studentOverallAttendanceRepository, times(1)).findByStudent_IdAndYear_Id(190001, 19)
        verifyNoMoreInteractions(studentOverallAttendanceRepository)
    }
    
    @Test
    public void testFindById() {
        StudentOverallAttendance result = studentOverallAttendanceService.findById(1);
    }
    
    @Test
    public void testSaveStudentOverallAttendance() {
        studentOverallAttendanceService.save(studentOverallAttendance);
        verify(studentOverallAttendanceRepository, times(1)).save(studentOverallAttendance)
        verifyNoMoreInteractions(studentOverallAttendanceRepository)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("StudentOverallAttendance should not be deleted")
        studentOverallAttendanceService.delete(studentOverallAttendance)
    }
}
