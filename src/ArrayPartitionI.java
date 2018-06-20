import java.util.Arrays;

/**
 * Solution: After analysis the array, group the nearest two integer to get largest sum
 *      so, we can first sort the array, and go through array add the smaller one in pair of numbers
 * Time Complexity: O(nlogn)
 * Space Complexity: O(1)
 */
public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res = res + nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayPartitionI ap = new ArrayPartitionI();
        System.out.println(ap.arrayPairSum(new int[]{1,4,3,2}));
    }
}
