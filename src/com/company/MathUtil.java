package com.company;

public class MathUtil {

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

    // LOGaX = b - power of 'a'
    public static double log(int x, int a) {
        return Math.log(x) / Math.log(a);
    }
}
