/**
 * Solution: Use dynamic programming, check the max of itself + place can be reach (i - 2) and place
 *      cannot be reach (i - 1)
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            result[i] = Math.max(nums[i] + result[i - 2], result[i - 1]);
        }
        return result[nums.length - 1];
    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        System.out.println(hr.rob(new int[]{2,7,9,3,1}));
    }
}
