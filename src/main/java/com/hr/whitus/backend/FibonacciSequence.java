package com.hr.whitus.backend;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FibonacciSequence {
    public static List<Integer> sequenceBetweenLimits(int lowerLimit, int upperLimit) {
        List<Integer> sequence = new ArrayList<>();
        int a = 0;
        int b = 1;
        while (a <= upperLimit) {
            if (a >= lowerLimit) {
                sequence.add(a);
            }
            int c = a + b;
            a = b;
            b = c;
        }
        return sequence;
    }

    public static List<Integer> sequenceFromLimitToLimit(int start, int end) {


        List<Integer> sequence = new ArrayList<>();
        int a = 0;
        int b = 1;
        while (a <= 1000) {
            if (a >= 0) {
                if (a >= start && a <= end){
                    sequence.add(a);
                }

            }
            int c = a + b;
            a = b;
            b = c;
        }
        return sequence;
    }

    public static BigInteger fibonnacci(int n) {
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(1);
        if (n == 0){
            return a;
        } else if(n == 1){
            return b;
        }
        //  fib[i] = fib[i-1] + fib[i-2];
        for (int j = 2; j <= n; j++) {
            c = a.add(b);
            a = b;
            b = c;
        }

        return (b);
    }
}

