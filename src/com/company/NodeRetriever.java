package com.company;

public class NodeRetriever {
    public static final int NODE_WHICH_DOES_NOT_EXIST = -1;

    public Node[] retrieveAsZSequence(Node root) {
        int length = calcLengthOfArray(root.getKeysNumber());
        Node[] nodes = new Node[length];
        nodes[0] = root;
        int step = 1;
        for (int i = step - 1; i < length; i++) {
            if (nodes[i] != null && nodes[i].getKey() != NODE_WHICH_DOES_NOT_EXIST) {
                if (nodes[i].getLeft() != null) {
                    nodes[i + step] = nodes[i].getLeft();
                    if (nodes[i].getRight() != null) {
                        nodes[i + step + 1] = nodes[i].getRight();
                    } else {
                        nodes[i + step + 1] = new Node(NODE_WHICH_DOES_NOT_EXIST);
                    }
                } else {
                    if (i + step < length - 1) {
                        nodes[i + step] = new Node(NODE_WHICH_DOES_NOT_EXIST);
                        nodes[i + step + 1] = new Node(NODE_WHICH_DOES_NOT_EXIST);
                    }
                }
            }
            step++;
        }
        return nodes;
    }


    private int calcLengthOfArray(int numOfKeys) {
        int m = numOfKeys / 2;
        int sum = 0;
        while (m >= 0) {
            sum = sum + (int) Math.pow(2, m);
            m--;
        }
        return sum;
    }
}
