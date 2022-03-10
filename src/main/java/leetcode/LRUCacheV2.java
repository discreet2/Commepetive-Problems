package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheV2 {
    class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = next = null;
        }
    }

    private Node head, tail;
    private int capacity;
    private Map<Integer, Node> map;

    private void removeNode(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void addNodeToHead(Node n) {
        Node nn = head.next;
        n.prev = head;
        head.next = n;
        n.next = nn;
        nn.prev = n;

    }

    public LRUCacheV2(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node n = map.get(key);
        removeNode(n);
        addNodeToHead(n);
        return n.value;
    }

    public void put(int key, int value) {
        boolean checkSize = true;
        if (map.containsKey(key)) {
            Node n = map.get(key);
            map.remove(key);
            removeNode(n);
            checkSize = false;
        }
        if (checkSize && map.size() == capacity) {
            Node d = tail.prev;
            map.remove(d.key);
            removeNode(d);
        }
        Node newNode = new Node(key, value);
        addNodeToHead(newNode);
        map.put(key, newNode);
    }

    public void print() {
        Node current = head.next;
        while (current != null) {
            if (current.key != -1 && current.value != -1) {
                System.out.print("(" + current.key + "," + current.value + ")");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCacheV2 lRUCache = new LRUCacheV2(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.print();
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.print();
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.print();
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.print();
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.print();
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.print();
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        lRUCache.print();
        System.out.println(lRUCache.get(3));    // return 3
        lRUCache.print();
        System.out.println(lRUCache.get(4));    // return 4
        lRUCache.print();

    }

}