package uk.ac.reigate.dto.admissions

import javax.persistence.FetchType
import javax.persistence.OneToMany
import javax.validation.constraints.NotNull

import org.springframework.format.annotation.DateTimeFormat

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.CareersRecordType
import uk.ac.reigate.dto.careers.CareersRecordTypeDto

/**
 * The DuplicateDetectionDto is used to send data back and forth between the client and the server during the creation of a new Application
 * to detect any potential duplicate applications or potential twins.
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class DuplicateDetectionDto implements Serializable {
    
    @JsonProperty
    @NotNull
    private String surname
    
    @JsonProperty
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private Date dob
    
    @JsonProperty
    private List<DuplicateApplicationDto> matches
    
    /**
     * Default Constructor
     */
    DuplicateDetectionDto(){}
    
    DuplicateDetectionDto(DuplicateDetectionDto duplicateDetection){
        this.surname = duplicateDetection.surname
        this.dob = duplicateDetection.dob
        this.matches = duplicateDetection.matches
    }
    
    public static DuplicateDetectionDto mapFromEntity(DuplicateDetectionDto duplicateDetection) {
        return new DuplicateDetectionDto(duplicateDetection);
    }
}
