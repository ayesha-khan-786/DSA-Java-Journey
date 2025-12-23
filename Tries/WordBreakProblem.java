public class WordBreakProblem {

    static class Node {
        Node children[] = new Node[26];     // 26 -> 'a' - 'z'
        boolean eow = false;

        public Node() {
            for(int i=0 ; i<26 ; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();       // by default null

    public static void insert(String word) {
        Node curr = root;
        for(int level=0 ; level<word.length() ; level++) {
            int idx = word.charAt(level) - 'a';     // ch - 'a' i.e for ch 'a' = 'a'-'a' = 0

            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();        // create new Node
            }

            curr = curr.children[idx];                  // update curr to next level
        }

        curr.eow = true;                          // last letter of word
    }

    // Searching -> O(L)
    public static boolean search(String key) {
         Node curr = root;
        for(int level=0 ; level<key.length() ; level++) {
            int idx = key.charAt(level) - 'a';    

            if(curr.children[idx] == null) {
                return false;      
            }

            curr = curr.children[idx];                  
        }

        return curr.eow == true;                          
    }

    public static boolean wordBreak(String key) {       // O(L)
        if(key.length() == 0) {                        // only 1st part exists
            return true;                
        }

        for(int i=1 ; i<=key.length() ; i++) {
           if(search(key.substring(0, i)) &&            // call for 1st part
            wordBreak(key.substring(i))) {               // in java i is treat as beginning idx
                return true;
            }       
        }

        return false;
    }

    public static void main(String args[]) {
        String arr[] = {"i", "like", "sam", "samsung", "mobile", "ice"};

        for(int i=0 ; i<arr.length ; i++) {
            insert(arr[i]);
        }

        String key = "ilikesamsung";
        System.out.println(wordBreak(key));
    }
}

