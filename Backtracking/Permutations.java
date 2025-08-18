public class Permutations {

    public static void findPermutation(String str, String ans) {
        // BAse Cace
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }
 
        // Recursion
        for(int i=0 ; i<str.length() ; i++) {
            char curr = str.charAt(i);
            // Remove i i.e curr =ex : "abcde" = "ab" + "de"
            String NewStr = str.substring(0, i) + str.substring(i+1);

            findPermutation(NewStr, ans+curr);
        }
    }

    public static void main(String args[]) {
        String str = "abc";
        findPermutation(str, "");
    }
}