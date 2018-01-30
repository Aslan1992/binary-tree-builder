package com.company;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreeBuilder {
    private Node root;
    private List<Integer> keys;
    private Preparer preparer;
    private NodeRetriever nodeRetriever;
    private Printer printer = new Printer();
    private int[][] treeMatrix;

    public BinaryTreeBuilder(List<Integer> keys) {
        this.keys = keys;
        Collections.sort(keys);
    }

    public void build() {
        root = algorithm(keys);
        root.setKeysNumber(keys.size());
        preparer = new Preparer(keys.size());
        nodeRetriever = new NodeRetriever();
        treeMatrix = preparer.prepare();
        Node[] sequence = nodeRetriever.retrieveAsZSequence(root);

        Stack<Integer> keysStack = new Stack<>();
        putTo(sequence, keysStack);

        for (int i = 0; i < treeMatrix.length; i++) {
            for (int j = 0; j < treeMatrix[0].length; j++) {
                if (treeMatrix[i][j] == 1) {
                    treeMatrix[i][j] = keysStack.pop();
                }
            }
        }
    }



    private void putTo(Node[] seq, Stack<Integer> keys) {
        for (int i = seq.length - 1; i >= 0 ; i--) {
            if (seq[i] != null) {
                keys.push(seq[i].getKey());
            }
        }
    }

    public String print() throws InterruptedException {
        return printer.print(treeMatrix);
    }

    public Node getRoot() {
        return root;
    }

    private Node algorithm(List<Integer> numbers) {
        Node root = new Node();
        if (numbers.isEmpty()) {
            return root;
        }

        if (numbers.size() == 1) {
            root.setKey(numbers.get(0));

        } else if (numbers.size() == 2) {
            root.setKey(numbers.get(1));
            root.setLeft(new Node(numbers.get(0)));
        } else {
            int index = getCenter(numbers);
            root.setKey(numbers.get(index));
            List<Integer> left = numbers.subList(0, index);
            List<Integer> right = numbers.subList(index + 1, numbers.size());
            root.setLeft(algorithm(left));
            root.setRight(algorithm(right));
        }
        return root;
    }

    private int getCenter(List<Integer> numbers) {
        return numbers.size()/2;
    }
}
