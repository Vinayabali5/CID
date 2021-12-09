package uk.ac.reigate.services.ilp

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.Mockito

import uk.ac.reigate.domain.ilp.StudentRelatedStaff;
import uk.ac.reigate.domain.ilp.StudentRelatedStaffPk
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilp.StudentRelatedStaffRepository


class StudentRelatedStaffServiceTest {
    
    private StudentRelatedStaffRepository studentRelatedStaffRepository
    
    private StudentRelatedStaffService studentRelatedStaffService;
    
    private StudentRelatedStaff studentRelatedStaff
    
    private StudentRelatedStaffPk studentRelatedStaffPk
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    @Before
    public void setup() {
        this.studentRelatedStaffRepository = Mockito.mock(StudentRelatedStaffRepository.class);
        this.studentRelatedStaffService = new StudentRelatedStaffService(studentRelatedStaffRepository);
        
        // when(studentRelatedStaffRepository.findById(1)).thenReturn(new Optional(190001));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentRelatedStaffService service = new StudentRelatedStaffService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<StudentRelatedStaff> result = studentRelatedStaffService.findAll();
        verify(studentRelatedStaffRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentRelatedStaffRepository)
    }
    
    @Test
    public void testFindByDistinctStaffByStudentId() {
        List<StudentRelatedStaff> result = studentRelatedStaffService.findByDistinctStaffByStudentId(190001);
        verify(studentRelatedStaffRepository, times(1)).findDistinctStaffIdByStudent_Id(190001)
        verifyNoMoreInteractions(studentRelatedStaffRepository)
    }
    
    @Test
    public void testFindByStudentId() {
        List<StudentRelatedStaff> result = studentRelatedStaffService.findByStudentId(190001);
        verify(studentRelatedStaffRepository, times(1)).findByStudent_Id(190001)
        verifyNoMoreInteractions(studentRelatedStaffRepository)
    }
    
    @Test
    public void testFindById() {
        StudentRelatedStaff result = studentRelatedStaffService.findById(190001);
        verifyNoMoreInteractions(studentRelatedStaffRepository)
    }
    
    @Test
    public void testSave() {
        StudentRelatedStaff savedStudentRelatedStaff = studentRelatedStaffService.save(studentRelatedStaff);
        verify(studentRelatedStaffRepository, times(1)).save(any())
        verifyNoMoreInteractions(studentRelatedStaffRepository)
    }
    
    @Test
    public void testSaveStudentRelatedStaff() {
        StudentRelatedStaff savedStudentRelatedStaff = studentRelatedStaffService.save(studentRelatedStaff);
        verify(studentRelatedStaffRepository, times(1)).save(any())
        verifyNoMoreInteractions(studentRelatedStaffRepository)
    }
    
    @Test
    public void testDelete() {
        studentRelatedStaffService.delete(studentRelatedStaff)
        verifyNoMoreInteractions(studentRelatedStaffRepository)
    }
}

