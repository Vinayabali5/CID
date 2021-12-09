package uk.ac.reigate.domain;

import org.junit.Test

import uk.ac.reigate.domain.lookup.StaffType

import static org.junit.Assert.*


public class StaffTest {
    
    Person createPerson() {
        Person person = new Person()
        person.firstName = 'Test'
        person.surname = 'Person'
        return person
    }
    
    StaffType createStaffType() {
        StaffType type = new StaffType()
        type.code = 'A'
        return type
    }
    
    @Test
    void testMethod_ToString() {
        Staff staff = new Staff()
        
        staff.initials = 'TES'
        staff.person = createPerson()
        assertEquals('TES - ' + staff.person.toStringWithoutMiddleName(), staff.toString())
    }
}
