import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Requirement: Given an array of size n, find the majority element. The majority element is the
 *      element that appears more than ⌊ n/2 ⌋ times.
 * Solution: Use HashMap to map the frequent of each number, and compare to n/2
 *      Or sort the array and find integer at position n/2
 * Case1: Time Complexity: O(n), Space Complexity: O(n)
 * Case2: Time Complexity: O(nlogn), Space Complexity: O(1)
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int res = 0;
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!numsMap.containsKey(nums[i])) {
                numsMap.put(nums[i], 1);
            } else {
                numsMap.put(nums[i], numsMap.get(nums[i]) + 1);
            }
            if (numsMap.get(nums[i]) > nums.length / 2) {
                res = nums[i];
                break;
            }
        }
        return res;
    }

    // time : O(nlogn) space : O(1)
    public int majorityElementII(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
