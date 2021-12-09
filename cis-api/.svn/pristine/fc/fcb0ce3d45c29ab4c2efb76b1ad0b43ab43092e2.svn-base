package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.Person
import uk.ac.reigate.dto.lookup.TitleDto

/**
 * This class is a DTO for display a summary of a person object.  
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class PersonSummaryDto implements Serializable {
    
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
    private String rfidCardId;
    
    /**
     * Default No Args constructor
     */
    PersonSummaryDto() {
    }
    
    /**
     * Constructor to create a PersonDto object from a Person object
     *
     * @param person the Person object to use for construction
     */
    PersonSummaryDto(Person person){
        if (person != null) {
            this.id = person.id;
            this.titleId = person.title != null ? person.title.id : null;
            this.title = person.title != null ? TitleDto.mapFromEntity(person.title) : null
            this.firstName = person.firstName;
            this.surname = person.surname;
            this.legalSurname = person.legalSurname;
            this.preferredName = person.preferredName;
            this.middleNames = person.middleNames;
            this.previousSurname = person.previousSurname;
            this.dob = person.dob;
            this.rfidCardId = person.rfidCardId;
        }
    }
    
    /**
     * This static method is used to create a PersonSummaryDto from a Person data object.
     *
     * @param person the Person data object to use for the creation.
     * @return a PersonSummaryDto object based on the Person data object supplied.
     */
    public static PersonSummaryDto mapFromEntity(Person person) {
        return new PersonSummaryDto(person)
    }
    
    /**
     * This static method is used to create a List of PersonSummaryDto from a List of Person data object.
     *
     * @param People the List of Person data object to use for the creation.
     * @return a List of PersonSummaryDto object based on the List of Person data object supplied.
     */
    public static List<PersonSummaryDto> mapFromList(List<Person> people) {
        return people.collect { person ->  new PersonSummaryDto(person) };
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
}
