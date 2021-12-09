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

import uk.ac.reigate.domain.lookup.Gender
import uk.ac.reigate.dto.lookup.GenderDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.GenderRepository


class GenderServiceTest {
    
    @Mock
    private GenderRepository genderRepository;
    
    @InjectMocks
    private GenderService genderService;
    
    private Gender gender
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample Gender data object to use for the testing
     * 
     * @return a sample Gender data object
     */
    Gender createGender() {
        return new Gender(
                id: 1,
                code: 'F',
                description: 'Female',
                sonDaughter: 'son',
                heShe: 'he',
                himHer: 'him',
                hisHer: 'his'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample Gender created at setup
     * 
     * @return a GenderDto object based on the sample Gender
     */
    GenderDto createDto() {
        return new GenderDto(
                id: gender.id,
                code: gender.code,
                description: gender.description,
                sonDaughter: gender.sonDaughter,
                heShe: gender.heShe,
                himHer: gender.himHer,
                hisHer: gender.hisHer
                )
    }
    
    /**
     * This method is used to set up the tests for the GenderService
     */
    @Before
    public void setup() {
        this.genderRepository = Mockito.mock(GenderRepository.class);
        this.genderService = new GenderService(genderRepository);
        
        gender = createGender()
        
        when(genderRepository.save(any(Gender.class))).thenReturn(gender);
        when(genderRepository.findById(1)).thenReturn(new Optional(gender));
        when(genderRepository.findByCode(gender.code)).thenReturn(gender);
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        GenderService service = new GenderService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<Gender> result = genderService.findAll();
        verify(genderRepository, times(1)).findAll()
        verifyNoMoreInteractions(genderRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        Gender result = genderService.findById(1);
        verify(genderRepository, times(1)).findById(1)
        verifyNoMoreInteractions(genderRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        Gender savedGender = genderService.save(gender);
        verify(genderRepository, times(1)).save(any())
        verifyNoMoreInteractions(genderRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<Gender> savedGenders = genderService.saveGenders([gender, gender]);
        verify(genderRepository, times(2)).save(gender)
        verifyNoMoreInteractions(genderRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        GenderDto dto = createDto()
        Gender genderSaved = genderService.createFromDto(dto)
        verify(genderRepository, times(1)).save(any(Gender.class))
        verifyNoMoreInteractions(genderRepository)
        assertEquals(dto.id, gender.id)
        assertEquals(dto.code, gender.code)
        assertEquals(dto.description, gender.description)
        assertEquals(dto.sonDaughter, gender.sonDaughter)
        assertEquals(dto.heShe, gender.heShe)
        assertEquals(dto.himHer, gender.himHer)
        assertEquals(dto.hisHer, gender.hisHer)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create gender from null object.")
        GenderDto dto = null
        genderService.createFromDto(dto)
        verifyNoMoreInteractions(genderRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        GenderDto dto = createDto()
        Gender genderSaved = genderService.updateFromDto(dto)
        verify(genderRepository, times(1)).findById(gender.id)
        verify(genderRepository, times(1)).save(gender)
        verifyNoMoreInteractions(genderRepository)
        assertEquals(gender.id, genderSaved.id)
        assertEquals(gender.code, genderSaved.code)
        assertEquals(gender.description, genderSaved.description)
        assertEquals(gender.sonDaughter, genderSaved.sonDaughter)
        assertEquals(gender.heShe, genderSaved.heShe)
        assertEquals(gender.himHer, genderSaved.himHer)
        assertEquals(gender.hisHer, genderSaved.hisHer)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        GenderDto dto = createDto()
        dto.code = null
        dto.description = null
        Gender genderSaved = genderService.updateFromDto(dto)
        verify(genderRepository, times(1)).findById(gender.id)
        verify(genderRepository, times(1)).save(gender)
        verifyNoMoreInteractions(genderRepository)
        assertEquals(gender.id, genderSaved.id)
        assertEquals(gender.code, genderSaved.code)
        assertEquals(gender.description, genderSaved.description)
        assertEquals(gender.sonDaughter, genderSaved.sonDaughter)
        assertEquals(gender.heShe, genderSaved.heShe)
        assertEquals(gender.himHer, genderSaved.himHer)
        assertEquals(gender.hisHer, genderSaved.hisHer)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update gender from null object.")
        GenderDto dto = null
        genderService.updateFromDto(dto)
        verifyNoMoreInteractions(genderRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        genderService.delete(gender)
        verifyNoMoreInteractions(genderRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the findByDescription service method
     */
    @Test
    public void testFindByDescription() {
        Gender result = genderService.findByCode(gender.code)
        verify(genderRepository, times(1)).findByCode(gender.code)
        verifyNoMoreInteractions(genderRepository)
    }
}

