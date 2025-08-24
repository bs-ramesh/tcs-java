package PracticeProblems.LamdaAndStreams;

import java.util.*;
import java.util.stream.Collectors;

public class DailyPractice5 {
    public static void main(String[] args) {
        problem1();
        problem2();
    }

    static class Employee {
        String name;
        String dept;
        double salary;

        Employee(String name, String dept, double salary) {
            this.name = name;
            this.dept = dept;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public String getDept() {
            return dept;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", dept='" + dept + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }


    /*
       Problem 1:
       You have a list of employees with name, department, and salary.
       1. Group employees by department.
       2. For each department, find the average salary.
       3. For each department, find the highest-paid employee's name.
       4. Print a map where key = department, value = "avgSalary - highestPaidEmployeeName".
    */
    public static void problem1() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT", 70000),
                new Employee("Bob", "HR", 50000),
                new Employee("Charlie", "IT", 90000),
                new Employee("David", "Finance", 60000),
                new Employee("Eva", "Finance", 80000)
        );

        // Write your Java 8 solution here
        Map<String, String> practice1 = employees.stream()
                                                 .collect(Collectors.groupingBy(Employee::getDept,
                                                         Collectors.collectingAndThen(Collectors.toList(), list -> {
                                                             double avg = list.stream()
                                                                              .collect(Collectors.averagingDouble(Employee::getSalary));
                                                             String maxName = list.stream()
                                                                                  .max(Comparator.comparingDouble(Employee::getSalary))
                                                                                  .map(Employee::getName)
                                                                                  .orElse("");
                                                             return String.format("%.2f - %s", avg, maxName);
                                                         })
                                                 ));

        System.out.println(practice1);

    }

    /*
       Problem 2:
       You have a map of user IDs and emails (some emails may be null).
       1. If the email is null, replace it with "default@email.com".
       2. Extract the domain part (after '@').
       3. Print the domains in uppercase.
    */
    public static void problem2() {
        Map<Integer, String> emails = new HashMap<>();
        emails.put(1, "alice@gmail.com");
        emails.put(2, null);
        emails.put(3, "bob@yahoo.com");

        List<String> practice2 = emails.values().stream()
                                       .map(email -> Optional.ofNullable(email)
                                                             .orElse("default@email.com")
                                                             .split("@")[1]
                                               .toUpperCase())
                                       .collect(Collectors.toList());

        System.out.println(practice2);


    }
}
