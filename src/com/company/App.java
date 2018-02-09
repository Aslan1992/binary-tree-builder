package com.company;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) throws InterruptedException {
        //It doesn't matter sorted it or not
        List<Integer> keys = Arrays.asList(1, 3, 5, 7, 9, 10, 13, 15, 16, 66, 68, 87, 90, 93, 111, 123, 134, 155);
        BinaryTreeBuilder binaryTreeBuilder = new BinaryTreeBuilder(keys);
        binaryTreeBuilder.build();
        System.out.println();
        System.out.print("Binary tree for keys ");
        System.out.print(keys);
        System.out.println(" will be: ");
        System.out.println("-----^-----");
        binaryTreeBuilder.print();


    }

}
