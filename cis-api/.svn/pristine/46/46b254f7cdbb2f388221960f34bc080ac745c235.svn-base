package uk.ac.reigate.dto.risk_assessment;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.risk_assessment.RiskLevel


/**
 *
 * JSON serializable DTO containing RiskLevel data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class RiskLevelDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private Integer priority
    
    @JsonProperty
    private Boolean sendEmail
    
    @JsonProperty
    private Boolean sendEmailSafeguarding
    
    /**
     * Default No Args constructor
     */
    public RiskLevelDto() {
    }
    
    /**
     * Constructor to create a RiskLevelDto object from a RiskLevel object
     *
     * @param riskLevel the RiskLevel object to use for construction
     */
    RiskLevelDto(RiskLevel riskLevel) {
        if (riskLevel != null) {
            this.id = riskLevel.id;
            this.code = riskLevel.code;
            this.description = riskLevel.description;
            this.priority = riskLevel.priority
            this.sendEmail = riskLevel.sendEmail
            this.sendEmailSafeguarding = riskLevel.sendEmailSafeguarding
        }
    }
    
    /**
     * This static method is used to create a RiskLevelDto from a RiskLevel data object.
     *
     * @param riskLevel the RiskLevel data object to use for the creation.
     * @return a RiskLevelDto object based on the RiskLevel data object supplied.
     */
    public static RiskLevelDto mapFromEntity(RiskLevel riskLevel) {
        return new RiskLevelDto(riskLevel);
    }
    
    /**
     * This static method is used to create a List of RiskLevelDto from a List of RiskLevel data object.
     *
     * @param riskLevels the List of RiskLevel data object to use for the creation.
     * @return a List of RiskLevelDto object based on the List of RiskLevel data object supplied.
     */
    public static List<RiskLevelDto> mapFromList(List<RiskLevel> riskLevels) {
        return riskLevels.collect { riskLevel ->  new RiskLevelDto(riskLevel) };
    }
}
