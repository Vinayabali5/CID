package uk.ac.reigate.services

import static org.mockito.Mockito.*
import static org.junit.Assert.assertNotNull
import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.Mockito

import uk.ac.reigate.domain.ilp.LetterType;
import uk.ac.reigate.dto.ilp.LetterTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilp.LetterTypeRepository


class LetterTypeServiceTest {
    
    private LetterTypeRepository letterTypeRepository
    
    private LetterTypeService letterTypeService;
    
    private LetterType letterType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Before
    public void setup() {
        this.letterTypeRepository = Mockito.mock(LetterTypeRepository.class);
        this.letterTypeService = new LetterTypeService(letterTypeRepository);
        
        letterType = new LetterType(
                id: 1,
                type: 'A'
                )
        
        when(letterTypeRepository.findById(1)).thenReturn(new Optional(letterType));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        LetterTypeService service = new LetterTypeService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindLetterTypes() {
        List<LetterType> result = letterTypeService.findAll();
        verify(letterTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(letterTypeRepository)
    }
    
    @Test
    public void testFindLetterType() {
        LetterType result = letterTypeService.findById(1);
        verify(letterTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(letterTypeRepository)
    }
    
    @Test
    public void testSaveNewLetterType() {
        LetterType savedLetterType = letterTypeService.save(letterType);
        verify(letterTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(letterTypeRepository)
    }
    
    @Test
    public void testSaveLetterType() {
        LetterType savedLetterType = letterTypeService.save(letterType);
        verify(letterTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(letterTypeRepository)
    }
    
    @Test
    public void testSaveLetterTypes() {
        List<LetterType> savedLetterTypes = letterTypeService.saveLetterTypes([
            new LetterType(id: 1),
            new LetterType(id: 2)
        ]);
        verify(letterTypeRepository, times(2)).save(any(LetterType.class))
        verifyNoMoreInteractions(letterTypeRepository)
    }
    
    @Test
    public void testSaveLetterTypeByFields() {
        LetterType savedLetterType = letterTypeService.save(letterType);
        verify(letterTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(letterTypeRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        LetterTypeDto dto = new LetterTypeDto(id: 1, type: 'A')
        letterTypeService.createFromDto(dto)
        verify(letterTypeRepository, times(1)).save(any(LetterType.class))
        verifyNoMoreInteractions(letterTypeRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        LetterTypeDto dto = new LetterTypeDto(id: 1, type: 'A')
        letterTypeService.updateFromDto(dto)
        verify(letterTypeRepository, times(1)).findById(letterType.id)
        verify(letterTypeRepository, times(1)).save(letterType)
        verifyNoMoreInteractions(letterTypeRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create letterTypeDto from null object.")
        LetterTypeDto dto = null
        letterTypeService.createFromDto(dto)
        verifyNoMoreInteractions(letterTypeRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update letterTypeDto from null object.")
        LetterTypeDto dto = null
        letterTypeService.updateFromDto(dto)
        verifyNoMoreInteractions(letterTypeRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        letterTypeService.delete(letterType)
        verifyNoMoreInteractions(letterTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}

