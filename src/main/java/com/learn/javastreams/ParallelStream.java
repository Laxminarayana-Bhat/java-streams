package com.learn.javastreams;

import java.util.List;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {
        //Multithreading using streams
        List<Integer> integerList = Stream.iterate(0, x -> x + 1).limit(10000).toList();
        long before = System.currentTimeMillis();
        List<Long> longList = integerList.stream().map(ParallelStream::fact).toList();
        long after = System.currentTimeMillis();
        System.out.println("normal streams: " + (after - before) + "ms");

        before = System.currentTimeMillis();
        longList = integerList.parallelStream().map(ParallelStream::fact).toList();
        after = System.currentTimeMillis();
        System.out.println("parallel streams: " + (after - before) + "ms");
    }

    public static long fact(int n) {
        long ini = 1;
        for (int i = 2; i < n; i++) {
            ini *= i;
        }
        return ini;
    }
}
