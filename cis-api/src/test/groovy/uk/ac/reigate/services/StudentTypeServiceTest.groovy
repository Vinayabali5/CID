package uk.ac.reigate.services

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

import uk.ac.reigate.domain.lookup.StudentType
import uk.ac.reigate.repositories.lookup.StudentTypeRepository
import uk.ac.reigate.services.lookup.StudentTypeService

import static org.mockito.Mockito.*


class StudentTypeServiceTest {
    
    private StudentTypeRepository studentTypeRepository;
    
    private StudentTypeService studentTypeService;
    
    StudentType studentType1
    StudentType studentType2
    
    @Before
    public void setup() {
        this.studentTypeRepository = Mockito.mock(StudentTypeRepository.class);
        this.studentTypeService = new StudentTypeService(studentTypeRepository);
        
        studentType1 = new StudentType(id: 1, code: 'A', description: 'A StudentType')
        studentType2 = new StudentType(id: 2, code: 'C', description: 'C StudentType')
        
        when(studentTypeRepository.findAll()).thenReturn([studentType1, studentType2]);
        when(studentTypeRepository.findById(1)).thenReturn(new Optional(studentType1));
        when(studentTypeRepository.findById(null)).thenThrow(new IllegalArgumentException());
        when(studentTypeRepository.save(any(StudentType.class))).thenReturn(studentType1);
    }
    
    @Test
    public void testFindStudentTypes() {
        List<StudentType> result = studentTypeService.findAll();
        verify(studentTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentTypeRepository)
    }
    
    @Test
    public void testFindStudentType() {
        StudentType result = studentTypeService.findById(1);
        verify(studentTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(studentTypeRepository)
    }
    
    @Test
    public void testSaveNewStudentType() {
        StudentType savedStudentType = studentTypeService.save(studentType1);
        verify(studentTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(studentTypeRepository)
    }
    
    @Test
    public void testSaveStudentType() {
        StudentType savedStudentType = studentTypeService.save(studentType1);
        verify(studentTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(studentTypeRepository)
    }
    
    @Test
    public void testSaveStudentTypes() {
        List<StudentType> savedStudentTypes = studentTypeService.saveStudentTypes([studentType1, studentType2]);
        verify(studentTypeRepository, times(2)).save(any(StudentType.class))
        verifyNoMoreInteractions(studentTypeRepository)
    }
    
    @Test
    public void testSaveStudentTypeByFields_WithNullId() {
        StudentType savedStudentType = studentTypeService.save(studentType1);
        verify(studentTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(studentTypeRepository)
    }
}

