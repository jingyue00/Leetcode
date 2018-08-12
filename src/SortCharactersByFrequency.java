import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 451. Sort Characters By Frequency
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Input:
 * "tree"
 * Output:
 * "eert"
 *
 * Solution: step1 use HashMap to count frequency of each character, step2
 *      create a bucket, map character to correspond index of bucket
 *      step3 loop from end of bucket, if not equals to null, add
 *      characters to StringBuilder
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] arrayS = s.toCharArray();
        for (char c : arrayS) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character>[] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int count = map.get(key);
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (char c : bucket[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
