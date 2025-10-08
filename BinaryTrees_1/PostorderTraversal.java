import java.util.*;

public class PostorderTraversal {

    static class Node {
        int data;
        Node left;
        Node right;

        // constructor
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;        // static bcoz idx should update at each level
        
        public static Node buildTree(int nodes[]) {
            idx++;

            if(idx >= nodes.length) {
                return null;
            }
            
            if(nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

       public static void postorder(Node root) {
        if(root == null) {
            return;
        }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
       }
    }

    public static void main(String args[]) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
       
        tree.postorder(root);
    }
}

// Time Complexity = O(n)