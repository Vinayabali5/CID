package uk.ac.reigate.services

import static org.mockito.Mockito.*
import static org.junit.Assert.assertNotNull
import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.Mockito

import uk.ac.reigate.domain.ilr.LLDDHealthProblemCategory;
import uk.ac.reigate.dto.LLDDHealthProblemCategoryDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.LLDDHealthProblemCategoryRepository


class LLDDHealthProblemCategoryServiceTest {
    
    private LLDDHealthProblemCategoryRepository lLDDHealthProblemCategoryRepository;
    
    private LLDDHealthProblemCategoryService lLDDHealthProblemCategoryService;
    
    private LLDDHealthProblemCategory lLDDHealthProblemCategory
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    @Before
    public void setup() {
        this.lLDDHealthProblemCategoryRepository = Mockito.mock(LLDDHealthProblemCategoryRepository.class)
        this.lLDDHealthProblemCategoryService = new LLDDHealthProblemCategoryService(lLDDHealthProblemCategoryRepository);
        
        lLDDHealthProblemCategory = new LLDDHealthProblemCategory(
                id: 1,
                code: 'N',
                description: 'New',
                shortDescription: 'New',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/11/11'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2016/11/11')
                )
        
        when(lLDDHealthProblemCategoryRepository.findById(1)).thenReturn(new Optional(lLDDHealthProblemCategory));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        LLDDHealthProblemCategoryService service = new LLDDHealthProblemCategoryService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindLLDDHealthProblemCategories() {
        List<LLDDHealthProblemCategory> result = lLDDHealthProblemCategoryService.findAll();
        verify(lLDDHealthProblemCategoryRepository, times(1)).findAll()
        verifyNoMoreInteractions(lLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testFindByCode() {
        LLDDHealthProblemCategory result = lLDDHealthProblemCategoryService.findByCode('Test');
        verify(lLDDHealthProblemCategoryRepository, times(1)).findByCode('Test')
        verifyNoMoreInteractions(lLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testFindLLDDHealthProblemCategory() {
        LLDDHealthProblemCategory result = lLDDHealthProblemCategoryService.findById(1);
        verify(lLDDHealthProblemCategoryRepository, times(1)).findById(1)
        verifyNoMoreInteractions(lLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testSaveNewLLDDHealthProblemCategory() {
        LLDDHealthProblemCategory savedLLDDHealthProblemCategory = lLDDHealthProblemCategoryService.save(lLDDHealthProblemCategory);
        verify(lLDDHealthProblemCategoryRepository, times(1)).save(any())
        verifyNoMoreInteractions(lLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testSaveLLDDHealthProblemCategory() {
        LLDDHealthProblemCategory savedLLDDHealthProblemCategory = lLDDHealthProblemCategoryService.save(lLDDHealthProblemCategory);
        verify(lLDDHealthProblemCategoryRepository, times(1)).save(any())
        verifyNoMoreInteractions(lLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testSaveLLDDHealthProblemCategories() {
        List<LLDDHealthProblemCategory> savedLLDDHealthProblemCategories = lLDDHealthProblemCategoryService.saveLLDDHealthProblemCategories([
            new LLDDHealthProblemCategory(id: 1),
            new LLDDHealthProblemCategory(id: 2)
        ]);
        verify(lLDDHealthProblemCategoryRepository, times(2)).save(any(LLDDHealthProblemCategory.class))
        verifyNoMoreInteractions(lLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testSaveLLDDHealthProblemCategoryByFields() {
        LLDDHealthProblemCategory savedLLDDHealthProblemCategory = lLDDHealthProblemCategoryService.save(lLDDHealthProblemCategory);
        verify(lLDDHealthProblemCategoryRepository, times(1)).save(any())
        verifyNoMoreInteractions(lLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        LLDDHealthProblemCategoryDto dto = new LLDDHealthProblemCategoryDto(id: 1, code: 'A')
        lLDDHealthProblemCategoryService.createFromDto(dto)
        verify(lLDDHealthProblemCategoryRepository, times(1)).save(any(LLDDHealthProblemCategory.class))
        verifyNoMoreInteractions(lLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create lLDDHealthProblemCategory from null object.")
        LLDDHealthProblemCategoryDto dto = null
        lLDDHealthProblemCategoryService.createFromDto(dto)
        verifyNoMoreInteractions(lLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        LLDDHealthProblemCategoryDto dto = new LLDDHealthProblemCategoryDto(id: 1, code: 'A')
        lLDDHealthProblemCategoryService.updateFromDto(dto)
        verify(lLDDHealthProblemCategoryRepository, times(1)).findById(lLDDHealthProblemCategory.id)
        verify(lLDDHealthProblemCategoryRepository, times(1)).save(any(LLDDHealthProblemCategory.class))
        verifyNoMoreInteractions(lLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update lLDDHealthProblemCategory from null object.")
        LLDDHealthProblemCategoryDto dto = null
        lLDDHealthProblemCategoryService.updateFromDto(dto)
        verifyNoMoreInteractions(lLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullIdDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update lLDDHealthProblemCategory when the id is null.")
        LLDDHealthProblemCategoryDto dto = new LLDDHealthProblemCategoryDto(code: 'A')
        lLDDHealthProblemCategoryService.updateFromDto(dto)
        verifyNoMoreInteractions(lLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullId() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update lLDDHealthProblemCategory when the id is null.")
        LLDDHealthProblemCategoryDto dto = new LLDDHealthProblemCategoryDto(code: '123')
        lLDDHealthProblemCategoryService.updateFromDto(dto)
        verifyNoMoreInteractions(lLDDHealthProblemCategoryRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("LLDDHealthProblemCategory should not be deleted")
        lLDDHealthProblemCategoryService.delete(new LLDDHealthProblemCategory(id: 1))
    }
}

