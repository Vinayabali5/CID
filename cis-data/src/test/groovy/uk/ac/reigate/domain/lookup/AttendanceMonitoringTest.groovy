package uk.ac.reigate.domain.lookup;

import org.junit.Test

import static org.junit.Assert.*


public class AttendanceMonitoringTest {
    
    @Test
    void testMethod_ToString() {
        AttendanceMonitoring attendanceMonitoring = new AttendanceMonitoring()
        attendanceMonitoring.code = 'T'
        attendanceMonitoring.description = 'TEST'
        
        assertEquals(attendanceMonitoring.description, attendanceMonitoring.toString())
    }
}
