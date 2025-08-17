package PracticeProblems;

/*Create a functional interface NumberCheck that takes an integer and returns a boolean.
Implement lambdas for checking:
1 If a number is prime
2 If a number is palindrome */

 interface NumbCheck {
    boolean check(int a);
}

public class FunctionalInterface3 {

    public static void main(String[] args) {
        NumbCheck prime = a -> {
            if (a < 1)
                return false;
            else
                for (int i = 2; i <= Math.sqrt(a); i++) {
                    if (a % i == 0)
                        return false;
                }
            return true;
        };
        NumbCheck palindrome = a -> {
            int original = a;
            int reversed = 0;
            while (a % 10 != 0) {
                int temp = a % 10;
                reversed = reversed * 10 + temp;
                a = a / 10;
            }
            return original == reversed;
        };
        System.out.println("Prime Number checking :" + prime.check(7));
        System.out.println("Palindrome Number checking :" + palindrome.check(733));

    }

}
