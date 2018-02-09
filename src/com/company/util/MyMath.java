package com.company.util;

public class MyMath {

    //Calculate range for 'number' --> [2^k .. 'number' .. 2^k+1]
    public static String calcRange(int number) {
        int numAtPowerOfTwo = 1;
        while(number >= numAtPowerOfTwo) {
            numAtPowerOfTwo *= 2;
            if(numAtPowerOfTwo > number) {
                int low = numAtPowerOfTwo / 2;
                int high = numAtPowerOfTwo;
                return low + "-" + high;
            }
        }
        return "0-0";
    }

    public static int getLow(int num) {
        String range = calcRange(num);
        return Integer.parseInt(range.split("-")[0]);
    }

    public static int getHigh(int num) {
        String range = calcRange(num);
        return Integer.parseInt(range.split("-")[1]);
    }

    // LOGaX = b - power of 'a'
    public static int log(int x, int a) {
        double result = Math.log(x) / Math.log(a);
        return (int) result;
    }
}
