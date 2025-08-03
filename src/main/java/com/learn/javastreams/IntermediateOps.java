package com.learn.javastreams;

import java.util.List;
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
    }


}
