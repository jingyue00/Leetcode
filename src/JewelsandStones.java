import java.util.HashSet;
import java.util.Set;

/**
 * Solution: use hashset, add character in J to hashset, and check whether each character in S
 *      contains in hashset.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> mySet = new HashSet<>();
        int res = 0;
        for (char c : J.toCharArray()) {
            mySet.add(c);
        }
        for (char c : S.toCharArray()) {
            if (mySet.contains(c)) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        JewelsandStones js = new JewelsandStones();
        System.out.println(js.numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(js.numJewelsInStones("z", "ZZ"));
    }
}
