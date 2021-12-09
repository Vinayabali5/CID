package uk.ac.reigate.dto;

import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.ilp.StatementBank
import uk.ac.reigate.dto.ilp.StatementBankTypeDto

/**
 *
 * JSON  DTO containing StatementBank data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StatementBankDto  {
    
    @JsonProperty
    private Integer id
    
    @JsonProperty
    private Integer iLPStatementBankTypeId
    
    @JsonProperty
    private StatementBankTypeDto iLPStatementBankType
    
    @JsonProperty
    private String letterType
    
    @JsonProperty
    private String topic
    
    @JsonProperty
    private String discussion
    
    @JsonProperty
    private String target
    
    @JsonProperty
    private Boolean useForMassLetters
    
    /**
     * Default No Args constructor
     */
    public StatementBankDto() {
    }
    
    /**
     * Constructor to create a StatementBankDto object from a StatementBank object
     *
     * @param statementBank the StatementBank object to use for construction
     */
    StatementBankDto(StatementBank statementBank) {
        if (statementBank != null) {
            this.id = statementBank.id;
            this.iLPStatementBankTypeId = statementBank.statementBankType != null ? statementBank.statementBankType.id : null
            this.iLPStatementBankType = statementBank.statementBankType != null ? StatementBankTypeDto.mapFromEntity(statementBank.statementBankType) : null
            this.letterType = statementBank.letterType;
            this.topic = statementBank.topic;
            this.discussion = statementBank.discussion
            this.target = statementBank.target
            this.useForMassLetters = statementBank.useForMassLetters
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a StatementBankDto from a StatementBank data object.
     *
     * @param statementBank the StatementBank data object to use for the creation.
     * @return a StatementBankDto object based on the StatementBank data object supplied.
     */
    public static StatementBankDto mapFromEntity(StatementBank statementBank) {
        return new StatementBankDto(statementBank);
    }
    
    /**
     * This static method is used to create a List of StatementBankDto from a List of StatementBank data object.
     *
     * @param statementBanks the List of StatementBank data object to use for the creation.
     * @return a List of StatementBankDto object based on the List of StatementBank data object supplied.
     */
    public static List<StatementBankDto> mapFromList(List<StatementBank> statementBanks) {
        return statementBanks.collect { statementBank ->  new StatementBankDto(statementBank) };
    }
    
    /**
     * This method is used to return the ILPStatementBankType for the StatementBank object
     *
     * @return the ILPStatementBankType for the StatementBank object
     */
    @JsonProperty(value = "_iLPStatementBankType")
    public String get_ILPStatementBankType() {
        return this.iLPStatementBankType != null ? this.iLPStatementBankType.type : null
    }
}
