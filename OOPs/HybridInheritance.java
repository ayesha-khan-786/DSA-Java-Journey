public class HybridInheritance {

    public static void main(String args[]) {
      
      Fish f1 = new Fish();
       f1.eat();

       Bird b1 = new Bird();
       b1.eat();

       Mammal m1 = new Mammal();
       m1.eat();

      Shark s1 = new Shark();
      s1.swim();

      Shark s2 = new Shark();
      s2.skinColor = "pink";
      System.out.println(s2.skinColor);

      Peacock p1 = new Peacock();
      p1.eat();

      Human h1 = new Human();
      h1.skinColor = "white";
      System.out.println(h1.skinColor);
    }
}

class Animal {
    String skinColor;

    void eat() {
        System.out.println("eats");
    }
}

class Fish extends Animal {
    void swim() {
        System.out.println("swims");
    }
}

class Bird extends Animal {
    void fly() {
        System.out.println("fly");
    }
} 

class Mammal extends Animal {
    void walk() {
        System.out.println("walk");
    }
} 

class Shark extends Fish {
     void bite() {
        System.out.println("bite");
    }
}

class Peacock extends Bird {
     void dance() {
        System.out.println("dance");
    }
}

class Human extends Mammal {
     void work() {
        System.out.println("work");
    }
}
