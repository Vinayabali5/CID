package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.dto.ilr.EthnicityDto
import uk.ac.reigate.dto.staff.DisabilityDto
import uk.ac.reigate.dto.staff.MaritalStatusDto
import uk.ac.reigate.dto.staff.ReligionDto
import uk.ac.reigate.dto.staff.SexualOrientationDto

/**
 *
 * JSON serializable DTO containing Staff data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StaffDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer personId;
    
    @JsonProperty
    private PersonDto person;
    
    @JsonProperty
    private Integer typeId;
    
    @JsonProperty
    private Boolean onTimetable;
    
    @JsonProperty
    private String initials;
    
    @JsonProperty
    private String knownAs;
    
    @JsonProperty
    private String networkLogin;
    
    @JsonProperty
    private Date startDate;
    
    @JsonProperty
    private Date continualServiceStartDate;
    
    @JsonProperty
    private Date endDate;
    
    @JsonProperty
    private Integer staffRef;
    
    @JsonProperty
    private Integer staffDetailsId;
    
    @JsonProperty
    private String StaffEmail
    
    @JsonProperty
    private String signature
    
    @JsonProperty
    private String emergencyContactName
    
    @JsonProperty
    private String emergencyContactRelationship
    
    @JsonProperty
    private String emergencyContactNumber
    
    @JsonProperty
    private String niNumber
    
    @JsonProperty
    private String dfeNumber
    
    @JsonProperty
    private String nationality
    
    @JsonProperty
    private Integer ethnicityId
    
    @JsonProperty
    private EthnicityDto ethnicity
    
    @JsonProperty
    private DisabilityDto disability
    
    @JsonProperty
    private Integer disabilityId
    
    @JsonProperty
    private Integer sexualOrientationId
    
    @JsonProperty
    private SexualOrientationDto sexualOrientation
    
    @JsonProperty
    private Integer maritalStatusId
    
    @JsonProperty
    private MaritalStatusDto maritalStatus
    
    @JsonProperty
    private Integer religionId
    
    @JsonProperty
    private ReligionDto religion
    /**
     * Default No Args constructor
     */
    public StaffDto() {
    }
    
    /**
     * Constructor to create a StaffDto object from a Staff object
     *
     * @param staff the Staff object to use for construction
     */
    StaffDto(Staff staff){
        if(staff != null) {
            this.id = staff.id;
            this.personId = staff.person != null ? staff.person.id : null;
            this.person = staff.person != null ? new PersonDto(staff.person) : null;
            this.typeId = staff.type != null ? staff.type.id : null;
            this.onTimetable = staff.onTimetable;
            this.initials = staff.initials;
            this.knownAs = staff.knownAs;
            this.networkLogin = staff.networkLogin
            this.startDate = staff.startDate;
            this.continualServiceStartDate = staff.continualServiceStartDate;
            this.endDate = staff.endDate;
            this.staffRef = staff.staffRef;
            this.staffDetailsId = staff.staffDetailsId;
            this.StaffEmail = staff.staffEmail;
            this.signature = staff.signature
            this.emergencyContactName = staff.emergencyContactName;
            this.emergencyContactRelationship = staff.emergencyContactRelationship;
            this.emergencyContactNumber = staff.emergencyContactNumber;
            this.niNumber = staff.niNumber
            this.dfeNumber = staff.dfeNumber
            this.nationality = staff.nationality
            this.ethnicityId = staff.ethnicity != null ? staff.ethnicity.id : null;
            this.ethnicity = staff.ethnicity != null ? new EthnicityDto(staff.ethnicity) : null;
            this.disabilityId = staff.disability != null ? staff.disability.id : null;
            this.disability = staff.disability != null ? new DisabilityDto(staff.disability) : null;
            this.sexualOrientationId = staff.sexualOrientation != null ? staff.sexualOrientation.id : null
            this.sexualOrientation = staff.sexualOrientation != null ? new SexualOrientationDto(staff.sexualOrientation) : null;
            this.maritalStatusId = staff.maritalStatus != null ? staff.maritalStatus.id : null
            this.maritalStatus = staff.maritalStatus != null ? new MaritalStatusDto(staff.maritalStatus) : null;
            this.religionId = staff.religion != null ? staff.religion.id : null
            this.religion = staff.religion != null ? new ReligionDto(staff.religion) : null;
        }
    }
    
    /**
     * This method is used to map a Staff object into a StaffDto object
     * 
     * @param staff a Staff object
     * @return the StaffDto object
     */
    public static StaffDto mapFromEntity(Staff staff) {
        return new StaffDto(staff);
    }
    
    /**
     * This method is used to map from a list of Staff objects into a list of StaffDto objects
     * 
     * @param staffList a list of Staff objects
     * @return the list of StaffDto objects
     */
    public static List<StaffDto> mapFromList(List<Staff> staffList) {
        return staffList.collect { staff ->  new StaffDto(staff) };
    }
}
