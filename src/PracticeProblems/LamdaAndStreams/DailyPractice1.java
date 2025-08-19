package PracticeProblems.LamdaAndStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class DailyPractice1 {

    public static void main(String[] args) {
        problem1();
        problem2();
        problem3();
        problem4();
        problem5();
    }

    //    Write a program using Java Streams + Lambda expressions to print only the even numbers.
    public static void problem1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> practice1 = numbers.stream()
                                         .filter(a -> a % 2 == 0)
                                         .toList();

        System.out.println("Solution to problem 1: " + practice1);
    }

    /*  You are given a list of names.
     1 Convert each name to uppercase.
     2 Keep only the names that have length greater than 5.
     3 Print them in a single line separated by commas. */
    public static void problem2() {
        List<String> names = Arrays.asList("Ramesh", "Bharath", "Raj", "Suresh", "Anil", "Srinivas");

        String practice2 = names.stream()
                                .filter(a -> a.length() > 5)
                                .map(a -> a.toUpperCase())
                                .collect(Collectors.joining(", "));

        System.out.println("Solution to problem 2: " + practice2);

    }
    static class Employee {
        String name;
        double salary;

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }
    }
    /*  You have a list of employees with name and salary.
      1 Keep only employees with a salary greater than 50,000.
      2 Sort them by salary in descending order.
      3 Print just their names in uppercase, separated by commas. */
    public static void problem3() {
        List<Employee> employees = Arrays.asList(
                new Employee("Ramesh", 60000),
                new Employee("Bharath", 75000),
                new Employee("Suresh", 50000),
                new Employee("Anil", 80000),
                new Employee("Raj", 40000)
        );

        String practice3 = employees.stream()
                                    .filter(e -> e.getSalary() > 50000)
                                    .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                                    .map(Employee::getName)
                                    .map(String::toUpperCase)
                                    .collect(Collectors.joining(", "));

        System.out.println("Solution to problem 3: " + practice3);
    }
    static class Employee1 {
        String name;
        String department;
        double salary;

        Employee1(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }
    }
    /*You have a list of employees with name, department, and salary.
    1 Group employees by their department.
    2 For each department, print the list of employee names (uppercase) separated by commas. */
    public static void problem4() {
        List<Employee1> employees1 = Arrays.asList(
                new Employee1("Ramesh", "IT", 60000),
                new Employee1("Bharath", "IT", 75000),
                new Employee1("Suresh", "HR", 50000),
                new Employee1("Anil", "Finance", 80000),
                new Employee1("Raj", "Finance", 40000),
                new Employee1("Srinivas", "HR", 55000)
        );


        Map<String, String> practice4 = employees1.stream()
                                                  .collect(Collectors.groupingBy(
                                                          Employee1::getDepartment,
                                                          Collectors.mapping(
                                                                  e -> e.getName().toUpperCase(),
                                                                  Collectors.joining(", ")
                                                          )
                                                  ));
        System.out.println("Solution to problem 4: ");
        practice4.forEach((a, b) -> System.out.println(a + " -> " + b));

    }
    //    Given a list of integers, compute the sum of the squares of all even numbers using lambdas/streams.
    public static void problem5() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int practice5 = numbers.stream()
                               .filter(n -> n % 2 == 0)
                               .map(n -> n * n)
                               .reduce(0, Integer::sum);

        System.out.println("Solution to problem 5: "+ practice5);    }

}