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

import com.thelocalmarketplace.software.WeightDiscrepancy;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.OutputStream;
import java.io.PrintStream;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
public class WeightDiscrepancyTest {

    private WeightDiscrepancy weightDiscrepancy;

    @Before
    public void setUp() {
        weightDiscrepancy = new WeightDiscrepancy();
    }

    @Test
    public void testAddItem() {
        weightDiscrepancy.addItem(0.5);
        assertEquals(0.5, weightDiscrepancy.getExpectedWeight(), 0.01);
    }

    @Test
    public void testRemoveItem() {
        weightDiscrepancy.addItem(1.0);
        weightDiscrepancy.removeItem(0.5);
        assertEquals(0.5, weightDiscrepancy.getExpectedWeight(), 0.01);
    }

    @Test
    public void testSetActualWeight() {
        weightDiscrepancy.setActualWeight(0.7);
        assertEquals(0.7, weightDiscrepancy.getActualWeight(), 0.01);
    }

    @Test
    public void testCheckWeightDiscrepancy() {
        weightDiscrepancy.addItem(1.0);
        weightDiscrepancy.setActualWeight(1.1);
        assertTrue(weightDiscrepancy.checkWeightDiscrepancy());
        assertTrue(weightDiscrepancy.isBlocked());
    }

    @Test
    public void testApproveWeightDiscrepancy() {
        weightDiscrepancy.addItem(1.0);
        weightDiscrepancy.setActualWeight(1.1);
        weightDiscrepancy.checkWeightDiscrepancy();
        weightDiscrepancy.approveWeightDiscrepancy();
        assertEquals(1.1, weightDiscrepancy.getExpectedWeight(), 0.01);
        assertFalse(weightDiscrepancy.isBlocked());
    }

    @Test
    public void testNoWeightDiscrepancy() {
        weightDiscrepancy.addItem(1.0);
        weightDiscrepancy.setActualWeight(1.0);
        assertFalse(weightDiscrepancy.checkWeightDiscrepancy());
        assertFalse(weightDiscrepancy.isBlocked());
    }

    @Test
    public void testWeightDiscrepancyWithinTolerance() {
        weightDiscrepancy.addItem(1.0);
        weightDiscrepancy.setActualWeight(1.05);
        assertFalse(weightDiscrepancy.checkWeightDiscrepancy());
        assertFalse(weightDiscrepancy.isBlocked());
    }

    @Test
    public void testUnblockMachine() {
        weightDiscrepancy.blockMachine();
        assertTrue(weightDiscrepancy.isBlocked());
        weightDiscrepancy.unblockMachine();
        assertFalse(weightDiscrepancy.isBlocked());
    }

    @Test
    public void testConstructor() {
        assertEquals(0.0, weightDiscrepancy.getExpectedWeight(), 0.01);
        assertEquals(0.0, weightDiscrepancy.getActualWeight(), 0.01);
        assertFalse(weightDiscrepancy.isBlocked());
    }

    @Test
    public void testBlockMachine() {
        weightDiscrepancy.blockMachine();
        assertTrue(weightDiscrepancy.isBlocked());
    }

/////
    @Test
    public void testAddZeroWeightItem() {
        weightDiscrepancy.addItem(0.0);
        assertEquals(0.0, weightDiscrepancy.getExpectedWeight(), 0.01);
    }

    @Test
    public void testAddNegativeWeightItem() {
        weightDiscrepancy.addItem(-0.5);
        assertEquals(-0.5, weightDiscrepancy.getExpectedWeight(), 0.01);
    }

    @Test
    public void testWeightDiscrepancyExactlyAtTolerance() {
        weightDiscrepancy.addItem(1.0);
        weightDiscrepancy.setActualWeight(1.1);
        assertTrue(weightDiscrepancy.checkWeightDiscrepancy());
        assertTrue(weightDiscrepancy.isBlocked());
    }

    @Test
    public void testApproveWeightDiscrepancyWhenAlreadyUnblocked() {
        weightDiscrepancy.addItem(1.0);
        weightDiscrepancy.setActualWeight(1.0);
        assertFalse(weightDiscrepancy.checkWeightDiscrepancy());
        assertFalse(weightDiscrepancy.isBlocked());
        weightDiscrepancy.approveWeightDiscrepancy();
        assertFalse(weightDiscrepancy.isBlocked());
    }

    @Test
    public void testDoNotPlaceItem() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        weightDiscrepancy.doNotPlaceItem();
        String expectedOutput = "Please do not place the item in the bagging area." + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
        System.setOut(System.out);
    }


}
