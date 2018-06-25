import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution: first sort the array. Use the for loop to start first number from 0 to nums.length - 2.
 *      Second number start from first number + 1, and third number start from nums.length - 1.
 *      if second number < third number, and first + second + thrid number = sum, add to result.
 *      Important: Use while loop to check repeat. while (low < high && nums[low] == nums[low + 1]) low++;
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];
            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    low++;
                    high--;
                } else if (nums[low] + nums[high] < sum) {
                    low++;
                } else high--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        System.out.println(ts.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
