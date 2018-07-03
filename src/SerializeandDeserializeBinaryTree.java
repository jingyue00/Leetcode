import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution: Use queue to BFS the Binary Tree.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                res.append("null ");
                continue;
            }
            res.append(cur.val + " ");
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] array = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < array.length; i++) {
            TreeNode cur = queue.poll();
            if (!array[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(array[i]));
                queue.offer(cur.left);
            }
            if (!array[++i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(array[i]));
                queue.offer(cur.right);
            }
        }
        return root;
    }
}
