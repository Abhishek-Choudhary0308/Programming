import java.util.*;

public class Problem07_LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println("Length: " + lengthOfLongestSubstring(input));
    }

    static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0, max = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (lastSeen.containsKey(ch)) {
                left = Math.max(left, lastSeen.get(ch) + 1);
            }
            lastSeen.put(ch, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}