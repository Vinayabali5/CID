package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import lombok.RequiredArgsConstructor
import uk.ac.reigate.api.PeopleApi
import uk.ac.reigate.domain.Contact
import uk.ac.reigate.dto.ContactDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.repositories.ContactRepository
import uk.ac.reigate.services.lookup.ContactTypeService
import uk.ac.reigate.services.lookup.GenderService
import uk.ac.reigate.services.lookup.LegalSexService
import uk.ac.reigate.services.lookup.TitleService

@Service
@RequiredArgsConstructor
class ContactService implements ICoreDataService<Contact, Integer>, IDtoCreateUpdateService<ContactDto, Contact>{
    
    @Autowired
    ContactRepository contactRepository
    
    @Autowired
    PersonService personService
    
    @Autowired
    ContactTypeService contactTypeService
    
    @Autowired
    PeopleApi peopleApi
    
    @Autowired
    TitleService titleService
    
    @Autowired
    GenderService genderService
    
    @Autowired
    AddressService addressService
    
    @Autowired
    LegalSexService legalSexService
    
    /**
     * Default NoArgs constructor
     */
    ContactService() {}
    
    /**
     * Autowired Constructor
     *
     * @param contactRepository
     */
    ContactService(ContactRepository contactRepository, PersonService personService, ContactTypeService contactTypeService, PeopleApi peopleApi, TitleService titleService, GenderService genderService, AddressService addressService, LegalSexService legalSexService) {
        super();
        this.contactRepository = contactRepository;
        this.personService = personService;
        this.contactTypeService = contactTypeService;
        this.peopleApi = peopleApi;
        this.titleService = titleService;
        this.genderService = genderService;
        this.addressService = addressService;
        this.legalSexService = legalSexService;
    }
    
    /**
     * Find an individual contact using the contacts ID fields
     *
     * @param id the ID fields to search for
     * @return the Contact object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Contact findById(Integer id) {
        return contactRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all contacts
     *
     * @return a list of Contacts
     */
    @Override
    @Transactional(readOnly = true)
    List<Contact> findAll() {
        return contactRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Contact object in the database
     *
     * @param contact the new Contact object to be saved
     * @return the saved version of the Contact object
     */
    @Transactional
    public Contact save(Contact contact) {
        return contactRepository.save(contact)
    }
    
    /**
     * This service method is used to create an Contact object in the database from a partial or complete Contact object.
     *
     * @param contact the partial or complete Contact object to be saved
     * @return the saved version of the Contact object
     */
    public Contact createFromDto(ContactDto contactDto) {
        if(contactDto == null) {
            throw new InvalidDataException("Cannot create Contact from null object.")
        }
        Contact contact = new Contact()
        if(contactDto.personId != null) {
            contact.person = personService.findById(contactDto.personId)
        }
        if(contactDto.contactTypeId != null){
            contact.contactType = contactTypeService.findById(contactDto.contactTypeId)
        }
        if(contactDto.contactId != null){
            contact.contact = personService.findById(contactDto.contactId)
        } else {
            peopleApi.create(contactDto.contact)
            contact.contact = personService.createFromDto(contactDto.contact)
        }
        contact.contactable = contactDto.contactable
        contact.preferred = contactDto.preferred
        contact.alternativeAddress = contactDto.alternativeAddress
        return save(contact)
    }
    
    /**
     * This service method is used to update an Contact object in the database from a partial or complete Contact object.
     *
     * @param contact the partial or complete Contact object to be saved
     * @return the saved version of the Contact object
     */
    public Contact updateFromDto(ContactDto contactDto) {
        if(contactDto.id == null) {
            throw new InvalidDataException("Cannot update Contact from null object.")
        }
        Contact contact = findById(contactDto.id)
        contact.contactable = contactDto.contactable
        contact.preferred = contactDto.preferred
        contact.alternativeAddress = contactDto.alternativeAddress
        if(contactDto.contact != null) {
            contact.contact.firstName = contactDto.contact.firstName
            contact.contact.preferredName = contactDto.contact.preferredName
            contact.contact.surname = contactDto.contact.surname
            contact.contact.middleNames = contactDto.contact.middleNames
            contact.contact.previousSurname = contactDto.contact.previousSurname
            contact.contact.dob = contactDto.contact.dob
            contact.contact.home = contactDto.contact.home
            contact.contact.mobile = contactDto.contact.mobile
            contact.contact.work = contactDto.contact.work
            contact.contact.email = contactDto.contact.email
            contact.contact.enabled= contactDto.contact.enabled
            if(contactDto.contact.titleId != null) {
                contact.contact.title = titleService.findById(contactDto.contact.titleId)
            }
            if(contactDto.contact.genderId != null) {
                contact.contact.gender = genderService.findById(contactDto.contact.genderId)
            }
            if(contactDto.contact.legalSexId != null) {
                contact.contact.legalSex = legalSexService.findById(contactDto.contact.legalSexId)
            }
            if(contactDto.contact.addressId != null) {
                contact.contact.address = addressService.findById(contactDto.contact.addressId)
            }
        }
        if(contactDto.contactTypeId != null) {
            contact.contactType = contactTypeService.findById(contactDto.contactTypeId)
        }
        
        return save(contact)
    }
    
    /**
     * This service method is used to update an Contact object in the database from a partial or complete Contact object.
     *
     * @param contact the partial or complete Contact object to be saved
     * @return the saved version of the Contact object
     */
    @Transactional
    public Contact updateContact(Contact contact) {
        Contact contactToSave = findById(contact.id)
        if(contact.person.id != null) {
            contactToSave.person = personService.findById(contact.person.id)
        }
        if(contact.contact.id != null) {
            contactToSave.contact = personService.findById(contact.contact.id)
        }
        if(contact.contactType.id != null) {
            contactToSave.contactType = contactTypeService.findById(contact.contactType.id)
        }
        contactToSave.contactable = contact.contactable
        contactToSave.preferred = contact.preferred
        contactToSave.alternativeAddress = contact.alternativeAddress
        return save(contactToSave)
    }
    
    /**
     * Saves a list of Contact objects to the database
     *
     * @param contacts a list of Contacts to be saved to the database
     * @return the list of save Contact objects
     */
    @Transactional
    public List<Contact> saveContacts(List<Contact> contacts) {
        return contacts.collect { contact -> save( contact ) };
    }
    
    /**
     * Find contact by using personId
     *
     * @param personId
     * @return the Contact object that matches the personId supplied, or null if not found
     */
    public List<Contact> searchByPersonId (Integer personId) {
        List<Contact> contacts = contactRepository.findByPerson(personService.findById(personId))
        return contacts
    }
    
    /**
     * Delete a contact based on the ID supplied
     * 
     * @param contactId the ID of the contact to delete
     */
    @PreAuthorize("@securityChecker.checkWriter(authentication)")
    @Transactional
    public void delete(Integer contactId) {
        contactRepository.deleteById(contactId)
    }
    
    /**
     * Delete a contact 
     *
     * @param contact object to be delete
     */
    @Override
    public void delete(Contact contact){
        contactRepository.delete(contact)
    }
}