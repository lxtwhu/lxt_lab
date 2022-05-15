package com.lxt.demo;

public class CalculateTuple {
    public static void main(String[] args) {

        long n = (long) Math.pow(10,15);
        System.out.println("N:"+n);
        System.out.println("long Maxv:"+ Long.MAX_VALUE);

        long start = System.currentTimeMillis();

        long biggestA = (long) Math.cbrt(n);

        long tupleNum = 0;
        for (long a = 1; a != biggestA + 1; ++a) {
            long biggestBC = n/a;
            long biggestB = (long) Math.sqrt(biggestBC);
            for (long b = a; b !=  biggestB + 1; ++b) {
                long biggestC = biggestBC/b;
                tupleNum += biggestC - b + 1;
            }
        }

        System.out.println("tupleNums:"+tupleNum);

        long elapse = System.currentTimeMillis() - start;
        System.out.println("Time elapsed(in milliseconds):"+elapse);
        return;
    }
}
