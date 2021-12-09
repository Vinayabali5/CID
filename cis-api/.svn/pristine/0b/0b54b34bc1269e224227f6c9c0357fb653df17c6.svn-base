package uk.ac.reigate.services.student;

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.lookup.StudentRemarkPermission
import uk.ac.reigate.dto.StudentRemarkPermissionDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.StudentRemarkPermissionRepository
import uk.ac.reigate.services.lookup.SupportTypeService


public class StudentRemarkPermissionServiceTest {
    
    @Mock
    private StudentRemarkPermissionRepository studentRemarkPermissionRepository;
    
    @InjectMocks
    private StudentRemarkPermissionService studentRemarkPermissionService;
    
    private StudentRemarkPermission studentRemarkPermission
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    StudentRemarkPermission createStudentRemarkPermission() {
        return new StudentRemarkPermission(
                id: 1,
                code: 'test',
                description:'testing'
                )
    }
    
    StudentRemarkPermissionDto createDto() {
        StudentRemarkPermission sampleStudentRemarkPermission = createStudentRemarkPermission()
        return new StudentRemarkPermissionDto(
                id: sampleStudentRemarkPermission.id,
                code: sampleStudentRemarkPermission.code,
                description:sampleStudentRemarkPermission.description
                )
    }
    
    @Before
    public void setup() {
        studentRemarkPermissionRepository = mock(StudentRemarkPermissionRepository.class);
        
        studentRemarkPermissionService = new StudentRemarkPermissionService(studentRemarkPermissionRepository);
        
        studentRemarkPermission = createStudentRemarkPermission()
        
        when(studentRemarkPermissionRepository.save(any(StudentRemarkPermission.class))).thenReturn(studentRemarkPermission);
        when(studentRemarkPermissionRepository.findById(studentRemarkPermission.id)).thenReturn(new Optional(studentRemarkPermission));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentRemarkPermissionService service = new StudentRemarkPermissionService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<StudentRemarkPermission> result = studentRemarkPermissionService.findAll();
        verify(studentRemarkPermissionRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentRemarkPermissionRepository)
    }
    
    @Test
    public void testFindById() {
        StudentRemarkPermission result = studentRemarkPermissionService.findById(1);
    }
    
    @Test
    public void testSave() {
        studentRemarkPermission.id = null
        studentRemarkPermissionService.save(studentRemarkPermission);
        verify(studentRemarkPermissionRepository, times(1)).save(studentRemarkPermission)
        verifyNoMoreInteractions(studentRemarkPermissionRepository)
    }
    
    @Test
    public void testSaveList() {
        List<StudentRemarkPermission> savedStudentRemarkPermissions = studentRemarkPermissionService.saveStudentRemarkPermissions([
            studentRemarkPermission,
            studentRemarkPermission
        ]);
        verify(studentRemarkPermissionRepository, times(2)).save(studentRemarkPermission)
        verifyNoMoreInteractions(studentRemarkPermissionRepository)
    }
    
    @Test
    public void testSaveStudentRemarkPermission() {
        studentRemarkPermissionService.save(studentRemarkPermission);
        verify(studentRemarkPermissionRepository, times(1)).save(studentRemarkPermission)
        verifyNoMoreInteractions(studentRemarkPermissionRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        StudentRemarkPermissionDto dto = createDto()
        studentRemarkPermissionService.createFromDto(dto)
        verify(studentRemarkPermissionRepository, times(1)).save(any(StudentRemarkPermission.class))
        verifyNoMoreInteractions(studentRemarkPermissionRepository)
    }
    
    @Test
    public void testCreateFromDto_Nulldto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create studentRemarkPermission from null object.")
        StudentRemarkPermissionDto dto = null
        studentRemarkPermissionService.createFromDto(dto)
        verify(studentRemarkPermissionRepository, times(1)).findById(dto.id)
        verifyNoMoreInteractions(studentRemarkPermissionRepository)
    }
    
    @Test
    public void testUpdateFromDto_Nulldto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update studentRemarkPermission from null object.")
        StudentRemarkPermissionDto dto = null
        studentRemarkPermissionService.updateFromDto(dto)
        verify(studentRemarkPermissionRepository, times(1)).findById(dto.id)
        verifyNoMoreInteractions(studentRemarkPermissionRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        StudentRemarkPermissionDto dto = createDto()
        studentRemarkPermissionService.updateFromDto(dto)
        verify(studentRemarkPermissionRepository, times(1)).findById(studentRemarkPermission.id)
        verify(studentRemarkPermissionRepository, times(1)).save(any(StudentRemarkPermission.class))
        verifyNoMoreInteractions(studentRemarkPermissionRepository)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("StudentRemarkPermission should not be deleted")
        studentRemarkPermissionService.delete(studentRemarkPermission)
    }
}
