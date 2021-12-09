package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.admissions.CollegeFundPaid
import uk.ac.reigate.dto.CollegeFundPaidDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.repositories.admissions.CollegeFundPaidRepository

@Service
class CollegeFundPaidService implements ICoreDataService<CollegeFundPaid, Integer>, IDtoCreateUpdateService<CollegeFundPaidDto, CollegeFundPaid>{
    
    @Autowired
    CollegeFundPaidRepository collegeFundPaidRepository
    
    /**
     * Default NoArgs constructor    
     */
    CollegeFundPaidService() {}
    
    /**
     * Autowired constructor
     * 
     * @param collegeFundPaidRepository
     */
    CollegeFundPaidService(CollegeFundPaidRepository collegeFundPaidRepository) {
        this.collegeFundPaidRepository = collegeFundPaidRepository
    }
    
    /**
     * Find an individual collegeFundPaid using the collegeFundPaids ID fields
     *
     * @param id the ID fields to search for
     * @return the CollegeFundPaid object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    CollegeFundPaid findById(Integer id) {
        return collegeFundPaidRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all collegeFundPaids
     *
     * @return a List of CollegeFundPaids
     */
    @Override
    @Transactional(readOnly = true)
    List<CollegeFundPaid> findAll() {
        return collegeFundPaidRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete CollegeFundPaid object in the database
     *
     * @param collegeFundPaid the new CollegeFundPaid object to be saved
     * @return the saved version of the CollegeFundPaid object
     */
    @Override
    @Transactional
    public CollegeFundPaid save(CollegeFundPaid collegeFundPaid) {
        return collegeFundPaidRepository.save(collegeFundPaid)
    }
    
    /**
     * This service method is used to create an CollegeFundPaid object in the database from a partial or complete CollegeFundPaid object.
     *
     * @param collegeFundPaid the partial or complete CollegeFundPaid object to be saved
     * @return the saved version of the CollegeFundPaid object
     */
    @Transactional
    public CollegeFundPaid createFromDto(CollegeFundPaidDto collegeFundPaid) {
        if (collegeFundPaid == null) {
            throw new InvalidDataException("Cannot create collegeFundPaid from null object.")
        }
        CollegeFundPaid collegeFundPaidToSave = new CollegeFundPaid()
        collegeFundPaidToSave.collegeFundPaid = collegeFundPaid.collegeFundPaid
        return save(collegeFundPaidToSave)
    }
    
    /**
     * This service method is used to update an CollegeFundPaid object in the database from a partial or complete CollegeFundPaid object.
     *
     * @param collegeFundPaid the partial or complete CollegeFundPaid object to be saved
     * @return the saved version of the CollegeFundPaid object
     */
    @Transactional
    public CollegeFundPaid updateFromDto(CollegeFundPaidDto collegeFundPaid) {
        if (collegeFundPaid == null) {
            throw new InvalidDataException("Cannot update CollegeFundPaid from null object.")
        }
        if (collegeFundPaid.id == null) {
            throw new InvalidDataException("Cannot update CollegeFundPaid when the ID is null.")
        }
        CollegeFundPaid collegeFundPaidToSave = findById(collegeFundPaid.id)
        collegeFundPaidToSave.collegeFundPaid = collegeFundPaid.collegeFundPaid
        return save(collegeFundPaidToSave)
    }
    
    /**
     * Saves a list of CollegeFundPaid objects to the database
     *
     * @param collegeFundPaids a list of CollegeFundPaids to be saved to the database
     * @return the list of save CollegeFundPaid objects
     */
    @Transactional
    public List<CollegeFundPaid> saveCollegeFundPaids(List<CollegeFundPaid> collegeFundPaids) {
        return collegeFundPaids.collect { collegeFundPaid -> save(collegeFundPaid) };
    }
    
    
    /**
     * This methods throws an InvalidOperationException when called. CollegeFundPaid should not be deleted.
     */
    @Override
    public void delete(CollegeFundPaid obj) {
        throw new InvalidOperationException("CollegeFundPaid should not be deleted.")
    }
}
