package com.company.util;

public class MyStringUtil {

    public static int countDigits(int num) {
        String result = String.valueOf(num);
        result = result.replaceAll("-", "");
        return result.length();
    }

    public static String createStringWithSpaces(int spacesQuantity) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < spacesQuantity; i++) {
            result.append(" ");
        }
        return result.toString();
    }
}
