/**
 * Requirement: Given list of int, find the single number
 * Solution: Use exclusive or since same - 0, difference - 1
 * 1 1 : 0
 * 0 0 : 0
 * 1 0 : 1
 * 0 1 : 1
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        System.out.println(sn.singleNumber(new int[]{2,2,1}));
        System.out.println(sn.singleNumber(new int[]{4,1,2,1,2}));
    }
}
