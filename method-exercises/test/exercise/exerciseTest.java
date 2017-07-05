
package exercise;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Travis Rogers
 */
public class exerciseTest {

    /**
     * Test of sumAllEvenFibonacciNumbersLessThan method, of class exercise.
     */
    @Test
    public void testSumAllEvenFibonacciNumbersLessThan() {
        int limit = 4000000;
        exercise instance = new exercise();
        int expResult = 4613732;
        int result = instance.sumAllEvenFibonacciNumbersLessThan(limit);
        assertEquals(expResult, result);
    }

    /**
     * Test of sumAllPrimeFibonacciNumbersLessThan method, of class exercise.
     */
    @Test
    public void testSumAllPrimeFibonacciNumbersLessThan() {
        int limit = 4000000;
        exercise instance = new exercise();
        int expResult = 544828;
        int result = instance.sumAllPrimeFibonacciNumbersLessThan(limit);
        assertEquals(expResult, result);
    }
    
}
