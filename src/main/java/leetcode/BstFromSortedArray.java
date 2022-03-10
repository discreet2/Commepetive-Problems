package leetcode;

public class BstFromSortedArray {
    //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
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

    private void printInOrderTraversal(TreeNode node) {
        if (node != null) {
            printInOrderTraversal(node.left);
            System.out.print(node.val + "->");
            printInOrderTraversal(node.right);
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return getBst(nums, 0, nums.length - 1);
    }

    private TreeNode getBst(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getBst(nums, start, mid - 1);
        root.right = getBst(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        BstFromSortedArray bst = new BstFromSortedArray();
        int nums[] = {-10, -3, 0, 5, 9};
        TreeNode root = bst.sortedArrayToBST(nums);
        bst.printInOrderTraversal(root);
    }
}
