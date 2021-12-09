package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.ContactType

/**
 *
 * JSON serializable DTO containing ContactType data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class ContactTypeDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String name;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public ContactTypeDto() {
    }
    
    /**
     * Constructor to create a ContactTypeDto object from a ContactType object
     *
     * @param contactType the ContactType object to use for construction
     */
    ContactTypeDto(ContactType contactType) {
        if(contactType != null) {
            this.id = contactType.id;
            this.name = contactType.name;
            this.description = contactType.description;
        }
    }
    
    /**
     * This static method is used to create a ContactTypeDto from a ContactType data object.
     *
     * @param contactType the ContactType data object to use for the creation.
     * @return a ContactTypeDto object based on the ContactType data object supplied.
     */
    public static ContactTypeDto mapFromEntity(ContactType contactType) {
        return new ContactTypeDto(contactType);
    }
    
    /**
     * This static method is used to create a List of ContactTypeDto from a List of ContactType data object.
     *
     * @param contactTypes the List of ContactType data object to use for the creation.
     * @return a List of ContactTypeDto object based on the List of ContactType data object supplied.
     */
    public static List<ContactTypeDto> mapFromList(List<ContactType> contactTypes) {
        return contactTypes.collect { contactType ->  new ContactTypeDto(contactType) };
    }
}
