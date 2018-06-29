import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution: use two stack to implement queue. Important: pop, peek need to first
 *      check empty of stack2, if empty, put all integer in stack1 to stack2
 */
public class ImplementQueueusingStacks {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    /** Initialize your data structure here. */
    public ImplementQueueusingStacks() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.offerFirst(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pollFirst();
        } else {
            while (!stack1.isEmpty()) {
                stack2.offerFirst(stack1.pollFirst());
            }
            return stack2.pollFirst();
        }
    }

    /** Get the front element. */
    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peekFirst();
        }else {
            while (!stack1.isEmpty()) {
                stack2.offerFirst(stack1.pollFirst());
            }
            return stack2.peekFirst();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (stack1.isEmpty() && stack2.isEmpty());
    }
}
