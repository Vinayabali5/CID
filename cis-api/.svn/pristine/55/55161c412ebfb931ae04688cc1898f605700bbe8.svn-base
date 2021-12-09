package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.CentralMonitoring

/**
 *
 * JSON serializable DTO containing CentralMonitoring data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class CentralMonitoringDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private String warningColour;
    
    @JsonProperty
    private Boolean nonEntry;
    
    /**
     * Default No Args constructor
     */
    public CentralMonitoringDto() {
    }
    
    /**
     * Constructor to create a CentralMonitoringDto object from a CentralMonitoring object
     *
     * @param centralMonitoring the CentralMonitoring object to use for construction
     */
    CentralMonitoringDto(CentralMonitoring centralMonitoring) {
        this.id = centralMonitoring.id;
        this.code = centralMonitoring.code;
        this.description = centralMonitoring.description;
        this.warningColour = centralMonitoring.warningColour;
        this.nonEntry = centralMonitoring.nonEntry;
    }
    
    /**
     * This static method is used to create a CentralMonitoringDto from a CentralMonitoring data object.
     *
     * @param centralMonitoring the CentralMonitoring data object to use for the creation.
     * @return a CentralMonitoringDto object based on the CentralMonitoring data object supplied.
     */
    public static CentralMonitoringDto mapFromEntity(CentralMonitoring centralMonitoring){
        return new CentralMonitoringDto(centralMonitoring)
    }
    
    /**
     * This static method is used to create a List of CentralMonitoringDto from a List of CentralMonitoring data object.
     *
     * @param centralMonitorings the List of CentralMonitoring data object to use for the creation.
     * @return a List of CentralMonitoringDto object based on the List of CentralMonitoring data object supplied.
     */
    public static List<CentralMonitoringDto> mapFromList(List<CentralMonitoring> centralMonitorings) {
        return centralMonitorings.collect { centralMonitoring ->  new CentralMonitoringDto(centralMonitoring) };
    }
}
