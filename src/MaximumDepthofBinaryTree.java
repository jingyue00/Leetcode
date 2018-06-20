/**
 * Solution: Use the recursion to find maximum depth. Stop when root equals null
 *      each time get the max depth between left node and right node, and plus 1
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
