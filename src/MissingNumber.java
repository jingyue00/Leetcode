/**
 * Solution: use exclusive or to check missing number.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }
}
