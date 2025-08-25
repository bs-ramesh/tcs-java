package PracticeProblems.LamdaAndStreams;

import java.util.*;
import java.util.stream.Collectors;

public class DailyPractice5 {
    public static void main(String[] args) {
        problem1();
        problem2();
        problem3();
        problem4();
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

    static class Product {
        String name;
        String category;
        double price;

        Product(String name, String category, double price) {
            this.name = name;
            this.category = category;
            this.price = price;
        }

        public String getName() { return name; }
        public String getCategory() { return category; }
        public double getPrice() { return price; }
    }

    /* Problem 3:
       You have a list of products with name, category, and price.
       1) Group products by category.
       2) For each category, calculate the total price of products.
       3) Print each category with its total price.
    */
    public static void problem3() {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 80000),
                new Product("Phone", "Electronics", 50000),
                new Product("Shirt", "Clothing", 2000),
                new Product("Jeans", "Clothing", 3000),
                new Product("Book", "Stationery", 500)
        );

        // write your solution code here

        Map<String,Double> practice3= products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.summingDouble(Product::getPrice)));

        System.out.println("output of problem 3 "+practice3);

    }
    static class Student {
        String name;
        List<Integer> marks;

        Student(String name, List<Integer> marks) {
            this.name = name;
            this.marks = marks;
        }

        public String getName() { return name; }
        public List<Integer> getMarks() { return marks; }
    }

    /* Problem 4:
       You have a list of students where each student has multiple marks.
       1) Flatten all marks into a single stream.
       2) Find the highest mark.
       3) Print the highest mark.
    */
    public static void problem4() {
        List<Student> students = Arrays.asList(
                new Student("Ramesh", Arrays.asList(70, 80, 90)),
                new Student("Bharath", Arrays.asList(85, 60, 75)),
                new Student("Anil", Arrays.asList(50, 65, 88))
        );

        // write your solution code here
        Optional<Integer> practice4 = students.stream()
                .map(Student::getMarks)
                .flatMap(List::stream)
                .max(Comparator.naturalOrder());

        System.out.println("output to problem 4 "+practice4);

    }

}
