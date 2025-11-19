public class Inheritance {

    public static void main(String args[]) {

// Single level Inheritance     
    //  Fish shark = new Fish();   
    //   shark.eat();                // Fish extends Animal there4 property of Animal comes in Fish
    
// Multi level Inheritance
      Dog dobby = new Dog();
      dobby.eat();
      dobby.legs = 4;
      System.out.println(dobby.legs);
    }
}

// Base class
class Animal {
    String color;
   
    void eat() {
        System.out.println("eats");
    }

    void breathe() {
        System.out.println("breathes");
    }
}

class Mammal extends Animal {
    void walk() {
         System.out.println("walks");
    }
}

class Fish extends Animal {
    void swim() {
         System.out.println("swims");
    }
}

class Bird extends Animal {
    void fly() {
         System.out.println("flies");
    }
}


//    class Dog extends Mammal {
//    String breed;
//    }

// Derived class
//    class Fish extends Animal {
//          int fins;
//
//          void swim() {
//          System.out.println("swims in water");
//    }
// }          

