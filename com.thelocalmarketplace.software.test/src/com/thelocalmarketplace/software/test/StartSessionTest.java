package com.thelocalmarketplace.software.test;

import com.thelocalmarketplace.software.StartSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.OutputStream;
import java.io.PrintStream;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class StartSessionTest {

    private StartSession startSession;

    @Before
    public void setUp() {
        startSession = new StartSession();
    }

    @Test
    public void testConstructorInitializesIsInSessionToFalse() {
        StartSession startSession = new StartSession();
        assertFalse(startSession.isInSession());
    }

    @Test
    public void testConstructorSetsIsInSessionToFalse() {
        assertFalse(startSession.isInSession());
    }

    @Test
    public void testMainMethod() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        StartSession.main(null);

        String expectedOutput = "Touch Anywhere to Start" + System.lineSeparator() +
                "System ready for further customer interaction." + System.lineSeparator() +
                "Session already in progress..." + System.lineSeparator() +
                "Session ended." + System.lineSeparator() +
                "Touch Anywhere to Start" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());

        System.setOut(System.out);
    }


    @Test
    public void testTouchScreenStartsSession() {
        startSession.touchScreen();
        assertTrue(startSession.isInSession());
    }

    @Test
    public void testTouchScreenWhenAlreadyInSession() {
        startSession.touchScreen();
        startSession.touchScreen();
        assertTrue(startSession.isInSession());
    }

    @Test
    public void testEndSessionEndsActiveSession() {
        startSession.touchScreen();
        startSession.endSession();
        assertFalse(startSession.isInSession());
    }

    @Test
    public void testEndSessionWhenNotInSession() {
        startSession.endSession();
        assertFalse(startSession.isInSession());
    }

    @Test
    public void testTouchScreenStartsSessionWhenNotInSession() {
        startSession.touchScreen();
        assertTrue(startSession.isInSession());
    }

    @Test
    public void testTouchScreenDoesNotStartSessionWhenInSession() {
        startSession.touchScreen();
        startSession.touchScreen();
        assertTrue(startSession.isInSession());
    }

    @Test
    public void testEndSessionDoesNothingWhenNotInSession() {
        startSession.endSession();
        assertFalse(startSession.isInSession());
    }

    @Test
    public void testIsInSessionReturnsTrueWhenSessionIsActive() {
        startSession.touchScreen();
        assertTrue(startSession.isInSession());
    }

    @Test
    public void testIsInSessionReturnsFalseWhenSessionIsNotActive() {
        assertFalse(startSession.isInSession());
    }

    @Test
    public void testTouchScreenAfterEndingSession() {
        startSession.touchScreen();
        startSession.endSession();
        startSession.touchScreen();
        assertTrue(startSession.isInSession());
    }

    @Test
    public void testTouchScreenWhileAlreadyInSession() {
        startSession.touchScreen();
        startSession.touchScreen();
        assertTrue(startSession.isInSession());
    }

    @Test
    public void testDisplaySplashScreenWhenNotInSession() {
        // Set isInSession to false
        assertFalse(startSession.isInSession());
        startSession.displaySplashScreen();
    }

    @Test
    public void testDisplaySplashScreenWhenInSession() {
        // Set isInSession to true
        startSession.touchScreen();
        assertTrue(startSession.isInSession());
        startSession.displaySplashScreen();
    }


    @Test
    public void testIsInSessionAfterStartingAndEndingSession() {
        startSession.touchScreen();
        assertTrue(startSession.isInSession());
        startSession.endSession();
        assertFalse(startSession.isInSession());
    }

}