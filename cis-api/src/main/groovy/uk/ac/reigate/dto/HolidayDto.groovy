package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.Holiday
import uk.ac.reigate.exceptions.InvalidDataException

/**
 *
 * JSON serializable DTO containing Holiday data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class HolidayDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer yearId;
    
    @JsonProperty
    private AcademicYearDto year
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private Date startDate;
    
    @JsonProperty
    private Date endDate;
    
    @JsonProperty
    private Boolean halfTerm
    
    /**
     * Default No Args constructor
     */
    public HolidayDto() {
    }
    
    /**
     * Constructor to create a HolidayDto object from a Holiday object
     *
     * @param holiday the Holiday object to use for construction
     */
    HolidayDto(Holiday holiday) {
        if(holiday != null) {
            this.id = holiday.id;
            this.yearId = holiday.year != null ? holiday.year.id : null;
            this.year = holiday.year != null ? AcademicYearDto.mapFromEntity(holiday.year) : null
            this.description = holiday.description;
            this.startDate = holiday.startDate;
            this.endDate = holiday.endDate;
            this.halfTerm = holiday.halfTerm;
        } else {
            throw new InvalidDataException("Cannot create HolidayDto from null object.")
        }
    }
    
    /**
     * This static method is used to create a HolidayDto from a Holiday data object.
     *
     * @param holiday the Holiday data object to use for the creation.
     * @return a HolidayDto object based on the Holiday data object supplied.
     */
    public static HolidayDto mapFromEntity(Holiday holiday) {
        return new HolidayDto(holiday);
    }
    
    /**
     * This static method is used to create a List of FacultyDto from a List of Faculty data object.
     *
     * @param holidays the List of Holiday data object to use for the creation.
     * @return a List of HolidayDto object based on the List of Holiday data object supplied.
     */
    public static List<HolidayDto> mapFromList(List<Holiday> holidays) {
        return holidays.collect { holiday ->  new HolidayDto(holiday) };
    }
    
    /**
     * This method is used to return the AcademicYear description for the Holiday object
     *
     * @return the Academic Year description for the Holiday object
     */
    @JsonProperty(value = "_yearDescription")
    public String get_YearDescription() {
        return this.year != null ? this.year.description : null
    }
}
