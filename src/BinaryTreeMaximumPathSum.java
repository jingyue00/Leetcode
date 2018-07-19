/**
 * 124. Binary Tree Maximum Path Sum
 *
 * Given a binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes
 * from some starting node to any node in the tree along the parent-child connections.
 *
 * The path must contain at least one node and does not need to go through the root.
 * For example:
 * Given the below binary tree,
 *   1
 *  / \
 * 2   3
 * Return 6.
 *
 * Solution: Use dfs, get left node and right node value.
 *      Important: the max sum and return sum are different
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class BinaryTreeMaximumPathSum {
    int res;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        res = Integer.MIN_VALUE;
        getMax(root);
        return res;
    }

    public int getMax(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, getMax(root.left));
        int right = Math.max(0, getMax(root.right));
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
