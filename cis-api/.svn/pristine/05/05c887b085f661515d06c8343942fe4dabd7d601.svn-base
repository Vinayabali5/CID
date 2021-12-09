package uk.ac.reigate.dto;

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.EntryQualificationType
import uk.ac.reigate.dto.lookup.PossibleGradeSetDto

/**
 *
 * JSON serializable DTO containing EntryQualificationType data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class EntryQualificationTypeDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private float size;
    
    @JsonProperty
    private Integer possibleGradeSetId
    
    @JsonProperty
    private PossibleGradeSetDto possibleGradeSet
    
    @JsonProperty
    private Boolean useOfRoe
    
    /**
     * Default No Args constructor
     */
    public EntryQualificationTypeDto() {
    }
    
    /**
     * Constructor to create an EntryQualificationTypeDto object from a EntryQualificationType object
     *
     * @param entryQualificationType the EntryQualificationType object to use for construction
     */
    EntryQualificationTypeDto(EntryQualificationType entryQualificationType) {
        this.id = entryQualificationType.id;
        this.code = entryQualificationType.code;
        this.description = entryQualificationType.description;
        this.size = entryQualificationType.size;
        this.possibleGradeSetId = entryQualificationType.possibleGradeSet != null ? entryQualificationType.possibleGradeSet.id : null
        this.possibleGradeSet = entryQualificationType.possibleGradeSet != null ? PossibleGradeSetDto.mapFromEntity(entryQualificationType.possibleGradeSet) : null
        this.useOfRoe = entryQualificationType.useOfRoe
    }
    
    /**
     * This static method is used to create a EntryQualificationTypeDto from a EntryQualificationType data object.
     *
     * @param entryQualificationType the EntryQualificationType data object to use for the creation.
     * @return a EntryQualificationTypeDto object based on the EntryQualificationType data object supplied.
     */
    public static EntryQualificationTypeDto mapFromEntity(EntryQualificationType entryQualificationType) {
        return new EntryQualificationTypeDto(entryQualificationType);
    }
    
    /**
     * This static method is used to create a List of EntryQualificationTypeDto from a List of EntryQualificationType data object.
     *
     * @param entryQualificationTypes the List of EntryQualificationType data object to use for the creation.
     * @return a List of EntryQualificationTypeDto object based on the List of EntryQualificationType data object supplied.
     */
    public static List<EntryQualificationTypeDto> mapFromList(List<EntryQualificationType> entryQualificationTypes) {
        return entryQualificationTypes.collect { entryQualificationType ->  new EntryQualificationTypeDto(entryQualificationType) };
    }
    
    /**
     * This method is used to return the description for the PossibleGradeSet object
     *
     * @return the description for the PossibleGradeSet object
     */
    @JsonProperty(value = "_possibleGradeSetDescription")
    public String get_EntryQualificationTypeDescription() {
        return this.possibleGradeSet != null ? this.possibleGradeSet.description : 'Not Set'
    }
}