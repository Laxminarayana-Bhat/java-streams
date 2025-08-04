package com.learn.javastreams;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootApplication
public class JavaStreamsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JavaStreamsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String sentence = "abc def abcd";
        Map<String, Long> stringIntegerMap = Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        List<String> stringList = List.of("hello", "hi");
        //key as string, val as len
        Map<String, Integer> map = stringList.stream().collect(Collectors.toMap(x -> x, String::length));
        //same with merging function in map
        stringList = List.of("hi", "hi");
        map = stringList.stream().collect(Collectors.toMap(key -> key, val -> 1, (x, y) -> x + y));//if we dont write this map will thr duplicate key exception
//        map = stringList.stream().collect(Collectors.toMap(key -> key, val -> 1, Integer::sum));

    }

}
