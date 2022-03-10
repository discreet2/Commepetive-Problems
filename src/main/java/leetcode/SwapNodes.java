package leetcode;

public class SwapNodes {
    //https://leetcode.com/problems/swap-nodes-in-pairs/
    public void print(ListNode l) {
        ListNode c = l;
        while (c != null) {
            System.out.print(c.val + "->");
            c = c.next;
        }
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            ListNode current = prev.next;
            ListNode forward = current.next;
            ListNode temp = forward.next;

            prev.next = forward;
            forward.next = current;
            current.next = temp;
            prev = current;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        SwapNodes addTwoNumbers = new SwapNodes();
        ListNode l1 = new ListNode(2);
         l1.next = new ListNode(4);
         l1.next.next = new ListNode(3);
         l1.next.next.next=new ListNode(5);
        addTwoNumbers.print(l1);

        addTwoNumbers.print(addTwoNumbers.swapPairs(l1));

    }

}
