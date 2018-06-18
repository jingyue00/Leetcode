
/**
 * Requirement: find median of two sorted array
 * Solution: first we compare two array and let the shorter one become nums1, another is nums2.
 *      Next, if we want to equally separate the combined array (nums1 + nums2), then when we random cut in nums1 using cut1,
 *      we can know that cut2 -> (nums1 + nums2) / 2 - cut1. In order to let number of left1 + left2 == right1 + right2
 *      example:    nums1   3 5 | 8 9               or      3 | 5 8 9
 *                  nums2   1 2 7 | 10 11 12                1 2 7 10 | 11 12
 *      To find median number, use while loop to keep cut1 >= 0 and <= nums.length
 *      To calculate left cut and right cut of both cut1 and cut2. We need to notice that if cut1 and cut2 equals 0,
 *      then the left cut equals Integer.MIN_VALUE, else equals nums[cut - 1]. And if cut1 and cut2 equals nums.length,
 *      the right cut equals Integer.MAX_VALUE, else equals nums[cut]
 *      Next step, compare the left Cut of cut1 and right cut of cut2; and right cut of cut1 and left cut of cut2
 *      (redefine the bound using cut1 - 1 and cut1 + 1)
 *      If satisfy the requirement of left1 < right2 and right1 > left2, then get the Max(left1, left2) and Min(right1, right2)
 *      Important: at the beginning, if we found nums1.length > nums2.length, recall the function.
 *      Don't forget return !!! Correct statement: return findMedianSortedArrays(nums2, nums1);
 *
 * Time Complexity: O(log(min(m,n)))
 * Space Complexity: O(1)
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int cut1 = nums1.length / 2;
        int cutL = 0;
        int cutR = nums1.length;

        while (cut1 <= nums1.length && cut1 >= 0) {
            cut1 = (cutR - cutL) / 2 + cutL;
            int cut2 = (nums1.length + nums2.length) / 2 - cut1;
            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int right1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int right2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
            if (left1 > right2) {
                cutR = cut1 - 1;
            } else if (right1 < left2) {
                cutL = cut1 + 1;
            } else {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    int left = Math.max(left1, left2);
                    int right = Math.min(right1, right2);
                    return (double) (left + right) / 2;
                } else {
                    return Math.min(right1, right2);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MedianofTwoSortedArrays msa = new MedianofTwoSortedArrays();
        System.out.println(msa.findMedianSortedArrays(new int[]{2,3,4,5}, new int[]{1}));
        System.out.println(msa.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }
}
