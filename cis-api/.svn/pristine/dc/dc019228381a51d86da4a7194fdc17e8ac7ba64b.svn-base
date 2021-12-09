package uk.ac.reigate.dto.ilp;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.ilp.LetterType

/**
 *
 * JSON  DTO containing LetterType data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class LetterTypeDto  {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String type;
    
    @JsonProperty
    private Boolean requireTarget
    
    @JsonProperty
    private Boolean requireAuthorisation;
    
    /**
     * Default No Args constructor
     */
    public LetterTypeDto() {
    }
    
    /**
     * Constructor to create a LetterTypeDto object from a LetterType object
     *
     * @param letterType the LetterType object to use for construction
     */
    LetterTypeDto(LetterType letterType) {
        this.id = letterType.id;
        this.type = letterType.type;
        this.requireTarget = letterType.requireTarget
        this.requireAuthorisation = letterType.requireAuthorisation;
    }
    
    /**
     * This static method is used to create a LetterTypeDto from a LetterType data object.
     *
     * @param letterType the LetterType data object to use for the creation.
     * @return a LetterTypeDto object based on the LetterType data object supplied.
     */
    public static LetterTypeDto mapFromEntity(LetterType letterType) {
        return new LetterTypeDto(letterType);
    }
    
    /**
     * This static method is used to create a List of LetterTypeDto from a List of LetterType data object.
     *
     * @param letterTypes the List of LetterType data object to use for the creation.
     * @return a List of LetterTypeDto object based on the List of LetterType data object supplied.
     */
    public static List<LetterTypeDto> mapFromList(List<LetterType> letterTypes) {
        return letterTypes.collect { letterType ->  new LetterTypeDto(letterType) };
    }
}
