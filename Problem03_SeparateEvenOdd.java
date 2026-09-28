import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Problem03_SeparateEvenOdd {
    public static void main(String[] args) throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        Map<Boolean, List<Integer>> result =
                numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("Even: " + result.get(true));
        System.out.println("Odd : " + result.get(false));

        // Alternate printing with two threads using wait/notify.
        Object lock = new Object();
        int[] value = {1};
        int limit = 10;

        Thread odd = new Thread(() -> {
            synchronized (lock) {
                while (value[0] <= limit) {
                    while (value[0] <= limit && value[0] % 2 == 0) {
                        try { lock.wait(); } catch (InterruptedException e) {
                            Thread.currentThread().interrupt(); return;
                        }
                    }
                    if (value[0] <= limit) {
                        System.out.print(value[0] + " ");
                        value[0]++;
                        lock.notifyAll();
                    }
                }
            }
        });

        Thread even = new Thread(() -> {
            synchronized (lock) {
                while (value[0] <= limit) {
                    while (value[0] <= limit && value[0] % 2 != 0) {
                        try { lock.wait(); } catch (InterruptedException e) {
                            Thread.currentThread().interrupt(); return;
                        }
                    }
                    if (value[0] <= limit) {
                        System.out.print(value[0] + " ");
                        value[0]++;
                        lock.notifyAll();
                    }
                }
            }
        });

        odd.start();
        even.start();
        odd.join();
        even.join();
        System.out.println();
    }
}