package com.cts.calc;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator(); 
    }

    @After
    public void tearDown() {
        calculator = null; 
    }
    
    @Test
    public void testMultiplication() {
    	int result = calculator.multiply(4, 7);
    	assertTrue(30>result);
    }

    @Test
    public void testAddition() {
        int result = calculator.add(10, 5);
        assertEquals(15, result);
    }

    @Test
    public void testSubtraction() {
        int result = calculator.subtract(10, 5);
        assertEquals(5, result);
    }
}
