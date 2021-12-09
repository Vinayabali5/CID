package uk.ac.reigate.dto;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.Block
import uk.ac.reigate.domain.academic.Period
import uk.ac.reigate.domain.register.RegisteredSession;

public class SessionDtoTest {
    
    private Block block
    
    private Period period
    
    private RegisteredSession session1
    
    private RegisteredSession session2
    
    private RegisteredSession session3
    
    private List<RegisteredSession> sessions
    
    @Before
    public void setupTests() {
        this.block = new Block()
        this.period = new Period()
        this.session1 = new RegisteredSession(
                id: 1,
                date: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                period: period
                );
        this.session2 = new RegisteredSession(
                id: 2,
                date: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                period: period
                );
        this.session3 = new RegisteredSession(
                id: 2,
                date: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                period: null
                );
        this.sessions = Arrays.asList(session1, session2);
    }
    SessionDto generateSessionDto() {
        return generateSession1Dto()
    }
    
    SessionDto generateSession1Dto() {
        return new SessionDto(session1.id, session1.date, session1.period.id)
    }
    
    SessionDto generateSession2Dto() {
        return new SessionDto(session2.id, session2.date, session2.period.id)
    }
    
    @Test
    public void testMapFromSessionEntityTest(){
        SessionDto sessionTest = SessionDto.mapFromEntity( session1 )
        assertEquals( sessionTest.id, session1.id );
        assertEquals( sessionTest.date, session1.date);
        assertEquals( sessionTest.periodId, session1.period.id);
    }
    
    @Test
    public void testMapFromSessionsEntitiesTest(){
        List<SessionDto> sessionTest = SessionDto.mapFromList(sessions)
        assertEquals( sessionTest[0].id, session1.id );
        assertEquals( sessionTest[0].date, session1.date);
        assertEquals( sessionTest[0].periodId, session1.period.id);
        assertEquals( sessionTest[1].id, session2.id );
        assertEquals( sessionTest[1].date, session2.date);
        assertEquals( sessionTest[1].periodId, session2.period.id);
    }
    
    @Test
    public void testEquals_Same() {
        SessionDto sessionDto1 = new SessionDto(session1)
        SessionDto sessionDto2 = new SessionDto(session1)
        assertEquals(sessionDto1, sessionDto2)
    }
    
    @Test
    public void testEquals_Different() {
        SessionDto sessionDto1 = new SessionDto(session1)
        SessionDto sessionDto2 = new SessionDto(session2)
        assertNotEquals(sessionDto1, sessionDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        SessionDto sessionDto1 = new SessionDto(session1)
        SessionDto sessionDto2 = new SessionDto(session1)
        assertEquals(sessionDto1.hashCode(), sessionDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        SessionDto sessionDto1 = new SessionDto(session1)
        SessionDto sessionDto2 = new SessionDto(session2)
        assertNotEquals(sessionDto1.hashCode(), sessionDto2.hashCode())
    }
    
    @Test
    public void testConstructor_Session() {
        SessionDto sessionTest = new SessionDto(session1)
        assertEquals( sessionTest.id, session1.id );
        assertEquals( sessionTest.date, session1.date);
        assertEquals( sessionTest.periodId, session1.period.id);
    }
    
    @Test
    public void testConstructor_NullPeriod() {
        SessionDto sessionTest = new SessionDto(session3)
        assertEquals( sessionTest.id, session3.id );
        assertEquals( sessionTest.date, session3.date);
        assertEquals( sessionTest.periodId, session3.period);
    }
}