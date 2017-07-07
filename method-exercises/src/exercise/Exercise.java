package exercise;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Travis Rogers
 */
public class Exercise {
    
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
}
