// Question 3 :Delete leaf nodes with values as x

import java.util.*;

public class Assig3 {

     static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node removeLeafNode(Node root, int target) {
        if(root == null) {
            return null;
        }

        root.left = removeLeafNode(root.left, target);
        root.right = removeLeafNode(root.right, target);

        if(root.left == null && root.right == null && root.data == target) {
            return null;
        }

        return root;
    }
 

    private static void printInOrder(Node root) {
        if(root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void main(String args[]) {
    /*
            1
           / \
          3   3
         / \ 
        3  2 
     */
    Node root = new Node(1);
    root.left = new Node(3);
    root.right = new Node(3);
    root.left.left = new Node(3);
    root.left.right = new Node(2);

    int target = 3;

    root = removeLeafNode(root, target);

    printInOrder(root);

}

}