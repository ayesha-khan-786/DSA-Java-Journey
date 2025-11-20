// Question 1 :Range Sum of BST
import java.util.*;

public class Assign1 {

     static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static int RangeSumBST(Node root, int left, int right) {
        if(root == null) {
            return 0;
        }

        int sum = 0;

        if(root.data >= left && root.data <= right) {       // if root is in range add in sum
            sum += root.data;
        }

        if(root.data > left) {
            sum += RangeSumBST(root.left, left, right);     // if range is in left subtree, check in left
        }

        if(root.data < right) {
            sum += RangeSumBST(root.right, left, right);    // if range is in right subtree, check in right
        }

        return sum;

    }

    public static void main(String args[]) {
        /*
                10
               / \
              5   15
             / \    \
            3   7   18
         */
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right = new Node(15);
        root.right.right = new Node(18);

        int left = 7;
        int right = 15;

        System.out.println(RangeSumBST(root, left, right));
    }
}