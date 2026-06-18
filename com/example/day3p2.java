//package
package com.example;
//method overriding
class A {
    void greet() {
        System.out.println("Hello from class A");
    }
    //Access modifiers: public, private, protected, default
    public void display() {
        System.out.println("Displaying from class A");
    }
    protected void show() {
        System.out.println("Showing from class A");
    }
    private void print() {
        System.out.println("Printing from class A");
    }
}
class B extends A {
    void greet() {
        System.out.println("Hello from class B");
    } 
}
public class day3p2 {
    public static void main(String[] args) {
        A obj1 = new A();
        obj1.greet(); // Output: Hello from class A

        B obj2 = new B();
        obj2.greet(); // Output: Hello from class B

        A obj3 = new B();
        obj3.greet(); // Output: Hello from class B (runtime polymorphism)
    }  
}
