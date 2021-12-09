package uk.ac.reigate.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.ilp.StudentRelatedStaff

/**
 *
 * JSON serializable DTO containing StudentRelatedStaff data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentRelatedStaffDto implements Serializable {
    
    @JsonProperty
    private Integer studentId
    
    @JsonProperty
    private Integer staffId
    
    @JsonProperty
    private String staffInitials
    
    @JsonProperty
    private String staffName
    
    @JsonProperty
    private String relationship
    
    /**
     * Default No Args constructor
     */
    public StudentRelatedStaffDto() {
    }
    
    /**
     * Constructor to create a StudentRelatedStaffDto object from a StudentRelatedStaff object
     *
     * @param studentRelatedStaff the StudentRelatedStaff object to use for construction
     */
    StudentRelatedStaffDto(StudentRelatedStaff studentRelatedStaff) {
        if(studentRelatedStaff != null) {
            this.studentId = studentRelatedStaff.student != null ? studentRelatedStaff.student.id : null
            this.staffId = studentRelatedStaff.staff != null ? studentRelatedStaff.staff.id : null
            this.staffInitials = studentRelatedStaff.staffInitials
            this.staffName = studentRelatedStaff.staffName
            this.relationship = studentRelatedStaff.relationship
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a StudentRelatedStaffDto from a StudentRelatedStaff data object.
     *
     * @param studentRelatedStaff the StudentRelatedStaff data object to use for the creation.
     * @return a StudentRelatedStaffDto object based on the StudentRelatedStaff data object supplied.
     */
    public static StudentRelatedStaffDto mapFromEntity(StudentRelatedStaff studentRelatedStaff) {
        return new StudentRelatedStaffDto(studentRelatedStaff)
    }
    
    /**
     * This static method is used to create a List of StudentRelatedStaffDto from a List of StudentRelatedStaff data object.
     *
     * @param studentRelatedStaffs the List of StudentRelatedStaff data object to use for the creation.
     * @return a List of StudentRelatedStaffDto object based on the List of StudentRelatedStaff data object supplied.
     */
    public static List<StudentRelatedStaffDto> mapFromList(List<StudentRelatedStaff> studentRelatedStaffs) {
        return studentRelatedStaffs.collect { studentRelatedStaff ->  new StudentRelatedStaffDto(studentRelatedStaff) };
    }
}
