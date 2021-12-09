package uk.ac.reigate.services

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import org.springframework.data.domain.Pageable

import uk.ac.reigate.domain.Person
import uk.ac.reigate.dto.PersonDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.model.SearchResult
import uk.ac.reigate.repositories.PersonRepository
import uk.ac.reigate.services.lookup.GenderService
import uk.ac.reigate.services.lookup.LegalSexService
import uk.ac.reigate.services.lookup.TitleService

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

class PersonServiceTest {
    
    @Mock
    private PersonRepository personRepository
    
    @Mock
    private TitleService titleService
    
    @Mock
    private GenderService genderService
    
    @Mock
    private LegalSexService legalSexService
    
    @Mock
    private AddressService addressService
    
    @Mock
    private ContactService contactService;
    
    @Mock
    private RoleService roleService
    
    @InjectMocks
    private PersonService personService;
    
    private Person person
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    Person createPerson() {
        return new Person(
                id: 1,
                firstName: 'Michael',
                surname: 'Horgan',
                home: '01737221118'
                )
    }
    
    PersonDto createDto() {
        Person sampleData = createPerson()
        return new PersonDto(
                id: sampleData.id,
                firstName: sampleData.firstName,
                surname: sampleData.surname,
                home: sampleData.home
                )
    }
    
    @Before
    public void setup() {
        personRepository = mock(PersonRepository.class);
        titleService = mock(TitleService.class);
        genderService = mock(GenderService.class);
        legalSexService = mock(LegalSexService.class);
        addressService = mock(AddressService.class)
        contactService = mock(ContactService.class);
        roleService = mock(RoleService.class);
        
        this.personService = new PersonService(personRepository, titleService, genderService, legalSexService, addressService, contactService, roleService);
        
        person = createPerson()
        
        when(personRepository.findById(person.id)).thenReturn(new Optional(new Person()));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        PersonService service = new PersonService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindPeople() {
        SearchResult<Person> result = personService.findAll();
        verify(personRepository, times(1)).findAll()
        verifyNoMoreInteractions(personRepository)
    }
    
    @Test
    public void testFindPerson() {
        Person result = personService.findById(1);
        verify(personRepository, times(1)).findById(1)
        verifyNoMoreInteractions(personRepository)
    }
    
    @Test
    public void testFindPersonByPage() {
        Pageable page
        SearchResult<Person> result = personService.findPersonByPage(page);
        verify(personRepository, times(1)).findAll(page)
        verifyNoMoreInteractions(personRepository)
    }
    
    @Test
    public void testFindByPerson() {
        Person result = personService.findByPerson(1);
        verify(personRepository, times(1)).findByPerson(1)
        verifyNoMoreInteractions(personRepository)
    }
    
    @Test
    public void testFindByUsername() {
        Person result = personService.findByUsername('Vin');
        verify(personRepository, times(1)).findByUsername('Vin')
        verifyNoMoreInteractions(personRepository)
    }
    
    @Test
    public void testSaveNewPerson() {
        person.id = null
        Person savedPerson = personService.save(person);
        verify(personRepository, times(1)).save(any(Person.class))
        verifyNoMoreInteractions(personRepository)
    }
    
    @Test
    public void testSavePerson() {
        Person savedPerson = personService.save(person);
        verify(personRepository, times(1)).save(any(Person.class))
        verifyNoMoreInteractions(personRepository)
    }
    
    @Test
    public void testFindByNamePart() {
        String name = 'Vinaya'
        List<Person> result = personService.findByNamePart('Vinaya');
        List<Person> people = new ArrayList<Person>()
        people.addAll(personRepository.findBySurnameContainingIgnoreCase(name))
        people.addAll(personRepository.findByFirstNameContainingIgnoreCase(name))
        people.addAll(personRepository.findByPreferredNameContainingIgnoreCase(name))
        people.addAll(personRepository.findByMiddleNamesContainingIgnoreCase(name))
        people.addAll(personRepository.findByPreviousSurnameContainingIgnoreCase(name))
    }
    
    @Test
    public void testCreateFromDto_dto() {
        PersonDto dto = new PersonDto(id: 1, firstName: 'Vinaya')
        personService.createFromDto(dto)
        verify(personRepository, times(1)).save(any(Person.class))
        verifyNoMoreInteractions(personRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithTitleId() {
        PersonDto dto = createDto()
        dto.titleId = 1
        when(titleService.findById(dto.titleId)).thenReturn(null);
        personService.createFromDto(dto)
        verify(personRepository, times(1)).save(any(Person.class))
        verifyNoMoreInteractions(personRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithGenderId() {
        PersonDto dto = createDto()
        dto.genderId = 1
        when(genderService.findById(dto.genderId)).thenReturn(null);
        personService.createFromDto(dto)
        verify(personRepository, times(1)).save(any(Person.class))
        verifyNoMoreInteractions(personRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithLegalSexId() {
        PersonDto dto = createDto()
        dto.legalSexId = 1
        when(legalSexService.findById(dto.legalSexId)).thenReturn(null);
        personService.createFromDto(dto)
        verify(personRepository, times(1)).save(any(Person.class))
        verifyNoMoreInteractions(personRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithAddressId() {
        PersonDto dto = createDto()
        dto.addressId = 1
        when(addressService.findById(dto.addressId)).thenReturn(null);
        personService.createFromDto(dto)
        verify(personRepository, times(1)).save(any(Person.class))
        verifyNoMoreInteractions(personRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create Person from null object.")
        PersonDto dto = null
        personService.createFromDto(dto)
        verifyNoMoreInteractions(personRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update Person from null object.")
        PersonDto dto = null
        personService.updateFromDto(dto)
        verifyNoMoreInteractions(personRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithTitleId() {
        PersonDto dto = createDto()
        dto.titleId = 1
        when(titleService.findById(dto.titleId)).thenReturn(null);
        personService.updateFromDto(dto)
        verify(titleService, times(1)).findById(dto.titleId)
        verifyNoMoreInteractions(titleService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithGenderId() {
        PersonDto dto = createDto()
        dto.genderId = 1
        when(genderService.findById(dto.genderId)).thenReturn(null);
        personService.updateFromDto(dto)
        verify(genderService, times(1)).findById(dto.genderId)
        verifyNoMoreInteractions(genderService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithLegalSexId() {
        PersonDto dto = createDto()
        dto.legalSexId = 1
        when(legalSexService.findById(dto.legalSexId)).thenReturn(null);
        personService.updateFromDto(dto)
        verify(legalSexService, times(1)).findById(dto.legalSexId)
        verifyNoMoreInteractions(legalSexService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithAddressId() {
        PersonDto dto = createDto()
        dto.addressId = 1
        when(addressService.findById(dto.addressId)).thenReturn(null);
        personService.updateFromDto(dto)
        verify(addressService, times(1)).findById(dto.addressId)
        verifyNoMoreInteractions(addressService)
    }
    
    @Test
    public void testCreatePersonRole_NullDto() {
        thrown.expect(InvalidDataException.class)
        PersonDto dto = null
        personService.createPersonRole(dto)
        verifyNoMoreInteractions(personRepository)
    }
    
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        personService.delete(person)
        verifyNoMoreInteractions(personRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}

