package com.company;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int key;
    private List<Node> nodes = new ArrayList<>();

    public Node() {
    }

    public Node(int key) {
        this.key = key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", nodes=" + nodes +
                '}';
    }
}
