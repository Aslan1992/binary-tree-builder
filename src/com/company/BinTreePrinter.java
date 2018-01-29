package com.company;

public class BinTreePrinter {
    private Node root;
    private Node[] nodes;
    private int[][] tree;
    public static final int INT_TO_ENCODE_EMPTY_NODE = -1;
    public static final int INT_TO_ENCODE_TREE_BRANCH = -2;

    private int LINES;
    private int COLUMNS;

    public BinTreePrinter(Node root) {
        this.root = root;

        String range = MathUtil.calcRange(root.getKeysNumber());

        System.out.println(range);
        int low = Integer.parseInt(range.split("-")[0]);
        int high = Integer.parseInt(range.split("-")[1]);

        int levels = (int) MathUtil.log(high, 2);
        int lowNodes = low;

        LINES = 2 * levels - 1;
        COLUMNS = 2 * lowNodes - 1;

        System.out.println(LINES);
        System.out.println(COLUMNS);

        tree = new int[LINES][COLUMNS];

        prepareItemsForNodes();
        prepare2();
    }


    private void prepareItemsForNodes() {
        int i = 0;
        int j;
        int numberOfNodesAtLine = 1;
        int step;
        do {
            j = 0;
            step = COLUMNS/numberOfNodesAtLine + 1;
            while (j < COLUMNS) {
                tree[i][j] = 1;
                j += step;
            }
            numberOfNodesAtLine *= 2;
            i += 2;
        } while (i < LINES);
    }

    private void prepare2() {
        int step;
        int numberOfNodesAtLowLine = 2;
        int k;
        int i = 0;
        while (i < LINES){
            step = COLUMNS/numberOfNodesAtLowLine;
            step++;
            for (int j = 0; j < COLUMNS; j++) {
                if (tree[i][j] == 1 && i != LINES - 1) {
                    k = 1;
                    while (k <= step) {
                        tree[i][j + k] = INT_TO_ENCODE_TREE_BRANCH;
                        k++;
                    }
                    tree[i + 1][j] = INT_TO_ENCODE_TREE_BRANCH;
                    tree[i + 1][j + k - 1] = INT_TO_ENCODE_TREE_BRANCH;
                }
            }
            numberOfNodesAtLowLine *= 2;
            i +=2;
        }
    }



    public void print() {
        for (int i = 0; i < LINES; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (tree[i][j] == -2) {
                    System.out.print("*  ");
                } else {
                    System.out.print(tree[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }





    private Node[] getBinaryTreeAsArray() {
        int length = calcLengthForNodeArray(root.getKeysNumber());
        Node[] nodes = new Node[length];
        nodes[0] = root;
        int step = 1;
        for (int i = step - 1; i < length; i++) {
            if (nodes[i] != null && nodes[i].getKey() != INT_TO_ENCODE_EMPTY_NODE) {
                if (nodes[i].getLeft() != null) {
                    nodes[i + step] = nodes[i].getLeft();
                    if (nodes[i].getRight() != null) {
                        nodes[i + step + 1] = nodes[i].getRight();
                    } else {
                        nodes[i + step + 1] = new Node(INT_TO_ENCODE_EMPTY_NODE);
                    }
                } else {
                    if (i + step < length - 1) {
                        nodes[i + step] = new Node(INT_TO_ENCODE_EMPTY_NODE);
                        nodes[i + step + 1] = new Node(INT_TO_ENCODE_EMPTY_NODE);
                    }
                }
            }
            step++;
        }
        return nodes;
    }


    private int calcLengthForNodeArray(int numOfKeys) {
        int m = numOfKeys / 2;
        int sum = 0;
        while (m >= 0) {
            sum = sum + (int) Math.pow(2, m);
            m--;
        }
        return sum;
    }
}
