package uk.ac.reigate.dto;


import java.text.SimpleDateFormat

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.cristal.MasterRegister
import uk.ac.reigate.exceptions.InvalidDataException


/**
 *
 * JSON serializable DTO containing MasterRegister data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class MasterRegisterDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer sessionRef
    
    @JsonProperty
    private Integer studentId
    
    @JsonProperty
    private String subjectCode;
    
    @JsonProperty
    private String group;
    
    @JsonProperty
    private Integer attendanceId;
    
    @JsonProperty
    private AttendanceCodeDto _attendance;
    
    @JsonProperty
    private Integer academicYearId
    
    @JsonProperty
    private Date _sessionDate;
    
    @JsonProperty
    private Integer _sessionPeriod;
    
    @JsonProperty
    String notes
    
    /**
     * Default No Args constructor
     */
    public MasterRegisterDto() {}
    
    /**
     * Constructor to create a MasterRegisterDto object from a MasterRegister object
     *
     * @param masterRegister the MasterRegister object to use for construction
     */
    MasterRegisterDto(MasterRegister masterRegister) {
        if(masterRegister != null) {
            this.id = masterRegister.id;
            this.sessionRef = masterRegister.sessionRef;
            this.studentId = masterRegister.student != null ? masterRegister.student.id : null;
            this.subjectCode = masterRegister.subjectCode;
            this.group = masterRegister.group;
            this.attendanceId = masterRegister.attendance != null ? masterRegister.attendance.id : null;
            this._attendance = masterRegister.attendance != null ? new AttendanceCodeDto(masterRegister.attendance) : null
            this._sessionPeriod = (masterRegister.sessionRef % 100L);
            SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd")
            this._sessionDate = originalFormat.parse((masterRegister.sessionRef / 100L).toString());
            this.academicYearId = masterRegister.academicYear != null ? masterRegister.academicYear.id : null
            this.notes = masterRegister.notes
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a MasterRegisterDto from a MasterRegister data object.
     *
     * @param masterRegister the MasterRegister data object to use for the creation.
     * @return a MasterRegisterDto object based on the MasterRegister data object supplied.
     */
    public static MasterRegisterDto mapFromEntity(MasterRegister masterRegister) {
        return new MasterRegisterDto(masterRegister);
    }
    
    /**
     * This static method is used to create a List of MasterRegisterDto from a List of MasterRegister data object.
     *
     * @param masterRegisters the List of MasterRegister data object to use for the creation.
     * @return a List of MasterRegisterDto object based on the List of MasterRegister data object supplied.
     */
    public static List<MasterRegisterDto> mapFromList(List<MasterRegister> masterRegisters) {
        List<MasterRegisterDto> output = masterRegisters.collect { masterRegister ->  new MasterRegisterDto(masterRegister) };
        return output
    }
}
