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

    /*
      funtion to print the sequence between 0 and 1000
   */
    public static List<BigInteger> fiboSeqZeroTo() {
        List<BigInteger> seq = new ArrayList<>();

        //loop fibonacci sequence between 0 and 1000
        for (int i = 0; i <= 1000; i++) {

                seq.add(i,fibonnacci(i));
            }



        return seq;
    }


    public static List<BigInteger> printFiboIndexes(int start, int end) {

        List<BigInteger> newSeq = new ArrayList<>();    //new list to return
        List<BigInteger> fiboSeq = fiboSeqZeroTo();     //fibo list with seq from 0 to 1000

        for (BigInteger value : fiboSeq){
            if (fiboSeq.indexOf(value) >= start && fiboSeq.indexOf(value) <= end){//if index between values add
                newSeq.add(value);
            }
        }

        return newSeq;
    }
}

