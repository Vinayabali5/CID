package uk.ac.reigate.services.ilr

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import uk.ac.reigate.domain.ilr.AimType
import uk.ac.reigate.dto.ilr.AimTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.AimTypeRepository


class AimTypeServiceTest {
    
    @Mock
    private AimTypeRepository aimTypeRepository;
    
    @InjectMocks
    private AimTypeService aimTypeService;
    
    private AimType aimType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample AimType data object to use for the testing
     * 
     * @return a sample AimType data object
     */
    AimType createAimType() {
        return new AimType(
                id: 1,
                code: 'N',
                description: 'Aim Type',
                shortDescription: 'Test',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo : new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/19  '),
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample AimType created at setup
     * 
     * @return a AimTypeDto object based on the sample AimType
     */
    AimTypeDto createDto() {
        return new AimTypeDto(
                id: aimType.id,
                code: aimType.code,
                description: aimType.description,
                shortDescription: aimType.shortDescription,
                validFrom: aimType.validFrom,
                validTo: aimType.validTo
                )
    }
    
    /**
     * This method is used to set up the tests for the AimTypeService
     */
    @Before
    public void setup() {
        this.aimTypeRepository = Mockito.mock(AimTypeRepository.class);
        this.aimTypeService = new AimTypeService(aimTypeRepository);
        
        aimType = createAimType()
        
        when(aimTypeRepository.save(any(AimType.class))).thenReturn(aimType);
        when(aimTypeRepository.findById(1)).thenReturn(new Optional(aimType));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        AimTypeService service = new AimTypeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<AimType> result = aimTypeService.findAll();
        verify(aimTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(aimTypeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        AimType result = aimTypeService.findById(1);
        verify(aimTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(aimTypeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        AimType savedAimType = aimTypeService.save(aimType);
        verify(aimTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(aimTypeRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<AimType> savedAimTypes = aimTypeService.saveAimTypes([aimType, aimType]);
        verify(aimTypeRepository, times(2)).save(aimType)
        verifyNoMoreInteractions(aimTypeRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        AimTypeDto dto = createDto()
        AimType aimTypeSaved = aimTypeService.createFromDto(dto)
        verify(aimTypeRepository, times(1)).save(any(AimType.class))
        verifyNoMoreInteractions(aimTypeRepository)
        assertEquals(dto.id, aimType.id)
        assertEquals(dto.code, aimType.code)
        assertEquals(dto.description, aimType.description)
        assertEquals(dto.shortDescription, aimType.shortDescription)
        assertEquals(dto.validFrom, aimType.validFrom)
        assertEquals(dto.validTo, aimType.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dtoWithNullValues() {
        AimTypeDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        AimType aimTypeSaved = aimTypeService.createFromDto(dto)
        verify(aimTypeRepository, times(1)).save(any(AimType.class))
        verifyNoMoreInteractions(aimTypeRepository)
        assertEquals(aimType.id, aimTypeSaved.id)
        assertEquals(aimType.code, aimTypeSaved.code)
        assertEquals(aimType.description, aimTypeSaved.description)
        assertEquals(aimType.shortDescription, aimTypeSaved.shortDescription)
        assertEquals(aimType.validFrom, aimTypeSaved.validFrom)
        assertEquals(aimType.validTo, aimTypeSaved.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create AimType from null object.")
        AimTypeDto dto = null
        aimTypeService.createFromDto(dto)
        verifyNoMoreInteractions(aimTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        AimTypeDto dto = createDto()
        AimType aimTypeSaved = aimTypeService.updateFromDto(dto)
        verify(aimTypeRepository, times(1)).findById(aimType.id)
        verify(aimTypeRepository, times(1)).save(aimType)
        verifyNoMoreInteractions(aimTypeRepository)
        assertEquals(aimType.id, aimTypeSaved.id)
        assertEquals(aimType.code, aimTypeSaved.code)
        assertEquals(aimType.description, aimTypeSaved.description)
        assertEquals(aimType.shortDescription, aimTypeSaved.shortDescription)
        assertEquals(aimType.validFrom, aimTypeSaved.validFrom)
        assertEquals(aimType.validTo, aimTypeSaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        AimTypeDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        AimType aimTypeSaved = aimTypeService.updateFromDto(dto)
        verify(aimTypeRepository, times(1)).findById(aimType.id)
        verify(aimTypeRepository, times(1)).save(aimType)
        verifyNoMoreInteractions(aimTypeRepository)
        assertEquals(aimType.id, aimTypeSaved.id)
        assertEquals(aimType.code, aimTypeSaved.code)
        assertEquals(aimType.description, aimTypeSaved.description)
        assertEquals(aimType.shortDescription, aimTypeSaved.shortDescription)
        assertEquals(aimType.validFrom, aimTypeSaved.validFrom)
        assertEquals(aimType.validTo, aimTypeSaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update AimType from null object.")
        AimTypeDto dto = null
        aimTypeService.updateFromDto(dto)
        verifyNoMoreInteractions(aimTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        aimTypeService.delete(aimType)
        verifyNoMoreInteractions(aimTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}