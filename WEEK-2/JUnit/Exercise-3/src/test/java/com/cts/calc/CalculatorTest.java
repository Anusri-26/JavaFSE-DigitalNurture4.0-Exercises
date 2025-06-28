package com.cts.calc;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
	Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(4, 3));
    }
    
    @Test
    public void testAssertions() {
    	assertEquals(6, calculator.multiply(2, 3));
        assertTrue(5 > calculator.add(1, 2));
        assertFalse(5 > calculator.subtract(11, 4));
        assertNotNull(calculator);
        calculator=null;
        assertNull(calculator);
    }
}
