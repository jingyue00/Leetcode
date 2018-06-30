/**
 * Solution: use recursion to check node.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkSymmetric (root.left, root.right);
    }

    public boolean checkSymmetric (TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }
        return checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
    }
}
