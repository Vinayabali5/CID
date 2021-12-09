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
import uk.ac.reigate.domain.exams.CourseOption
import uk.ac.reigate.domain.exams.CourseOptionPk
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.dto.exams.CourseOptionDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.predicates.CourseOptionPredicates
import uk.ac.reigate.repositories.exams.CourseOptionRepository
import uk.ac.reigate.services.CourseService
import uk.ac.reigate.services.exams.basedata.ExamOptionService
import uk.ac.reigate.services.exams.basedata.ExamSeriesService

class CourseOptionServiceTest {
    
    @Mock
    private CourseOptionRepository courseOptionRepository
    
    @Mock
    private CourseService courseService
    
    @Mock
    private ExamOptionService examOptionService
    
    @Mock
    private ExamSeriesService examSeriesService
    
    private CourseOption courseOption
    
    private CourseOptionPk courseOptionPk
    
    @InjectMocks
    private CourseOptionService courseOptionService
    
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
    
    CourseOption createCourseOption() {
        return new CourseOption(
                course: createCourse(),
                examOption : new ExamOption(id:1 ),
                lowerEntry: true,
                upperEntry : true,
                intermediateEntry: true
                )
    }
    
    CourseOptionDto createDto() {
        CourseOption sampleCourseOption = createCourseOption();
        return new CourseOptionDto(
                courseId: sampleCourseOption.course.id,
                examOptionId: sampleCourseOption.examOption.id,
                lowerEntry: sampleCourseOption.lowerEntry,
                upperEntry: sampleCourseOption.upperEntry,
                intermediateEntry: sampleCourseOption.intermediateEntry
                )
    }
    
    @Before
    public void setup() {
        this.courseOptionRepository = mock(CourseOptionRepository.class)
        this.courseService = mock(CourseService.class)
        this.examOptionService = mock(ExamOptionService.class)
        this.examSeriesService = mock(ExamSeriesService.class)
        this.courseOptionService = new CourseOptionService(courseOptionRepository, courseService, examOptionService, examSeriesService)
        
        courseOption = createCourseOption()
        when(courseOptionService.findCourseOption(courseOption.course.id, courseOption.examOption.id)).thenReturn(new Optional(new CourseOption()));
    }
    
    @Test
    public void testNoArgsConstructor() {
        CourseOptionService service = new CourseOptionService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindCourseOption() {
        CourseOptionService result = courseOptionService.findCourseOption(1, 2)
        CourseOptionPk courseOptionPk = new CourseOptionPk(1, 2)
        verify(courseOptionRepository, times(1)).findById(courseOptionPk)
        verifyNoMoreInteractions(courseOptionRepository)
    }
    
    @Test
    public void testFindAll() {
        List<CourseOptionService> result = courseOptionService.findAll()
        verify(courseOptionRepository, times(1)).findAll()
        verifyNoMoreInteractions(courseOptionRepository)
    }
    
    @Test
    public void testFindById() {
        CourseOptionService result = courseOptionService.findById(courseOptionPk)
        verify(courseOptionRepository, times(1)).findById(courseOptionPk)
        verifyNoMoreInteractions(courseOptionRepository)
    }
    
    @Test
    public void testSave() {
        CourseOptionService result = courseOptionService.save(courseOption)
        verify(courseOptionRepository, times(1)).save(courseOption)
        verifyNoMoreInteractions(courseOptionRepository)
    }
    
    @Test
    public void testCourseExamOptions() {
        List<CourseOptionService> result = courseOptionService.findCourseExamOptions(1)
        courseOptionRepository.findByCourseId(1).collect {
            examOptionService.findById(it.examOption.id)
        }
        verifyNoMoreInteractions(examOptionService)
    }
    
    @Test
    public void testFindCourseExamOptions() {
        List<CourseOptionService> result = courseOptionService.findCourseExamOptions(1, 2)
        List<CourseOption> courseOptions = courseOptionRepository.findAll(CourseOptionPredicates.courseAndYear(1, 2))
        courseOptions.collect {
            examOptionService.findById(it.examOption.id)
        }
        verifyNoMoreInteractions(examOptionService)
    }
    
    @Test
    public void testDelete() {
        CourseOptionService result = courseOptionService.delete(courseOption)
        verify(courseOptionRepository, times(1)).delete(courseOption)
        verifyNoMoreInteractions(courseOptionRepository)
    }
    
    @Test
    public void testDeleteByIds() {
        Boolean result = courseOptionService.deleteByIds(1, 2)
        CourseOption courseOption = courseOptionRepository.findByCourse_IdAndExamOptionId(1, 2)
        courseOption != null
        courseOptionService.delete(courseOption)
    }
    
    @Test
    public void testDeleteByCourseAndExamOption() {
        Course course = new Course(id: 1)
        ExamOption examOption = new ExamOption(id:1 )
        Boolean result = courseOptionService.deleteByCourseAndExamOption(course, examOption)
        courseOptionService.deleteByIds(1, 1)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create courseOptionDto from null object.")
        CourseOptionDto dto = null
        courseOptionService.createFromDto(dto)
        verifyNoMoreInteractions(courseOptionRepository)
    }
    
    @Test
    public void testCreateFromDto() {
        CourseOptionDto dto = createDto()
        courseOptionService.createFromDto(dto)
        verify(courseOptionRepository, times(1)).save(any(CourseOption.class))
        verifyNoMoreInteractions(courseOptionRepository)
    }
    
    @Test
    public void testCreateFromDto_withCourseId() {
        // Stub Data and Method Returns
        CourseOptionDto dto = createDto()
        dto.courseId = 1
        when(courseService.findById(dto.courseId)).thenReturn(null);
        // Initialise Test
        courseOptionService.createFromDto(dto)
        // Verify Results
        verify(courseOptionRepository, times(1)).save(any(CourseOption.class))
        verifyNoMoreInteractions(courseOptionRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullCourseId() {
        // Stub Data and Method Returns
        CourseOptionDto dto = createDto()
        dto.courseId = null
        // Initialise Test
        courseOptionService.createFromDto(dto)
        // Verify Results
        verify(courseOptionRepository, times(1)).save(any(CourseOption.class))
        verifyNoMoreInteractions(courseOptionRepository)
    }
    
    @Test
    public void testCreateFromDto_withExamOptionId() {
        // Stub Data and Method Returns
        CourseOptionDto dto = createDto()
        dto.examOptionId = 1
        when(examOptionService.findById(dto.examOptionId)).thenReturn(null);
        // Initialise Test
        courseOptionService.createFromDto(dto)
        // Verify Results
        verify(courseOptionRepository, times(1)).save(any(CourseOption.class))
        verifyNoMoreInteractions(courseOptionRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullExamOptionId() {
        // Stub Data and Method Returns
        CourseOptionDto dto = createDto()
        dto.examOptionId = null
        // Initialise Test
        courseOptionService.createFromDto(dto)
        // Verify Results
        verify(courseOptionRepository, times(1)).save(any(CourseOption.class))
        verifyNoMoreInteractions(courseOptionRepository)
    }
    
    @Test
    public void testUpdateFromDto_withDto() {
        CourseOptionDto dto = createDto()
        courseOptionService.updateFromDto(dto)
        when(courseOptionService.findCourseOption(dto.courseId, dto.examOptionId)).thenReturn(null);
        verify(courseOptionRepository, times(1)).save(any(CourseOption.class))
    }
    
    @Test
    public void testUpdateFromDto_withDtoWithNoId() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update courseOptionDto from null object.");
        // Initialise Test
        CourseOptionDto dto = null
        courseOptionService.updateFromDto(dto)
        // Verify Results
        verifyNoMoreInteractions(courseOptionRepository)
    }
}
