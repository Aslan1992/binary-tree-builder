package com.company;

public class Preparer {
    private int numberOfKeys;
    private int LINES;
    private int COLUMNS;
    private static final int TREE_LINKS = -2;

    public Preparer(int numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }

    public int[][] prepare() {
        int low = MyMath.getLow(numberOfKeys);
        int high = MyMath.getHigh(numberOfKeys);
        
        int hiercharchyLevel = MyMath.log(high, 2);
        
        LINES = 2 * hiercharchyLevel - 1;
        COLUMNS = 2 * low - 1;
        
        int[][] resultArr = new int[LINES][COLUMNS];
        
        prepare1(resultArr);
        prepare2(resultArr);

        return resultArr;
    }

    private void prepare1(int[][] resultArr) {
        int i = 0;
        int j;
        int numberOfNodesAtLine = 1;
        int step;
        do {
            j = 0;
            step = COLUMNS/numberOfNodesAtLine + 1;
            while (j < COLUMNS) {
                resultArr[i][j] = 1;
                j += step;
            }
            numberOfNodesAtLine *= 2;
            i += 2;
        } while (i < LINES);
    }

    private void prepare2(int[][] resultArr) {
        int step;
        int numberOfNodesAtLowLine = 2;
        int k;
        int i = 0;
        while (i < LINES){
            step = COLUMNS/numberOfNodesAtLowLine;
            step++;
            for (int j = 0; j < COLUMNS; j++) {
                if (resultArr[i][j] == 1 && i != LINES - 1) {
                    k = 1;
                    while (k <= step) {
                        resultArr[i][j + k] = TREE_LINKS;
                        k++;
                    }
                    resultArr[i + 1][j] = TREE_LINKS;
                    resultArr[i + 1][j + k - 1] = TREE_LINKS;
                }
            }
            numberOfNodesAtLowLine *= 2;
            i +=2;
        }
    }
}
