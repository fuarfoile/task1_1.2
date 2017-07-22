package com.boast.task1;

import java.util.Scanner;

/**
 * Created by Bondarenko Oleh on 22.07.2017.
 */

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        long number = in.nextLong();

        getPerfectNumbers(number);

    }

    private static void getPerfectNumbers(long maxNumber) {

        for (int p = 1; p < 31; p++) {
            long testingPrime = (2 << p) - 1;

            if (primeTest(testingPrime)) {
                long perfectNumber = testingPrime * (2 << (p - 1));
                if (perfectNumber > maxNumber) {
                    break;
                }
                System.out.println(perfectNumber);
            }
        }
    }

    private static boolean primeTest(long n){

        for(long i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
