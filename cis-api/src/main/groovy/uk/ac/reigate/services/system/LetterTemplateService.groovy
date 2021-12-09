package uk.ac.reigate.services.system

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.system.LetterTemplate
import uk.ac.reigate.dto.LetterTemplateDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.system.LetterTemplateRepository
import uk.ac.reigate.services.ICoreDataService

@Service
class LetterTemplateService implements ICoreDataService<LetterTemplate, Integer>{
    
    
    @Autowired
    LetterTemplateRepository letterTemplateRepository
    
    /**
     * Default NoArgs constructor
     */
    LetterTemplateService(){}
    
    /**
     * Autowired Constructor
     *
     * @param letterTemplateRepository
     */
    LetterTemplateService(LetterTemplateRepository letterTemplateRepository){
        this.letterTemplateRepository = letterTemplateRepository;
    }
    
    /**
     * Find an letterTemplate using the ID
     *
     * @param id the LetterTemplate id
     * @return the LetterTemplate object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    public LetterTemplate findById(Integer id) {
        return letterTemplateRepository.findById(id).orElse(null)
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<LetterTemplate> findAll() {
        return letterTemplateRepository.findAll()
    }
    
    @Override
    public LetterTemplate save(LetterTemplate letterTemplate) {
        return letterTemplateRepository.save(letterTemplate)
    }
    
    /**
     * This service method is used to create an LetterTemplate object in the database from a partial or complete LetterTemplate object.
     *
     * @param letterTemplate the partial or complete LetterTemplate object to be saved
     * @return the saved version of the LetterTemplate object
     */
    @Transactional
    public LetterTemplate createFromDto(LetterTemplateDto letterTemplate) {
        if(letterTemplate == null) {
            throw new InvalidDataException("Cannot create LetterTemplate from null object.")
        }
        LetterTemplate letterTemplateToSave = new LetterTemplate()
        letterTemplateToSave.name = letterTemplate.name
        letterTemplateToSave.description = letterTemplate.description
        letterTemplateToSave.templateText = letterTemplate.templateText
        letterTemplateToSave.inUse = letterTemplate.inUse
        return save(letterTemplateToSave)
    }
    
    /**
     * This service method is used to update a LetterTemplate object in the database from a partial or complete LetterTemplate object.
     *
     * @param letterTemplate the partial or complete LetterTemplate object to be saved
     * @return the saved version of the LetterTemplate object
     */
    @Transactional
    public LetterTemplate updateFromDto(LetterTemplateDto letterTemplate) {
        if(letterTemplate == null) {
            throw new InvalidDataException("Cannot update LetterTemplate from null object.")
        }
        LetterTemplate letterTemplateToSave = findById(letterTemplate.id)
        letterTemplateToSave.name = letterTemplate.name
        letterTemplateToSave.description = letterTemplate.description
        letterTemplateToSave.templateText = letterTemplate.templateText
        letterTemplateToSave.inUse = letterTemplate.inUse
        return save(letterTemplateToSave)
    }
    
    @Override
    //LetterTemplate cannot be deleted.
    public void delete(LetterTemplate obj) {
        throw new InvalidOperationException("Letter Template should not be deleted.")
    }
    
    public List<LetterTemplate> findValidLetterTemplates(){
        return letterTemplateRepository.findValidTemplate()
    }
    
}