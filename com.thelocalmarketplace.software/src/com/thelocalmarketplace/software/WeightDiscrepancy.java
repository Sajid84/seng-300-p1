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

public class WeightDiscrepancy {
	private double expectedWeight;
    private double actualWeight;
    private boolean isBlocked;
    
    public void SelfCheckoutMachine() {
        this.expectedWeight = 0.0;
        this.actualWeight = 0.0;
        this.isBlocked = false;
    }

    public void addItem(double itemWeight) {
        expectedWeight += itemWeight;
    }

    public void removeItem(double itemWeight) {
        expectedWeight -= itemWeight;
    }

    public void setActualWeight(double weight) {
        this.actualWeight = weight;
    }

    public boolean checkWeightDiscrepancy() {
        if (Math.abs(expectedWeight - actualWeight) > 0.1) { 
            blockMachine();
            signalCustomer();
            signalAttendant();
            return true;
        }
        return false;
    }

    public void blockMachine() {
        isBlocked = true;
    }

    public void unblockMachine() {
        isBlocked = false;
    }

    private void signalCustomer() {
        System.out.println("Please check the items in the bagging area.");
    }

    private void signalAttendant() {
        System.out.println("Attendant notified about weight discrepancy.");
    }

    public void doNotPlaceItem() {
        System.out.println("Please do not place the item in the bagging area.");
    }

    public void approveWeightDiscrepancy() {
        this.expectedWeight = this.actualWeight;
        unblockMachine();
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public double getExpectedWeight() {
        return expectedWeight;
    }

    public double getActualWeight() {
        return actualWeight;
    }

}
