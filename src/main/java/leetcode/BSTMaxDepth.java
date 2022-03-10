package leetcode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class BSTMaxDepth {
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
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curr;
        while (!queue.isEmpty()) {
            int l = queue.size();
            while (l > 0) {
                curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                l--;
            }
            depth++;
        }
        return depth;

    }
    //DFS
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        return getMaxNode(root, 0);
    }

    private int getMaxNode(TreeNode root, int depth) {
        if (root == null) return depth;
        int leftDepth = getMaxNode(root.left, depth + 1);
        int rightDepth = getMaxNode(root.right, depth + 1);
        return Math.max(leftDepth, rightDepth);

    }

    public static void main(String[] args) {
        BSTMaxDepth bst = new BSTMaxDepth();
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20, t15, t7);
        TreeNode t3 = new TreeNode(3, t9, t20);
        System.out.println(bst.maxDepth(t3));
        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1, null, t2);
        System.out.println(bst.maxDepth(t1));

    }
}
