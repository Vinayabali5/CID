package uk.ac.reigate.services;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Department
import uk.ac.reigate.dto.DepartmentDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.DepartmentRepository;


public class DepartmentServiceTest {
    
    @Mock
    private DepartmentRepository departmentRepository;
    
    @Mock
    private FacultyService facultyService;
    
    @Mock
    private StaffService staffService;
    
    @InjectMocks
    private DepartmentService departmentService;
    
    private Department department
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    Department createDepartment() {
        return new Department(
                id: 1,
                name: 'A',
                description: 'Arts Department'
                )
    }
    
    DepartmentDto createDto() {
        Department sampleDepartment = createDepartment()
        return new DepartmentDto(
                id: sampleDepartment.id,
                name: sampleDepartment.name,
                description: sampleDepartment.description
                )
    }
    
    @Before
    public void setup() {
        departmentRepository = mock(DepartmentRepository.class);
        facultyService = mock(FacultyService.class);
        staffService = mock(StaffService.class);
        
        departmentService = new DepartmentService(departmentRepository, facultyService, staffService);
        
        department = createDepartment()
        when(departmentRepository.findById(1)).thenReturn(new Optional(new Department()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        DepartmentService service = new DepartmentService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<Department> result = departmentService.findAll();
        verify(departmentRepository, times(1)).findAll()
        verifyNoMoreInteractions(departmentRepository)
    }
    
    @Test
    public void testFindById() {
        Department result = departmentService.findById(1);
        verify(departmentRepository, times(1)).findById(1)
        verifyNoMoreInteractions(departmentRepository)
    }
    
    @Test
    public void testFindByHeadOfDepartment() {
        List<Department> result = departmentService.findByfacultyId(2);
        verify(departmentRepository, times(1)).findByFaculty_Id(2)
        verifyNoMoreInteractions(departmentRepository)
    }
    
    @Test
    public void testSave() {
        department.id = null
        departmentService.save(department);
        verify(departmentRepository, times(1)).save(department)
        verifyNoMoreInteractions(departmentRepository)
    }
    
    @Test
    public void testFindByStaff() {
        Staff staff = new Staff(id: 11)
        List<Department> result = departmentService.findByHeadOfDepartment(staff);
        verify(departmentRepository, times(1)).findByHodOrHod2(staff, staff)
        verifyNoMoreInteractions(departmentRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<Department> savedDepartments = departmentService.saveDepartments([
            department,
            department
        ]);
        verify(departmentRepository, times(2)).save(department)
        verifyNoMoreInteractions(departmentRepository)
    }
    
    @Test
    public void testSaveDepartment() {
        departmentService.save(department);
        verify(departmentRepository, times(1)).save(department)
        verifyNoMoreInteractions(departmentRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        DepartmentDto dto = new DepartmentDto(id: 1, name: '123', description: 'Yes')
        departmentService.createFromDto(dto)
        verify(departmentRepository, times(1)).save(any(Department.class))
        verifyNoMoreInteractions(departmentRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithFacultyId() {
        DepartmentDto dto = createDto()
        dto.facultyId = 1
        when(facultyService.findById(dto.facultyId)).thenReturn(null);
        departmentService.createFromDto(dto)
        verify(departmentRepository, times(1)).save(any(Department.class))
        verifyNoMoreInteractions(departmentRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithHodId() {
        DepartmentDto dto = createDto()
        dto.hodId = 1
        when(staffService.findById(dto.hodId)).thenReturn(null);
        departmentService.createFromDto(dto)
        verify(departmentRepository, times(1)).save(any(Department.class))
        verifyNoMoreInteractions(departmentRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithHod2Id() {
        DepartmentDto dto = createDto()
        dto.hod2Id = 1
        when(staffService.findById(dto.hod2Id)).thenReturn(null);
        departmentService.createFromDto(dto)
        verify(departmentRepository, times(1)).save(any(Department.class))
        verifyNoMoreInteractions(departmentRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create departmentDto from null object.")
        DepartmentDto dto = null
        departmentService.createFromDto(dto)
        verifyNoMoreInteractions(departmentRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoNullFaculty() {
        DepartmentDto dto = new DepartmentDto(id: 1, name: '123', description: 'Yes')
        dto.facultyId = null
        dto.hod2Id = null
        dto.hodId = null
        departmentService.updateFromDto(dto)
        verify(departmentRepository, times(1)).findById(department.id)
        verify(departmentRepository, times(1)).save(any(Department.class))
        verifyNoMoreInteractions(departmentRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update Department from null object.")
        DepartmentDto dto = new DepartmentDto(name: '123', description: 'Yes')
        departmentService.updateFromDto(dto)
        verifyNoMoreInteractions(departmentRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithFacultyId() {
        DepartmentDto dto = createDto()
        dto.facultyId = 1
        when(facultyService.findById(dto.facultyId)).thenReturn(null);
        // Initialise Test
        departmentService.updateFromDto(dto)
        // Verify Results
        verify(facultyService, times(1)).findById(dto.facultyId)
        verifyNoMoreInteractions(facultyService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithHodId() {
        DepartmentDto dto = createDto()
        dto.hodId = 1
        when(staffService.findById(dto.hodId)).thenReturn(null);
        // Initialise Test
        departmentService.updateFromDto(dto)
        // Verify Results
        verify(staffService, times(1)).findById(dto.hodId)
        verifyNoMoreInteractions(staffService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithHod2Id() {
        DepartmentDto dto = createDto()
        dto.hod2Id = 1
        when(staffService.findById(dto.hod2Id)).thenReturn(null);
        // Initialise Test
        departmentService.updateFromDto(dto)
        // Verify Results
        verify(staffService, times(1)).findById(dto.hod2Id)
        verifyNoMoreInteractions(staffService)
    }
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        departmentService.delete(department)
        verifyNoMoreInteractions(departmentRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}
