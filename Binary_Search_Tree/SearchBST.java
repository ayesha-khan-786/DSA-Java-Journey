// Search in BST
import java.util.*;

public class SearchBST {

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

    public static boolean search(Node root, int key) {
        // case 1 -> root is null
        if(root == null) {
            return false;
        }

        // case 2 -> root is equal to key
        if(root.data == key) {
            return true;
        }

        //case 3 -> search in left subtree
        if(root.data > key) {
            return search(root.left, key);
        } 
        else {
        
        // case 4 -> search in right subtree
            return search(root.right, key);
        }
    }

    public static void main(String args[]) {
         int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;

        for(int i=0 ; i<values.length ; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        if(search(root, 1)) {
            System.out.println("Key found!");
        } else {
            System.out.println("Key Not Found");
        }
    }
}

// Time COmplexity = O(H), where H -> height of tree