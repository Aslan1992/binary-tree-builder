package com.company;

import java.util.Collections;
import java.util.List;

public class BinaryTreeBuilder {
    private Node root;
    private List<Integer> keys;

    public BinaryTreeBuilder(List<Integer> keys) {
        this.keys = keys;
        Collections.sort(keys);
    }

    public void build() {
        root = algorithm(keys);
        root.setKeysNumber(keys.size());
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
