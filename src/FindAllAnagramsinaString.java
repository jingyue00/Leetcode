import java.util.ArrayList;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 *
 * Given a string s and a non-empty string p,
 * find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and
 * the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 *
 * Solution: use array to match the place of characters.
 *      if (chars[s.charAt(end) - 'a'] > 0) count--; if (end - start == p.length()) and
 *      (chars[s.charAt(start) - 'a'] >= 0) count ++;
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || p.length() > s.length()) {
            return res;
        }
        int[] chars = new int[26];
        for (int i = 0; i < p.length(); i++) {
            chars[p.charAt(i) - 'a'] ++;
        }
        int start = 0, end = 0, count = p.length();
        while (end < s.length()) {
            if (chars[s.charAt(end) - 'a'] > 0) {
                count--;
            }
            chars[s.charAt(end) - 'a'] --;
            end++;
            if (count == 0) {
                res.add(start);
            }
            if (end - start == p.length()) {
                if (chars[s.charAt(start) - 'a'] >= 0) {
                    count ++;
                }
                chars[s.charAt(start) - 'a'] ++;
                start ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = new FindAllAnagramsinaString().findAnagrams("cbaebabacd", "abc");
        System.out.println(list.toString());
    }
}
