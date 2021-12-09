package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.ilp.LetterWarningParagraph

/**
 *
 * JSON  DTO containing LetterWarningParagraph data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class LetterWarningParagraphDto  {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public LetterWarningParagraphDto() {
    }
    
    /**
     * Constructor to create a LetterWarningParagraphDto object from a LetterWarningParagraph object
     *
     * @param letterWarningParagraph the LetterWarningParagraph object to use for construction
     */
    LetterWarningParagraphDto(LetterWarningParagraph letterWarningParagraph) {
        if(letterWarningParagraph != null) {
            this.id = letterWarningParagraph.id;
            this.description = letterWarningParagraph.description;
        }
    }
    
    /**
     * This static method is used to create a LetterWarningParagraphDto from a LetterWarningParagraph data object.
     *
     * @param letterWarningParagraph the LetterWarningParagraph data object to use for the creation.
     * @return a LetterWarningParagraphDto object based on the LetterWarningParagraph data object supplied.
     */
    public static LetterWarningParagraphDto mapFromEntity(LetterWarningParagraph letterWarningParagraph) {
        return new LetterWarningParagraphDto(letterWarningParagraph);
    }
    
    /**
     * This static method is used to create a List of LetterWarningParagraphDto from a List of LetterWarningParagraph data object.
     *
     * @param letterWarningParagraphs the List of LetterWarningParagraph data object to use for the creation.
     * @return a List of LetterWarningParagraphDto object based on the List of LetterWarningParagraph data object supplied.
     */
    public static List<LetterWarningParagraphDto> mapFromList(List<LetterWarningParagraph> letterWarningParagraphs) {
        List<LetterWarningParagraphDto> output = letterWarningParagraphs.collect { letterWarningParagraph ->  new LetterWarningParagraphDto(letterWarningParagraph) };
        return output
    }
}
