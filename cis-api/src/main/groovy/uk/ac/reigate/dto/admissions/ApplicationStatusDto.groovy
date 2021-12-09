package uk.ac.reigate.dto.admissions;

import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.admissions.ApplicationStatus

/**
 *
 * JSON serializable DTO containing ApplicationStatus data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class ApplicationStatusDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private Boolean considerWithdrawn
    
    /**
     * Default No Args constructor
     */
    public ApplicationStatusDto() {
    }
    
    /**
     * Constructor to create an ApplicationStatusDto object from an ApplicationStatus object
     *
     * @param applicationStatus the ApplicationStatus object to use for construction
     */
    ApplicationStatusDto(ApplicationStatus applicationStatus) {
        if(applicationStatus != null) {
            this.id = applicationStatus.id;
            this.code = applicationStatus.code;
            this.description = applicationStatus.description;
            this.considerWithdrawn = applicationStatus.considerWithdrawn;
        }
    }
    
    /**
     * This static method is used to create a SubjectDto from a ApplicationStatus data object.
     *
     * @param applicationStatus the ApplicationStatus data object to use for the creation.
     * @return a ApplicationStatusDto object based on the ApplicationStatus data object supplied.
     */
    public static ApplicationStatusDto mapFromEntity(ApplicationStatus applicationStatus) {
        return new ApplicationStatusDto(applicationStatus);
    }
    
    /**
     * This static method is used to create a List of ApplicationStatusDto from a List of ApplicationStatus data object.
     *
     * @param applicationStatuses the List of ApplicationStatus data object to use for the creation.
     * @return a List of ApplicationStatusDto object based on the List of ApplicationStatus data object supplied.
     */
    public static List<ApplicationStatusDto> mapFromList(List<ApplicationStatus> applicationStatuses) {
        return applicationStatuses.collect { applicationStatus ->  new ApplicationStatusDto(applicationStatus) };
    }
}
