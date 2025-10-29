import java.util.*;

public class GetIthBit {

   // get ith bit

    public static int getIthBit(int n, int i) {
       int bitMask =  1<<i;      // i in binary is 0001 (usko left shift karna h by i)
       
       if((n & bitMask) == 0) {  // bitmask & to check ith bit is 0 or 1
         return 0;
       } else {
         return 1;
       }
   }

   // set i th bit

   public static int setIthBit(int n, int i) {
      int bitMask = 1 << i;

      return n | bitMask;
   }

   // clear ith bit

     public static int clearIthBit(int n, int i) {
      int bitMask =  ~(1 << i);
       return n & bitMask;
      
   }

   // update ith Bit

    public static int updateIthBit(int n, int i, int newBit) {
     //    if (newBit == 0) {
     //       return clearIthBit(n , i);
     //    } else {
     //       return setIthBit(n , i);
     //    }
     
       n = clearIthBit(n , i);
       int BitMask = newBit << i;
       return n | BitMask;
 }

     public static int clearIBits(int n, int i) {
      int bitMask = (~0)<<i;
      return n & bitMask;
     }

    public static void main(String args[]) {
      // System.out.println(getIthBit( 10 , 2 ));

      // System.out.println(setIthBit( 10 , 2 ));

      // System.out.println(clearIthBit( 10 , 1 ));

      // System.out.println(updateIthBit( 10 , 2, 1 ));

      System.out.println(clearIBits( 15 , 2 ));
   
    }
  }
