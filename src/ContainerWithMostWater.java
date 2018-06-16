/**
 * Requirement: find two lines, let container contains most water, input is int[] height
 * Solution: have two pointers, one start from position 0, one start from position height.length - 1
 *      use while loop to count the area, compare the height between left and right and use the smaller
 *      value to multiple the distance between left and right. Then compare the result and select the
 *      larger one. Move the pointer which has the smaller value and get result after finishing the loop.
 *      Important: Good to use Math.max and Math.min to calculate.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left ++;
            } else right --;

        }
        return res;
    }

    public static void main(String[] args) {
        ContainerWithMostWater cwmw = new ContainerWithMostWater();
        System.out.println(cwmw.maxArea(new int[]{2,3,4,5,18,17,6}));
    }
}
