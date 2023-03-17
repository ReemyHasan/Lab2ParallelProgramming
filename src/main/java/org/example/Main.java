package org.example;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //exercise 1


//        for (int j =0; j< 5; j++) {
//            System.out.println("/////////////////////////\nenter length of array\n/////////////////////////");
//            Scanner sc = new Scanner(System.in);
//            int c = sc.nextInt();
//            int arr[] = new int[c];
//            Random random = new Random();
//            int rand = 0;
//            for (int i = 0; i < arr.length; i++) {
//                while (true) {
//                    rand = random.nextInt(100000);
//                    if (rand != 0)
//                        break;
//                }
//                arr[i] = rand;
//                //System.out.println("element "+i+" "+arr[i]);
//            }
//            System.out.println("array Initialized successfully with random numbers");
//            System.out.println("enter number to search for");
//            int c1 = sc.nextInt();
//            SearchTask task = new SearchTask(arr, c1, arr.length, 0);
//            //////////////////Sequential Search
//            long start = System.currentTimeMillis();
//            int g = task.SeqCompute();
//            long execTime = System.currentTimeMillis() - start;
//            //////////////////////////////Parallel Search
//            long start2 = System.currentTimeMillis();
//            int g2 = task.compute();
//            long execTime2 = System.currentTimeMillis() - start2;
//            //////////////////////////////////Sequential Stream Search
//            long start3 = System.currentTimeMillis();
//            int g3 = task.SeqcomputeStream();
//            long execTime3 = System.currentTimeMillis() - start3;
//            //////////////////////////////////Parallel Stream Search
//            long start4 = System.currentTimeMillis();
//            int g4 = task.SeqcomputeStream();
//            long execTime4 = System.currentTimeMillis() - start4;
//            ///////////////output
//            System.out.println("Sequential Execution Time: " + execTime + " ms");
//            System.out.println("Count is " + g);
//            System.out.println("Parallel Execution Time: " + execTime2 + " ms");
//            System.out.println("Count is " + g2);
//            System.out.println("Sequential Stream Execution Time: " + execTime3 + " ms");
//            System.out.println("Count is " + g3);
//            System.out.println("Parallel Stream Execution Time: " + execTime4 + " ms");
//            System.out.println("Count is " + g4);
//        }
        System.out.println("exercise 3");
        // exercise 2 is in independent Project
        //exercise 3
        System.out.println("/////////////////////////\nenter number to calculate Fibonacci\n/////////////////////////");
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        Fibonacci fb = new Fibonacci(c);
        long start5 = System.currentTimeMillis();
        int g5 = fb.compute();
        long execTime5 = System.currentTimeMillis() - start5;
        System.out.println("Parallel: Fibonacci is "+ g5);
        System.out.println("execution time is "+execTime5);

        long start6 = System.currentTimeMillis();
        int g6 = fb.MemoizationCompute();
        long execTime6 = System.currentTimeMillis() - start6;
        System.out.println("Memoization: Fibonacci is "+ g6);
        System.out.println("execution time is "+execTime6);
    }
}