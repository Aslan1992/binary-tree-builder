package com.company;

public class Printer {

    private int digitsInMax;

    public void print(int[][] treeArr) throws InterruptedException {
        int digits;
        for (int i = 0; i < treeArr.length; i++) {
            for (int j = 0; j < treeArr[0].length; j++) {
                digits = getNumberOfDigits(treeArr[i][j]);
                int a = digitsInMax - digits;
                String line = createStringWithSpaces(a);
                if (treeArr[i][j] > 0) {
                    System.out.print("(" + treeArr[i][j] + line + ")");
                } else {
                    if (treeArr[i][j] == -1) {
                        System.out.print("( " + line + ")");
                    } else if (treeArr[i][j] == -2) {
                        System.out.print(" * "+ line);
                    } else {
                        System.out.print("   " + line);
                    }
                }
                //Just for beauty output
                Thread.sleep(80);
            }
            System.out.println();
        }
    }

    public void setDigitsInMax(int digitsInMax) {
        this.digitsInMax = digitsInMax;
    }

    private int getNumberOfDigits(int num) {
        String s = String.valueOf(num);
        s = s.replaceAll("-", "");
        return s.length();
    }

    private String createStringWithSpaces(int spacesQuantity) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < spacesQuantity; i++) {
            result.append(" ");
        }
        return result.toString();
    }
}
