package leetcode;

import java.util.Stack;

//https://leetcode.com/problems/validate-binary-search-tree/
public class BSTValidate {
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

    public void inorderLoop(TreeNode root) {
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.val + "->");
                temp = temp.right;
            }
        }
        System.out.println();
    }

    public boolean isValidBST2(TreeNode root) {
        return isValidBSTRecursive(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTRecursive(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBSTRecursive(root.left, min, root.val) && isValidBSTRecursive(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        long currVal = Long.MIN_VALUE;
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                if (currVal >= temp.val) {
                    return false;
                } else {
                    currVal = temp.val;
                    temp = temp.right;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode root = new TreeNode(2, one, three);
        BSTValidate bst = new BSTValidate();
        bst.inorderLoop(root);
        System.out.println(bst.isValidBST(root));
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t4 = new TreeNode(4, t3, t6);
        TreeNode t1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(5, t1, t4);
        bst.inorderLoop(root2);
        System.out.println(bst.isValidBST2(root2));
    }
}
