import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match,
 * such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 *
 * Notes:
 * You may assume pattern contains only lowercase letters,
 * and str contains lowercase letters separated by a single space.
 *
 * Solution: Use HashMap to check equals of pattern and string
 *      Important: don't forget to check duplicate of values in map and compare strings use equals
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] array = str.split(" ");
        if (pattern.length() != array.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (!map.containsValue(array[i])) {
                    map.put(pattern.charAt(i), array[i]);
                } else {
                    return false;
                }
            } else {
                String cur = map.get(pattern.charAt(i));
                if (cur.equals(array[i])) continue;
                else return false;
            }
        }
        return true;
    }
}
