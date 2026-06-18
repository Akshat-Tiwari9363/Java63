//opps polymorphism
class A {
    //final
    final int MAX_VALUE = 100;
    //final method
    final void display() {
        System.out.println("This is a final method in class A");
    }
    int add(int a, int b) {
        return a + b;
    }
    double add(double a, double b) {
        return a + b;
    }
    int add(int a, int b, int c) {
        return a + b + c;
    }

    //inner class
    class Inner {
        void show() {
            System.out.println("This is an inner class in class A");
        }
    }

}

//final class
final class C {
    void show() {
        System.out.println("This is a final class C");
    }
}

//abstract class
abstract class D {
    abstract void print();
}

class B extends A {
    int add(int a, int b) {
        return a + b + 10; // Overriding method
    }
    double add(double a, double b) {
        return a + b + 10.0; // Overriding method
    }
}

class E extends D {
    void print() {
        System.out.println("This is an abstract method implementation in class E");
    }
}

class Laptop {
    int price;
    String brand;
    
    public Laptop(int price, String brand) {
        this.price = price;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Laptop [price=" + price + ", brand=" + brand + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + price;
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Laptop other = (Laptop) obj;
        if (price != other.price)
            return false;
        if (brand == null) {
            if (other.brand != null)
                return false;
        } else if (!brand.equals(other.brand))
            return false;
        return true;
    }
    
    
}

public class day4 {
    public static void main(String[] args) {
        A obj1 = new A();
        System.out.println("Sum of 2 integers: " + obj1.add(5, 10)); // Output: 15
        System.out.println("Sum of 2 doubles: " + obj1.add(5.5, 10.5)); // Output: 16.0
        System.out.println("Sum of 3 integers: " + obj1.add(5, 10, 15)); // Output: 30

        B obj2 = new B();
        System.out.println("Sum of 2 integers (overridden): " + obj2.add(5, 10)); // Output: 25
        System.out.println("Sum of 2 doubles (overridden): " + obj2.add(5.5, 10.5)); // Output: 26.0

        //dynamic method dispatch
        A obj3 = new B();
        System.out.println("Sum of 2 integers (dynamic dispatch): " + obj3.add(5, 10)); // Output: 25

        Laptop laptop1 = new Laptop(1000, "Dell");
        Laptop laptop2 = new Laptop(1000, "Dell");
        System.out.println("Laptop 1: " + laptop1);
        System.out.println("Laptop 2: " + laptop2);
        System.out.println("Are they equal? " + laptop1.equals(laptop2));

        //Casting
        A obj4 = new B(); // Upcasting
        B obj5 = (B) obj4; // Downcasting
        obj5.display(); // Output: This is a B class

        //Wapper classes
        Integer num1 = 10; // Autoboxing
        int num2 = num1; // Unboxing
        System.out.println("Autoboxing: " + num1);
        System.out.println("Unboxing: " + num2);
        System.out.println("Integer value: " + Integer.valueOf(10));
        System.out.println("Integer parse: " + Integer.parseInt("10"));

        E obj6 = new E();
        obj6.print(); // Output: This is an abstract method implementation in class E

        A.Inner innerObj = new A().new Inner();
        innerObj.show(); // Output: This is an inner class in class A

    }
}
