package uk.ac.reigate.services

//import static org.springframework.util.Assert

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.SpecialCategory
import uk.ac.reigate.dto.SpecialCategoryDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.SpecialCategoryRepository

@Service
class SpecialCategoryService implements ICoreDataService<SpecialCategory, Integer>, IDtoCreateUpdateService<SpecialCategoryDto, SpecialCategory>{
    
    @Autowired
    SpecialCategoryRepository specialCategoryRepository
    
    /**
     * Default NoArgs constructor
     */
    SpecialCategoryService() {}
    
    /**
     * Autowired Constructor
     *
     * @param specialCategoryRepository
     */
    SpecialCategoryService(SpecialCategoryRepository specialCategoryRepository) {
        this.specialCategoryRepository = specialCategoryRepository;
    }
    
    /**
     * Find an individual specialCategory using the specialCategories ID fields
     *
     * @param id the ID fields to search for
     * @return the SpecialCategory object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    SpecialCategory findById(Integer id) {
        return specialCategoryRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of SpecialCategory objects
     * @return a SearchResult set with the list of SpecialCategories
     */
    @Override
    @Transactional(readOnly = true)
    List<SpecialCategory> findAll() {
        return specialCategoryRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete SpecialCategory object in the database
     *
     * @param specialCategory the new SpecialCategory object to be saved
     * @return the saved version of the SpecialCategory object
     */
    @Override
    @Transactional
    public SpecialCategory save(SpecialCategory specialCategory) {
        return specialCategoryRepository.save(specialCategory)
    }
    
    /**
     * This service method is used to create a SpecialCategory object in the database from a partial or complete SpecialCategory object.
     *
     * @param specialCategory the partial or complete SpecialCategory object to be saved
     * @return the saved version of the SpecialCategory object
     */
    
    @Transactional
    public SpecialCategory createFromDto(SpecialCategoryDto specialCategory) {
        if (specialCategory == null) {
            throw new InvalidDataException("Cannot create specialCategoryDto from null object.")
        }
        SpecialCategory specialCategoryToSave = new SpecialCategory()
        specialCategoryToSave.code = specialCategory.code
        specialCategoryToSave.description = specialCategory.description
        specialCategoryToSave.details = specialCategory.details
        specialCategoryToSave.priority = specialCategory.priority
        specialCategoryToSave.sendEmail = specialCategory.sendEmail
        return save(specialCategoryToSave)
    }
    
    /**
     * This service method is used to update a SpecialCategory object in the database from a partial or complete SpecialCategory object.
     *
     * @param specialCategory the partial or complete SpecialCategory object to be saved
     * @return the saved version of the SpecialCategory object
     */
    
    @Transactional
    public SpecialCategory updateFromDto(SpecialCategoryDto specialCategory) {
        if (specialCategory == null) {
            throw new InvalidDataException("Cannot update specialCategoryDto from null object.")
        }
        SpecialCategory specialCategoryToSave = findById(specialCategory.id)
        specialCategoryToSave.code = specialCategory.code
        specialCategoryToSave.description = specialCategory.description
        specialCategoryToSave.details = specialCategory.details
        specialCategoryToSave.priority = specialCategory.priority
        specialCategoryToSave.sendEmail = specialCategory.sendEmail
        return save(specialCategoryToSave)
    }
    
    /**
     * Saves a list of SpecialCategory objects to the database
     *
     * @param specialCategorys a list of SpecialCategorys to be saved to the database
     * @return the list of save SpecialCategory objects
     */
    
    @Transactional
    public List<SpecialCategory> saveSpecialCategories(List<SpecialCategory> specialCategories) {
        return specialCategories.collect { specialCategory -> save(specialCategory) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. SpecialCategory should not be deleted.
     */
    @Override
    public void delete(SpecialCategory obj) {
        throw new InvalidOperationException("SpecialCategory should not be deleted")
        
    }
    
    
}
