// print the sum, difference & product of two complex number by creating a class named 'Complex' with separate methods for each operation whose real and imaginary parts are entered by user.

import java.util.*;

public class Assignment1 {

    public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

 // Input 1st complex number
    System.out.println("Enter real and imaginary part of first complex number : ");
    int r1 = sc.nextInt();
    int i1 = sc.nextInt();
    Complex c1 = new Complex(r1, i1);
    
// Input 2nd complex number
    System.out.println("Enter real and imaginary part of second complex number : ");
    int r2 = sc.nextInt();
    int i2 = sc.nextInt();
    Complex c2 = new Complex(r2, i2);

// Perform operations
    Complex sum = c1.add(c2);
    Complex diff = c1.subtract(c2);
    Complex prod = c1.multiply(c2);

// Output
    System.out.println("Sum :");
    sum.print();

    System.out.println("Difference :");
    diff.print();

    System.out.println("Product :");
    prod.print();

    sc.close();
    }
}

class Complex {
    int real, imag;

// constructor
    Complex(int r, int i) {
        real = r;
        imag = i;
    }

// Method to add two complex numbers
    Complex add(Complex c) {
        return new Complex(this.real + c.real , this.imag + c.imag); // this = c1 & c = c2 bcoz above c1 is calling c2 i.e c1.add(c2)
    }

// Method to subtract two complex numbers
    Complex subtract(Complex c) {
        return new Complex(this.real - c.real , this.imag - c.imag);
    }

// Method to multiply two complex numbers
    Complex multiply(Complex c) {
        int r = this.real * c.real - this.imag * c.imag;
        int i = this.real * c.imag + this.imag * c.real;
        return new Complex(r, i);
    }

// Method to print a complex number
    void print() {
        if (imag >= 0) {
            System.out.println(real + "+" + imag + "i");
        } else {
            System.out.println(real + "-" + (-imag) + "i");
        }
    }

}
