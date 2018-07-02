import java.util.HashSet;
import java.util.Set;

/**
 * Solution: build a HashSet to check repetition.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() <= 1) return true;
        Set<Character> mySet = new HashSet<>();
        char[] arrayS = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (!mySet.contains(arrayS[i])) mySet.add(arrayS[i]);
            else mySet.remove(arrayS[i]);
        }
        return mySet.size() <= 1;
    }

    public boolean canPermutePalindrome1(String s) {
        char[] count = new char[256];
        int res = 0;
        for (char c : s.toCharArray()) {
            if (count[c] > 0) {
                count[c]--;
            } else {
                count[c]++;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) res++;
        }
        return res <= 1;
    }
}
