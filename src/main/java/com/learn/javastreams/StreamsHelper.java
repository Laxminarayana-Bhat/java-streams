package com.learn.javastreams;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.function.*;

@UtilityClass
public class StreamsHelper {

    Opera m = Integer::sum;

    interface Opera {
        int sum(int a, int b);
    }

    //Predicate --> a Boolean valued functional interface
    Predicate<Integer> p = a -> a > 0;
    //used in filter(...)
    //removeIf(...)
    //anyMatch(...)
    //allMatch(...)
    //noneMatch(...)
    //takeWhile(...)
    //dropWhile(...)

    //Function --> do work for you, functional interface
    Function<String, String> str = s -> s.substring(0, 3);
    Function<Integer, Integer> i = Function.identity();
    //map(...)
    //flatMap(...)
    //collect(Collectors.toMap(keyMapper, valueMapper))
    //Comparator.comparing(...)

    //Consumer -->  void method , takes but doesnt return
    Consumer<Integer> prnt = System.out::println;
    //forEach(...)
    //peek(...)
    //List.forEach(...)
    //Optional.ifPresent(...)

    //Supplier --> void method, dont take but returns
    Supplier<Integer> spl = () -> 10;
    //Common places
    //Optional.orElseGet(...)
    //Stream.generate(...)
    //Collectors.toCollection(...)
    //ThreadLocal.withInitial(...)

    //bipredicate, biconsumer, bifunction are also there

//    BiFunction<T, U, R> → two inputs, one output
//      Map.compute(...)
//      Map.merge(...)
//      Collectors.toMap(...)

//     BiConsumer<T, U> → two inputs, no return
    //When working with maps.
    //Map.forEach(...)
    //Map.replaceAll(...)


    //When input and output are the same type
    UnaryOperator<Integer> unaryOperator = x -> x * 10;
    //map(...)
    //List.replaceAll(...)

    //When two elements become one.
    BinaryOperator<Integer> binaryOperator = (x, y) -> x + y;
    //reduce(...)
    //Collectors.reducing(...)
    //Collectors.toMap(..., mergeFunction)

    //Method reference (::) -> use method without invoking it
    List<Integer> list=List.of(1,2,3,4);


    public void doOperations() {
        System.out.println(p.test(8));//true
        System.out.println(str.apply("abcd"));//abc
        System.out.println(i.apply(9879));//9879
        prnt.accept(66);//prints 66
        prnt.accept(spl.get());//10

        list.forEach((x)-> System.out.println(x));//without method reference
        list.forEach(System.out::println);//with method reference
    }



}
