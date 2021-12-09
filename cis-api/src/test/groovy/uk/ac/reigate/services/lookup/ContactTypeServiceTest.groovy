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

import uk.ac.reigate.domain.lookup.ContactType
import uk.ac.reigate.dto.lookup.ContactTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.ContactTypeRepository


class ContactTypeServiceTest {
    
    @Mock
    private ContactTypeRepository contactTypeRepository;
    
    @InjectMocks
    private ContactTypeService contactTypeService;
    
    private ContactType contactType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample ContactType data object to use for the testing
     * 
     * @return a sample ContactType data object
     */
    ContactType createContactType() {
        return new ContactType(
                id: 1,
                name: 'F',
                description: 'Father'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample ContactType created at setup
     * 
     * @return a ContactTypeDto object based on the sample ContactType
     */
    ContactTypeDto createDto() {
        return new ContactTypeDto(
                id: contactType.id,
                name: contactType.name,
                description: contactType.description
                )
    }
    
    /**
     * This method is used to set up the tests for the ContactTypeService
     */
    @Before
    public void setup() {
        this.contactTypeRepository = Mockito.mock(ContactTypeRepository.class);
        this.contactTypeService = new ContactTypeService(contactTypeRepository);
        
        contactType = createContactType()
        
        when(contactTypeRepository.save(any(ContactType.class))).thenReturn(contactType);
        when(contactTypeRepository.findById(1)).thenReturn(new Optional(contactType));
        when(contactTypeRepository.findByDescription(contactType.description)).thenReturn(contactType);
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        ContactTypeService service = new ContactTypeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<ContactType> result = contactTypeService.findAll();
        verify(contactTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(contactTypeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        ContactType result = contactTypeService.findById(1);
        verify(contactTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(contactTypeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        ContactType savedContactType = contactTypeService.save(contactType);
        verify(contactTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(contactTypeRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<ContactType> savedContactTypes = contactTypeService.saveContactTypes([contactType, contactType]);
        verify(contactTypeRepository, times(2)).save(contactType)
        verifyNoMoreInteractions(contactTypeRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        ContactTypeDto dto = createDto()
        ContactType contactTypeSaved = contactTypeService.createFromDto(dto)
        verify(contactTypeRepository, times(1)).save(any(ContactType.class))
        verifyNoMoreInteractions(contactTypeRepository)
        assertEquals(dto.id, contactType.id)
        assertEquals(dto.name, contactType.name)
        assertEquals(dto.description, contactType.description)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create contactType from null object.")
        ContactTypeDto dto = null
        contactTypeService.createFromDto(dto)
        verifyNoMoreInteractions(contactTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        ContactTypeDto dto = createDto()
        ContactType contactTypeSaved = contactTypeService.updateFromDto(dto)
        verify(contactTypeRepository, times(1)).findById(contactType.id)
        verify(contactTypeRepository, times(1)).save(contactType)
        verifyNoMoreInteractions(contactTypeRepository)
        assertEquals(contactType.id, contactTypeSaved.id)
        assertEquals(contactType.name, contactTypeSaved.name)
        assertEquals(contactType.description, contactTypeSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        ContactTypeDto dto = createDto()
        dto.name = null
        dto.description = null
        ContactType contactTypeSaved = contactTypeService.updateFromDto(dto)
        verify(contactTypeRepository, times(1)).findById(contactType.id)
        verify(contactTypeRepository, times(1)).save(contactType)
        verifyNoMoreInteractions(contactTypeRepository)
        assertEquals(contactType.id, contactTypeSaved.id)
        assertEquals(contactType.name, contactTypeSaved.name)
        assertEquals(contactType.description, contactTypeSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update contactType from null object.")
        ContactTypeDto dto = null
        contactTypeService.updateFromDto(dto)
        verifyNoMoreInteractions(contactTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        contactTypeService.delete(contactType)
        verifyNoMoreInteractions(contactTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the findByDescription service method
     */
    @Test
    public void testFindByDescription() {
        ContactType result = contactTypeService.findByDescription(contactType.description)
        verify(contactTypeRepository, times(1)).findByDescription(contactType.description)
        verifyNoMoreInteractions(contactTypeRepository)
    }
}

