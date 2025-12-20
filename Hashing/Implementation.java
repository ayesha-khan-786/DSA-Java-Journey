import java.util.*;

public class Implementation {

    static class HashMap<K,V> {     // <K,V> -> generic -> when data types r not fixed
        
        private class Node {        // store types of node in LL
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;                       // n
        private int N;
        private LinkedList<Node> buckets[];     // N = buckets.length

        @SuppressWarnings("unchecked")

        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];       // create bucket hvg 4 idx
            for(int i=0 ; i<4 ; i++) {
                this.buckets[i] = new LinkedList<>();       // to make LL in each bucket
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;     // to get value in range 0 to 3(size-1)
        }

        private int SearchInLL(K key, int bi) {     // search in LL
            LinkedList<Node> ll = buckets[bi];      // find LL of nodes by going on bi[]
            int di = 0;

            for(int i=0 ; i<ll.size() ; i++) {
                Node node = ll.get(i);
                if(node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

     @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBuck[] = buckets;     // store old buckets
            buckets = new LinkedList[N*2];
            N = 2*N;

            for(int i=0 ; i<buckets.length ; i++) {
                buckets[i] = new LinkedList<>();
            }

             // put old bucket val in new bucket
            for(int i=0; i<oldBuck.length ; i++) {
                LinkedList<Node> ll = oldBuck[i];
                 for(int j=0 ; j<ll.size() ; j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                 }
            }
        }
    
        public void put(K key, V value) {               // O(lambda) -> O(1)
            int bi = hashFunction(key);                 // step 1 -> find bucket idx
            int di = SearchInLL(key, bi);               // step 2 -> search in LL return data idx
        
            if(di != -1) {                              // key exists
                Node node = buckets[bi].get(di);        // update
                node.value = value;
            } else {                                    // create new node
                buckets[bi].add(new Node(key,value));
                n++;
            }

            // Rehashing
            double lambda = (double)n/N;
            if(lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {         // O(1)
            int bi = hashFunction(key);                 
            int di = SearchInLL(key, bi);               
        
            if(di != -1) {       // valid value                       
               return true;
            } else {                                   
               return false;
            }
        }

        public V remove(K key) {         // O(1)
             int bi = hashFunction(key);                
            int di = SearchInLL(key, bi);               
        
            if(di != -1) {                              
                Node node = buckets[bi].remove(di);  
                n--;      
                return node.value;
            } else {                                    
                return null;
            }
        }

        public V get(K key) {        // O(1)
           int bi = hashFunction(key);                 
           int di = SearchInLL(key, bi);               
        
            if(di != -1) {                               
               Node node = buckets[bi].get(di);        
               return node.value;
            } else {                                   
               return null;
            }
        }

        public ArrayList<K> keySet() {          // store key in arraylist
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0 ; i<buckets.length ; i++) {
                LinkedList<Node> ll = buckets[i];
                for(Node node : ll) {
                    keys.add(node.key);
                }
            }

            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String args[]) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 5);

        ArrayList<String> keys = hm.keySet();
        for(String key : keys) {
            System.out.println(key);
        }
    }
}