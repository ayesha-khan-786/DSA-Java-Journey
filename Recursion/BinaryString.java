public class BinaryString {

    public static void printBinaryStrings(int n, int lastPlace, String str) {
        // base case
        if(n == 0){
            System.out.println(str);
            return;
        }

//kaam
    /*    // nth seat pr kisko bithana h
        if(lastPlace == 0) {
            // sit 0 on chair n
            printBinaryStrings(n-1 , 0, str+"0");
            printBinaryStrings(n-1 , 1, str+"1");
        } else {
            // if lastplace pr 1 hai to sirf 0 ko bithana h
             printBinaryStrings(n-1 , 0, str+"0");  
        }       */ 

       // simple n short code

       // har br 0 ko bithana hi hai
        printBinaryStrings(n-1 , 0, str+"0");  
      
        if(lastPlace == 0) {
            // pr lastpalce pr agr 0 hai to 1 ko b bitha dungi
             printBinaryStrings(n-1 , 1, str+"1");
        }
    }

    public static void main(String args[]) {
        printBinaryStrings(3, 0, "");

    }
}