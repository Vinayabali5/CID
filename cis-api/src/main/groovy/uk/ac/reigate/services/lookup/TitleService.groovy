package uk.ac.reigate.services.lookup

//import static org.springframework.util.Assert

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.Title
import uk.ac.reigate.dto.lookup.TitleDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.TitleRepository
import uk.ac.reigate.services.ICoreDataService

@Service
class TitleService implements ICoreDataService<Title, Integer>{
    
    @Autowired
    TitleRepository titleRepository
    
    /**
     * Default NoArgs constructor
     */
    TitleService() {}
    
    /**
     * Autowired Constructor
     *
     * @param titleRepository
     */
    TitleService(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }
    
    /**
     * Find an individual title using the titles ID fields
     *
     * @param id the ID fields to search for
     * @return the Title object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Title findById(Integer id) {
        return titleRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of Title objects
     * @return a List of Titles
     */
    @Override
    @Transactional(readOnly = true)
    List<Title> findAll() {
        List<Title> titles = titleRepository.findAll();
        return titles
    }
    
    /**
     * This service method is used to save a complete Title object in the database
     *
     * @param title the new Title object to be saved
     * @return the saved version of the Title object
     */
    @Override
    @Transactional
    public Title save(Title title) {
        return titleRepository.save(title)
    }
    
    /**
     * This service method is used to update an Title object in the database from a partial or complete Title object.
     *
     * @param title the partial or complete Title object to be saved
     * @return the saved version of the Title object
     */
    
    @Transactional
    public Title createFromDto(TitleDto titleDto) {
        if (titleDto == null) {
            throw new InvalidDataException("Cannot create title from null object.")
        }
        Title title = new Title()
        title.code = titleDto.code
        title.description = titleDto.description
        return save(title)
    }
    
    /**
     * This service method is used to update an Title object in the database from a partial or complete Title object.
     *
     * @param title the partial or complete Title object to be saved
     * @return the saved version of the Title object
     */
    
    @Transactional
    public Title updateFromDto(TitleDto titleDto) {
        if (titleDto == null) {
            throw new InvalidDataException("Cannot update title from null object.")
        }
        Title title = findById(titleDto.id)
        title.code = titleDto.code
        title.description = titleDto.description
        return save(title)
    }
    
    /**
     * Saves a list of Title objects to the database
     *
     * @param titles a list of Titles to be saved to the database
     * @return the list of save Title objects
     */
    
    @Transactional
    public List<Title> saveTitles(List<Title> titles) {
        return titles.collect { title -> save(title) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Title should not be deleted.
     */
    @Override
    public void delete(Title obj) {
        throw new InvalidOperationException("Title should not be deleted")
        
    }
    
    
    @Transactional(readOnly = true)
    Title findByDescription(String description) {
        return titleRepository.findByDescription(description);
    }
    
}
