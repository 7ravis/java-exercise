package exercise;

import java.math.BigDecimal;
import java.time.LocalTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Travis Rogers
 */
public class exerciseTest {
    
    /**
     * Test of getClockHandDegreeDifference method, of class Exercise.
     */
    @Test
    public void testGetClockHandDegreeDifference() {
        BigDecimal expResult = new BigDecimal("157.50");
        BigDecimal result = Exercise.getClockHandDegreeDifference(LocalTime.of(3,45));
        assertEquals("3:45 argument", expResult, result);
        expResult = null;
        result = Exercise.getClockHandDegreeDifference(null);
        assertEquals("null argument", expResult, result);
        
    }

    /**
     * Test of sumEvenFibonacciNumbers method, of class Exercise.
     */
    @Test
    public void testSumEvenFibonacciNumbers() {
        int limit = 4000000;
        int expResult = 4613732;
        int result = Exercise.sumEvenFibonacciNumbers(limit);
        assertEquals("limit 4,000,000", expResult, result);
        limit = -10;
        expResult = 0;
        result = Exercise.sumEvenFibonacciNumbers(limit);
        assertEquals("limit -10", expResult, result);
        limit = 2;
        expResult = 2;
        result = Exercise.sumEvenFibonacciNumbers(limit);
        assertEquals("limit 2", expResult, result);
    }

    /**
     * Test of sumPrimeFibonacciNumbers method, of class Exercise.
     */
    @Test
    public void testSumPrimeFibonacciNumbers() {
        int limit = 4000000;
        Exercise instance = new Exercise();
        int expResult = 544828;
        int result = instance.sumPrimeFibonacciNumbers(limit);
        assertEquals("limit 4,000,000", expResult, result);
        limit = -10;
        expResult = 0;
        result = Exercise.sumPrimeFibonacciNumbers(limit);
        assertEquals("limit -10", expResult, result);
        limit = 2;
        expResult = 2;
        result = Exercise.sumPrimeFibonacciNumbers(limit);
        assertEquals("limit 2", expResult, result);
    }
    
    /**
     * Test of isAnagram method, of class Exercise.
     */
    @Test
    public void testIsAnagram() {
        assertTrue("aabc & baca", Exercise.isAnagram("aabc", "baca"));
        assertFalse("aabac & babca", Exercise.isAnagram("aabac", "babca"));
        assertFalse("aaa & aaaa", Exercise.isAnagram("aaa", "aaaa"));
        assertFalse("aaa & null", Exercise.isAnagram("aaa", null));        
    }
    
    /**
     * Test of isPalindrome method, of class Exercise.
     */
    @Test
    public void testIsPalindrome() {
        assertTrue("racecar", Exercise.isPalindrome("racecar"));
        assertFalse("raceccar", Exercise.isPalindrome("raceccar"));
        assertTrue("A santa at nasa", Exercise.isPalindrome("A santa at nasa "));
        assertFalse("null", Exercise.isPalindrome(null));
    }
}
