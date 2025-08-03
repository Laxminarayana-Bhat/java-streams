package com.learn.javastreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        //collect
        list = list.stream().skip(1).collect(Collectors.toList());

        //foreach
        list.stream().forEach(System.out::println);

        //reduce - combines elements to produce single result
        Optional<Integer> opt = list.stream().reduce((x, y) -> x + y);//here we are taking 2 values and making it as 1 value, reduce basically
        Integer s = opt.isPresent() ? opt.get() : 0;

        //anyMath allmatch nonematch
        boolean var = list.stream().anyMatch(x -> x % 2 == 0);

        //findfirst findany
        System.out.println(list.stream().findFirst());
        System.out.println(list.stream().findAny());

        //Ex: return if len > 3
        List<String> names = List.of("Anna", "Me", "Rekha");
        names = names.stream().filter(x -> x.length() > 3).toList();

        //Ex: square and sort
        list = list.stream().map(x -> x * x).sorted().toList();

        //Ex: Summing values
        System.out.println(list.stream().reduce(Integer::sum));

        //Ex: counting occurrance of chars
        String st = "jdlkjf";
        System.out.println(st.chars().filter(x -> x == 'l').count());

        //stateful vs stateless
        // stateless - Should know more than 1 elements. ex: sort, sum
        // stateful - will know 1 by one element

        //Lazy evaluation - until we ran the terminal operation to stream, it wont stop
        List<Integer> lazy = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = lazy.stream().filter(
                x -> {
                    System.out.println("applying lazy");
                    return x % 2 == 0;
                });

        System.out.println(" before terminal op");
        lazy = stream.toList();
        System.out.println(" after terminal op");
        System.out.println(lazy);


    }
}
