package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.learning_support.StudentConcessionType
import uk.ac.reigate.dto.lookup.ConcessionTypeDto

/**
 *
 * JSON serializable DTO containing ConcessionType data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentConcessionTypeDto implements Serializable {
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Integer concessionTypeId;
    
    @JsonProperty
    private ConcessionTypeDto concessionType;
    
    @JsonProperty
    private Integer extraTimePercentage;
    
    /**
     * Default No Args constructor
     */
    public StudentConcessionTypeDto() {
    }
    
    /**
     * Constructor to create a StudentConcessionTypeDto object from a StudentConcessionType object
     *
     * @param studentConcessionType the StudentConcessionType object to use for construction
     */
    public StudentConcessionTypeDto(StudentConcessionType studentConcessionType) {
        if(studentConcessionType != null) {
            this.studentId = studentConcessionType.student != null ? studentConcessionType.student.id : null;
            this.concessionType = studentConcessionType.concessionType != null ? ConcessionTypeDto.mapFromEntity(studentConcessionType.concessionType) : null
            this.concessionTypeId = studentConcessionType.concessionType != null ? studentConcessionType.concessionType.id : null;
            this.extraTimePercentage = studentConcessionType.extraTimePercentage;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a StudentConcessionTypeDto from a StudentConcessionType data object.
     *
     * @param studentConcessionType the StudentConcessionType data object to use for the creation.
     * @return a StudentConcessionTypeDto object based on the StudentConcessionType data object supplied.
     */
    public static StudentConcessionTypeDto mapFromEntity(StudentConcessionType studentConcessionType) {
        return new StudentConcessionTypeDto(studentConcessionType);
    }
    
    /**
     * This static method is used to create a List of StudentConcessionTypeDto from a List of StudentConcessionType data object.
     *
     * @param studentConcessionTypes the List of StudentConcessionType data object to use for the creation.
     * @return a List of StudentConcessionTypeDto object based on the List of StudentConcessionType data object supplied.
     */
    public static List<StudentConcessionTypeDto> mapFromList(List<StudentConcessionType> studentConcessionTypes) {
        return studentConcessionTypes.collect { studentConcessionType ->  new StudentConcessionTypeDto(studentConcessionType) };
    }
    
    /**
     * This method is used to return the code for the concessionType object
     *
     * @return the code for the concessionType object
     */
    @JsonProperty(value = "_concessionCode")
    public String get_ConcessionCode() {
        return this.concessionType != null ? this.concessionType.code : null
    }
    
    /**
     * This method is used to return the description for the concessionType object
     *
     * @return the description for the concessionType object
     */
    @JsonProperty(value = "_concessionDescription")
    public String get_ConcessionDescription() {
        return this.concessionType != null ? this.concessionType.description : null
    }
}
