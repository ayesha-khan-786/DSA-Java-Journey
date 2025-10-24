// Lowest common ancestor (Approach 1)

import java.util.*;

public class LCA {

     static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if(root == null) {
            return false;
        }
       
        //Add node in path
        path.add(root);

        if(root.data == n) {        // Node found 
            return true;
        }

        // if node not found in root then go to subtree
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight) {
            return true;
        }

    // if node not found in this path then remove 
        path.remove(path.size()-1);
        return false;

    }

    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

    // To store path from root to node 
        getPath(root, n1, path1);
        getPath(root, n2, path2);

    // calculate last common ancestor
        int i = 0;
        for(i=0 ; i<path1.size() && i<path2.size() ; i++ ) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
        }

    // last equal node will be i-1th node bcoz loop vl run until node is common
        Node lca = path1.get(i-1);
        return lca;
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
        int n2 = 5;

        System.out.println(lca(root, n1, n2).data);
    
    }
}

// TC = O(n)