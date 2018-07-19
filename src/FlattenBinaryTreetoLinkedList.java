import java.util.Deque;
import java.util.LinkedList;

/**
 * * 114. Flatten Binary Tree to Linked List
 * Given a binary tree, flatten it to a linked list in-place.
 * For example, Given
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 * The flattened tree should look like:
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * Solution: use stack to save tree node, like tree PreOrder traverse, first check and save
 *      right node, then check and save left node.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollFirst();
            if (node.right != null) stack.offerFirst(node.right);
            if (node.left != null) stack.offerFirst(node.left);
            if (!stack.isEmpty()) {
                node.right = stack.peekFirst();
            }
            node.left = null;
        }
    }

    TreeNode prev = null;
    public void flattenI(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
