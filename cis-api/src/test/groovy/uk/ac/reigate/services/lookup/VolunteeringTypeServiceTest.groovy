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

import uk.ac.reigate.domain.lookup.VolunteeringType
import uk.ac.reigate.dto.lookup.VolunteeringTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.VolunteeringTypeRepository


class VolunteeringTypeServiceTest {
    
    @Mock
    private VolunteeringTypeRepository volunteeringTypeRepository;
    
    @InjectMocks
    private VolunteeringTypeService volunteeringTypeService;
    
    private VolunteeringType volunteeringType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample VolunteeringType data object to use for the testing
     * 
     * @return a sample VolunteeringType data object
     */
    VolunteeringType createVolunteeringType() {
        return new VolunteeringType(
                id: 1,
                code: 'F',
                description: 'Free meals'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample VolunteeringType created at setup
     * 
     * @return a VolunteeringTypeDto object based on the sample VolunteeringType
     */
    VolunteeringTypeDto createDto() {
        return new VolunteeringTypeDto(
                id: volunteeringType.id,
                code: volunteeringType.code,
                description: volunteeringType.description
                )
    }
    
    /**
     * This method is used to set up the tests for the VolunteeringTypeService
     */
    @Before
    public void setup() {
        this.volunteeringTypeRepository = Mockito.mock(VolunteeringTypeRepository.class);
        this.volunteeringTypeService = new VolunteeringTypeService(volunteeringTypeRepository);
        
        volunteeringType = createVolunteeringType()
        
        when(volunteeringTypeRepository.save(any(VolunteeringType.class))).thenReturn(volunteeringType);
        when(volunteeringTypeRepository.findById(1)).thenReturn(new Optional(volunteeringType));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        VolunteeringTypeService service = new VolunteeringTypeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<VolunteeringType> result = volunteeringTypeService.findAll();
        verify(volunteeringTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(volunteeringTypeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        VolunteeringType result = volunteeringTypeService.findById(1);
        verify(volunteeringTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(volunteeringTypeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        VolunteeringType savedVolunteeringType = volunteeringTypeService.save(volunteeringType);
        verify(volunteeringTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(volunteeringTypeRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<VolunteeringType> savedVolunteeringTypes = volunteeringTypeService.saveVolunteeringTypes([
            volunteeringType,
            volunteeringType
        ]);
        verify(volunteeringTypeRepository, times(2)).save(volunteeringType)
        verifyNoMoreInteractions(volunteeringTypeRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        VolunteeringTypeDto dto = createDto()
        VolunteeringType volunteeringTypeSaved = volunteeringTypeService.createFromDto(dto)
        verify(volunteeringTypeRepository, times(1)).save(any(VolunteeringType.class))
        verifyNoMoreInteractions(volunteeringTypeRepository)
        assertEquals(dto.id, volunteeringType.id)
        assertEquals(dto.code, volunteeringType.code)
        assertEquals(dto.description, volunteeringType.description)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create volunteeringType from null object.")
        VolunteeringTypeDto dto = null
        volunteeringTypeService.createFromDto(dto)
        verifyNoMoreInteractions(volunteeringTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        VolunteeringTypeDto dto = createDto()
        VolunteeringType volunteeringTypeSaved = volunteeringTypeService.updateFromDto(dto)
        verify(volunteeringTypeRepository, times(1)).findById(volunteeringType.id)
        verify(volunteeringTypeRepository, times(1)).save(volunteeringType)
        verifyNoMoreInteractions(volunteeringTypeRepository)
        assertEquals(volunteeringType.id, volunteeringTypeSaved.id)
        assertEquals(volunteeringType.code, volunteeringTypeSaved.code)
        assertEquals(volunteeringType.description, volunteeringTypeSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        VolunteeringTypeDto dto = createDto()
        VolunteeringType volunteeringTypeSaved = volunteeringTypeService.updateFromDto(dto)
        verify(volunteeringTypeRepository, times(1)).findById(volunteeringType.id)
        verify(volunteeringTypeRepository, times(1)).save(volunteeringType)
        verifyNoMoreInteractions(volunteeringTypeRepository)
        assertEquals(volunteeringType.id, volunteeringTypeSaved.id)
        assertEquals(volunteeringType.code, volunteeringTypeSaved.code)
        assertEquals(volunteeringType.description, volunteeringTypeSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update volunteeringType from null object.")
        VolunteeringTypeDto dto = null
        volunteeringTypeService.updateFromDto(dto)
        verifyNoMoreInteractions(volunteeringTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        volunteeringTypeService.delete(volunteeringType)
        verifyNoMoreInteractions(volunteeringTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}