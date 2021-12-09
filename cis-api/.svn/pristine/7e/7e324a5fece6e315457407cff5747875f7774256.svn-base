package uk.ac.reigate.services.exams

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.exams.CourseComponent
import uk.ac.reigate.domain.exams.CourseComponentPk
import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.repositories.exams.CourseComponentRepository

class CourseComponentServiceTest {
    
    @Mock
    private CourseComponentRepository courseComponentRepository
    
    @InjectMocks
    private CourseComponentService courseComponentService
    
    private CourseComponentPk courseComponentPk
    
    private CourseComponent courseComponent
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Before
    public void setup() {
        this.courseComponentRepository = mock(CourseComponentRepository.class)
        this.courseComponentService = new CourseComponentService(courseComponentRepository);
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        CourseComponentService service = new CourseComponentService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<CourseComponentService> result = courseComponentService.findAll()
        verify(courseComponentRepository, times(1)).findAll()
        verifyNoMoreInteractions(courseComponentRepository)
    }
    
    @Test
    public void testFindById() {
        CourseComponentService result = courseComponentService.findById(courseComponentPk)
        verify(courseComponentRepository, times(1)).findById(courseComponentPk)
        verifyNoMoreInteractions(courseComponentRepository)
    }
    
    @Test
    public void testFindCourseComponent() {
        CourseComponentService result = courseComponentService.findCourseComponent(1, 2, 3)
        CourseComponentPk courseComponentPk = new CourseComponentPk(1, 2, 3)
        verify(courseComponentRepository, times(1)).findById(courseComponentPk)
        verifyNoMoreInteractions(courseComponentRepository)
    }
    
    @Test
    public void testSave() {
        CourseComponentService result = courseComponentService.save(courseComponent)
        verify(courseComponentRepository, times(1)).save(courseComponent)
        verifyNoMoreInteractions(courseComponentRepository)
    }
    
    @Test
    public void testDelete() {
        CourseComponentService result = courseComponentService.delete(courseComponent)
        verify(courseComponentRepository, times(1)).delete(courseComponent)
        verifyNoMoreInteractions(courseComponentRepository)
    }
    
    @Test
    public void testDeleteByIds() {
        Boolean result = courseComponentService.deleteByIds(1, 2, 3)
        CourseComponent courseComponent = courseComponentRepository.findByCourse_IdAndExamOption_IdAndExamComponent_Id(1, 2, 3)
        courseComponent != null
        courseComponentService.delete(courseComponent)
    }
}


