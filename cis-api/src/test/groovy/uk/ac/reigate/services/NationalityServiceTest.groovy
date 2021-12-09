package uk.ac.reigate.services;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.mockito.Mockito.*
import static org.junit.Assert.assertNotNull

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.Mockito

import uk.ac.reigate.domain.lookup.Nationality
import uk.ac.reigate.dto.lookup.NationalityDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.NationalityRepository


public class NationalityServiceTest {
    
    private NationalityRepository nationalityRepository;
    
    private NationalityService nationalityService;
    
    private Nationality nationality
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Before
    public void setup() {
        this.nationalityRepository = Mockito.mock(NationalityRepository.class);
        this.nationalityService = new NationalityService(nationalityRepository);
        
        nationality = new Nationality(
                id: 1,
                name: 'A',
                description: 'A Nationality'
                )
        
        when(nationalityRepository.findById(1)).thenReturn(new Optional(nationality));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        NationalityService service = new NationalityService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindNationalities() {
        List<Nationality> result = nationalityService.findAll();
        verify(nationalityRepository, times(1)).findAll()
        verifyNoMoreInteractions(nationalityRepository)
    }
    
    @Test
    public void testFindNationality() {
        Nationality result = nationalityService.findById(1);
        verify(nationalityRepository, times(1)).findById(1)
        verifyNoMoreInteractions(nationalityRepository)
    }
    
    @Test
    public void testFindByDescription() {
        Nationality result = nationalityService.findByDescription('UK');
        verify(nationalityRepository, times(1)).findByDescription('UK')
        verifyNoMoreInteractions(nationalityRepository)
    }
    
    @Test
    public void testSaveNewNationality() {
        Nationality savedNationality = nationalityService.save(nationality);
        verify(nationalityRepository, times(1)).save(any())
        verifyNoMoreInteractions(nationalityRepository)
    }
    
    @Test
    public void testSaveNationality() {
        Nationality savedNationality = nationalityService.save(nationality);
        verify(nationalityRepository, times(1)).save(any())
        verifyNoMoreInteractions(nationalityRepository)
    }
    
    @Test
    public void testSaveNationalities() {
        List<Nationality> savedNationalities = nationalityService.saveNationalities([
            new Nationality(id: 1),
            new Nationality(id: 2)
        ]);
        verify(nationalityRepository, times(2)).save(any(Nationality.class))
        verifyNoMoreInteractions(nationalityRepository)
    }
    
    @Test
    public void testSaveNationalityByFields_WithNullId() {
        Nationality savedNationality = nationalityService.save(nationality);
        verify(nationalityRepository, times(1)).save(any())
        verifyNoMoreInteractions(nationalityRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        NationalityDto dto = new NationalityDto(id: 1, name: 'uk')
        nationalityService.createFromDto(dto)
        verify(nationalityRepository, times(1)).save(any(Nationality.class))
        verifyNoMoreInteractions(nationalityRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        NationalityDto dto = new NationalityDto(id: 1, name: 'uk')
        nationalityService.updateFromDto(dto)
        verify(nationalityRepository, times(1)).findById(nationality.id)
        verify(nationalityRepository, times(1)).save(any(Nationality.class))
        verifyNoMoreInteractions(nationalityRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create nationalityDto from null object.")
        NationalityDto dto = null
        nationalityService.createFromDto(dto)
        verifyNoMoreInteractions(nationalityRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update nationalityDto from null object.")
        NationalityDto dto = null
        nationalityService.updateFromDto(dto)
        verifyNoMoreInteractions(nationalityRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        nationalityService.delete(nationality)
        verifyNoMoreInteractions(nationalityRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}

