import java.util.HashMap;
import java.util.Map;

/**
 * Solution: use map to count the frequency. Go through the string to check first position
 *      with frequency equals 1.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        char[] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        for (int i = 0 ; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
