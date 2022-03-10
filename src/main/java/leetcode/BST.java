package leetcode;

import java.util.Stack;

public class BST {
    private Node root;

    public static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    public void add(int key) {
        Node node = new Node(key);
        if (root == null) {
            root = node;
            return;
        }
        Node temp = root, prev = null;
        while (temp != null) {
            prev = temp;
            if (temp.key > key) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if (prev.key > key) {
            prev.left = node;
        } else {
            prev.right = node;
        }
    }

    public void inorderTraversal() {
        printInOrderTraversal(root);
    }

    private void printInOrderTraversal(Node node) {
        if (node != null) {
            printInOrderTraversal(node.left);
            System.out.print(node.key + "->");
            printInOrderTraversal(node.right);
        }
    }

    public void inorderLoop() {
        Node temp = root;
        Stack<Node> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.key + "->");
                temp = temp.right;
            }
        }
    }

    public void preOrderTraversal() {
        printPreOrderTraversal(root);
    }

    private void printPreOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.key + "->");
            printPreOrderTraversal(node.left);
            printPreOrderTraversal(node.right);
        }
    }

    public void preOrderLoop() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            System.out.print(n.key + "->");
            if (n.right != null) {
                stack.push(n.right);
            }
            if (n.left != null) {
                stack.push(n.left);
            }
        }
    }

    public void postOrderTraversal() {
        printPostOrderTraversal(root);
    }

    private void printPostOrderTraversal(Node node) {
        if (node != null) {
            printPostOrderTraversal(node.left);
            printPostOrderTraversal(node.right);
            System.out.print(node.key + "->");
        }
    }

    public Node search(int key) {
        Node temp = root;
        while (temp != null) {
            if (temp.key == key) return temp;
            else if (temp.key > key) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        BST bst = new BST();
        bst.add(4);
        bst.add(6);
        bst.add(2);
        bst.add(8);
        bst.add(3);
        bst.inorderTraversal();
        System.out.println();
        bst.inorderLoop();
        System.out.println();
        bst.preOrderTraversal();
        System.out.println();
        bst.preOrderLoop();
        System.out.println();
        bst.postOrderTraversal();
        System.out.println();
        Node s1 = bst.search(8);
        Node s2 = bst.search(5);
        if (s1 != null) {
            System.out.println("found" + s1.key);
        } else {
            System.out.println("8 key not found");
        }
        if (s2 != null) {
            System.out.println("found" + s2.key);
        } else {
            System.out.println("5 key not found");
        }
    }
}
