package uk.ac.reigate.domain.system;

import static org.junit.Assert.*

import org.junit.Test


public class SettingTest {
    
    
    @Test
    void testConstructor_AllFieldsWithoutId() {
        String setting = 'T'
        String value = 'TEST'
        String description = 'testing'
        Setting settings = new Setting(setting, value, description)
        
        assertNotNull(settings)
        assertEquals(settings.setting, setting)
        assertEquals(settings.value, value)
        assertEquals(settings.description, description)
    }
    
    @Test
    void testConstructor_AllFieldsWithId() {
        Integer id = 1
        String setting = 'T'
        String value = 'TEST'
        String description = 'testing'
        Setting settings = new Setting(id, setting, value, description)
        
        assertNotNull(settings)
        assertEquals(settings.id, id)
        assertEquals(settings.setting, setting)
        assertEquals(settings.value, value)
        assertEquals(settings.description, description)
    }
    
    @Test
    void testMethod_ToString() {
        Setting settingl = new Setting()
        settingl.value = 'TEST'
        
        assertEquals(settingl.setting + ": " + settingl.value, settingl.toString())
    }
}
