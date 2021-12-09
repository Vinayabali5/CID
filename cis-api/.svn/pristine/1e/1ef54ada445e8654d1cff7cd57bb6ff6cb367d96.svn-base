package uk.ac.reigate.services.student

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

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.learning_support.ConcessionType
import uk.ac.reigate.domain.learning_support.StudentConcessionType
import uk.ac.reigate.domain.learning_support.StudentConcessionTypePk
import uk.ac.reigate.dto.StudentConcessionTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.learning_support.StudentConcessionTypeRepository


class StudentConcessionTypeServiceTest {
    
    @Mock
    private StudentConcessionTypeRepository studentConcessionTypeRepository;
    
    @InjectMocks
    private StudentConcessionTypeService studentConcessionTypeService;
    
    private StudentConcessionType studentConcessionType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to set up the tests for the StudentConcessionTypeService
     */
    @Before
    public void setup() {
        this.studentConcessionTypeRepository = Mockito.mock(StudentConcessionTypeRepository.class);
        this.studentConcessionTypeService = new StudentConcessionTypeService(studentConcessionTypeRepository);
        
        //  when(studentConcessionTypeRepository.findById(1)).thenReturn(new Optional(new StudentConcessionType()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentConcessionTypeService service = new StudentConcessionTypeService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<StudentConcessionType> result = studentConcessionTypeService.findAll();
        verify(studentConcessionTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentConcessionTypeRepository)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testGetByStudent() {
        List<StudentConcessionType> result = studentConcessionTypeService.getByStudent(19001);
        verify(studentConcessionTypeRepository, times(1)).findByStudent_Id(19001)
        verifyNoMoreInteractions(studentConcessionTypeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    //@Test
    public void testFindById() {
        StudentConcessionTypePk studentConcessionTypePk = new StudentConcessionTypePk(student: new Student(id:19001), concessionType:new ConcessionType(id: 1))
        StudentConcessionType result = studentConcessionTypeService.findById(studentConcessionTypePk);
        verify(studentConcessionTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(studentConcessionTypeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        StudentConcessionType savedStudentConcessionType = studentConcessionTypeService.save(studentConcessionType);
        verify(studentConcessionTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(studentConcessionTypeRepository)
    }
    
    
}

