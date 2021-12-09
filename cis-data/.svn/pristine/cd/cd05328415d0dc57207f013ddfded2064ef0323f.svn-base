package uk.ac.reigate.register;

import org.junit.Test

import uk.ac.reigate.domain.Staff;
import uk.ac.reigate.domain.academic.CourseGroup;
import uk.ac.reigate.domain.register.Register
import uk.ac.reigate.domain.register.RegisteredSession;

import static org.junit.Assert.*


public class RegisterTest {
    
    RegisteredSession createRegisteredSession() {
        RegisteredSession session = new RegisteredSession()
    }
    
    CourseGroup createCourseGroup() {
        CourseGroup courseGroup = new CourseGroup()
    }
    
    Staff createStaff() {
        Staff staffCompleted = new Staff()
    }
    
    @Test
    void testMethod_ToString() {
        Register registere = new Register()
        RegisteredSession session = createRegisteredSession()
        registere.session = session
        
        assertEquals(registere.session.id, registere.toString())
    }
}
