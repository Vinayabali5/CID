package uk.ac.reigate.services.admissions

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

import uk.ac.reigate.domain.admissions.InterviewCategory
import uk.ac.reigate.dto.admissions.InterviewCategoryDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.admissions.InterviewCategoryRepository


class InterviewCategoryServiceTest {
    
    @Mock
    private InterviewCategoryRepository interviewCategoryRepository;
    
    @InjectMocks
    private InterviewCategoryService interviewCategoryService;
    
    private InterviewCategory interviewCategory
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample InterviewCategory data object to use for the testing
     * 
     * @return a sample InterviewCategory data object
     */
    InterviewCategory createInterviewCategory() {
        return new InterviewCategory(
                id: 1,
                category: 'Admissions',
                description: 'Admissions Interview'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample InterviewCategory created at setup
     * 
     * @return a InterviewCategoryDto object based on the sample InterviewCategory
     */
    InterviewCategoryDto createDto() {
        return new InterviewCategoryDto(
                id: interviewCategory.id,
                category: interviewCategory.category,
                description: interviewCategory.description
                )
    }
    
    /**
     * This method is used to set up the tests for the InterviewCategoryService
     */
    @Before
    public void setup() {
        this.interviewCategoryRepository = Mockito.mock(InterviewCategoryRepository.class);
        this.interviewCategoryService = new InterviewCategoryService(interviewCategoryRepository);
        
        interviewCategory = createInterviewCategory()
        
        when(interviewCategoryRepository.save(any(InterviewCategory.class))).thenReturn(interviewCategory);
        when(interviewCategoryRepository.findById(1)).thenReturn(new Optional(interviewCategory));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        InterviewCategoryService service = new InterviewCategoryService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<InterviewCategory> result = interviewCategoryService.findAll();
        verify(interviewCategoryRepository, times(1)).findAll()
        verifyNoMoreInteractions(interviewCategoryRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        InterviewCategory result = interviewCategoryService.findById(1);
        verify(interviewCategoryRepository, times(1)).findById(1)
        verifyNoMoreInteractions(interviewCategoryRepository)
    }
    
    /**
     * This method is used to test the findByDescription service method
     */
    @Test
    public void testFindByDescription() {
        InterviewCategory result = interviewCategoryService.findByDescription('test');
        verify(interviewCategoryRepository, times(1)).findByDescription('test')
        verifyNoMoreInteractions(interviewCategoryRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        InterviewCategory savedInterviewCategory = interviewCategoryService.save(interviewCategory);
        verify(interviewCategoryRepository, times(1)).save(any())
        verifyNoMoreInteractions(interviewCategoryRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<InterviewCategory> savedInterviewCategorys = interviewCategoryService.saveList([
            interviewCategory,
            interviewCategory
        ]);
        verify(interviewCategoryRepository, times(2)).save(interviewCategory)
        verifyNoMoreInteractions(interviewCategoryRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        InterviewCategoryDto dto = createDto()
        InterviewCategory interviewCategorySaved = interviewCategoryService.createFromDto(dto)
        verify(interviewCategoryRepository, times(1)).save(any(InterviewCategory.class))
        verifyNoMoreInteractions(interviewCategoryRepository)
        assertEquals(dto.id, interviewCategory.id)
        assertEquals(dto.category, interviewCategory.category)
        assertEquals(dto.description, interviewCategory.description)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create interviewCategoryDto from null object.")
        InterviewCategoryDto dto = null
        interviewCategoryService.createFromDto(dto)
        verifyNoMoreInteractions(interviewCategoryRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        InterviewCategoryDto dto = createDto()
        InterviewCategory interviewCategorySaved = interviewCategoryService.updateFromDto(dto)
        verify(interviewCategoryRepository, times(1)).findById(interviewCategory.id)
        verify(interviewCategoryRepository, times(1)).save(interviewCategory)
        verifyNoMoreInteractions(interviewCategoryRepository)
        assertEquals(interviewCategory.id, interviewCategorySaved.id)
        assertEquals(interviewCategory.category, interviewCategorySaved.category)
        assertEquals(interviewCategory.description, interviewCategorySaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        InterviewCategoryDto dto = createDto()
        InterviewCategory interviewCategorySaved = interviewCategoryService.updateFromDto(dto)
        verify(interviewCategoryRepository, times(1)).findById(interviewCategory.id)
        verify(interviewCategoryRepository, times(1)).save(interviewCategory)
        verifyNoMoreInteractions(interviewCategoryRepository)
        assertEquals(interviewCategory.id, interviewCategorySaved.id)
        assertEquals(interviewCategory.category, interviewCategorySaved.category)
        assertEquals(interviewCategory.description, interviewCategorySaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update interviewCategoryDto from null object.")
        InterviewCategoryDto dto = null
        interviewCategoryService.updateFromDto(dto)
        verifyNoMoreInteractions(interviewCategoryRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        interviewCategoryService.delete(interviewCategory)
        verifyNoMoreInteractions(interviewCategoryRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}