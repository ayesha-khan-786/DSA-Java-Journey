// Q 1 -> Bottom View oa a Binary Tree
import java.util.*;

public class Q1 {

    // Node class
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Pair class
        class Pair {
            Node node;
            int hd;         // horizontal distance i.e idx

            Pair(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

    // Funct to return a list containing the bottom view of given tree
        public ArrayList<Integer> bottomView(Node root) {
            ArrayList<Integer> ans = new ArrayList<>();

        // Queue to store node and its hd
        Queue<Pair> q = new LinkedList<>();

        // TreeMap to store largest node at each horizontal distance(sorted order)
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Start BFS from root at hd = 0
        q.add(new Pair(root, 0));

        while(!q.isEmpty()) {
            Pair current = q.poll();
            Node currNode = current.node;
            int dist = current.hd;

            // Update map with latest node at this hd
            map.put(dist, currNode.data);

            //Add left child with hd-1
            if(currNode.left != null) {
                q.add(new Pair(currNode.left, dist-1));
            }

            //Add right child with hd+1
            if(currNode.right != null) {
                q.add(new Pair(currNode.right, dist+1));
            } 
        }

        // Add values from TreeMap to ans list
        for(int val : map.values()) {
            ans.add(val);
        }

        return ans;
        }


    public static void main(String args[]) {

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        Q1 obj = new Q1();
        System.out.println("Bottom view of the given binary tree:");
        System.out.println(obj.bottomView(root));
        
}

}