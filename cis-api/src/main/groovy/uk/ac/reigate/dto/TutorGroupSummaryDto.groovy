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
public class TutorGroupSummaryDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public TutorGroupSummaryDto() {
    }
    
    /**
     * Constructor to create a TutorGroupDto object from a TutorGroup object
     *
     * @param tutorGroup the TutorGroup object to use for construction
     */
    TutorGroupSummaryDto(TutorGroup tutorGroup) {
        if(tutorGroup != null) {
            this.id = tutorGroup.id;
            this.code = tutorGroup.code;
            this.description = tutorGroup.description;
        }
    }
    
    /**
     * This method is used to create a TutorGroupDto object from the supplied TutorGroup data object.
     * 
     * @param tutorGroup the TutorGroup data object to convert
     * @return a TutorGroupDto object 
     */
    public static TutorGroupSummaryDto mapFromEntity(TutorGroup tutorGroup) {
        return new TutorGroupSummaryDto(tutorGroup)
    }
    
    /**
     * This method is used to create a List of TutorGroupDto objects from a supplied List of TutorGroup data objects. 
     * 
     * @param tutorGroups a List of TutorGroup data objects to convert
     * @return a List of TutorGroupDto objects
     */
    public static List<TutorGroupSummaryDto> mapFromList(List<TutorGroup> tutorGroups) {
        return tutorGroups.collect { tutorGroup ->  new TutorGroupSummaryDto(tutorGroup) };
    }
}
