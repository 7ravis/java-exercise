package exercise;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
        int expResult = 544828;
        int result = Exercise.sumPrimeFibonacciNumbers(limit);
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
    
    /**
     * Test of findIndexOfFirstEquilibriumPoint method, of class Exercise
     */
    @Test
    public void testFindIndexOfFirstEquilibriumPoint() {
        int[] testCase1 = {3,5,1,8,9};
        int[] testCase2 = {4,3,1};
        Integer result1 = Exercise.findIndexOfFirstEquilibriumPoint(testCase1);
        Integer result2 = Exercise.findIndexOfFirstEquilibriumPoint(testCase2);
        assertEquals(new Integer(3), result1);
        assertNull(result2);
    }
    
    /**
     * Test of findNumbersNotInSecondList method, of class Exercise
     */
    @Test
    public void testFindNumbersNotInSecondList() {
        List<Integer> list1 = Arrays.asList(3,7,4,6,10,78);
        List<Integer> list2 = Arrays.asList(18,7,4,10);
        List<Integer> result = Exercise.findNumbersNotInSecondList(list1, list2);
        result = result.stream().sorted((a,b) -> a.compareTo(b)).collect(Collectors.toList());
        List<Integer> expResult = Arrays.asList(3,6,78);
        assertEquals(expResult, result);
        List<Integer> list3 = Arrays.asList(8,10,18);
        List<Integer> list4 = Arrays.asList(18,8,5,10,21);
        List<Integer> result2 = Exercise.findNumbersNotInSecondList(list3, list4);
        result2 = result2.stream().sorted((a,b) -> a.compareTo(b)).collect(Collectors.toList());
        List<Integer> expResult2 = new ArrayList<>();
        assertEquals(expResult2, result2);
    }
    
    /**
     * Test of translateDnaToRna method, of class Exercise
     */
    @Test
    public void testTranslateDnaToRna() {
        assertEquals("C", Exercise.translateDnaToRna("G"));
        assertEquals("G", Exercise.translateDnaToRna("c"));
        assertEquals("U", Exercise.translateDnaToRna("A"));
        assertEquals("A", Exercise.translateDnaToRna("t"));
        assertEquals("UGCACCAGAAUU", Exercise.translateDnaToRna("ACGTGGTCTTAA"));
        assertNull(Exercise.translateDnaToRna("ACXTGG"));
    }
    
    /**
     * Test of findMostFrequentInt method, of class Exercise
     */
    @Test
    public void testFindMostFrequentInt() {
        List<Integer> list1 = Arrays.asList(2, 87, 56, 87, 4, 56, 5, 56, 7);
        assertEquals(new Integer(56), Exercise.findMostFrequentInt(list1));
        List<Integer> list2 = Arrays.asList(3, 4, 4, 3, 6);
        assertNull(Exercise.findMostFrequentInt(list2));        
    }
    
    /**
     * Test of findFirstNonRepeatedCharacter method, of class Exercise
     */
    @Test
    public void testFindFirstNonRepeatedCharacter() {
    		assertEquals(new Character('a'), Exercise.findFirstNonRepeatedCharacter("hhhyyaoolll"));
    		assertEquals(new Character('b'), Exercise.findFirstNonRepeatedCharacter("hhhyyggoob"));
    		assertEquals(new Character('c'), Exercise.findFirstNonRepeatedCharacter("chhhyyoolll"));
    		assertEquals(new Character('d'), Exercise.findFirstNonRepeatedCharacter("d"));
    		assertNull(Exercise.findFirstNonRepeatedCharacter("hhhyyoolll"));
    		assertNull(Exercise.findFirstNonRepeatedCharacter(""));
    		assertNull(Exercise.findFirstNonRepeatedCharacter(null));
    }
}
