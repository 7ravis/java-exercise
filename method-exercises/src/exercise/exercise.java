/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package exercise;

/**
 *
 * @author Travis Rogers
 */
public class exercise {
    
    public int sumAllEvenFibonacciNumbersLessThan(int limit) {
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
    
    public int sumAllPrimeFibonacciNumbersLessThan(int limit) {
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
    
}
