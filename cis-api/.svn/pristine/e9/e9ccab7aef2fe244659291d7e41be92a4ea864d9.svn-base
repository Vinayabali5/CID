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
public class MassILPPraiseLetterDto extends MassILPEntryBaseDto implements Serializable {
    
    @NotNull
    @JsonProperty
    Integer statementId
    
    @NotNull
    @JsonProperty
    Integer courseGroupId
    
    @JsonProperty
    Integer letterTypeId
}
