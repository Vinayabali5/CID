
package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.admissions.Request

/**
 *
 * JSON serializable DTO containing Request data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class RequestDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private String request;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private Integer academicYearId;
    
    @JsonProperty
    private AcademicYearDto academicYear;
    
    @JsonProperty
    private Boolean coreAim;
    
    @JsonProperty
    private Boolean broadeningSubject;
    
    @JsonProperty
    private Boolean chosenAgainstAdvice
    
    @JsonProperty
    private Boolean allocated
    
    
    /**
     * Default No Args constructor
     */
    public RequestDto() {
    }
    
    /**
     * Constructor to create a RequestDto object from a Request object
     *
     * @param request the Request object to use for construction
     */
    RequestDto(Request request) {
        if(request != null) {
            this.id = request.id;
            this.studentId = request.student != null ? request.student.id : null;
            this.request = request.request;
            this.academicYearId = request.academicYear != null ? request.academicYear.id : null;
            this.academicYear = request.academicYear != null ? AcademicYearDto.mapFromEntity(request.academicYear) : null;
            this.coreAim = request.coreAim;
            this.broadeningSubject = request.broadeningSubject;
            this.chosenAgainstAdvice = request.chosenAgainstAdvice;
            this.allocated = request.allocated;
        }
    }
    
    /**
     * This static method is used to create a RequestDto from a Request data object.
     *
     * @param request the Request data object to use for the creation.
     * @return a RequestDto object based on the Request data object supplied.
     */
    public static RequestDto mapFromEntity(Request request) {
        return new RequestDto(request)
    }
    
    /**
     * This static method is used to create a List of RequestDto from a List of Request data object.
     *
     * @param requests the List of Request data object to use for the creation.
     * @return a List of RequestDto object based on the List of Request data object supplied.
     */
    public static List<RequestDto> mapFromList(List<Request> requests) {
        return requests.collect { request ->  new RequestDto(request) };
    }
    
    /**
     * This method is used to return the AcademicYear Code for the Request object
     *
     * @return the AcademicYear Code for the Request object
     */
    @JsonProperty(value = "_academicYearCode")
    public String get_AcademicYearCode() {
        return this.academicYear != null ? this.academicYear.code : null
    }
}
