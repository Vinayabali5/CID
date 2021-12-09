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
import uk.ac.reigate.domain.learning_support.StudentLLDDHealthProblemCategory
import uk.ac.reigate.dto.StudentLLDDHealthProblemCategoryDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.learning_support.StudentLLDDHealthProblemCategoryRepository
import uk.ac.reigate.services.LLDDHealthProblemCategoryService


public class StudentLLDDHealthProblemCategoryServiceTest {
    
    @Mock
    private StudentLLDDHealthProblemCategoryRepository studentLLDDHealthProblemCategoryRepository;
    
    @Mock
    private StudentService studentService;
    
    @Mock
    private LLDDHealthProblemCategoryService lLDDHealthProblemCategoryService;
    
    @InjectMocks
    private StudentLLDDHealthProblemCategoryService studentLLDDHealthProblemCategoryService;
    
    private StudentLLDDHealthProblemCategory studentLLDDHealthProblemCategory
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    StudentLLDDHealthProblemCategory createStudentLLDDHealthProblemCategory() {
        return new StudentLLDDHealthProblemCategory(
                id: 1,
                primarylldd: true
                )
    }
    
    StudentLLDDHealthProblemCategoryDto createDto() {
        StudentLLDDHealthProblemCategory sampleStudentLLDDHealthProblemCategory = createStudentLLDDHealthProblemCategory()
        return new StudentLLDDHealthProblemCategoryDto(
                id: sampleStudentLLDDHealthProblemCategory.id,
                primarylldd: sampleStudentLLDDHealthProblemCategory.primarylldd
                )
    }
    
    @Before
    public void setup() {
        studentLLDDHealthProblemCategoryRepository = mock(StudentLLDDHealthProblemCategoryRepository.class);
        studentService = mock(StudentService.class);
        lLDDHealthProblemCategoryService = mock(LLDDHealthProblemCategoryService.class);
        
        studentLLDDHealthProblemCategoryService = new StudentLLDDHealthProblemCategoryService(studentLLDDHealthProblemCategoryRepository, studentService, lLDDHealthProblemCategoryService);
        
        studentLLDDHealthProblemCategory = createStudentLLDDHealthProblemCategory()
        when(studentLLDDHealthProblemCategoryRepository.findById(1)).thenReturn(new Optional(new StudentLLDDHealthProblemCategory()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentLLDDHealthProblemCategoryService service = new StudentLLDDHealthProblemCategoryService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<StudentLLDDHealthProblemCategory> result = studentLLDDHealthProblemCategoryService.findAll();
        verify(studentLLDDHealthProblemCategoryRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentLLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testGetByStudent() {
        List<StudentLLDDHealthProblemCategory> result = studentLLDDHealthProblemCategoryService.getByStudentId(190001);
        verify(studentLLDDHealthProblemCategoryRepository, times(1)).findByStudent_Id(190001)
        verifyNoMoreInteractions(studentLLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testFindById() {
        StudentLLDDHealthProblemCategory result = studentLLDDHealthProblemCategoryService.findById(1);
        verify(studentLLDDHealthProblemCategoryRepository, times(1)).findById(1)
        verifyNoMoreInteractions(studentLLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testGetByStudentLLDDHealthProblemCategorys() {
        Student student = new Student(id:190001)
        List<StudentLLDDHealthProblemCategory> result = studentLLDDHealthProblemCategoryService.getByStudent(student);
        verify(studentLLDDHealthProblemCategoryRepository, times(1)).findByStudent(student)
        verifyNoMoreInteractions(studentLLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testSave() {
        studentLLDDHealthProblemCategory.id = null
        studentLLDDHealthProblemCategoryService.save(studentLLDDHealthProblemCategory);
        verify(studentLLDDHealthProblemCategoryRepository, times(1)).save(studentLLDDHealthProblemCategory)
        verifyNoMoreInteractions(studentLLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testSaveStudentLLDDHealthProblemCategory() {
        studentLLDDHealthProblemCategoryService.save(studentLLDDHealthProblemCategory);
        verify(studentLLDDHealthProblemCategoryRepository, times(1)).save(studentLLDDHealthProblemCategory)
        verifyNoMoreInteractions(studentLLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        StudentLLDDHealthProblemCategoryDto dto = createDto()
        studentLLDDHealthProblemCategoryService.createFromDto(dto)
        verify(studentLLDDHealthProblemCategoryRepository, times(1)).save(any(StudentLLDDHealthProblemCategory.class))
        verifyNoMoreInteractions(studentLLDDHealthProblemCategoryRepository)
    }
    
    
    @Test
    public void testCreateFromDto_dtoWithStudentId() {
        StudentLLDDHealthProblemCategoryDto dto = createDto()
        dto.studentId = 1
        when(studentService.findById(dto.studentId)).thenReturn(null);
        studentLLDDHealthProblemCategoryService.createFromDto(dto)
        verify(studentLLDDHealthProblemCategoryRepository, times(1)).save(any(StudentLLDDHealthProblemCategory.class))
        verifyNoMoreInteractions(studentLLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithEntryQualificationId() {
        StudentLLDDHealthProblemCategoryDto dto = createDto()
        dto.lLDDHealthProblemCategoryId = 1
        when(lLDDHealthProblemCategoryService.findById(dto.lLDDHealthProblemCategoryId)).thenReturn(null);
        studentLLDDHealthProblemCategoryService.createFromDto(dto)
        verify(studentLLDDHealthProblemCategoryRepository, times(1)).save(any(StudentLLDDHealthProblemCategory.class))
        verifyNoMoreInteractions(studentLLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithEntryQualificationId() {
        StudentLLDDHealthProblemCategoryDto dto = createDto()
        dto.lLDDHealthProblemCategoryId = 1
        when(lLDDHealthProblemCategoryService.findById(dto.lLDDHealthProblemCategoryId)).thenReturn(null);
        studentLLDDHealthProblemCategoryService.updateFromDto(dto)
        verify(lLDDHealthProblemCategoryService, times(1)).findById(dto.lLDDHealthProblemCategoryId)
        verifyNoMoreInteractions(lLDDHealthProblemCategoryService)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create studentLLDDHealthProblemCategoryDto from null object.")
        StudentLLDDHealthProblemCategoryDto dto = null
        studentLLDDHealthProblemCategoryService.createFromDto(dto)
        verifyNoMoreInteractions(studentLLDDHealthProblemCategoryRepository)
    }
    
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update studentLLDDHealthProblemCategoryDto from null object.")
        StudentLLDDHealthProblemCategoryDto dto = null
        studentLLDDHealthProblemCategoryService.updateFromDto(dto)
        verifyNoMoreInteractions(studentLLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithStudentId() {
        StudentLLDDHealthProblemCategoryDto dto = createDto()
        dto.studentId = 1
        when(studentService.findById(dto.studentId)).thenReturn(null);
        // Initialise Test
        studentLLDDHealthProblemCategoryService.updateFromDto(dto)
        // Verify Results
        verify(studentService, times(1)).findById(dto.studentId)
        verifyNoMoreInteractions(studentService)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        studentLLDDHealthProblemCategoryService.delete(studentLLDDHealthProblemCategory)
        verify(studentLLDDHealthProblemCategoryRepository, times(1)).delete(studentLLDDHealthProblemCategory)
        verifyNoMoreInteractions(studentLLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testDeleteById() {
        studentLLDDHealthProblemCategoryService.delete(1)
        verify(studentLLDDHealthProblemCategoryRepository, times(1)).deleteById(1)
        verifyNoMoreInteractions(studentLLDDHealthProblemCategoryRepository)
    }
}
