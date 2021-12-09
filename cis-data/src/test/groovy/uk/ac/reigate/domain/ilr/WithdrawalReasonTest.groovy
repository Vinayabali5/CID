package uk.ac.reigate.domain.ilr;

import org.junit.Test

import static org.junit.Assert.*

public class WithdrawalReasonTest {
    
    @Test
    void testMethod_ToString() {
        WithdrawalReason withdrawalReason = new WithdrawalReason()
        withdrawalReason.description = 'TEST'
        assertEquals(withdrawalReason.description, withdrawalReason.toString())
    }
}
