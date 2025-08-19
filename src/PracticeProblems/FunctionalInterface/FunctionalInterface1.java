package PracticeProblems.FunctionalInterface;

/* Create a functional interface Calculator with one method int calculate(int a, int b).
Use it with a lambda to perform addition of two numbers.
Then use the same interface to perform multiplication */

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

public class FunctionalInterface1 {

    public static void main(String[] args) {
        Calculator add = (a, b) -> a + b;
        int res = add.calculate(3, 5);
        System.out.println(res);

        Calculator mul=(a,b)->a*b;
        res=mul.calculate(4,6);
        System.out.println(res);
    }
}
