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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.*;
import static org.junit.Assert.*;
import com.thelocalmarketplace.software.PayViaCoin;

public class PayViaCoinTest {
	//NOTE: the code currently has the parameter (totalAmountDue)... there is no parameter for the value of coin inserted
	//I have documented to explain things that make no sense rn cause the code is incomplete
	
	private PayViaCoin pvc;
	
	/*
	 * The constructor should initialize totalAmountDue to the inputted parameter -> totalAmountDue
	 */
	@Test
	public void testConstructorInitializesTotalAmountDue() {
		pvc = new PayViaCoin(1);
		assertEquals(pvc.getTotalAmountDue(), 1); //getTotalAmountDue is a method i made up, use the actual get method in code
	}
	
	/*
	 * The constructor should initialize remainingAmount to the inputted parameter -> totalAmountDue
	 */
	@Test
	public void testConstructorInitializesRemainingAmountDue() {
		pvc = new PayViaCoin(1);
		assertEquals(pvc.getRemainingAmountDue(), 1); //getRemainingAmountDue is a method i made up, use the actual get method in code
	}
	
	/*
	 * Invalid coin is value < 0
	 * should print the line "Invalid coin value. Please insert a valid coin."
	 * 
	 * You should insert a coin value -1 and make sure the invalid coin String is printed
	 */
	@Test
	public void testInvalidCoinValueInserted() {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		pvc = new PayViaCoin(1);
		String expectedOutput = "Remaining amount due: 1" + System.lineSeparator() +
				"Insert coin value: " + System.lineSeparator() + //insert value -1
				"Invalid coin value. Please insert a valid coin." + System.lineSeparator() +
				"Amount due after insertion: 1" + System.lineSeparator() +
				"Remaining amount due: 1" + System.lineSeparator() +
				"Insert coin value: " + System.lineSeparator() + //insert value 1
				"Amount due after insertion: 0" + System.lineSeparator() +
				"Receipt printed successfully." + System.lineSeparator();
		assertEquals(expectedOutput, output.toString());
		System.setOut(System.out);
	}
	
	/*
	 * When the coin value inserted is less than the amount due, it should subtract coin value from the remainingAmountDue,
	 * and prompt for another coin
	 * 
	 * I pretended total amount due is 2, then you pay $1, so remaining due is $1
	 * You get prompted again and pay $1, and then receipt is printed
	 */
	@Test
	public void testCoinInsertedLessThanAmountDue() {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		pvc = new PayViaCoin(2);
		String expectedOutput = "Remaining amount due: 2" + System.lineSeparator() +
				"Insert coin value: " + System.lineSeparator() + //insert value 1
				"Amount due after insertion: 1" + System.lineSeparator() +
				"Remaining amount due: 1" + System.lineSeparator() +
				"Insert coin value: " + System.lineSeparator() + //insert value 1
				"Amount due after insertion: 0" + System.lineSeparator() +
				"Receipt printed successfully." + System.lineSeparator();
		assertEquals(expectedOutput, output.toString());
		System.setOut(System.out);
	}
	
	/*
	 * When the amount due < 0, that means change should be returned
	 * 
	 * I said total amount is $1, then you pay $2 (the code currently has no way to track the value of the coin inserted)
	 * Change dispensed is $1, then receipt is printed
	 */
	@Test
	public void testRemainingAmountDueLessThanZero() {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		pvc = new PayViaCoin(1);
		String expectedOutput = "Remaining amount due: 1" + System.lineSeparator() +
				"Insert coin value: " + System.lineSeparator() + //insert value 2
				"Amount due after insertion: -1" + System.lineSeparator() +
				"Change dispensed: 1" + System.lineSeparator() +
				"Receipt printed successfully." + System.lineSeparator();
		assertEquals(expectedOutput, output.toString());
		System.setOut(System.out);
	}
	
	/*
	 * The end of the method called makes the receipt print, with a String to indicate it has been done
	 * Mainly want to check that last string is printed.
	 * 
	 * I say total amount due is $1, we pay $1, no change is given out, and the receipt is printed indicated by string
	 */
	@Test
	public void testReceiptPrinted() {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		pvc = new PayViaCoin(1);
		String expectedOutput = "Remaining amount due: 1" + System.lineSeparator() +
				"Insert coin value: " + System.lineSeparator() + //insert value 1
				"Amount due after insertion: 0" + System.lineSeparator() +
				"Receipt printed successfully." + System.lineSeparator();
		assertEquals(expectedOutput, output.toString());
		System.setOut(System.out);
	}
	
	@Test
	public void testMain() {
		
	}
}
