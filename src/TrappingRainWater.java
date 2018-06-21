/**
 * Requirement: Given n non-negative integers representing an elevation map where the width of
 *      each bar is 1, compute how much water it is able to trap after raining.
 * 0,1,0,2,1,0,1,3,2,1,2,1      ->      6
 *       * *   *
 *   * *   * * * * * *
 * 0 1 2 3 4 5 6 7 8 9 0 1
 * Solution: In order to bound two side, we need to have to pointer start from 0 and height.length - 1
 *      if left and right not meet we continue our loop. Important: each time compare and move the pointer
 *      with lower height, and compare it with max value, then we can add leftMax - height[max] to res.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
                left ++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
                right --;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TrappingRainWater tr = new TrappingRainWater();
        System.out.println(tr.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(tr.trap(new int[] {2,0,2}));
        System.out.println(tr.trap(new int[] {4,2,3}));
        System.out.println(tr.trap(new int[] {5,4,1,2}));
        System.out.println(tr.trap(new int[] {5,2,1,2,1,5}));
    }
}
