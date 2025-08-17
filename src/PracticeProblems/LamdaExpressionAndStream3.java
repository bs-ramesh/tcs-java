package PracticeProblems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LamdaExpressionAndStream3 {
    public static void main(String[] args) {
        problem1();
        problem2();
        problem3();
    }

    //given list of numbers skip first 3 and add only 4 numbers to list
    public static void problem1() {
        List<Integer> nums = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);

        List<Integer> practice1 = nums.stream()
                                      .skip(3)
                                      .limit(4)
                                      .collect(Collectors.toList());

        System.out.println("output to problem 1 : " + practice1);
    }

    //Partition the list into two groups → even and odd numbers.
    //Use Collectors.partitioningBy.
    public static void problem2() {
        List<Integer> numbers = Arrays.asList(5, 12, 8, 21, 33, 14, 7);

        Map<Boolean, List<Integer>> practice2 = numbers.stream()
                                                       .collect(Collectors.partitioningBy(a -> a % 2 == 0));

        System.out.println("output to problem 2 : " + practice2);
    }

//    Find the average of all numbers greater than 15 using streams.
    public static void problem3() {
        List<Integer> nums = Arrays.asList(5, 10, 15, 20, 25, 30, 35, 40);

        double practice3 = nums.stream()
                               .filter(a -> a > 15)
                               .collect(Collectors.averagingInt(a -> a));
        System.out.println("output to problem 2 : " + practice3);

    }
}