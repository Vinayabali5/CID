package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import uk.ac.reigate.domain.system.Setting
import uk.ac.reigate.dto.SettingDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.system.SettingRepository


class SettingServiceTest {
    
    @Mock
    private SettingRepository settingRepository;
    
    @InjectMocks
    private SettingService settingService;
    
    private Setting setting
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample Setting data object to use for the testing
     * 
     * @return a sample Setting data object
     */
    Setting createSetting() {
        return new Setting(
                id: 1,
                value: '1',
                description: 'Setting 1'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample Setting created at setup
     * 
     * @return a SettingDto object based on the sample Setting
     */
    SettingDto createDto() {
        return new SettingDto(
                id: setting.id,
                value: setting.value,
                description: setting.description
                )
    }
    
    /**
     * This method is used to set up the tests for the SettingService
     */
    @Before
    public void setup() {
        this.settingRepository = Mockito.mock(SettingRepository.class);
        this.settingService = new SettingService(settingRepository);
        
        setting = createSetting()
        
        when(settingRepository.save(any(Setting.class))).thenReturn(setting);
        when(settingRepository.findById(1)).thenReturn(new Optional(setting));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        SettingService service = new SettingService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<Setting> result = settingService.findAll();
        verify(settingRepository, times(1)).findAll()
        verifyNoMoreInteractions(settingRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        Setting result = settingService.findById(1);
        verify(settingRepository, times(1)).findById(1)
        verifyNoMoreInteractions(settingRepository)
    }
    
    @Test
    public void testfindSettingBySetting() {
        Setting result = settingService.findSettingBySetting('Test');
        verify(settingRepository, times(1)).findBySetting('Test')
        verifyNoMoreInteractions(settingRepository)
    }
    
    @Test
    public void testGetSetting() {
        Setting result = settingService.getSetting('Test');
        verify(settingRepository, times(1)).findBySetting('Test')
        verifyNoMoreInteractions(settingRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        Setting savedSetting = settingService.save(setting);
        verify(settingRepository, times(1)).save(any())
        verifyNoMoreInteractions(settingRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<Setting> savedSettings = settingService.saveSettings([setting, setting]);
        verify(settingRepository, times(2)).save(setting)
        verifyNoMoreInteractions(settingRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        SettingDto dto = createDto()
        Setting settingSaved = settingService.createFromDto(dto)
        verify(settingRepository, times(1)).save(any(Setting.class))
        verifyNoMoreInteractions(settingRepository)
        assertEquals(dto.id, setting.id)
        assertEquals(dto.value, setting.value)
        assertEquals(dto.description, setting.description)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update setting from null object.")
        SettingDto dto = null
        settingService.createFromDto(dto)
        verifyNoMoreInteractions(settingRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        SettingDto dto = createDto()
        Setting settingSaved = settingService.updateFromDto(dto)
        verify(settingRepository, times(1)).findById(setting.id)
        verify(settingRepository, times(1)).save(setting)
        verifyNoMoreInteractions(settingRepository)
        assertEquals(setting.id, settingSaved.id)
        assertEquals(setting.value, settingSaved.value)
        assertEquals(setting.description, settingSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        SettingDto dto = createDto()
        Setting settingSaved = settingService.updateFromDto(dto)
        verify(settingRepository, times(1)).findById(setting.id)
        verify(settingRepository, times(1)).save(setting)
        verifyNoMoreInteractions(settingRepository)
        assertEquals(setting.id, settingSaved.id)
        assertEquals(setting.value, settingSaved.value)
        assertEquals(setting.description, settingSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update setting from null object.")
        SettingDto dto = null
        settingService.updateFromDto(dto)
        verifyNoMoreInteractions(settingRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        settingService.delete(setting)
        verifyNoMoreInteractions(settingRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}