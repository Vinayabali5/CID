package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.register.AttendanceCode;
import uk.ac.reigate.domain.register.Register
import uk.ac.reigate.domain.register.RegisterMark

/**
 *
 * JSON serializable DTO containing Register data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class RegisterMarkDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Integer courseId;
    
    @JsonProperty
    private Integer courseGroupId;
    
    @JsonProperty
    private Integer registerId;
    
    @JsonProperty
    private Integer attendanceCodeId;
    
    
    /**
     * Default No Args constructor
     */
    public RegisterMarkDto() {
    }
    
    /**
     * Constructor to create a RegisterMarkDto object from a RegisterMark object
     *
     * @param registerMark the RegisterMark object to use for construction
     */
    RegisterMarkDto(RegisterMark registerMark){
        if(registerMark != null) {
            this.id = registerMark.id;
            this.courseId = registerMark.course != null ? registerMark.course.id : null;
            this.courseGroupId = registerMark.courseGroup != null ? registerMark.courseGroup.id : null;
            this.registerId = registerMark.register != null ? registerMark.register.id : null;
            this.studentId = registerMark.student != null ? registerMark.student.id : null;
            this.attendanceCodeId = registerMark.attendanceCode != null ? registerMark.attendanceCode.id : null;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a RegisterMarkDto from a RegisterMark data object.
     *
     * @param registerMark the RegisterMark data object to use for the creation.
     * @return a RegisterMarkDto object based on the RegisterMark data object supplied.
     */
    public static RegisterMarkDto mapFromEntity(RegisterMark registerMark) {
        return new RegisterMarkDto(registerMark)
    }
    
    /**
     * This static method is used to create a List of RegisterMarkDto from a List of RegisterMark data object.
     *
     * @param registerMarks the List of RegisterMark data object to use for the creation.
     * @return a List of RegisterMarkDto object based on the List of RegisterMark data object supplied.
     */
    public static List<RegisterMarkDto> mapFromList(List<Register> registerMarks) {
        return registerMarks.collect { registerMark ->  new RegisterMarkDto(registerMark) };
    }
}
