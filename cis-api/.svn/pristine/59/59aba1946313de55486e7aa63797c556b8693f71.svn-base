package uk.ac.reigate.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.StudentVolunteeringLog
import uk.ac.reigate.dto.lookup.StudentRoleDto
import uk.ac.reigate.dto.lookup.VolunteeringExperienceDto
import uk.ac.reigate.dto.lookup.VolunteeringTypeDto

/**
 *
 * JSON serializable DTO containing StudentVolunteeringLog data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentVolunteeringLogDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Integer volunteeringTypeId
    
    @JsonProperty
    private VolunteeringTypeDto volunteeringType
    
    @JsonProperty
    private Integer volunteeringExperienceId
    
    @JsonProperty
    private VolunteeringExperienceDto volunteeringExperience
    
    @JsonProperty
    private Date date
    
    @JsonProperty
    private Double hours
    
    @JsonProperty
    private String note
    
    @JsonProperty
    private Integer studentRoleId
    
    @JsonProperty
    private StudentRoleDto studentRole
    
    /**
     * Default No Args constructor
     */
    public StudentVolunteeringLogDto() {
    }
    
    /**
     * Constructor to create a StudentVolunteeringLogDto object from a Student, StudentVolunteeringLog object
     *
     * @param student, studentVolunteeringLog the Student, StudentVolunteeringLog object to use for construction
     */
    public StudentVolunteeringLogDto(StudentVolunteeringLog studentVolunteeringLog) {
        if(studentVolunteeringLog != null) {
            this.id = studentVolunteeringLog.id
            this.studentId = studentVolunteeringLog.student != null ? studentVolunteeringLog.student.id : null;
            this.date = studentVolunteeringLog.date
            this.hours = studentVolunteeringLog.hours
            this.volunteeringTypeId = studentVolunteeringLog.volunteeringType != null ? studentVolunteeringLog.volunteeringType.id : null;
            this.volunteeringType = studentVolunteeringLog.volunteeringType != null ? VolunteeringTypeDto.mapFromEntity(studentVolunteeringLog.volunteeringType) : null
            this.volunteeringExperienceId = studentVolunteeringLog.volunteeringExperience != null ? studentVolunteeringLog.volunteeringExperience.id : null;
            this.volunteeringExperience = studentVolunteeringLog.volunteeringExperience != null ? VolunteeringExperienceDto.mapFromEntity(studentVolunteeringLog.volunteeringExperience) : null
            this.studentRoleId = studentVolunteeringLog.studentRole != null ? studentVolunteeringLog.studentRole.id : null;
            this.studentRole = studentVolunteeringLog.studentRole != null ? StudentRoleDto.mapFromEntity(studentVolunteeringLog.studentRole) : null
            this.note = studentVolunteeringLog.note
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a StudentVolunteeringLogDto from a StudentVolunteeringLog data object.
     *
     * @param contact the StudentVolunteeringLog data object to use for the creation.
     * @return a StudentVolunteeringLogDto object based on the StudentVolunteeringLog data object supplied.
     */
    public static StudentVolunteeringLogDto mapFromEntity(StudentVolunteeringLog studentVolunteeringLog) {
        return new StudentVolunteeringLogDto(studentVolunteeringLog);
    }
    
    /**
     * This static method is used to create a List of StudentVolunteeringLogDto from a List of StudentVolunteeringLog data object.
     *
     * @param studentVolunteeringLogs the List of StudentVolunteeringLog data object to use for the creation.
     * @return a List of StudentVolunteeringLogDto object based on the List of StudentVolunteeringLog data object supplied.
     */
    public static List<StudentVolunteeringLogDto> mapFromList(List<StudentVolunteeringLog> studentVolunteeringLogs) {
        return studentVolunteeringLogs.collect { studentVolunteeringLog ->  new StudentVolunteeringLogDto(studentVolunteeringLog) };
    }
    
    /**
     * This method is used to return the VolunteeringType Description for the volunteering Type object
     *
     * @return the VolunteeringType Description for the volunteering type object
     */
    @JsonProperty(value = "_volunteeringTypeDescription")
    public String get_VolunteeringTypeDescription() {
        return this.volunteeringType != null ? this.volunteeringType.description : null
    }
    
    /**
     * This method is used to return the VolunteeringExperience Description for the volunteering Experience object
     *
     * @return the VolunteeringExperience Description for the volunteering Experience object
     */
    @JsonProperty(value = "_volunteeringExperienceDescription")
    public String get_VolunteeringExperienceDescription() {
        return this.volunteeringExperience != null ? this.volunteeringExperience.description : null
    }
    
    /**
     * This method is used to return the StudentRole Description for the StudentRole object
     *
     * @return the StudentRole Description for the StudentRole object
     */
    @JsonProperty(value = "_studentRoleDescription")
    public String get_StudentRoleDescription() {
        return this.studentRole != null ? this.studentRole.description : null
    }
}