package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.exceptions.InvalidDataException

/**
 * This class is a DTO for display a summary of a staff object.  
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StaffSummaryDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer personId;
    
    @JsonProperty
    private PersonSummaryDto person;
    
    @JsonProperty
    private Integer typeId;
    
    @JsonProperty
    private String initials;
    
    /**
     * Default No Args constructor
     */
    public StaffSummaryDto() {
    }
    /**
     * Constructor to create a StaffSummaryDto object from a Staff object
     *
     * @param staff the Staff object to use for construction
     */
    StaffSummaryDto(Staff staff){
        if(staff != null) {
            this.id = staff.id;
            this.personId = staff.person != null ? staff.person.id : null;
            this.person = new PersonSummaryDto(staff.person);
            this.typeId = staff.type != null ? staff.type.id : null;
            this.initials = staff.initials;
        } else {
            throw new InvalidDataException("Cannot create StaffSummaryDto from null object.")
        }
    }
    
    /**
     * This method is used to map a Staff object into a StaffDto object
     * 
     * @param staff a Staff object
     * @return the StaffDto object
     */
    public static StaffSummaryDto mapFromEntity(Staff staff) {
        return new StaffSummaryDto(staff);
    }
    
    /**
     * This method is used to map from a list of Staff objects into a list of StaffDto objects
     * 
     * @param staffList a list of Staff objects
     * @return the list of StaffDto objects
     */
    public static List<StaffSummaryDto> mapFromList(List<Staff> staffList) {
        return staffList.collect { staff ->  new StaffSummaryDto(staff) };
    }
}
