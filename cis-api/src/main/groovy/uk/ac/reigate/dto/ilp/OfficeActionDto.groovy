package uk.ac.reigate.dto.ilp

import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.ilp.OfficeAction

@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class OfficeActionDto {
    
    Integer id
    
    String action
    
    /**
     * Default No Args constructor
     */
    public OfficeActionDto() {
    }
    
    /**
     * Constructor to create a OfficeActionDto object from a OfficeAction object
     *
     * @param officeAction the OfficeAction object to use for construction
     */
    OfficeActionDto(OfficeAction officeAction) {
        this.id = officeAction.id;
        this.action = officeAction.action;
    }
    
    /**
     * This static method is used to create a OfficeActionDto from a OfficeAction data object.
     *
     * @param officeAction the OfficeAction data object to use for the creation.
     * @return a OfficeActionDto object based on the OfficeAction data object supplied.
     */
    public static OfficeActionDto mapFromEntity(OfficeAction officeAction) {
        return new OfficeActionDto(officeAction);
    }
    
    /**
     * This static method is used to create a List of OfficeActionDto from a List of OfficeAction data object.
     *
     * @param officeActions the List of OfficeAction data object to use for the creation.
     * @return a List of OfficeActionDto object based on the List of OfficeAction data object supplied.
     */
    public static List<OfficeActionDto> mapFromList(List<OfficeAction> officeActions) {
        return officeActions.collect { officeAction ->  new OfficeActionDto(officeAction) };
    }
}
