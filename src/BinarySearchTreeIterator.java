import java.util.Deque;
import java.util.LinkedList;

/**
 * 173. Binary Search Tree Iterator
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory
 * where h is the height of the tree.
 *
 * Solution: Use stack to save the smaller node, go through left node until equals null
 *      then check right node
 * Time Complexity: next() and hasNext() run in average O(1) time
 * Space Complexity: O(h) - h is height of tree
 */

public class BinarySearchTreeIterator {

    public class BSTIterator {

        private TreeNode cur;
        private Deque<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            cur = root;
            stack = new LinkedList<>();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            if (!stack.isEmpty() || cur != null) {
                return true;
            }
            return false;
        }

        /** @return the next smallest number */
        public int next() {
            while (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            }
            cur = stack.pollFirst();
            int value = cur.val;
            cur = cur.right;
            return value;
        }
    }

}
