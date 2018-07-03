/**
 * Solution: compare the value of root and its left and right, count add 1 if they are equal
 *      reset res as the larger value of res and leftCount + rightCount
 *      then return larger value compare leftCount and rightCount
 * Time Complexity: O(n)
 * Space Complexity: O(H)
 */
public class LongestUnivaluePath {
    int res;
    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        getLongestUnivaluePath(root);
        return res;
    }

    public int getLongestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        int left = getLongestUnivaluePath(root.left);
        int right = getLongestUnivaluePath(root.right);
        int leftCount = 0, rightCount = 0;
        if (root.left != null && root.val == root.left.val) {
            leftCount += left + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            rightCount += right + 1;
        }
        res = Math.max(res, leftCount + rightCount);
        return Math.max(leftCount, rightCount);
    }
}
