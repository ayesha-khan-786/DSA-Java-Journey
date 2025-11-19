public class Interface {

    public static void main(String args[]) {
        Queen q = new Queen();
        q.moves();

        Bear b = new Bear();
        b.lunch();
        b.dinner();
    }
}

// Multiple Inheritance 
interface Herbivore {
    void lunch();
}

interface Carnivore {
    void dinner();
}

class Bear implements Herbivore, Carnivore {
      public void lunch() {
        System.out.println("he eats bamboo");
      }

       public void dinner() {
        System.out.println("he also eats meat");
      }
}

//

interface ChessPlayer {    // blueprint
    void moves();      // by default it is public, abstract
}

class Queen implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, right, left, diagonal(in all directions)");
    }
}

class Rook implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, right, left");
    }
}

class King implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, right, left, diagonal(by 1 step)");
    }
}