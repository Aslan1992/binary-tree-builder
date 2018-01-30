package com.company;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> keys = Arrays.asList(1,2,3,5,6,7777,8,9);
        BinaryTreeBuilder binaryTreeBuilder = new BinaryTreeBuilder(keys);
        binaryTreeBuilder.build();
        Node root = binaryTreeBuilder.getRoot();

        String result = binaryTreeBuilder.print();

       System.out.println(result);

//        String str = "(999) * * * * " + "\n" +
//                     " *         * " + "\n" +
//                     "(5)        (1234)" ;
//        System.out.println(str);


    }

}
