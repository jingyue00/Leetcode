import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 545. Boundary of Binary Tree
 *
 * Given a binary tree,
 * return the values of its boundary in anti-clockwise direction starting from root.
 *
 * Boundary includes left boundary, leaves,
 * and right boundary in order without duplicate nodes.
 *
 * Left boundary is defined as the path from root to the left-most node.
 * Right boundary is defined as the path from root to the right-most node.
 * If the root doesn't have left subtree or right subtree,
 * then the root itself is left boundary or right boundary.
 *
 * Note this definition only applies to the input binary tree,
 * and not applies to any subtrees.
 * The left-most node is defined as a leaf node you could reach
 * when you always firstly travel to the left subtree if exists.
 *
 * If not, travel to the right subtree.
 * Repeat until you reach a leaf node.
 * The right-most node is also defined by the same way with left and right exchanged.
 *
 * Solution: use recursion go through left node, then leaves, then right node. Use HashSet to avoid
 *      duplicate, Important: right node add from down to up.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class BoundaryofBinaryTree {
    List<Integer> res = new LinkedList<>();
    Set<TreeNode> set = new HashSet<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        getLeftBound(root.left);
        getLeaves(root.left);
        getLeaves(root.right);
        getRightBound(root.right);
        return res;
    }
    public void getLeftBound(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (!set.contains(root)) {
            set.add(root);
            res.add(root.val);
        }
        if (root.left == null) {
            getLeftBound(root.right);
        } else {
            getLeftBound(root.left);
        }
    }

    public void getLeaves(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (!set.contains(root)) {
                set.add(root);
                res.add(root.val);
            }
        }
        if (root.left != null) {
            getLeaves(root.left);
        }
        if (root.right != null) {
            getLeaves(root.right);
        }
    }

    public void getRightBound(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (root.right == null) {
            getRightBound(root.left);
        } else {
            getRightBound(root.right);
        }
        if (!set.contains(root)) {
            set.add(root);
            res.add(root.val);
        }
    }

}
