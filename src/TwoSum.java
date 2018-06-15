import java.util.HashMap;
import java.util.Map;

/**
 * Solution: input are int[] nums and int target, output are position of two matching integers.
 *      use HashMap to store each number in nums and its position,
 *      and each time check difference (target - nums[i])
 *      if match, save them as the solution.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[]{-1, -1};
        if (nums == null || nums.length < 2) {
            return results;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                results[0] = map.get(target - nums[i]);
                results[1] = i;
            }
            map.put(nums[i], i);
        }
        return results;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        System.out.println(ts.twoSum(new int[]{2, 7, 11, 15}, 9)[0]);
        System.out.println(ts.twoSum(new int[]{2, 7, 11, 15}, 9)[1]);
    }
}
