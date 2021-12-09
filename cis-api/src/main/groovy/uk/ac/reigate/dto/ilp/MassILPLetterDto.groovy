package uk.ac.reigate.dto.ilp

import groovy.transform.EqualsAndHashCode

import javax.validation.constraints.NotNull

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

/**
 *
 * JSON serializable DTO containing Letter data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class MassILPLetterDto extends MassILPEntryBaseDto implements Serializable {
    
    @NotNull
    @JsonProperty
    Integer statementId
    
    @NotNull
    @JsonProperty
    Integer courseGroupId
    
    @JsonProperty
    String pieceOfWork
    
    @JsonProperty
    Date originalDueDate
    
    @NotNull
    @JsonProperty
    Date dueDate
    
    @JsonProperty
    Integer letterTypeId
    
    @JsonProperty
    Boolean reviewMeeting
    
    @JsonProperty
    Boolean attendance
    
    @JsonProperty
    Boolean behaviour
    
    @JsonProperty
    Boolean homework
    
    @JsonProperty
    Boolean punctuality
    
    @JsonProperty
    Boolean focus
    
    @JsonProperty
    Boolean deadlines
    
    @JsonProperty
    Boolean progress
    
    @JsonProperty
    Boolean incompleteCoursework
    
    @JsonProperty
    Boolean studentCopiedIn
    
    @JsonProperty
    Integer warningParagraph
}
