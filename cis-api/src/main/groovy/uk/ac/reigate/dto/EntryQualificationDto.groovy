package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.EntryQualification
import uk.ac.reigate.exceptions.InvalidDataException

/**
 *
 * JSON serializable DTO containing EntryQualification data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class EntryQualificationDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String title;
    
    @JsonProperty
    private Integer entryQualificationTypeId;
    
    @JsonProperty
    private EntryQualificationTypeDto entryQualificationType
    
    @JsonProperty
    private boolean basicList
    
    @JsonProperty
    private boolean shortCourse
    
    @JsonProperty
    private String dataMatchCode;
    
    @JsonProperty
    private Integer webLinkCode;
    
    @JsonProperty
    private String OLDID
    
    /**
     * Default No Args constructor
     */
    public EntryQualificationDto() {
    }
    
    /**
     * Constructor to create an EntryQualificationDto object from a EntryQualification object
     *
     * @param entryQualification the EntryQualification object to use for construction
     */
    EntryQualificationDto(EntryQualification entryQualification) {
        if(entryQualification != null) {
            this.id = entryQualification.id;
            this.title = entryQualification.title;
            this.entryQualificationTypeId = entryQualification.type != null ? entryQualification.type.id : null
            this.entryQualificationType =  entryQualification.type != null ? EntryQualificationTypeDto.mapFromEntity(entryQualification.type) : null
            this.basicList = entryQualification.basicList
            this.shortCourse = entryQualification.shortCourse
            this.dataMatchCode = entryQualification.dataMatchCode;
            this.webLinkCode = entryQualification.webLinkCode;
            this.OLDID = entryQualification.OLDID
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a EntryQualificationDto from a EntryQualification data object.
     *
     * @param entryQualification the EntryQualification data object to use for the creation.
     * @return a EntryQualificationDto object based on the EntryQualification data object supplied.
     */
    public static EntryQualificationDto mapFromEntity(EntryQualification entryQualification) {
        return new EntryQualificationDto(entryQualification)
    }
    
    /**
     * This static method is used to create a List of EntryQualificationDto from a List of EntryQualification data object.
     *
     * @param entryQualifications the List of EntryQualification data object to use for the creation.
     * @return a List of EntryQualificationDto object based on the List of EntryQualification data object supplied.
     */
    public static List<EntryQualificationDto> mapFromList(List<EntryQualification> entryQualifications) {
        return entryQualifications.collect { entryQualification ->  new EntryQualificationDto(entryQualification) };
    }
    
    /**
     * This method is used to return the description for the EntryQualificationType object
     *
     * @return the description for the EntryQualificationType object
     */
    @JsonProperty(value = "_entryQualificationTypeDescription")
    public String get_EntryQualificationTypeDescription() {
        return this.entryQualificationType != null ? this.entryQualificationType.description : 'Not Set'
    }
}
