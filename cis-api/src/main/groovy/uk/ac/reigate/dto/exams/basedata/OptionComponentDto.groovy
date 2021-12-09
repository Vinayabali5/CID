package uk.ac.reigate.dto.exams.basedata

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.basedata.OptionComponent

import groovy.transform.EqualsAndHashCode

@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class OptionComponentDto {
    
    @JsonProperty
    private Integer examOptionId;
    
    @JsonProperty
    private Integer examComponentId;
    
    /**
     * Default No Args constructor
     */
    OptionComponentDto(){}
    
    /**
     * Constructor to create an Exam OptionComponent object
     *     
     * @param option
     * @param examComponent
     */
    OptionComponentDto(ExamOption examOption, ExamComponent examComponent) {
        this.examOptionId = examOption.id;
        this.examComponentId = examComponent.id;
    }
    
    /**
     * Constructor to create a OptionComponentDto object from a OptionComponent object
     *
     * @param OptionComponent object to use for construction
     */
    OptionComponentDto(OptionComponent optionComponent){
        this.examOptionId = optionComponent.examOption.id;
        this.examComponentId = optionComponent.examComponent.id;
    }
    
    /**
     * This static method is used to create a OptionComponentDto from a OptionComponent data object.
     *
     * @param optionComponent the OptionComponent data object to use for the creation.
     * @return a OptionComponentDto object based on the OptionComponent data object supplied.
     */
    public static OptionComponentDto mapFromEntity(OptionComponent optionComponent) {
        return new OptionComponentDto(optionComponent);
    }
    
    /**
     * This static method is used to create a List of OptionComponentDto from a List of OptionComponent data object.
     *
     * @param optionComponents the List of OptionComponent data object to use for the creation.
     * @return a List of OptionComponentDto object based on the List of OptionComponent data object supplied.
     */
    public static List<OptionComponentDto> mapFromList(List<OptionComponent> optionComponents) {
        return optionComponents.collect { optionComponent -> new OptionComponentDto(optionComponent) } ;
    }
}