import java.util.Arrays;

public class Problem12_MoveZeros {
    public static void main(String[] args) {
        int[] arr = {2, 3, 0, 1, 0, 1, 2, 0, 6};
        moveZerosToEnd(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void moveZerosToEnd(int[] arr) {
        int index = 0;

        for (int value : arr) {
            if (value != 0) {
                arr[index++] = value;
            }
        }

        while (index < arr.length) {
            arr[index++] = 0;
        }
    }
}