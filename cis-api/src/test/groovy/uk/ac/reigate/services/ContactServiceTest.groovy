package uk.ac.reigate.services

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import uk.ac.reigate.api.PeopleApi
import uk.ac.reigate.domain.Contact
import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.lookup.ContactType
import uk.ac.reigate.domain.lookup.Title
import uk.ac.reigate.dto.ContactDto
import uk.ac.reigate.dto.PersonDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.ContactRepository
import uk.ac.reigate.services.lookup.ContactTypeService
import uk.ac.reigate.services.lookup.GenderService
import uk.ac.reigate.services.lookup.LegalSexService
import uk.ac.reigate.services.lookup.TitleService

@RunWith(MockitoJUnitRunner.class)
class ContactServiceTest {
    
    @Mock
    private ContactRepository contactRepository;
    
    @Mock
    private PersonService personService
    
    @Mock
    private ContactTypeService contactTypeService
    
    @Mock
    private PeopleApi peopleApi
    
    @Mock
    private TitleService titleService
    
    @Mock
    private GenderService genderService
    
    @Mock
    private AddressService addressService
    
    @Mock
    private LegalSexService legalSexService
    
    @InjectMocks
    private ContactService contactService;
    
    private Contact contact
    
    @Mock
    private PersonDto personDto
    
    @Mock
    private Person person
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    /**
     * This method is used to create a sample Contact data object to use for the testing
     *
     * @return a sample Contact data object
     */
    Contact createContact() {
        return new Contact(
                id: 1,
                contactable : true,
                preferred : true,
                contactType: new ContactType(id: 1),
                person: createPerson(),
                contact : createPerson()
                )
    }
    
    ContactDto createDto() {
        Contact sampleContact = createContact();
        return new ContactDto(
                id: sampleContact.id,
                contactable : sampleContact.contactable,
                preferred : sampleContact.preferred,
                contactTypeId : sampleContact.contactType.id,
                personId : sampleContact.person.id,
                contactId: sampleContact.contact.id,
                contact: createPersonDto()
                )
    }
    
    ContactDto create1Dto() {
        Contact sampleContact = createContact();
        return new ContactDto(
                id: sampleContact.id,
                contactable : sampleContact.contactable,
                preferred : sampleContact.preferred,
                contactTypeId : sampleContact.contactType.id,
                personId : sampleContact.person.id,
                contactId: sampleContact.contact.id,
                contact: createPersonDtoWithNullId()
                )
    }
    
    Person createPerson() {
        return new Person(
                id: 2,
                firstName : 'Vinaya',
                surname: 'Bali',
                preferredName : 'Vin',
                middleNames :'MB',
                previousSurname : 'Uday',
                dob :new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                home : '0780917888',
                mobile : '3427832743',
                work : '7483742893',
                email :'mbvinayabali@gmail.com'
                )
    }
    
    PersonDto createPersonDto() {
        PersonDto output = new PersonDto()
        output.id = 1
        output.titleId = 2
        output.firstName = 'vinaya'
        output.surname = 'bali'
        output.preferredName = 'Vin'
        output.middleNames ='MB'
        output.genderId = 3
        output.legalSexId = 1
        output.addressId = 2
        output.previousSurname = 'Uday'
        output.dob = new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09')
        output.home = '0780917888'
        output.mobile = '3427832743'
        output.work = '7483742893'
        output.email ='mbvinayabali@gmail.com'
        return output
    }
    
    PersonDto createPersonDtoWithNullId() {
        PersonDto output = new PersonDto()
        output.id = 1
        output.titleId = null
        output.firstName = 'vinaya'
        output.surname = 'bali'
        output.preferredName = 'Vin'
        output.middleNames ='MB'
        output.genderId = null
        output.legalSexId = null
        output.addressId = null
        output.previousSurname = 'Uday'
        output.dob = new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09')
        output.home = '0780917888'
        output.mobile = '3427832743'
        output.work = '7483742893'
        output.email ='mbvinayabali@gmail.com'
        return output
    }
    
    @Before
    public void setup() {
        contactRepository = mock(ContactRepository.class);
        personService = mock(PersonService.class);
        contactTypeService = mock(ContactTypeService.class);
        peopleApi = mock(PeopleApi.class);
        titleService = mock(TitleService.class);
        genderService = mock(GenderService.class);
        addressService = mock(AddressService.class);
        legalSexService = mock(LegalSexService.class);
        
        contactService = new ContactService(contactRepository, personService, contactTypeService, peopleApi, titleService, genderService, addressService, legalSexService)
        
        contact = createContact()
        
        when(contactRepository.findById(contact.id)).thenReturn(new Optional(new Contact()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        ContactService service = new ContactService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<Contact> result = contactService.findAll();
        verify(contactRepository, times(1)).findAll()
        verifyNoMoreInteractions(contactRepository)
    }
    
    @Test
    public void testSearchByPersonId() {
        List<Contact> result = contactService.searchByPersonId(2);
        verify(contactRepository, times(1)).findByPerson(personService.findById(2))
        verifyNoMoreInteractions(contactRepository)
    }
    
    @Test
    public void testFindById() {
        Contact result = contactService.findById(1);
        verify(contactRepository, times(1)).findById(1)
        verifyNoMoreInteractions(contactRepository)
    }
    
    @Test
    public void testSaveNewContact() {
        contact.id = null
        contactService.save(contact);
        verify(contactRepository, times(1)).save(contact)
        verifyNoMoreInteractions(contactRepository)
    }
    
    @Test
    public void testSaveContact() {
        contactService.save(contact);
        verify(contactRepository, times(1)).save(contact)
        verifyNoMoreInteractions(contactRepository)
    }
    
    @Test
    public void testSaveContacts() {
        List<Contact> savedContacts = contactService.saveContacts([
            new Contact(id: 1),
            new Contact(id: 2)
        ]);
        verify(contactRepository, times(2)).save(any(Contact.class))
        verifyNoMoreInteractions(contactRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create Contact from null object.")
        ContactDto dto = null
        contactService.createFromDto(dto)
        verifyNoMoreInteractions(contactRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithNullIds() {
        ContactDto dto = createDto()
        dto.personId = null
        dto.contactTypeId = null
        contactService.createFromDto(dto)
        verify(contactRepository, times(1)).save(any(Contact.class))
        verifyNoMoreInteractions(contactRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithPersonId() {
        ContactDto dto = createDto()
        dto.personId = 11
        when(personService.findById(dto.personId)).thenReturn(null);
        contactService.createFromDto(dto)
        verify(contactRepository, times(1)).save(any(Contact.class))
        verifyNoMoreInteractions(contactRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithContactTypeId() {
        ContactDto dto = createDto()
        dto.contactTypeId = 2
        when(contactTypeService.findById(dto.contactTypeId)).thenReturn(null);
        contactService.createFromDto(dto)
        verify(contactRepository, times(1)).save(any(Contact.class))
        verifyNoMoreInteractions(contactRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithContactId() {
        ContactDto dto = createDto()
        dto.contactId = 12
        when(personService.findById(dto.contactId)).thenReturn(null);
        contactService.createFromDto(dto)
        verify(contactRepository, times(1)).save(any(Contact.class))
        verifyNoMoreInteractions(contactRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithNullContactId() {
        ContactDto dto = createDto()
        dto.contact = new PersonDto(id: 2)
        dto.contactId = null
        peopleApi.create(dto.contact)
        when(personService.createFromDto(dto.contact)).thenReturn(null);
        contactService.createFromDto(dto)
        verify(contactRepository, times(1)).save(any(Contact.class))
        verifyNoMoreInteractions(contactRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullId() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update Contact from null object.")
        ContactDto dto = new ContactDto(contactable: true)
        contactService.updateFromDto(dto)
        verifyNoMoreInteractions(contactRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        ContactDto dto = createDto()
        when(contactRepository.findById(dto.id)).thenReturn(new Optional(new Contact(id: 1, contact: new Person(
        id:1,
        firstName : 'Vinaya',
        surname: 'Bali',
        preferredName : 'Vin',
        middleNames :'MB',
        previousSurname : 'Uday',
        dob :new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
        home : '0780917888',
        mobile : '3427832743',
        work : '7483742893',
        email :'mbvinayabali@gmail.com'
        ))));
        dto.contact = createPersonDto()
        dto.contact.genderId = 1
        when(genderService.findById(dto.contact.genderId)).thenReturn(null)
        dto.contact.legalSexId = 1
        when(legalSexService.findById(dto.contact.legalSexId)).thenReturn(null)
        contactService.updateFromDto(dto)
        verify(contactRepository, times(1)).findById(dto.id)
        verify(contactRepository, times(1)).save(any(Contact.class))
        verifyNoMoreInteractions(contactRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoNullIds() {
        ContactDto dto = create1Dto()
        when(contactRepository.findById(dto.id)).thenReturn(new Optional(new Contact(
                id: 1,
                contact: new Person(
                id:1,
                firstName : 'Vinaya',
                surname: 'Bali',
                preferredName : 'Vin',
                middleNames :'MB',
                previousSurname : 'Uday',
                dob :new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                home : '0780917888',
                mobile : '3427832743',
                work : '7483742893',
                email :'mbvinayabali@gmail.com',
                title: null,
                legalSex : null,
                gender : null
                ))));
        dto.contact = createPersonDtoWithNullId()
        contactService.updateFromDto(dto)
        verify(contactRepository, times(1)).findById(dto.id)
        verify(contactRepository, times(1)).save(any(Contact.class))
        verifyNoMoreInteractions(contactRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoNullContact() {
        ContactDto dto = new ContactDto(id:1 , contactable: true, preferred: false)
        dto.contact = null
        dto.contactTypeId = null
        contactService.updateFromDto(dto)
        verify(contactRepository, times(1)).findById(dto.id)
        verify(contactRepository, times(1)).save(any(Contact.class))
        verifyNoMoreInteractions(contactRepository)
    }
    
    
    @Test
    public void testUpdateFromDto_withUpdateContact() {
        Contact dto = new Contact(id: 1)
        dto.person = new Person(id: 2, firstName: 'Vinaya', surname: 'Bali', preferredName: 'Vin')
        dto.person.id = 2
        when(personService.findById(dto.person.id)).thenReturn(null)
        dto.contact = new Person(id: 2, firstName: 'Vinaya', surname: 'Bali', preferredName: 'Vin')
        dto.contact.id = 2
        when(personService.findById(dto.contact.id)).thenReturn(null)
        dto.contactType = new ContactType(id: 2, name:'mom')
        dto.contactType.id
        when(contactTypeService.findById(dto.contactType.id)).thenReturn(null)
        contactService.updateContact(dto)
        verify(contactRepository, times(1)).save(any(Contact.class))
    }
    
    @Test
    public void testUpdateFromDto_withNullUpdateContact() {
        Contact dto = new Contact(id: 1)
        dto.person = new Person(firstName: 'Vinaya', surname: 'Bali', preferredName: 'Vin')
        dto.person.id = null
        dto.contact = new Person(firstName: 'Vinaya', surname: 'Bali', preferredName: 'Vin')
        dto.contact.id = null
        dto.contactType = new ContactType(name:'mom')
        dto.contactType.id = null
        contactService.updateContact(dto)
        verify(contactRepository, times(1)).save(any(Contact.class))
    }
    
    @Test
    public void testDelete() {
        contactService.delete(new Contact(id: 1))
    }
    
    @Test
    public void testDeleteContactId() {
        Integer contactId = 1
        contactService.delete(1)
        verify(contactRepository, times(1)).deleteById(1)
    }
}