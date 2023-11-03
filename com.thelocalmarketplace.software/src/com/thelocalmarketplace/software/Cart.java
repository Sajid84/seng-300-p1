package com.thelocalmarketplace.software;

import com.thelocalmarketplace.hardware.BarcodedProduct;
import com.thelocalmarketplace.hardware.SelfCheckoutStation;
import com.jjjwelectronics.scanner.BarcodedItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;

public class Cart {
	public ArrayList<BarcodedItem> cart = new ArrayList<BarcodedItem>();
	BigDecimal cartTotal = new BigDecimal(0.0);
	int numberOfItems = 0;
	public SelfCheckoutStation selfCheckoutStation;
	
	public Cart(SelfCheckoutStation selfCheckoutStation) {this.selfCheckoutStation = selfCheckoutStation;}
	
	public SelfCheckoutStation getSelfCheckoutStation() {return selfCheckoutStation;}
	
	public void addToCart(BarcodedItem barcodedItem) {
		this.cart.add(barcodedItem);
		//this.cartTotal = cartTotal.add(barcodedItem.getMass());
		this.numberOfItems += 1;
	}
	
	public void updateNumberOfItems(int item) {
		this.numberOfItems += item;
	}
	
	public int getNumberOfItems() {
		return numberOfItems;
	}
	
	public ArrayList<BarcodedItem> getCartContents() { return cart; }

}
