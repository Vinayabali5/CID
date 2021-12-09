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

import uk.ac.reigate.domain.learning_support.LearningSupportCostCategory
import uk.ac.reigate.dto.LearningSupportCostCategoryDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.learning_support.LearningSupportCostCategoryRepository


class LearningSupportCostCategoryServiceTest {
    
    @Mock
    private LearningSupportCostCategoryRepository learningSupportCostCategoryRepository;
    
    @InjectMocks
    private LearningSupportCostCategoryService learningSupportCostCategoryService;
    
    private LearningSupportCostCategory learningSupportCostCategory
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample LearningSupportCostCategory data object to use for the testing
     * 
     * @return a sample LearningSupportCostCategory data object
     */
    LearningSupportCostCategory createLearningSupportCostCategory() {
        return new LearningSupportCostCategory(
                id: 1,
                category: 'N',
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample LearningSupportCostCategory created at setup
     * 
     * @return a LearningSupportCostCategoryDto object based on the sample LearningSupportCostCategory
     */
    LearningSupportCostCategoryDto createDto() {
        return new LearningSupportCostCategoryDto(
                id: learningSupportCostCategory.id,
                category: learningSupportCostCategory.category
                )
    }
    
    /**
     * This method is used to set up the tests for the LearningSupportCostCategoryService
     */
    @Before
    public void setup() {
        this.learningSupportCostCategoryRepository = Mockito.mock(LearningSupportCostCategoryRepository.class);
        this.learningSupportCostCategoryService = new LearningSupportCostCategoryService(learningSupportCostCategoryRepository);
        
        learningSupportCostCategory = createLearningSupportCostCategory()
        
        when(learningSupportCostCategoryRepository.save(any(LearningSupportCostCategory.class))).thenReturn(learningSupportCostCategory);
        when(learningSupportCostCategoryRepository.findById(1)).thenReturn(new Optional(learningSupportCostCategory));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        LearningSupportCostCategoryService service = new LearningSupportCostCategoryService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<LearningSupportCostCategory> result = learningSupportCostCategoryService.findAll();
        verify(learningSupportCostCategoryRepository, times(1)).findAll()
        verifyNoMoreInteractions(learningSupportCostCategoryRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        LearningSupportCostCategory result = learningSupportCostCategoryService.findById(1);
        verify(learningSupportCostCategoryRepository, times(1)).findById(1)
        verifyNoMoreInteractions(learningSupportCostCategoryRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        LearningSupportCostCategory savedLearningSupportCostCategory = learningSupportCostCategoryService.save(learningSupportCostCategory);
        verify(learningSupportCostCategoryRepository, times(1)).save(any())
        verifyNoMoreInteractions(learningSupportCostCategoryRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<LearningSupportCostCategory> savedLearningSupportCostCategorys = learningSupportCostCategoryService.saveLearningSupportCostCategorys([
            learningSupportCostCategory,
            learningSupportCostCategory
        ]);
        verify(learningSupportCostCategoryRepository, times(2)).save(learningSupportCostCategory)
        verifyNoMoreInteractions(learningSupportCostCategoryRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        LearningSupportCostCategoryDto dto = createDto()
        LearningSupportCostCategory learningSupportCostCategorySaved = learningSupportCostCategoryService.createFromDto(dto)
        verify(learningSupportCostCategoryRepository, times(1)).save(any(LearningSupportCostCategory.class))
        verifyNoMoreInteractions(learningSupportCostCategoryRepository)
        assertEquals(dto.id, learningSupportCostCategory.id)
        assertEquals(dto.category, learningSupportCostCategory.category)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create learningSupportCostCategoryDto from null object.")
        LearningSupportCostCategoryDto dto = null
        learningSupportCostCategoryService.createFromDto(dto)
        verifyNoMoreInteractions(learningSupportCostCategoryRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        LearningSupportCostCategoryDto dto = createDto()
        LearningSupportCostCategory learningSupportCostCategorySaved = learningSupportCostCategoryService.updateFromDto(dto)
        verify(learningSupportCostCategoryRepository, times(1)).findById(learningSupportCostCategory.id)
        verify(learningSupportCostCategoryRepository, times(1)).save(learningSupportCostCategory)
        verifyNoMoreInteractions(learningSupportCostCategoryRepository)
        assertEquals(learningSupportCostCategory.id, learningSupportCostCategorySaved.id)
        assertEquals(learningSupportCostCategory.category, learningSupportCostCategorySaved.category)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update learningSupportCostCategoryDto from null object.")
        LearningSupportCostCategoryDto dto = null
        learningSupportCostCategoryService.updateFromDto(dto)
        verifyNoMoreInteractions(learningSupportCostCategoryRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        learningSupportCostCategoryService.delete(learningSupportCostCategory)
        verifyNoMoreInteractions(learningSupportCostCategoryRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}