package com.learn.javastreams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOps {
    public static void main(String[] args) {
        // Intermediate ops transforms a stream into another stream
        // They are lazy, and until any terminal operation is invoked, they wont execute

        List<String> names = List.of("arpit", "bala");//start
        //filter
        Stream<String> stringStream = names.stream().filter(s -> s.startsWith("a"));//intermediate
        long cnt = stringStream.count();//terminal

        //map
        List<String> list = names.stream().map(String::toUpperCase).toList();

        //sorted
        list = list.stream().sorted((a, b) -> b.length() - a.length()).toList();//we can give comparator also to the sort

        //distinct
        list = list.stream().distinct().toList();

        //limit
        list = list.stream().limit(10).toList();
        System.out.println(Stream.iterate(0, x -> x + 1).limit(50).toList());

        //skip
        System.out.println(Stream.iterate(0, x -> x + 1).skip(10).limit(100).toList());//skips first 10 entries

        //peek
        //Returns a new stream with the same elements, but performs the action (like printing or logging) on each element as it passes through.
        list = list.stream().filter(x -> x.length() > 10).peek(System.out::println).toList();

        //toArray()
        Object[] arr = Stream.of(1, 2, 3).toArray();

        //min/max
        System.out.println(Stream.of(1, 2, 3, 4).max(Comparator.reverseOrder()));//prints 1 as - reverse order - (a,b)-> b-a
        System.out.println(Stream.of(1, 2, 3, 4).min(Comparator.reverseOrder()));//prints 1 as reverse order

        //flatmap
        //flatMap() is an intermediate operation in the Stream API.
        //It is used to flatten nested structures (e.g., List<List<T>>) into a single stream of elements.
        //It maps each element to a stream, then flattens all resulting streams into one.

        //map()	- One-to-one	- Stream of objects
        //flatMap() - 	One-to-many (Stream)	- Flattened stream of objects
        List<List<Integer>> listofList = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(3, 6, 8));
        System.out.println(listofList.stream().flatMap(lst -> lst.stream()).collect(Collectors.toList()));
        System.out.println(listofList.stream().flatMap(Collection::stream).collect(Collectors.toList()));

        list = List.of("Hello how", "are you", " right now ");
        System.out.println(list.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toUpperCase)
                .toList());//used arrays stream as it returns String[]


    }


}
