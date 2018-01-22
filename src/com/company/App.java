package com.company;

import java.util.Arrays;
import java.util.List;

public class App {

    private static int getLengthOfNodeArr(int numOfKeys) {
        int m = numOfKeys / 2;
        int sum = 0;
        while (m >= 0) {
            sum = sum + (int) Math.pow(2, m);
            m--;
        }
        return sum;
    }

    private static Node[] getBinaryTreeAsArray(Node root) {
        int length = getLengthOfNodeArr(root.getKeysNumber());
        Node[] nodes = new Node[length];
        nodes[0] = root;

        int step = 1;
        for (int i = step - 1; i < nodes.length; i++) {
            if (nodes[i] != null && nodes[i].getLeft() != null) {
                    nodes[i + step] = nodes[i].getLeft();
                    if (nodes[i].getRight() != null) {
                        nodes[i + step + 1] = nodes[i].getRight();
                    }
            }
            step++;
        }
        return nodes;
    }

    public static void main(String[] args) {
        List<Integer> keys = Arrays.asList(1, 2, 3, 4, 5, 6);
        BinaryTreeBuilder binaryTreeBuilder = new BinaryTreeBuilder(keys);
        binaryTreeBuilder.build();
      //  System.out.println(binaryTreeBuilder.getRoot());




    }
}
