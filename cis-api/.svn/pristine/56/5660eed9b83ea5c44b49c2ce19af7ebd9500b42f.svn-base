package uk.ac.reigate.dto.staff;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.staff.AbsenceReason


/**
 *
 * JSON serializable DTO containing AbsenceReason data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class AbsenceReasonDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String reason;
    
    /**
     * Default No Args constructor
     */
    public AbsenceReasonDto() {
    }
    
    /**
     * Constructor to create a AbsenceReasonDto object from a AbsenceReason object
     *
     * @param absenceReason the AbsenceReason object to use for construction
     */
    AbsenceReasonDto(AbsenceReason absenceReason) {
        if(absenceReason != null) {
            this.id = absenceReason.id;
            this.reason = absenceReason.reason;
        }
    }
    
    /**
     * This static method is used to create a AbsenceReasonDto from a AbsenceReason data object.
     *
     * @param absenceReason the AbsenceReason data object to use for the creation.
     * @return a AbsenceReasonDto object based on the AbsenceReason data object supplied.
     */
    public static AbsenceReasonDto mapFromEntity(AbsenceReason absenceReason) {
        return new AbsenceReasonDto(absenceReason);
    }
    
    /**
     * This static method is used to create a List of AbsenceReasonDto from a List of AbsenceReason data object.
     *
     * @param absenceReasons the List of AbsenceReason data object to use for the creation.
     * @return a List of LetterDto object based on the List of AbsenceReason data object supplied.
     */
    public static List<AbsenceReasonDto> mapFromList(List<AbsenceReason> absenceReasons) {
        return absenceReasons.collect { absenceReason ->  new AbsenceReasonDto(absenceReason) };
    }
}
