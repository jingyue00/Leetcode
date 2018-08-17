/**
 * 414. Third Maximum Number
 *
 * There are N gas stations along a circular route,
 * where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and
 * it costs cost[i] of gas to travel from station i to its next station (i+1).
 *
 * You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 *
 * Solution: use first. second, third to record number
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[1];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == first || nums[i] == second || nums[i] == third)
                continue;
            if(nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            }
            else if(nums[i] > second) {
                third = second;
                second = nums[i];
            }
            else if(nums[i] > third) {
                third = nums[i];
            }
        }
        return (int) ((third == Long.MIN_VALUE)?first:third);
    }
}
