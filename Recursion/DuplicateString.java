public class DuplicateString {

    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        if(idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        //kaam
        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true) {
            //duplicate
            removeDuplicates(str, idx+1, newStr, map);
       
       // if false
        } else {
            map[currChar - 'a'] = true;   // currChar 1st time araha to true karke map me newStr me append kar dena h
            removeDuplicates(str, idx+1, newStr.append(currChar), map);
        }
    }

    public static void main(String args[]) {
        String str = "appnnacollege";
        removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
    }
}