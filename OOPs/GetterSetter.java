public class ClassObject {
    
    public static void main(String args[]) {
        Pen p1 = new Pen();   // created a pen object called p1
        p1.setColor("Pink");
        System.out.println(p1.getColor());

        p1.setTip(5);
        System.out.println(p1.getTip());

        p1.setColor("Yellow");
        System.out.println(p1.getColor());
    }
}

// class i.e pen blueprint

class Pen {
    private String color;
    private int tip;

// Getter
    String getColor() {
        return this.color;   // this = current object
    }

    int getTip() {
        return this.tip;
    }

// Setter
    void setColor(String newColor) {
        color = newColor;
    }

    void setTip(int newTip) {
        tip = newTip;
    }
}

