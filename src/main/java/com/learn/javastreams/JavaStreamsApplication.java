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
//        Streams.doOperations();
    }
}
