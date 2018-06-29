import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution: use queue to go through each level, reverse the list if number of level
 *      is even
 * Time Complexity: O(n) ? O(n ^ 2)
 * Space Complexity: O(n)
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            while (curSize > 0) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
                curLevel.add(curNode.val);
                curSize --;
            }
            if (level % 2 == 0) Collections.reverse(curLevel);
            level ++;
            res.add(curLevel);
        }
        return res;
    }
}
