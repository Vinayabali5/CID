package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.YearGroup

/**
 *
 * JSON serializable DTO containing YearGroup data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class YearGroupDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private Boolean excludeTTCheck
    
    /**
     * Default No Args constructor
     */
    public YearGroupDto() {
    }
    
    /**
     * Constructor to create a YearGroup Dto object from a YearGroup  object
     *
     * @param yearGroup  the YearGroup  object to use for construction
     */
    YearGroupDto(YearGroup yearGroup) {
        if(yearGroup != null) {
            this.id = yearGroup.id;
            this.code = yearGroup.code;
            this.description = yearGroup.description;
            this.excludeTTCheck = yearGroup.excludeTTCheck
        }
    }
    
    /**
     * This static method is used to create a YearGroupDto from a YearGroup data object.
     *
     * @param yearGroup the YearGroup data object to use for the creation.
     * @return a YearGroupDto object based on the YearGroup data object supplied.
     */
    public static YearGroupDto mapFromEntity(YearGroup yearGroup) {
        return new YearGroupDto(yearGroup);
    }
    
    /**
     * This static method is used to create a List of YearGroupDto from a List of YearGroup data object.
     *
     * @param yearGroups the List of YearGroup data object to use for the creation.
     * @return a List of YearGroupDto object based on the List of YearGroup data object supplied.
     */
    public static List<YearGroupDto> mapFromList(List<YearGroup> yearGroups) {
        return yearGroups.collect { yearGroup ->  new YearGroupDto(yearGroup) };
    }
}
