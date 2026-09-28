import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem06_FindDuplicatesWithoutSet {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 1, 6, 3, 3);

        // No Set and no additional helper collection for detecting duplicates.
        List<Integer> duplicates = numbers.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Duplicates: " + duplicates);
    }
}