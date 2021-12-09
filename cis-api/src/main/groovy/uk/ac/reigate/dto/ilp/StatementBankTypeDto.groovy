package uk.ac.reigate.dto.ilp;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.ilp.StatementBankType

/**
 *
 * JSON  DTO containing ILPStatementBankType data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StatementBankTypeDto  {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String type;
    
    /**
     * Default No Args constructor
     */
    public StatementBankTypeDto() {
    }
    
    /**
     * Constructor to create a ILPStatementBankTypeDto object from a ILPStatementBankType object
     *
     * @param iLPStatementBankType the ILPStatementBankType object to use for construction
     */
    StatementBankTypeDto(StatementBankType iLPStatementBankType) {
        if(iLPStatementBankType != null) {
            this.id = iLPStatementBankType.id;
            this.type = iLPStatementBankType.type;
        }
    }
    
    /**
     * This static method is used to create a ILPStatementBankTypeDto from a ILPStatementBankType data object.
     *
     * @param iLPStatementBankType the ILPStatementBankType data object to use for the creation.
     * @return a ILPStatementBankTypeDto object based on the ILPStatementBankType data object supplied.
     */
    public static StatementBankTypeDto mapFromEntity(StatementBankType iLPStatementBankType) {
        return new StatementBankTypeDto(iLPStatementBankType);
    }
    
    /**
     * This static method is used to create a List of ILPStatementBankTypeDto from a List of ILPStatementBankType data object.
     *
     * @param iLPStatementBankTypes the List of ILPStatementBankType data object to use for the creation.
     * @return a List of ILPStatementBankTypeDto object based on the List of ILPStatementBank=Type data object supplied.
     */
    public static List<StatementBankTypeDto> mapFromList(List<StatementBankType> iLPStatementBankTypes) {
        List<StatementBankTypeDto> output = iLPStatementBankTypes.collect { iLPStatementBankType ->  new StatementBankTypeDto(iLPStatementBankType) };
        return output
    }
}
