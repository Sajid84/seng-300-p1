package com.thelocalmarketplace.software;

import java.math.BigDecimal;

import org.junit.*;
import static org.junit.Assert.*;

import com.thelocalmarketplace.hardware.SelfCheckoutStation;
import com.thelocalmarketplace.software.PayViaCoin;

public class PayViaCoinTest {
	
	private SelfCheckoutStation selfCheckoutStation;
	private PayViaCoin payViaCoin;

    @Before
    public void setUp() {
    	payViaCoin = new PayViaCoin(selfCheckoutStation);
    }
    
    @Test
    public void testSetAmountDue() {
        BigDecimal cartTotal = new BigDecimal("50.00");
        payViaCoin.setAmountDue(cartTotal);
        assertEquals(cartTotal, payViaCoin.setAmountDue(cartTotal));
    }
    
    @Test
    public void testDispenseChangePaymentFinalized() {
        boolean check = payViaCoin.dispenseChange();
        assertTrue(check);
    }

    @Test
    public void testDispenseChangePaymentNotFinalized() {
        boolean result = payViaCoin.PaymentFinalized();
        assertFalse(result);
    }
 

}
