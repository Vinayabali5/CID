package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.lookup.TutorGroup
import uk.ac.reigate.dto.TutorGroupDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.TutorGroupRepository
import uk.ac.reigate.services.student.StudentRemarkPermissionService
import uk.ac.reigate.services.student.StudentService
import uk.ac.reigate.services.student.StudentYearService


class TutorGroupServiceTest {
    
    @Mock
    private TutorGroupRepository tutorGroupRepository;
    
    @Mock
    private FacultyService facultyService;
    
    @Mock
    private StaffService staffService;
    
    @Mock
    private RoomService roomService;
    
    @Mock
    private StudentService studentService
    
    @Mock
    private StudentYearService studentYearService
    
    @Mock
    private AcademicYearService academicYearService
    
    @Mock
    private StudentRemarkPermissionService studentRemarkPermissionService
    
    @InjectMocks
    private TutorGroupService tutorGroupService;
    
    private TutorGroup tutorGroup
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample TutorGroup data object to use for the testing
     * 
     * @return a sample TutorGroup data object
     */
    TutorGroup createTutorGroup() {
        return new TutorGroup(
                id: 1,
                code: '1',
                description: 'TutorGroup 1'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample TutorGroup created at setup
     * 
     * @return a TutorGroupDto object based on the sample TutorGroup
     */
    TutorGroupDto createDto() {
        return new TutorGroupDto(
                id: tutorGroup.id,
                code: tutorGroup.code,
                description: tutorGroup.description
                )
    }
    
    /**
     * This method is used to set up the tests for the TutorGroupService
     */
    @Before
    public void setup() {
        tutorGroupRepository = mock(TutorGroupRepository.class);
        tutorGroupRepository = mock(TutorGroupRepository.class)
        facultyService = mock(FacultyService.class)
        staffService = mock(StaffService.class)
        roomService = mock(RoomService.class)
        studentService = mock(StudentService.class)
        studentYearService = mock(StudentYearService.class)
        academicYearService = mock(AcademicYearService.class)
        studentRemarkPermissionService = mock(StudentRemarkPermissionService.class)
        
        this.tutorGroupService = new TutorGroupService(tutorGroupRepository, facultyService, staffService, roomService, studentService, studentYearService, academicYearService, studentRemarkPermissionService);
        
        tutorGroup = createTutorGroup()
        
        when(tutorGroupRepository.save(any(TutorGroup.class))).thenReturn(tutorGroup);
        when(tutorGroupRepository.findById(1)).thenReturn(new Optional(tutorGroup));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        TutorGroupService service = new TutorGroupService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<TutorGroup> result = tutorGroupService.findAll();
        verify(tutorGroupRepository, times(1)).findAll()
        verifyNoMoreInteractions(tutorGroupRepository)
    }
    
    @Test
    public void testGetValidTutorGroups() {
        Staff tutor = new Staff(id: 1)
        List<TutorGroup> result = tutorGroupService.getValidTutorGroups(true);
        verify(tutorGroupRepository, times(1)).findByInUse(true)
        verifyNoMoreInteractions(tutorGroupRepository)
    }
    
    @Test
    public void testFindByTutor() {
        Staff tutor = new Staff(id: 1)
        List<TutorGroup> result = tutorGroupService.findByTutor(tutor);
        verify(tutorGroupRepository, times(1)).findByTutorAndInUseIsTrue(tutor)
        verifyNoMoreInteractions(tutorGroupRepository)
    }
    
    @Test
    public void testFindBySeniorTutor() {
        Staff tutor = new Staff(id: 1)
        List<TutorGroup> result = tutorGroupService.findBySeniorTutor(tutor);
        verify(tutorGroupRepository, times(1)).findBySeniorTutorAndInUseIsTrue(tutor)
        verifyNoMoreInteractions(tutorGroupRepository)
    }
    
    @Test
    public void testFindByDirectorOfLearning() {
        Staff tutor = new Staff(id: 1)
        List<TutorGroup> result = tutorGroupService.findByDirectorOfLearning(tutor);
        verify(tutorGroupRepository, times(1)).findByFaculty_DolAndInUseIsTrue(tutor)
        verifyNoMoreInteractions(tutorGroupRepository)
    }
    
    @Test
    public void testFindByAssociateDirectorOfLearning() {
        Staff tutor = new Staff(id: 1)
        List<TutorGroup> result = tutorGroupService.findByAssociateDirectorOfLearning(tutor);
        verify(tutorGroupRepository, times(1)).findByFaculty_AdolAndInUseIsTrue(tutor)
        verifyNoMoreInteractions(tutorGroupRepository)
    }
    
    @Test
    public void testFindByPastoralDirector() {
        Staff tutor = new Staff(id: 1)
        List<TutorGroup> result = tutorGroupService.findByPastoralDirector(tutor);
        verify(tutorGroupRepository, times(1)).findByFaculty_PdAndInUseIsTrue(tutor)
        verifyNoMoreInteractions(tutorGroupRepository)
    }
    
    @Test
    public void testFindByAssoicatePastoralDirector() {
        Staff tutor = new Staff(id: 1)
        List<TutorGroup> result = tutorGroupService.findByAssoicatePastoralDirector(tutor);
        verify(tutorGroupRepository, times(1)).findByFaculty_ApdAndInUseIsTrue(tutor)
        verifyNoMoreInteractions(tutorGroupRepository)
    }
    
    @Test
    public void testFindByHeadOfFaculty() {
        Staff tutor = new Staff(id: 1)
        List<TutorGroup> result = tutorGroupService.findByHeadOfFaculty(tutor);
        verify(tutorGroupRepository, times(1)).findByFaculty_HofAndInUseIsTrue(tutor)
        verifyNoMoreInteractions(tutorGroupRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        TutorGroup result = tutorGroupService.findById(1);
        verify(tutorGroupRepository, times(1)).findById(1)
        verifyNoMoreInteractions(tutorGroupRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        TutorGroup savedTutorGroup = tutorGroupService.save(tutorGroup);
        verify(tutorGroupRepository, times(1)).save(any())
        verifyNoMoreInteractions(tutorGroupRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<TutorGroup> savedTutorGroups = tutorGroupService.saveTutorGroups([tutorGroup, tutorGroup]);
        verify(tutorGroupRepository, times(2)).save(tutorGroup)
        verifyNoMoreInteractions(tutorGroupRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        TutorGroupDto dto = createDto()
        TutorGroup tutorGroupSaved = tutorGroupService.createFromDto(dto)
        verify(tutorGroupRepository, times(1)).save(any(TutorGroup.class))
        verifyNoMoreInteractions(tutorGroupRepository)
        assertEquals(dto.id, tutorGroup.id)
        assertEquals(dto.code, tutorGroup.code)
        assertEquals(dto.description, tutorGroup.description)
    }
    
    @Test
    public void testCreateFromDto_dtoWithFacultyId() {
        TutorGroupDto dto = createDto()
        dto.facultyId = 1
        when(facultyService.findById(dto.facultyId)).thenReturn(null)
        TutorGroup tutorGroupSaved = tutorGroupService.createFromDto(dto)
        verify(tutorGroupRepository, times(1)).save(any(TutorGroup.class))
        verifyNoMoreInteractions(tutorGroupRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithTutorId() {
        TutorGroupDto dto = createDto()
        dto.tutorId = 1
        when(staffService.findById(dto.tutorId)).thenReturn(null)
        TutorGroup tutorGroupSaved = tutorGroupService.createFromDto(dto)
        verify(tutorGroupRepository, times(1)).save(any(TutorGroup.class))
        verifyNoMoreInteractions(tutorGroupRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithSeniorTutorId() {
        TutorGroupDto dto = createDto()
        dto.seniorTutorId = 1
        when(staffService.findById(dto.seniorTutorId)).thenReturn(null)
        TutorGroup tutorGroupSaved = tutorGroupService.createFromDto(dto)
        verify(tutorGroupRepository, times(1)).save(any(TutorGroup.class))
        verifyNoMoreInteractions(tutorGroupRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithRoomId() {
        TutorGroupDto dto = createDto()
        dto.roomId = 1
        when(roomService.findById(dto.roomId)).thenReturn(null)
        TutorGroup tutorGroupSaved = tutorGroupService.createFromDto(dto)
        verify(tutorGroupRepository, times(1)).save(any(TutorGroup.class))
        verifyNoMoreInteractions(tutorGroupRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create tutorGroupDto from null object.")
        TutorGroupDto dto = null
        tutorGroupService.createFromDto(dto)
        verifyNoMoreInteractions(tutorGroupRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        TutorGroupDto dto = createDto()
        TutorGroup tutorGroupSaved = tutorGroupService.updateFromDto(dto)
        verify(tutorGroupRepository, times(1)).findById(tutorGroup.id)
        verify(tutorGroupRepository, times(1)).save(tutorGroup)
        verifyNoMoreInteractions(tutorGroupRepository)
        assertEquals(tutorGroup.id, tutorGroupSaved.id)
        assertEquals(tutorGroup.code, tutorGroupSaved.code)
        assertEquals(tutorGroup.description, tutorGroupSaved.description)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithFacultyId() {
        TutorGroupDto dto = createDto()
        dto.facultyId = 1
        when(facultyService.findById(dto.facultyId)).thenReturn(null)
        TutorGroup tutorGroupSaved = tutorGroupService.updateFromDto(dto)
        verify(facultyService, times(1)).findById(dto.facultyId)
        verifyNoMoreInteractions(facultyService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithTutorId() {
        TutorGroupDto dto = createDto()
        dto.tutorId = 1
        when(staffService.findById(dto.tutorId)).thenReturn(null)
        TutorGroup tutorGroupSaved = tutorGroupService.updateFromDto(dto)
        verify(staffService, times(1)).findById(dto.tutorId)
        verifyNoMoreInteractions(staffService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithSeniorTutorId() {
        TutorGroupDto dto = createDto()
        dto.seniorTutorId = 1
        when(staffService.findById(dto.seniorTutorId)).thenReturn(null)
        TutorGroup tutorGroupSaved = tutorGroupService.updateFromDto(dto)
        verify(staffService, times(1)).findById(dto.seniorTutorId)
        verifyNoMoreInteractions(staffService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithRoomId() {
        TutorGroupDto dto = createDto()
        dto.roomId = 1
        when(roomService.findById(dto.roomId)).thenReturn(null)
        TutorGroup tutorGroupSaved = tutorGroupService.updateFromDto(dto)
        verify(roomService, times(1)).findById(dto.roomId)
        verifyNoMoreInteractions(roomService)
    }
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        TutorGroupDto dto = createDto()
        TutorGroup tutorGroupSaved = tutorGroupService.updateFromDto(dto)
        verify(tutorGroupRepository, times(1)).findById(tutorGroup.id)
        verify(tutorGroupRepository, times(1)).save(tutorGroup)
        verifyNoMoreInteractions(tutorGroupRepository)
        assertEquals(tutorGroup.id, tutorGroupSaved.id)
        assertEquals(tutorGroup.code, tutorGroupSaved.code)
        assertEquals(tutorGroup.description, tutorGroupSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update tutorGroupDto from null object.")
        TutorGroupDto dto = null
        tutorGroupService.updateFromDto(dto)
        verifyNoMoreInteractions(tutorGroupRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        tutorGroupService.delete(tutorGroup)
        verifyNoMoreInteractions(tutorGroupRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}