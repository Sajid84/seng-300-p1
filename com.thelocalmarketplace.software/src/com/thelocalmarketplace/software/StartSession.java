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

public class StartSession {
private boolean isInSession;
    
    public void SelfCheckoutMachine() {
        this.isInSession = false;
    }

    /**
     * Displays an initial splash screen with an indication to start.
     *
     * @return
     */
    public void displaySplashScreen() {
        if (!isInSession) {
            System.out.println("Touch Anywhere to Start");
        } else {
            System.out.println("Session already in progress...");
        }
    }

    /**
     * Triggered when the customer touches the screen.
     */
    public void touchScreen() {
        if (!isInSession) {
            isInSession = true;
            System.out.println("System ready for further customer interaction.");
        } else {
            System.out.println("Session already in progress...");
        }
    }

    /**
     * Ends the current session.
     */
    public void endSession() {
        if (isInSession) {
            isInSession = false;
            System.out.println("Session ended.");
        } else {
            System.out.println("No active session to end.");
        }
    }

    /**
     * Returns true if a session is in progress, false otherwise.
     */
    public boolean isInSession() {
        return isInSession;
    }

    public static void main(String[] args) {
        StartSession checkoutMachine = new StartSession();
        
        checkoutMachine.displaySplashScreen();
        checkoutMachine.touchScreen();
        checkoutMachine.displaySplashScreen();
        checkoutMachine.endSession();
        checkoutMachine.displaySplashScreen();
    }
}
