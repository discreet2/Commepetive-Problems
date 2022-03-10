package leetcode;

public class BSTBalancedValidate {
    //https://leetcode.com/problems/balanced-binary-tree
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


    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        else if (root.left == null && root.right == null) return true;
        else return dfs(root) != -1;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int lHeight = dfs(root.left);
        if (lHeight == -1) return -1;

        int rHeight = dfs(root.right);
        if (rHeight == -1) return -1;

        if (Math.abs(lHeight - rHeight) > 1) return -1;
        else return 1 + Math.max(lHeight, rHeight);
    }

    public static void main(String[] args) {
        BSTBalancedValidate bst = new BSTBalancedValidate();
        System.out.println(bst.isBalanced(null));
        TreeNode t7 = new TreeNode(7);
        TreeNode t9 = new TreeNode(9);
        TreeNode t15 = new TreeNode(15);
        TreeNode t20 = new TreeNode(20, t15, t7);
        TreeNode t3 = new TreeNode(3, t9, t20);
        System.out.println(bst.isBalanced(t3));

        TreeNode l1 = new TreeNode(4);
        TreeNode l2 = new TreeNode(4);
        TreeNode l3 = new TreeNode(3);
        TreeNode l4 = new TreeNode(2);
        TreeNode tt3 = new TreeNode(3, l1, l2);
        TreeNode tt2 = new TreeNode(2, tt3, l3);
        TreeNode tt1 = new TreeNode(1, tt2, l4);
        System.out.println(bst.isBalanced(tt1));

        TreeNode ll3 = new TreeNode(3);
        TreeNode ll2 = new TreeNode(2, null, ll3);
        TreeNode ll1 = new TreeNode(1, null, ll2);
        System.out.println(bst.isBalanced(ll1));

        TreeNode tn8 = new TreeNode(8);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn6 = new TreeNode(6);
        TreeNode tn4 = new TreeNode(4, tn8, null);
        TreeNode tn2 = new TreeNode(2, tn4, tn5);
        TreeNode tn3 = new TreeNode(3, tn6, null);
        TreeNode tn1 = new TreeNode(1, tn2, tn3);
        System.out.println(bst.isBalanced(tn1));
    }
}
