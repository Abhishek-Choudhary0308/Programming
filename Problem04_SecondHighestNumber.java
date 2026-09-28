import java.util.*;
import java.util.stream.Collectors;

public class Problem04_SecondHighestNumber {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 30, 20, 30, 40, null, 40, 25);

        Integer secondHighest = numbers.stream()
                .filter(Objects::nonNull)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println("Second highest: " + secondHighest);
    }
}