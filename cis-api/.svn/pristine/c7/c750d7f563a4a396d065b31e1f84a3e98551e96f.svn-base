package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.academic.School
import uk.ac.reigate.dto.lookup.SchoolTypeDto
/**
 *
 * JSON serializable DTO containing School data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class SchoolDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String name;
    
    @JsonProperty
    private Integer typeId;
    
    @JsonProperty
    private SchoolTypeDto type
    
    @JsonProperty
    private String urn;
    
    @JsonProperty
    private Integer priorityId;
    
    @JsonProperty
    private SchoolPriorityDto priority
    
    @JsonProperty
    private String line1;
    
    @JsonProperty
    private String line2;
    
    @JsonProperty
    private String line3;
    
    @JsonProperty
    private String postcode;
    
    @JsonProperty
    private String telephone
    
    @JsonProperty
    private String headTitle
    
    @JsonProperty
    private String headFirstName
    
    @JsonProperty
    private String headSurname
    
    @JsonProperty
    private String contactTitle
    
    @JsonProperty
    private  String contactFirstName
    
    @JsonProperty
    private String contactSurname
    
    @JsonProperty
    private String contactEmail
    
    @JsonProperty
    private Boolean useInOnlineApplications;
    
    
    /**
     * Default No Args constructor
     */
    public SchoolDto() {
    }
    
    /**
     * Constructor to create a SchoolDto object from a School object
     *
     * @param school the School object to use for construction
     */
    SchoolDto(School school){
        if(school != null) {
            this.id = school.id;
            this.name = school.name;
            this.typeId = school.type != null ? school.type.id : null;
            this.type = school.type != null ? SchoolTypeDto.mapFromEntity(school.type) : null
            this.priorityId = school.priority != null ? school.priority.id : null;
            this.priority = school.priority != null ? SchoolPriorityDto.mapFromEntity(school.priority) : null
            this.urn = school.urn;
            this.line1 = school.line1;
            this.line2 = school.line2;
            this.line3 = school.line3;
            this.postcode = school.postcode;
            this.telephone = school.telephone;
            this.headTitle = school.headTitle;
            this.headFirstName = school.headFirstName;
            this.headSurname = school.headSurname;
            this.contactTitle = school.contactTitle;
            this.contactFirstName = school.contactFirstName;
            this.contactSurname = school.contactSurname;
            this.contactEmail = school.contactEmail;
            this.useInOnlineApplications = school.useInOnlineApplications;
        }
    }
    
    /**
     * This static method is used to create a SchoolDto from a School data object.
     *
     * @param school the School data object to use for the creation.
     * @return a SchoolDto object based on the School data object supplied.
     */
    public static SchoolDto mapFromEntity(School school) {
        return new SchoolDto(school)
    }
    
    /**
     * This static method is used to create a List of SchoolDto from a List of School data object.
     *
     * @param schools the List of School data object to use for the creation.
     * @return a List of SchoolDto object based on the List of School data object supplied.
     */
    public static List<SchoolDto> mapFromList(List<School> schools) {
        return schools.collect { school ->  new SchoolDto(school) };
    }
    
    /**
     * This method is used to return the SchoolType description for the School object
     *
     * @return the SchoolType description for the School object
     */
    @JsonProperty(value = "_typeDescription")
    public String get_TypeDescription() {
        return this.type != null ? this.type.description : null
    }
    
    /**
     * This method is used to return the Priority Code for the School object
     *
     * @return the Priority Code for the School object
     */
    @JsonProperty(value = "_priorityCode")
    public String get_PriorityCode() {
        return this.priority != null ? this.priority.code : null
    }
}
