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

import com.jjjwelectronics.scanner.Barcode;
import com.jjjwelectronics.AbstractDevice;
import com.jjjwelectronics.IDevice;
import com.jjjwelectronics.scanner.BarcodeScanner;
import com.thelocalmarketplace.hardware.BarcodedProduct;
import com.thelocalmarketplace.hardware.SelfCheckoutStation;
import com.jjjwelectronics.IDeviceListener;
import com.jjjwelectronics.Mass;
import com.jjjwelectronics.scanner.BarcodeScannerListener;
import com.thelocalmarketplace.hardware.external.ProductDatabases;
import com.jjjwelectronics.scanner.BarcodedItem;
import com.jjjwelectronics.scanner.IBarcodeScanner;

import java.math.BigDecimal;

public class AddItem extends Cart{
	private Mass mass;
	private BarcodedItem barcodedItem;
	private BarcodeScannerListener listener;
	

	public AddItem(SelfCheckoutStation sc) {
		super(sc);
		listener = new BarcodeScannerListener() {
		
			@Override
			public void aDeviceHasBeenEnabled(IDevice<? extends IDeviceListener> device) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void aDeviceHasBeenDisabled(IDevice<? extends IDeviceListener> device) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void aDeviceHasBeenTurnedOn(IDevice<? extends IDeviceListener> device) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void aDeviceHasBeenTurnedOff(IDevice<? extends IDeviceListener> device) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void aBarcodeHasBeenScanned(IBarcodeScanner barcodeScanner, Barcode barcode) {
				if (ProductDatabases.BARCODED_PRODUCT_DATABASE.containsKey(barcode)) {
					BarcodedProduct product = ProductDatabases.BARCODED_PRODUCT_DATABASE.get(barcode);
					BarcodedItem item = new BarcodedItem(barcode, mass);
					
					addToCart(barcodedItem);
					
					selfCheckoutStation.scanner.disable();
					
				}
				
			}
		};
		
		selfCheckoutStation.scanner.register(listener);
	}

}
