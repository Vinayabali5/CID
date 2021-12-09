package uk.ac.reigate.dto.cristal;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.cristal.InterimReportEffortGrade


/**
 *
 * JSON serializable DTO containing InterimReportEffortGrade data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class InterimReportEffortGradeDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public InterimReportEffortGradeDto() {
    }
    
    /**
     * Constructor to create a InterimReportEffortGradeDto object from a InterimReportEffortGrade object
     *
     * @param interimReportEffortGrade the InterimReportEffortGrade object to use for construction
     */
    InterimReportEffortGradeDto(InterimReportEffortGrade interimReportEffortGrade) {
        if(interimReportEffortGrade != null) {
            this.id = interimReportEffortGrade.id;
            this.code = interimReportEffortGrade.code;
            this.description = interimReportEffortGrade.description;
        }
    }
    
    /**
     * This static method is used to create a InterimReportEffortGradeDto from a InterimReportEffortGrade data object.
     *
     * @param interimReportEffortGrade the InterimReportEffortGrade data object to use for the creation.
     * @return a InterimReportEffortGradeDto object based on the InterimReportEffortGrade data object supplied.
     */
    public static InterimReportEffortGradeDto mapFromEntity(InterimReportEffortGrade interimReportEffortGrade) {
        return new InterimReportEffortGradeDto(interimReportEffortGrade);
    }
    
    /**
     * This static method is used to create a List of InterimReportEffortGradeDto from a List of InterimReportEffortGrade data object.
     *
     * @param interimReportEffortGrades the List of InterimReportEffortGrade data object to use for the creation.
     * @return a List of InterimReportEffortGradeDto object based on the List of InterimReportEffortGrade data object supplied.
     */
    public static List<InterimReportEffortGradeDto> mapFromList(List<InterimReportEffortGrade> interimReportEffortGrades) {
        return interimReportEffortGrades.collect { interimReportEffortGrade ->  new InterimReportEffortGradeDto(interimReportEffortGrade) };
    }
}