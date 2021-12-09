package uk.ac.reigate.dto;

import groovy.transform.EqualsAndHashCode

import io.swagger.annotations.ApiModel

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.AcademicYear

/**
 *
 * JSON serializable DTO containing AcademicYear data
 *
 */
@ApiModel
@JsonSerialize
@EqualsAndHashCode(callSuper = true, includeFields = true)
public class AcademicYearDto extends AcademicYearSummaryDto implements Serializable {
    
    @JsonProperty
    Date startDate
    
    @JsonProperty
    Date endDate
    
    @JsonProperty
    Integer startYear
    
    @JsonProperty
    Date enumerationDate
    
    @JsonProperty
    Date teachingStartDate
    
    @JsonProperty
    Date teachingEndDate
    
    /**
     * Default No Args constructor
     */
    public AcademicYearDto() {
        super()
    }
    
    /**
     * Constructor to create an AcademicYearDto object from an AcademicYear object
     * 
     * @param academicYear the AcademicYear object to use for construction
     */
    public AcademicYearDto(AcademicYear academicYear) {
        super(academicYear)
        if (academicYear != null) {
            this.startDate = academicYear.startDate
            this.endDate = academicYear.endDate
            this.startYear = academicYear.startYear
            this.enumerationDate = academicYear.enumerationDate
            this.teachingStartDate = academicYear.teachingStartDate
            this.teachingEndDate = academicYear.teachingEndDate
        }
    }
    
    /**
     * This static method is used to create a AcademicYearDto from a AcademicYear data object.
     * 
     * @param academicYear the AcademicYear data object to use for the creation.
     * @return a AcademicYearDto object based on the AcademicYear data object supplied.
     */
    public static AcademicYearDto mapFromEntity(AcademicYear academicYear) {
        return new AcademicYearDto(academicYear)
    }
    
    /**
     * This static method is used to create a List of AcademicYearDto from a List of AcademicYear data object.
     *
     * @param academicYears the List of AcademicYear data object to use for the creation.
     * @return a List of AcademicYearDto object based on the List of AcademicYear data object supplied.
     */
    public static List<AcademicYearDto> mapFromList(List<AcademicYear> academicYears) {
        return academicYears.collect { academicYear ->  mapFromEntity(academicYear) }
    }
    
    /**
     * This method is used to provide a string representation of the object.
     */
    public String toString() {
        return this.description
    }
}
