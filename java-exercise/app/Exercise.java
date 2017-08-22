package app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		while (num2 < limit) {
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
		while (num2 < limit) {
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

	public static List<Integer> findNumbersNotInSecondList(List<Integer> list1, List<Integer> list2) {
		List<Integer> result = new ArrayList<>();
		if (list1 == null || list2 == null || list1.size() == 0 || list2.size() == 0) {
			return result;
		}
		for (int i = 0; i < list1.size(); i++) {
			if (!list2.contains(list1.get(i))) {
				result.add(list1.get(i));
			}
		}
		return result;
	}

	public static String translateDnaToRna(String input) {
		if (input == null) { return null; }
		input = input.replace(" ", "").toUpperCase();
		if (input.length() == 0) { return null; }
		char[] array = input.toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 'G' && array[i] != 'C' && array[i] != 'T' && array[i] != 'A') {
				return null;
			}
			switch (array[i]) {
			case 'G':
				array[i] = 'C';
				break;
			case 'C':
				array[i] = 'G';
				break;
			case 'T':
				array[i] = 'A';
				break;
			case 'A':
				array[i] = 'U';
				break;
			default:
			}
		}
		return String.copyValueOf(array);
	}

	public static Integer findMostFrequentInt(List<Integer> input) {
		if (input == null || input.size() == 0) { return null; }
		Map<Integer, MutableInt> results = new HashMap<>();
		int mostFrequentInt = Integer.MIN_VALUE;
		int maxOccurences = 0;
		boolean isTie = false;
		for (int i = 0; i < input.size(); i++) {
			if (input.get(i) == null) { continue; }
			int currentInt = input.get(i);
			if (results.containsKey(currentInt)) { results.get(currentInt).increment(); } 
			else { results.put(currentInt, new MutableInt()); }            
		}
		for (Integer key : results.keySet()) {
			int occurences = results.get(key).getValue();
			if (occurences > maxOccurences) {
				isTie = false;
				mostFrequentInt = key;
				maxOccurences = occurences;
			} else if (occurences == maxOccurences) {
				isTie = true;
			}
		}
		if (isTie == true) { return null; }
		return mostFrequentInt;
	}

	private static class MutableInt {        
		int value = 0;

		public int getValue() {
			return value;
		}
		public void increment() {
			value++;
		}
	}

	public static Character findFirstNonRepeatedCharacter(String input) {    		
		if (input == null || input.length() == 0) {
			return null;
		}
		int length = input.length();
		if (length == 1) {
			return input.charAt(0);
		}
		for (int i = 0; i < length; i++) {
			if (i == 0) {
				char myChar = input.charAt(i);
				if (myChar != input.charAt(i + 1)) {
					return myChar;
				}
			} else if (i == length - 1) {
				char myChar = input.charAt(i);
				if (myChar != input.charAt(i - 1)) {
					return myChar;
				}
			} else {
				char myChar = input.charAt(i);
				if (myChar != input.charAt(i - 1) && myChar != input.charAt(i + 1)) {
					return myChar;
				}
			}
		}
		return null;
	}

	public static String createAcronym(String input) {
		if (input == null || input.trim().length() == 0) {
			return null;
		}
		StringBuilder output = new StringBuilder();
		boolean addNextLetter = true;
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isLetter(input.charAt(i))) {
				addNextLetter = true;
			} else if (addNextLetter == true) {
				output.append(Character.toUpperCase(input.charAt(i)));
				addNextLetter = false;
			}
		}
		if (output.length() == 0) {
			return null;
		} else {
			return output.toString();
		}
	}

	public static String findLongestWord(String input) {
		if (input == null || input.trim().length() == 0) {
			return null;
		}
		StringBuilder longestWord = new StringBuilder();
		StringBuilder tempWord = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char curChar = input.charAt(i);
			if (Character.isLetter(curChar) || curChar == '-') {
				tempWord.append(curChar);
			} else {
				if (tempWord.length() > longestWord.length()) {
					longestWord.delete(0,longestWord.length());
					longestWord.append(tempWord.toString());
				}
				tempWord.delete(0, tempWord.length());
			}
		}
		if (longestWord.length() == 0) { return null; }
		return longestWord.toString();
	}

	public static Integer divideIntRoundUp(int numerator, int denominator) {
		if (denominator == 0) { return null; }
		int result = numerator / denominator;
		if (numerator % denominator == 0) {
			return result;
		} else if (result < 0) {
			return result - 1;
		} else {
			return result + 1;
		}
	}
}