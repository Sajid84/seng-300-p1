/**
 * Project Iteration 1 Group Members:
 * Shaikh Sajid Mahmood	- 30182396
 * Andrew Matti		- 30182547
 * Christopher Lo	- 30113400
 * Rahul Ghosal 	- 30171782
 * Dana Al Bastami	- 30170494
 * Atique Muhammad	- 30038650
 */

package com.thelocalmarketplace.software.test;

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
