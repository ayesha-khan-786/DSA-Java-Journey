// Question 5 :Maximum Path Sum in a Binary Tree

import java.util.*;

public class Assig4 {

     static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public int helper(Node root, int[] res) {
        if(root == null) {
            return 0;
        }

        int left = Math.max(0, helper(root.left, res));
        int right = Math.max(0, helper(root.right, res));

        res[0] = Math.max(res[0], root.data+left+right);

        return root.data + Math.max(left, right);
    }

    public int maxPathSum(Node root) {
        int[] res = {Integer.MIN_VALUE};

        helper(root, res);
        return res[0];
    }
 
    public static void main(String args[]) {
    /*
           -10
           / \
          9   20
              / \ 
             15  7
     */
    Node root = new Node(-10);
    root.left = new Node(9);
    root.right = new Node(20);
    root.right.left = new Node(15);
    root.right.right = new Node(7);

    Assig4 obj = new Assig4();
    System.out.println("Maximum Path Sum: " + obj.maxPathSum(root));
}

}

// Time Complexity = O(n)