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

import uk.ac.reigate.domain.lookup.BursaryType
import uk.ac.reigate.dto.lookup.BursaryTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.BursaryTypeRepository


class BursaryTypeServiceTest {
    
    @Mock
    private BursaryTypeRepository bursaryTypeRepository;
    
    @InjectMocks
    private BursaryTypeService bursaryTypeService;
    
    private BursaryType bursaryType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample BursaryType data object to use for the testing
     * 
     * @return a sample BursaryType data object
     */
    BursaryType createBursaryType() {
        return new BursaryType(
                id: 1,
                code: 'F',
                description: 'Free meals'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample BursaryType created at setup
     * 
     * @return a BursaryTypeDto object based on the sample BursaryType
     */
    BursaryTypeDto createDto() {
        return new BursaryTypeDto(
                id: bursaryType.id,
                code: bursaryType.code,
                description: bursaryType.description
                )
    }
    
    /**
     * This method is used to set up the tests for the BursaryTypeService
     */
    @Before
    public void setup() {
        this.bursaryTypeRepository = Mockito.mock(BursaryTypeRepository.class);
        this.bursaryTypeService = new BursaryTypeService(bursaryTypeRepository);
        
        bursaryType = createBursaryType()
        
        when(bursaryTypeRepository.save(any(BursaryType.class))).thenReturn(bursaryType);
        when(bursaryTypeRepository.findById(1)).thenReturn(new Optional(bursaryType));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        BursaryTypeService service = new BursaryTypeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<BursaryType> result = bursaryTypeService.findAll();
        verify(bursaryTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(bursaryTypeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        BursaryType result = bursaryTypeService.findById(1);
        verify(bursaryTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(bursaryTypeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        BursaryType savedBursaryType = bursaryTypeService.save(bursaryType);
        verify(bursaryTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(bursaryTypeRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<BursaryType> savedBursaryTypes = bursaryTypeService.saveBursaryTypes([bursaryType, bursaryType]);
        verify(bursaryTypeRepository, times(2)).save(bursaryType)
        verifyNoMoreInteractions(bursaryTypeRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        BursaryTypeDto dto = createDto()
        BursaryType bursaryTypeSaved = bursaryTypeService.createFromDto(dto)
        verify(bursaryTypeRepository, times(1)).save(any(BursaryType.class))
        verifyNoMoreInteractions(bursaryTypeRepository)
        assertEquals(dto.id, bursaryType.id)
        assertEquals(dto.code, bursaryType.code)
        assertEquals(dto.description, bursaryType.description)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create bursaryType from null object.")
        BursaryTypeDto dto = null
        bursaryTypeService.createFromDto(dto)
        verifyNoMoreInteractions(bursaryTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        BursaryTypeDto dto = createDto()
        BursaryType bursaryTypeSaved = bursaryTypeService.updateFromDto(dto)
        verify(bursaryTypeRepository, times(1)).findById(bursaryType.id)
        verify(bursaryTypeRepository, times(1)).save(bursaryType)
        verifyNoMoreInteractions(bursaryTypeRepository)
        assertEquals(bursaryType.id, bursaryTypeSaved.id)
        assertEquals(bursaryType.code, bursaryTypeSaved.code)
        assertEquals(bursaryType.description, bursaryTypeSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        BursaryTypeDto dto = createDto()
        BursaryType bursaryTypeSaved = bursaryTypeService.updateFromDto(dto)
        verify(bursaryTypeRepository, times(1)).findById(bursaryType.id)
        verify(bursaryTypeRepository, times(1)).save(bursaryType)
        verifyNoMoreInteractions(bursaryTypeRepository)
        assertEquals(bursaryType.id, bursaryTypeSaved.id)
        assertEquals(bursaryType.code, bursaryTypeSaved.code)
        assertEquals(bursaryType.description, bursaryTypeSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update bursaryType from null object.")
        BursaryTypeDto dto = null
        bursaryTypeService.updateFromDto(dto)
        verifyNoMoreInteractions(bursaryTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        bursaryTypeService.delete(bursaryType)
        verifyNoMoreInteractions(bursaryTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}