package leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedList {
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

    public void print(ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        MergeKSortedList m = new MergeKSortedList();
        ListNode one = new ListNode(1);
        one.next = new ListNode(4);
        one.next.next = new ListNode(5);
        m.print(one);
        System.out.println();
        ListNode two = new ListNode(1);
        two.next = new ListNode(3);
        two.next.next = new ListNode(4);
        m.print(two);
        System.out.println();
        ListNode three = new ListNode(2);
        three.next = new ListNode(6);
        m.print(three);
        System.out.println();
        ListNode nodes[] = new ListNode[3];
        nodes[0] = null;
        nodes[1] = null;
        nodes[2] = null;
        ListNode res = m.mergeKLists(nodes);
        m.print(res);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int numbersOfListNodeLeft = lists.length;
        while (numbersOfListNodeLeft > 0) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node == null) {
                    list.add(i, Integer.MAX_VALUE);
                } else {
                    list.add(i, node.val);
                }
            }

            int ind = getMinIndex(list);
            if (ind == -1 || lists[ind].next == null) {
                numbersOfListNodeLeft--;
            }
            if (ind != -1) {
                current.next = lists[ind];
                lists[ind] = lists[ind].next;
                current = current.next;
            }

        }
        return dummy.next;
    }

    private int getMinIndex(List<Integer> list) {
        int currentMinIndex = -1;
        int currentMinVal = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < currentMinVal) {
                currentMinVal = list.get(i);
                currentMinIndex = i;
            }
        }
        return currentMinIndex;
    }
}
