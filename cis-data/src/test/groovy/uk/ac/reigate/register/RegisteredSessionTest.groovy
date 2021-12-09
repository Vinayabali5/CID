package uk.ac.reigate.register;

import org.junit.Test

import uk.ac.reigate.domain.academic.Period;
import uk.ac.reigate.domain.register.RegisteredSession

import static org.junit.Assert.*



public class RegisteredSessionedSessionTest {
    
    Period createPeriod() {
        Period period = new Period()
    }
    
    @Test
    void testMethod_ToString() {
        RegisteredSession registeredSessione = new RegisteredSession()
        
        assertEquals(registeredSessione.date, registeredSessione.toString())
    }
}
