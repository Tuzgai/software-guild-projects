package com.sg.warmups;

/**
 *
 * @author Stuart
 */
public class Fibonacci {

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fib(n - 2) + fib(n - 1);
    }

    public static boolean isPrime(int n) {
        // I promise 1 is not prime even if that feels crazy
        if(n == 0 || n == 1) {
            return false;
        }
        
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 0;
        int i = 0;
        int sum = 0;

        while (n < 4000000) {
            n = fib(i);
            if (n % 2 == 0) {
                sum += n;
            }
            i++;
        }

        // Undo the last result where n > 4000000
        if (n % 2 == 0) {
            sum -= n;
        }

        System.out.println("The sum of the even fibonacci numbers < 4 million is: " + sum);

        i = 0;
        n = 0;
        sum = 0;
        while (n < 4000000) {
            n = fib(i);
            if (isPrime(n)) {
                sum += n;
            }
            i++;
        }

        // Undo the last result where n > 4000000
        if (isPrime(n)) {
            sum -= n;
        }

        System.out.println("The sum of the prime fibonacci numbers < 4 million is: " + sum);
    }
}
