package uk.ac.reigate.domain.academic;

import org.junit.Test

import uk.ac.reigate.domain.Staff;

import static org.junit.Assert.*


public class DepartmentTest {
    
    Faculty createFaculty() {
        Faculty faculty = new Faculty()
    }
    
    Staff createHod() {
        Staff hod = new Staff()
    }
    
    Staff createHod2() {
        Staff hod2 = new Staff()
    }
    
    @Test
    void testMethod_ToString() {
        Department department = new Department()
        department.description = 'TEST'
        
        assertEquals(department.description, department.toString())
    }
}
