package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.admissions.CollegeFundPaid
import uk.ac.reigate.exceptions.InvalidDataException

/**
 *
 * JSON  DTO containing CollegeFundPaid data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class CollegeFundPaidDto  {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String collegeFundPaid;
    
    /**
     * Default No Args constructor
     */
    public CollegeFundPaidDto() {
    }
    
    /**
     * Constructor to create a CollegeFundPaidDto object from a CollegeFundPaid object
     *
     * @param collegeFundPaid the CollegeFundPaid object to use for construction
     */
    CollegeFundPaidDto(CollegeFundPaid collegeFundPaid) {
        if(collegeFundPaid != null) {
            this.id = collegeFundPaid.id;
            this.collegeFundPaid = collegeFundPaid.collegeFundPaid;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a CollegeFundPaidDto from a CollegeFundPaid data object.
     *
     * @param collegeFundPaid the CollegeFundPaid data object to use for the creation.
     * @return a CollegeFundPaidDto object based on the CollegeFundPaid data object supplied.
     */
    public static CollegeFundPaidDto mapFromEntity(CollegeFundPaid collegeFundPaid) {
        return new CollegeFundPaidDto(collegeFundPaid);
    }
    
    /**
     * This static method is used to create a List of CollegeFundPaidDto from a List of CollegeFundPaid data object.
     *
     * @param collegeFundPaids the List of CollegeFundPaid data object to use for the creation.
     * @return a List of CollegeFundPaidDto object based on the List of CollegeFundPaid data object supplied.
     */
    public static List<CollegeFundPaidDto> mapFromList(List<CollegeFundPaid> collegeFundPaids) {
        return collegeFundPaids.collect { collegeFundPaid ->  new CollegeFundPaidDto(collegeFundPaid) };
    }
}
