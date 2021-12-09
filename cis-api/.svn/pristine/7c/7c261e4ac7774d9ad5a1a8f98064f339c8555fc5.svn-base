package uk.ac.reigate.dto

import com.fasterxml.jackson.annotation.JsonProperty

import uk.ac.reigate.domain.system.LetterTemplate

/**
 *
 * JSON serializable DTO containing LearningSupportCost data
 *
 */
class LetterTemplateDto implements Serializable{
    
    @JsonProperty
    Integer id
    
    @JsonProperty
    String name
    
    @JsonProperty
    String description
    
    @JsonProperty
    String templateText
    
    @JsonProperty
    Boolean inUse
    
    /**
     * Default No Args constructor
     */
    LetterTemplateDto(){
    }
    
    /**
     * Constructor to create a LetterTemplateDto object from a LetterTemplate object
     *
     * @param letterTemplate the LetterTemplate object to use for construction
     */
    LetterTemplateDto(LetterTemplate letterTemplate){
        if(letterTemplate != null) {
            this.id = letterTemplate.id
            this.name = letterTemplate.name
            this.description = letterTemplate.description
            this.templateText = letterTemplate.templateText
            this.inUse = letterTemplate.inUse
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a LetterTemplateDto from a LetterTemplate data object.
     *
     * @param letterTemplate the LetterTemplate data object to use for the creation.
     * @return a LetterTemplateDto object based on the LetterTemplate data object supplied.
     */
    public static LetterTemplateDto mapFromEntity(LetterTemplate letterTemplate) {
        return new LetterTemplateDto(letterTemplate);
    }
    
    /**
     * This static method is used to create a List of LetterTemplateDto from a List of LetterTemplate data object.
     *
     * @param letterTemplates the List of LetterTemplate data object to use for the creation.
     * @return a List of LetterTemplateDto object based on the List of LetterTemplate data object supplied.
     */
    public static List<LetterTemplateDto> mapFromList(List<LetterTemplate> letterTemplates) {
        return letterTemplates.collect { letterTemplate ->  new LetterTemplateDto(letterTemplate) };
    }
}
