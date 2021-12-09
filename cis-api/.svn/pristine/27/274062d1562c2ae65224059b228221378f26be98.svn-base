package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.PersonAlias
import uk.ac.reigate.dto.PersonDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.model.SearchResult
import uk.ac.reigate.repositories.PersonAliasRepository

class PersonAliasServiceTest {
    
    @Mock
    private PersonAliasRepository personAliasRepository
    
    @InjectMocks
    private PersonAliasService personAliasService;
    
    private PersonAlias personAlias
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    PersonAlias createPersonAlias() {
        return new PersonAlias(
                personUsername: 'Vinaya',
                aliasUsername: 'Michael',
                inUse: true
                )
    }
    
    @Before
    public void setup() {
        personAliasRepository = mock(PersonAliasRepository.class);
        this.personAliasService = new PersonAliasService(personAliasRepository);
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        PersonAliasService service = new PersonAliasService();
        assertNotNull(service)
    }
    @Test
    public void testFindPersonAlias() {
        PersonAlias result = personAliasService.findByPersonUsername('Vinaya');
        verify(personAliasRepository, times(1)).findByPersonUsername('Vinaya')
        verifyNoMoreInteractions(personAliasRepository)
    }
}

