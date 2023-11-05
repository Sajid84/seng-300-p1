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

	SelfCheckoutStation selfCheckoutStation = new SelfCheckoutStation();
	AddItem addItem = new AddItem(selfCheckoutStation);
	
	byte b = 2;
	Numeral two = Numeral.valueOf(b);
	Numeral[] barcodeNumbers = {two};
	Barcode barcode = new Barcode(barcodeNumbers);
	Mass mass = new Mass(5);
	BarcodeScanner scanner = new BarcodeScanner();
	BarcodedItem testItem = new BarcodedItem(barcode, mass);
	BarcodedProduct testProduct = new BarcodedProduct(barcode, "test", 1, 1);
	
	
	
	@Before
	public void setup() {
		selfCheckoutStation.scanner.plugIn(PowerGrid.instance());
		ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcode, testProduct);
	}
	
	@Test
	public void testOnAndOffListeners() {
		selfCheckoutStation.scanner.turnOn();
		selfCheckoutStation.scanner.turnOff();
	}
	
	@Test
	public void testEnableDisableListeners() {
		selfCheckoutStation.scanner.turnOn();
		selfCheckoutStation.scanner.enable();
		selfCheckoutStation.scanner.disable();
		selfCheckoutStation.scanner.turnOff();
	}
	
	@Test
	public void testScannedItemInDatabaseListener() {
		selfCheckoutStation.scanner.turnOn();
		selfCheckoutStation.scanner.enable();
		selfCheckoutStation.scanner.scan(testItem);
	}
	
	@Test
	public void testScannedItemNotInDatabaseListener() {
		
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
