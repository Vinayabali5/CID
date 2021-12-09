package uk.ac.reigate.dto.admissions

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.Person;
import uk.ac.reigate.dto.PersonDto

/**
 *
 * JSON serializable DTO containing ApplicationStatus data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class DuplicateApplicationDto implements Serializable {
    
    @JsonProperty
    private Integer studentId
    
    @JsonProperty
    private PersonDto person
    
    public DuplicateApplicationDto(Integer studentId, Person person) {
        super();
        this.studentId = studentId
        this.person = PersonDto.mapFromEntity(person)
    }
}
