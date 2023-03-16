package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		int arr[]=new int[100000];
		Random random = new Random();
        int rand = 0;
        for (int i=0; i<arr.length;i++) {
            while (true) {
                rand = random.nextInt(100000);
                if (rand != 0)
                    break;
            }
            arr[i]=rand;
            //System.out.println("element "+i+" "+arr[i]);
        }
        System.out.println("OK");
        System.out.println("enter number to search for");
        Scanner sc= new Scanner(System.in);
        int c = sc.nextInt();
        //String str= sc.nextLine();
        SearchTask task = new SearchTask(arr,c,arr.length,0);
        //////////////////Sequential Search
        long start = System.currentTimeMillis();
        int g =task.SeqCompute();
        long execTime = System.currentTimeMillis() - start;
        System.out.println("Sequential Execution Time: " + execTime + " ms");
        System.out.println("Count is "+g);
        //////////////////////////////Parallel Search
        long start2 = System.currentTimeMillis();
        int g2 =task.compute();
        long execTime2 = System.currentTimeMillis() - start2;
        System.out.println("Parallel Execution Time: " + execTime2 + " ms");
        System.out.println("Count is "+g2);
        //////////////////////////////////Sequential Stream Search
        long start3 = System.currentTimeMillis();
        int g3 =task.SeqcomputeStream();
        long execTime3 = System.currentTimeMillis() - start3;
        System.out.println("sequential Stream Execution Time: " + execTime3 + " ms");
        System.out.println("Count is "+g3);
        //////////////////////////////////Parallel Stream Search
        long start4 = System.currentTimeMillis();
        int g4 =task.SeqcomputeStream();
        long execTime4 = System.currentTimeMillis() - start4;
        System.out.println("parallel Stream Execution Time: " + execTime4 + " ms");
        System.out.println("Count is "+g4);

    }
}