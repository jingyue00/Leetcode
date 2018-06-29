/**
 * Solution each time find mid from start to end, count number <= mid,
 *      if count <= mid, reset start, else reset end
 * Time Complexity: O(nlogn)
 * Space Complexity: O(1)
 */
public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length;
        while (start <= end) {
            int mid = start + (end - start) / 2 ;
            int count = 0;
            for (int n : nums) {
                if (n <= mid) ++count;
            }
            if (count <= mid) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity : O(1)
     * */

    public int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
