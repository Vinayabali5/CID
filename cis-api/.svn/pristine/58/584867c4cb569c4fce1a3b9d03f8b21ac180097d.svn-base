package uk.ac.reigate.services.attendance

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.attendance.StudentAttendance
import uk.ac.reigate.repositories.attendance.StudentAttendanceRepository
import uk.ac.reigate.services.AcademicYearService

@RunWith(MockitoJUnitRunner.class)
class StudentAttendanceServiceTest {
    
    @Mock
    private StudentAttendanceRepository studentAttendanceRepository
    
    @Mock
    private AcademicYearService academicYearService
    
    @InjectMocks
    private StudentAttendanceService studentAttendanceService
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    @Before
    public void setup() {
        studentAttendanceRepository = mock(StudentAttendanceRepository.class)
        academicYearService = mock(AcademicYearService.class)
        
        studentAttendanceService = new StudentAttendanceService(studentAttendanceRepository, academicYearService)
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentAttendanceService service = new StudentAttendanceService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindByStudentIdAndCourseId() {
        StudentAttendanceService result = studentAttendanceService.findByStudentIdAndCourseId(20001, 213)
        verify(studentAttendanceRepository, times(1)).findByStudentIdAndCourseId(20001, 213)
        verifyNoMoreInteractions(studentAttendanceRepository)
    }
    
    @Test
    public void testSearchByYearStudentIdAndCourseId() {
        AcademicYear academicYear = new AcademicYear(id: 18)
        StudentAttendanceService result = studentAttendanceService.searchByYearStudentIdAndCourseId(academicYear, 20001, 213, null, null)
        verify(studentAttendanceRepository, times(1)).findByAcademicYearStudentIdAndCourseIdForDateRange(academicYear, 20001, 213, null, null)
        verifyNoMoreInteractions(studentAttendanceRepository)
    }
    
    @Test
    public void testFindAll() {
        List<StudentAttendance> result = studentAttendanceService.findAll()
        verify(studentAttendanceRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentAttendanceRepository)
    }
}
