package uk.ac.reigate.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.StudentWorkPlacement

/**
 *
 * JSON serializable DTO containing LearningSupport data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentWorkPlacementDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Date startDate
    
    @JsonProperty
    private Date endDate
    
    @JsonProperty
    private Float placementHours
    
    @JsonProperty
    private Integer workPlacementModeId
    
    @JsonProperty
    private WorkPlacementModeDto workPlacementMode
    
    @JsonProperty
    private String employer
    
    @JsonProperty
    private String extraDetails
    
    /**
     * Default No Args constructor
     */
    public StudentWorkPlacementDto() {
    }
    
    /**
     * Constructor to create a StudentWorkPlacementDto object from a Student, StudentWorkPlacement object
     *
     * @param student, studentWorkPlacement the Student, StudentWorkPlacement object to use for construction
     */
    public StudentWorkPlacementDto(StudentWorkPlacement studentWorkPlacement) {
        if(studentWorkPlacement != null) {
            this.id = studentWorkPlacement.id
            this.studentId = studentWorkPlacement.student != null ? studentWorkPlacement.student.id : null;
            this.startDate = studentWorkPlacement.startDate
            this.endDate = studentWorkPlacement.endDate
            this.placementHours = studentWorkPlacement.placementHours
            this.employer = studentWorkPlacement.employer
            this.extraDetails = studentWorkPlacement.extraDetails
            this.workPlacementModeId = studentWorkPlacement.workPlacementMode != null ? studentWorkPlacement.workPlacementMode.id : null;
            this.workPlacementMode = studentWorkPlacement.workPlacementMode != null ? WorkPlacementModeDto.mapFromEntity(studentWorkPlacement.workPlacementMode) : null
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a StudentWorkPlacementDto from a StudentWorkPlacement data object.
     *
     * @param studentWorkPlacement the StudentWorkPlacement data object to use for the creation.
     * @return a StudentWorkPlacementDto object based on the StudentWorkPlacement data object supplied.
     */
    public static StudentWorkPlacementDto mapFromEntity(StudentWorkPlacement studentWorkPlacement) {
        return new StudentWorkPlacementDto(studentWorkPlacement);
    }
    
    /**
     * This static method is used to create a List of StudentWorkPlacementDto from a List of StudentWorkPlacement data object.
     *
     * @param studentWorkPlacements the List of StudentWorkPlacement data object to use for the creation.
     * @return a List of StudentWorkPlacementDto object based on the List of StudentWorkPlacement data object supplied.
     */
    public static List<StudentWorkPlacementDto> mapFromList(List<StudentWorkPlacement> studentWorkPlacements) {
        return studentWorkPlacements.collect { studentWorkPlacement ->  new StudentWorkPlacementDto(studentWorkPlacement) };
    }
    
    /**
     * This method is used to return the WorkPlacementMode description for the Room object
     *
     * @return the WorkPlacementMode description for the Room object
     */
    @JsonProperty(value = "_workPlacementModeDescription")
    public String get_WorkPlacementModeDescription() {
        return this.workPlacementMode != null ? this.workPlacementMode.description : null
    }
}