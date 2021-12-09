
package uk.ac.reigate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.Note
import uk.ac.reigate.dto.lookup.NoteTypeDto

/**
 *
 * JSON serializable DTO containing Note data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class NoteDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer personId;
    
    @JsonProperty
    private String note;
    
    @JsonProperty
    private Integer typeId;
    
    @JsonProperty
    private NoteTypeDto type;
    
    @JsonProperty
    private Boolean pastoral
    
    /**
     * Default No Args constructor
     */
    public NoteDto() {
    }
    
    /**
     * Constructor to create a NoteDto object from a Note object
     *
     * @param note the Note object to use for construction
     */
    NoteDto(Note note){
        if(note != null) {
            this.id = note.id;
            this.personId = note.person != null ? note.person.id : null;
            this.note = note.note;
            this.typeId = note.type != null ? note.type.id : null;
            this.type = note.type != null ? NoteTypeDto.mapFromEntity(note.type) : null
            this.pastoral = note.pastoral
        }
    }
    
    /**
     * This static method is used to create a NoteDto from a Note data object.
     *
     * @param note the Note data object to use for the creation.
     * @return a NoteDto object based on the Letter data object supplied.
     */
    public static NoteDto mapFromEntity(Note note) {
        return new NoteDto(note)
    }
    
    /**
     * This static method is used to create a List of NoteDto from a List of Note data object.
     *
     * @param notes the List of Note data object to use for the creation.
     * @return a List of NoteDto object based on the List of Note data object supplied.
     */
    public static List<NoteDto> mapFromList(List<Note> notes) {
        return notes.collect { note ->  new NoteDto(note) };
    }
    
    /**
     * This method is used to return the Note type Description for the Note object
     *
     * @return the Note type Description for the Note object
     */
    @JsonProperty(value = "_typeDescription")
    public String get_TypeDescription() {
        return this.type != null ? this.type.description : null
    }
}
