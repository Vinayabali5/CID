package uk.ac.reigate.services.audit

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import uk.ac.reigate.domain.audit.ApiAccessLog
import uk.ac.reigate.repositories.audit.ApiAccessLogRepository


@RunWith(MockitoJUnitRunner.class)
class AuditServiceTest {
    
    @Mock
    private ApiAccessLogRepository apiAccessLogRepository
    
    @InjectMocks
    private AuditService auditService;
    
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    private ApiAccessLog apiAccessLog
    
    @Before
    public void setup() {
        this.apiAccessLogRepository = mock(ApiAccessLogRepository.class);
        this.auditService = new AuditService(apiAccessLogRepository)
        
        when(apiAccessLogRepository.save(any(ApiAccessLog.class))).thenReturn(apiAccessLog);
    }
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        AuditService service = new AuditService();
        assertNotNull(service)
    }
    
    @Test
    public void testLogApiAccess() {
        String username = 'vinaya.balakrishna'
        String remoteHost = 'test'
        String method = 'testMethod'
        String uri = 'localHost'
        String params = 'params'
        String content = 'test'
        AuditService service = auditService.logApiAccess(username, remoteHost, method, uri, params, content)
        when(apiAccessLogRepository.save(any(AuditService.class))).thenReturn(null)
    }
}