package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.academic.Block
import uk.ac.reigate.domain.academic.Period
import uk.ac.reigate.dto.lookup.BlockDto

/**
 *
 * JSON serializable DTO containing Period data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class PeriodDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private Integer blockId;
    
    @JsonProperty
    private BlockDto block
    
    @JsonProperty
    private Date startTime;
    
    @JsonProperty
    private Date endTime;
    
    @JsonProperty
    private Integer day;
    
    @JsonProperty
    private Integer dayPeriod;
    
    @JsonProperty
    private Integer boxNo
    
    @JsonProperty
    private Integer cristalPeriod
    
    @JsonProperty
    private Integer length
    
    @JsonProperty
    private String defaultPeriodText
    
    /**
     * Default No Args constructor
     */
    public PeriodDto() {
    }
    
    /**
     * Constructor to create a PeriodDto object from a Period object
     *
     * @param period the Period object to use for construction
     */
    PeriodDto(Period period) {
        if(period != null) {
            this.id = period.id;
            this.code = period.code;
            this.description = period.description;
            this.blockId = period.block != null ? period.block.id : null;
            this.block = period.block != null ? BlockDto.mapFromEntity(period.block) : null
            this.startTime = period.startTime;
            this.endTime = period.endTime;
            this.day = period.day;
            this.dayPeriod = period.dayPeriod;
            this.boxNo = period.boxNo;
            this.cristalPeriod = period.cristalPeriod;
            this.length = period.length
            this.defaultPeriodText = period.defaultPeriodText
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a PeriodDto from a Period data object.
     *
     * @param period the Period data object to use for the creation.
     * @return a PeriodDto object based on the Period data object supplied.
     */
    public static PeriodDto mapFromEntity(Period period) {
        return new PeriodDto(period)
    }
    
    /**
     * This static method is used to create a List of PeriodDto from a List of Period data object.
     *
     * @param periods the List of Period data object to use for the creation.
     * @return a List of PeriodDto object based on the List of Period data object supplied.
     */
    public static List<PeriodDto> mapFromList(List<Period> periods) {
        return periods.collect { period ->  new PeriodDto(period) };
    }
    
    /**
     * This method is used to return the Block Description for the Period object
     *
     * @return the Block Description for the Period object
     */
    @JsonProperty(value = "_blockDescription")
    public String get_BlockDescription() {
        return this.block != null ? this.block.description : null
    }
}
