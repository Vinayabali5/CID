package uk.ac.reigate.dto.staff;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.staff.StaffAbsence
import uk.ac.reigate.dto.StaffSummaryDto


/**
 *
 * JSON serializable DTO containing StaffAbsence data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StaffAbsenceDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer staffId;
    
    @JsonProperty
    private StaffSummaryDto staff;
    
    @JsonProperty
    private Date startDate
    
    @JsonProperty
    private Date endDate
    
    @JsonProperty
    private Integer absenceReasonId
    
    @JsonProperty
    private AbsenceReasonDto absenceReason
    
    @JsonProperty
    private String reason
    
    //	@JsonProperty
    //	private String illnessCode
    
    @JsonProperty
    private Double daysAbsence
    
    @JsonProperty
    private String comment
    
    /**
     * Default No Args constructor
     */
    public StaffAbsenceDto() {
    }
    
    /**
     * Constructor to create a StaffAbsenceDto object from a StaffAbsence object
     *
     * @param staffAbsence the StaffAbsence object to use for construction
     */
    StaffAbsenceDto(StaffAbsence staffAbsence) {
        if(staffAbsence != null) {
            this.id = staffAbsence.id;
            this.staffId = staffAbsence.staff != null ? staffAbsence.staff.id : null;
            this.staff = staffAbsence.staff != null ? StaffSummaryDto.mapFromEntity(staffAbsence.staff) : null;
            this.startDate = staffAbsence.startDate
            this.endDate = staffAbsence.endDate
            this.absenceReasonId = staffAbsence.absenceReason != null ? staffAbsence.absenceReason.id : null;
            this.absenceReason = staffAbsence.absenceReason != null ? AbsenceReasonDto.mapFromEntity(staffAbsence.absenceReason) : null;
            this.reason = staffAbsence.reason
            //this.illnessCode = staffAbsence.illnessCode
            this.daysAbsence = staffAbsence.daysAbsence
            this.comment = staffAbsence.comment
        }
    }
    
    /**
     * This static method is used to create a StaffAbsenceDto from a StaffAbsence data object.
     *
     * @param staffAbsence the StaffAbsence data object to use for the creation.
     * @return a StaffAbsenceDto object based on the StaffAbsence data object supplied.
     */
    public static StaffAbsenceDto mapFromEntity(StaffAbsence staffAbsence) {
        return new StaffAbsenceDto(staffAbsence);
    }
    
    /**
     * This static method is used to create a List of StaffAbsenceDto from a List of StaffAbsence data object.
     *
     * @param staffAbsences the List of StaffAbsence data object to use for the creation.
     * @return a List of LetterDto object based on the List of StaffAbsence data object supplied.
     */
    public static List<StaffAbsenceDto> mapFromList(List<StaffAbsence> staffAbsences) {
        return staffAbsences.collect { staffAbsence ->  new StaffAbsenceDto(staffAbsence) };
    }
}
