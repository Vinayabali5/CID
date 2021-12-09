package uk.ac.reigate.dto;


import javax.persistence.Column

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.academic.AlternativePeriod
import uk.ac.reigate.dto.lookup.BlockDto

/**
 *
 * JSON serializable DTO containing Period data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class AlternativePeriodDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private Integer day
    
    @JsonProperty
    private Integer dayPeriod
    
    @JsonProperty
    private Integer blockId;
    
    @JsonProperty
    private BlockDto block
    
    @JsonProperty
    private Date LviStartTime
    
    @JsonProperty
    private Date LviEndTime
    
    @JsonProperty
    private Date UviStartTime
    
    @JsonProperty
    private Date UviEndTime
    
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
    public AlternativePeriodDto() {
    }
    
    /**
     * Constructor to create a PeriodDto object from a Period object
     *
     * @param period the Period object to use for construction
     */
    AlternativePeriodDto(AlternativePeriod alternativePeriod) {
        this.id = alternativePeriod.id;
        this.code = alternativePeriod.code;
        this.description = alternativePeriod.description;
        this.blockId = alternativePeriod.block != null ? alternativePeriod.block.id : null;
        this.block = alternativePeriod.block != null ? BlockDto.mapFromEntity(alternativePeriod.block) : null
        this.day = alternativePeriod.day;
        this.dayPeriod = alternativePeriod.dayPeriod;
        this.LviStartTime = alternativePeriod.LviStartTime;
        this.LviEndTime = alternativePeriod.LviEndTime;
        this.UviStartTime = alternativePeriod.UviStartTime;
        this.UviEndTime = alternativePeriod.UviEndTime;
        this.boxNo = alternativePeriod.boxNo;
        this.cristalPeriod = alternativePeriod.cristalPeriod;
        this.length = alternativePeriod.length
        this.defaultPeriodText = alternativePeriod.defaultPeriodText
    }
    
    /**
     * This static method is used to create a AlternativePeriodDto from a AlternativePeriod data object.
     *
     * @param alternativePeriod the AlternativePeriod data object to use for the creation.
     * @return a AlternativePeriodDto object based on the AlternativePeriod data object supplied.
     */
    public static AlternativePeriodDto mapFromEntity(AlternativePeriod alternativePeriod) {
        return new AlternativePeriodDto(alternativePeriod)
    }
    
    /**
     * This static method is used to create a List of AlternativePeriodDto from a List of AlternativePeriod data object.
     *
     * @param alternativePeriods the List of AlternativePeriod data object to use for the creation.
     * @return a List of AlternativePeriodDto object based on the List of AlternativePeriod data object supplied.
     */
    public static List<AlternativePeriodDto> mapFromList(List<AlternativePeriod> alternativePeriods) {
        return alternativePeriods.collect { alternativePeriod ->  new AlternativePeriodDto(alternativePeriod) };
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
