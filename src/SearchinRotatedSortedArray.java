/**
 * Solution: start = 0, end = nums.length - 1. Use the while loop each time get the mid.
 *      Then check nums[start] < nums[mid] to determine whether to change start or end
 *      Important: Why using (start + 1 < end) Case [1,3] 2 will not stop
 *      And why check the nums[start] and nums[end] after loop. Because Case [1,3] 3
 *      will not go into the loop, (start + 1 < end) will auto stop when there are only
 *      two elements.
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) return mid;
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
