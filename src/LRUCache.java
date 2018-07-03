import java.util.HashMap;

/**
 * Solution: Use LinkedHashMap both get(key) and put(key, value) operations
 *      in O(1) time complexity
 */
public class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = null;
        tail = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        if (node != tail) {
            moveNodeToTail(node);
        }
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            if (node != tail) {
                moveNodeToTail(node);
            }
        } else {
            Node newNode = new Node(key, value);
            if (capacity == 0) {
                Node tmp = head;
                head = head.next;
                map.remove(tmp.key);
                capacity ++;
            }
            if (head == null && tail == null) {
                head = newNode;
            } else {
                updateTail(newNode);
            }
            tail = newNode;
            map.put(key, newNode);
            capacity --;
        }
    }

    public void moveNodeToTail(Node node) {
        if (node == head) {
            head = head.next;
        } else {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
        updateTail(node);
        tail = node;
    }

    public void updateTail(Node node) {
        tail.next = node;
        node.prev = tail;
        node.next = null;
    }
}
