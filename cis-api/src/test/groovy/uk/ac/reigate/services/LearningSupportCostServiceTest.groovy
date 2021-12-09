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

import uk.ac.reigate.domain.learning_support.LearningSupportCost
import uk.ac.reigate.dto.LearningSupportCostDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.learning_support.LearningSupportCostRepository
import uk.ac.reigate.services.student.StudentService


class LearningSupportCostServiceTest {
    
    @Mock
    private LearningSupportCostRepository learningSupportCostRepository;
    
    @Mock
    private StudentService studentService;
    
    @Mock
    private LearningSupportCostCategoryService learningSupportCostCategoryService;
    
    @Mock
    private StaffService staffService
    
    @InjectMocks
    private LearningSupportCostService learningSupportCostService;
    
    private LearningSupportCost learningSupportCost
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample LearningSupportCost data object to use for the testing
     * 
     * @return a sample LearningSupportCost data object
     */
    LearningSupportCost createLearningSupportCost() {
        return new LearningSupportCost(
                id: 1,
                rate: 1.1,
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample LearningSupportCost created at setup
     * 
     * @return a LearningSupportCostDto object based on the sample LearningSupportCost
     */
    LearningSupportCostDto createDto() {
        LearningSupportCost sampleData = createLearningSupportCost()
        return new LearningSupportCostDto(
                id: sampleData.id,
                rate: sampleData.rate
                )
    }
    
    /**
     * This method is used to set up the tests for the LearningSupportCostService
     */
    @Before
    public void setup() {
        learningSupportCostRepository = mock(LearningSupportCostRepository.class);
        studentService = mock(StudentService.class)
        learningSupportCostCategoryService = mock(LearningSupportCostCategoryService.class)
        staffService = mock(StaffService.class);
        
        this.learningSupportCostService = new LearningSupportCostService(learningSupportCostRepository, studentService, learningSupportCostCategoryService, staffService);
        
        learningSupportCost = createLearningSupportCost()
        
        when(learningSupportCostRepository.findById(1)).thenReturn(new Optional(new LearningSupportCost()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        LearningSupportCostService service = new LearningSupportCostService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<LearningSupportCost> result = learningSupportCostService.findAll();
        verify(learningSupportCostRepository, times(1)).findAll()
        verifyNoMoreInteractions(learningSupportCostRepository)
    }
    
    @Test
    public void testStudentById() {
        List<LearningSupportCost> result = learningSupportCostService.findByStudentId(190001);
        verify(learningSupportCostRepository, times(1)).findByStudent_Id(190001)
        verifyNoMoreInteractions(learningSupportCostRepository)
    }
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        LearningSupportCost result = learningSupportCostService.findById(1);
        verify(learningSupportCostRepository, times(1)).findById(1)
        verifyNoMoreInteractions(learningSupportCostRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        LearningSupportCost savedLearningSupportCost = learningSupportCostService.save(learningSupportCost);
        verify(learningSupportCostRepository, times(1)).save(any())
        verifyNoMoreInteractions(learningSupportCostRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<LearningSupportCost> savedLearningSupportCosts = learningSupportCostService.saveLearningSupportCosts([
            learningSupportCost,
            learningSupportCost
        ]);
        verify(learningSupportCostRepository, times(2)).save(learningSupportCost)
        verifyNoMoreInteractions(learningSupportCostRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        LearningSupportCostDto dto = createDto()
        LearningSupportCost learningSupportCostSaved = learningSupportCostService.createFromDto(dto)
        verify(learningSupportCostRepository, times(1)).save(any(LearningSupportCost.class))
        verifyNoMoreInteractions(learningSupportCostRepository)
        assertEquals(dto.id, learningSupportCost.id)
    }
    
    @Test
    public void testCreateFromDto_withStudentId() {
        LearningSupportCostDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        LearningSupportCost learningSupportCostSaved = learningSupportCostService.createFromDto(dto)
        verify(learningSupportCostRepository, times(1)).save(any(LearningSupportCost.class))
        verifyNoMoreInteractions(learningSupportCostRepository)
    }
    
    @Test
    public void testCreateFromDto_withCostCategoryId() {
        LearningSupportCostDto dto = createDto()
        dto.costCategoryId = 19001
        when(learningSupportCostCategoryService.findById(dto.costCategoryId)).thenReturn(null);
        LearningSupportCost learningSupportCostSaved = learningSupportCostService.createFromDto(dto)
        verify(learningSupportCostRepository, times(1)).save(any(LearningSupportCost.class))
        verifyNoMoreInteractions(learningSupportCostRepository)
    }
    
    @Test
    public void testCreateFromDto_withStaffId() {
        LearningSupportCostDto dto = createDto()
        dto.staffId = 19001
        when(staffService.findById(dto.costCategoryId)).thenReturn(null);
        LearningSupportCost learningSupportCostSaved = learningSupportCostService.createFromDto(dto)
        verify(learningSupportCostRepository, times(1)).save(any(LearningSupportCost.class))
        verifyNoMoreInteractions(learningSupportCostRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create learningSupportCostDto from null object.")
        LearningSupportCostDto dto = null
        learningSupportCostService.createFromDto(dto)
        verifyNoMoreInteractions(learningSupportCostRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        LearningSupportCostDto dto = createDto()
        LearningSupportCost learningSupportCostSaved = learningSupportCostService.updateFromDto(dto)
        verify(learningSupportCostRepository, times(1)).findById(learningSupportCost.id)
        verify(learningSupportCostRepository, times(1)).save(any(LearningSupportCost.class))
        verifyNoMoreInteractions(learningSupportCostRepository)
    }
    
    @Test
    public void testUpdateFromDto_withStudentId() {
        LearningSupportCostDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        LearningSupportCost learningSupportCostSaved = learningSupportCostService.updateFromDto(dto)
        verify(studentService, times(1)).findById(dto.studentId)
        verifyNoMoreInteractions(studentService)
    }
    
    @Test
    public void testUpdateFromDto_withCostCategoryId() {
        LearningSupportCostDto dto = createDto()
        dto.costCategoryId = 19
        when(learningSupportCostCategoryService.findById(dto.costCategoryId)).thenReturn(null);
        LearningSupportCost learningSupportCostSaved = learningSupportCostService.updateFromDto(dto)
        verify(learningSupportCostCategoryService, times(1)).findById(dto.costCategoryId)
        verifyNoMoreInteractions(learningSupportCostCategoryService)
    }
    
    @Test
    public void testUpdateFromDto_withStaffId() {
        LearningSupportCostDto dto = createDto()
        dto.staffId = 1
        when(staffService.findById(dto.costCategoryId)).thenReturn(null);
        LearningSupportCost learningSupportCostSaved = learningSupportCostService.updateFromDto(dto)
        verify(staffService, times(1)).findById(dto.staffId)
        verifyNoMoreInteractions(staffService)
    }
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update learningSupportCostCategoryDto from null object.")
        LearningSupportCostDto dto = null
        learningSupportCostService.updateFromDto(dto)
        verifyNoMoreInteractions(learningSupportCostRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    @Test
    public void testUpdateFromDto_withNullId() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update learningSupportCostCategoryDto from null Id.")
        LearningSupportCostDto dto = new LearningSupportCostDto(rate:1.1)
        learningSupportCostService.updateFromDto(dto)
        verifyNoMoreInteractions(learningSupportCostRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        learningSupportCostService.delete(learningSupportCost)
        verifyNoMoreInteractions(learningSupportCostRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}