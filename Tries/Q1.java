// Group Anagrams
import java.util.*;
public class Q1 {

    static class Node {
        Node children[] = new Node[26];
        boolean endOfWord = false;
        List<String> data = new ArrayList<>();       // stores original words

        Node() {
            for(int i=0 ; i<26 ; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();
    static List<List<String>> ans;       

    public List<List<String>> groupAnagrams(String[] strs) {
       
        ans = new ArrayList<>();
        root = new Node();

         // Insert each word into trie
        for(String word : strs) {
            build(word);
        }

        // DFS to collect grouped anagrams
        dfs(root);
        return ans;
    }

    // Insert sorted word into trie
    public void build(String s) {
        Node temp = root;
        
        char[] word = s.toCharArray();
        Arrays.sort(word);
        
        for (char c : word) {
            int idx = c - 'a';
            if (temp.children[idx] == null) {
                temp.children[idx] = new Node();
            }
            temp = temp.children[idx];
        }
            temp.endOfWord = true;
            temp.data.add(s);           // store original word
            }

    public void dfs(Node rt) {
        if(rt.endOfWord) {
            ans.add(rt.data);
        } 
        for(int i=0; i<26; i++) {
            if(rt.children[i] !=null)
            dfs(rt.children[i]);
            }
        }

    public static void main(String args[]) {
         Q1 obj = new Q1();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = obj.groupAnagrams(strs);
        System.out.println(result);
    }
}

