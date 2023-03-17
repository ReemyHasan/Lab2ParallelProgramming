package org.example;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Integer> {
    final int n;
    private Map<Integer, Integer> memoize = new HashMap<Integer, Integer>();
    public Fibonacci(int n) { this.n = n; }

    public Integer MemoizationCompute() {
        if (!memoize.containsKey(n)) {
            if (n > 20) {
                if (n <= 1)
                    return n;
                Fibonacci f1 = new Fibonacci(n - 1);
                Fibonacci f2 = new Fibonacci(n - 2);
                f1.fork();
                f2.fork();
                memoize.put(n, f2.join() + f1.join());
                return memoize.get(n);
            } else {
                return computeSeq();
            }
        }
        return memoize.get(n);
    }

    public Integer MemoizationComputeSeq() {
        if (n <= 1)
            return n;
        if (!memoize.containsKey(n)) {
            Fibonacci f1 = new Fibonacci(n - 1);
            Fibonacci f2 = new Fibonacci(n - 2);
            memoize.put(n, f2.computeSeq() + f1.computeSeq());
        }
        return memoize.get(n);
    }
    public Integer compute() {

        if(n > 20) {
            if (n <= 1)
                return n;
            Fibonacci f1 = new Fibonacci(n - 1);
            f1.fork();
            Fibonacci f2 = new Fibonacci(n - 2);
            return f2.compute() + f1.join();
        }else{
            return computeSeq();
        }
    }

    public Integer computeSeq() {
        if (n <= 1)
            return n;
            Fibonacci f1 = new Fibonacci(n - 1);
            Fibonacci f2 = new Fibonacci(n - 2);
            return f2.computeSeq() + f1.computeSeq();

    }
}

