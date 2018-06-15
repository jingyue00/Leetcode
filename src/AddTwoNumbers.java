/**
 * Solution: input are two ListNodes, we need consider carry bit.
 *      use while and if to check whether two ListNode equal null, if not add value to sum
 *      if sum more than 9, next unit will add 1.
 *      * Important: check carry bit after while loop (19 + 21 -> 301)
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(sum % 10);
            sum /= 10;
            cur = cur.next;
        }
        if (sum == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers at = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        ListNode n1 = l1;
        n1.next = new ListNode(4);
        n1 = n1.next;
        n1.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode n2 = l2;
        n2.next = new ListNode(6);
        n2 = n2.next;
        n2.next = new ListNode(4);
        System.out.println(at.addTwoNumbers(l1, l2).next.next.val);
    }
}


