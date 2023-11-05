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

import org.junit.Before;
import org.junit.Test;

import com.jjjwelectronics.Mass;
import com.jjjwelectronics.Numeral;
import com.jjjwelectronics.scanner.Barcode;
import com.jjjwelectronics.scanner.BarcodeScanner;
import com.jjjwelectronics.scanner.BarcodedItem;
import com.thelocalmarketplace.hardware.BarcodedProduct;
import com.thelocalmarketplace.hardware.SelfCheckoutStation;
import com.thelocalmarketplace.hardware.external.ProductDatabases;
import com.thelocalmarketplace.software.AddItem;

import powerutility.PowerGrid;

/**
 * 
 * @author Christopher Lo, 30113400
 *
 * JUnit Test Class for AddItem.java
 * 
 */

public class AddItemTest {

	// Initializing a Self-Checkout Station instance and linking the AddItem software with it
	SelfCheckoutStation selfCheckoutStation = new SelfCheckoutStation();
	AddItem addItem = new AddItem(selfCheckoutStation);

	// Initializing a test product with its own barcode and mass
	byte b = 2;
	Numeral two = Numeral.valueOf(b);
	Numeral[] barcodeNumbers = {two};
	Barcode barcode = new Barcode(barcodeNumbers);
	Mass mass = new Mass(5);
	BarcodeScanner scanner = new BarcodeScanner();
	BarcodedItem testItem = new BarcodedItem(barcode, mass);
	BarcodedProduct testProduct = new BarcodedProduct(barcode, "test", 1, 1);
	
	
	// Powering the Self-Checkout Station hardware and adding the test product into the database
	@Before
	public void setup() {
		selfCheckoutStation.scanner.plugIn(PowerGrid.instance());
		ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcode, testProduct); // Adding the test item into the database
	}


	// Tests the turnOn() and turnOff() listeners
	@Test
	public void testOnAndOffListeners() {
		selfCheckoutStation.scanner.turnOn();
		selfCheckoutStation.scanner.turnOff();
	}


	// Tests the enable() and disable() listeners
	@Test
	public void testEnableDisableListeners() {
		selfCheckoutStation.scanner.turnOn();
		selfCheckoutStation.scanner.enable();
		selfCheckoutStation.scanner.disable();
		selfCheckoutStation.scanner.turnOff();
	}


	// Tests the scanner listener for scanning an item that is within the database
	@Test
	public void testScannedItemInDatabaseListener() {
		selfCheckoutStation.scanner.turnOn();
		selfCheckoutStation.scanner.enable();
		selfCheckoutStation.scanner.scan(testItem);
	}


	// Tests the scanner listener for scanning an item that is not in the database
	@Test
	public void testScannedItemNotInDatabaseListener() {

		// Initializing a test product that is not in the database
		byte c = 3;
		Numeral three = Numeral.valueOf(c);
		Numeral[] barcodeNumbers = {three};
		Barcode barcode1 = new Barcode(barcodeNumbers);
		Mass mass1 = new Mass(5);
		BarcodedItem testItem2 = new BarcodedItem(barcode1, mass1);
		
		selfCheckoutStation.scanner.turnOn();
		selfCheckoutStation.scanner.enable();
		selfCheckoutStation.scanner.scan(testItem2);
	}
}
