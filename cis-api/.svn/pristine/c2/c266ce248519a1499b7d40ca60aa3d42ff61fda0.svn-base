package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.ilr.Destination
import uk.ac.reigate.dto.DestinationDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.DestinationRepository

@Service
class DestinationService implements ICoreDataService<Destination, Integer>, IDtoCreateUpdateService<DestinationDto, Destination>{
    
    @Autowired
    DestinationRepository destinationRepository
    
    /**
     * Default NoArgs constructor
     */
    DestinationService() {}
    
    /**
     * Autowired Constructor
     *
     * @param destinationRepository
     */
    DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository
    }
    
    /**
     * Find an individual Destination using the Destination ID fields
     *
     * @param id The ID fields to search for
     * @return The Destination object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Destination findById(Integer id) {
        return destinationRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all Destinations
     *
     * @return a List set with the list of Destination
     */
    @Override
    @Transactional(readOnly = true)
    List<Destination> findAll() {
        return destinationRepository.findAll()
    }
    
    /**
     * This method is used to save the Destination object.
     */
    @Override
    public Destination save(Destination destination) {
        return destinationRepository.save(destination);
    }
    
    /**
     * This service method is used to create an Destination object in the database from a partial or complete Destination object.
     *
     * @param destination the partial or complete Destination object to be saved
     * @return the saved version of the Destination object
     */
    @Transactional
    public Destination createFromDto(DestinationDto destination) {
        if (destination == null) {
            throw new InvalidDataException("Cannot create destination from null object.")
        }
        Destination destinationToSave = new Destination();
        destinationToSave.id = destination.id
        destinationToSave.code = destination.code
        destinationToSave.description = destination.description
        destinationToSave.type = destination.type
        destinationToSave.shortDescription = destination.shortDescription
        destinationToSave.validFrom = destination.validFrom
        destinationToSave.validTo = destination.validTo
        return save(destinationToSave)
    }
    
    /**
     * This service method is used to update an Destination object in the database from a partial or complete Destination object.
     *
     * @param destination the partial or complete Destination object to be saved
     * @return the saved version of the Destination object
     */
    @Transactional
    public Destination updateFromDto(DestinationDto destination) {
        if (destination == null) {
            throw new InvalidDataException("Cannot update destination from null object.")
        }
        Destination destinationToSave = findById(destination.id)
        destinationToSave.code = destination.code
        destinationToSave.description = destination.description
        destinationToSave.type = destination.type
        destinationToSave.shortDescription = destination.shortDescription
        destinationToSave.validFrom = destination.validFrom
        destinationToSave.validTo = destination.validTo
        return save(destinationToSave)
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Block should not be deleted.
     */
    @Override
    public void delete(Destination obj) {
        throw new InvalidOperationException("Destination should not be deleted")
    }
}
