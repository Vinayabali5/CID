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

import uk.ac.reigate.domain.learning_support.SupportType
import uk.ac.reigate.dto.lookup.SupportTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.learning_support.SupportTypeRepository


class SupportTypeServiceTest {
    
    @Mock
    private SupportTypeRepository supportTypeRepository;
    
    @InjectMocks
    private SupportTypeService supportTypeService;
    
    private SupportType supportType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample SupportType data object to use for the testing
     * 
     * @return a sample SupportType data object
     */
    SupportType createSupportType() {
        return new SupportType(
                id: 1,
                support: 'Test'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample SupportType created at setup
     * 
     * @return a SupportTypeDto object based on the sample SupportType
     */
    SupportType createDto() {
        return new SupportType(
                id: supportType.id,
                support: supportType.support
                )
    }
    
    /**
     * This method is used to set up the tests for the SupportTypeService
     */
    @Before
    public void setup() {
        this.supportTypeRepository = Mockito.mock(SupportTypeRepository.class);
        this.supportTypeService = new SupportTypeService(supportTypeRepository);
        
        supportType = createSupportType()
        
        when(supportTypeRepository.save(any(SupportType.class))).thenReturn(supportType);
        when(supportTypeRepository.findById(1)).thenReturn(new Optional(supportType));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        SupportTypeService service = new SupportTypeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<SupportType> result = supportTypeService.findAll();
        verify(supportTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(supportTypeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        SupportType result = supportTypeService.findById(1);
        verify(supportTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(supportTypeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        SupportType savedSupportType = supportTypeService.save(supportType);
        verify(supportTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(supportTypeRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<SupportType> savedSupportTypes = supportTypeService.saveSupportTypes([supportType, supportType]);
        verify(supportTypeRepository, times(2)).save(supportType)
        verifyNoMoreInteractions(supportTypeRepository)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        SupportType dto = createDto()
        SupportType supportTypeSaved = supportTypeService.updateSupportType(dto)
        verify(supportTypeRepository, times(1)).findById(supportType.id)
        verify(supportTypeRepository, times(1)).save(supportType)
        verifyNoMoreInteractions(supportTypeRepository)
        assertEquals(supportType.id, supportTypeSaved.id)
        assertEquals(supportType.support, supportTypeSaved.support)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        SupportType dto = createDto()
        dto.support = null
        SupportType supportTypeSaved = supportTypeService.updateSupportType(dto)
        verify(supportTypeRepository, times(1)).findById(supportType.id)
        verify(supportTypeRepository, times(1)).save(supportType)
        verifyNoMoreInteractions(supportTypeRepository)
        assertEquals(supportType.id, supportTypeSaved.id)
        assertEquals(supportType.support, supportTypeSaved.support)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update supportType from null object.")
        SupportTypeDto dto = null
        supportTypeService.updateSupportType(dto)
        verifyNoMoreInteractions(supportTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        supportTypeService.delete(supportType)
        verifyNoMoreInteractions(supportTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}