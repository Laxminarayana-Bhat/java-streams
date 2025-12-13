package com.learn.javastreams.collections;

import java.io.Serializable;
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
        ListIterator<Integer> integerListIterator = list.listIterator();
        if (integerListIterator.hasNext()){
            System.out.println(integerListIterator.next());
        }
        Serializable serializable = integerListIterator.hasNext() ? integerListIterator.next() : 0;

        Iterator<Integer> iterator=list1.iterator();
        int i = iterator.hasNext() ? iterator.next() : 0;
        //Iterator can only move forward and remove elements.
        //ListIterator can move forward & backward and can add, set, remove elements.

        //Iterator<Integer> it = list.iterator(); --------- Fail fast iterator
        //list.add(3);          // modification
        //it.next();            // Exception here

        //Iterator = read + remove only
        //add() needs position + ordering
        //That’s why it exists in "ListIterator", not Iterator
        // For fail safe iteration use concurrent / copy on arraylist etc.

        int[] arr=new int[10];
        List<Integer> list5 = List.of(arr[0]);//immutable
        List<Integer> list6 = new ArrayList<>(Arrays.asList(arr[0]));//mutable

        List<String> original = new ArrayList<>(List.of("A", "B"));
        List<String> unmodifiableList = Collections.unmodifiableList(original);
        // This line throws UnsupportedOperationException - modifying immutable list
         unmodifiableList.add("C");

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

        //hashCode + equals: Used to detect duplicates in sets
        //SortedSet: Maintains sorted order
        //NavigableSet: Adds navigation methods
        //Null in Set: Depends on implementation, trees doesn't allow null, hashset allows one

        Set<MyEnum> set = new HashSet<>();
        set.add(new MyEnum(1));
        set.add(new MyEnum(1));   // added again! thats why we need !!!! overriding of hashcode
//refer below custom class




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
        Map<Integer, String> m3 = new TreeMap<>();                   // sorted (Red-Black tree), no null keys can have null values
        Map<Integer, String> m4 = new Hashtable<>();                 // thread-safe, legacy
        Map<Integer, String> m5 = new ConcurrentHashMap<>();         // thread-safe, high-performance hashing
        Map<Integer, String> m6 = new ConcurrentSkipListMap<>();     // thread-safe, sorted map
        Map<Integer, String> m7 = new WeakHashMap<>();               // keys eligible for GC (weak references), ex: if Object is key and has some value, if object is set to null it will be removed here
        Map<Integer, String> m8 = new IdentityHashMap<>();           // key comparison using == instead of equals()
        Map<Integer, String> m9 = new EnumMap<>(MyEnum.class);       // fast map for enum keys
//!!! map is separate interface, as its having k,v pairs. rest of the collection framework work values are single valued
        //those methods like .keyset, .values would not fit the collections framework, soo

        //Role of Generics:List<Integer>, List<String> etc.
        //Generics provide compile-time type safety and eliminate runtime ClassCastException in collections.
        //Why Generics Help:
        //They reduce bugs, remove casting, and make code safer and more readable.
        //Raw Collections:List list=new ArrayList<>();
        //Raw collections are non-generic collections that lack type safety and can cause runtime errors.
        //Homogeneous vs Heterogeneous:List<Integer> vs List<Object>
        //Homogeneous collections store a single type and are type-safe, while heterogeneous collections store multiple types and are not type-safe.

        //internal design
        //Node[] table   ← array (buckets)
        //  |
        //  ├─ index 0 → null
        //  ├─ index 1 → Node(key,value) → Node → Node   (LinkedList)
        //  ├─ index 2 → TreeNode(...)                   (Tree)
        class Node<K,V> {
            int hash;
            K key;
            V value;
            Node<K,V> next;
        }
        list2.removeIf(a->a%3==0);//takes predicate

        //Why String is immutable
        //1. Keys in HashMap/HashSet – hashCode must stay constant (e.g., map.put("key",1))
        //2. String pool / memory sharing – literals can be shared safely (e.g., String s1="hello"; String s2="hello")
        //3. Security – prevent modification of sensitive data (e.g., String url="jdbc:mysql://localhost/db")
        //4. Thread safety – safe across threads (e.g., String msg="hello")
        //5. Predictable / simpler behavior – original string never changes (e.g., s="abc"; s.concat("d"))
    }

    static class MyEnum {
        Integer id;
        MyEnum(Integer ele){
            this.id=ele;
        }

        @Override
        public boolean equals(Object o) {
            return ((MyEnum)o).id == this.id;
        }//makes sure uniqness

        @Override
        public int hashCode() {
            return id;
        }

        class Child extends MyEnum {
            Child(Integer ele) {
                super(ele);
            }

//            @Override    here we get compile time error as method doesnt exist but we want to override
            void shoow() {}   // ❌ compile-time error
        }
        //Without @Override → no error, method just becomes a new method.



        //Standard collections → fast, not thread-safe
        //
        //ConcurrentHashMap → fine-grained locking, high concurrency
        //
        //Blocking collections → thread coordination (producer–consumer)
        //
        //WeakHashMap → GC-friendly, memory-sensitive
        //
        //IdentityHashMap → == instead of equals()
        //
        //Synchronized wrappers → iteration needs manual locking


        //| Concept      | Real-world analogy                                      |
        //| ------------ | ------------------------------------------------------- |
        //| Serializable | Saving a game and loading later                         |
        //| WeakHashMap  | Sticky note on a file that disappears when file is gone |
    }
}
