/**
 * Solution: first reverse all array, then reverse 0 to k-1, and reverse k to array.length-1
 *      Original List                   : 1 2 3 4 5 6 7
 *      After reversing all numbers     : 7 6 5 4 3 2 1
 *      After reversing first k numbers : 5 6 7 4 3 2 1
 *      After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(0, nums.length - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, nums.length - 1, nums);
    }

    public void reverse(int start, int end, int[] nums) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start ++;
            end --;
        }
    }

    public void rotateI(int[] nums, int k) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }
}
