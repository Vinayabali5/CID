package uk.ac.reigate.services.student;

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.lookup.BursaryTypeService


public class StudentBursaryServiceTest {
    
    @Mock
    private StudentYearService studentYearService
    
    @Autowired
    AcademicYearService academicYearService
    
    @Autowired
    StudentService studentService
    
    @Autowired
    BursaryTypeService bursaryTypeService;
    
    @InjectMocks
    private StudentBursaryService studentBursaryService;
    
    private StudentYear studentYear
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    @Before
    public void setup() {
        studentYearService = mock(StudentYearService.class);
        
        studentBursaryService = new StudentBursaryService(studentYearService);
        
        // when(studentYearService.findByStudentAndYear(studentService.findById(190001), academicYearService.findById(19))).thenReturn(new Optional(new StudentYear(student:new Student(id:190001), year:new AcademicYear(id:19))))
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentBursaryService service = new StudentBursaryService();
        assertNotNull(service)
    }
    
    //@Test
    public void testUpdateStudentBursary() {
        StudentYear service = studentBursaryService.updateStudentBursary(190001, 19, true, true, true, true, 1, true)
        when(studentYearService.findByStudentAndYear(studentService.findById(190001), academicYearService.findById(19))).thenReturn(new StudentYear(student:new Student(id:190001), year:new AcademicYear(id:19)))
    }
}


