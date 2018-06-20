import java.util.Deque;
import java.util.LinkedList;

/**
 * Requirement： design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * Solution: in order to let time of getMin() is constant, have a minStack
 *      Important: minStack cannot only save the smallest value since after pop, minStack could be empty
 *      the method to solve this problem is poll the value into minStack if x <= minStack.peek()
 * time : O(1)
 * space : O(n)
 */
public class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.offerFirst(x);
        if (minStack.isEmpty()) {
            minStack.offerFirst(x);
        } else {
            if (x <= minStack.peekFirst()) {
                minStack.offerFirst(x);
            }
        }
    }

    public void pop() {
        int output = stack.pollFirst();
        if (!minStack.isEmpty()) {
            if (minStack.peekFirst() == output) {
                minStack.pollFirst();
            }
        }
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return minStack.peek();
    }
}
