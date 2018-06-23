/**
 * Requirement: Input: [-2,1,-3,4,-1,2,1,-5,4],
 *              Output: 6
 *              Explanation: [4,-1,2,1] has the largest sum = 6.
 * Solution: to get maximum subarray. start from 1 to array.length - 1. Compare the value of
 *      nums[i] and maxSum[i - 1] + nums[i] to get max sum at each position. Then use a maxValue
 *      to get the overall maximum value.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] maxSum = new int[nums.length];
        int maxValue = nums[0];
        maxSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSum[i] = Math.max(maxSum[i - 1] + nums[i], nums[i]);
            maxValue = Math.max(maxValue, maxSum[i]);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        MaximumSubarray msa = new MaximumSubarray();
        System.out.println(msa.maxSubArray(new int[]{-2,1}));
        //System.out.println(msa.maxSubArray(new int[]{1,2}, new int[]{3,4}));
    }
}
