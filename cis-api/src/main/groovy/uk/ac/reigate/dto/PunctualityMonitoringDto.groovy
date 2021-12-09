package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.PunctualityMonitoring

/**
 *
 * JSON serializable DTO containing PunctualityMonitoring data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class PunctualityMonitoringDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private String warningColour
    
    @JsonProperty
    private String htmlColour
    
    @JsonProperty
    private Boolean inUse
    
    @JsonProperty
    private Boolean nonEntry;
    
    /**
     * Default No Args constructor
     */
    public PunctualityMonitoringDto() {
    }
    
    /**
     * Constructor to create a PunctualityMonitoringDto object from a PunctualityMonitoring object
     *
     * @param punctualityMonitoring the PunctualityMonitoring object to use for construction
     */
    PunctualityMonitoringDto(PunctualityMonitoring punctualityMonitoring) {
        if(punctualityMonitoring != null) {
            this.id = punctualityMonitoring.id;
            this.code = punctualityMonitoring.code;
            this.description = punctualityMonitoring.description;
            this.warningColour = punctualityMonitoring.warningColour;
            this.htmlColour = punctualityMonitoring.htmlColour
            this.inUse = punctualityMonitoring.inUse
            this.nonEntry = punctualityMonitoring.nonEntry
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a PunctualityMonitoringDto from a PunctualityMonitoring data object.
     *
     * @param punctualityMonitoring the PunctualityMonitoring data object to use for the creation.
     * @return a PunctualityMonitoringDto object based on the PunctualityMonitoring data object supplied.
     */
    public static PunctualityMonitoringDto mapFromEntity(PunctualityMonitoring punctualityMonitoring){
        return new PunctualityMonitoringDto(punctualityMonitoring)
    }
    
    /**
     * This static method is used to create a List of PunctualityMonitoringDto from a List of PunctualityMonitoring data object.
     *
     * @param punctualityMonitorings the List of PunctualityMonitoring data object to use for the creation.
     * @return a List of PunctualityMonitoringDto object based on the List of PunctualityMonitoring data object supplied.
     */
    public static List<PunctualityMonitoringDto> mapFromList(List<PunctualityMonitoring> punctualityMonitorings) {
        return punctualityMonitorings.collect { punctualityMonitoring ->  new PunctualityMonitoringDto(punctualityMonitoring) };
    }
}
