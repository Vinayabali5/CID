package uk.ac.reigate.services.ilp

import static org.junit.Assert.assertNotNull
import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.ilp.ILPInterview;
import uk.ac.reigate.dto.LetterDto
import uk.ac.reigate.dto.ilp.ILPInterviewDto
import uk.ac.reigate.dto.ilp.ILPInterviewUpdateDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilp.ILPInterviewRepository
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.CourseGroupService
import uk.ac.reigate.services.PersonService
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.lip.LIPService
import uk.ac.reigate.services.student.StudentService

class ILPInterviewServiceTest {
    
    @Mock
    private ILPInterviewRepository iLPInterviewRepository
    
    @InjectMocks
    private ILPInterviewService iLPInterviewService;
    
    @Mock
    private ILPInterviewRepository ilpInterviewRepository
    
    @Mock
    private ILPInterviewTypeService ilpInterviewTypeService;
    
    @Mock
    private StudentService studentService;
    
    @Mock
    private CourseGroupService courseGroupService;
    
    @Mock
    private StaffService staffService;
    
    @Mock
    private AcademicYearService academicYearService;
    
    @Mock
    private PersonService personService
    
    @Mock
    private LetterService letterService
    
    @Mock
    private OfficeActionService officeActionService
    
    @Mock
    private LIPService lipService
    
    private ILPInterview iLPInterview
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    ILPInterview createILPInterview() {
        return new ILPInterview(
                id: 1,
                discussion: 'Testing',
                target: 'A',
                referLip : true
                )
    }
    
    ILPInterviewDto createDto() {
        return new ILPInterviewDto(
                id: iLPInterview.id,
                discussion: iLPInterview.discussion,
                target: iLPInterview.target,
                referLip: iLPInterview.referLip
                )
    }
    
    ILPInterviewUpdateDto updateDto() {
        return new ILPInterviewUpdateDto(
                id: iLPInterview.id,
                privateEntry: iLPInterview.privateEntry
                )
    }
    
    @Before
    public void setup() {
        iLPInterviewRepository = mock(ILPInterviewRepository.class);
        ilpInterviewRepository = mock(ILPInterviewRepository.class);
        ilpInterviewTypeService = mock(ILPInterviewTypeService.class);
        studentService = mock(StudentService.class);
        courseGroupService= mock(CourseGroupService.class);
        staffService = mock(StaffService.class);
        academicYearService = mock(AcademicYearService.class);
        personService = mock(PersonService.class);
        letterService = mock(LetterService.class);
        officeActionService = mock(OfficeActionService.class);
        lipService = mock(LIPService.class);
        
        iLPInterviewService = new ILPInterviewService(iLPInterviewRepository, ilpInterviewTypeService, studentService, courseGroupService, staffService, academicYearService, personService, letterService, officeActionService, lipService);
        
        iLPInterview = createILPInterview()
        
        when(iLPInterviewRepository.findById(iLPInterview.id)).thenReturn(new Optional(new ILPInterview()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        ILPInterviewService service = new ILPInterviewService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindByCourseGroupId() {
        List<ILPInterview> result = iLPInterviewService.findByCourseGroupId(11);
        verify(iLPInterviewRepository, times(1)).findByCourseGroup_Id(11)
        verifyNoMoreInteractions(iLPInterviewRepository)
    }
    
    @Test
    public void testFindByCourseGroupAndYear(){
        AcademicYear year = new AcademicYear(id:18, code:'18')
        List<ILPInterview> result = iLPInterviewService.findByCourseAndYear(11, year);
        verify(iLPInterviewRepository, times(1)).findByCourseGroup_IdAndAcademicYear(11, year)
        verifyNoMoreInteractions(iLPInterviewRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        iLPInterviewService.delete(iLPInterview)
    }
    
    @Test
    public void testFindById() {
        ILPInterview result = iLPInterviewService.findById(1);
        verify(iLPInterviewRepository, times(1)).findById(1)
        verifyNoMoreInteractions(iLPInterviewRepository)
    }
    
    @Test
    public void testSave() {
        ILPInterview savedILPInterview = iLPInterviewService.save(iLPInterview);
        verify(iLPInterviewRepository, times(1)).save(any())
        verifyNoMoreInteractions(iLPInterviewRepository)
    }
    
    @Test
    public void testSaveILPInterview() {
        ILPInterview savedILPInterview = iLPInterviewService.save(iLPInterview);
        verify(iLPInterviewRepository, times(1)).save(any())
        verifyNoMoreInteractions(iLPInterviewRepository)
    }
    
    @Test
    public void testSaveILPInterviews() {
        List<ILPInterview> savedILPInterviews = iLPInterviewService.saveILPInterviews([
            new ILPInterview(id : 1),
            new ILPInterview(id: 2)
        ]);
        verify(iLPInterviewRepository, times(2)).save(any(ILPInterview.class))
        verifyNoMoreInteractions(iLPInterviewRepository)
    }
    
    @Test
    public void testSaveILPInterviewByFields() {
        ILPInterview savedILPInterview = iLPInterviewService.save(iLPInterview);
        verify(iLPInterviewRepository, times(1)).save(any())
        verifyNoMoreInteractions(iLPInterviewRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        ILPInterviewDto dto = createDto()
        iLPInterviewService.updateFromDto(dto)
        verify(iLPInterviewRepository, times(1)).findById(dto.id)
    }
    
    @Test
    public void testUpdateFromDto_DtoWithCourseGroupId() {
        ILPInterviewDto dto = createDto()
        dto.courseGroupId = 1
        when(courseGroupService.findById(dto.courseGroupId)).thenReturn(null)
        iLPInterviewService.updateFromDto(dto)
        verify(iLPInterviewRepository, times(1)).findById(dto.id)
    }
    
    @Test
    public void testUpdateFromDto_DtoWithStaffId() {
        ILPInterviewDto dto = createDto()
        dto.staffId = 1
        when(staffService.findById(dto.staffId)).thenReturn(null)
        iLPInterviewService.updateFromDto(dto)
        verify(iLPInterviewRepository, times(1)).findById(dto.id)
    }
    
    @Test
    public void testUpdateFromDto_DtoWithofficeActionId() {
        ILPInterviewDto dto = createDto()
        dto.officeAction = 1
        when(officeActionService.findById(dto.officeAction)).thenReturn(null)
        iLPInterviewService.updateFromDto(dto)
        verify(iLPInterviewRepository, times(1)).findById(dto.id)
    }
    
    @Test
    public void testUpdateFromDto_DtoWithLetterId() {
        ILPInterviewDto dto = createDto()
        dto.letter = new LetterDto(id:1 )
        dto.letter.id = 1
        when(letterService.updateFromDto(dto.letter)).thenReturn(null)
        iLPInterviewService.updateFromDto(dto)
        verify(iLPInterviewRepository, times(1)).findById(dto.id)
    }
    
    @Test
    public void testUpdateFromDto_DtoILPInterviewUpdateDto() {
        ILPInterviewUpdateDto dto = updateDto()
        iLPInterviewService.updateFromDto(dto)
        verify(iLPInterviewRepository, times(1)).findById(dto.id)
    }
    
    @Test
    public void testUpdateFromDto_DtoILPInterviewUpdateDtoWithStaffId() {
        ILPInterviewUpdateDto dto = updateDto()
        dto.staffId = 1465
        when(staffService.findById(dto.staffId)).thenReturn(null);
        iLPInterviewService.updateFromDto(dto)
        verify(iLPInterviewRepository, times(1)).findById(dto.id)
    }
    
    @Test
    public void testCreateFromDto_NoStudent() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("No student supplied for ILP Interview")
        ILPInterviewDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        iLPInterviewService.createFromDto(dto)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}

