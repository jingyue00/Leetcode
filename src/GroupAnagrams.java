import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Solution: use HashMap, use sorted String as key, list of anagrams is value
 * Time Complexity: O(m * nlogn)
 * Space Complexity: O(n)
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String newS = new String(array);
            if (!map.containsKey(newS)) {
                List<String> list = new LinkedList();
                list.add(s);
                map.put(newS, list);
            } else {
                List<String> list = map.get(newS);
                list.add(s);
                map.put(newS, list);
            }
        }
        for (String s : map.keySet()) {
            res.add(map.get(s));
        }
        return res;
    }

    /**
     * Solution: difference is not using sort, but new int[26] to get sorted key.
     * Time Complexity: O(m * n)
     * Space Complexity: O(n)
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (Character ch : str.toCharArray()) {
                count[ch - 'a']++;
            }
            String s = "";
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    s += String.valueOf(count[i]) + String.valueOf((char)(i + 'a'));
                }
            }
            if (map.containsKey(s)) {
                List<String> list = map.get(s);
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
