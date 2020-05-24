package ru.asolodkaya;

import org.junit.Test;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;
import static org.junit.Assert.assertEquals;

/**
 * Provides number of tests for problem solution
 */
public class MainTest {

    @Test(expected = IllegalArgumentException.class)
    public void calculateWaysOfDrawing0(){
        Main.calculateWaysOfDrawing(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateWaysOfDrawingNegative(){
        Main.calculateWaysOfDrawing(-4);
    }

    @Test
    public void calculateWaysOfDrawing1(){
        assertEquals(ONE, Main.calculateWaysOfDrawing(1));
    }

    @Test
    public void calculateWaysOfDrawing2(){
        assertEquals(valueOf(2), Main.calculateWaysOfDrawing(2));
    }

    @Test
    public void calculateWaysOfDrawing3(){
        assertEquals(valueOf(3), Main.calculateWaysOfDrawing(3));
    }

    @Test
    public void calculateWaysOfDrawing4(){
        assertEquals(valueOf(5), Main.calculateWaysOfDrawing(4));
    }

    @Test
    public void calculateWaysOfDrawing5(){
        assertEquals(valueOf(8), Main.calculateWaysOfDrawing(5));
    }

    @Test
    public void calculateWaysOfDrawing6(){
        assertEquals(valueOf(13), Main.calculateWaysOfDrawing(6));
    }

    @Test
    public void calculateWaysOfDrawing10(){
        assertEquals(valueOf(10946), Main.calculateWaysOfDrawing(20));
    }
}
