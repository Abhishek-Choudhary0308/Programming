import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem01_FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String input = "Swiss";

        // Case-insensitive, so the example "Swiss" returns 'w'.
        Map<Character, Integer> frequency = new LinkedHashMap<>();
        for (char ch : input.toCharArray()) {
            char key = Character.toLowerCase(ch);
            frequency.put(key, frequency.getOrDefault(key, 0) + 1);
        }

        for (char ch : input.toCharArray()) {
            if (frequency.get(Character.toLowerCase(ch)) == 1) {
                System.out.println("Loop: " + ch);
                break;
            }
        }

        Character result = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        ch -> Character.toLowerCase(ch),
                        LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println("Stream: " + result);
    }
}