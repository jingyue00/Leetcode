import java.util.HashSet;
import java.util.Set;

/**
 * Solution: use while loop and HashSet to check duplicate
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> mySet = new HashSet<>();
        int cur = 0;
        while (cur < nums.length) {
            if (mySet.contains(nums[cur])) {
                return true;
            }
            mySet.add(nums[cur]);
            cur ++;
        }
        return false;
    }
}
