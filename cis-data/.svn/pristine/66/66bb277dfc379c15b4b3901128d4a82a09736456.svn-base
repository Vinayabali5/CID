package uk.ac.reigate.domain

import org.junit.Test

import uk.ac.reigate.domain.lookup.Gender;
import uk.ac.reigate.domain.lookup.Title;

import static org.junit.Assert.*


public class PersonTest {
    
    Title createTitle() {
        Title title = new Title()
    }
    
    Gender createGender() {
        Gender gender = new Gender()
    }
    
    Address createAddress() {
        Address address = new Address()
    }
    
    @Test
    void testMethod_ToString() {
        Person person = new Person()
        
        assertEquals(person.surname + ', ' + person.firstName, person.toString())
    }
}
