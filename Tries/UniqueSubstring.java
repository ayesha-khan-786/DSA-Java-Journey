public class UniqueSubstring {

    static class Node {
        Node children[] = new Node[26];
        boolean eow;

        public Node() {
            for(int i=0 ; i<26 ; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();       

    public static void insert(String word) {
        int level = 0;
        int len = word.length();
        int idx = 0;

        Node curr = root;
        for(; level<len ; level++) {
           idx = word.charAt(level)-'a';                // ch - 'a' i.e for ch 'a' = 'a'-'a' = 0

            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();        // create new Node
            }

            curr = curr.children[idx];                  // update curr to next level
        }

        curr.eow = true;                                 // last letter of word
    }

    // Searching -> O(L)
    public static boolean search(String key) {
        int level = 0;
        int len = key.length();
        
         Node curr = root;
        for(; level<len ; level++) {
            int idx = key.charAt(level) - 'a';    

            if(curr.children[idx] == null) {
                return false;      
            }

            curr = curr.children[idx];                  
        }

        return curr.eow == true;                          
    }

    public static int countNodes(Node root) {
        if(root == null) {
            return 0;
        }

        int count = 0;
        for(int i=0 ; i<26 ; i++) {
            if(root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }

        return count+1;
    }

    public static void main(String args[]) {
        String str = "ababa";       // ans = 10

        // step 1 -> suffix
        for(int i=0 ; i<str.length() ; i++) {
             String suffix = str.substring(i);

              // step 2 -> insert suffix in trie
              insert(suffix);
        }

       System.out.println(countNodes(root));
    }
}

