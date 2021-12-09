package uk.ac.reigate.dto.ilr;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.ilr.CompletionStatus

/**
 *
 * JSON serializable DTO containing CompletionStatus data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class CompletionStatusDto implements Serializable {
    
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
    public CompletionStatusDto() {
    }
    
    /**
     * Constructor to create a CompletionStatusDto object from a CompletionStatus object
     *
     * @param completionStatus the CompletionStatus object to use for construction
     */
    CompletionStatusDto(CompletionStatus completionStatus) {
        if(completionStatus != null) {
            this.id = completionStatus.id;
            this.code = completionStatus.code;
            this.description = completionStatus.description;
            this.shortDescription = completionStatus.shortDescription;
            this.validFrom = completionStatus.validFrom;
            this.validTo = completionStatus.validTo;
        }
    }
    
    /**
     * This static method is used to create a CompletionStatusDto from a CompletionStatus data object.
     *
     * @param completionStatus the CompletionStatus data object to use for the creation.
     * @return a CompletionStatusDto object based on the CompletionStatus data object supplied.
     */
    public static CompletionStatusDto mapFromEntity(CompletionStatus completionStatus) {
        return new CompletionStatusDto(completionStatus);
    }
    
    /**
     * This static method is used to create a List of CompletionStatusDto from a List of CompletionStatus data object.
     *
     * @param completionStatuss the List of CompletionStatus data object to use for the creation.
     * @return a List of CompletionStatusDto object based on the List of CompletionStatus data object supplied.
     */
    public static List<CompletionStatusDto> mapFromList(List<CompletionStatus> completionStatuses) {
        return  completionStatuses.collect { completionStatus ->  new CompletionStatusDto(completionStatus) };
    }
}
