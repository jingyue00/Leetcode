/**
 * Solution: use two pointer to go through the array.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != val) {
                nums[left ++] = nums[right];
            }
            right ++;
        }
        return left;
    }

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        System.out.println(re.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}
