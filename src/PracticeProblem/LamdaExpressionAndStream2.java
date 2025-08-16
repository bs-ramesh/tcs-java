package PracticeProblem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LamdaExpressionAndStream2 {
    public static void main(String[] args) {
        problem1();
        problem2();
        problem3();
        problem4();
        problem5();
        problem6();
    }

    //    Count Strings Starting with "A" (Case-insensitive)
    public static void problem1() {
        List<String> words = Arrays.asList("Apple", "Banana", "Avocado", "Mango");

        long practice1 = words.stream()
                              .filter(a -> a.toUpperCase().startsWith("A"))
                              .count();

        System.out.println("Solution to problem 1: " + practice1);

    }

    /*You are given a list of integers.
    1 Keep only odd numbers.
    2 Sort them in ascending order.
    3 Print them as a list. */
    public static void problem2() {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 3, 1, 9);

        List<Integer> practice2 = numbers.stream()
                                         .filter(a -> a % 2 != 0)
                                         .sorted()
                                         .toList();
        System.out.println("Solution to problem 2: " + practice2);
    }

    //    Find Strings with Length Between 4 and 7
    public static void problem3() {
        List<String> words = Arrays.asList("Java", "Stream", "Lambda", "Code", "Practice");

        List<String> practice3 = words.stream()
                                      .filter(a -> a.length() >= 4 && a.length() <= 7)
                                      .toList();
        System.out.println("Solution to problem 3: " + practice3);
    }

    //    Find the maximum number using reduce.
    public static void problem4() {
        List<Integer> nums = Arrays.asList(10, 25, 32, 7, 55, 43);

        int practice4 = nums.stream()
                            .reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);

        System.out.println("Solution to problem 4 : " + practice4);

    }
    /*   You are given a list of words with some duplicates.
        1 Remove duplicates using distinct.
        2 Collect them into a list. */
    public static void problem5(){
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");

        List<String> practice5= words.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Solution to problem 5 : " + practice5);
    }

 /*   You are given a list of lists of integers.
    1 Flatten the nested lists using flatMap.
    2 Remove duplicates (distinct).
    3 Collect them into a single list. */
    public static void problem6(){
        List<List<Integer>> nestedNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(3, 4, 5),
                Arrays.asList(5, 6, 7)
        );

        List<Integer> practice7 = nestedNumbers.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println("Solution to problem 6 : " + practice7);
    }


}
