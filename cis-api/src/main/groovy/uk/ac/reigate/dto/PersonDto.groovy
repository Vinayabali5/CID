package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.security.Role
import uk.ac.reigate.dto.lookup.GenderDto
import uk.ac.reigate.dto.lookup.LegalSexDto
import uk.ac.reigate.dto.lookup.TitleDto

/**
 *
 * JSON serializable DTO containing Person data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class PersonDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer titleId;
    
    @JsonProperty
    private TitleDto title
    
    @JsonProperty
    private String firstName;
    
    @JsonProperty
    private String preferredName;
    
    @JsonProperty
    private String surname;
    
    @JsonProperty
    private String legalSurname
    
    @JsonProperty
    private String middleNames;
    
    @JsonProperty
    private String previousSurname;
    
    @JsonProperty
    private Date dob;
    
    @JsonProperty
    private Integer genderId;
    
    @JsonProperty
    private GenderDto gender
    
    @JsonProperty
    private Integer legalSexId;
    
    @JsonProperty
    private LegalSexDto legalSex
    
    @JsonProperty
    private AddressDto address;
    
    @JsonProperty
    private Integer addressId;
    
    @JsonProperty
    private String home;
    
    @JsonProperty
    private String mobile;
    
    @JsonProperty
    private String work;
    
    @JsonProperty
    private String email;
    
    @JsonProperty
    private Boolean enabled;
    
    @JsonProperty
    private Set<Role> roles;
    
    @JsonProperty
    private String username;
    
    @JsonProperty
    private List<ContactDto> contacts
    
    @JsonProperty
    private String rfidCardId;
    
    /**
     * Default No Args constructor
     */
    public PersonDto() {
    }
    
    /**
     * Constructor to create a PersonDto object from a Person object
     *
     * @param person the Person object to use for construction
     */
    PersonDto(Person person){
        if(person != null) {
            this.id = person.id;
            this.titleId = person.title != null ? person.title.id : null;
            this.title = person.title != null ? TitleDto.mapFromEntity(person.title) : null
            this.firstName = person.firstName;
            this.preferredName = person.preferredName;
            this.surname = person.surname;
            this.legalSurname = person.legalSurname;
            this.middleNames = person.middleNames;
            this.previousSurname = person.previousSurname;
            this.dob = person.dob;
            this.genderId = person.gender != null ? person.gender.id : null;
            this.gender = person.gender != null ? GenderDto.mapFromEntity(person.gender) : null
            this.legalSexId = person.legalSex != null ? person.legalSex.id : null;
            this.legalSex = person.legalSex != null ? LegalSexDto.mapFromEntity(person.legalSex) : null
            this.address = person.address != null ?  AddressDto.mapFromEntity(person.address) : null;
            this.addressId = person.address != null ? person.address.id : null;
            this.home = person.home;
            this.mobile = person.mobile;
            this.work = person.work;
            this.email = person.email;
            this.enabled = person.enabled;
            this.roles = person.roles;
            this.username = person.username;
            this.contacts = person.contacts != null ? ContactDto.mapFromList(person.contacts) : null
            this.rfidCardId = person.rfidCardId;
        }
    }
    
    /**
     * This static method is used to create a PersonDto from a Person data object.
     *
     * @param person the Person data object to use for the creation.
     * @return a PersonDto object based on the Person data object supplied.
     */
    public static PersonDto mapFromEntity(Person person) {
        return new PersonDto(person)
    }
    
    /**
     * This static method is used to create a List of PersonDto from a List of Person data object.
     *
     * @param People the List of Person data object to use for the creation.
     * @return a List of PersonDto object based on the List of Person data object supplied.
     */
    public static List<PersonDto> mapFromList(List<Person> people) {
        return people.collect { person ->  mapFromEntity(person) };
    }
    
    /**
     * This method is used to return the Title Description for the Person object
     *
     * @return the Title Description for the Person object
     */
    @JsonProperty(value = "_titleDescription")
    public String get_TitleDescription() {
        return this.title != null ? this.title.description : null
    }
    
    /**
     * This method is used to return the Gender Code for the Person object
     *
     * @return the Gender Code for the Person object
     */
    @JsonProperty(value = "_genderCode")
    public String get_GenderCode() {
        return this.gender != null ? this.gender.code : null
    }
    
    /**
     * This method is used to return the LegalSex Code for the Person object
     *
     * @return the LegalSex Code for the Person object
     */
    @JsonProperty(value = "_legalSexCode")
    public String get_LegalSexCode() {
        return this.legalSex != null ? this.legalSex.code : null
    }
}
