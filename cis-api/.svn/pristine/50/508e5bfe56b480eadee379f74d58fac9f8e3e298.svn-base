package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.ilr.LLDDHealthProblemCategory
import uk.ac.reigate.dto.LLDDHealthProblemCategoryDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.LLDDHealthProblemCategoryRepository

@Service
class LLDDHealthProblemCategoryService implements ICoreDataService<LLDDHealthProblemCategory, Integer>, IDtoCreateUpdateService<LLDDHealthProblemCategoryDto, LLDDHealthProblemCategory>{
    
    @Autowired
    LLDDHealthProblemCategoryRepository lLDDHealthProblemCategoryRepository
    
    /**
     * Default NoArgs constructor
     */
    LLDDHealthProblemCategoryService() {}
    
    /**
     * Autowired Constructor
     *
     * @param lLDDHealthProblemCategoryRepository
     */
    LLDDHealthProblemCategoryService(LLDDHealthProblemCategoryRepository lLDDHealthProblemCategoryRepository) {
        this.lLDDHealthProblemCategoryRepository = lLDDHealthProblemCategoryRepository;
    }
    
    /**
     * Find an individual lLDDHealthProblemCategory using the lLDDHealthProblemCategorys ID fields
     *
     * @param id the ID fields to search for
     * @return the LLDDHealthProblemCategory object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    LLDDHealthProblemCategory findById(Integer id) {
        return lLDDHealthProblemCategoryRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all lLDDHealthProblemCategorys
     *
     * @return a SearchResult set with the list of LLDDHealthProblemCategorys
     */
    @Override
    @Transactional(readOnly = true)
    List<LLDDHealthProblemCategory> findAll() {
        return lLDDHealthProblemCategoryRepository.findAll()
    }
    
    /**
     * This service method is used to save a complete LLDDHealthProblemCategory object in the database
     *
     * @param lLDDHealthProblemCategory the new LLDDHealthProblemCategory object to be saved
     * @return the saved version of the LLDDHealthProblemCategory object
     */
    @Override
    @Transactional
    public LLDDHealthProblemCategory save(LLDDHealthProblemCategory lLDDHealthProblemCategory) {
        return lLDDHealthProblemCategoryRepository.save(lLDDHealthProblemCategory)
    }
    
    /**
     * This service method is used to update an LLDDHealthProblemCategory object in the database from a partial or complete LLDDHealthProblemCategory object.
     *
     * @param lLDDHealthProblemCategory the partial or complete LLDDHealthProblemCategory object to be saved
     * @return the saved version of the LLDDHealthProblemCategory object
     */
    @Transactional
    public LLDDHealthProblemCategory createFromDto(LLDDHealthProblemCategoryDto lLDDHealthProblemCategory) {
        if (lLDDHealthProblemCategory == null) {
            throw new InvalidDataException("Cannot create lLDDHealthProblemCategory from null object.")
        }
        LLDDHealthProblemCategory lLDDHealthProblemCategoryToSave = new LLDDHealthProblemCategory()
        lLDDHealthProblemCategoryToSave.code = lLDDHealthProblemCategory.code
        lLDDHealthProblemCategoryToSave.description = lLDDHealthProblemCategory.description
        lLDDHealthProblemCategoryToSave.shortDescription = lLDDHealthProblemCategory.shortDescription
        lLDDHealthProblemCategoryToSave.validFrom = lLDDHealthProblemCategory.validFrom
        lLDDHealthProblemCategoryToSave.validTo = lLDDHealthProblemCategory.validTo
        return save(lLDDHealthProblemCategoryToSave)
    }
    
    /**
     * This service method is used to update an LLDDHealthProblemCategory object in the database from a partial or complete LLDDHealthProblemCategory object.
     *
     * @param lLDDHealthProblemCategory the partial or complete LLDDHealthProblemCategory object to be saved
     * @return the saved version of the LLDDHealthProblemCategory object
     */
    @Transactional
    public LLDDHealthProblemCategory updateFromDto(LLDDHealthProblemCategoryDto lLDDHealthProblemCategory) {
        if (lLDDHealthProblemCategory == null) {
            throw new InvalidDataException("Cannot update lLDDHealthProblemCategory from null object.")
        }
        if (lLDDHealthProblemCategory.id == null) {
            throw new InvalidDataException("Cannot update lLDDHealthProblemCategory when the id is null.")
        }
        LLDDHealthProblemCategory lLDDHealthProblemCategoryToSave = findById(lLDDHealthProblemCategory.id)
        lLDDHealthProblemCategoryToSave.code = lLDDHealthProblemCategory.code
        lLDDHealthProblemCategoryToSave.description = lLDDHealthProblemCategory.description
        lLDDHealthProblemCategoryToSave.shortDescription = lLDDHealthProblemCategory.shortDescription
        lLDDHealthProblemCategoryToSave.validFrom = lLDDHealthProblemCategory.validFrom
        lLDDHealthProblemCategoryToSave.validTo = lLDDHealthProblemCategory.validTo
        return save(lLDDHealthProblemCategoryToSave)
    }
    
    /**
     * Saves a list of LLDDHealthProblemCategory objects to the database
     *
     * @param lLDDHealthProblemCategorys a list of LLDDHealthProblemCategorys to be saved to the database
     * @return the list of save LLDDHealthProblemCategory objects
     */
    @Transactional
    public List<LLDDHealthProblemCategory> saveLLDDHealthProblemCategories(List<LLDDHealthProblemCategory> lLDDHealthProblemCategories) {
        return lLDDHealthProblemCategories.collect { lLDDHealthProblemCategory -> save(lLDDHealthProblemCategory) }
    }
    
    /**
     * This methods throws an InvalidOperationException when called. LLDDHealthProblemCategory should not be deleted.
     */
    @Override
    public void delete(LLDDHealthProblemCategory obj) {
        throw new InvalidOperationException("LLDDHealthProblemCategory should not be deleted")
    }
    
    LLDDHealthProblemCategory findByCode(String code) {
        return lLDDHealthProblemCategoryRepository.findByCode(code)
    }
}
