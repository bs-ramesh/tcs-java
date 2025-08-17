package PracticeProblems;

import java.util.Optional;

/*Create an Optional<String> from a given name.
1 If the name is not null, print it in uppercase.
2 If it’s null, print "Name not provided". */
public class OptionalClass1 {
    public static void main(String[] args) {
        Optional<String> str1= Optional.of("hello");
        Optional<String> str2= Optional.empty();

        String strr1 = str1
                .map(String::toUpperCase)
                .orElse("Name not Provided");

        String strr2 = str2
                .map(String::toUpperCase)
                .orElse("Name not Provided");

        System.out.println("Printing str1 and str2 "+ str1 +" and "+ str2);
        System.out.println("Printing strr1 and strr2 "+ strr1 +" and "+ strr2);
    }
}
