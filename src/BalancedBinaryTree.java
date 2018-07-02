/**
 * Solution: compare the height of root.left and root.right use Math.abs.
 *      return -1 if depth of the two subtrees of every node never differ by more than 1
 *      else, return the larger number of height
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return height(root) != -1;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        if (left == -1) return -1;
        int right = height(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
