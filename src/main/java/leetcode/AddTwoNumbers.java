package leetcode;

public class AddTwoNumbers {
    //https://leetcode.com/problems/add-two-numbers/
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null || l2 != null) {
            int num1 = 0;
            int num2 = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }
            int sum = num1 + num2 + carry;
            ListNode n = new ListNode(sum % 10);
            current.next = n;
            current = current.next;
            carry = sum / 10;
        }
        if (carry > 0) {
            ListNode n = new ListNode(carry);
            current.next = n;
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        addTwoNumbers.print(l1);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(8);
        addTwoNumbers.print(l2);
        addTwoNumbers.print(addTwoNumbers.addTwoNumbers(l1, l2));

    }

}
