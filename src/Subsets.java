import java.util.LinkedList;
import java.util.List;

/**
 * Solution: use recursion, each time we need to decide whether add current number or not
 *      Important: don't forget to have an index, in the for loop,
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        sets(nums, new LinkedList<>(), res, 0);
        return res;
    }

    public void sets(int[] nums, List<Integer> cur, List<List<Integer>> res, int index) {
        res.add(new LinkedList<>(cur));
        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            sets(nums, cur, res, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
