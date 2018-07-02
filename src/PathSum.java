/**
 * Solution: Use recursion each time check left, or right with sum - root.val
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
