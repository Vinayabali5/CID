package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.academic.WorkPlacementMode
import uk.ac.reigate.exceptions.InvalidDataException

/**
 *
 * JSON serializable DTO containing WorkPlacementMode data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class WorkPlacementModeDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public WorkPlacementModeDto() {
    }
    
    /**
     * Constructor to create a WorkPlacementModeDto object from a WorkPlacementMode object
     *
     * @param workPlacementMode the WorkPlacementMode object to use for construction
     */
    WorkPlacementModeDto(WorkPlacementMode workPlacementMode) {
        if(workPlacementMode != null) {
            this.id = workPlacementMode.id;
            this.code = workPlacementMode.code;
            this.description = workPlacementMode.description;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a WorkPlacementModeDto from a WorkPlacementMode data object.
     *
     * @param workPlacementMode the WorkPlacementMode data object to use for the creation.
     * @return a WorkPlacementModeDto object based on the WorkPlacementMode data object supplied.
     */
    public static WorkPlacementModeDto mapFromEntity(WorkPlacementMode workPlacementMode) {
        return new WorkPlacementModeDto(workPlacementMode);
    }
    
    /**
     * This static method is used to create a List of WorkPlacementModeDto from a List of WorkPlacementMode data object.
     *
     * @param workPlacementModes the List of WorkPlacementMode data object to use for the creation.
     * @return a List of WorkPlacementModeDto object based on the List of WorkPlacementMode data object supplied.
     */
    public static List<WorkPlacementModeDto> mapFromList(List<WorkPlacementMode> workPlacementModes) {
        return workPlacementModes.collect { workPlacementMode ->  new WorkPlacementModeDto(workPlacementMode) };
    }
}
