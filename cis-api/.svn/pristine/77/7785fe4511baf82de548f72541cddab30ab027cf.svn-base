package uk.ac.reigate.services.admissions

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.admissions.InterviewCategory
import uk.ac.reigate.dto.admissions.InterviewCategoryDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.admissions.InterviewCategoryRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class InterviewCategoryService implements ICoreDataService<InterviewCategory, Integer>, IDtoCreateUpdateService<InterviewCategoryDto, InterviewCategory> {
    
    @Autowired
    InterviewCategoryRepository interviewCategoryRepository
    
    /**
     * Default NoArgs constructor
     */
    InterviewCategoryService() {}
    
    /**
     * Autowired Constructor
     *
     * @param interviewCategoryRepository
     */
    InterviewCategoryService(InterviewCategoryRepository interviewCategoryRepository) {
        this.interviewCategoryRepository = interviewCategoryRepository;
    }
    
    /**
     * Find an individual InterviewCategory using the InterviewCategory ID fields
     *
     * @param id the ID fields to search for
     * @return the InterviewCategory object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    InterviewCategory findById(Integer id) {
        return interviewCategoryRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of InterviewCategory objects
     * @return a List of InterviewCategorys
     */
    @Override
    @Transactional(readOnly = true)
    List<InterviewCategory> findAll() {
        return interviewCategoryRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete InterviewCategory object in the database
     *
     * @param interviewCategory the new InterviewCategory object to be saved
     * @return the saved version of the InterviewCategory object
     */
    @Override
    @Transactional
    public InterviewCategory save(InterviewCategory interviewCategory) {
        return interviewCategoryRepository.save(interviewCategory)
    }
    
    /**
     * This service method is used to create an InterviewCategory object in the database from a partial or complete InterviewCategory object.
     *
     * @param interviewCategory the partial or complete InterviewCategory object to be saved
     * @return the saved version of the InterviewCategory object
     */
    @Transactional
    public InterviewCategory createFromDto(InterviewCategoryDto interviewCategory) {
        if(interviewCategory == null) {
            throw new InvalidDataException("Cannot create interviewCategoryDto from null object.")
        }
        InterviewCategory interviewCategoryToSave = new InterviewCategory();
        interviewCategoryToSave.category = interviewCategory.category
        interviewCategoryToSave.description = interviewCategory.description
        return save(interviewCategoryToSave)
    }
    
    /**
     * This service method is used to update an InterviewCategory object in the database from a partial or complete InterviewCategory object.
     *
     * @param interviewCategory the partial or complete InterviewCategory object to be saved
     * @return the saved version of the InterviewCategory object
     */
    @Transactional
    public InterviewCategory updateFromDto(InterviewCategoryDto interviewCategory) {
        if(interviewCategory == null) {
            throw new InvalidDataException("Cannot update interviewCategoryDto from null object.")
        }
        InterviewCategory interviewCategoryToSave = findById(interviewCategory.id)
        interviewCategoryToSave.category = interviewCategory.category
        interviewCategoryToSave.description = interviewCategory.description
        return save(interviewCategoryToSave)
    }
    
    /**
     * Saves a list of InterviewCategory objects to the database
     *
     * @param interviewCategorys a list of InterviewCategorys to be saved to the database
     * @return the list of save InterviewCategory objects
     */
    @Transactional
    public List<InterviewCategory> saveList(List<InterviewCategory> interviewCategorys) {
        return interviewCategorys.collect { interviewCategory -> save(interviewCategory) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. InterviewCategory should not be deleted.
     */
    @Override
    public void delete(InterviewCategory obj) {
        throw new InvalidOperationException("InterviewCategory should not be deleted")
    }
    
    /**
     * This method is used to retrieve an InterviewCategory data object based on the supplied description.
     *
     * @param description the description to search for in the database
     * @return an InterviewCategory data object that matches the search criteria
     */
    public InterviewCategory findByDescription(String description) {
        return interviewCategoryRepository.findByDescription(description)
    }
}
