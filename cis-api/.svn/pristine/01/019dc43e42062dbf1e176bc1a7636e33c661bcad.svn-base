package uk.ac.reigate.services.exams.basedata

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.basedata.OptionComponent
import uk.ac.reigate.domain.exams.basedata.OptionComponentPk
import uk.ac.reigate.dto.exams.basedata.OptionComponentDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.exams.basedata.OptionComponentRepository
import uk.ac.reigate.services.ICoreDataService

@Service
public class OptionComponentService implements ICoreDataService<OptionComponent, OptionComponentPk>{
    
    @Autowired
    OptionComponentRepository optionComponentRepository
    
    @Autowired
    ExamOptionService examOptionService
    
    @Autowired
    ExamComponentService examComponentService
    
    /**
     * Default NoArgs constructor
     */
    OptionComponentService() {}
    
    /**
     * Autowired constructor
     * 
     * @param optionComponentRepository
     */
    OptionComponentService(OptionComponentRepository optionComponentRepository, ExamOptionService examOptionService, ExamComponentService examComponentService) {
        super();
        this.optionComponentRepository = optionComponentRepository;
        this.examOptionService = examOptionService;
        this.examComponentService = examComponentService;
    }
    
    /**
     * find an individual exam basedata OptionComponent by optionId and examComponentId
     * 
     * @param optionId
     * @param componentId   
     * @return OptionComponent
     */
    @Transactional(readOnly = true)
    public OptionComponent findOptionComponent(Integer examOptionId, Integer examComponentId) {
        return findById(new OptionComponentPk(examOptionId, examComponentId));
    }
    
    
    /**
     * find an individual exam basedata OptionComponent by optionComponentId
     * @param optionComponentId
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public OptionComponent findById(OptionComponentPk optionComponentPk) {
        return optionComponentRepository.findById(optionComponentPk).orElse(null)
    }
    
    /**
     * find all option components
     * 
     * @returns a SearchResult set with the list of option components
     */
    @Override
    @Transactional(readOnly = true)
    public List<OptionComponent> findAll() {
        return optionComponentRepository.findAll();
    }
    
    /**
     * Save an OptionComponent object to the database
     *
     * @param OptionComponent - the OptionComponent object to save
     * @return the saved OptionComponent object
     */
    @Override
    public OptionComponent save(OptionComponent optionComponent) {
        return optionComponentRepository.save(optionComponent)
    }
    
    /**
     * This Service method is used to create a new OptionComponent data object from the supplied OptionComponentDto
     * @param OptionComponentDto
     * @return
     */
    @Transactional
    public OptionComponent createFromDto(OptionComponentDto optionComponentDto) {
        if (optionComponentDto == null) {
            throw new InvalidDataException("Cannot create optionComponentDto from null object.")
        }
        OptionComponent optionComponent = new OptionComponent()
        if(optionComponentDto.examOptionId != null) {
            optionComponent.examOption = examOptionService.findById(optionComponentDto.examOptionId)
        }
        if(optionComponentDto.examComponentId != null) {
            optionComponent.examComponent = examComponentService.findById(optionComponentDto.examComponentId)
        }
        return save(optionComponent)
    }
    
    /**
     * This service method is used to Delete the CourseOption object from the database
     *
     * @param examComponentId the ID of the ExamComponent object to delete
     * @param examOptionId  the ID of the ExamOption object to delete
     */
    public Boolean deleteByIds(Integer examOptionId, Integer examComponentId) {
        OptionComponent optionComponent =  findOptionComponent(examOptionId, examComponentId);
        if(optionComponent != null) {
            delete(optionComponent)
            return true;
        }
        return false;
    }
    
    /**
     * This method is used to delete by course and examOption object.
     */
    public Boolean deleteByCourseAndExamOption(ExamOption examOption, ExamComponent examComponent) {
        return deleteByIds(examOption.id, examComponent.id)
    }
    
    /**
     * This method is used to delete by OptionComponent object
     */
    @Override
    public void delete(OptionComponent optionComponent) {
        optionComponentRepository.delete(optionComponent);
    }
}
