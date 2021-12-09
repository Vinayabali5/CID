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

import uk.ac.reigate.domain.lookup.VolunteeringExperience
import uk.ac.reigate.dto.lookup.VolunteeringExperienceDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.VolunteeringExperienceRepository


class VolunteeringExperienceServiceTest {
    
    @Mock
    private VolunteeringExperienceRepository volunteeringExperienceRepository;
    
    @InjectMocks
    private VolunteeringExperienceService volunteeringExperienceService;
    
    private VolunteeringExperience volunteeringExperience
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample VolunteeringExperience data object to use for the testing
     * 
     * @return a sample VolunteeringExperience data object
     */
    VolunteeringExperience createVolunteeringExperience() {
        return new VolunteeringExperience(
                id: 1,
                code: 'F',
                description: 'Free meals'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample VolunteeringExperience created at setup
     * 
     * @return a VolunteeringExperienceDto object based on the sample VolunteeringExperience
     */
    VolunteeringExperienceDto createDto() {
        return new VolunteeringExperienceDto(
                id: volunteeringExperience.id,
                code: volunteeringExperience.code,
                description: volunteeringExperience.description
                )
    }
    
    /**
     * This method is used to set up the tests for the VolunteeringExperienceService
     */
    @Before
    public void setup() {
        this.volunteeringExperienceRepository = Mockito.mock(VolunteeringExperienceRepository.class);
        this.volunteeringExperienceService = new VolunteeringExperienceService(volunteeringExperienceRepository);
        
        volunteeringExperience = createVolunteeringExperience()
        
        when(volunteeringExperienceRepository.save(any(VolunteeringExperience.class))).thenReturn(volunteeringExperience);
        when(volunteeringExperienceRepository.findById(1)).thenReturn(new Optional(volunteeringExperience));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        VolunteeringExperienceService service = new VolunteeringExperienceService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<VolunteeringExperience> result = volunteeringExperienceService.findAll();
        verify(volunteeringExperienceRepository, times(1)).findAll()
        verifyNoMoreInteractions(volunteeringExperienceRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        VolunteeringExperience result = volunteeringExperienceService.findById(1);
        verify(volunteeringExperienceRepository, times(1)).findById(1)
        verifyNoMoreInteractions(volunteeringExperienceRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        VolunteeringExperience savedVolunteeringExperience = volunteeringExperienceService.save(volunteeringExperience);
        verify(volunteeringExperienceRepository, times(1)).save(any())
        verifyNoMoreInteractions(volunteeringExperienceRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<VolunteeringExperience> savedVolunteeringExperiences = volunteeringExperienceService.saveVolunteeringExperiences([
            volunteeringExperience,
            volunteeringExperience
        ]);
        verify(volunteeringExperienceRepository, times(2)).save(volunteeringExperience)
        verifyNoMoreInteractions(volunteeringExperienceRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        VolunteeringExperienceDto dto = createDto()
        VolunteeringExperience volunteeringExperienceSaved = volunteeringExperienceService.createFromDto(dto)
        verify(volunteeringExperienceRepository, times(1)).save(any(VolunteeringExperience.class))
        verifyNoMoreInteractions(volunteeringExperienceRepository)
        assertEquals(dto.id, volunteeringExperience.id)
        assertEquals(dto.code, volunteeringExperience.code)
        assertEquals(dto.description, volunteeringExperience.description)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create volunteeringExperience from null object.")
        VolunteeringExperienceDto dto = null
        volunteeringExperienceService.createFromDto(dto)
        verifyNoMoreInteractions(volunteeringExperienceRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        VolunteeringExperienceDto dto = createDto()
        VolunteeringExperience volunteeringExperienceSaved = volunteeringExperienceService.updateFromDto(dto)
        verify(volunteeringExperienceRepository, times(1)).findById(volunteeringExperience.id)
        verify(volunteeringExperienceRepository, times(1)).save(volunteeringExperience)
        verifyNoMoreInteractions(volunteeringExperienceRepository)
        assertEquals(volunteeringExperience.id, volunteeringExperienceSaved.id)
        assertEquals(volunteeringExperience.code, volunteeringExperienceSaved.code)
        assertEquals(volunteeringExperience.description, volunteeringExperienceSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        VolunteeringExperienceDto dto = createDto()
        VolunteeringExperience volunteeringExperienceSaved = volunteeringExperienceService.updateFromDto(dto)
        verify(volunteeringExperienceRepository, times(1)).findById(volunteeringExperience.id)
        verify(volunteeringExperienceRepository, times(1)).save(volunteeringExperience)
        verifyNoMoreInteractions(volunteeringExperienceRepository)
        assertEquals(volunteeringExperience.id, volunteeringExperienceSaved.id)
        assertEquals(volunteeringExperience.code, volunteeringExperienceSaved.code)
        assertEquals(volunteeringExperience.description, volunteeringExperienceSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update volunteeringExperience from null object.")
        VolunteeringExperienceDto dto = null
        volunteeringExperienceService.updateFromDto(dto)
        verifyNoMoreInteractions(volunteeringExperienceRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        volunteeringExperienceService.delete(volunteeringExperience)
        verifyNoMoreInteractions(volunteeringExperienceRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}