package com.learn.javastreams;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Primitive {
    public static void main(String[] args) {
        int[] ar=new int[10];
        IntStream stream = Arrays.stream(ar);
        //here its intstream not stream<int>

        //to convert we use boxing
        Stream<Integer> boxed = stream.boxed();
        System.out.println(IntStream.range(1,5).boxed().collect(Collectors.toList()));//1 to 4
        System.out.println(IntStream.rangeClosed(1,5).boxed().collect(Collectors.toList()));//1 to 5
        


    }
}
