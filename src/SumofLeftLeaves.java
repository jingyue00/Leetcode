/**
 * 404. Sum of Left Leaves
 *
 * Find the sum of all left leaves in a given binary tree.
 * Example:
 *   3
 *  / \
 * 9  20
 *   /  \
 * 15   7
 *
 * There are two left leaves in the binary tree,
 * with values 9 and 15 respectively. Return 24.
 *
 * Solution: Each time check left and right node. Only root.left.left == null
 *      && root.left.right == null, add node value to result
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class SumofLeftLeaves {
    int res;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                res += root.left.val;
            } else {
                sumOfLeftLeaves(root.left);
            }
        }
        if (root.right != null) {
            if (root.right.left != null || root.right.right != null) {
                sumOfLeftLeaves(root.right);
            }
        }
        return res;
    }
}
