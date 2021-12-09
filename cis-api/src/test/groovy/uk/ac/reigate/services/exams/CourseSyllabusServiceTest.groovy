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
import uk.ac.reigate.domain.exams.CourseSyllabus
import uk.ac.reigate.domain.exams.CourseSyllabusPk
import uk.ac.reigate.domain.exams.basedata.Syllabus
import uk.ac.reigate.dto.exams.CourseSyllabusDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.exams.CourseSyllabusRepository
import uk.ac.reigate.services.CourseService
import uk.ac.reigate.services.exams.basedata.SyllabusService

class CourseSyllabusServiceTest {
    
    @Mock
    private CourseSyllabusRepository courseSyllabusRepository
    
    @Mock
    private CourseService courseService
    
    @Mock
    private SyllabusService syllabusService
    
    private CourseSyllabusPk courseSyllabusPk
    
    private CourseSyllabus courseSyllabus
    
    @InjectMocks
    private CourseSyllabusService courseSyllabusService
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    Course createCourse() {
        return new Course(
                id: 1,
                glh: 155,
                learningAimReference: 'CMISC001',
                syllabusCode: 'NA',
                locationPostcode: 'RH2 0SD',
                subjectSectorArea: '12.1',
                courseSummary: 'This is a sample course',
                published: false,
                publishedTitle: 'Sample Course',
                notes: 'Sample notes'
                )
    }
    
    CourseSyllabus createCourseSyllabus() {
        return new CourseSyllabus(
                course: createCourse(),
                syllabus : new Syllabus(id: 1)
                )
    }
    
    CourseSyllabusDto createDto() {
        CourseSyllabus sampleCourseSyllabus = createCourseSyllabus();
        return new CourseSyllabusDto(
                courseId: sampleCourseSyllabus.course.id,
                syllabusId: sampleCourseSyllabus.syllabus.id
                )
    }
    
    @Before
    public void setup() {
        this.courseSyllabusRepository = mock(CourseSyllabusRepository.class)
        this.courseService = mock(CourseService.class)
        this.syllabusService = mock(SyllabusService.class)
        this.courseSyllabusService = new CourseSyllabusService(courseSyllabusRepository, courseService, syllabusService)
    }
    
    @Test
    public void testNoArgsConstructor() {
        CourseSyllabusService service = new CourseSyllabusService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindCourseSyllabus() {
        CourseSyllabusService result = courseSyllabusService.findCourseSyllabus(1, 2)
        CourseSyllabusPk courseSyllabusPk = new CourseSyllabusPk(1, 2)
        verify(courseSyllabusRepository, times(1)).findById(courseSyllabusPk)
        verifyNoMoreInteractions(courseSyllabusRepository)
    }
    
    @Test
    public void testFindById() {
        CourseSyllabusService result = courseSyllabusService.findById(courseSyllabusPk)
        verify(courseSyllabusRepository, times(1)).findById(courseSyllabusPk)
        verifyNoMoreInteractions(courseSyllabusRepository)
    }
    
    @Test
    public void testFindAll() {
        List<CourseSyllabusService> result = courseSyllabusService.findAll()
        verify(courseSyllabusRepository, times(1)).findAll()
        verifyNoMoreInteractions(courseSyllabusRepository)
    }
    
    @Test
    public void testSave() {
        CourseSyllabusService result = courseSyllabusService.save(courseSyllabus)
        verify(courseSyllabusRepository, times(1)).save(courseSyllabus)
        verifyNoMoreInteractions(courseSyllabusRepository)
    }
    
    @Test
    public void testDelete() {
        CourseSyllabusService result = courseSyllabusService.delete(courseSyllabus)
        verify(courseSyllabusRepository, times(1)).delete(courseSyllabus)
        verifyNoMoreInteractions(courseSyllabusRepository)
    }
    
    @Test
    public void testDeleteByIds() {
        Boolean result = courseSyllabusService.deleteByIds(1, 2)
        CourseSyllabus courseSyllabus = courseSyllabusRepository.findByCourse_IdAndSyllabus_Id(1, 2)
        courseSyllabus != null
        courseSyllabusService.delete(courseSyllabus)
    }
    
    @Test
    public void testDeleteByCourseAndSyllabus() {
        Course course = new Course(id: 1)
        Syllabus syllabus = new Syllabus(id:1 )
        Boolean result = courseSyllabusService.deleteByCourseAndSyllabus(course, syllabus)
        courseSyllabusService.deleteByIds(1, 1)
    }
    
    @Test
    public void testCreateFromDto() {
        CourseSyllabusDto dto = createDto()
        courseSyllabusService.createFromDto(dto)
        verify(courseSyllabusRepository, times(1)).save(any(CourseSyllabus.class))
        verifyNoMoreInteractions(courseSyllabusRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create courseSyllabusDto from null object.")
        CourseSyllabusDto dto = null
        courseSyllabusService.createFromDto(dto)
        verifyNoMoreInteractions(courseSyllabusRepository)
    }
}
