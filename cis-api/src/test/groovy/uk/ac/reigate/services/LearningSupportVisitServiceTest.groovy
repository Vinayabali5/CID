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

import uk.ac.reigate.domain.learning_support.LearningSupportVisit
import uk.ac.reigate.dto.LearningSupportVisitDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.learning_support.LearningSupportVisitRepository
import uk.ac.reigate.services.student.StudentService


class LearningSupportVisitServiceTest {
    
    @Mock
    private LearningSupportVisitRepository learningSupportVisitRepository;
    
    @Mock
    private StudentService studentService;
    
    @Mock
    private StaffService staffService
    
    @InjectMocks
    private LearningSupportVisitService learningSupportVisitService;
    
    private LearningSupportVisit learningSupportVisit
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample LearningSupportVisit data object to use for the testing
     * 
     * @return a sample LearningSupportVisit data object
     */
    LearningSupportVisit createLearningSupportVisit() {
        return new LearningSupportVisit(
                id: 1,
                details: 'Test',
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample LearningSupportVisit created at setup
     * 
     * @return a LearningSupportVisitDto object based on the sample LearningSupportVisit
     */
    LearningSupportVisitDto createDto() {
        LearningSupportVisit sampleData = createLearningSupportVisit()
        return new LearningSupportVisitDto(
                id: sampleData.id,
                details: sampleData.details
                )
    }
    
    /**
     * This method is used to set up the tests for the LearningSupportVisitService
     */
    @Before
    public void setup() {
        learningSupportVisitRepository = mock(LearningSupportVisitRepository.class);
        studentService = mock(StudentService.class)
        staffService = mock(StaffService.class)
        learningSupportVisitService = new LearningSupportVisitService(learningSupportVisitRepository, studentService, staffService);
        
        learningSupportVisit = createLearningSupportVisit()
        
        when(learningSupportVisitRepository.findById(1)).thenReturn(new Optional(new LearningSupportVisit()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        LearningSupportVisitService service = new LearningSupportVisitService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<LearningSupportVisit> result = learningSupportVisitService.findAll();
        verify(learningSupportVisitRepository, times(1)).findAll()
        verifyNoMoreInteractions(learningSupportVisitRepository)
    }
    
    @Test
    public void testStudentById() {
        List<LearningSupportVisit> result = learningSupportVisitService.findByStudentId(190001);
        verify(learningSupportVisitRepository, times(1)).findByStudent_Id(190001)
        verifyNoMoreInteractions(learningSupportVisitRepository)
    }
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        LearningSupportVisit result = learningSupportVisitService.findById(1);
        verify(learningSupportVisitRepository, times(1)).findById(1)
        verifyNoMoreInteractions(learningSupportVisitRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        LearningSupportVisit savedLearningSupportVisit = learningSupportVisitService.save(learningSupportVisit);
        verify(learningSupportVisitRepository, times(1)).save(any())
        verifyNoMoreInteractions(learningSupportVisitRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<LearningSupportVisit> savedLearningSupportVisits = learningSupportVisitService.saveLearningSupportVisits([
            learningSupportVisit,
            learningSupportVisit
        ]);
        verify(learningSupportVisitRepository, times(2)).save(learningSupportVisit)
        verifyNoMoreInteractions(learningSupportVisitRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        LearningSupportVisitDto dto = createDto()
        LearningSupportVisit learningSupportVisitSaved = learningSupportVisitService.createFromDto(dto)
        verify(learningSupportVisitRepository, times(1)).save(any(LearningSupportVisit.class))
        verifyNoMoreInteractions(learningSupportVisitRepository)
        assertEquals(dto.id, learningSupportVisit.id)
    }
    
    @Test
    public void testCreateFromDto_dtoWithStudentId() {
        LearningSupportVisitDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        LearningSupportVisit learningSupportVisitSaved = learningSupportVisitService.createFromDto(dto)
        verify(learningSupportVisitRepository, times(1)).save(any(LearningSupportVisit.class))
        verifyNoMoreInteractions(learningSupportVisitRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create learningSupportVisitDto from null object.")
        LearningSupportVisitDto dto = null
        learningSupportVisitService.createFromDto(dto)
        verifyNoMoreInteractions(learningSupportVisitRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        LearningSupportVisitDto dto = createDto()
        LearningSupportVisit learningSupportVisitSaved = learningSupportVisitService.updateFromDto(dto)
        verify(learningSupportVisitRepository, times(1)).findById(learningSupportVisit.id)
        verify(learningSupportVisitRepository, times(1)).save(any(LearningSupportVisit.class))
        verifyNoMoreInteractions(learningSupportVisitRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithStudentId() {
        LearningSupportVisitDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        LearningSupportVisit learningSupportVisitSaved = learningSupportVisitService.updateFromDto(dto)
        verify(studentService, times(1)).findById(dto.studentId)
        verifyNoMoreInteractions(studentService)
    }
    
    @Test
    public void testUpdateFromDto_withNullId() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update learningSupportVisitDto from null Id.")
        LearningSupportVisitDto dto = new LearningSupportVisitDto(duration: '1')
        learningSupportVisitService.updateFromDto(dto)
        verifyNoMoreInteractions(learningSupportVisitRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update learningSupportVisitDto from null object.")
        LearningSupportVisitDto dto = null
        learningSupportVisitService.updateFromDto(dto)
        verifyNoMoreInteractions(learningSupportVisitRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        learningSupportVisitService.delete(learningSupportVisit)
        verifyNoMoreInteractions(learningSupportVisitRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}