package com.thelocalmarketplace.software;
import java.math.BigDecimal;

import com.tdc.CashOverloadException;
import com.tdc.DisabledException;
import com.tdc.Sink;
import com.tdc.coin.*;
import com.thelocalmarketplace.hardware.SelfCheckoutStation;


public abstract class PayViaCoin extends Cart implements Sink<Coin> {
	
	private BigDecimal remainingAmountDue;
	private Coin coin;
	private BigDecimal coinInserted;
	
	public PayViaCoin(SelfCheckoutStation selfCheckoutStation) {
		super(selfCheckoutStation);
	}

    public void PayViaCoin(BigDecimal cartTotal) {
        this.remainingAmountDue = cartTotal;
    }
      

    public void processCoinPayment() throws DisabledException, CashOverloadException {
    	
    	
    	while (remainingAmountDue.compareTo(BigDecimal.ZERO) > 0) {  		
    		System.out.println("Please insert coin"); 
    		
    		receive(coin);   		
    		coinInserted = coin.getValue();  
    		
    		remainingAmountDue = remainingAmountDue.subtract(coinInserted);
    		System.out.println("Remaining amount due: " + remainingAmountDue);    		
    	}
    	
    	if (remainingAmountDue.compareTo(BigDecimal.ZERO) < 0) {
            //Dispense the amount of change due
    		//Print Receipt
    		//Both methods will be implemented in later versions of the program 
        }
    	
    }

}       
