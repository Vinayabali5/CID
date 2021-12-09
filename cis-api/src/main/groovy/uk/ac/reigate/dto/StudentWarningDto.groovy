package uk.ac.reigate.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.StudentYear


/**
 *
 * JSON serializable DTO containing StudentWarning data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentWarningDto implements Serializable{
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Integer yearId;
    
    @JsonProperty
    private Integer attendanceMonitoringId;
    
    @JsonProperty
    private AttendanceMonitoringDto attendanceMonitoring;
    
    @JsonProperty
    private Boolean _attendanceMonitoringNonEntry;
    
    @JsonProperty
    private Integer punctualityMonitoringId;
    
    @JsonProperty
    private PunctualityMonitoringDto punctualityMonitoring;
    
    @JsonProperty
    private Boolean _punctualityMonitoringNonEntry;
    
    @JsonProperty
    private Boolean attendanceMonitorable
    
    @JsonProperty
    private Boolean punctualityMonitorable
    
    
    /**
     * Default No Args constructor
     */
    public StudentWarningDto() {}
    
    /**
     * Constructor to create a StudentWarningDto object from a StudentYear object
     *
     * @param studentYear the StudentYear object to use for construction
     */
    public StudentWarningDto(StudentYear studentYear) {
        if(studentYear != null) {
            this.studentId = studentYear.student != null ? studentYear.student.id : null;
            this.yearId = studentYear.year != null ? studentYear.year.id : null;
            this.attendanceMonitoringId = studentYear.attendanceMonitoring != null ? studentYear.attendanceMonitoring.id : null;
            this.attendanceMonitoring = studentYear.attendanceMonitoring != null ? AttendanceMonitoringDto.mapFromEntity(studentYear.attendanceMonitoring) : null
            this.punctualityMonitoringId = studentYear.punctualityMonitoring != null ? studentYear.punctualityMonitoring.id : null;
            this.punctualityMonitoring = studentYear.punctualityMonitoring != null ? PunctualityMonitoringDto.mapFromEntity(studentYear.punctualityMonitoring) : null
            this._attendanceMonitoringNonEntry = studentYear.attendanceMonitoring != null ? studentYear.attendanceMonitoring.nonEntry : null;
            this._punctualityMonitoringNonEntry = studentYear.punctualityMonitoring != null ? studentYear.punctualityMonitoring.nonEntry : null;
            this.attendanceMonitorable = studentYear.attendanceMonitorable
            this.punctualityMonitorable = studentYear.punctualityMonitorable
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a StudentWarningDto from a StudentYear data object.
     *
     * @param studentYear the StudentYear data object to use for the creation.
     * @return a StudentWarningDto object based on the StudentYear data object supplied.
     */
    public static StudentWarningDto mapFromEntity(StudentYear studentYear) {
        return new StudentWarningDto(studentYear);
    }
    
    /**
     * This method is used to return the AttendanceMonitoring code for the StudentYear object
     *
     * @return the AttendanceMonitoring code for the StudentYear object
     */
    @JsonProperty(value = "_attendanceMonitoringCode")
    public String get_AttendanceMonitoringeCode() {
        return this.attendanceMonitoring != null ? this.attendanceMonitoring.code : null
    }
    
    /**
     * This method is used to return the AttendanceMonitoring description for the StudentYear object
     *
     * @return the AttendanceMonitoring description for the StudentYear object
     */
    @JsonProperty(value = "_attendanceMonitoringDescription")
    public String get_AttendanceMonitoringeDescription() {
        return this.attendanceMonitoring != null ? this.attendanceMonitoring.description : null
    }
    
    /**
     * This method is used to return the PunctualityMonitoring code for the StudentYear object
     *
     * @return the PunctualityMonitoring code for the StudentYear object
     */
    @JsonProperty(value = "_punctualityMonitoringCode")
    public String get_PunctualityMonitoringeCode() {
        return this.punctualityMonitoring != null ? this.punctualityMonitoring.code : null
    }
    
    /**
     * This method is used to return the PunctualityMonitoring description for the StudentYear object
     *
     * @return the PunctualityMonitoring description for the StudentYear object
     */
    @JsonProperty(value = "_punctualityMonitoringDescription")
    public String get_PunctualityMonitoringeDescription() {
        return this.punctualityMonitoring != null ? this.punctualityMonitoring.description : null
    }
}
