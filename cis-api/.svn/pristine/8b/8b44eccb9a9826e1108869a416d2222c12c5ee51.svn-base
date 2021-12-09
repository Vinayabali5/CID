package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.NoteType

/**
 *
 * JSON serializable DTO containing NoteType data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class NoteTypeDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public NoteTypeDto() {
    }
    
    /**
     * Constructor to create a NoteTypeDto object from a NoteType object
     *
     * @param noteType the NoteType object to use for construction
     */
    NoteTypeDto(NoteType noteType) {
        if(noteType != null) {
            this.id = noteType.id;
            this.code = noteType.code;
            this.description = noteType.description;
        }
    }
    
    /**
     * This static method is used to create a NoteTypeDto from a NoteType data object.
     *
     * @param noteType the NoteType data object to use for the creation.
     * @return a NoteTypeDto object based on the NoteType data object supplied.
     */
    public static NoteTypeDto mapFromEntity(NoteType noteType) {
        return new NoteTypeDto(noteType);
    }
    
    /**
     * This static method is used to create a List of NoteTypeDto from a List of NoteType data object.
     *
     * @param noteTypes the List of NoteType data object to use for the creation.
     * @return a List of NoteTypeDto object based on the List of NoteType data object supplied.
     */
    public static List<NoteTypeDto> mapFromList(List<NoteType> noteTypes) {
        return noteTypes.collect { noteType ->  new NoteTypeDto(noteType) };
    }
}
