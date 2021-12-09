package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.register.AttendanceCode

/**
 *
 * JSON serializable DTO containing AttendanceCode data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class AttendanceCodeDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private String registerMark
    
    @JsonProperty
    private Boolean absence;
    
    @JsonProperty
    private Boolean authorisedAbsence;
    
    @JsonProperty
    private Boolean late;
    
    @JsonProperty
    private Boolean authorisedLate;
    
    @JsonProperty
    private Boolean included
    
    @JsonProperty
    private Boolean lastDateOfAttendance
    
    @JsonProperty
    private String htmlColour
    
    @JsonProperty
    private String accessColour
    
    /**
     * Default No Args constructor
     */
    public AttendanceCodeDto() {
    }
    
    /**
     * Constructor to create an AttendanceCodeDto object from an AttendanceCode object
     *
     * @param attendanceCode the AttendanceCode object to use for construction
     */
    AttendanceCodeDto(AttendanceCode attendanceCode) {
        if(attendanceCode != null) {
            this.id = attendanceCode.id;
            this.code = attendanceCode.code;
            this.description = attendanceCode.description;
            this.registerMark = attendanceCode.registerMark;
            this.absence = attendanceCode.absence;
            this.authorisedAbsence = attendanceCode.authorisedAbsence;
            this.late = attendanceCode.late;
            this.authorisedLate = attendanceCode.authorisedLate;
            this.included = attendanceCode.included;
            this.lastDateOfAttendance = attendanceCode.lastDateOfAttendance;
            this.htmlColour = attendanceCode.htmlColour;
            this.accessColour = attendanceCode.accessColour;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a AttendanceCodeDto from a AttendanceCode data object.
     *
     * @param attendanceCode the AttendanceCode data object to use for the creation.
     * @return a AttendanceCodeDto object based on the AttendanceCode data object supplied.
     */
    public static AttendanceCodeDto mapFromEntity(AttendanceCode attendanceCode){
        return new AttendanceCodeDto(attendanceCode);
    }
    
    /**
     * This static method is used to create a List of AttendanceCodeDto from a List of AttendanceCode data object.
     *
     * @param attendanceCodes the List of AttendanceCode data object to use for the creation.
     * @return a List of AttendanceCodeDto object based on the List of AttendanceCode data object supplied.
     */
    public static List<AttendanceCodeDto> mapFromList(List<AttendanceCode> attendanceCodes) {
        return attendanceCodes.collect { attendanceCode ->  mapFromEntity(attendanceCode) };
    }
}
