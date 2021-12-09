package uk.ac.reigate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.learning_support.LearningSupportCost
import uk.ac.reigate.exceptions.InvalidDataException

/**
 *
 * JSON serializable DTO containing LearningSupportCost data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class LearningSupportCostDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Date startDate;
    
    @JsonProperty
    private Date endDate;
    
    @JsonProperty
    private Double hoursPerWeek;
    
    @JsonProperty
    private Double weeks;
    
    @JsonProperty
    private Double rate;
    
    @JsonProperty
    private Integer costCategoryId;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private String periodDescription
    
    @JsonProperty
    private Integer staffId
    
    @JsonProperty
    private StaffDto staff
    
    /**
     * Default No Args constructor
     */
    public LearningSupportCostDto() {
    }
    
    /**
     * Constructor to create a LearningSupportCostDto object from a LearningSupportCost object
     *
     * @param learningSupportCost the LearningSupportCost object to use for construction
     */
    LearningSupportCostDto(LearningSupportCost learningSupportCost) {
        if(learningSupportCost != null) {
            this.id = learningSupportCost.id;
            this.studentId = learningSupportCost.student != null ? learningSupportCost.student.id : null;
            this.startDate = learningSupportCost.startDate;
            this.endDate = learningSupportCost.endDate;
            this.hoursPerWeek = learningSupportCost.hoursPerWeek;
            this.weeks = learningSupportCost.weeks;
            this.rate = learningSupportCost.rate;
            this.costCategoryId = learningSupportCost.costCategory != null ? learningSupportCost.costCategory.id : null;
            this.description = learningSupportCost.description;
            this.periodDescription = learningSupportCost.periodDescription;
            this.staffId = learningSupportCost.staff != null ? learningSupportCost.staff.id : null;
            this.staff = learningSupportCost.staff != null ? StaffDto.mapFromEntity(learningSupportCost.staff) : null
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a LearningSupportCostDto from a LearningSupportCost data object.
     *
     * @param learningSupportCost the LearningSupportCost data object to use for the creation.
     * @return a LearningSupportCostDto object based on the LearningSupportCost data object supplied.
     */
    public static LearningSupportCostDto mapFromEntity(LearningSupportCost learningSupportCost) {
        return new LearningSupportCostDto(learningSupportCost)
    }
    
    /**
     * This static method is used to create a List of LearningSupportCostDto from a List of LearningSupportCost data object.
     *
     * @param learningSupportCosts the List of LearningSupportCost data object to use for the creation.
     * @return a List of LearningSupportCostDto object based on the List of LearningSupportCost data object supplied.
     */
    public static List<LearningSupportCostDto> mapFromList(List<LearningSupportCost> learningSupportCosts) {
        return learningSupportCosts.collect { learningSupportCost ->  new LearningSupportCostDto(learningSupportCost) };
    }
    
    /**
     * This method is used to return the Staff initials for the LearningSupportCost object
     *
     * @return the Staff initials for the LearningSupportCost object
     */
    @JsonProperty(value = "_staffInitials")
    public String get_StaffInitials() {
        return this.staff != null ? this.staff.initials : null
    }
}