package uk.ac.reigate.dto.ilp;

import com.fasterxml.jackson.annotation.JsonProperty;

import uk.ac.reigate.dto.bulkoperation.BulkStudentOperationDto

class MassILPEntryBaseDto extends BulkStudentOperationDto {
    
    @JsonProperty
    Integer staffId
    
    @JsonProperty
    Date interviewDate
    
    @JsonProperty
    Integer interviewTypeId
}
