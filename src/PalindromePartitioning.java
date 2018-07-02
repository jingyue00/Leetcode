import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution: Use recursion (backtracking), start from 0 to s.length() - 1
 *      check partition of first part isPartition(s.substring(0, i + 1), if it equals true
 *      add it to cur list and begin the recursion of left part of string
 *      checkPartition(res, cur, s.substring(i + 1)), after recursion remove last element in cur.
 *      then base case is s.length <= 0, at this time add cur to res.
 *      Important: don't forget return even the return of the method is void.
 *    a         aa      aab
 * a    ab      b
 * b
 * Time Complexity: O(2^n)
 * T(n)=T(n-1)+T(n-2)+..+T(1), T(n+1)=T(n)+T(n-1)+..+T(1) -> T(n+1)=2T(n) -> T(n)=2^n
 * Space Complexity: O(n)
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        List<String> cur = new LinkedList<>();
        checkPartition(res, cur, s);
        return res;
    }

    public void checkPartition(List<List<String>> res, List<String> cur, String s) {
        if (s.length() <= 0) {
            res.add(new LinkedList(cur));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPartition(s.substring(0, i + 1))) {
                cur.add(s.substring(0, i + 1));
                checkPartition(res, cur, s.substring(i + 1));
                cur.remove(cur.size() - 1);
            }
        }
    }

    public boolean isPartition(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }

    // Time Complexity: O(n^2), Space Complexity: O(n)
    public static List<List<String>> partitionII(String s) {
        int len = s.length();
        List<List<String>>[] result = new List[len + 1];
        result[0] = new ArrayList<>();
        result[0].add(new ArrayList<>());

        boolean[][] pair = new boolean[len][len];
        for (int i = 0; i < s.length(); i++) {
            result[i + 1] = new ArrayList<>();
            for (int left = 0; left <= i; left++) {
                if (s.charAt(left) == s.charAt(i) && (i-left <= 1 || pair[left + 1][i - 1])) {
                    pair[left][i] = true;
                    String str = s.substring(left, i + 1);
                    for (List<String> r : result[left]) {
                        List<String> ri = new ArrayList<>(r);
                        ri.add(str);
                        result[i + 1].add(ri);
                    }
                }
            }
        }
        return result[len];
    }
}
