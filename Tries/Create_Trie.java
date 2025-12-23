public class Create_Trie {

    static class Node {
        Node children[] = new Node[26];
        boolean endOfWord = false;

        Node() {
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

        curr.endOfWord = true;                          // last letter of word
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

        return curr.endOfWord == true;                          
    }

    public static void main(String args[]) {
        String words[] = {"the", "a", "there", "their", "any", "thee"};

        for(int i=0 ; i<words.length ; i++) {
            insert(words[i]);
        }

        System.out.println(search("thee"));         // true
        System.out.println(search("thor"));         // false
        System.out.println(search("any"));   
    }
}

// TC = O(L) -> L = largest word length