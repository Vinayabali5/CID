package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.register.Register
import uk.ac.reigate.domain.register.RegisteredSession;

/**
 *
 * JSON serializable DTO containing Register data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class RegisterDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer sessionId;
    
    @JsonProperty
    private Integer courseGroupId;
    
    @JsonProperty
    private Boolean completed;
    
    @JsonProperty
    private Integer staffCompletedId;
    
    @JsonProperty
    private Date dateCompleted;
    
    /**
     * Default No Args constructor
     */
    public RegisterDto() {
    }
    
    /**
     * Constructor to create a RegisterDto object from a Register object
     *
     * @param register the Register object to use for construction
     */
    RegisterDto(Register register){
        if(register != null) {
            this.id = register.id;
            this.sessionId = register.session != null ? register.session.id : null;
            this.courseGroupId = register.courseGroup != null ? register.courseGroup.id : null;
            this.completed = register.completed;
            this.staffCompletedId = register.staffCompleted != null ? register.staffCompleted.id : null;
            this.dateCompleted = register.dateCompleted;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a RegisterDto from a Register data object.
     *
     * @param register the Register data object to use for the creation.
     * @return a RegisterDto object based on the Register data object supplied.
     */
    public static RegisterDto mapFromEntity(Register register) {
        return new RegisterDto(register)
    }
    
    /**
     * This static method is used to create a List of RegisterDto from a List of Register data object.
     *
     * @param registers the List of Register data object to use for the creation.
     * @return a List of RegisterDto object based on the List of Register data object supplied.
     */
    public static List<RegisterDto> mapFromList(List<Register> registers) {
        return registers.collect { register ->  new RegisterDto(register) };
    }
}
