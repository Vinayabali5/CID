package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.system.Setting

/**
 *
 * JSON serializable DTO containing Setting data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class SettingDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String setting;
    
    @JsonProperty
    private String value;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public SettingDto() {
    }
    
    /**
     * Constructor to create a SettingDto object
     *
     * @param id the Id for the Setting
     * @param setting the setting for the Setting
     * @param value the value for the Setting
     */
    public SettingDto(Integer id, String setting, String value, String description) {
        this.id = id;
        this.setting = setting;
        this.value = value;
        this.description = description;
    }
    
    /**
     * Constructor to create a SettingDto object from a Setting object
     *
     * @param setting the Setting object to use for construction
     */
    SettingDto(Setting setting) {
        if(setting != null) {
            this.id = setting.id;
            this.setting = setting.setting;
            this.value = setting.value;
            this.description = setting.description;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a SettingDto from a Setting data object.
     *
     * @param setting the Setting data object to use for the creation.
     * @return a SettingDto object based on the Setting data object supplied.
     */
    public static SettingDto mapFromEntity(Setting setting) {
        return new SettingDto(setting);
    }
    
    /**
     * This static method is used to create a List of SettingDto from a List of Setting data object.
     *
     * @param settings the List of Setting data object to use for the creation.
     * @return a List of SettingDto object based on the List of Setting data object supplied.
     */
    public static List<SettingDto> mapFromList(List<Setting> settings) {
        List<SettingDto> output = settings.collect { setting ->  new SettingDto(setting) };
        return output
    }
}
