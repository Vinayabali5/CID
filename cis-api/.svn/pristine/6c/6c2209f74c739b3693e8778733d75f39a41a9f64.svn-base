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

import uk.ac.reigate.domain.academic.SpecialCategory
import uk.ac.reigate.dto.SpecialCategoryDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.SpecialCategoryRepository


class SpecialCategoryServiceTest {
    
    @Mock
    private SpecialCategoryRepository specialCategoryRepository;
    
    @InjectMocks
    private SpecialCategoryService specialCategoryService;
    
    private SpecialCategory specialCategory
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample SpecialCategory data object to use for the testing
     * 
     * @return a sample SpecialCategory data object
     */
    SpecialCategory createSpecialCategory() {
        return new SpecialCategory(
                id: 1,
                code: '1',
                description: 'SpecialCategory 1'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample SpecialCategory created at setup
     * 
     * @return a SpecialCategoryDto object based on the sample SpecialCategory
     */
    SpecialCategoryDto createDto() {
        return new SpecialCategoryDto(
                id: specialCategory.id,
                code: specialCategory.code,
                description: specialCategory.description
                )
    }
    
    /**
     * This method is used to set up the tests for the SpecialCategoryService
     */
    @Before
    public void setup() {
        this.specialCategoryRepository = Mockito.mock(SpecialCategoryRepository.class);
        this.specialCategoryService = new SpecialCategoryService(specialCategoryRepository);
        
        specialCategory = createSpecialCategory()
        
        when(specialCategoryRepository.save(any(SpecialCategory.class))).thenReturn(specialCategory);
        when(specialCategoryRepository.findById(1)).thenReturn(new Optional(specialCategory));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        SpecialCategoryService service = new SpecialCategoryService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<SpecialCategory> result = specialCategoryService.findAll();
        verify(specialCategoryRepository, times(1)).findAll()
        verifyNoMoreInteractions(specialCategoryRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        SpecialCategory result = specialCategoryService.findById(1);
        verify(specialCategoryRepository, times(1)).findById(1)
        verifyNoMoreInteractions(specialCategoryRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        SpecialCategory savedSpecialCategory = specialCategoryService.save(specialCategory);
        verify(specialCategoryRepository, times(1)).save(any())
        verifyNoMoreInteractions(specialCategoryRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<SpecialCategory> savedSpecialCategorys = specialCategoryService.saveSpecialCategories([
            specialCategory,
            specialCategory
        ]);
        verify(specialCategoryRepository, times(2)).save(specialCategory)
        verifyNoMoreInteractions(specialCategoryRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        SpecialCategoryDto dto = createDto()
        SpecialCategory specialCategorySaved = specialCategoryService.createFromDto(dto)
        verify(specialCategoryRepository, times(1)).save(any(SpecialCategory.class))
        verifyNoMoreInteractions(specialCategoryRepository)
        assertEquals(dto.id, specialCategory.id)
        assertEquals(dto.code, specialCategory.code)
        assertEquals(dto.description, specialCategory.description)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create specialCategoryDto from null object.")
        SpecialCategoryDto dto = null
        specialCategoryService.createFromDto(dto)
        verifyNoMoreInteractions(specialCategoryRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        SpecialCategoryDto dto = createDto()
        SpecialCategory specialCategorySaved = specialCategoryService.updateFromDto(dto)
        verify(specialCategoryRepository, times(1)).findById(specialCategory.id)
        verify(specialCategoryRepository, times(1)).save(specialCategory)
        verifyNoMoreInteractions(specialCategoryRepository)
        assertEquals(specialCategory.id, specialCategorySaved.id)
        assertEquals(specialCategory.code, specialCategorySaved.code)
        assertEquals(specialCategory.description, specialCategorySaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        SpecialCategoryDto dto = createDto()
        SpecialCategory specialCategorySaved = specialCategoryService.updateFromDto(dto)
        verify(specialCategoryRepository, times(1)).findById(specialCategory.id)
        verify(specialCategoryRepository, times(1)).save(specialCategory)
        verifyNoMoreInteractions(specialCategoryRepository)
        assertEquals(specialCategory.id, specialCategorySaved.id)
        assertEquals(specialCategory.code, specialCategorySaved.code)
        assertEquals(specialCategory.description, specialCategorySaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update specialCategoryDto from null object.")
        SpecialCategoryDto dto = null
        specialCategoryService.updateFromDto(dto)
        verifyNoMoreInteractions(specialCategoryRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        specialCategoryService.delete(specialCategory)
        verifyNoMoreInteractions(specialCategoryRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}