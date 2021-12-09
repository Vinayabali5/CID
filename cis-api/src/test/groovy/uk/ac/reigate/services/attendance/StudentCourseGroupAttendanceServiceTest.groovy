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
import uk.ac.reigate.domain.attendance.StudentCourseGroupAttendance
import uk.ac.reigate.repositories.attendance.StudentCourseGroupAttendanceRepository
import uk.ac.reigate.services.AcademicYearService

class StudentCourseGroupAttendanceServiceTest {
    
    @Mock
    StudentCourseGroupAttendanceRepository studentCourseGroupAttendanceRepository
    
    @Mock
    private AcademicYearService academicYearService
    
    @InjectMocks
    private StudentCourseGroupAttendanceService studentCourseGroupAttendanceService
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    @Before
    public void setup() {
        studentCourseGroupAttendanceRepository = mock(StudentCourseGroupAttendanceRepository.class)
        academicYearService = mock(AcademicYearService.class)
        
        studentCourseGroupAttendanceService = new StudentCourseGroupAttendanceService(studentCourseGroupAttendanceRepository, academicYearService)
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentCourseGroupAttendanceService service = new StudentCourseGroupAttendanceService();
        assertNotNull(service)
    }
    
    //@Test
    public void testFindByStudentIdAndCourseId() {
        StudentCourseGroupAttendanceService result = studentCourseGroupAttendanceService.findByStudentIdAndCourseId(20001, 213)
        verify(studentCourseGroupAttendanceRepository, times(1)).findByStudentIdAndCourseId(20001, 213)
        verifyNoMoreInteractions(studentCourseGroupAttendanceRepository)
    }
    
    //@Test
    public void testSearchByYearStudentIdAndCourseId() {
        AcademicYear academicYear = new AcademicYear(id: 18)
        StudentCourseGroupAttendanceService result = studentCourseGroupAttendanceService.searchByYearStudentIdAndCourseId(academicYear, 20001, 213, null, null)
        verify(studentCourseGroupAttendanceRepository, times(1)).findByAcademicYearStudentIdAndCourseGroupIdForDateRange(academicYear, 20001, 213, null, null)
        verifyNoMoreInteractions(studentCourseGroupAttendanceRepository)
    }
    
    //@Test
    public void testFindAll() {
        List<StudentCourseGroupAttendance> result = studentCourseGroupAttendanceService.findAll()
        verify(studentCourseGroupAttendanceRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentCourseGroupAttendanceRepository)
    }
}
