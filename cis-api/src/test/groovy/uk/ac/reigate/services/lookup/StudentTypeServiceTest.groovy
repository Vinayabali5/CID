package uk.ac.reigate.services.lookup

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

import uk.ac.reigate.domain.lookup.StudentType
import uk.ac.reigate.dto.lookup.StudentTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.StudentTypeRepository


class StudentTypeServiceTest {
    
    @Mock
    private StudentTypeRepository studentTypeRepository;
    
    @InjectMocks
    private StudentTypeService studentTypeService;
    
    private StudentType studentType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample StudentType data object to use for the testing
     * 
     * @return a sample StudentType data object
     */
    StudentType createStudentType() {
        return new StudentType(
                id: 1,
                code: 'A',
                description: 'Active'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample StudentType created at setup
     * 
     * @return a StudentTypeDto object based on the sample StudentType
     */
    StudentTypeDto createDto() {
        return new StudentTypeDto(
                id: studentType.id,
                code: studentType.code,
                description: studentType.description
                )
    }
    
    /**
     * This method is used to set up the tests for the StudentTypeService
     */
    @Before
    public void setup() {
        this.studentTypeRepository = Mockito.mock(StudentTypeRepository.class);
        this.studentTypeService = new StudentTypeService(studentTypeRepository);
        
        studentType = createStudentType()
        
        when(studentTypeRepository.save(any(StudentType.class))).thenReturn(studentType);
        when(studentTypeRepository.findById(1)).thenReturn(new Optional(studentType));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentTypeService service = new StudentTypeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<StudentType> result = studentTypeService.findAll();
        verify(studentTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentTypeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        StudentType result = studentTypeService.findById(1);
        verify(studentTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(studentTypeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        StudentType savedStudentType = studentTypeService.save(studentType);
        verify(studentTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(studentTypeRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<StudentType> savedStudentTypes = studentTypeService.saveStudentTypes([studentType, studentType]);
        verify(studentTypeRepository, times(2)).save(studentType)
        verifyNoMoreInteractions(studentTypeRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        StudentTypeDto dto = createDto()
        StudentType studentTypeSaved = studentTypeService.createFromDto(dto)
        verify(studentTypeRepository, times(1)).save(any(StudentType.class))
        verifyNoMoreInteractions(studentTypeRepository)
        assertEquals(dto.id, studentType.id)
        assertEquals(dto.code, studentType.code)
        assertEquals(dto.description, studentType.description)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create studentType from null object.")
        StudentTypeDto dto = null
        studentTypeService.createFromDto(dto)
        verifyNoMoreInteractions(studentTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        StudentTypeDto dto = createDto()
        StudentType studentTypeSaved = studentTypeService.updateFromDto(dto)
        verify(studentTypeRepository, times(1)).findById(studentType.id)
        verify(studentTypeRepository, times(1)).save(studentType)
        verifyNoMoreInteractions(studentTypeRepository)
        assertEquals(studentType.id, studentTypeSaved.id)
        assertEquals(studentType.code, studentTypeSaved.code)
        assertEquals(studentType.description, studentTypeSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        StudentTypeDto dto = createDto()
        dto.code = null
        dto.description = null
        StudentType studentTypeSaved = studentTypeService.updateFromDto(dto)
        verify(studentTypeRepository, times(1)).findById(studentType.id)
        verify(studentTypeRepository, times(1)).save(studentType)
        verifyNoMoreInteractions(studentTypeRepository)
        assertEquals(studentType.id, studentTypeSaved.id)
        assertEquals(studentType.code, studentTypeSaved.code)
        assertEquals(studentType.description, studentTypeSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update studentType from null object.")
        StudentTypeDto dto = null
        studentTypeService.updateFromDto(dto)
        verifyNoMoreInteractions(studentTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        studentTypeService.delete(studentType)
        verifyNoMoreInteractions(studentTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}