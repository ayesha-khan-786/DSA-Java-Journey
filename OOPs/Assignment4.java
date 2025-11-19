// Predict output

public class Assignment4 {

    public static void main(String args[]) {
       
       new BlueCar();
    }
}

abstract class Car {
    static {        // 1st output is always static
        System.out.print("1");
    }
    public Car(String name) {
        super();
        System.out.print("2");
    }
     {
        System.out.print("3");
    }
    }
    
    public class BlueCar extends Car {
        {
            System.out.print("4");
        }
        public BlueCar() {
            super("blue");
            System.out.print("5");
        }
    } 

