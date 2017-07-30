package exercise;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Travis Rogers
 */
public class Exercise {
    
    //method takes a LocalDateTime and returns the smallest angle between the hour hand and the minute hand of an analog clock representation of that time
    public static BigDecimal getClockHandDegreeDifference(LocalTime time) {
        if (time == null) {
            return null;
        }
        BigDecimal minuteHandDegrees = new BigDecimal(time.getMinute()).multiply(new BigDecimal("6"));
        BigDecimal partialHourHandDegrees = minuteHandDegrees.divide(new BigDecimal("12"), 2, RoundingMode.HALF_UP);
        BigDecimal hourHandDegrees = (new BigDecimal(time.getHour()).multiply(new BigDecimal("30"))).add(partialHourHandDegrees);
        BigDecimal degreeDifference = (hourHandDegrees.subtract(minuteHandDegrees)).abs();
        return degreeDifference;
    }
    
    //method returns the sum of all even Fibonacci numbers, terminating after a Fibonacci number is greater than or equal to the limit argument
    public static int sumEvenFibonacciNumbers(int limit) {
        if (limit <= 1) {
            return 0;
        }
        int sum = 0;
        int num1 = 0;
        int num2 = 1;
        for (int i = 0; num2 < limit; i++) {
            int fibNum = num1 + num2;
            if (fibNum % 2 == 0) {
                sum += fibNum;
            }
            num1 = num2;
            num2 = fibNum;
        }
        return sum;
    }
    
    //method returns the sum of all prime Fibonacci numbers, terminating after a Fibonacci number is greater than or equal to the limit argument
    public static int sumPrimeFibonacciNumbers(int limit) {
        if (limit <= 1) {
            return 0;
        }
        int sum = 0;
        int num1 = 0;
        int num2 = 1;
        for (int i = 0; num2 < limit; i++) {
            int fibNum = num1 + num2;
            int primeSum = 0;
            for (int j = 1; j < fibNum; j++) {
                if (fibNum % j == 0) {
                    primeSum += j;
                }
            }
            if (primeSum == 1) {
                sum += fibNum;
            }
            num1 = num2;
            num2 = fibNum;
        }
        return sum;
    }
    
    //method checks if two string arguments are anagrams
    public static boolean isAnagram(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        str1 = str1.replace(" ", "");
        str2 = str2.replace(" ", "");
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for (char c : array1) {
            if (map1.containsKey(c)) {
                map1.put(c, map1.get(c) + 1);
            } else {
                map1.put(c, 1);
            }
        }
        for (char c : array2) {
            if (map2.containsKey(c)) {
                map2.put(c, map2.get(c) + 1);
            } else {
                map2.put(c, 1);
            }
        }
        return map1.equals(map2);
    }
    
    public static boolean isPalindrome(String str1) {
        if (str1 == null || str1.trim().length() == 0) {
            return false;
        }
        str1 = str1.replace(" ", "");
        String str2 = "";
        for (int i = str1.length() - 1; i >= 0; i--) {
            str2 += str1.charAt(i);
        }
        return str1.equalsIgnoreCase(str2);
    }
    
    public static Integer findIndexOfFirstEquilibriumPoint(int[] intArray) {
        if (intArray == null || intArray.length <= 2) {
            return null;
        }
        int bottomSum = intArray[0];
        int topSum = intArray[2];
        for (int i = 3; i < intArray.length; i++) {
            topSum += intArray[i];
        }
        for (int i = 1; i < intArray.length - 1; i++) {
            if (bottomSum == topSum) {
                return i;
            }
            bottomSum += intArray[i];
            topSum -= intArray[i + 1];
        }
        return null;
    }
}
