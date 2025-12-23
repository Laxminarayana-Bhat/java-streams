package com.learn.javastreams.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

public class ComparableTest implements Comparable<ComparableTest> {

    private Integer id;
    private String name;

    @Override
    public int compareTo(ComparableTest o) {

        //for increasing natural order
        if (this.id < o.id) {
            return -1; // This object comes first
        } else if (this.id > o.id) {
            return 1; // The other object comes first
        } else {
            return 0; // They are equal
        }
//        return this.id.compareTo(o.id); //using compareTo
//        return this.id.compareTo(o.id); //using compare
    }
    public void check(){
        Comparator<Integer> comparator = (a, b) -> a - b;
        Thread t=new Thread(()->{
            File file=new File("asdjf");
            try {
                FileReader fr=new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            // --> drawback of lambda is it cannot throw checked excpetions
            //  FileReader fr=new FileReader(file); cannot use without try catch
        });
        Test test=new Test(()-> System.out.println("hello"));//my custom functional interface
    }
    @FunctionalInterface
    interface test{
        void nothing();
        //void error(); // error as annotation doesnt let interface have multiple abstract methods
        static int add(int a, int b){
            return a+b;
        }
    }

    class Test{
        Test(test tst){

        }
    }
    /*
How does a functional interface relate to lambda expressions at compile time?
Compile-time process:

Runnable r = () -> System.out.println("Run");

What the compiler does:

Sees a lambda expression

Finds the target type (Runnable)

Verifies it’s a functional interface

Matches lambda signature to the single abstract method

Generates bytecode using invokedynamic
     */

    //Method reference types: reference to static method(Integer::parseInt), object(Custom::name), constructor(ArrayList::new) etc.
}
