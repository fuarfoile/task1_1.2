/*
 * Main.java 22/07/2017
 *
 * Created by Bondarenko Oleh
 */


package com.boast.task1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Enter max value to search: ");

        try (Scanner in = new Scanner(System.in)) {
            long maxNumber = in.nextLong();
            PerfectNumbers.printTo(maxNumber);
        } catch (InputMismatchException e){
            System.out.println("Invalid input");
        }
    }
}

class PerfectNumbers{
    public static void printTo(long maxNumber) {
        boolean findFlag = false;

        for (int p = 1; p < 31; p++) {
            long candidateForPrime = (2 << p) - 1;

            if (primeTest(candidateForPrime)) {
                long perfectNumber = candidateForPrime * (2 << (p - 1));
                if (perfectNumber > maxNumber) {
                    if (!findFlag) {
                        System.out.println("Perfect numbers less than entered value does not exist");
                    }
                    break;
                }
                findFlag = true;
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
