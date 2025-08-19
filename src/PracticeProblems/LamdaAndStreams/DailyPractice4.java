package PracticeProblems.LamdaAndStreams;

import java.util.*;
import java.util.stream.Collectors;

public class DailyPractice4 {
    public static void main(String[] args) {
        problem1();
        problem2();
        problem3();
        problem4();

    }

    //    Given a list of integers, find the second-highest number using streams.
    public static void problem1() {
        List<Integer> numbers = Arrays.asList(12, 45, 67, 23, 89, 67, 89, 34);

        int secHighest = numbers.stream()
                                .sorted(Comparator.reverseOrder())
                                .skip(1)
                                .findFirst().orElseThrow(() -> new NoSuchElementException("no elements"));

        System.out.println("problem 1 output : " + secHighest);
    }


    //    Given a list of strings, group them by their length using Collectors.groupingBy.
    public static void problem2() {
        List<String> words = Arrays.asList("java", "stream", "api", "lambda", "code", "function");

        Map<Integer, List<String>> groups = words.stream()
                                                 .collect(Collectors.groupingBy(String::length));
        System.out.println(groups);
        groups.forEach((a, b) -> System.out.println(a + " " + b));
    }

    //    You are given a list of sentences. Write a Java Stream program to find the most frequent word across all sentences.
    public static void problem3() {
        List<String> sentences = Arrays.asList(
                "java stream api",
                "stream api makes coding easy",
                "java lambda stream"
        );

        String max = sentences.stream()
                              .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                              .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                              .entrySet().stream()
                              .max(Map.Entry.comparingByValue())
                              .map(Map.Entry::getKey)
                              .orElse(null);

        System.out.println("problem 3 output : " + max);

    }

    //    You are given a list of integers. Write a Java Stream program to find the third-highest distinct number in the list.
    public static void problem4() {
        List<Integer> numbers = Arrays.asList(5, 12, 7, 20, 20, 15, 8, 30, 30);

        int highestNum = numbers.stream()
                                .distinct()
                                .sorted()
                                .skip(2)
                                .findFirst()
                                .orElseThrow(()-> new NoSuchElementException("not found"));

        System.out.println("problem 4 output : " + highestNum);


    }
}
