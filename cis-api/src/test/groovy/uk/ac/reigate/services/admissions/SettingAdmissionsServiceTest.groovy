package uk.ac.reigate.services.admissions

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.system.Setting
import uk.ac.reigate.repositories.system.SettingRepository
import uk.ac.reigate.services.admissions.SettingAdmissionsService


class SettingAdmissionsServiceTest {
    
    @Mock
    private SettingRepository settingRepository
    
    @InjectMocks
    private SettingAdmissionsService settingAdmissionsService;
    
    private Setting setting
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Before
    public void setup() {
        this.settingRepository = mock(SettingRepository.class);
        this.settingAdmissionsService = new SettingAdmissionsService(settingRepository);
        
        when(settingRepository.findBySetting('vinaya')).thenReturn(setting);
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        SettingAdmissionsService service = new SettingAdmissionsService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testGetSetting() {
        String settingName = 'Vinaya'
        Setting result = settingAdmissionsService.getSetting(settingName);
        verify(settingRepository, times(1)).findBySetting(settingName)
        verifyNoMoreInteractions(settingRepository)
    }
}