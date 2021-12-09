package uk.ac.reigate.domain.lookup;

import org.junit.Test

import static org.junit.Assert.*


public class CentralMonitoringTest {
    
    @Test
    void testMethod_ToString() {
        CentralMonitoring centralMonitoring = new CentralMonitoring()
        centralMonitoring.code = 'T'
        centralMonitoring.description = 'TEST'
        
        assertEquals(centralMonitoring.description, centralMonitoring.toString())
    }
}
