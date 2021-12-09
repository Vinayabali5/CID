package uk.ac.reigate.services

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Enrolment
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.dto.CourseGroupDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.predicates.CourseGroupPredicates
import uk.ac.reigate.repositories.academic.CourseGroupRepository;
import uk.ac.reigate.services.enrolments.EnrolmentService
import uk.ac.reigate.services.ilp.ILPInterviewService


class CourseGroupServiceTest {
    
    @Mock
    private CourseGroupRepository courseGroupRepository;
    
    @Mock
    private YearGroupService yearGroupService;
    
    @Mock
    private CourseService courseService;
    
    @Mock
    private AcademicYearService academicYearService;
    
    @Mock
    private DepartmentService departmentService;
    
    @Mock
    private StaffService staffService;
    
    @Mock
    private EnrolmentService enrolmentService;
    
    @Mock
    private TimetableService timetableService;
    
    @Mock
    private ILPInterviewService iLPInterviewService;
    
    @InjectMocks
    private CourseGroupService courseGroupService;
    
    private CourseGroup courseGroup
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    CourseGroup createCourseGroup() {
        return new CourseGroup(
                id: 1,
                code: 'A',
                displayOnTimetable: true,
                hasRegister: true,
                notes: 'Nothing',
                spec:'L-MAH'
                )
    }
    
    CourseGroupDto createDto() {
        CourseGroup sampleCourseGroup = createCourseGroup()
        return new CourseGroupDto(
                id: sampleCourseGroup.id,
                code: sampleCourseGroup.code,
                displayOnTimetable: sampleCourseGroup.displayOnTimetable,
                hasRegister: sampleCourseGroup.hasRegister,
                notes: sampleCourseGroup.notes,
                spec:sampleCourseGroup.spec
                )
    }
    
    @Before
    public void setup() {
        this.courseGroupRepository = mock(CourseGroupRepository.class);
        this.yearGroupService = mock(YearGroupService.class);
        this.courseService = mock(CourseService.class);
        this.academicYearService = mock(AcademicYearService.class);
        this.departmentService = mock(DepartmentService.class);
        this.staffService = mock(StaffService.class);
        this.enrolmentService = mock(EnrolmentService.class);
        this.timetableService = mock(TimetableService.class);
        this.iLPInterviewService = mock(ILPInterviewService.class);
        
        this.courseGroupService = new CourseGroupService(courseGroupRepository, yearGroupService, courseService, academicYearService, departmentService, staffService, enrolmentService, timetableService, iLPInterviewService);
        
        courseGroup = createCourseGroup()
        
        when(courseGroupRepository.findById(courseGroup.id)).thenReturn(new Optional(new CourseGroup()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        CourseGroupService service = new CourseGroupService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<CourseGroup> result = courseGroupService.findAll();
        verify(courseGroupRepository, times(1)).findAll()
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testGetCourseGroupsByYearId() {
        List<CourseGroup> result = courseGroupService.getCourseGroupsByYearId(11);
        verify(courseGroupRepository, times(1)).findAll(CourseGroupPredicates.courseGroupValidInYear(11))
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testFindByHodAndYear() {
        List<CourseGroup> result = courseGroupService.findByHodAndYear(10, 11);
        verify(courseGroupRepository, times(1)).findByDepartment_Hod_IdAndYear_Id(10, 11)
        verify(courseGroupRepository, times(1)).findByDepartment_Hod2_IdAndYear_Id(10, 11)
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testSearchByCourses() {
        List<CourseGroup> result = courseGroupService.searchByCourse(11);
        verify(courseGroupRepository, times(1)).findByCourse_Id(11)
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testGetCourseGroupEnrolments() {
        List<Enrolment> result = courseGroupService.getCourseGroupEnrolments(11);
        verify(enrolmentService, times(1)).findByCourseGroup(11)
        verifyNoMoreInteractions(enrolmentService)
    }
    
    @Test
    public void testFindByTeacherAndYear() {
        List<CourseGroup> result = courseGroupService.findByTeacherAndYear(12, 19);
        verify(courseGroupRepository, times(1)).findDistinctCourseGroupByTimetable_TeacherIdAndYear_Id(12, 19)
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testSearchByYearAndSpec() {
        AcademicYear academicYear = new AcademicYear(id:1, code:'19', description: '2019', startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'), endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'), startYear: 2017 )
        List<CourseGroup> result = courseGroupService.searchByYearAndSpec(academicYear, 'Test');
        verify(courseGroupRepository, times(1)).findByYearAndSpecLike(academicYear, 'Test')
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testGetByAcademicYear() {
        AcademicYear academicYear = new AcademicYear(id:1, code:'19', description: '2019', startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'), endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'), startYear: 2017 )
        CourseGroup result = courseGroupService.getByAcademicYear(academicYear);
        verify(courseGroupRepository, times(1)).findByYear(academicYear)
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testFindByCourseLeaderAndYear() {
        List<CourseGroup> result = courseGroupService.findByCourseLeaderAndYear(12, 19);
        verify(courseGroupRepository, times(1)).findByCourseLeader_IdAndYear_Id(12, 19)
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testFindById() {
        CourseGroup result = courseGroupService.findById(1);
        verify(courseGroupRepository, times(1)).findById(1)
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testSearchBycourseAndYear() {
        AcademicYear year = new AcademicYear(id:1, code:'19', description: '2019', startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'), endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'), startYear: 2017 )
        List<CourseGroup> result = courseGroupService.searchBycourseAndYear(12, year);
        verify(courseGroupRepository, times(1)).findByCourse_IdAndYear(12, year)
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testFindByStudentAndYear() {
        Student student = new Student(id:19001)
        AcademicYear year = new AcademicYear(id:1, code:'19', description: '2019', startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'), endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'), startYear: 2017 )
        List<CourseGroup> result = courseGroupService.findByStudentAndYear(student, year);
        verify(courseGroupRepository, times(1)).findByStudentAndYear(student, year)
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testFindByStudent() {
        Student student = new Student(id:19001)
        List<CourseGroup> result = courseGroupService.findByStudent(student);
        verify(courseGroupRepository, times(1)).findByStudent(student)
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testSearchByCourse() {
        List<CourseGroup> result = courseGroupService.searchByYearAndCourseIdAndSpec(12, 11, 'Test');
        verify(courseGroupRepository, times(1)).findByYear_IdAndCourse_IdAndSpec(12, 11, 'Test')
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testGetCourseGroupByIdYearId() {
        List<CourseGroup> result = courseGroupService.getCourseGroupByIdYearId(12, 11);
        verify(courseGroupRepository, times(1)).findCourseGroupByIdYearId(12, 11)
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testSearchByYear() {
        AcademicYear academicYear = new AcademicYear(id:1, code:'19', description: '2019', startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'), endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'), startYear: 2017 )
        List<CourseGroup> result = courseGroupService.searchByYear(academicYear);
        verify(courseGroupRepository, times(1)).findCourseGroupYear(academicYear.id)
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testSaveCourseGroups() {
        List<CourseGroup> savedCourseGroups = courseGroupService.saveCourseGroups([
            new CourseGroup(id: 1),
            new CourseGroup(id: 2)
        ])
        verify(courseGroupRepository, times(2)).save(any(CourseGroup.class))
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testSave() {
        courseGroup.id = null
        courseGroupService.save(courseGroup);
        verify(courseGroupRepository, times(1)).save(courseGroup)
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testSaveCourseGroup() {
        courseGroupService.save(courseGroup);
        verify(courseGroupRepository, times(1)).save(courseGroup)
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        CourseGroupDto dto = createDto()
        CourseGroup courseGroupSaved = courseGroupService.createFromDto(dto)
        verify(courseGroupRepository, times(1)).save(any(CourseGroup.class))
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithYearGroupId() {
        CourseGroupDto dto = createDto()
        dto.yearGroupId= 1
        when(yearGroupService.findById(dto.yearGroupId)).thenReturn(null);
        CourseGroup courseGroupSaved = courseGroupService.createFromDto(dto)
        verify(courseGroupRepository, times(1)).save(any(CourseGroup.class))
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithCourseId() {
        CourseGroupDto dto = createDto()
        dto.courseId= 1
        when(courseService.findById(dto.courseId)).thenReturn(null);
        CourseGroup courseGroupSaved = courseGroupService.createFromDto(dto)
        verify(courseGroupRepository, times(1)).save(any(CourseGroup.class))
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithYearId() {
        CourseGroupDto dto = createDto()
        dto.yearId= 1
        when(academicYearService.findById(dto.yearId)).thenReturn(null);
        CourseGroup courseGroupSaved = courseGroupService.createFromDto(dto)
        verify(courseGroupRepository, times(1)).save(any(CourseGroup.class))
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithDepartmentId() {
        CourseGroupDto dto = createDto()
        dto.departmentId= 1
        when(departmentService.findById(dto.departmentId)).thenReturn(null);
        CourseGroup courseGroupSaved = courseGroupService.createFromDto(dto)
        verify(courseGroupRepository, times(1)).save(any(CourseGroup.class))
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithCourseLeaderId() {
        CourseGroupDto dto = createDto()
        dto.courseLeaderId= 1
        when(staffService.findById(dto.courseLeaderId)).thenReturn(null);
        CourseGroup courseGroupSaved = courseGroupService.createFromDto(dto)
        verify(courseGroupRepository, times(1)).save(any(CourseGroup.class))
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        CourseGroupDto dto = createDto()
        CourseGroup courseGroupSaved = courseGroupService.updateFromDto(dto)
        verify(courseGroupRepository, times(1)).findById(courseGroup.id)
        verify(courseGroupRepository, times(1)).save(any(CourseGroup.class))
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithYearGroupId() {
        CourseGroupDto dto = createDto()
        dto.yearGroupId= 1
        when(yearGroupService.findById(dto.yearGroupId)).thenReturn(null);
        CourseGroup courseGroupSaved = courseGroupService.updateFromDto(dto)
        verify(yearGroupService, times(1)).findById(dto.yearGroupId)
        verifyNoMoreInteractions(yearGroupService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithCourseId() {
        CourseGroupDto dto = createDto()
        dto.courseId= 1
        when(courseService.findById(dto.courseId)).thenReturn(null);
        CourseGroup courseGroupSaved = courseGroupService.updateFromDto(dto)
        verify(courseService, times(1)).findById(dto.courseId)
        verifyNoMoreInteractions(courseService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithYearId() {
        CourseGroupDto dto = createDto()
        dto.yearId= 1
        when(academicYearService.findById(dto.yearId)).thenReturn(null);
        CourseGroup courseGroupSaved = courseGroupService.updateFromDto(dto)
        verify(academicYearService, times(1)).findById(dto.yearId)
        verifyNoMoreInteractions(academicYearService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithDepartmentId() {
        CourseGroupDto dto = createDto()
        dto.departmentId= 1
        when(departmentService.findById(dto.departmentId)).thenReturn(null);
        CourseGroup courseGroupSaved = courseGroupService.updateFromDto(dto)
        verify(departmentService, times(1)).findById(dto.departmentId)
        verifyNoMoreInteractions(departmentService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithCourseLeaderId() {
        CourseGroupDto dto = createDto()
        dto.courseLeaderId= 1
        when(staffService.findById(dto.courseLeaderId)).thenReturn(null);
        CourseGroup courseGroupSaved = courseGroupService.updateFromDto(dto)
        verify(staffService, times(1)).findById(dto.courseLeaderId)
        verifyNoMoreInteractions(staffService)
    }
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create CourseGroup from null object.")
        CourseGroupDto dto = null
        courseGroupService.createFromDto(dto)
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testupdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update CourseGroup from null object.")
        CourseGroupDto dto = null
        courseGroupService.updateFromDto(dto)
        verifyNoMoreInteractions(courseGroupRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("CourseGroup should not be deleted");
        courseGroupService.delete(new CourseGroup(id: 1))
    }
}

