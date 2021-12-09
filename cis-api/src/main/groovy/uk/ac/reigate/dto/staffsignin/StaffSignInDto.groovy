package uk.ac.reigate.dto.staffsignin

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.staffsignin.StaffSignin
import uk.ac.reigate.dto.StaffSummaryDto

@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class StaffSignInDto implements Serializable {
    
    String rfid
    
    String rfidHex
    
    @JsonProperty
    private Integer id
    
    @JsonProperty
    private Integer staffId
    
    @JsonProperty
    private StaffSummaryDto staff
    
    @JsonProperty
    private Date signinTime
    
    @JsonProperty
    private Date signoutTime
    
    StaffSignInDto() {}
    
    StaffSignInDto(StaffSignin staffSignin){
        if(staffSignin != null) {
            this.id = staffSignin.id
            this.staffId = staffSignin.staff != null ? staffSignin.staff.id : null;
            this.staff = staffSignin.staff != null ? StaffSummaryDto.mapFromEntity(staffSignin.staff) : null;
            this.signinTime = staffSignin.signinTime
            this.signoutTime = staffSignin.signoutTime
        }
    }
    
    /**
     * This static method is used to create a StaffSignInDto from a StaffSignIn data object.
     *
     * @param staffSignIn the StaffSignIn data object to use for the creation.
     * @return a StaffSignInDto object based on the StaffSignIn data object supplied.
     */
    public static StaffSignInDto mapFromEntity(StaffSignin staffSignin) {
        return new StaffSignInDto(staffSignin);
    }
    
    /**
     * This static method is used to create a List of StaffSignInDto from a List of StaffSignIn data object.
     *
     * @param staffSignIns the List of StaffSignIn data object to use for the creation.
     * @return a List of StaffSignInDto object based on the List of StaffSignIn data object supplied.
     */
    public static List<StaffSignInDto> mapFromList(List<StaffSignin> staffSignins) {
        return staffSignins.collect { staffSignin ->  new StaffSignInDto(staffSignin) };
    }
}
