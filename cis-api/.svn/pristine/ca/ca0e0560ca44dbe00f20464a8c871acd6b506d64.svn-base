package uk.ac.reigate.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.register.StudentOverallAttendance
import uk.ac.reigate.exceptions.InvalidDataException

/**
 *
 * JSON serializable DTO containing StudentOverallAttendance data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentOverallAttendanceDto implements Serializable {
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Integer totalSessions
    
    @JsonProperty
    private Integer totalAbsence
    
    @JsonProperty
    private Integer totalAuthorisedAbsence
    
    @JsonProperty
    private Integer totalAdjusted
    
    @JsonProperty
    private Integer totalLate
    
    @JsonProperty
    private Integer totalAuthorisedLate
    
    @JsonProperty
    private Double attendance
    
    @JsonProperty
    private Double adjustedAttendance
    
    @JsonProperty
    private Double punctuality
    
    @JsonProperty
    private Double adjustedPunctuality
    
    /**
     * Default No Args constructor
     */
    public StudentOverallAttendanceDto() {
    }
    
    /**
     * Constructor to create a StudentOverallAttendanceDto object
     *
     * @param studentId the studentId for the StudentOverallAttendance
     * @param code the code for the StudentOverallAttendance
     * @param description the description for the StudentOverallAttendance
     */
    public StudentOverallAttendanceDto(Integer studentId, Integer totalSessions, Integer totalAbsence, Integer totalAuthorisedAbsence, Integer totalAdjusted, Integer totalLate, Integer totalAuthorisedLate, Double attendance, Double adjustedAttendance, Double punctuality, Double adjustedPunctuality) {
        this.studentId = studentId;
        this.totalSessions = totalSessions;
        this.totalAbsence = totalAbsence;
        this.totalAuthorisedAbsence = totalAuthorisedAbsence;
        this.totalAdjusted = totalAdjusted;
        this.totalLate = totalLate;
        this.totalAuthorisedLate = totalAuthorisedLate;
        this.attendance = attendance;
        this.adjustedAttendance = adjustedAttendance;
        this.punctuality = punctuality;
        this.adjustedPunctuality = adjustedPunctuality;
    }
    
    /**
     * Constructor to create a StudentOverallAttendanceDto object from a StudentOverallAttendance object
     *
     * @param studentOverallAttendance the StudentOverallAttendance object to use for construction
     */
    public StudentOverallAttendanceDto(StudentOverallAttendance studentOverallAttendance) {
        if(studentOverallAttendance != null) {
            this.studentId = studentOverallAttendance.student.id;
            this.totalSessions = studentOverallAttendance.totalSessions;
            this.totalAbsence = studentOverallAttendance.totalAbsence;
            this.totalAuthorisedAbsence = studentOverallAttendance.totalAuthorisedAbsence;
            this.totalAdjusted = studentOverallAttendance.totalAdjusted;
            this.totalLate = studentOverallAttendance.totalLate;
            this.totalAuthorisedLate = studentOverallAttendance.totalAuthorisedLate;
            this.attendance = studentOverallAttendance.attendance;
            this.adjustedAttendance = studentOverallAttendance.adjustedAttendance;
            this.punctuality = studentOverallAttendance.punctuality;
            this.adjustedPunctuality = studentOverallAttendance.adjustedPunctuality;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a StudentOverallAttendanceDto from a StudentOverallAttendance data object.
     *
     * @param studentOverallAttendance the StudentOverallAttendance data object to use for the creation.
     * @return a StudentOverallAttendanceDto object based on the StudentOverallAttendance data object supplied.
     */
    public static StudentOverallAttendanceDto mapFromStudentOverallAttendanceEntity(StudentOverallAttendance studentOverallAttendance) {
        return new StudentOverallAttendanceDto(studentOverallAttendance);
    }
    
    /**
     * This static method is used to create a List of StudentOverallAttendanceDto from a List of StudentOverallAttendance data object.
     *
     * @param studentOverallAttendances the List of StudentOverallAttendance data object to use for the creation.
     * @return a List of StudentOverallAttendanceDto object based on the List of StudentOverallAttendance data object supplied.
     */
    public static List<StudentOverallAttendanceDto> mapFromStudentOverallAttendancesEntities(List<StudentOverallAttendance> studentOverallAttendances) {
        return studentOverallAttendances.collect { studentOverallAttendance ->  mapFromStudentOverallAttendanceEntity(studentOverallAttendance) };
    }
}
