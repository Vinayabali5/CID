package uk.ac.reigate.services.lookup

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

import uk.ac.reigate.domain.lookup.LegalSex
import uk.ac.reigate.dto.lookup.LegalSexDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.LegalSexRepository


class LegalSexServiceTest {
    
    @Mock
    private LegalSexRepository legalSexRepository;
    
    @InjectMocks
    private LegalSexService legalSexService;
    
    private LegalSex legalSex
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample LegalSex data object to use for the testing
     * 
     * @return a sample LegalSex data object
     */
    LegalSex createLegalSex() {
        return new LegalSex(
                id: 1,
                code: 'F',
                description: 'Female'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample LegalSex created at setup
     * 
     * @return a LegalSexDto object based on the sample LegalSex
     */
    LegalSexDto createDto() {
        return new LegalSexDto(
                id: legalSex.id,
                code: legalSex.code,
                description: legalSex.description
                )
    }
    
    /**
     * This method is used to set up the tests for the LegalSexService
     */
    @Before
    public void setup() {
        this.legalSexRepository = Mockito.mock(LegalSexRepository.class);
        this.legalSexService = new LegalSexService(legalSexRepository);
        
        legalSex = createLegalSex()
        
        when(legalSexRepository.save(any(LegalSex.class))).thenReturn(legalSex);
        when(legalSexRepository.findById(1)).thenReturn(new Optional(legalSex));
        when(legalSexRepository.findByCode(legalSex.code)).thenReturn(legalSex);
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        LegalSexService service = new LegalSexService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<LegalSex> result = legalSexService.findAll();
        verify(legalSexRepository, times(1)).findAll()
        verifyNoMoreInteractions(legalSexRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        LegalSex result = legalSexService.findById(1);
        verify(legalSexRepository, times(1)).findById(1)
        verifyNoMoreInteractions(legalSexRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        LegalSex savedLegalSex = legalSexService.save(legalSex);
        verify(legalSexRepository, times(1)).save(any())
        verifyNoMoreInteractions(legalSexRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<LegalSex> savedLegalSexs = legalSexService.saveLegalSexs([legalSex, legalSex]);
        verify(legalSexRepository, times(2)).save(legalSex)
        verifyNoMoreInteractions(legalSexRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        LegalSexDto dto = createDto()
        LegalSex legalSexSaved = legalSexService.createFromDto(dto)
        verify(legalSexRepository, times(1)).save(any(LegalSex.class))
        verifyNoMoreInteractions(legalSexRepository)
        assertEquals(dto.id, legalSex.id)
        assertEquals(dto.code, legalSex.code)
        assertEquals(dto.description, legalSex.description)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create legalSex from null object.")
        LegalSexDto dto = null
        legalSexService.createFromDto(dto)
        verifyNoMoreInteractions(legalSexRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        LegalSexDto dto = createDto()
        LegalSex legalSexSaved = legalSexService.updateFromDto(dto)
        verify(legalSexRepository, times(1)).findById(legalSex.id)
        verify(legalSexRepository, times(1)).save(legalSex)
        verifyNoMoreInteractions(legalSexRepository)
        assertEquals(legalSex.id, legalSexSaved.id)
        assertEquals(legalSex.code, legalSexSaved.code)
        assertEquals(legalSex.description, legalSexSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        LegalSexDto dto = createDto()
        dto.code = null
        dto.description = null
        LegalSex legalSexSaved = legalSexService.updateFromDto(dto)
        verify(legalSexRepository, times(1)).findById(legalSex.id)
        verify(legalSexRepository, times(1)).save(legalSex)
        verifyNoMoreInteractions(legalSexRepository)
        assertEquals(legalSex.id, legalSexSaved.id)
        assertEquals(legalSex.code, legalSexSaved.code)
        assertEquals(legalSex.description, legalSexSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update legalSex from null object.")
        LegalSexDto dto = null
        legalSexService.updateFromDto(dto)
        verifyNoMoreInteractions(legalSexRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        legalSexService.delete(legalSex)
        verifyNoMoreInteractions(legalSexRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the findByDescription service method
     */
    @Test
    public void testFindByDescription() {
        LegalSex result = legalSexService.findByCode(legalSex.code)
        verify(legalSexRepository, times(1)).findByCode(legalSex.code)
        verifyNoMoreInteractions(legalSexRepository)
    }
}

