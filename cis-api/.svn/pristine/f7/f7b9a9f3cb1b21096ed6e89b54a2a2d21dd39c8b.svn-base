package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.lookup.WarningCodeChange
import uk.ac.reigate.exceptions.InvalidDataException

/**
 *
 * JSON serializable DTO containing WarningCodeChange data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class WarningCodeChangeDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Integer yearId;
    
    @JsonProperty
    private Integer previousAmId;
    
    @JsonProperty
    private AttendanceMonitoringDto previousAm
    
    @JsonProperty
    private Integer currentAmId;
    
    @JsonProperty
    private AttendanceMonitoringDto currentAm
    
    @JsonProperty
    private Integer previousPmId;
    
    @JsonProperty
    private PunctualityMonitoringDto previousPm
    
    @JsonProperty
    private Integer currentPmId;
    
    @JsonProperty
    private PunctualityMonitoringDto currentPm;
    
    @JsonProperty
    private Date changeDate;
    
    /**
     * Default No Args constructor
     */
    public WarningCodeChangeDto() {
    }
    
    /**
     * Constructor to create an WarningCodeChangeDto object from an WarningCodeChange object
     *
     * @param warningCodeChange the WarningCodeChange object to use for construction
     */
    WarningCodeChangeDto(WarningCodeChange warningCodeChange) {
        if(warningCodeChange != null) {
            this.id = warningCodeChange.id;
            this.studentId = warningCodeChange.student != null ? warningCodeChange.student.id : null;
            this.yearId = warningCodeChange.year != null ? warningCodeChange.year.id : null;
            this.previousAmId = warningCodeChange.previousAm != null ? warningCodeChange.previousAm.id : null;
            this.previousAm = warningCodeChange.previousAm != null ? AttendanceMonitoringDto.mapFromEntity(warningCodeChange.previousAm) : null
            this.currentAmId = warningCodeChange.currentAm != null ? warningCodeChange.currentAm.id : null;
            this.currentAm = warningCodeChange.currentAm != null ? AttendanceMonitoringDto.mapFromEntity(warningCodeChange.currentAm) : null
            this.previousPmId = warningCodeChange.previousPm != null ? warningCodeChange.previousPm.id : null;
            this.previousPm = warningCodeChange.previousPm != null ? PunctualityMonitoringDto.mapFromEntity(warningCodeChange.previousPm) : null
            this.currentPmId = warningCodeChange.currentPm != null ? warningCodeChange.currentPm.id : null;
            this.currentPm = warningCodeChange.previousPm != null ? PunctualityMonitoringDto.mapFromEntity(warningCodeChange.previousPm) : null
            this.changeDate = warningCodeChange.changeDate;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a WarningCodeChangeDto from a WarningCodeChange data object.
     *
     * @param warningCodeChange the WarningCodeChange data object to use for the creation.
     * @return a WarningCodeChangeDto object based on the WarningCodeChange data object supplied.
     */
    public static WarningCodeChangeDto mapFromEntity(WarningCodeChange warningCodeChange){
        return new WarningCodeChangeDto(warningCodeChange)
    }
    
    /**
     * This static method is used to create a List of WarningCodeChangeDto from a List of WarningCodeChange data object.
     *
     * @param warningCodeChanges the List of WarningCodeChange data object to use for the creation.
     * @return a List of WarningCodeChangeDto object based on the List of WarningCodeChange data object supplied.
     */
    public static List<WarningCodeChangeDto> mapFromList(List<WarningCodeChange> warningCodeChanges) {
        return warningCodeChanges.collect { warningCodeChange ->  new WarningCodeChangeDto(warningCodeChange) };
    }
    
    /**
     * This method is used to return the PreviousAm Description for the WarningCodeChange object
     *
     * @return the PreviousAm Description for the WarningCodeChange object
     */
    @JsonProperty(value = "_previousAmDescription")
    public String get_PreviousAmDescription() {
        return this.previousAm != null ? this.previousAm.description : null
    }
    
    /**
     * This method is used to return the CurrentAm Description for the WarningCodeChange object
     *
     * @return the CurrentAm Description for the WarningCodeChange object
     */
    @JsonProperty(value = "_currentAmDescription")
    public String get_CurrentAmDescription() {
        return this.currentAm != null ? this.currentAm.description : null
    }
    
    /**
     * This method is used to return the PreviousPm Description for the WarningCodeChange object
     *
     * @return the PreviousPm Description for the WarningCodeChange object
     */
    @JsonProperty(value = "_previousPmDescription")
    public String get_PreviousPmDescription() {
        return this.previousPm != null ? this.previousPm.description : null
    }
    
    /**
     * This method is used to return the CurrentPm Description for the WarningCodeChange object
     *
     * @return the CurrentPm Description for the WarningCodeChange object
     */
    @JsonProperty(value = "_currentPmDescription")
    public String get_CurrentPmDescription() {
        return this.currentPm != null ? this.currentPm.description : null
    }
}
