package com.company;

import com.company.util.MyStringUtil;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreeBuilder {
    private Node root;
    private List<Integer> keys;
    private Preparer preparer = new Preparer();
    private NodeRetriever nodeRetriever = new NodeRetriever();
    private int[][] treeAsMatrix;

    public BinaryTreeBuilder(List<Integer> keys) {
        this.keys = keys;
        Collections.sort(keys);
    }

    public Node getRoot() {
        return root;
    }

    public void print() throws InterruptedException {
        int max = keys.get(keys.size() - 1);
        Printer.print(treeAsMatrix, MyStringUtil.countDigits(max));
    }

    public void build() {
        root = algorithm(keys);
        root.setKeysNumber(keys.size());
        treeAsMatrix = preparer.prepareTreeMatrix(keys.size());
        Node[] sequence = nodeRetriever.retrieveAsZSequence(root);
        fillMatrix(sequence, treeAsMatrix);
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

    private void fillMatrix(Node[] seq, int[][] treeMatrix) {
        Stack<Integer> seqAsStack = new Stack<>();
        for (int i = seq.length - 1; i >= 0 ; i--) {
            if (seq[i] != null) {
                seqAsStack.push(seq[i].getKey());
            }
        }
        for (int i = 0; i < treeMatrix.length; i++) {
            for (int j = 0; j < treeMatrix[0].length; j++) {
                if (treeMatrix[i][j] == 1) {
                    treeMatrix[i][j] = seqAsStack.pop();
                }
            }
        }
    }
}
