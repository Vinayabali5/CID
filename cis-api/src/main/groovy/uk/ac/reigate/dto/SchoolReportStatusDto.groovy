package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.SchoolReportStatus

/**
 *
 * JSON serializable DTO containing SchoolReportStatus data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class SchoolReportStatusDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public SchoolReportStatusDto() {
    }
    
    /**
     * Constructor to create a SchoolReportStatusDto object from a SchoolReportStatus object
     *
     * @param schoolReportStatus the SchoolReportStatus object to use for construction
     */
    SchoolReportStatusDto(SchoolReportStatus schoolReportStatus) {
        if(schoolReportStatus != null) {
            this.id = schoolReportStatus.id;
            this.code = schoolReportStatus.code;
            this.description = schoolReportStatus.description;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a SchoolReportStatusDto from a SchoolReportStatus data object.
     *
     * @param schoolReportStatus the SchoolReportStatus data object to use for the creation.
     * @return a SchoolReportStatusDto object based on the SchoolReportStatus data object supplied.
     */
    public static SchoolReportStatusDto mapFromEntity(SchoolReportStatus schoolReportStatus) {
        return new SchoolReportStatusDto(schoolReportStatus);
    }
    
    /**
     * This static method is used to create a List of SchoolReportStatusDto from a List of SchoolReportStatus data object.
     *
     * @param schoolReportStatuses the List of SchoolReportStatus data object to use for the creation.
     * @return a List of SchoolReportStatusDto object based on the List of SchoolReportStatus data object supplied.
     */
    public static List<SchoolReportStatusDto> mapFromList(List<SchoolReportStatus> schoolReportStatuses) {
        return schoolReportStatuses.collect { schoolReportStatus ->  new SchoolReportStatusDto(schoolReportStatus) };
    }
}
