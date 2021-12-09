package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.Timetable

/**
 *
 * JSON serializable DTO containing Timetable data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class TimetableDto implements Serializable {
    
    @JsonProperty
    private Integer id
    
    @JsonProperty
    private Integer courseGroupId
    
    @JsonProperty
    private String _courseGroupSpec
    
    @JsonProperty
    private Integer periodId
    
    @JsonProperty
    PeriodDto _period
    
    @JsonProperty
    private Integer roomId
    
    @JsonProperty
    private RoomDto _room
    
    @JsonProperty
    private Integer teacherId
    
    @JsonProperty
    private String _teacherInitials
    
    @JsonProperty
    private Date validFrom
    
    @JsonProperty
    private Date validTo
    
    @JsonProperty
    private Date _startTime
    
    @JsonProperty
    private Date _endTime
    
    /**
     * Default No Args constructor
     */
    public TimetableDto() {
    }
    
    /**
     * Constructor to create a TimetableDto object from a Timetable object
     *
     * @param timetable the Timetable object to use for construction
     */
    TimetableDto(Timetable timetable) {
        if(timetable != null) {
            this.id = timetable.id
            this.courseGroupId = timetable.courseGroup != null ?  timetable.courseGroup.id : null
            this._courseGroupSpec = timetable.courseGroup != null ?  timetable.courseGroup.spec : null
            this.periodId = timetable.period != null ? timetable.period.id : null
            this._period = timetable.period != null ? new PeriodDto(timetable.period) : null
            this.roomId = timetable.room != null ? timetable.room.id : null
            this._room = timetable.room != null ? new RoomDto(timetable.room) : null
            this.teacherId = timetable.teacher != null ? timetable.teacher.id : null
            this._teacherInitials = timetable.teacher != null ? timetable.teacher.initials : null
            //  this.teacher = timetable.teacher != null ? new StaffSummaryDto(timetable.teacher) : null
            this.validFrom = timetable.validFrom;
            this.validTo = timetable.validTo;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a TimetableDto from a Timetable data object.
     *
     * @param timetable the Timetable data object to use for the creation.
     * @return a TimetableDto object based on the Timetable data object supplied.
     */
    public static TimetableDto mapFromEntity(Timetable timetable) {
        return new TimetableDto(timetable)
    }
    
    /**
     * This static method is used to create a List of TimetableDto from a List of Timetable data object.
     *
     * @param timetables the List of Timetable data object to use for the creation.
     * @return a List of TimetableDto object based on the List of Timetable data object supplied.
     */
    public static List<TimetableDto> mapFromList(List<Timetable> timetables) {
        return  timetables.collect { timetable ->  new TimetableDto(timetable) };
    }
}
