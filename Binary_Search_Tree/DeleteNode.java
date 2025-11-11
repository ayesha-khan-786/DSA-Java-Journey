// Build a BST
import java.util.*;

public class DeleteNode {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }

        if(root.data > val) {
            // insert in left subtree
            root.left = insert(root.left, val);
        } else {
            // insert in right subtree
            root.right = insert(root.right, val);
        }

        return root;
        
    }

    public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static Node delete(Node root, int val) {
        if(root.data < val) {
            root.right = delete(root.right, val);
        }
        else if(root.data > val) {
            root.left = delete(root.left, val);
        }
        else {  // voila case
        // case 1 -> leaf node
            if(root.left == null && root.right == null) {
                return null;
            }

        // case 2 -> one child
            if(root.left == null) {
            return root.right;
            }
            else if(root.right == null) {
            return root.left;
            }
        // case 3 -> two children
            // find inorder successor
            Node IS = findInorderSuccessor(root.right);

            // replace root data with IS
            root.data = IS.data;

            // delete IS Node
            root.right = delete(root.right, IS.data);

        }

        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String args[]) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i=0 ; i<values.length ; i++) {
            root = insert(root, values[i]);
        }

        System.out.println("Before deletion of Node : ");
        inorder(root);
        System.out.println();

        root = delete(root, 5);
        System.out.println();

        System.out.println("After deletion of Node : ");
        inorder(root);
    }
}