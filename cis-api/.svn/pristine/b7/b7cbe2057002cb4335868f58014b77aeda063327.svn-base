package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.academic.IdentificationViolation
import uk.ac.reigate.exceptions.InvalidDataException

/**
 *
 * JSON serializable DTO containing Department data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class IdentificationViolationDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Integer yearId;
    
    @JsonProperty
    private Date date;
    
    @JsonProperty
    private Boolean returned;
    
    @JsonProperty
    private Boolean lost;
    
    @JsonProperty
    private Boolean printed;
    
    @JsonProperty
    private Boolean replacementPaidFor;
    
    @JsonProperty
    private Integer id_number;
    
    /** 
     * Default No Args constructor
     */
    public IdentificationViolationDto() {
    }
    
    /**
     * Constructor to create a IdentificationViolationDto object from a IdentificationViolation object
     *
     * @param department the IdentificationViolation object to use for construction
     */
    IdentificationViolationDto(IdentificationViolation idViolation) {
        if(idViolation != null) {
            this.id = idViolation.id;
            this.studentId = idViolation.student != null ? idViolation.student.id : null
            this.yearId = idViolation.year != null ? idViolation.year.id : null
            this.date = idViolation.date
            this.returned = idViolation.returned
            this.lost = idViolation.lost
            this.printed = idViolation.printed
            this.replacementPaidFor = idViolation.replacementPaidFor
            this.id_number = idViolation.id_number
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a IdentificationViolationDto from a IdentificationViolation data object.
     *
     * @param idViolation the IdentificationViolation data object to use for the creation.
     * @return a IdentificationViolationDto object based on the IdentificationViolation data object supplied.
     */
    public static IdentificationViolationDto mapFromEntity(IdentificationViolation idViolation) {
        return  new IdentificationViolationDto(idViolation)
    }
    
    /**
     * This static method is used to create a List of IdentificationViolationDto from a List of IdentificationViolation data object.
     *
     * @param IdViolations the List of IdentificationViolation data object to use for the creation.
     * @return a List of IdentificationViolationDto object based on the List of IdentificationViolation data object supplied.
     */
    public static List<IdentificationViolationDto> mapFromEntities(List<IdentificationViolation> idViolations) {
        return idViolations.collect { idViolation -> new IdentificationViolationDto(idViolation)};
    }
}