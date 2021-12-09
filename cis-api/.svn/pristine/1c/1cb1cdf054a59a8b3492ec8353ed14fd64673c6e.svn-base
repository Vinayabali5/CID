package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.ilr.LLDDHealthProblem
import uk.ac.reigate.exceptions.InvalidDataException

/**
 *
 * JSON serializable DTO containing LLDDHealthProblem data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class LLDDHealthProblemDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private String shortDescription;
    
    @JsonProperty
    private Date validFrom;
    
    @JsonProperty
    private Date validTo;
    
    /**
     * Default No Args constructor
     */
    public LLDDHealthProblemDto() {
    }
    
    /**
     * Constructor to create a LLDDHealthProblemDto object from a LLDDHealthProblem object
     *
     * @param lLDDHealthProblem the LLDDHealthProblem object to use for construction
     */
    LLDDHealthProblemDto(LLDDHealthProblem lLDDHealthProblem) {
        if(lLDDHealthProblem != null) {
            this.id = lLDDHealthProblem.id;
            this.code = lLDDHealthProblem.code;
            this.description = lLDDHealthProblem.description;
            this.shortDescription = lLDDHealthProblem.shortDescription;
            this.validFrom = lLDDHealthProblem.validFrom;
            this.validTo = lLDDHealthProblem.validTo;
        } else {
            return null;
        }
    }
    
    /**
     * This static method is used to create a LLDDHealthProblemDto from a LLDDHealthProblem data object.
     *
     * @param lLDDHealthProblem the LLDDHealthProblem data object to use for the creation.
     * @return a LLDDHealthProblemDto object based on the LLDDHealthProblem data object supplied.
     */
    public static LLDDHealthProblemDto mapFromEntity(LLDDHealthProblem lLDDHealthProblem) {
        return new LLDDHealthProblemDto(lLDDHealthProblem);
    }
    
    /**
     * This static method is used to create a List of LLDDHealthProblemDto from a List of LLDDHealthProblem data object.
     *
     * @param lLDDHealthProblems the List of LLDDHealthProblem data object to use for the creation.
     * @return a List of LLDDHealthProblemDto object based on the List of LLDDHealthProblem data object supplied.
     */
    public static List<LLDDHealthProblemDto> mapFromList(List<LLDDHealthProblem> lLDDHealthProblems) {
        List<LLDDHealthProblemDto> output = lLDDHealthProblems.collect { lLDDHealthProblem ->  new LLDDHealthProblemDto(lLDDHealthProblem) };
        return output
    }
}