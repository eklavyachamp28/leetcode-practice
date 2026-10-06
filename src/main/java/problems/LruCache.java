package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 146 - LRU Cache. O(1) get/put using a hash map plus a doubly linked list
 * with sentinel head/tail nodes (most recently used next to head).
 */
public class LruCache {
    private static final class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) { this.key = key; this.value = value; }
    }

    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private final Node head = new Node(0, 0);
    private final Node tail = new Node(0, 0);

    public LruCache(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be > 0");
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node n = map.get(key);
        if (n == null) return -1;
        moveToFront(n);
        return n.value;
    }

    public void put(int key, int value) {
        Node n = map.get(key);
        if (n != null) {
            n.value = value;
            moveToFront(n);
            return;
        }
        if (map.size() == capacity) {
            Node lru = tail.prev;
            unlink(lru);
            map.remove(lru.key);
        }
        n = new Node(key, value);
        map.put(key, n);
        insertAfterHead(n);
    }

    private void moveToFront(Node n) { unlink(n); insertAfterHead(n); }

    private void unlink(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void insertAfterHead(Node n) {
        n.next = head.next;
        n.prev = head;
        head.next.prev = n;
        head.next = n;
    }
}
