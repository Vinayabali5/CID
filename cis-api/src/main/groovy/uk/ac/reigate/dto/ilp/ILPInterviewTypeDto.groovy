package uk.ac.reigate.dto.ilp


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.ilp.ILPInterviewType

/**
 *
 * JSON  DTO containing ILPInterviewType data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class ILPInterviewTypeDto  {
    
    @JsonProperty
    private Integer id
    
    @JsonProperty
    private String type
    
    @JsonProperty
    private Boolean requireCourseGroupId
    
    @JsonProperty
    private Boolean allowLipReferral
    
    @JsonProperty
    private Boolean allowOfficeAction
    
    @JsonProperty
    private Boolean allowEmailRelatedStaff
    
    @JsonProperty
    private Boolean defaultToPrivate
    
    @JsonProperty
    private Boolean requireTarget
    
    /**
     * Default No Args constructor
     */
    public ILPInterviewTypeDto() {
    }
    
    /**
     * Constructor to create an ILPInterviewTypeDto object from a ILPInterviewType object
     *
     * @param iLPInterviewType the ILPInterviewType object to use for construction
     */
    ILPInterviewTypeDto(ILPInterviewType iLPInterviewType) {
        this.id = iLPInterviewType.id
        this.type = iLPInterviewType.type
        this.requireCourseGroupId = iLPInterviewType.requireCourseGroupId
        this.allowLipReferral = iLPInterviewType.allowLipReferral
        this.allowOfficeAction = iLPInterviewType.allowOfficeAction
        this.allowEmailRelatedStaff = iLPInterviewType.allowEmailRelatedStaff
        this.defaultToPrivate = iLPInterviewType.defaultToPrivate
        this.requireTarget = iLPInterviewType.requireTarget
    }
    
    /**
     * This static method is used to create a ILPInterviewTypeDto from a ILPInterviewType data object.
     *
     * @param iLPInterviewType the ILPInterviewType data object to use for the creation.
     * @return a ILPInterviewTypeDto object based on the ILPInterviewType data object supplied.
     */
    public static ILPInterviewTypeDto mapFromEntity(ILPInterviewType iLPInterviewType) {
        return new ILPInterviewTypeDto(iLPInterviewType)
    }
    
    /**
     * This static method is used to create a List of ILPInterviewTypeDto from a List of ILPInterviewType data object.
     *
     * @param iLPInterviewTypes the List of ILPInterviewType data object to use for the creation.
     * @return a List of ILPInterviewTypeDto object based on the List of ILPInterviewType data object supplied.
     */
    public static List<ILPInterviewTypeDto> mapFromList(List<ILPInterviewType> iLPInterviewTypes) {
        List<ILPInterviewTypeDto> output = iLPInterviewTypes.collect { iLPInterviewType ->  new ILPInterviewTypeDto(iLPInterviewType) }
        return output
    }
}
