package PracticeProblems;

/*Create a functional interface StringOperation with one method String operate(String s).
1 Use it with a lambda to reverse a string.
2 Use the same interface again to convert the string to uppercase.*/

interface StringOperation{
    String operate(String S);
}
public class FunctionalInterface2 {
    public static void main(String[] args) {
        StringOperation upper = a->a.toUpperCase();
        System.out.println(upper.operate("hello"));

        StringOperation reverse = s -> new StringBuilder(s).reverse().toString();
        System.out.println(reverse.operate("Ramesh"));

    }
}
