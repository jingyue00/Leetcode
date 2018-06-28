import java.util.List;

/**
 * Solution: build a boolean array. Go through the while character array,
 *      each time to check left part use boolean array and check right part
 *      use contains() method. Important: start element of boolean array equals true.
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        char[] arrayS = s.toCharArray();
        boolean[] match = new boolean[s.length() + 1];
        match[0] = true;
        for (int i = 1; i <= arrayS.length; i++) {
            for (int j = 0; j < i; j++) {
                if (match[j] && wordDict.contains(s.substring(j, i))) {
                    match[i] = true;
                    break;
                }
            }
        }
        return match[s.length()];
    }
}
