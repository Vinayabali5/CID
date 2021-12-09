package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.Address
import uk.ac.reigate.exceptions.InvalidDataException

/**
 *
 * JSON serializable DTO containing Address data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class AddressDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String line1;
    
    @JsonProperty
    private String line2;
    
    @JsonProperty
    private String line3;
    
    @JsonProperty
    private String line4;
    
    @JsonProperty
    private String line5;
    
    @JsonProperty
    private String town;
    
    @JsonProperty
    private String county;
    
    @JsonProperty
    private String postcode;
    
    @JsonProperty
    private String buildingName;
    
    @JsonProperty
    private String subBuilding;
    
    @JsonProperty
    private String udprn;
    
    @JsonProperty
    private String _fullAddress;
    
    /**
     * Default No Args constructor
     */
    public AddressDto() {
    }
    
    /**
     * Constructor to create an AddressDto object from an Address object
     *
     * @param address the Address object to use for construction
     */
    AddressDto(Address address) {
        if(address != null) {
            this.id = address.id
            this.line1 = address.line1;
            this.line2 = address.line2;
            this.line3 = address.line3;
            this.line4 = address.line4;
            this.line5 = address.line5;
            this.town = address.town
            this.buildingName = address.buildingName
            this.subBuilding = address.subBuilding
            this.county = address.county
            this.postcode = address.postcode
            this._fullAddress = address.fullAddress
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a AddressDto from a Address data object.
     *
     * @param address the Address data object to use for the creation.
     * @return a AddressDto object based on the Address data object supplied.
     */
    public static AddressDto mapFromEntity(Address address) {
        return new AddressDto(address);
    }
    
    /**
     * This static method is used to create a List of AddressDto from a List of Address data object.
     *
     * @param addresses the List of Address data object to use for the creation.
     * @return a List of AddressDto object based on the List of Address data object supplied.
     */
    public static List<AddressDto> mapFromList(List<Address> addresses) {
        return addresses.collect { address ->  new AddressDto(address) };
    }
}