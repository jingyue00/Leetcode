import java.util.HashMap;
import java.util.Map;

/**
 * Solution: Use a Hashmap to match each current node to a new RandonListNode.
 *      Then get next and random using the node mapping in the HashMap.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> mapping = new HashMap<>();
        RandomListNode cur = head;
        while (cur != null) {
            mapping.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            mapping.get(cur).next = mapping.get(cur.next);
            mapping.get(cur).random = mapping.get(cur.random);
            cur = cur.next;
        }
        return mapping.get(head);
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };
}
