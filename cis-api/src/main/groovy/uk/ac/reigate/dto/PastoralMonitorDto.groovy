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
public class PastoralMonitorDto implements Serializable{
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private StudentSummaryDto student;
    
    @JsonProperty
    private Integer yearId;
    
    @JsonProperty
    private Integer pastoralMonitorId;
    
    @JsonProperty
    private StaffDto pastoralMonitor;
    
    @JsonProperty
    private Integer seniorTutorId;
    
    /**
     * Default No Args constructor
     */
    public PastoralMonitorDto() {}
    
    /**
     * Constructor to create a StudentWarningDto object from a StudentYear object
     *
     * @param studentYear the StudentYear object to use for construction
     */
    public PastoralMonitorDto(StudentYear studentYear) {
        if(studentYear != null) {
            this.studentId = studentYear.student != null ? studentYear.student.id : null;
            this.student = studentYear.student != null ? StudentSummaryDto.mapFromEntity(studentYear.student) : null;
            this.yearId = studentYear.year != null ? studentYear.year.id : null;
            this.pastoralMonitorId = studentYear.pastoralMonitor != null ? studentYear.pastoralMonitor.id : null;
            this.pastoralMonitor = studentYear.pastoralMonitor != null ? StaffDto.mapFromEntity(studentYear.pastoralMonitor) : null
            this.seniorTutorId = studentYear.tutorGroup != null && studentYear.tutorGroup.seniorTutor != null ? studentYear.tutorGroup.seniorTutor.id : null;
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
    public static PastoralMonitorDto mapFromEntity(StudentYear studentYear) {
        return new PastoralMonitorDto(studentYear);
    }
    
    /**
     * This method is used to return the AttendanceMonitoring code for the StudentYear object
     *
     * @return the AttendanceMonitoring code for the StudentYear object
     */
    @JsonProperty(value = "_pastoralMonitor")
    public String get_PastoralMonitor() {
        return this.pastoralMonitor != null ? this.pastoralMonitor.knownAs : null
    }
}
