package com.learn.javastreams.collections;

import java.util.Collections;

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
}
