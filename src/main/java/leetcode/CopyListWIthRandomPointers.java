package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWIthRandomPointers {
    //https://leetcode.com/problems/copy-list-with-random-pointer/
    public void print(Node l) {
        Node c = l;
        while (c != null) {
            Integer random = null;
            if (c.random != null) {
                random = c.random.val;
            }
            System.out.print(c.val + "," + random + "->");
            c = c.next;
        }
        System.out.println();
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }
        current = head;
        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        Node thirteen = new Node(13);
        Node eleven = new Node(11);
        Node ten = new Node(10);
        Node one = new Node(1);
        head.next = thirteen;
        thirteen.next = eleven;
        eleven.next = ten;
        ten.next = one;
        thirteen.random = head;
        eleven.random = one;
        ten.random = eleven;
        one.random = head;
        CopyListWIthRandomPointers clwrp = new CopyListWIthRandomPointers();
        clwrp.print(head);
        clwrp.print(clwrp.copyRandomList(head));
    }
}
