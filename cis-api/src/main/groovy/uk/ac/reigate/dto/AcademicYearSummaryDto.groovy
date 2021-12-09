package uk.ac.reigate.dto;

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

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
@EqualsAndHashCode(includeFields = true)
@ToString
public class AcademicYearSummaryDto implements Serializable {
    
    @JsonProperty
    Integer id
    
    @JsonProperty
    String code
    
    @JsonProperty
    String description
    
    /**
     * Default No Args constructor
     */
    public AcademicYearSummaryDto() {}
    
    /**
     * Constructor to create an AcademicYearDto object from an AcademicYear object
     * 
     * @param academicYear the AcademicYear object to use for construction
     */
    public AcademicYearSummaryDto(AcademicYear academicYear) {
        if (academicYear != null) {
            this.id = academicYear.id
            this.code = academicYear.code
            this.description = academicYear.description
        }
    }
    
    /**
     * This static method is used to create a AcademicYearDto from a AcademicYear data object.
     * 
     * @param academicYear the AcademicYear data object to use for the creation.
     * @return a AcademicYearDto object based on the AcademicYear data object supplied.
     */
    public static AcademicYearSummaryDto mapFromEntity(AcademicYear academicYear) {
        return new AcademicYearSummaryDto(academicYear)
    }
    
    /**
     * This static method is used to create a List of AcademicYearDto from a List of AcademicYear data object.
     *
     * @param academicYears the List of AcademicYear data object to use for the creation.
     * @return a List of AcademicYearDto object based on the List of AcademicYear data object supplied.
     */
    public static List<AcademicYearSummaryDto> mapFromList(List<AcademicYear> academicYears) {
        List<AcademicYearSummaryDto> output = academicYears.collect { academicYear ->  mapFromEntity(academicYear) }
        return output
    }
}
