package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.Room;
import uk.ac.reigate.domain.Staff;
import uk.ac.reigate.domain.academic.Faculty
import uk.ac.reigate.domain.lookup.TutorGroup

/**
 *
 * JSON serializable DTO containing TutorGroup data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class TutorGroupDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private Integer facultyId;
    
    @JsonProperty
    private FacultyDto faculty
    
    @JsonProperty
    private Integer tutorId;
    
    @JsonProperty
    private StaffDto tutor
    
    @JsonProperty
    private Integer seniorTutorId;
    
    @JsonProperty
    private StaffDto seniorTutor
    
    @JsonProperty
    private Integer roomId;
    
    @JsonProperty
    private RoomDto room
    
    @JsonProperty
    private Boolean inUse
    
    
    /**
     * Default No Args constructor
     */
    public TutorGroupDto() {
    }
    
    /**
     * Constructor to create a TutorGroupDto object from a TutorGroup object
     *
     * @param tutorGroup the TutorGroup object to use for construction
     */
    TutorGroupDto(TutorGroup tutorGroup) {
        if(tutorGroup != null) {
            this.id = tutorGroup.id;
            this.code = tutorGroup.code;
            this.description = tutorGroup.description;
            this.facultyId = tutorGroup.faculty != null ? tutorGroup.faculty.id : null;
            this.faculty = tutorGroup.faculty != null ? FacultyDto.mapFromEntity(tutorGroup.faculty) : null
            this.tutorId = tutorGroup.tutor != null ? tutorGroup.tutor.id : null;
            this.tutor = tutorGroup.tutor != null ? StaffDto.mapFromEntity(tutorGroup.tutor) : null
            this.seniorTutorId = tutorGroup.seniorTutor != null ? tutorGroup.seniorTutor.id : null;
            this.seniorTutor = tutorGroup.seniorTutor != null ? StaffDto.mapFromEntity(tutorGroup.seniorTutor) : null
            this.roomId = tutorGroup.room != null ? tutorGroup.room.id : null;
            this.room = tutorGroup.room != null ? RoomDto.mapFromEntity(tutorGroup.room) : null
            this.inUse = tutorGroup.inUse;
        }
    }
    
    /**
     * This method is used to create a TutorGroupDto object from the supplied TutorGroup data object.
     * 
     * @param tutorGroup the TutorGroup data object to convert
     * @return a TutorGroupDto object 
     */
    public static TutorGroupDto mapFromEntity(TutorGroup tutorGroup) {
        return new TutorGroupDto(tutorGroup)
    }
    
    /**
     * This method is used to create a List of TutorGroupDto objects from a supplied List of TutorGroup data objects. 
     * 
     * @param tutorGroups a List of TutorGroup data objects to convert
     * @return a List of TutorGroupDto objects
     */
    public static List<TutorGroupDto> mapFromList(List<TutorGroup> tutorGroups) {
        return tutorGroups.collect { tutorGroup ->  new TutorGroupDto(tutorGroup) };
    }
    
    /**
     * This method is used to return the faculty Code for the TutorGroup object
     *
     * @return the faculty Code for the TutorGroup object
     */
    @JsonProperty(value = "_facultyCode")
    public String get_FacultyCode() {
        return this.faculty != null ? this.faculty.code : null
    }
    
    /**
     * This method is used to return the faculty Description for the TutorGroup object
     *
     * @return the faculty Description for the TutorGroup object
     */
    @JsonProperty(value = "_facultyDesc")
    public String get_FacultyDesc() {
        return this.faculty != null ? this.faculty.description : null
    }
    
    /**
     * This method is used to return the room Code for the TutorGroup object
     *
     * @return the room Code for the TutorGroup object
     */
    @JsonProperty(value = "_roomCode")
    public String get_RoomCode() {
        return this.room != null ? this.room.code : null
    }
    
    /**
     * This method is used to return the tutor Initials for the TutorGroup object
     *
     * @return the tutor Initials  for the TutorGroup object
     */
    @JsonProperty(value = "_tutorInitials")
    public String get_TutorInitials() {
        return this.tutor != null ? this.tutor.initials : null
    }
    
    /**
     * This method is used to return the tutor Name for the TutorGroup object
     *
     * @return the tutor Name  for the TutorGroup object
     */
    @JsonProperty(value = "_tutorName")
    public String get_TutorName() {
        return this.tutor != null ? this.tutor.knownAs : null
    }
    
    /**
     * This method is used to return the senior tutor Initials for the TutorGroup object
     *
     * @return the tutor senior Initials  for the TutorGroup object
     */
    @JsonProperty(value = "_seniorTutorInitials")
    public String get_seniorTutorInitials() {
        return this.seniorTutor != null ? this.seniorTutor.initials : null
    }
    
    /**
     * This method is used to return the senior tutor Name for the TutorGroup object
     *
     * @return the senior tutor Name  for the TutorGroup object
     */
    @JsonProperty(value = "_seniorTutorName")
    public String get_seniorTutorName() {
        return this.seniorTutor != null ? this.seniorTutor.knownAs : null
    }
}
