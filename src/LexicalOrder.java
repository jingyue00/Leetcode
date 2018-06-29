import java.util.LinkedList;
import java.util.List;

/**
 * Solution: loop 0 to n-1 times, cur start with 1. Three Steps: step 1, if cur * 10 < n
 *      cur *= 10; step 2, if cur % 10 != 9, cur++; step 3, if (cur / 10) % 10 == 9, continue
 *      the while loop to let cur /= 10.
 *      Important: why there is (cur / 10) in while ((cur / 10) % 10 == 9), since after the
 *      while loop we need to run cur = cur / 10 one more time.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class LexicalOrder {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new LinkedList<>();
        int cur = 1;
        for (int i = 0; i < n; i++) {
            res.add(cur);
            if (cur * 10 <= n) {
                cur *= 10;
            } else if (cur % 10 != 9 && cur < n) {
                cur += 1;
            } else {
                while ((cur / 10) % 10 == 9) {
                    cur /= 10;
                }
                cur = cur / 10 + 1;
            }
        }
        return res;
    }
}
