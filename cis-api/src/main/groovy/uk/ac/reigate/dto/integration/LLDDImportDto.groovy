package uk.ac.reigate.dto.integration

import com.fasterxml.jackson.annotation.JsonProperty

import uk.ac.reigate.dto.LLDDHealthProblemCategoryDto

class LLDDImportDto {
    
    @JsonProperty
    private String code
    
    @JsonProperty
    private String description
    
    /**
     * Default No Args constructor
     */
    LLDDImportDto() {
    }
    
    /**
     * Constructor to create a LLDDImportDto object from a LLDDHealthProblemCategoryDto object
     *
     * @param lldd the LLDDHealthProblemCategoryDto object to use for construction
     */
    LLDDImportDto(LLDDHealthProblemCategoryDto lldd) {
        this.code = lldd.code;
        this.description = lldd.description;
    }
    
    @Override
    public String toString() {
        return "LLDDImportDto [id=" + id + ", code=" + code + ", description=" + description + "]";
    }
}
