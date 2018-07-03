/**
 * Solution: use recursion to check root.left and root.right.
 *      base case return when root == null || root == p || root == q
 *      if both left and right not equal to null, return root
 *      else return node which is not equal to null
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
