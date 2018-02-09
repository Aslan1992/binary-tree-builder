package com.company;

import com.company.util.MyMath;

//I know this is awful class :(
public class Preparer {
    private int LINES;
    private int COLUMNS;
    public static final int PLACE_FOR_KEY = 1;
    private static final int PLACE_FOR_BRANCH_PART = -2;


    public int[][] prepareTreeMatrix(int numberOfKeys) {
        int low = MyMath.getLow(numberOfKeys);
        int high = MyMath.getHigh(numberOfKeys);
        int hiercharchyLevel = MyMath.log(high, 2);
        LINES = 2 * hiercharchyLevel - 1;
        COLUMNS = 2 * low - 1;
        int[][] resultArr = new int[LINES][COLUMNS];
        preparePlacesForKeys(resultArr);
        preparePlacesForBranches(resultArr);

        return resultArr;
    }

    private void preparePlacesForKeys(int[][] resultArr) {
        int i = 0;
        int j;
        int numberOfNodesAtLine = 1;
        int step;
        do {
            j = 0;
            step = COLUMNS/numberOfNodesAtLine + 1;
            while (j < COLUMNS) {
                resultArr[i][j] = PLACE_FOR_KEY;
                j += step;
            }
            numberOfNodesAtLine *= 2;
            i += 2;
        } while (i < LINES);
    }

    private void preparePlacesForBranches(int[][] resultArr) {
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
                        resultArr[i][j + k] = PLACE_FOR_BRANCH_PART;
                        k++;
                    }
                    resultArr[i + 1][j] = PLACE_FOR_BRANCH_PART;
                    resultArr[i + 1][j + k - 1] = PLACE_FOR_BRANCH_PART;
                }
            }
            numberOfNodesAtLowLine *= 2;
            i +=2;
        }
    }
}
