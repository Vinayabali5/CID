package uk.ac.reigate.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.ilp.Correspondence
import uk.ac.reigate.dto.lookup.CorrespondenceTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
/**
 *
 * JSON serializable DTO containing Correspondence data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class CorrespondenceDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Integer courseId;
    
    @JsonProperty
    private CourseGroupSummaryDto courseGroup;
    
    @JsonProperty
    private String correspondence
    
    @JsonProperty
    private String title
    
    @JsonProperty
    private Date date
    
    @JsonProperty
    private String from
    
    @JsonProperty
    private String to
    
    @JsonProperty
    private Integer letterId
    
    @JsonProperty
    private Date staffAdvised
    
    @JsonProperty
    private Integer typeId
    
    @JsonProperty
    private CorrespondenceTypeDto correspondenceType
    
    @JsonProperty
    private String producedBy
    
    @JsonProperty
    private Boolean privateEntry
    
    @JsonProperty
    private Integer processStage
    
    @JsonProperty
    private String attachmentsSent
    
    /**
     * Default No Args constructor
     */
    public CorrespondenceDto() {
    }
    
    /**
     * Constructor to create a CorrespondenceDto object from a Correspondence object
     *
     * @param correspondence the Correspondence object to use for construction
     */
    CorrespondenceDto(Correspondence correspondence) {
        if(correspondence != null ) {
            this.id = correspondence.id;
            this.studentId = correspondence.student != null ? correspondence.student.id : null;
            this.courseId = correspondence.course != null ? correspondence.course.id : null;
            this.courseGroup = correspondence.course != null ? CourseGroupSummaryDto.mapFromEntity(correspondence.course) : null
            this.correspondence = correspondence.correspondence;
            this.title = correspondence.title;
            this.date = correspondence.date;
            this.from = correspondence.from;
            this.to = correspondence.to;
            this.letterId = correspondence.letter != null ? correspondence.letter.id : null;
            this.staffAdvised = correspondence.staffAdvised;
            this.typeId = correspondence.type != null ? correspondence.type.id : null;
            this.correspondenceType = correspondence.type != null ? CorrespondenceTypeDto.mapFromEntity(correspondence.type) : null;
            this.producedBy = correspondence.producedBy;
            this.privateEntry = correspondence.privateEntry;
            this.processStage = correspondence.processStage;
            this.attachmentsSent = correspondence.attachmentsSent;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a CorrespondenceDto from a Correspondence data object.
     *
     * @param correspondence the Correspondence data object to use for the creation.
     * @return a CorrespondenceDto object based on the Correspondence data object supplied.
     */
    public static CorrespondenceDto mapFromEntity(Correspondence correspondence) {
        return  new CorrespondenceDto(correspondence)
    }
    
    /**
     * This static method is used to create a List of CorrespondenceDto from a List of Correspondence data object.
     *
     * @param correspondences the List of Correspondence data object to use for the creation.
     * @return a List of CorrespondenceDto object based on the List of Correspondence data object supplied.
     */
    public static List<CorrespondenceDto> mapFromList(List<Correspondence> correspondenceList) {
        return correspondenceList.collect { correspondence ->  new CorrespondenceDto(correspondence) };
    }
    
    /**
     * This method is used to return the CourseGroup description for the Correspondence object
     *
     * @return the CourseGroup description for the Correspondence object
     */
    @JsonProperty(value = "_courseGroupDescription")
    public String get_CourseGroupDescription() {
        return this.courseGroup != null ? this.courseGroup.code : null;
    }
    
    /**
     * This method is used to return the CourseGroup spec for the Correspondence object
     *
     * @return the CourseGroup spec for the Correspondence object
     */
    @JsonProperty(value = "_courseGroupSpec")
    public String get_CourseGroupSpec() {
        return this.courseGroup != null ? this.courseGroup.spec : null;
    }
    
    /**
     * This method is used to return the CorrespondenceType description for the Correspondence object
     *
     * @return the CorrespondenceType description for the Correspondence object
     */
    @JsonProperty(value = "_correspondenceTypeDescription")
    public String get_CorrespondenceTypeDescription() {
        return this.correspondenceType != null ? this.correspondenceType.type : null;
    }
}