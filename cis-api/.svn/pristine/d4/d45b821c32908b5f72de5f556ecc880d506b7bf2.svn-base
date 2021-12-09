package uk.ac.reigate.dto

import java.security.InvalidParameterException

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.dto.lookup.BursaryTypeDto

@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentBursaryDto implements Serializable{
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Integer yearId;
    
    @JsonProperty
    private Integer bursaryTypeId;
    
    @JsonProperty
    private BursaryTypeDto bursaryType
    
    @JsonProperty
    private Boolean gb;
    
    @JsonProperty
    private Boolean db
    
    @JsonProperty
    private Boolean freeMealsEligibility
    
    @JsonProperty
    private Boolean receivingFreeMeals
    
    @JsonProperty
    Boolean removedFromFreeMeals
    
    /**
     * Default No Args constructor
     */
    public StudentBursaryDto() {}
    
    /**
     * Constructor to create a StudentBursaryDto object from a StudentYear object
     *
     * @param studentYear the StudentYear object to use for construction
     */
    public StudentBursaryDto(StudentYear studentYear) {
        if (studentYear) {
            this.studentId = studentYear.student != null ? studentYear.student.id : null;
            this.yearId = studentYear.year != null ? studentYear.year.id : null;
            this.bursaryTypeId = studentYear.bursaryType != null ? studentYear.bursaryType.id : null;
            this.bursaryType = studentYear.bursaryType != null ? BursaryTypeDto.mapFromEntity(studentYear.bursaryType) : null
            this.gb = studentYear.gb != null ? studentYear.gb : null;
            this.db = studentYear.db != null ? studentYear.db : null;
            this.freeMealsEligibility = studentYear.freeMealsEligibility!= null ? studentYear.freeMealsEligibility : null;
            this.receivingFreeMeals = studentYear.receivingFreeMeals != null ? studentYear.receivingFreeMeals : null;
            this.removedFromFreeMeals = studentYear.removedFromFreeMeals != null ? studentYear.removedFromFreeMeals : null;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a StudentBursaryDto from a StudentYear data object.
     *
     * @param studentYear the StudentYear data object to use for the creation.
     * @return a StudentBursaryDto object based on the StudentYear data object supplied.
     */
    public static StudentBursaryDto mapFromStudentBursaryEntity(StudentYear studentYear) {
        return new StudentBursaryDto(studentYear);
    }
    
    /**
     * This method is used to return the BursaryType description for the StudentYear object
     *
     * @return the BursaryType description for the StudentYear object
     */
    @JsonProperty(value = "_bursaryTypeDescription")
    public String get_BursaryTypeDescription() {
        return this.bursaryType != null ? this.bursaryType.description : null
    }
}
