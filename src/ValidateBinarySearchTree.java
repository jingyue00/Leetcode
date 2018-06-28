/**
 * Solution: need to have a max and a min. use dfs (recursion). max of root.left is current root,
 *      min of root.right is current root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return checkValid(root, null, null);
    }

    public boolean checkValid(TreeNode root, Integer max, Integer min) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;

        return checkValid(root.left, root.val, min) && checkValid(root.right, max, root.val);
    }
}
