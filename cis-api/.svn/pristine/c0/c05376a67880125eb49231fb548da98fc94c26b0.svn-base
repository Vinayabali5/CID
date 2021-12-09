package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.AttendanceMonitoring

/**
 *
 * JSON serializable DTO containing AttendanceMonitoring data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class AttendanceMonitoringDto implements Serializable {
    
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
    public AttendanceMonitoringDto() {
    }
    
    /**
     * Constructor to create an AttendanceMonitoringDto object from an AttendanceMonitoring object
     *
     * @param attendanceMonitoring the AttendanceMonitoring object to use for construction
     */
    public AttendanceMonitoringDto(AttendanceMonitoring attendanceMonitoring) {
        if(attendanceMonitoring != null) {
            this.id = attendanceMonitoring.id;
            this.code = attendanceMonitoring.code;
            this.description = attendanceMonitoring.description;
            this.warningColour = attendanceMonitoring.warningColour;
            this.htmlColour = attendanceMonitoring.htmlColour;
            this.inUse = attendanceMonitoring.inUse;
            this.nonEntry = attendanceMonitoring.nonEntry;
        } else {
            return null
        }
    }
    /**
     * This static method is used to create a AttendanceMonitoringDto from a AttendanceMonitoring data object.
     *
     * @param attendanceMonitoring the AttendanceMonitoring data object to use for the creation.
     * @return a AttendanceMonitoringDto object based on the AttendanceMonitoring data object supplied.
     */
    public static AttendanceMonitoringDto mapFromEntity(AttendanceMonitoring attendanceMonitoring){
        return new AttendanceMonitoringDto(attendanceMonitoring)
    }
    
    /**
     * This static method is used to create a List of AttendanceMonitoringDto from a List of AttendanceMonitoring data object.
     *
     * @param attendanceMonitorings the List of AttendanceMonitoring data object to use for the creation.
     * @return a List of AttendanceMonitoringDto object based on the List of AttendanceMonitoring data object supplied.
     */
    public static List<AttendanceMonitoringDto> mapFromList(List<AttendanceMonitoring> attendanceMonitoringList) {
        return attendanceMonitoringList.collect { AttendanceMonitoring attendanceMonitoring -> new AttendanceMonitoringDto(attendanceMonitoring) };
    }
}
