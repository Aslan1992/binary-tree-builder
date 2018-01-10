package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeBuilder {
    private Node root;
    private List<Integer> numbers;

    public BinaryTreeBuilder(List<Integer> numbers) {
        this.numbers = numbers;
        Collections.sort(numbers);
        
    }

    public void build() {
        root = algorithm(numbers);
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
            root.addNode(new Node(numbers.get(0)));
        } else {
            int index = getCenter(numbers);
            root.setKey(numbers.get(index));
            List<Integer> right = new ArrayList<>(numbers.subList(0, index));
            List<Integer> left = new ArrayList<>(numbers.subList(index + 1, numbers.size()));

            root.addNode(algorithm(right));
            root.addNode(algorithm(left));
        }
        return root;
    }

    private int getCenter(List<Integer> numbers) {
        return numbers.size() / 2;
    }
}
