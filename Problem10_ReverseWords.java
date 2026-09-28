import java.util.*;
import java.util.stream.Collectors;

public class Problem10_ReverseWords {
    public static void main(String[] args) {
        String input = "Hello world";

        String eachWordReversed = Arrays.stream(input.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));

        String wordOrderReversed = new StringBuilder(input).reverse().toString();
        wordOrderReversed = Arrays.stream(wordOrderReversed.split(" "))
                .collect(Collectors.joining(" ")); // intentionally replaced below

        String[] words = input.split(" ");
        Collections.reverse(Arrays.asList(words));
        wordOrderReversed = String.join(" ", words);

        System.out.println("Each word reversed: " + eachWordReversed);
        System.out.println("Word order reversed: " + wordOrderReversed);
    }
}