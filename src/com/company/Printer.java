package com.company;

public class Printer {
    private StringBuilder result = new StringBuilder();

    public String print(int[][] treeArr) throws InterruptedException {
        for (int i = 0; i < treeArr.length; i++) {
            for (int j = 0; j < treeArr[0].length; j++) {
                if (treeArr[i][j] > 0) {
                    //System.out.print("(" + treeArr[i][j] + ")");
                    result.append("(" + treeArr[i][j] + ")");
                } else {
                    if (treeArr[i][j] == -1) {
                        //System.out.print("( )");
                        result.append("( )");
                    } else if (treeArr[i][j] == -2) {
                        //System.out.print(" * ");
                        result.append(" * ");
                    } else {
//                        System.out.print("   ");
                        result.append("   ");
                    }
                }
                //Thread.sleep(200);
            }
//            System.out.println();
            result.append("\n");
        }
        return result.toString();
    }
}
