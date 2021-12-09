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
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.dto.StaffDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.StaffRepository
import uk.ac.reigate.services.ilr.EthnicityService
import uk.ac.reigate.services.lookup.StaffTypeService
import uk.ac.reigate.services.staff.DisabilityService
import uk.ac.reigate.services.staff.MaritalStatusService
import uk.ac.reigate.services.staff.ReligionService
import uk.ac.reigate.services.staff.SexualOrientationService


class StaffServiceTest {
    
    @Mock
    private StaffRepository staffRepository;
    
    @Mock
    private PersonService personService;
    
    @Mock
    private StaffTypeService staffTypeService;
    
    @Mock
    private EthnicityService ethnicityService
    
    @Mock
    private DisabilityService disabilityService
    
    @Mock
    private SexualOrientationService sexualOrientationService
    
    @Mock
    private MaritalStatusService maritalStatusService
    
    @Mock
    private ReligionService religionService
    
    @Mock
    Pageable page
    
    @InjectMocks
    private StaffService staffService;
    
    private Staff staff
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample Staff data object to use for the testing
     * 
     * @return a sample Staff data object
     */
    Staff createStaff() {
        return new Staff(
                id: 1,
                initials: 'VBM',
                knownAs: 'vinaya'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample Staff created at setup
     * 
     * @return a StaffDto object based on the sample Staff
     */
    StaffDto createDto() {
        return new StaffDto(
                id: staff.id,
                initials: staff.initials,
                knownAs: staff.knownAs
                )
    }
    
    /**
     * This method is used to set up the tests for the StaffService
     */
    @Before
    public void setup() {
        staffRepository = mock(StaffRepository.class);
        personService = mock(PersonService.class);
        staffTypeService = mock(StaffTypeService.class);
        ethnicityService  = mock(EthnicityService.class);
        disabilityService = mock(DisabilityService.class);
        sexualOrientationService = mock(SexualOrientationService.class)
        maritalStatusService = mock(MaritalStatusService.class);
        religionService = mock(ReligionService.class);
        this.staffService = new StaffService(staffRepository, personService, staffTypeService, ethnicityService, disabilityService, sexualOrientationService, maritalStatusService, religionService);
        
        staff = createStaff()
        
        when(staffRepository.findById(1)).thenReturn(new Optional(new Staff()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StaffService service = new StaffService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<Staff> result = staffService.findAll();
        verify(staffRepository, times(1)).findByType_NeedInitialsTrue()
        verifyNoMoreInteractions(staffRepository)
    }
    
    @Test
    public void testfindStaffCurrent() {
        Pageable page
        Page<Staff> result = staffService.findStaffCurrent(page);
        verify(staffRepository, times(1)).findAllCurrent(page)
        verifyNoMoreInteractions(staffRepository)
    }
    
    @Test
    public void testFindStaffCurrent() {
        List<Staff> result = staffService.findStaffCurrent();
        verify(staffRepository, times(1)).findAllCurrent()
        verifyNoMoreInteractions(staffRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        Staff result = staffService.findById(1);
        verify(staffRepository, times(1)).findById(1)
        verifyNoMoreInteractions(staffRepository)
    }
    
    @Test
    public void testFindByPerson() {
        Person person = new Person(id: 1)
        Staff result = staffService.findByPerson(person);
        verify(staffRepository, times(1)).findByPerson(person)
        verifyNoMoreInteractions(staffRepository)
    }
    
    @Test
    public void testFindTeachers() {
        CourseGroup courseGroup = new CourseGroup(id: 1)
        List<Staff> result = staffService.findTeachers(courseGroup);
        verify(staffRepository, times(1)).findTeacherByCourseGroup(courseGroup)
        verifyNoMoreInteractions(staffRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        Staff savedStaff = staffService.save(staff);
        verify(staffRepository, times(1)).save(any())
        verifyNoMoreInteractions(staffRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<Staff> savedStaffs = staffService.saveStaffs([staff, staff]);
        verify(staffRepository, times(2)).save(staff)
        verifyNoMoreInteractions(staffRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        StaffDto dto = createDto()
        Staff staffSaved = staffService.createFromDto(dto)
        verify(staffRepository, times(1)).save(any(Staff.class))
        verifyNoMoreInteractions(staffRepository)
        assertEquals(dto.id, staff.id)
        assertEquals(dto.initials, staff.initials)
        assertEquals(dto.knownAs, staff.knownAs)
    }
    
    @Test
    public void testCreateFromDto_personId() {
        StaffDto dto = createDto()
        dto.personId = 1
        when(personService.findById(dto.personId)).thenReturn(null);
        Staff staffSaved = staffService.createFromDto(dto)
        verify(staffRepository, times(1)).save(any(Staff.class))
        verifyNoMoreInteractions(staffRepository)
    }
    
    @Test
    public void testCreateFromDto_typeId() {
        StaffDto dto = createDto()
        dto.typeId = 1
        when(staffTypeService.findById(dto.typeId)).thenReturn(null);
        Staff staffSaved = staffService.createFromDto(dto)
        verify(staffRepository, times(1)).save(any(Staff.class))
        verifyNoMoreInteractions(staffRepository)
    }
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create staffDto from null object.")
        StaffDto dto = null
        staffService.createFromDto(dto)
        verifyNoMoreInteractions(staffRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        StaffDto dto = createDto()
        Staff staffSaved = staffService.updateFromDto(dto)
        verify(staffRepository, times(1)).findById(staff.id)
        verify(staffRepository, times(1)).save(staff)
        verifyNoMoreInteractions(staffRepository)
    }
    
    @Test
    public void testUpdateFromDto_personId() {
        StaffDto dto = createDto()
        dto.personId = 1
        when(personService.findById(dto.personId)).thenReturn(null);
        Staff staffSaved = staffService.updateFromDto(dto)
        verify(personService, times(1)).findById(dto.personId)
        verifyNoMoreInteractions(personService)
    }
    
    @Test
    public void testUPdateFromDto_typeId() {
        StaffDto dto = createDto()
        dto.typeId = 1
        when(staffTypeService.findById(dto.typeId)).thenReturn(null);
        Staff staffSaved = staffService.updateFromDto(dto)
        verify(staffTypeService, times(1)).findById(dto.typeId)
        verifyNoMoreInteractions(staffTypeService)
    }
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        StaffDto dto = createDto()
        Staff staffSaved = staffService.updateFromDto(dto)
        verify(staffRepository, times(1)).findById(staff.id)
        verify(staffRepository, times(1)).save(staff)
        verifyNoMoreInteractions(staffRepository)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update staffDto from null object.")
        StaffDto dto = null
        staffService.updateFromDto(dto)
        verifyNoMoreInteractions(staffRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        staffService.delete(staff)
        verifyNoMoreInteractions(staffRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}