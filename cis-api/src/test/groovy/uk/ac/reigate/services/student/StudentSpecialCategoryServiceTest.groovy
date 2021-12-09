package uk.ac.reigate.services.student;

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.learning_support.StudentSpecialCategory
import uk.ac.reigate.dto.StudentSpecialCategoryDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.learning_support.StudentSpecialCategoryRepository
import uk.ac.reigate.services.SpecialCategoryService
import uk.ac.reigate.services.StaffService

public class StudentSpecialCategoryServiceTest {
    
    @Mock
    private StudentSpecialCategoryRepository studentSpecialCategoryRepository;
    
    @Mock
    private SpecialCategoryService specialCategoryService;
    
    @Mock
    private StaffService staffService;
    
    @Mock
    private StudentService studentService
    
    @InjectMocks
    private StudentSpecialCategoryService studentSpecialCategoryService;
    
    private StudentSpecialCategory studentSpecialCategory
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    StudentSpecialCategory createStudentSpecialCategory() {
        return new StudentSpecialCategory(
                id: 1,
                specialConfirmed: true
                )
    }
    
    StudentSpecialCategoryDto createDto() {
        StudentSpecialCategory sampleStudentSpecialCategory = createStudentSpecialCategory()
        return new StudentSpecialCategoryDto(
                id: sampleStudentSpecialCategory.id,
                specialConfirmed: sampleStudentSpecialCategory.specialConfirmed
                )
    }
    
    @Before
    public void setup() {
        studentSpecialCategoryRepository = mock(StudentSpecialCategoryRepository.class);
        specialCategoryService = mock(SpecialCategoryService.class);
        staffService = mock(StaffService.class);
        studentService = mock(StudentService.class);
        
        studentSpecialCategoryService = new StudentSpecialCategoryService(studentSpecialCategoryRepository, specialCategoryService, staffService, studentService);
        
        studentSpecialCategory = createStudentSpecialCategory()
        when(studentSpecialCategoryRepository.findById(1)).thenReturn(new Optional(new StudentSpecialCategory()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentSpecialCategoryService service = new StudentSpecialCategoryService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<StudentSpecialCategory> result = studentSpecialCategoryService.findAll();
        verify(studentSpecialCategoryRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentSpecialCategoryRepository)
    }
    
    @Test
    public void testFindById() {
        StudentSpecialCategory result = studentSpecialCategoryService.findById(1);
        verify(studentSpecialCategoryRepository, times(1)).findById(1)
        verifyNoMoreInteractions(studentSpecialCategoryRepository)
    }
    
    @Test
    public void testGetByStudent() {
        List<StudentSpecialCategory> result = studentSpecialCategoryService.getByStudent(19001);
        verify(studentSpecialCategoryRepository, times(1)).findByStudent_Id(19001)
        verifyNoMoreInteractions(studentSpecialCategoryRepository)
    }
    
    @Test
    public void testSave() {
        studentSpecialCategory.id = null
        studentSpecialCategoryService.save(studentSpecialCategory);
        verify(studentSpecialCategoryRepository, times(1)).save(studentSpecialCategory)
        verifyNoMoreInteractions(studentSpecialCategoryRepository)
    }
    
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<StudentSpecialCategory> savedStudentSpecialCategorys = studentSpecialCategoryService.saveStudentSpecialCategorys([
            studentSpecialCategory,
            studentSpecialCategory
        ]);
        verify(studentSpecialCategoryRepository, times(2)).save(studentSpecialCategory)
        verifyNoMoreInteractions(studentSpecialCategoryRepository)
    }
    
    @Test
    public void testSaveStudentSpecialCategory() {
        studentSpecialCategoryService.save(studentSpecialCategory);
        verify(studentSpecialCategoryRepository, times(1)).save(studentSpecialCategory)
        verifyNoMoreInteractions(studentSpecialCategoryRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        StudentSpecialCategoryDto dto = createDto()
        studentSpecialCategoryService.createFromDto(dto)
        verify(studentSpecialCategoryRepository, times(1)).save(any(StudentSpecialCategory.class))
        verifyNoMoreInteractions(studentSpecialCategoryRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithSpecialCategoryId() {
        StudentSpecialCategoryDto dto = createDto()
        dto.specialCategoryId = 1
        when(specialCategoryService.findById(dto.specialCategoryId)).thenReturn(null);
        studentSpecialCategoryService.createFromDto(dto)
        verify(studentSpecialCategoryRepository, times(1)).save(any(StudentSpecialCategory.class))
        verifyNoMoreInteractions(studentSpecialCategoryRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithStudentId() {
        StudentSpecialCategoryDto dto = createDto()
        dto.studentId = 1
        when(studentService.findById(dto.studentId)).thenReturn(null);
        studentSpecialCategoryService.createFromDto(dto)
        verify(studentSpecialCategoryRepository, times(1)).save(any(StudentSpecialCategory.class))
        verifyNoMoreInteractions(studentSpecialCategoryRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithStaffRequestingId() {
        StudentSpecialCategoryDto dto = createDto()
        dto.staffRequestingId = 1
        when(staffService.findById(dto.staffRequestingId)).thenReturn(null);
        studentSpecialCategoryService.createFromDto(dto)
        verify(studentSpecialCategoryRepository, times(1)).save(any(StudentSpecialCategory.class))
        verifyNoMoreInteractions(studentSpecialCategoryRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithRiskAssessmentToBeCompletedId() {
        StudentSpecialCategoryDto dto = createDto()
        dto.riskAssessmentToBeCompletedById = 1
        when(staffService.findById(dto.riskAssessmentToBeCompletedById)).thenReturn(null);
        studentSpecialCategoryService.createFromDto(dto)
        verify(studentSpecialCategoryRepository, times(1)).save(any(StudentSpecialCategory.class))
        verifyNoMoreInteractions(studentSpecialCategoryRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithStaffConcernedId() {
        StudentSpecialCategoryDto dto = createDto()
        dto.staffConcernedId = 1
        when(staffService.findById(dto.staffConcernedId)).thenReturn(null);
        studentSpecialCategoryService.createFromDto(dto)
        verify(studentSpecialCategoryRepository, times(1)).save(any(StudentSpecialCategory.class))
        verifyNoMoreInteractions(studentSpecialCategoryRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithriskAssessmentRaisedById() {
        StudentSpecialCategoryDto dto = createDto()
        dto.riskAssessmentRaisedById = 1
        when(staffService.findById(dto.riskAssessmentRaisedById)).thenReturn(null);
        studentSpecialCategoryService.createFromDto(dto)
        verify(studentSpecialCategoryRepository, times(1)).save(any(StudentSpecialCategory.class))
        verifyNoMoreInteractions(studentSpecialCategoryRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithRiskAssessmentCarriedOutById() {
        StudentSpecialCategoryDto dto = createDto()
        dto.riskAssessmentCarriedOutById = 1
        when(staffService.findById(dto.riskAssessmentCarriedOutById)).thenReturn(null);
        studentSpecialCategoryService.createFromDto(dto)
        verify(studentSpecialCategoryRepository, times(1)).save(any(StudentSpecialCategory.class))
        verifyNoMoreInteractions(studentSpecialCategoryRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create studentSpecialCategoryDto from null object.")
        StudentSpecialCategoryDto dto = null
        studentSpecialCategoryService.createFromDto(dto)
        verifyNoMoreInteractions(studentSpecialCategoryRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update studentSpecialCategoryDto from null object.")
        StudentSpecialCategoryDto dto = null
        studentSpecialCategoryService.updateFromDto(dto)
        verifyNoMoreInteractions(studentSpecialCategoryRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithSpecialCategoryId() {
        StudentSpecialCategoryDto dto = createDto()
        dto.specialCategoryId = 1
        when(specialCategoryService.findById(dto.specialCategoryId)).thenReturn(null);
        // Initialise Test
        studentSpecialCategoryService.updateFromDto(dto)
        // Verify Results
        verify(specialCategoryService, times(1)).findById(dto.specialCategoryId)
        verifyNoMoreInteractions(specialCategoryService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithStudentId() {
        StudentSpecialCategoryDto dto = createDto()
        dto.studentId = 1
        when(studentService.findById(dto.studentId)).thenReturn(null);
        // Initialise Test
        studentSpecialCategoryService.updateFromDto(dto)
        // Verify Results
        verify(studentService, times(1)).findById(dto.studentId)
        verifyNoMoreInteractions(studentService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithStaffConcernedId() {
        StudentSpecialCategoryDto dto = createDto()
        dto.staffConcernedId = 1
        when(staffService.findById(dto.staffConcernedId)).thenReturn(null);
        // Initialise Test
        studentSpecialCategoryService.updateFromDto(dto)
        // Verify Results
        verify(staffService, times(1)).findById(dto.staffConcernedId)
        verifyNoMoreInteractions(staffService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithRiskAssessmentCarriedOutById() {
        StudentSpecialCategoryDto dto = createDto()
        dto.riskAssessmentCarriedOutById = 1
        when(staffService.findById(dto.riskAssessmentCarriedOutById)).thenReturn(null);
        // Initialise Test
        studentSpecialCategoryService.updateFromDto(dto)
        // Verify Results
        verify(staffService, times(1)).findById(dto.riskAssessmentCarriedOutById)
        verifyNoMoreInteractions(staffService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithRiskAssessmentRaisedById() {
        StudentSpecialCategoryDto dto = createDto()
        dto.riskAssessmentRaisedById = 1
        when(staffService.findById(dto.riskAssessmentRaisedById)).thenReturn(null);
        // Initialise Test
        studentSpecialCategoryService.updateFromDto(dto)
        // Verify Results
        verify(staffService, times(1)).findById(dto.riskAssessmentRaisedById)
        verifyNoMoreInteractions(staffService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithRiskAssessmentToBeCompletedById() {
        StudentSpecialCategoryDto dto = createDto()
        dto.riskAssessmentToBeCompletedById = 1
        when(staffService.findById(dto.riskAssessmentToBeCompletedById)).thenReturn(null);
        // Initialise Test
        studentSpecialCategoryService.updateFromDto(dto)
        // Verify Results
        verify(staffService, times(1)).findById(dto.riskAssessmentToBeCompletedById)
        verifyNoMoreInteractions(staffService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithstaffRequestingId() {
        StudentSpecialCategoryDto dto = createDto()
        dto.staffRequestingId = 1
        when(staffService.findById(dto.staffRequestingId)).thenReturn(null);
        // Initialise Test
        studentSpecialCategoryService.updateFromDto(dto)
        // Verify Results
        verify(staffService, times(1)).findById(dto.staffRequestingId)
        verifyNoMoreInteractions(staffService)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        studentSpecialCategoryService.delete(studentSpecialCategory)
        verifyNoMoreInteractions(studentSpecialCategoryRepository)
    }
}
