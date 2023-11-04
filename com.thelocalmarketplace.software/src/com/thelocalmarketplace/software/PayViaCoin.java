package com.thelocalmarketplace.software;

import java.math.BigDecimal;

import com.tdc.coin.*;

import java.util.Currency;


//import java.util.Scanner;



public class PayViaCoin {
	//private BigDecimal Value;
	//private Coin coin = new Coin(Value);
	private double totalAmountDue;
	private double remainingAmountDue;
	private double coin;
	
	
	
    public PayViaCoin(double totalAmountDue) {
        this.totalAmountDue = totalAmountDue;
        this.remainingAmountDue = totalAmountDue;
    }
    
    public void processCoinPayment() {
        //Scanner scanner = new Scanner(System.in);
        
        while (remainingAmountDue > 0) {
            System.out.println("Remaining amount due: " + remainingAmountDue);
            System.out.print("Insert coin value: ");
            
            if (coin <= 0) {
                System.out.println("Invalid coin value. Please insert a valid coin.");
                continue;
            }
            
            // 2. Reduce the remaining amount due by the value of the inserted coin.
            
            remainingAmountDue -= coin;
            
            // 3. Signal the Customer the updated amount due after each insertion.
            System.out.println("Amount due after insertion: " + remainingAmountDue);
        }
            
        if (remainingAmountDue < 0) {
            // 5. Dispense the change.
            double change = -remainingAmountDue;
            System.out.println("Change dispensed: " + change);
        }

        /*
        // 6. Print Receipt
        printReceipt();

      
    }

    public void printReceipt() {
        System.out.println("Receipt printed successfully.");
    }
       */
        
    }
    
    public static void main(String[] args, double Coin) {
        // Create an instance of the PayViaCoin with the total amount due.
    	PayViaCoin payViaCoin = new PayViaCoin(Coin);

        // Trigger the payment process.
    	payViaCoin.processCoinPayment();
    }
} 
