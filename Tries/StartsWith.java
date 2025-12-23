public class StartsWith {

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

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

    public static boolean startsWith(String prefix) {
        Node curr = root;

        for(int i=0 ; i<prefix.length() ; i++) {
            int idx = prefix.charAt(i) -'a';
            if(curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return true;
    }

    public static void main(String args[]) {
        String words[] = {"apple", "app", "mango", "man", "woman"};
        String prefix1 = "app";     // true
        String prefix2 = "moon";    // false

        for(int i=0 ; i<words.length ; i++) {
            insert(words[i]);
        }
     
     System.out.println(startsWith(prefix1));
     System.out.println(startsWith(prefix2));
    }
}

// TC = O(L) -> L = Length of Prefix