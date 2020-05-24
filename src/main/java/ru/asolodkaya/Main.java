package ru.asolodkaya;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

public class Main {

    public static void main(String[] args) {
        if(args.length != 1){
            printHelp();
            return;
        }
        try {
            int ballCount = Integer.parseInt(args[0]);
            if(ballCount < 1){
                System.out.printf("Please use positive numbers for ball count, \"%d\" is not valid number.%n", ballCount);
                printHelp();
                return;
            }
            BigInteger waysOfDrawing = calculateWaysOfDrawing(ballCount);
            System.out.printf("You can draw %d balls in %d different ways.%n", ballCount, waysOfDrawing);
        }catch(NumberFormatException e){
            System.out.printf("Unable to parse number from argument \"%s\".%n", args[0]);
            printHelp();
            return;
        }
    }

    /**
     * Calculation is based on formula ways(n) = ways(n-1) + ways(n-2).
     *
     * The proof for this formula can be found combining basic formulas:
     * (1) P(x, y) = (x+y)! / (x! * y!) - permutation with repetitions
     * (2) P(x, y) = P(x - 1, y) + P(x, y - 1) - simple property of permutation with repetitions
     * (3) ways(n) = P(n, 0) + P(n-2, 1) + P(n-4, 2) + ... + P(0, [n/2]) - number of draws, [n/2] denotes quotient
     *
     *
     * @param ballCount - number of balls in the bag
     * @throws IllegalArgumentException in the case number of balls is less than 1
     * @return number of possible draws for this balls count
     */
    protected static BigInteger calculateWaysOfDrawing(int ballCount){
        if(ballCount < 1){
            throw new IllegalArgumentException("Ball count should be positive.");
        }

        BigInteger ways2 = ZERO;
        BigInteger ways1 = ZERO;

        for (int i = 0; i < ballCount; i++) {
            if (i == 0) {
                ways1 = ONE;
                ways2 = ZERO;
            } else {
                BigInteger ways = ways1.add(ways2);
                ways2 = ways1;
                ways1 = ways;
            }
        }
        return ways1.add(ways2);
    }

    private static void printHelp() {
        System.out.printf("Please use program in following way: %n");
        System.out.printf("    java ru.asolodkaya.Main [number], where [number] is ball count more than 0.%n");
        System.out.printf("For example:%n");
        System.out.printf("    java ru.asolodkaya.Main 10%n");
        System.out.printf("    java ru.asolodkaya.Main 3%n");
    }

}