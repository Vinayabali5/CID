package uk.ac.reigate.services

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.dto.CourseDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.predicates.CoursePredicates
import uk.ac.reigate.repositories.academic.CourseRepository;
import uk.ac.reigate.services.exams.ExamBoardService

@RunWith(MockitoJUnitRunner.class)
class CourseServiceTest {
    
    @Mock
    private CourseRepository courseRepository;
    
    @Mock
    private LevelService levelService;
    
    @Mock
    private SubjectService subjectService;
    
    @Mock
    private ExamBoardService examBoardService;
    
    @Mock
    private AcademicYearService academicYearService;
    
    @InjectMocks
    private CourseService courseService;
    
    private Course course
    
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
    
    CourseDto createDto() {
        Course sampleCourse = createCourse();
        return new CourseDto(
                id: sampleCourse.id,
                glh: sampleCourse.glh,
                learningAimReference: sampleCourse.learningAimReference,
                syllabusCode: sampleCourse.syllabusCode,
                locationPostcode: sampleCourse.locationPostcode,
                subjectSectorArea: sampleCourse.subjectSectorArea,
                notes: sampleCourse.notes,
                courseSummary: sampleCourse.courseSummary,
                published: sampleCourse.published,
                publishedTitle: sampleCourse.publishedTitle
                )
    }
    
    @Before
    public void setup() {
        courseRepository = mock(CourseRepository.class);
        levelService = mock(LevelService.class);
        subjectService = mock(SubjectService.class);
        examBoardService = mock(ExamBoardService.class);
        academicYearService = mock(AcademicYearService.class);
        
        courseService = new CourseService(courseRepository, levelService, subjectService, examBoardService, academicYearService);
        
        course = createCourse()
        
        when(courseRepository.findById(course.id)).thenReturn(new Optional(new Course()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        CourseService service = new CourseService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<Course> result = courseService.findAll();
        verify(courseRepository, times(1)).findAll()
        verifyNoMoreInteractions(courseRepository)
    }
    
    @Test
    public void testFindById() {
        Course result = courseService.findById(1);
        verify(courseRepository, times(1)).findById(1)
        verifyNoMoreInteractions(courseRepository)
    }
    
    @Test
    public void testGetByAcademicYear() {
        AcademicYear academicYear = new AcademicYear(id:1, code:'19', description: '2019', startDate: null, endDate: null, startYear: 2017 )
        Course result = courseService.getByAcademicYear(academicYear);
        verify(courseRepository, times(1)).findByValidFrom(academicYear)
        verifyNoMoreInteractions(courseRepository)
    }
    
    @Test
    public void testFindByStudent() {
        Student student = new Student(id: 19001)
        List<Course> result = courseService.findByStudent(student);
        verify(courseRepository, times(1)).findByStudent(student)
        verifyNoMoreInteractions(courseRepository)
    }
    
    @Test
    public void testFindAllCoursesValidInYears() {
        List<Course> result = courseService.findAllCoursesValidInYear(18);
        verify(courseRepository, times(1)).findAll(CoursePredicates.courseValidInYear(18))
        verifyNoMoreInteractions(courseRepository)
    }
    
    @Test
    public void testFindAllPublishedCoursesValidInYear() {
        List<Course> result = courseService.findAllPublishedCoursesValidInYear(18);
        verify(courseRepository, times(1)).findAll(CoursePredicates.coursePublishedAndValidInYear(18))
        verifyNoMoreInteractions(courseRepository)
    }
    
    @Test
    public void testSearchByYear() {
        AcademicYear academicYear = new AcademicYear(id:1, code:'19', description: '2019', startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'), endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'), startYear: 2017 )
        List<Course> result = courseService.searchByYear(academicYear);
        verify(courseRepository, times(1)).findCourseValidOnYear(academicYear.id)
        verifyNoMoreInteractions(courseRepository)
    }
    
    @Test
    public void testSearchByYearAndSpec() {
        AcademicYear academicYear = new AcademicYear(id:1, code:'19', description: '2019', startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'), endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'), startYear: 2017 )
        String string = 'Test'
        List<Course> result = courseService.searchByYearAndSpec(academicYear, string);
        verify(courseRepository, times(1)).findByValidFromAndSpecLike(academicYear, string)
        verifyNoMoreInteractions(courseRepository)
    }
    
    @Test
    public void testFindAllCoursesValidInYear() {
        List<Course> result = courseService.getCourseByYearId(19);
        verify(courseRepository, times(1)).findCourseValidOnYear(19)
        verifyNoMoreInteractions(courseRepository)
    }
    
    @Test
    public void testgetCourseByIdAndYearId() {
        Course result = courseService.getCourseByIdAndYearId(4, 19);
        verify(courseRepository, times(1)).findCourseByIDAndValidFrom(4, 19)
        verifyNoMoreInteractions(courseRepository)
    }
    
    @Test
    public void testSave() {
        course.id = null
        courseService.save(course);
        verify(courseRepository, times(1)).save(course)
        verifyNoMoreInteractions(courseRepository)
    }
    
    /**
     * This method is used to test the saveAll service method
     */
    @Test
    public void testSaveCourses() {
        List<Course> savedCourses = courseService.saveCourses([
            new Course(id: 1),
            new Course(id: 2)
        ])
        verify(courseRepository, times(2)).save(any(Course.class))
        verifyNoMoreInteractions(courseRepository)
    }
    
    @Test
    public void testSaveCourse() {
        courseService.save(course);
        verify(courseRepository, times(1)).save(course)
        verifyNoMoreInteractions(courseRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create Course from null object.")
        CourseDto dto = null
        courseService.createFromDto(dto)
        verifyNoMoreInteractions(courseRepository)
    }
    
    @Test
    public void testCreateFromDto_withDto() {
        CourseDto dto = createDto()
        courseService.createFromDto(dto)
        verify(courseRepository, times(1)).save(any(Course.class))
        verifyNoMoreInteractions(courseRepository)
    }
    
    @Test
    public void testCreateFromDto_withLevelId() {
        // Stub Data and Method Returns
        CourseDto dto = createDto()
        dto.levelId = 1
        when(levelService.findById(dto.levelId)).thenReturn(null);
        // Initialise Test
        courseService.createFromDto(dto)
        // Verify Results
        verify(courseRepository, times(1)).save(any(Course.class))
        verifyNoMoreInteractions(courseRepository)
    }
    
    @Test
    public void testCreateFromDto_withSubjectId() {
        // Stub Data and Method Returns
        CourseDto dto = createDto()
        dto.subjectId = 1
        when(subjectService.findById(dto.subjectId)).thenReturn(null);
        // Initialise Test
        courseService.createFromDto(dto)
        // Verify Results
        verify(courseRepository, times(1)).save(any(Course.class))
        verifyNoMoreInteractions(courseRepository)
    }
    
    @Test
    public void testCreateFromDto_withExamBoardId() {
        // Stub Data and Method Returns
        CourseDto dto = createDto()
        dto.examBoardId = 1
        when(examBoardService.findById(dto.examBoardId)).thenReturn(null);
        // Initialise Test
        courseService.createFromDto(dto)
        // Verify Results
        verify(courseRepository, times(1)).save(any(Course.class))
        verifyNoMoreInteractions(courseRepository)
    }
    
    @Test
    public void testCreateFromDto_withValidFromId() {
        // Stub Data and Method Returns
        CourseDto dto = createDto()
        dto.validFromId = 1
        when(academicYearService.findById(dto.validFromId)).thenReturn(null);
        // Initialise Test
        courseService.createFromDto(dto)
        // Verify Results
        verify(courseRepository, times(1)).save(any(Course.class))
        verifyNoMoreInteractions(courseRepository)
    }
    
    @Test
    public void testCreateFromDto_withValidToId() {
        // Stub Data and Method Returns
        CourseDto dto = createDto()
        dto.validToId = 1
        when(academicYearService.findById(dto.validToId)).thenReturn(null);
        // Initialise Test
        courseService.createFromDto(dto)
        // Verify Results
        verify(courseRepository, times(1)).save(any(Course.class))
        verifyNoMoreInteractions(courseRepository)
    }
    
    @Test
    public void testUpdateFromDto_withDto() {
        CourseDto dto = createDto()
        courseService.updateFromDto(dto)
        verify(courseRepository, times(1)).findById(course.id)
        verify(courseRepository, times(1)).save(any(Course.class))
        verifyNoMoreInteractions(courseRepository)
    }
    
    @Test
    public void testUpdateFromDto_withDtoWithNoId() {
        // Stub Data and Method Returns
        CourseDto dto = createDto()
        dto.id = null
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Course ID should not be null when updating");
        // Initialise Test
        courseService.updateFromDto(dto)
        // Verify Results
        verifyNoMoreInteractions(courseRepository)
    }
    
    @Test
    public void testUpdateFromDto_withLevelId() {
        // Stub Data and Method Returns
        CourseDto dto = createDto()
        dto.levelId = 1
        when(levelService.findById(dto.levelId)).thenReturn(null);
        // Initialise Test
        courseService.updateFromDto(dto)
        // Verify Results
        verify(levelService, times(1)).findById(dto.levelId)
        verifyNoMoreInteractions(levelService)
    }
    
    @Test
    public void testUpdateFromDto_withSubjectId() {
        // Stub Data and Method Returns
        CourseDto dto = createDto()
        dto.subjectId = 1
        when(subjectService.findById(dto.subjectId)).thenReturn(null);
        // Initialise Test
        courseService.updateFromDto(dto)
        // Verify Results
        verify(subjectService, times(1)).findById(dto.subjectId)
        verifyNoMoreInteractions(subjectService)
    }
    
    @Test
    public void testUpdateFromDto_withExamBoardId() {
        // Stub Data and Method Returns
        CourseDto dto = createDto()
        dto.examBoardId = 1
        when(examBoardService.findById(dto.examBoardId)).thenReturn(null);
        // Initialise Test
        courseService.updateFromDto(dto)
        // Verify Results
        verify(examBoardService, times(1)).findById(dto.examBoardId)
        verifyNoMoreInteractions(examBoardService)
    }
    
    @Test
    public void testUpdateFromDto_withValidFromId() {
        // Stub Data and Method Returns
        CourseDto dto = createDto()
        dto.validFromId = 1
        when(academicYearService.findById(dto.validFromId)).thenReturn(null);
        // Initialise Test
        courseService.updateFromDto(dto)
        // Verify Results
        verify(academicYearService, times(1)).findById(dto.validFromId)
        verifyNoMoreInteractions(academicYearService)
    }
    
    @Test
    public void testUpdateFromDto_withValidToId() {
        // Stub Data and Method Returns
        CourseDto dto = createDto()
        dto.validToId = 1
        when(academicYearService.findById(dto.validToId)).thenReturn(null);
        // Initialise Test
        courseService.updateFromDto(dto)
        // Verify Results
        verify(academicYearService, times(1)).findById(dto.validToId)
        verifyNoMoreInteractions(academicYearService)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("Course should not be deleted");
        courseService.delete(new Course(id: 1))
        verifyNoMoreInteractions(courseRepository)
    }
}
