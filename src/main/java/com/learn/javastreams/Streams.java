package com.learn.javastreams;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.function.*;

@UtilityClass
public class Streams {

    Opera m = Integer::sum;

    interface Opera {
        int sum(int a, int b);
    }

    //Predicate --> a Boolean valued functional interface
    Predicate<Integer> p = a -> a > 0;

    //Function --> do work for you, functional interface
    Function<String, String> str = s -> s.substring(0, 3);
    Function<Integer, Integer> i = Function.identity();

    //Consumer -->  void method , takes but doesnt return
    Consumer<Integer> prnt = System.out::println;

    //Supplier --> void method, dont tek but returns
    Supplier<Integer> spl = () -> 10;
    //bipredicate, biconsumer, bifunction are also there

    //UnaryOperator , BinaryOperator
    UnaryOperator<Integer> unaryOperator = x -> x * 10;
    BinaryOperator<Integer> binaryOperator = (x, y) -> x + y;

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
