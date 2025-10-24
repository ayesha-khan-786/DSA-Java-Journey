// Lowest common ancestor (Approach 2)

import java.util.*;

public class LCA2 {

     static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node lca2(Node root, int n1, int n2) {
      
      // Step 1 - compare with root
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }

      // Step 2 - find lca in left & right subtree  
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

      // Step 3 - leftLca -> returns valid val, rightLca -> null
        if(rightLca == null) {
            return leftLca;             // i.e in right side n1,n2 not exists
        }

        if(leftLca== null) {
            return rightLca;
        }

      // if both are not null i.e n1, n2 exists both side -> root is common ancestor
        return root;
    }
 

    public static void main(String args[]) {
        /*
            1
           / \
          2   3
         / \ / \
        4  5 6  7
        */
       Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.right.left = new Node(6);
       root.right.right = new Node(7);
        
        int n1 = 4;
        int n2 = 7;

        System.out.println(lca2(root, n1, n2).data);
    
    }
}

// TC = O(n)