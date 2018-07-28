import java.util.HashMap;
import java.util.Map;

/**
 * 340. Longest Substring with At Most K Distinct Characters
 *
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * For example, Given s = “eceba” and k = 2,
 * T is "ece" which its length is 3.
 *
 * Solution: Use HashMap to record location. keep add character, until map.size() > k
 *      find minimum index, then remove, each time compare the max with i - start + 1
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        int max = 0;
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
            if (map.size() > k) {
                int indexRemove = i;
                for (int val : map.values()) {
                    indexRemove = Math.min(indexRemove, val);
                }
                map.remove(array[indexRemove]);
                start = indexRemove + 1;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String[] ss = {"abc", "annc", "annncccx", "eceba"};
        for (String s : ss) {
            System.out.println(lengthOfLongestSubstringKDistinct(s, 3));
        }
    }
}
