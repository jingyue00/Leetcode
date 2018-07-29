import java.util.LinkedList;
import java.util.Queue;

/**
 * 449. Serialize and Deserialize BST
 *
 * Serialization is the process of converting a data structure or object
 * into a sequence of bits so that it can be stored in a file or memory buffer,
 *
 * or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary search tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary search tree can be serialized to a string
 * and this string can be deserialized to the original tree structure.
 *
 * Solution: Use queue do the level traversal
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class SerializeandDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("null ");
                continue;
            }
            sb.append(cur.val + " ");
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
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
