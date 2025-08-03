package com.learn.javastreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {

        //ways to create a stream
        //1. From Collections
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6);
        long cnt = integerList.stream().filter(n -> n % 2 == 0).count();

        //2. From primitive arrays
        String[] prim = {"a"};
        Stream<String> primStream = Arrays.stream(prim);

        //3.Using Stream.of
        Stream<Integer> integerStream = Stream.of(1, 2, 3);

        //4. infinite streams using iterate or generate
        Stream<Integer> integerStream1 = Stream.generate(() -> 1);
        Stream<Integer> integerStream2 = Stream.iterate(0, x -> x + 1);
        System.out.println(cnt);
    }
}
