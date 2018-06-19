import java.util.HashSet;
import java.util.Set;

/**
 * Solution: to find the longest substring without repeating characters, we can use hashset.
 *      use while loop to go through each character in the string s, let i and j start from 0.
 *      keep moving j if the character is not exist in hashset and compare length with res.
 *      else, move i from left to right and each time remove character at i position from hashset
 *      and then continue to check whether character at position j exist in the hashset again.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        Set<Character> mySet = new HashSet<>();
        char[] arrayS = s.toCharArray();
        int i = 0, j = 0;
        while (j < arrayS.length) {
            if (!mySet.contains(arrayS[j])) {
                mySet.add(arrayS[j++]);
                res = Math.max(res, j - i);
            } else {
                mySet.remove(arrayS[i++]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(lswrc.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lswrc.lengthOfLongestSubstring("bbbbb"));
        System.out.println(lswrc.lengthOfLongestSubstring("pwwkew"));
    }
}
