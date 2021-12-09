package uk.ac.reigate.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.Contact
import uk.ac.reigate.dto.lookup.ContactTypeDto
/**
 *
 * JSON serializable DTO containing Contact data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class ContactDto implements Serializable{
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer personId;
    
    @JsonProperty
    private Integer contactId;
    
    @JsonProperty
    private Integer contactTypeId;
    
    @JsonProperty
    private ContactTypeDto contactType;
    
    @JsonProperty
    private Boolean contactable;
    
    @JsonProperty
    private Boolean preferred;
    
    @JsonProperty
    private Boolean alternativeAddress;
    
    @JsonProperty
    private PersonDto contact;
    
    /**
     * Default No Args constructor
     */
    public ContactDto() {
    }
    
    /**
     * Constructor to create a ContactDto object from a Contact object
     *
     * @param contact the Contact object to use for construction
     */
    ContactDto(Contact contact) {
        this.id = contact.id;
        this.personId = contact.person != null ? contact.person.id : null;
        this.contactId = contact.contact != null ? contact.contact.id : null;
        this.contactTypeId = contact.contactType != null ? contact.contactType.id : null;
        this.contactType = contact.contactType != null ? ContactTypeDto.mapFromEntity(contact.contactType) : null
        this.contactable = contact.contactable;
        this.preferred = contact.preferred;
        this.alternativeAddress = contact.alternativeAddress;
        this.contact = PersonDto.mapFromEntity(contact.contact)
    }
    
    /**
     * This static method is used to create a ContactDto from a Contact data object.
     *
     * @param contact the Contact data object to use for the creation.
     * @return a ContactDto object based on the Contact data object supplied.
     */
    public static ContactDto mapFromEntity(Contact contact) {
        return  new ContactDto(contact)
    }
    
    /**
     * This static method is used to create a List of ContactDto from a List of Contact data object.
     *
     * @param contacts the List of Contact data object to use for the creation.
     * @return a List of ContactDto object based on the List of Contact data object supplied.
     */
    public static List<ContactDto> mapFromList(List<Contact> contacts) {
        return contacts.collect { contact -> mapFromEntity(contact)};
    }
    
    /**
     * This method is used to return the description for the ContactType object
     *
     * @return the description for the ContactType object
     */
    @JsonProperty(value = "_contactTypeDescription")
    public String get_ContactTypeDescription() {
        return this.contactType != null ? this.contactType.description : null
    }
    
    /**
     * This method is used to return the description for the Title object
     *
     * @return the description for the Title object
     */
    @JsonProperty(value = "_titleDescription")
    public String get_TitleDescription() {
        return this.contact.title != null ? this.contact.title.description : null
    }
    
    /**
     * This method is used to return the code for the Gender object
     *
     * @return the code for the Gender object
     */
    @JsonProperty(value = "_genderCode")
    public String get_GenderCode() {
        return this.contact.gender != null ? this.contact.gender.code : null
    }
}
