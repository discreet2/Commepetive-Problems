package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class BSTMinDepth {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //BFS
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int minDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curr;
        int l;
        boolean leafFound = false;
        while (!queue.isEmpty()) {
            l = queue.size();
            minDepth++;
            while (l > 0) {
                curr = queue.poll();
                if (curr.left == null && curr.right == null) {
                    leafFound = true;
                    break;
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                l--;
            }
            if (leafFound) break;

        }
        return minDepth;

    }

    //DFS
    public int minDepth2(TreeNode root) {
        return getMinDepth(root);
    }

    private int getMinDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.right == null && root.left != null) return getMinDepth(root.left) + 1;
        if (root.left == null && root.right != null) return getMinDepth(root.right) + 1;
        return Math.min(getMinDepth(root.left), getMinDepth(root.right)) + 1;
    }


    public static void main(String[] args) {
        BSTMinDepth bst = new BSTMinDepth();
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20, t15, t7);
        TreeNode t3 = new TreeNode(3, t9, t20);
        System.out.println(bst.minDepth(t3));
        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1, null, t2);
        System.out.println(bst.minDepth(t1));
        TreeNode tt4 = new TreeNode(4);
        TreeNode tt5 = new TreeNode(5);
        TreeNode tt3 = new TreeNode(3);
        TreeNode tt2 = new TreeNode(2, tt4, tt5);
        TreeNode tt1 = new TreeNode(1, tt2, tt3);
        System.out.println(bst.minDepth(tt1));

    }
}
