package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.admissions.Request
import uk.ac.reigate.dto.RequestDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.predicates.CoursePredicates
import uk.ac.reigate.repositories.academic.CourseRepository
import uk.ac.reigate.repositories.admissions.RequestRepository
import uk.ac.reigate.repositories.lookup.LevelRepository
import uk.ac.reigate.repositories.lookup.SubjectRepository
import uk.ac.reigate.services.student.StudentService

class RequestServiceTest {
    
    @Mock
    private RequestRepository requestRepository
    
    @Mock
    private AcademicYearService academicYearService;
    
    @Mock
    private StudentService studentService
    
    @Mock
    private SubjectRepository subjectRepository
    
    @Mock
    private LevelRepository levelRepository
    
    @Mock
    private CourseRepository courseRepository
    
    @InjectMocks
    private RequestService requestService;
    
    private Request request;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    Request createRequest() {
        return new Request(
                id: 1,
                request: 'Maths',
                coreAim: false,
                broadeningSubject: true
                );
    }
    
    RequestDto createDto() {
        Request sampleData = createRequest()
        return new RequestDto(
                id: sampleData.id,
                request: sampleData.request,
                coreAim: sampleData.coreAim,
                broadeningSubject: sampleData.broadeningSubject
                );
    }
    
    @Before
    public void setup() {
        requestRepository = mock(RequestRepository.class);
        academicYearService = mock(AcademicYearService.class);
        studentService = mock(StudentService.class);
        subjectRepository = mock(SubjectRepository.class);
        levelRepository = mock(LevelRepository.class);
        courseRepository = mock(CourseRepository.class);
        
        this.requestService = new RequestService(requestRepository, academicYearService, studentService, subjectRepository, levelRepository, courseRepository);
        
        request = createRequest()
        
        when(requestRepository.findById(1)).thenReturn(new Optional(request));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        RequestService service = new RequestService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindRequests() {
        List<Request> result = requestService.findAll();
        verify(requestRepository, times(1)).findAll()
        verifyNoMoreInteractions(requestRepository)
    }
    
    @Test
    public void testGetCourseDescription() {
        String requestCode = 'Maths'
        String result = requestService.getCourseDescription(18, requestCode);
        String description = ""
        requestCode.size()
        verifyNoMoreInteractions(requestRepository)
    }
    
    @Test
    public void testGetCourseNullDescription() {
        String requestCode = 'Maths'
        String result = requestService.getCourseDescription(18, requestCode);
        String description = ""
        requestCode.size()
        verifyNoMoreInteractions(requestRepository)
    }
    
    @Test
    public void testCourseDescription() {
        String requestCode = 'Maths'
        String result = requestService.getCourseDescription(18, requestCode);
        String description = ""
        requestCode.size()
        List<Course> courses = courseRepository.findAll(CoursePredicates.courseValidInYear(18).and(CoursePredicates.courseSpecIs('Maths'.substring(2,5))))
        courses.size()
        verifyNoMoreInteractions(requestRepository)
    }
    
    @Test
    public void testCourseDescriptionCode() {
        String requestCode = 'Math'
        String result = requestService.getCourseDescription(18, requestCode);
        String description = ""
        requestCode.size()
        List<Course> courses = courseRepository.findAll(CoursePredicates.courseValidInYear(18).and(CoursePredicates.courseSpecIs('Maths'.substring(2,5))))
        courses.size()
        verifyNoMoreInteractions(requestRepository)
    }
    
    @Test
    public void testFindRequest() {
        Request result = requestService.findById(1);
        verify(requestRepository, times(1)).findById(1)
        verifyNoMoreInteractions(requestRepository)
    }
    
    @Test
    public void testFindByStudent_IdAndRequestAndAcademicYear() {
        AcademicYear academicYear = new AcademicYear(id: 1)
        Request result = requestService.findByStudent_IdAndRequestAndAcademicYear(1, 'Maths', academicYear);
        verify(requestRepository, times(1)).findByStudent_IdAndRequestAndAcademicYear(1, 'Maths', academicYear)
        verifyNoMoreInteractions(requestRepository)
    }
    
    @Test
    public void testFindRequestsByStudentId() {
        List<Request> result = requestService.findRequestsByStudentId(19001);
        verify(requestRepository, times(1)).findByStudent_Id(19001)
        verifyNoMoreInteractions(requestRepository)
    }
    
    @Test
    public void testSearchByYear() {
        AcademicYear academicYear = new AcademicYear(id: 1)
        List<Request> result = requestService.searchByYear(academicYear);
        verify(requestRepository, times(1)).findByAcademicYear(academicYear)
        verifyNoMoreInteractions(requestRepository)
    }
    
    @Test
    public void testSearchByYearAndStudentId() {
        List<Request> result = requestService.findByStudentIdYearId(19001, 18);
        verify(requestRepository, times(1)).findByStudent_IdAndAcademicYear_Id(19001, 18)
        verifyNoMoreInteractions(requestRepository)
    }
    
    @Test
    public void testSearchByYearAndStudent() {
        List<Request> result = requestService.searchByYearAndStudentId(19001, 18);
        verify(requestRepository, times(1)).findByAcademicYear_IdAndStudent_Id(19001, 18)
        verifyNoMoreInteractions(requestRepository)
    }
    
    @Test
    public void testFindByStudentId() {
        List<Request> result = requestService.findByStudentId(19001);
        verify(requestRepository, times(1)).findByStudent_Id(19001)
        verifyNoMoreInteractions(requestRepository)
    }
    
    @Test
    public void testSaveNewRequest() {
        request.id = null
        Request savedRequest = requestService.save(request);
        verify(requestRepository, times(1)).save(any(Request.class))
        verifyNoMoreInteractions(requestRepository)
    }
    
    @Test
    public void testSaveRequest() {
        Request savedRequest = requestService.save(request);
        verify(requestRepository, times(1)).save(any(Request.class))
        verifyNoMoreInteractions(requestRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        RequestDto dto = new RequestDto(id: 1, request: 'Maths');
        requestService.createFromDto(dto)
        verify(requestRepository, times(1)).save(any(Request.class))
        verifyNoMoreInteractions(requestRepository)
    }
    
    @Test
    public void testCreateFromDto_studentId() {
        RequestDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        requestService.createFromDto(dto)
        verify(requestRepository, times(1)).save(any(Request.class))
        verifyNoMoreInteractions(requestRepository)
    }
    
    @Test
    public void testCreateFromDto_academicYeard() {
        RequestDto dto = createDto()
        dto.academicYearId = 20
        when(academicYearService.findById(dto.academicYearId)).thenReturn(null);
        requestService.createFromDto(dto)
        verify(requestRepository, times(1)).save(any(Request.class))
        verifyNoMoreInteractions(requestRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        RequestDto dto = new RequestDto(id: 1, request: 'Maths');
        requestService.updateFromDto(dto)
        verify(requestRepository, times(1)).findById(request.id)
        verify(requestRepository, times(1)).save(request)
        verifyNoMoreInteractions(requestRepository)
    }
    
    @Test
    public void testUpdateFromDto_studentId() {
        RequestDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        requestService.updateFromDto(dto)
        verify(studentService, times(1)).findById(dto.studentId)
        verifyNoMoreInteractions(studentService)
    }
    
    @Test
    public void testUpdateFromDto_academicYeard() {
        RequestDto dto = createDto()
        dto.academicYearId = 20
        when(academicYearService.findById(dto.academicYearId)).thenReturn(null);
        requestService.updateFromDto(dto)
        verify(academicYearService, times(1)).findById(dto.academicYearId)
        verifyNoMoreInteractions(academicYearService)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create requestDto from null object.")
        RequestDto dto = null
        requestService.createFromDto(dto)
        verifyNoMoreInteractions(requestRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update requestDto from null object.")
        RequestDto dto = null
        requestService.updateFromDto(dto)
        verifyNoMoreInteractions(requestRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        requestService.delete(request)
        verifyNoMoreInteractions(requestRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    @Test
    public void testDeleteById() {
        requestService.delete(request.id)
        verify(requestRepository, times(1)).deleteById(request.id)
    }
}

