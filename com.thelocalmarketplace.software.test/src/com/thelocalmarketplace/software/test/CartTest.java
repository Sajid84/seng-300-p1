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


	// Initialize an instance of a Self-Checkout Station and linking it with a new instance of a Cart
	SelfCheckoutStation selfCheckoutStation;
	Cart cart = new Cart(selfCheckoutStation);
	
	BarcodedItem testItem;

	// Checking if the SelfCheckoutStation correspond with what was initialized
	@Test
	public void testGetSelfCheckoutStation() {
		SelfCheckoutStation testSelfCheckoutStation = cart.getSelfCheckoutStation();
		assertEquals(selfCheckoutStation, testSelfCheckoutStation);
	}
	
	// Adding a type barcodedItem (null) into the cart
	@Test
	public void testAddToCart() {
		cart.addToCart(testItem);
	}
	
	// Updating number of items in cart to 2
	@Test
	public void testUpdateNumberOfItems() {
		cart.updateNumberOfItems(2);
		
		int items = cart.getNumberOfItems();
		int expectedItems = 2;
		assertEquals(expectedItems, items);
	}
	
	// Checking contents of a cart when empty
	@Test
	public void testGetEmptyCartContents() {
		
		ArrayList<BarcodedItem> listOfItems = new ArrayList<BarcodedItem>();
		ArrayList<BarcodedItem> items = cart.getCartContents();
		assertEquals(listOfItems, items);
	}

	// Checking contents of a cart with items
	@Test
	public void testGetCartContents() {
		
		ArrayList<BarcodedItem> listOfItems = new ArrayList<BarcodedItem>();
		listOfItems.add(testItem);
		
		cart.addToCart(testItem);
		ArrayList<BarcodedItem> items = cart.getCartContents();
		assertEquals(listOfItems, items);
	}
}
