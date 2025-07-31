package com.learn.javastreams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice {

    public void doNothing() {
        //find even numbers
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list = list.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());

        //sum of all elements
        int[] arr = new int[0];
        Arrays.stream(arr).sum();
        Integer sum = list.stream().mapToInt(Integer::intValue).sum();

        //first non repeated char in string
        String input = "sjdkf";
        Optional<Character> charr = input.chars()                                                // Convert the String to an IntStream of Unicode code points
                .mapToObj(c -> (char) c)                                // Cast each int to a Character object
                .collect(Collectors.groupingBy(                         // Group characters by their identity
                        Function.identity(),                                // Key = the character itself
                        LinkedHashMap::new,                                 // Use LinkedHashMap to preserve the order of appearance
                        Collectors.counting()                               // Value = how many times each character appears
                ))
                .entrySet().stream()                                    // Turn the map entries into a stream
                .filter(entry -> entry.getValue() == 1)                 // Keep only entries with count = 1 (non-repeated)
                .map(Map.Entry::getKey)                                 // Extract the character (key) from each entry
                .findFirst();                                           // Return the first one (preserving insertion order)
        //Find Duplicate Elements in a List
        Set<Integer> duplicates = list.stream()                                             // Convert list to a Stream
                .collect(Collectors.groupingBy(                       // Group by each number
                        Function.identity(),                              // Key = the number itself
                        Collectors.counting()                             // Value = how many times it appears
                ))
                .entrySet().stream()                                  // Convert map entries to a Stream
                .filter(entry -> entry.getValue() > 1)                // Keep only numbers that appear more than once
                .map(Map.Entry::getKey)                               // Extract the duplicate number (key)
                .collect(Collectors.toSet());                         // Collect them into a Set (no duplicates in result)

        //convert list of string to uppercase
        List<String> words = Arrays.asList("abcd", "def");
        words = words.stream().map(String::toUpperCase).collect(Collectors.toList());
    }
}
