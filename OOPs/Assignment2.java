 // predict Output
 
 public class Assignment2 { 
  
   public static void main(String[]wheels) 
    {
        final Car car = new ElectricCar();
        System.out.print(car.drive());
    }
}


class Automobile {
    private String drive() {
        return"Driving vehicle";
    }
 }
class Car extends Automobile {
    protected String drive() {
        return"Driving car";
     }
 }
 public class ElectricCar extends Car {
   
    public final String drive() {
        return"Driving electric car";
    }
 }
    
 