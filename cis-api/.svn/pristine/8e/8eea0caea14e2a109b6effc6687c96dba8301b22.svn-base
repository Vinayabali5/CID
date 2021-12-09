package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.LegalSex

/**
 *
 * JSON serializable DTO containing LegalSex data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class LegalSexDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public LegalSexDto() {
    }
    
    /**
     * Constructor to create a LegalSexDto object from a LegalSex object
     *
     * @param legalSex the LegalSex object to use for construction
     */
    LegalSexDto(LegalSex legalSex) {
        if(legalSex != null) {
            this.id = legalSex.id;
            this.code = legalSex.code;
            this.description = legalSex.description;
        }
    }
    
    /**
     * This static method is used to create a LegalSexDto from a LegalSex data object.
     *
     * @param legalSexcontact the LegalSex data object to use for the creation.
     * @return a LegalSexDto object based on the LegalSex data object supplied.
     */
    public static LegalSexDto mapFromEntity(LegalSex legalSex) {
        return new LegalSexDto(legalSex);
    }
    
    /**
     * This static method is used to create a List of LegalSexDto from a List of LegalSex data object.
     *
     * @param legalSexs the List of LegalSex data object to use for the creation.
     * @return a List of LegalSexDto object based on the List of LegalSex data object supplied.
     */
    public static List<LegalSexDto> mapFromList(List<LegalSex> legalSexs) {
        return legalSexs.collect { legalSex ->  new LegalSexDto(legalSex) };
    }
}
