package uk.ac.reigate.services.learningsupport;

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.learning_support.StudentCourseConcession
import uk.ac.reigate.dto.learningsupport.StudentCourseConcessionDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.learning_support.StudentCourseConcessionRepository
import uk.ac.reigate.services.CourseService
import uk.ac.reigate.services.lookup.ConcessionTypeService
import uk.ac.reigate.services.student.StudentService


public class StudentCourseConcessionServiceTest {
    
    @Mock
    private StudentCourseConcessionRepository studentCourseConcessionRepository;
    
    @Mock
    private CourseService courseService
    
    @Mock
    private ConcessionTypeService concessionTypeService
    
    @Mock
    private StudentService studentService
    
    @InjectMocks
    private StudentCourseConcessionService studentCourseConcessionService;
    
    private StudentCourseConcession studentCourseConcession
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    StudentCourseConcession createStudentCourseConcession() {
        return new StudentCourseConcession(
                id: 1,
                extraTimePercentage: 1
                )
    }
    
    StudentCourseConcessionDto createDto() {
        StudentCourseConcession sampleStudentCourseConcession = createStudentCourseConcession()
        return new StudentCourseConcessionDto(
                studentCourseConcessionId: sampleStudentCourseConcession.id,
                extraTimePercentage: sampleStudentCourseConcession.extraTimePercentage
                )
    }
    
    @Before
    public void setup() {
        studentCourseConcessionRepository = mock(StudentCourseConcessionRepository.class);
        courseService = mock(CourseService.class);
        concessionTypeService = mock(ConcessionTypeService.class);
        studentService = mock(StudentService.class);
        
        studentCourseConcessionService = new StudentCourseConcessionService(studentCourseConcessionRepository, courseService, concessionTypeService, studentService);
        
        studentCourseConcession = createStudentCourseConcession()
        when(studentCourseConcessionRepository.findById(1)).thenReturn(new Optional(new StudentCourseConcession()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentCourseConcessionService service = new StudentCourseConcessionService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<StudentCourseConcession> result = studentCourseConcessionService.findAll();
        verify(studentCourseConcessionRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentCourseConcessionRepository)
    }
    
    @Test
    public void testFindById() {
        StudentCourseConcession result = studentCourseConcessionService.findById(1);
        verify(studentCourseConcessionRepository, times(1)).findById(1)
        verifyNoMoreInteractions(studentCourseConcessionRepository)
    }
    
    @Test
    public void testSave() {
        studentCourseConcession.id = null
        studentCourseConcessionService.save(studentCourseConcession);
        verify(studentCourseConcessionRepository, times(1)).save(studentCourseConcession)
        verifyNoMoreInteractions(studentCourseConcessionRepository)
    }
    
    
    @Test
    public void testSaveStudentCourseConcession() {
        studentCourseConcessionService.save(studentCourseConcession);
        verify(studentCourseConcessionRepository, times(1)).save(studentCourseConcession)
        verifyNoMoreInteractions(studentCourseConcessionRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        StudentCourseConcessionDto dto = new StudentCourseConcessionDto(studentCourseConcessionId: 1, extraTimePercentage: 1)
        studentCourseConcessionService.createFromDto(dto)
        verify(studentCourseConcessionRepository, times(1)).save(any(StudentCourseConcession.class))
        verifyNoMoreInteractions(studentCourseConcessionRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoStudentId() {
        StudentCourseConcessionDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        studentCourseConcessionService.createFromDto(dto)
        verify(studentCourseConcessionRepository, times(1)).save(any(StudentCourseConcession.class))
        verifyNoMoreInteractions(studentCourseConcessionRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoCourseId() {
        StudentCourseConcessionDto dto = createDto()
        dto.courseId = 19001
        when(courseService.findById(dto.courseId)).thenReturn(null);
        studentCourseConcessionService.createFromDto(dto)
        verify(studentCourseConcessionRepository, times(1)).save(any(StudentCourseConcession.class))
        verifyNoMoreInteractions(studentCourseConcessionRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoconcessionTypeId() {
        StudentCourseConcessionDto dto = createDto()
        dto.concessionTypeId = 19001
        when(courseService.findById(dto.concessionTypeId)).thenReturn(null);
        studentCourseConcessionService.createFromDto(dto)
        verify(studentCourseConcessionRepository, times(1)).save(any(StudentCourseConcession.class))
        verifyNoMoreInteractions(studentCourseConcessionRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create StudentCourseConcession from null object.")
        StudentCourseConcessionDto dto = null
        studentCourseConcessionService.createFromDto(dto)
        verifyNoMoreInteractions(studentCourseConcessionRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update StudentCourseConcession from null object.")
        StudentCourseConcessionDto dto = null
        studentCourseConcessionService.updateFromDto(dto)
    }
    
    @Test
    public void testUpdateFromDto_dtoStudentId() {
        StudentCourseConcessionDto dto = createDto()
        dto.studentId = 190001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        studentCourseConcessionService.updateFromDto(dto)
    }
    
    @Test
    public void testUpdateFromDto_dtoCourseId() {
        StudentCourseConcessionDto dto = createDto()
        dto.courseId = 1
        when(courseService.findById(dto.courseId)).thenReturn(null);
        studentCourseConcessionService.updateFromDto(dto)
        verify(courseService, times(1)).findById(dto.courseId)
        verifyNoMoreInteractions(courseService)
    }
    
    @Test
    public void testUpdateFromDto_dtoconcessionTypeId() {
        StudentCourseConcessionDto dto = createDto()
        dto.concessionTypeId = 19001
        when(concessionTypeService.findById(dto.concessionTypeId)).thenReturn(null);
        studentCourseConcessionService.updateFromDto(dto)
        verify(concessionTypeService, times(1)).findById(dto.concessionTypeId)
        verifyNoMoreInteractions(concessionTypeService)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        studentCourseConcessionService.delete(studentCourseConcession)
        verify(studentCourseConcessionRepository, times(1)).delete(studentCourseConcession)
        verifyNoMoreInteractions(studentCourseConcessionRepository)
    }
    
    @Test
    public void testDeleteId() {
        studentCourseConcessionService.deleteById(1)
        verify(studentCourseConcessionRepository, times(1)).deleteById(1)
        verifyNoMoreInteractions(studentCourseConcessionRepository)
    }
    
    @Test
    public void testGetByStudent() {
        Student student = new Student(id:19001)
        List<StudentCourseConcession> result = studentCourseConcessionService.getByStudent(student);
        verify(studentCourseConcessionRepository, times(1)).findByStudent(student)
        verifyNoMoreInteractions(studentCourseConcessionRepository)
    }
    
    @Test
    public void testGetByStudentAndCourse() {
        Student student = new Student(id:19001)
        Course course = new Course(id:1)
        List<StudentCourseConcession> result = studentCourseConcessionService.getByStudentAndCourse(student, course);
        verify(studentCourseConcessionRepository, times(1)).findByStudentAndCourse(student, course)
        verifyNoMoreInteractions(studentCourseConcessionRepository)
    }
    
    @Test
    public void testGetByStudentAndCourseList() {
        Student student = new Student(id:19001)
        List<Course> courses = [new Course(id:1)]
        List<StudentCourseConcession> result = studentCourseConcessionService.getByStudentAndCourseList(student, courses);
        List<StudentCourseConcession> concessions = new ArrayList<StudentCourseConcession>()
        courses.each { course ->
            concessions.addAll(studentCourseConcessionRepository.findByStudentAndCourse(student, course))
        }
    }
    
    @Test
    public void testGetByStudentId() {
        List<StudentCourseConcession> result = studentCourseConcessionService.getByStudentId(19001);
        verify(studentCourseConcessionRepository, times(1)).findByStudentId(19001)
        verifyNoMoreInteractions(studentCourseConcessionRepository)
    }
}
