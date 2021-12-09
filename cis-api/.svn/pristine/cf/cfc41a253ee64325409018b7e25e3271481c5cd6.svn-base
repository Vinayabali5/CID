package uk.ac.reigate.services

//import static org.springframework.util.Assert

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.learning_support.LearningSupportCostCategory
import uk.ac.reigate.dto.LearningSupportCostCategoryDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.learning_support.LearningSupportCostCategoryRepository

@Service
class LearningSupportCostCategoryService implements ICoreDataService<LearningSupportCostCategory, Integer>, IDtoCreateUpdateService<LearningSupportCostCategoryDto, LearningSupportCostCategory>{
    
    @Autowired
    LearningSupportCostCategoryRepository learningSupportCostCategoryRepository
    
    /**
     * Default NoArgs constructor
     */
    LearningSupportCostCategoryService() {}
    
    /**
     * Autowired Constructor
     *
     * @param learningSupportCostCategoryRepository
     */
    LearningSupportCostCategoryService(LearningSupportCostCategoryRepository learningSupportCostCategoryRepository) {
        this.learningSupportCostCategoryRepository = learningSupportCostCategoryRepository
    }
    
    /**
     * Find an individual learningSupportCostCategory using the learningSupportCostCategorys ID fields
     *
     * @param id the ID fields to search for
     * @return the LearningSupportCostCategory object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    LearningSupportCostCategory findById(Integer id) {
        return learningSupportCostCategoryRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of LearningSupportCostCategory objects
     * @return a SearchResult set with the list of LearningSupportCostCategorys
     */
    @Override
    @Transactional(readOnly = true)
    List<LearningSupportCostCategory> findAll() {
        return learningSupportCostCategoryRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete LearningSupportCostCategory object in the database
     *
     * @param learningSupportCostCategory the new LearningSupportCostCategory object to be saved
     * @return the saved version of the LearningSupportCostCategory object
     */
    @Override
    @Transactional
    public LearningSupportCostCategory save(LearningSupportCostCategory learningSupportCostCategory) {
        return learningSupportCostCategoryRepository.save(learningSupportCostCategory)
    }
    
    /**
     * This service method is used to update a LearningSupportCostCategory object in the database from a partial or complete LearningSupportCostCategory object.
     *
     * @param learningSupportCostCategory the partial or complete LearningSupportCostCategory object to be saved
     * @return the saved version of the LearningSupportCostCategory object
     */
    @Transactional
    public LearningSupportCostCategory createFromDto(LearningSupportCostCategoryDto learningSupportCostCategory) {
        if (learningSupportCostCategory == null) {
            throw new InvalidDataException("Cannot create learningSupportCostCategoryDto from null object.")
        }
        LearningSupportCostCategory learningSupportCostCategoryToSave = new LearningSupportCostCategory()
        learningSupportCostCategoryToSave.category = learningSupportCostCategory.category
        return save(learningSupportCostCategoryToSave)
    }
    
    /**
     * This service method is used to update a LearningSupportCostCategory object in the database from a partial or complete LearningSupportCostCategory object.
     *
     * @param learningSupportCostCategory the partial or complete LearningSupportCostCategory object to be saved
     * @return the saved version of the LearningSupportCostCategory object
     */
    @Transactional
    public LearningSupportCostCategory updateFromDto(LearningSupportCostCategoryDto learningSupportCostCategory) {
        if (learningSupportCostCategory == null) {
            throw new InvalidDataException("Cannot update learningSupportCostCategoryDto from null object.")
        }
        LearningSupportCostCategory learningSupportCostCategoryToSave = findById(learningSupportCostCategory.id)
        learningSupportCostCategoryToSave.category = learningSupportCostCategory.category
        return save(learningSupportCostCategoryToSave)
    }
    
    /**
     * Saves a list of LearningSupportCostCategory objects to the database
     *
     * @param learningSupportCostCategorys a list of LearningSupportCostCategorys to be saved to the database
     * @return the list of save LearningSupportCostCategory objects
     */
    @Transactional
    public List<LearningSupportCostCategory> saveLearningSupportCostCategorys(List<LearningSupportCostCategory> learningSupportCostCategories) {
        return learningSupportCostCategories.collect { learningSupportCostCategory -> save(learningSupportCostCategory) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. LearningSupportCostCategory should not be deleted.
     */
    @Override
    public void delete(LearningSupportCostCategory obj) {
        throw new InvalidOperationException("LearningSupportCostCategory should not be deleted")
        
    }
}