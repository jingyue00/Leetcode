/**
 * Solution: case 1: pointer i, j, keep moving j, if j != 0, set it to i and i++. After j finish loop
 *      set the rest of integer to 0
 *      case 2: pointer i, j. keep moving j, if j != 0, swap j and i, i++ (j will not move at this time)
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int zero = 0;
        int nonzero = 0;
        while (nonzero < nums.length) {
            if (nums[nonzero] != 0) {
                int tmp = nums[nonzero];
                nums[nonzero] = nums[zero];
                nums[zero ++] = tmp;
            }
            nonzero ++;
        }
    }

    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[start++] = nums[i];
            }
        }
        while (start < nums.length) {
            nums[start++] = 0;
        }
    }
}
