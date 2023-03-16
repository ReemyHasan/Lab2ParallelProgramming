package org.example;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class SearchTask extends RecursiveTask<Integer> {
    int arr[];
    int searchElement;
    int lo,hi;

    public SearchTask(int[] arr, int searchElement,int high,int low) {
        this.arr = arr;
        this.searchElement = searchElement;
        this.hi = high;
        this.lo = low;
    }
    protected Integer SeqCompute(){

        int Count=0;
        for(int i=lo; i<hi;i++){
            if(arr[i]==searchElement)
                Count++;
        }

        return Count;
    }
    @Override
    protected Integer compute() {
        long start = System.currentTimeMillis();
        if (hi - lo > 1_000_000) {
            int mid = (lo + hi) / 2;
            SearchTask left = new SearchTask(arr, searchElement, mid, lo);
            SearchTask right = new SearchTask(arr, searchElement, hi, mid + 1);
            left.fork();
            right.fork();
            int res = left.join() + right.join();
            return res;
        } else {
            return SeqCompute();
        }
    }

    protected int SeqcomputeStream() {
        return (int) Arrays.stream(arr).asLongStream().sequential()
                .filter(number -> number == searchElement)
                .count();
    }
    protected int ParallelcomputeStream() {
        return (int) Arrays.stream(arr).asLongStream().parallel()
                .filter(number -> number == searchElement)
                .count();
    }
}
