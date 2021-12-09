package uk.ac.reigate.domain.academic;

import org.junit.Test

import static org.junit.Assert.*

public class ExternalResultsArchiveTest {
    
    /**
     * Helper function to create a dummy student
     * 
     * @return a dummy student
     */
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    @Test
    void testMethod_ToString() {
        ExternalResultsArchive externalResultsArchive = new ExternalResultsArchive()
        Student student = createStudent()
        
        assertEquals(externalResultsArchive.student, externalResultsArchive.toString())
    }
}
