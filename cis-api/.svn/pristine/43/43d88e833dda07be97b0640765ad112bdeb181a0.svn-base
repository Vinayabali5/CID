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

import uk.ac.reigate.domain.academic.CareersRecordType
import uk.ac.reigate.dto.careers.CareersRecordTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.CareersRecordTypeRepository

class CareersRecordTypeServiceTest {
    
    @Mock
    private CareersRecordTypeRepository careersRecordTypeRepository;
    
    @InjectMocks
    private CareersRecordTypeService careersRecordTypeService;
    
    private CareersRecordType careersRecordType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample CareersRecordType data object to use for the testing
     * 
     * @return a sample CareersRecordType data object
     */
    CareersRecordType createCareersRecordType() {
        return new CareersRecordType(
                id: 1,
                code: 'F',
                description: 'Test'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample CareersRecordType created at setup
     * 
     * @return a CareersRecordTypeDto object based on the sample CareersRecordType
     */
    CareersRecordTypeDto createDto() {
        return new CareersRecordTypeDto(
                id: careersRecordType.id,
                code: careersRecordType.code,
                description: careersRecordType.description
                )
    }
    
    /**
     * This method is used to set up the tests for the CareersRecordTypeService
     */
    @Before
    public void setup() {
        this.careersRecordTypeRepository = Mockito.mock(CareersRecordTypeRepository.class);
        this.careersRecordTypeService = new CareersRecordTypeService(careersRecordTypeRepository);
        
        careersRecordType = createCareersRecordType()
        
        when(careersRecordTypeRepository.save(any(CareersRecordType.class))).thenReturn(careersRecordType);
        when(careersRecordTypeRepository.findById(1)).thenReturn(new Optional(careersRecordType));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        CareersRecordTypeService service = new CareersRecordTypeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<CareersRecordType> result = careersRecordTypeService.findAll();
        verify(careersRecordTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(careersRecordTypeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        CareersRecordType result = careersRecordTypeService.findById(1);
        verify(careersRecordTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(careersRecordTypeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        CareersRecordType savedCareersRecordType = careersRecordTypeService.save(careersRecordType);
        verify(careersRecordTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(careersRecordTypeRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<CareersRecordType> savedCareersRecordTypes = careersRecordTypeService.saveCareersRecordTypes([
            careersRecordType,
            careersRecordType
        ]);
        verify(careersRecordTypeRepository, times(2)).save(careersRecordType)
        verifyNoMoreInteractions(careersRecordTypeRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        CareersRecordTypeDto dto = createDto()
        CareersRecordType careersRecordTypeSaved = careersRecordTypeService.createFromDto(dto)
        verify(careersRecordTypeRepository, times(1)).save(any(CareersRecordType.class))
        verifyNoMoreInteractions(careersRecordTypeRepository)
        assertEquals(dto.id, careersRecordType.id)
        assertEquals(dto.code, careersRecordType.code)
        assertEquals(dto.description, careersRecordType.description)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create careersRecordTypeDto from null object.")
        CareersRecordTypeDto dto = null
        careersRecordTypeService.createFromDto(dto)
        verifyNoMoreInteractions(careersRecordTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        CareersRecordTypeDto dto = createDto()
        CareersRecordType careersRecordTypeSaved = careersRecordTypeService.updateFromDto(dto)
        verify(careersRecordTypeRepository, times(1)).findById(careersRecordType.id)
        verify(careersRecordTypeRepository, times(1)).save(careersRecordType)
        verifyNoMoreInteractions(careersRecordTypeRepository)
        assertEquals(careersRecordType.id, careersRecordTypeSaved.id)
        assertEquals(careersRecordType.code, careersRecordTypeSaved.code)
        assertEquals(careersRecordType.description, careersRecordTypeSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        CareersRecordTypeDto dto = createDto()
        CareersRecordType careersRecordTypeSaved = careersRecordTypeService.updateFromDto(dto)
        verify(careersRecordTypeRepository, times(1)).findById(careersRecordType.id)
        verify(careersRecordTypeRepository, times(1)).save(careersRecordType)
        verifyNoMoreInteractions(careersRecordTypeRepository)
        assertEquals(careersRecordType.id, careersRecordTypeSaved.id)
        assertEquals(careersRecordType.code, careersRecordTypeSaved.code)
        assertEquals(careersRecordType.description, careersRecordTypeSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update careersRecordTypeDto from null object.")
        CareersRecordTypeDto dto = null
        careersRecordTypeService.updateFromDto(dto)
        verifyNoMoreInteractions(careersRecordTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        careersRecordTypeService.delete(careersRecordType)
        verifyNoMoreInteractions(careersRecordTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}