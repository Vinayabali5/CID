package uk.ac.reigate.dto.bulkoperation

import javax.validation.constraints.NotEmpty

import com.fasterxml.jackson.annotation.JsonProperty

class BulkStudentOperationDto {
    
    @NotEmpty
    @JsonProperty
    List<Integer> studentList;
}
