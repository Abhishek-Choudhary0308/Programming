import java.util.Arrays;

public class Problem27_MergeSortedArrays {
    public static void main(String[] args) {
        int[] a = {1, 4, 7, 8};
        int[] b = {2, 3, 6, 9};

        merge(a, b);

        // The two arrays together now contain one sorted sequence.
        System.out.println("A: " + Arrays.toString(a));
        System.out.println("B: " + Arrays.toString(b));
    }

    // Gap method: no third array is created.
    static void merge(int[] a, int[] b) {
        int total = a.length + b.length;

        for (int gap = nextGap(total); gap > 0; gap = nextGap(gap)) {
            int i = 0;

            while (i + gap < total) {
                int j = i + gap;

                if (get(a, b, i) > get(a, b, j)) {
                    swap(a, b, i, j);
                }
                i++;
            }
        }
    }

    static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }

    static int get(int[] a, int[] b, int index) {
        return index < a.length ? a[index] : b[index - a.length];
    }

    static void swap(int[] a, int[] b, int i, int j) {
        if (i < a.length && j < a.length) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        } else if (i < a.length) {
            int temp = a[i];
            a[i] = b[j - a.length];
            b[j - a.length] = temp;
        } else {
            int x = i - a.length;
            int y = j - a.length;
            int temp = b[x];
            b[x] = b[y];
            b[y] = temp;
        }
    }
}