package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.Subject

/**
 *
 * JSON serializable DTO containing Subject data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
@ApiModel(description = "")
public class SubjectDto implements Serializable {
    
    @ApiModelProperty(value = "")
    @JsonProperty
    private Integer id;
    
    @ApiModelProperty(value = "")
    @JsonProperty
    private String code;
    
    @ApiModelProperty(value = "")
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public SubjectDto() {
    }
    
    /**
     * Constructor to create a SubjectDto object from a Subject object
     *
     * @param subject the Subject object to use for construction
     */
    SubjectDto(Subject subject) {
        if(subject != null) {
            this.id = subject.id;
            this.code = subject.code;
            this.description = subject.description;
        }
    }
    
    /**
     * This static method is used to create a SubjectDto from a Subject data object.
     *
     * @param subject the Subject data object to use for the creation.
     * @return a SubjectDto object based on the Subject data object supplied.
     */
    public static SubjectDto mapFromEntity(Subject subject) {
        return new SubjectDto(subject);
    }
    
    /**
     * This static method is used to create a List of SubjectDto from a List of Subject data object.
     *
     * @param subjects the List of Subject data object to use for the creation.
     * @return a List of SubjectDto object based on the List of Subject data object supplied.
     */
    public static List<SubjectDto> mapFromList(List<Subject> subjects) {
        return subjects.collect { subject ->  new SubjectDto(subject) };
    }
}