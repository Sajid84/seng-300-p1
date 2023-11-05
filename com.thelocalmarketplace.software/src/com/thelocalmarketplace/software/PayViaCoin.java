package com.thelocalmarketplace.software;
import java.math.BigDecimal;

import com.tdc.CashOverloadException;
import com.tdc.DisabledException;
import com.tdc.Sink;
import com.tdc.coin.*;
import com.thelocalmarketplace.hardware.SelfCheckoutStation;


public abstract class PayViaCoin extends Cart implements Sink<Coin> {
	
	private BigDecimal remainingAmountDue;
	private BigDecimal coinInserted;
	private Coin coin;
	
	public PayViaCoin(SelfCheckoutStation selfCheckoutStation) {
		super(selfCheckoutStation);
	}

	//sets the initial amount that is due by the customer 
    public void setAmountDue(BigDecimal cartTotal) {
        this.remainingAmountDue = cartTotal;
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
    	
    	if (remainingAmountDue.compareTo(BigDecimal.ZERO) < 0) {
            	//Dispense the amount of change due
    		//Print Receipt
    		//Both methods will be implemented in later versions of the program 
        }
    	
    }

}       
