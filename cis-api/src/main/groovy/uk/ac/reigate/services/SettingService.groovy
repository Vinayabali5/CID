package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.system.Setting
import uk.ac.reigate.dto.SettingDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.system.SettingRepository

@Service
class SettingService implements ICoreDataService<Setting, Integer>{
    
    @Autowired
    SettingRepository settingRepository
    
    /**
     * Default NoArgs constructor
     */
    SettingService() {}
    
    /**
     * Autowired Constructor
     *
     * @param settingRepository
     */
    SettingService(SettingRepository settingRepository) {
        this.settingRepository = settingRepository;
    }
    
    /**
     * Find an individual setting using the settings ID fields
     *
     * @param id the ID fields to search for
     * @return the Setting object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Setting findById(Integer id) {
        return settingRepository.findById(id).orElse(null)
    }
    
    /**
     * Find an individual setting using the setting field
     * 
     * @param setting The setting field to search for
     * @return the Setting object that matches the setting supplied, or null if not found
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    @Transactional(readOnly = true)
    Setting findSettingBySetting(String setting) {
        return settingRepository.findBySetting(setting);
    }
    
    /**
     * Find a single page of Setting objects
     * @return a SearchResult set with the list of Settings
     */
    @Override
    @Transactional(readOnly = true)
    List<Setting> findAll() {
        return settingRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Setting object in the database
     *
     * @param setting the new Setting object to be saved
     * @return the saved version of the Setting object
     */
    @Override
    @Transactional
    public Setting save(Setting setting) {
        return settingRepository.save(setting)
    }
    
    /**
     * This service method is used to update an Setting object in the database from a partial or complete Setting object.
     *
     * @param setting the partial or complete Setting object to be saved
     * @return the saved version of the Setting object
     */
    @Transactional
    public Setting createFromDto(SettingDto setting) {
        if (setting == null) {
            throw new InvalidDataException("Cannot update setting from null object.")
        }
        Setting settingToSave = new Setting()
        settingToSave.setting = setting.setting
        settingToSave.value = setting.value
        settingToSave.description = setting.description
        return save(settingToSave)
    }
    
    /**
     * This service method is used to update an Setting object in the database from a partial or complete Setting object.
     *
     * @param setting the partial or complete Setting object to be saved
     * @return the saved version of the Setting object
     */
    @Transactional
    public Setting updateFromDto(SettingDto setting) {
        if (setting == null) {
            throw new InvalidDataException("Cannot update setting from null object.")
        }
        Setting settingToSave = findById(setting.id)
        settingToSave.setting = setting.setting
        settingToSave.value = setting.value
        settingToSave.description = setting.description
        return save(settingToSave)
    }
    
    /**
     * Saves a list of Setting objects to the database
     *
     * @param settings a list of Settings to be saved to the database
     * @return the list of save Setting objects
     */
    @Transactional
    public List<Setting> saveSettings(List<Setting> settings) {
        return settings.collect { setting -> save(setting) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Setting should not be deleted.
     */
    @Override
    public void delete(Setting obj) {
        throw new InvalidOperationException("Setting should not be deleted")
    }
    
    /**
     * This method is a shorthand version of the findSettingBySetting(setting) method.
     */
    @Transactional
    public Setting getSetting(String setting) {
        return settingRepository.findBySetting(setting)
    }
}
