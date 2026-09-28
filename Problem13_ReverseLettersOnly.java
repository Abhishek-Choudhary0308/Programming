public class Problem13_ReverseLettersOnly {
    public static void main(String[] args) {
        String input = "a1b2c3d4e5f";
        System.out.println(reverseLettersOnly(input));
    }

    static String reverseLettersOnly(String s) {
        char[] result = s.toCharArray();
        int left = 0, right = result.length - 1;

        while (left < right) {
            while (left < right && !Character.isLetter(result[left])) left++;
            while (left < right && !Character.isLetter(result[right])) right--;

            if (left < right) {
                char temp = result[left];
                result[left] = result[right];
                result[right] = temp;
                left++;
                right--;
            }
        }
        return new String(result);
    }
}