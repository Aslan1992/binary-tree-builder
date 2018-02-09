package com.company;

import com.company.util.MyStringUtil;

public class Printer {

    public static void print(int[][] treeArr, int digitsInMax) throws InterruptedException {
        for (int i = 0; i < treeArr.length; i++) {
            for (int j = 0; j < treeArr[0].length; j++) {

                int spaces = digitsInMax - MyStringUtil.countDigits(treeArr[i][j]);
                String spaceLine = MyStringUtil.createStringWithSpaces(spaces);

                if (treeArr[i][j] > 0) {
                    System.out.print("(" + treeArr[i][j] + spaceLine + ")");
                } else {
                    if (treeArr[i][j] == -1) {
                        System.out.print("( " + spaceLine + ")");
                    } else if (treeArr[i][j] == -2) {
                        System.out.print(" * "+ spaceLine);
                    } else {
                        System.out.print("   " + spaceLine);
                    }
                }
                //Just for beauty output
                Thread.sleep(40);
            }
            System.out.println();
        }
    }
}
