package com.company;

public class Printer {

    public void print(int[][] treeArr) {
        for (int i = 0; i < treeArr.length; i++) {
            for (int j = 0; j < treeArr[0].length; j++) {
                if (treeArr[i][j] > 0) {
                    System.out.print("(" + treeArr[i][j] + ")");
                } else {
                    if (treeArr[i][j] == -1) {
                        System.out.print("( )");
                    } else if (treeArr[i][j] == -2) {
                        System.out.print(" * ");
                    } else {
                        System.out.print("   ");
                    }
                }
            }
            System.out.println();
        }
    }
}
