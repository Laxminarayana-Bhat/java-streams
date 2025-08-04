package com.learn.javastreams;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    //Collectors is a Utility class
    public static void main(String[] args) {
        List<Integer> integerList = List.of(2, 2, 5, 3, 4, 4, 4, 5, 5, 5);

        //to list
        integerList = integerList.stream().filter(x -> x > 1).collect(Collectors.toList());

        //to set
        Set<Integer> set = integerList.stream().collect(Collectors.toSet());
//        Set<Integer> set = new HashSet<>(integerList); directly add the collection


        //Collecting to a specific Collection
        ArrayDeque<Integer> arrayDeque = integerList.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));
//        ArrayDeque<Integer> arrayDeque =  directly construct using constructor

        //Collectors joining() with delimiter option
        String s = integerList.stream().distinct().sorted().map(String::valueOf).collect(Collectors.joining(", "));
//        s = integerList.stream().collect(Collectors.toSet()).stream().map(String::valueOf).collect(Collectors.joining(", "));//convert to set then stream it and do operations
        System.out.println(s);

        //Summarization of data (sum,min,max,average,count)
        IntSummaryStatistics temp = integerList.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println(temp.getMax());
        System.out.println(temp.getMin());
        System.out.println(temp.getAverage());
        System.out.println(temp.getSum());
        System.out.println(temp.getCount());

        //Calculate avg
        Double avg = integerList.stream().collect(Collectors.averagingInt(x -> x));

        //For count
        Long count = integerList.stream().collect(Collectors.counting());

        //  Grouping elements grouping by
        List<String> stringList = List.of("abc", "def", "abcd", "bagh");
        System.out.println(stringList.stream().collect(Collectors.groupingBy(String::length)));//{3=[abc, def], 4=[abcd, bagh]}
        System.out.println(stringList.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(", "))));
        System.out.println(stringList.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())));


        Map<Integer, List<String>> map = stringList.stream()
                .collect(Collectors
                        .groupingBy(String::length, () -> new HashMap<>(), Collectors.toList()));//directly convert it ot map
//        Map<Integer,List<String>> map=        stringList.stream().collect(Collectors.groupingBy(String::length, HashMap::new,Collectors.toList()));


        //Partitioning elements - partition to 2 groups based on the predicate
        System.out.println(stringList.stream().collect(Collectors.partitioningBy(x -> x.length() > 3)));//2 groups boolean,string list

        //Mapping and collecting
        stringList = stringList.stream().collect(Collectors.mapping(x -> x.toLowerCase(), Collectors.toList()));

        
    }
}
