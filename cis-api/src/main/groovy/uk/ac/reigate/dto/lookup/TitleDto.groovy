package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.Title

/**
 *
 * JSON serializable DTO containing Title data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class TitleDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public TitleDto() {
    }
    
    /**
     * Constructor to create a TitleDto object from a Title object
     *
     * @param title the Title object to use for construction
     */
    TitleDto(Title title) {
        if(title != null) {
            this.id = title.id;
            this.code = title.code;
            this.description = title.description;
        }
    }
    
    /**
     * This static method is used to create a TitleDto from a Title data object.
     *
     * @param title the Title data object to use for the creation.
     * @return a TitleDto object based on the Title data object supplied.
     */
    public static TitleDto mapFromEntity(Title title) {
        return new TitleDto(title);
    }
    
    /**
     * This static method is used to create a List of TitleDto from a List of Title data object.
     *
     * @param titles the List of Title data object to use for the creation.
     * @return a List of TitleDto object based on the List of Title data object supplied.
     */
    public static List<TitleDto> mapFromList(List<Title> titles) {
        return titles.collect { title ->  new TitleDto(title) };
    }
}