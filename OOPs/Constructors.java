public class Constructors {

    public static void main(String args[]) {
    
 /*   Student s1 = new Student("Aisha");        1. 
    System.out.println(s1.name);  */

    Student s1 = new Student();              // .2

    }
}

class Student {
    String name;
    int roll;

    // constructor 
 /*   Student(String name) {                     1. // parameterized 
       this.name = name;  
    }   */

   Student() {                                         // .2  // Non parameterized
    System.out.println("constructor is called...");
   }
}