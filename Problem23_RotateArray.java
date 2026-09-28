import java.util.Arrays;

public class Problem23_RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int steps = 3;

        rotateRight(arr, steps);
        System.out.println(Arrays.toString(arr));
    }

    static void rotateRight(int[] arr, int steps) {
        if (arr.length == 0) return;
        steps %= arr.length;

        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, steps - 1);
        reverse(arr, steps, arr.length - 1);
    }

    static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}