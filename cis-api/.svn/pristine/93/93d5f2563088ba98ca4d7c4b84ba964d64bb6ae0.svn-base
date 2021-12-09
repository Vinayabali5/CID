package uk.ac.reigate.services.lookup

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.FileCategory
import uk.ac.reigate.dto.lookup.FileCategoryDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.FileCategoryRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class FileCategoryService implements ICoreDataService<FileCategory, Integer>, IDtoCreateUpdateService<FileCategoryDto, FileCategory>{
    
    @Autowired
    FileCategoryRepository fileCategoryRepository
    
    /**
     * Default NoArgs constructor
     */
    FileCategoryService() {}
    
    /**
     * Autowired Constructor
     *
     * @param fileCategoryRepository
     */
    FileCategoryService(FileCategoryRepository fileCategoryRepository) {
        this.fileCategoryRepository = fileCategoryRepository;
    }
    
    /**
     * Find an individual fileCategory using the fileCategorys ID fields
     *
     * @param id the ID fields to search for
     * @return the FileCategory object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    FileCategory findById(Integer id) {
        return fileCategoryRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of FileCategory objects
     * @return a List of FileCategories
     */
    @Override
    @Transactional(readOnly = true)
    List<FileCategory> findAll() {
        return fileCategoryRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete FileCategory object in the database
     *
     * @param fileCategory the new FileCategory object to be saved
     * @return the saved version of the FileCategory object
     */
    @Override
    @Transactional
    public FileCategory save(FileCategory fileCategory) {
        return fileCategoryRepository.save(fileCategory)
    }
    
    /**
     * This service method is used to update an FileCategory object in the database from a partial or complete FileCategory object.
     *
     * @param fileCategory the partial or complete FileCategory object to be saved
     * @return the saved version of the FileCategory object
     */
    @Transactional
    public FileCategory createFromDto(FileCategoryDto fileCategoryDto) {
        if (fileCategoryDto == null) {
            throw new InvalidDataException("Cannot create fileCategory from null object.")
        }
        FileCategory fileCategory = new FileCategory()
        fileCategory.code = fileCategoryDto.code
        fileCategory.description = fileCategoryDto.description
        return save(fileCategory)
    }
    
    /**
     * This service method is used to update an FileCategory object in the database from a partial or complete FileCategory object.
     *
     * @param fileCategory the partial or complete FileCategory object to be saved
     * @return the saved version of the FileCategory object
     */
    @Transactional
    public FileCategory updateFromDto(FileCategoryDto fileCategoryDto) {
        if (fileCategoryDto == null) {
            throw new InvalidDataException("Cannot update fileCategory from null object.")
        }
        FileCategory fileCategory = findById(fileCategoryDto.id)
        fileCategory.code = fileCategoryDto.code
        fileCategory.description = fileCategoryDto.description
        return save(fileCategory)
    }
    
    /**
     * Saves a list of FileCategory objects to the database
     *
     * @param fileCategories a list of FileCategories to be saved to the database
     * @return the list of save FileCategory objects
     */
    @Transactional
    public List<FileCategory> saveFileCategorys(List<FileCategory> fileCategories) {
        return fileCategories.collect { fileCategory -> save(fileCategory) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. FileCategory should not be deleted.
     */
    @Override
    public void delete(FileCategory obj) {
        throw new InvalidOperationException("FileCategory should not be deleted")
    }
}
