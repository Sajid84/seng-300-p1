/**
 * Project Iteration 1 Group Members:
 * Shaikh Sajid Mahmood	- 30182396
 * Andrew Matti		- 30182547
 * Christopher Lo	- 30113400
 * Rahul Ghosal 	- 30171782
 * Dana Al Bastami	- 30170494
 * Atique Muhammad	- 30038650
 */

package com.thelocalmarketplace.software;
import java.math.BigDecimal;

import com.tdc.CashOverloadException;
import com.tdc.DisabledException;
import com.tdc.Sink;
import com.tdc.coin.*;
import com.thelocalmarketplace.hardware.SelfCheckoutStation;


public class PayViaCoin extends Cart implements Sink<Coin> {
	
	private BigDecimal remainingAmountDue;
	private BigDecimal coinInserted;
	private Coin coin;
	
	public boolean paymentFinalized;
	
	public PayViaCoin(SelfCheckoutStation selfCheckoutStation) {
		super(selfCheckoutStation);
	}

	//sets the initial amount that is due by the customer 
    public BigDecimal setAmountDue(BigDecimal cartTotal) {
        this.remainingAmountDue = cartTotal;
        return remainingAmountDue;
    }
    
    public boolean PaymentFinalized() {
    	this.paymentFinalized = false;

    	return paymentFinalized;
    	
    }
    
      
    /**
	 * Processes the payment from the customer with coins only
	 * After each insertion, calculates the amount remaining and presents the updated amount due
	 * 
	 * @throws DisabledException
	 *             If the coin slot is currently disabled and cannot accept coins
	 *              
	 * @throws CashOverloadException
	 *             If the coin slot is currently full and there is no space 
	 *             to accept coins 
	 */
    public void processCoinPayment() throws DisabledException, CashOverloadException {
    	   	
    	
    	while (remainingAmountDue.compareTo(BigDecimal.ZERO) > 0) {  		
    		System.out.println("Please insert coin"); 
    		
    		receive(coin);   		
    		coinInserted = coin.getValue();  
    		
    		//Reduce the remaining amount due by the value of the inserted coin
    		remainingAmountDue = remainingAmountDue.subtract(coinInserted);		
    		
    		//Present to the Customer the updated amount due
    		System.out.println("Remaining amount due: " + remainingAmountDue);    		
    	}	
    	
    }
    
    public boolean dispenseChange() {
    	
    	if (remainingAmountDue.compareTo(BigDecimal.ZERO) < 0) {
            //Dispense the amount of change due
    		//Print Receipt
    		//Both methods will be implemented in later versions of the program 
        }
    	
    	this.paymentFinalized = true;
    	
    	return paymentFinalized;
    		  	
    }


	@Override
	public void receive(Coin coin) throws CashOverloadException, DisabledException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasSpace() {
		// TODO Auto-generated method stub
		return false;
	}
	
}       
