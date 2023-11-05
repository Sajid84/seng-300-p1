package com.thelocalmarketplace.software.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.jjjwelectronics.scanner.BarcodedItem;
import com.thelocalmarketplace.hardware.SelfCheckoutStation;
import com.thelocalmarketplace.software.Cart;

import ca.ucalgary.seng300.simulation.InvalidArgumentSimulationException;
import ca.ucalgary.seng300.simulation.NullPointerSimulationException;

/**
 * 
 * @author Christopher Lo, 30113400
 *
 * JUnit Test Class for Cart.java
 * 
 */

public class CartTest {

	SelfCheckoutStation selfCheckoutStation;
	Cart cart = new Cart(selfCheckoutStation);
	
	BarcodedItem testItem;

	@Test
	public void testGetSelfCheckoutStation() {
		SelfCheckoutStation testSelfCheckoutStation = cart.getSelfCheckoutStation();
		assertEquals(selfCheckoutStation, testSelfCheckoutStation);
	}
	
	
	@Test
	public void testAddToCart() {
		cart.addToCart(testItem);
	}
	
	
	@Test
	public void testUpdateNumberOfItems() {
		cart.updateNumberOfItems(2);
		
		int items = cart.getNumberOfItems();
		int expectedItems = 2;
		assertEquals(expectedItems, items);
	}
	
	
	@Test
	public void testGetEmptyCartContents() {
		
		ArrayList<BarcodedItem> listOfItems = new ArrayList<BarcodedItem>();
		ArrayList<BarcodedItem> items = cart.getCartContents();
		assertEquals(listOfItems, items);
	}
	
	@Test
	public void testGetCartContents() {
		
		ArrayList<BarcodedItem> listOfItems = new ArrayList<BarcodedItem>();
		listOfItems.add(testItem);
		
		cart.addToCart(testItem);
		ArrayList<BarcodedItem> items = cart.getCartContents();
		assertEquals(listOfItems, items);
	}
}
