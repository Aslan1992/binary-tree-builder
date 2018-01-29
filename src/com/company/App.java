package com.company;

import java.util.Arrays;
import java.util.List;

public class App {


    private static void prepareItemsForNodes(int[][] arr, int lines, int columns) {
        int i = 0;
        int j;
        int numberOfNodesAtLine = 1;
        int step;
        do {
            j = 0;
            step = columns/numberOfNodesAtLine + 1;
            while (j < columns) {
                arr[i][j] = 1;
                j += step;
            }
            numberOfNodesAtLine *= 2;
            i += 2;
        } while (i < lines);
    }

    private static void prepare2(int[][] arr, int LINES, int COLUMNS) {
        int step;
        int numberOfNodesAtLowLine = 2;
        int k;
        int i = 0;
        while (i < LINES){
            step = COLUMNS/numberOfNodesAtLowLine;
            step++;
            for (int j = 0; j < COLUMNS; j++) {
                if (arr[i][j] == 1 && i != LINES - 1) {
                    k = 1;
                    while (k <= step) {
                        arr[i][j + k] = -2;
                        k++;
                    }
                    arr[i + 1][j] = -2;
                    arr[i + 1][j + k - 1] = -2;
                }
            }
            numberOfNodesAtLowLine *= 2;
            i +=2;
        }
    }

    public static void main(String[] args) {
        List<Integer> keys = Arrays.asList(11,22,33,44,55,66,77);
        BinaryTreeBuilder binaryTreeBuilder = new BinaryTreeBuilder(keys);
        binaryTreeBuilder.build();
        System.out.println(binaryTreeBuilder.getRoot());

        BinTreePrinter printer = new BinTreePrinter(binaryTreeBuilder.getRoot());
        printer.print();

    }
}
