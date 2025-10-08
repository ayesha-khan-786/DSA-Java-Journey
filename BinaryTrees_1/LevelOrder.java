import java.util.*;

public class LevelOrder {

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
        static int idx = -1;        
        
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

        // Level Order Traversal
        public static void levelOrder(Node root) {
            if(root == null) {
                return;
            }
    // Step 1 - Make a Queue to add ele
            Queue<Node>  q = new LinkedList<>();
            q.add(root);
            q.add(null);

    // Step 2 - Remove ele from queue & store in node
            while(!q.isEmpty()) {
                Node currNode = q.remove();
                if(currNode == null) {
                    System.out.println();       // print next line
                    if(q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    } 
                } else {
                        System.out.print(currNode.data + " ");      // if not null then print data
                        if(currNode.left != null) {
                            q.add(currNode.left);
                        }
                        if(currNode.right != null) {
                            q.add(currNode.right);
                        }
                    }
                }
            }
         
        }


    public static void main(String args[]) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
       
        tree.levelOrder(root);
    }
}

// Time Complexity = O(n)