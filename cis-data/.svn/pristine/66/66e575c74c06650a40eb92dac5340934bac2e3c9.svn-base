package uk.ac.reigate.domain.system

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "setting_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Setting extends BaseEntity {
    
    @Column(name='setting')
    String setting
    
    @Column(name='value')
    String value
    
    @Column(name='description')
    String description
    
    /**
     * Default NoArgs constructor
     */
    Setting() {}
    
    
    Setting(Integer id, String setting, String value, String description) {
        this.id = id;
        this.setting = setting;
        this.value = value;
        this.description = description;
    }
    /**
     * Constructor to create a new blank setting providing just a settingName
     * 
     * @param settingName the name of the setting to create
     */
    Setting(String settingName) {
        this.setting = settingName
    }
    
    /**
     * Constructor to create a new setting providing a settingName and the default value to use
     * 
     * @param settingName the name of the setting to create
     * @param value the value to set the setting to when creating
     */
    Setting(String settingName, String value, String description) {
        this(settingName)
        this.value = value
        this.description = description
    }
    
    /**
     * toString method used to display the Setting object as text
     */
    String toString() {
        return setting + ": " + value
    }
    
    /**
     * The update method is used to change the value of the setting providing a string to set the value to
     * 
     * @param value the value to change the setting to
     */
    void update(String value) {
        this.value = value
    }
    
    /**
     * The update method is used to change the value of the setting providing a Setting object to use the value of
     * 
     * @param setting a Setting object with the new value contained within 
     */
    void update(Setting setting) {
        if (this.setting == setting.setting) {
            this.update(setting.value)
        } else {
            //#TODO ensure this throws an error when mismatch found
            //			throw new SettingMismatchException('The setting name does not match the existing setting name.')
        }
    }
}
