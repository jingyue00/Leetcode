import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution: Use stack to save all the node. Then we can add them from the tail.
 *      Important, since add from end, each time don't forget to create a new head.
 *      new head can equal carry.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = new LinkedList<>();
        Deque<ListNode> stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.offerFirst(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.offerFirst(l2);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int value1 = stack1.isEmpty() ? 0 : stack1.pollFirst().val;
            int value2 = stack2.isEmpty() ? 0 : stack2.pollFirst().val;
            int sum = value1 + value2 + carry;
            cur.val = sum % 10;
            ListNode newNode = new ListNode(sum / 10);
            newNode.next = cur;
            cur = newNode;
            carry = sum / 10;
        }
        return carry != 0 ? cur : cur.next;
    }
}
