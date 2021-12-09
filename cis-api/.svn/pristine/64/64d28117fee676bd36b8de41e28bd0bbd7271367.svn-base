package uk.ac.reigate.services.lookup

//import static org.springframework.util.Assert

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.ContactType
import uk.ac.reigate.dto.lookup.ContactTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.ContactTypeRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class ContactTypeService implements ICoreDataService<ContactType, Integer>, IDtoCreateUpdateService<ContactTypeDto, ContactType>{
    
    @Autowired
    ContactTypeRepository contactTypeRepository
    
    /**
     * Default NoArgs constructor
     */
    ContactTypeService() {}
    
    /**
     * Autowired Constructor
     *
     * @param contactTypeRepository
     */
    ContactTypeService(ContactTypeRepository contactTypeRepository){
        this.contactTypeRepository = contactTypeRepository;
    }
    
    /**
     * Find an individual contactType using the contactTypes ID fields
     *
     * @param id the ID fields to search for
     * @return the ContactType object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    ContactType findById(Integer id) {
        return contactTypeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all contactTypes
     *
     * @return a List of ContactTypes
     */
    @Override
    @Transactional(readOnly = true)
    List<ContactType> findAll() {
        return contactTypeRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete ContactType object in the database
     *
     * @param contactType the new ContactType object to be saved
     * @return the saved version of the ContactType object
     */
    @Override
    @Transactional
    public ContactType save(ContactType contactType) {
        return contactTypeRepository.save(contactType)
    }
    
    /**
     * Saves a list of ContactType objects to the database
     *
     * @param contactTypes a list of ContactTypes to be saved to the database
     * @return the list of save ContactType objects
     */
    @Transactional
    public List<ContactType> saveContactTypes(List<ContactType> contactTypes) {
        return contactTypes.collect { contactType -> save(contactType) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. ContactType should not be deleted.
     */
    @Override
    public void delete(ContactType obj) {
        throw new InvalidOperationException("ContactType should not be deleted")
        
    }
    
    /**
     * Find all contactTypes
     *
     * @return a List of ContactTypes
     */
    @Transactional(readOnly = true)
    ContactType findByDescription(String description) {
        return contactTypeRepository.findByDescription(description)
    }
    
    /**
     * This service method is used to create an ContactType object in the database from a partial or complete ContactType object.
     * @param contactType the partial or complete ContactType object to be saved
     * @return the saved version of the ContactType object
     */
    public ContactType createFromDto(ContactTypeDto contactTypeDto) {
        if (contactTypeDto == null) {
            throw new InvalidDataException("Cannot create contactType from null object.")
        }
        ContactType contactType = new ContactType()
        contactType.name = contactTypeDto.name
        contactType.description = contactTypeDto.description
        return save(contactType)
    }
    
    /**
     * This service method is used to update an ContactType object in the database from a partial or complete ContactType object.
     *
     * @param contactType the partial or complete ContactType object to be saved
     * @return the saved version of the ContactType object
     */
    public ContactType updateFromDto(ContactTypeDto contactTypeDto) {
        if (contactTypeDto == null) {
            throw new InvalidDataException("Cannot update contactType from null object.")
        }
        ContactType contactType = findById(contactTypeDto.id);
        contactType.name = contactTypeDto.name
        contactType.description = contactTypeDto.description
        return save(contactType)
    }
    
}
