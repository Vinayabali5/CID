package uk.ac.reigate.dto.ilp

import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.ilp.ILPInterview

/**
 * This class is used as an Update only DTO for ILP Interview data. The API will be able to
 * receive the data represented in this class to use for various Update tasks for ILP Interviews.
 * 
 * @author Michael Horgan
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class ILPInterviewUpdateDto extends ILPInterviewBaseDto {
    
    /**
     * Default No Args constructor
     */
    public ILPInterviewUpdateDto() {
    }
    
    /**
     * Constructor to create an ILPInterviewDto object from a ILPInterview object
     *
     * @param ilpInterview the ILPInterview object to use for construction
     */
    ILPInterviewUpdateDto(ILPInterview ilpInterview) {
        super(ilpInterview)
    }
    
    /**
     * This static method is used to create a ILPInterviewUpdateDto from a ILPInterview data object.
     *
     * @param iLPInterview the ILPInterview data object to use for the creation.
     * @return a ILPInterviewUpdateDto object based on the ILPInterview data object supplied.
     */
    public static ILPInterviewUpdateDto mapFromEntity(ILPInterview ilpInterview) {
        return new ILPInterviewUpdateDto(ilpInterview)
    }
    
    /**
     * This static method is used to create a List of ILPInterviewUpdateDto from a List of ILPInterview data object.
     *
     * @param iLPInterviews the List of ILPInterview data object to use for the creation.
     * @return a List of ILPInterviewUpdateDto object based on the List of ILPInterview data object supplied.
     */
    public static List<ILPInterviewUpdateDto> mapFromList(List<ILPInterview> ilpInterviews) {
        return ilpInterviews.collect { ilpInterview ->  new ILPInterviewUpdateDto(ilpInterview) };
    }
}
