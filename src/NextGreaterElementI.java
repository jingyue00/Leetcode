import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Requirement: for x in nums1, find the same number in nums2 and check if there is any
 *      number larger than x (say the number is y>x) on its right side in nums2.
 *      Print y if there is such a number or -1 if there is no such number.
 * Solution: Use stack and HashMap to find the greater number on right side
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peekFirst()) {
                map.put(stack.pollFirst(), nums2[i]);
            }
            stack.offerFirst(nums2[i]);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pollFirst(), -1);
        }
        for (int j = 0; j < nums1.length; j++) {
            res[j] = map.get(nums1[j]);
        }
        return res;
    }
}
