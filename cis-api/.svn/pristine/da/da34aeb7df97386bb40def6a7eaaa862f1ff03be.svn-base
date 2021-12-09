package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.register.RegisteredSession
import uk.ac.reigate.dto.SessionDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.RegisteredSessionRepository


class RegisteredSessionServiceTest {
    
    @Mock
    private RegisteredSessionRepository registeredSessionRepository
    
    @Mock
    private PeriodService periodService
    
    @InjectMocks
    private RegisteredSessionService registeredSessionService;
    
    private RegisteredSession session;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    RegisteredSession createRegisteredSession() {
        return new RegisteredSession(
                id: 1,
                date: new SimpleDateFormat("yyyy/MM/dd").parse('2011/11/11')
                )
    }
    
    SessionDto createDto() {
        RegisteredSession sampleData = createRegisteredSession()
        return new SessionDto(
                id: sampleData.id,
                date: sampleData.date
                )
    }
    
    @Before
    public void setup() {
        registeredSessionRepository = mock(RegisteredSessionRepository.class);
        periodService = mock(PeriodService.class);
        
        this.registeredSessionService = new RegisteredSessionService(registeredSessionRepository, periodService);
        
        session = createRegisteredSession()
        
        when(registeredSessionRepository.findById(1)).thenReturn(new Optional(session));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        RegisteredSessionService service = new RegisteredSessionService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindSession() {
        List<RegisteredSession> result = registeredSessionService.findAll();
        verify(registeredSessionRepository, times(1)).findAll()
        verifyNoMoreInteractions(registeredSessionRepository)
    }
    
    @Test
    public void testFindSessionById() {
        RegisteredSession result = registeredSessionService.findById(1);
        verify(registeredSessionRepository, times(1)).findById(1)
        verifyNoMoreInteractions(registeredSessionRepository)
    }
    
    @Test
    public void testSaveNewSession() {
        session.id = null
        registeredSessionService.save(session);
        verify(registeredSessionRepository, times(1)).save(session)
        verifyNoMoreInteractions(registeredSessionRepository)
    }
    
    @Test
    public void testSaveSession() {
        registeredSessionService.save(session);
        verify(registeredSessionRepository, times(1)).save(session)
        verifyNoMoreInteractions(registeredSessionRepository)
    }
    
    @Test
    public void testSaveList() {
        List<RegisteredSession> savedRegisteredSessions = registeredSessionService.saveSessions([session, session]);
        verify(registeredSessionRepository, times(2)).save(session)
        verifyNoMoreInteractions(registeredSessionRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        SessionDto dto = new SessionDto(id: 1, date: new SimpleDateFormat("yyyy/MM/dd").parse('2011/11/11'))
        registeredSessionService.createFromDto(dto)
        verify(registeredSessionRepository, times(1)).save(any(RegisteredSession.class))
        verifyNoMoreInteractions(registeredSessionRepository)
    }
    
    @Test
    public void testCreateFromDto_PeriodId() {
        SessionDto dto = createDto()
        dto.periodId = 1
        when(periodService.findById(dto.periodId)).thenReturn(null);
        registeredSessionService.createFromDto(dto)
        verify(registeredSessionRepository, times(1)).save(any(RegisteredSession.class))
        verifyNoMoreInteractions(registeredSessionRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        SessionDto dto = new SessionDto(id: 1, date: new SimpleDateFormat("yyyy/MM/dd").parse('2011/11/11'))
        registeredSessionService.updateFromDto(dto)
        verify(registeredSessionRepository, times(1)).findById(session.id)
        verify(registeredSessionRepository, times(1)).save(session)
        verifyNoMoreInteractions(registeredSessionRepository)
    }
    
    @Test
    public void testUpdateFromDto_PeriodId() {
        SessionDto dto = createDto()
        dto.periodId = 1
        when(periodService.findById(dto.periodId)).thenReturn(null);
        registeredSessionService.updateFromDto(dto)
        verify(periodService, times(1)).findById(dto.periodId)
        verifyNoMoreInteractions(periodService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        SessionDto dto = new SessionDto(id: 1, date: new SimpleDateFormat("yyyy/MM/dd").parse('2011/11/11'))
        dto.periodId = null
        registeredSessionService.updateFromDto(dto)
        verify(registeredSessionRepository, times(1)).findById(session.id)
        verify(registeredSessionRepository, times(1)).save(session)
        verifyNoMoreInteractions(registeredSessionRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create sessionDto from null object.")
        SessionDto dto = null
        registeredSessionService.createFromDto(dto)
        verifyNoMoreInteractions(registeredSessionRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update sessionDto from null object.")
        SessionDto dto = null
        registeredSessionService.updateFromDto(dto)
        verifyNoMoreInteractions(registeredSessionRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        registeredSessionService.delete(session)
        verifyNoMoreInteractions(registeredSessionRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}

