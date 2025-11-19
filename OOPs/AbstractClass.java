public class AbstractClass {

    public static void main(String args[]) {
// Abstract class
/*         Horse h = new Horse();
        h.eat();
        h.walk();
        System.out.println(h.color);

        Chicken c = new Chicken();
        c.eat();
        c.walk();
        System.out.println(c.color);
        */

// Constructor = Animal -> Horse -> Mustang
       Mustang myHorse = new Mustang();       
    }
}

abstract class Animal {
   String color;          

   Animal() {            // constructor
    //color = "brown";
    System.out.println("Animal constructor called...");
   }
   
    void eat() {                     // non-abstract method
        System.out.println("animals eat");
    }

    abstract void walk();            //  abstract method 
}

class Horse extends Animal {

    Horse() {
        System.out.println("Horse constructor called...");
    }

    void changeColor() {
        color = "dark brown";
    }
    
    void walk() {
        System.out.println("walks on 4 legs");
    }
}

class Mustang extends Horse {
    Mustang() {
        System.out.println("Mustang constructor called...");
    }
}

class Chicken extends Animal {
     void changeColor() {
        color = "yellow";
    }

    void walk() {
        System.out.println("walks on 2 legs");
    }
}