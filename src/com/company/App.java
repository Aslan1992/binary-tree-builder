package com.company;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Integer> keys = Arrays.asList(5, 9, 2, 7, 1);

        BinaryTreeBuilder binaryTreeBuilder = new BinaryTreeBuilder(keys);
        binaryTreeBuilder.build();
        System.out.println(binaryTreeBuilder.getRoot());

    }
}
