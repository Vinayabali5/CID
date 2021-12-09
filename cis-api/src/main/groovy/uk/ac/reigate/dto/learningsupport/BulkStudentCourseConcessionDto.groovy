package uk.ac.reigate.dto.learningsupport

import com.fasterxml.jackson.annotation.JsonProperty

class BulkStudentCourseConcessionDto {
    
    @JsonProperty
    Integer studentId
    
    @JsonProperty
    Integer concessionTypeId
    
    @JsonProperty
    Integer extraTimePercentage
}
