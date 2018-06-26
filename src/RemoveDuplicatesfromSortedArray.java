/**
 * Solution: use two pointers, place value of right pointer to left pointer if nums[right] = nums[right - 1]
 *      stop when right reach nums.length;
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }
        int left = 1;
        int right = 1;
        while (right < nums.length) {
            if (nums[right - 1] != nums[right]) {
                nums[left++] = nums[right];
            }
            right ++;
        }
        return left;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray rd = new RemoveDuplicatesfromSortedArray();
        System.out.println(rd.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
