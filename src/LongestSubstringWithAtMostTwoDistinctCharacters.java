import java.util.HashMap;
import java.util.Map;

/**
 * 159. Longest Substring with At Most Two Distinct Characters
 *
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 * For example, Given s = “eceba”,
 * T is "ece" which its length is 3.
 *
 * Solution: Use HashMap to record location. keep add character, until map.size() > 2
 *      find minimum index, then remove, each time compare the max with i - start + 1
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        int max = 0;
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
            if (map.size() > 2) {
                int removeIndex = i;
                for (int index : map.values()) {
                    removeIndex = Math.min(index, removeIndex);
                }
                map.remove(array[removeIndex]);
                start = removeIndex + 1;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String[] ss = {"abc", "annc", "annncccx", "eceba"};
        for (String s : ss) {
            System.out.println(lengthOfLongestSubstringTwoDistinct(s));
        }
    }
}
