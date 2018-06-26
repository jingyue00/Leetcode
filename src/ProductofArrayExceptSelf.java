/**
 * Solution: first multiple each number's left part, then multiple the right part
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            res[j] *= right;
            right *= nums[j];
        }
        return res;
    }

    public static void main(String[] args) {
        ProductofArrayExceptSelf pae = new ProductofArrayExceptSelf();
        System.out.println(pae.productExceptSelf(new int[]{1,2,3,4}));
    }
}
