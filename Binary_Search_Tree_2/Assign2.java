//Question 5 :Maximum Sum BST in Binary Tree
public class Assign2 {

     static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private int ans = 0;

    public static class BSTInfo {
        boolean isBST;
        int minVal;
        int maxVal;
        int sum;

        BSTInfo(boolean isBST, int minVal, int maxVal, int sum) {
            this.isBST = isBST;
            this.minVal = minVal;
            this.maxVal = maxVal;
            this.sum = sum;
        }
    }

    public int maxSumBST(Node root) {
        ans = 0;
        postorder(root);
        return ans;
    }

     private BSTInfo postorder(Node root) {
        if(root == null) {
            return new BSTInfo(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        BSTInfo leftInfo = postorder(root.left);
        BSTInfo rightInfo = postorder(root.right);

        int currSum = root.data + leftInfo.sum + rightInfo.sum;

        if(leftInfo.isBST && rightInfo.isBST &&
            root.data > leftInfo.maxVal && root.data < rightInfo.minVal) {

                ans = Math.max(ans, currSum);       // it is valid BST
           
            return new BSTInfo(
                true,
                Math.min(root.data, leftInfo.minVal),
                Math.max(root.data, rightInfo.maxVal),
                currSum
            );
         }

                return new BSTInfo(false, 0, 0, 0);
        
     }

    public static void main(String args[]) {
         /*
                5
               / \
              9   2
             /     \
            6       3
           / \
          8   7
         */

         Assign2 obj = new Assign2();
        Node root = new Node(5);
        root.left = new Node(9);
        root.left.left = new Node(6);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(7);
        root.right = new Node(2);
        root.right.right = new Node(3);
      
      System.out.println("Maximum Sum BST is : " + obj.maxSumBST(root));

    }
}