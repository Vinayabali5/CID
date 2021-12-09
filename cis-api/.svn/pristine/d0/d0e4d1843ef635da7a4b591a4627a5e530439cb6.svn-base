package uk.ac.reigate.dto.admissions;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.admissions.OfferType

/**
 *
 * JSON  DTO containing OfferType data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class OfferTypeDto {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private Boolean considerAsEnrolling
    
    /**
     * Default No Args constructor
     */
    public OfferTypeDto() {
    }
    
    /**
     * Constructor to create an OfferTypeDto object from a OfferType object
     *
     * @param offerType the OfferType object to use for construction
     */
    OfferTypeDto(OfferType offerType) {
        if(offerType != null) {
            this.id = offerType.id;
            this.code = offerType.code;
            this.description = offerType.description;
            this.considerAsEnrolling = offerType.considerAsEnrolling
        }
    }
    
    /**
     * This static method is used to create a OfferTypeDto from a OfferType data object.
     *
     * @param offerType the OfferType data object to use for the creation.
     * @return a OfferTypeDto object based on the OfferType data object supplied.
     */
    public static OfferTypeDto mapFromEntity(OfferType offerType) {
        return new OfferTypeDto(offerType);
    }
    
    /**
     * This static method is used to create a List of OfferTypeDto from a List of OfferType data object.
     *
     * @param offerTypes the List of OfferType data object to use for the creation.
     * @return a List of OfferTypeDto object based on the List of OfferType data object supplied.
     */
    public static List<OfferTypeDto> mapFromList(List<OfferType> offerTypes) {
        return offerTypes.collect { offerType ->  new OfferTypeDto(offerType) };
    }
}
