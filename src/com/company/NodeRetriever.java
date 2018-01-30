package com.company;

public class NodeRetriever {
    public static final int NODE_WHICH_MUST_BE_EMPTY = -1;

    public Node[] retrieveAsZSequence(Node root) {
        int length = calcNumberOfReservingCells(root.getKeysNumber());
        Node[] nodes = new Node[length];
        nodes[0] = root;
        int step = 1;
        for (int i = step - 1; i < length; i++) {
            if (nodes[i] != null && nodes[i].getKey() != NODE_WHICH_MUST_BE_EMPTY) {
                if (nodes[i].getLeft() != null) {
                    nodes[i + step] = nodes[i].getLeft();
                    if (nodes[i].getRight() != null) {
                        nodes[i + step + 1] = nodes[i].getRight();
                    } else {
                        nodes[i + step + 1] = new Node(NODE_WHICH_MUST_BE_EMPTY);
                    }
                } else {
                    if (i + step < length - 1) {
                        nodes[i + step] = new Node(NODE_WHICH_MUST_BE_EMPTY);
                        nodes[i + step + 1] = new Node(NODE_WHICH_MUST_BE_EMPTY);
                    }
                }
            }
            step++;
        }
        return nodes;
    }

    private int calcNumberOfReservingCells(int numOfKeys) {
        return MyMath.getHigh(numOfKeys);
    }
}
