package com.learn.javastreams.collections;

import org.springframework.scheduling.config.DelayedTask;

import java.util.*;
import java.util.concurrent.*;

public class CollectionFramework {
    //Collection - interface in iterable (all ds and methods like size(),add() etc.)
    //Collections - utility class that has methods like binarySearch(), sort() etc.

    //Mainly List,Set,Queue,Map
    public static void main(String[] args) {

        // ----- List Implementations -----

        List<Integer> list = new ArrayList<>();               // dynamic array, fast read, not thread-safe
        List<Integer> list1 = new LinkedList<>();              // doubly linked list, fast insert/delete, slow access
        List<Integer> list2 = new Vector<>();                  // synchronized ArrayList (thread-safe, legacy)
        List<Integer> list3 = new Stack<>();                   // thread-safe LIFO stack (legacy, extends Vector)
        List<Integer> list4 = new CopyOnWriteArrayList<>();    // thread-safe, best for read-heavy operations

//------------ Copy-On-Write Strategy ------------
//When a write operation happens (add, set, remove):
//It creates a new copy of the underlying array
//Makes modifications on the new array
//Sets the new array as the internal reference
//Old array is untouched → used by readers
//Write operations are done by copying the data, so no reader is affected
//Internally uses a ReentrantLock only for writes

        // ----- Set Implementations -----

        Set<Integer> set1 = new HashSet<>();                  // no order, fast, uses hashing
        Set<Integer> set2 = new LinkedHashSet<>();            // maintains insertion order
        Set<Integer> set3 = new TreeSet<>();                  // sorted (Red-Black tree), no nulls
        Set<Integer> set4 = new CopyOnWriteArraySet<>();      // thread-safe, internally uses CopyOnWrite mechanism
        Set<Integer> set5 = new ConcurrentSkipListSet<>();    // thread-safe, sorted, scalable concurrency

        // ----- Queue Implementations -----

        Queue<Integer> q1 = new LinkedList<>();               // FIFO queue + deque, not thread-safe
        Queue<Integer> q2 = new PriorityQueue<>();            // min-heap priority queue
        Queue<Integer> q3 = new ArrayDeque<>();               // fast queue/stack, no capacity limit
        Queue<Integer> q4 = new ConcurrentLinkedQueue<>();    // thread-safe, lock-free, high performance
        Queue<Integer> q5 = new ArrayBlockingQueue<>(100);     // bounded, thread-safe blocking queue
        Queue<Integer> q6 = new LinkedBlockingQueue<>();      // optionally bounded, thread-safe blocking queue
        Queue<Integer> q7 = new PriorityBlockingQueue<>();    // thread-safe priority queue
        Queue<Delayed> q8 = new DelayQueue<>();             // elements released after given delay
        Queue<Integer> q9 = new SynchronousQueue<>();         // handoff queue, no storage

//ArrayBlockingQueue is a bounded blocking queue backed by a fixed-size array.
//✔ Why It’s Thread-Safe
//It uses:
//a single ReentrantLock to protect its internal array
//two Condition variables:
//notEmpty → signals consumer threads
//notFull → signals producer threads
//Operations:
//put(E e) (producer)
//If queue is full → thread waits on notFull
//When space is available → lock acquired → element inserted
//take() (consumer):
//If queue is empty → waits on notEmpty
//When element appears → lock acquired → element removed
//✔ Internally
//final Object[] items;
//int takeIndex;  // index to remove
//int putIndex;   // index to insert
//int count;      // number of elements



        // ----- Deque Implementations -----

        Deque<Integer> d1 = new ArrayDeque<>();               // fastest deque, stack+queue
        Deque<Integer> d2 = new LinkedList<>();               // doubly linked list
        Deque<Integer> d3 = new ConcurrentLinkedDeque<>();    // thread-safe, lock-free deque

        // ----- Map Implementations -----

        Map<Integer, String> m1 = new HashMap<>();                   // fast, hashing based, not thread-safe
        Map<Integer, String> m2 = new LinkedHashMap<>(10,0.8f,true);    //lru  // maintains insertion order
        Map<Integer, String> m3 = new TreeMap<>();                   // sorted (Red-Black tree), no null keys
        Map<Integer, String> m4 = new Hashtable<>();                 // thread-safe, legacy
        Map<Integer, String> m5 = new ConcurrentHashMap<>();         // thread-safe, high-performance hashing
        Map<Integer, String> m6 = new ConcurrentSkipListMap<>();     // thread-safe, sorted map
        Map<Integer, String> m7 = new WeakHashMap<>();               // keys eligible for GC (weak references)
        Map<Integer, String> m8 = new IdentityHashMap<>();           // key comparison using == instead of equals()
        Map<Integer, String> m9 = new EnumMap<>(MyEnum.class);       // fast map for enum keys

    }

    static class MyEnum {
        Integer key1;

    }
}
