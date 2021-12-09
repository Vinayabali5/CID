package uk.ac.reigate.dto.attendance;


import javax.persistence.Column

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.attendance.StudentAttendance

/**
 *
 * JSON serializable DTO containing StudentAttendance data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentAttendanceDto implements Serializable {
    
    @JsonProperty
    public Integer studentId
    
    @JsonProperty
    public Integer courseId
    
    @JsonProperty
    public Integer academicYearId
    
    @JsonProperty
    public Integer sumOfPeriods
    
    @JsonProperty
    public Integer sumOfAbsences
    
    @JsonProperty
    public Integer sumOfAdjAbs
    
    @JsonProperty
    public Integer sumOfLates
    
    /**
     * Default No Args constructor
     */
    public StudentAttendanceDto() {
    }
    
    /**
     * Constructor to create an StudentAttendanceDto object from a StudentAttendance object
     *
     * @param studentAttendance the StudentAttendance object to use for construction
     */
    public StudentAttendanceDto(StudentAttendance studentAttendance) {
        this.courseId = studentAttendance.course.id;
        this.studentId = studentAttendance.student.id;
        this.academicYearId = studentAttendance.academicYear.id;
        this.sumOfPeriods = studentAttendance.sumOfPeriods;
        this.sumOfAbsences = studentAttendance.sumOfAbsences;
        this.sumOfAdjAbs = studentAttendance.sumOfAdjAbs;
        this.sumOfLates = studentAttendance.sumOfLates;
    }
    
    /**
     * This static method is used to create a StudentAttendanceDto from a StudentAttendance data object.
     *
     * @param studentAttendance the StudentAttendance data object to use for the creation.
     * @return a StudentAttendanceDto object based on the StudentAttendance data object supplied.
     */
    public static StudentAttendanceDto mapFromEntity(StudentAttendance studentAttendance) {
        return new StudentAttendanceDto(studentAttendance)
    }
    
    /**
     * This static method is used to create a List of StudentAttendanceDto from a List of StudentAttendance data object.
     *
     * @param studentAttendances the List of StudentAttendance data object to use for the creation.
     * @return a List of StudentAttendanceDto object based on the List of StudentAttendance data object supplied.
     */
    public static List<StudentAttendanceDto> mapFromList(List<StudentAttendance> studentAttendances) {
        return studentAttendances.collect { studentAttendance ->  new StudentAttendanceDto(studentAttendance) };
    }
}