package uk.ac.reigate.domain.lookup;

import org.junit.Test

import static org.junit.Assert.*


public class PunctualityMonitoringTest {
    
    @Test
    void testMethod_ToString() {
        PunctualityMonitoring punctualityMonitoring = new PunctualityMonitoring()
        punctualityMonitoring.code = 'T'
        punctualityMonitoring.description = 'TEST'
        
        assertEquals(punctualityMonitoring.description, punctualityMonitoring.toString())
    }
}
