package uk.ac.reigate.domain.admissions;

import org.junit.Test

import static org.junit.Assert.*


public class CollegeFundPaidTest {
    
    @Test
    void testMethod_ToString() {
        CollegeFundPaid collegeFundPaid = new CollegeFundPaid()
        collegeFundPaid.collegeFundPaid = 'TEST'
        
        assertEquals(collegeFundPaid.collegeFundPaid, collegeFundPaid.toString())
    }
}
