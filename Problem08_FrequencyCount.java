import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem08_FrequencyCount {
    public static void main(String[] args) {
        String input = "java streams java";

        Map<Character, Long> charFrequency = input.chars()
                .filter(c -> !Character.isWhitespace(c))
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));

        Map<String, Long> wordFrequency = Arrays.stream(input.split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        System.out.println("Character frequency: " + charFrequency);
        System.out.println("Word frequency: " + wordFrequency);
    }
}