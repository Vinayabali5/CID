package uk.ac.reigate.dto.ilp

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.ilp.ILPInterview
import uk.ac.reigate.dto.CourseGroupSummaryDto

@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class MassILPEntryDto extends MassILPEntryBaseDto implements Serializable {
    
    @JsonProperty
    Integer courseGroupId
    
    @JsonProperty
    String discussion
    
    @JsonProperty
    String target
    
    @JsonProperty
    Date targetDate
    
    @JsonProperty
    Boolean referLip
    
    @JsonProperty
    Date lipReferralDate
    
    @JsonProperty
    Boolean privateEntry
}
