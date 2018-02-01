package com.company;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> keys = Arrays.asList(1, 3, 5, 7, 9, 10, 13, 15, 16, 66, 68, 87, 90);
        BinaryTreeBuilder binaryTreeBuilder = new BinaryTreeBuilder(keys);
        binaryTreeBuilder.build();
        Node root = binaryTreeBuilder.getRoot();

        Integer max = keys.get(keys.size() - 1);
        int digits = String.valueOf(max).length();
        binaryTreeBuilder.print(digits);


    }

}
