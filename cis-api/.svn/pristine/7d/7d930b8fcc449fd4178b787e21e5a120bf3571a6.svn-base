package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.Address
import uk.ac.reigate.dto.AddressDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.AddressRepository

@Service
class AddressService implements ICoreDataService<Address, Integer> {
    
    @Autowired
    AddressRepository addressRepository
    
    /**
     * Default NoArgs constructor
     */
    AddressService() { }
    
    /**
     * Autowired Constructor
     *
     * @param addressRepository
     */
    AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository
    }
    
    /**
     * Find an individual address using the addresses ID fields
     *
     * @param id the ID fields to search for
     * @return the Address object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Address findById(Integer id) {
        return addressRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all addresses
     *
     * @return a SearchResult set with the list of Addresses
     */
    @Override
    @Transactional(readOnly = true)
    List<Address> findAll() {
        return addressRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Address object in the database
     *
     * @param address the new Address object to be saved
     * @return the saved version of the Address object
     */
    @Override
    @Transactional
    public Address save(Address address) {
        return addressRepository.save(address)
    }
    
    @Transactional
    public Address createFromDto(AddressDto address) {
        if(address == null) {
            throw new InvalidDataException("Cannot create address from null object")
        }
        Address addressToSave = new Address()
        addressToSave.line1 = address.line1
        addressToSave.line2 = address.line2
        addressToSave.line3 = address.line3
        addressToSave.line4 = address.line4
        addressToSave.line5 = address.line5
        addressToSave.town = address.town
        addressToSave.county = address.county
        addressToSave.postcode = address.postcode
        addressToSave.buildingName = address.buildingName
        addressToSave.subBuilding = address.subBuilding
        return save(addressToSave)
    }
    
    @Transactional
    public Address updateFromDto(AddressDto address) {
        if(address == null) {
            throw new InvalidDataException("Cannot update address from null object")
        }
        Address addressToSave = findById(address.id)
        if(findById(address.id) == null) {
            throw new InvalidDataException("Cannot update address when the id is null")
        }
        addressToSave.line1 = address.line1
        addressToSave.line2 = address.line2
        addressToSave.line3 = address.line3
        addressToSave.line4 = address.line4
        addressToSave.line5 = address.line5
        addressToSave.town = address.town
        addressToSave.county = address.county
        addressToSave.postcode = address.postcode
        addressToSave.buildingName = address.buildingName
        addressToSave.subBuilding = address.subBuilding
        return save(addressToSave)
    }
    
    /**
     * Saves a list of Address objects to the database
     *
     * @param sddresses a list of Addresses to be saved to the database
     * @return the list of save Address objects
     */
    @Transactional
    public List<Address> saveAddresses(List<Address> addresses) {
        return addresses.collect { address -> save( address) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Addresses should not be deleted.
     * 
     */
    @Override
    public void delete(Address obj) {
        throw new InvalidOperationException("Addresses should not be deleted.")
    }
}
