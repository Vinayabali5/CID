package uk.ac.reigate.api.learningsupport

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc

import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.CourseService
import uk.ac.reigate.services.learningsupport.StudentCourseConcessionService
import uk.ac.reigate.services.lookup.ConcessionTypeService
import uk.ac.reigate.services.student.StudentService

//@RunWith(SpringRunner.class)
//@WebMvcTest(StudentCourseConcessionsApi.class)
class StudentCourseConcessionsApiTest {
    
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private AcademicYearService academicYearService;
    
    @MockBean
    private StudentCourseConcessionService studentCourseConcessionService
    
    @MockBean
    private StudentService studentService
    
    @MockBean
    private CourseService courseService
    
    @MockBean
    private ConcessionTypeService concessionTypeService
    
    //@Test
    public void testStudentCourseConcessions() throws Exception {
        this.mvc.perform(get("/students/0/course-concessions").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
    }
}
